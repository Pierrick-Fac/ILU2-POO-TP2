package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlAcheterProduit cap;


	@BeforeEach
	void setUp() {
		Village village = new Village("Village test", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlEmmenager ce = new ControlEmmenager(village);
		ce.ajouterGaulois("Bonemine", 10);
		ControlTrouverEtalVendeur ctev = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite cvi = new ControlVerifierIdentite(village);
		cap = new ControlAcheterProduit(cvi, ctev, village);
		ControlPrendreEtal cpe = new ControlPrendreEtal(cvi, village);
		cpe.prendreEtal("Abraracourcix", "Fleurs", 5);
		cpe.prendreEtal("Bonemine", "gros caillou", 0);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(cap);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(cap.verifierIdentite("Abraracourcix"));
		assertFalse(cap.verifierIdentite("Not"));
	}

	@Test
	void testTrouverVendeurProduit() {
		assertNull(cap.trouverVendeurProduit("Caillou"));
		assertNotNull(cap.trouverVendeurProduit("Fleurs"));
	}

	@Test
	void testAcheterProduit() {
		assertEquals(cap.acheterProduit("Test", 10), -1);
		assertEquals(cap.acheterProduit("Abraracourcix", -2), -1);
		assertEquals(cap.acheterProduit("Bonemine", 0), 0);
		assertEquals(cap.acheterProduit("Abraracourcix", 10), 5);
	}

}
