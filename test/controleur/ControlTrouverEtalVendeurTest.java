package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private ControlTrouverEtalVendeur ctev;
	private ControlPrendreEtal cpe;

	@BeforeEach
	void setUp() {
		Village village = new Village("Village test", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ctev = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite cvi = new ControlVerifierIdentite(village);
		cpe = new ControlPrendreEtal(cvi, village);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(ctev);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(ctev.trouverEtalVendeur("Test"));
		assertNull(ctev.trouverEtalVendeur("Abraracourcix"));
		cpe.prendreEtal("Abraracourcix", "Fleurs", 10);
		assertNotNull(ctev.trouverEtalVendeur("Abraracourcix"));
	}

}
