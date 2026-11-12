package controleur;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

import org.junit.jupiter.api.BeforeEach;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite cvi;

	@BeforeEach
	public void setUp() {
		Village village = new Village("Village test", 10, 3);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		cvi = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(cvi, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(cvi.verifierIdentite("Abraracourcix"));
		assertFalse(cvi.verifierIdentite("Not"));
	}

}
