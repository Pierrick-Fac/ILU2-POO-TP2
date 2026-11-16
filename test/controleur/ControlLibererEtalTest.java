package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlLibererEtal cle;
	private ControlPrendreEtal cpe;

	@BeforeEach
	void setUp() {
		Village village = new Village("Village test", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlTrouverEtalVendeur ctev = new ControlTrouverEtalVendeur(village);
		cle = new ControlLibererEtal(ctev);
		ControlVerifierIdentite cvi = new ControlVerifierIdentite(village);
		cpe = new ControlPrendreEtal(cvi, village);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(cle);
	}

	@Test
	void testIsVendeur() {
		assertFalse(cle.isVendeur("Test"));
		assertFalse(cle.isVendeur("Abraracourcix"));
		cpe.prendreEtal("Abraracourcix", "Fleurs", 5);
		assertTrue(cle.isVendeur("Abraracourcix"));
	}

	@Test
	void testLibererEtal() {
		assertNull(cle.libererEtal("Test"));
		assertNull(cle.libererEtal("Abraracourcix"));
		cpe.prendreEtal("Abraracourcix", "Fleurs", 5);
		String[] donnee = cle.libererEtal("Abraracourcix");
		assertNotNull(donnee);
		assertEquals(donnee[0], "true");
		assertEquals(donnee[1], "Abraracourcix");
		assertEquals(donnee[2], "Fleurs");
		assertEquals(donnee[3], "5");
		assertEquals(donnee[4], "0");
	}

}
