package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager ce;
	
	@BeforeEach
	public void initialiserSituation() {
		Village village = new Village("Le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ce = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(ce, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		assertTrue(ce.isHabitant("Abraracourcix"));
		ce.ajouterGaulois("Bonemine", 10);
		assertTrue(ce.isHabitant("Bonemine"));
		ce.ajouterDruide("Panoramix", 2, 1, 3);
		assertTrue(ce.isHabitant("Panoramix"));
		assertFalse(ce.isHabitant("Not"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(ce.isHabitant("Panoramix"));
		ce.ajouterDruide("Panoramix", 2, 1, 3);
		assertTrue(ce.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(ce.isHabitant("Bonemine"));
		ce.ajouterGaulois("Bonemine", 10);
		assertTrue(ce.isHabitant("Bonemine"));
	}
	
	@Test
	void testAjouterBeaucoupGaulois() {
		for(int i = 0; i < 100; i++) {
			ce.ajouterGaulois("G" + i, 10);
		}
		for (int i = 0; i < 100; i++) {
			if (i < 10) {
				assertTrue(ce.isHabitant("G"+i));
			}
			else {
				assertFalse(ce.isHabitant("G"+i));
			}
		}
	}

}
