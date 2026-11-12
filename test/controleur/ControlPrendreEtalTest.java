package controleur;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private ControlPrendreEtal cpe;

	@BeforeEach
	void setUp() {
		Village village = new Village("Village test", 10, 1);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlVerifierIdentite cvi = new ControlVerifierIdentite(village);
		cpe = new ControlPrendreEtal(cvi, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(cpe);
	}

	@Test
	void testResteEtals() {
		assertTrue(cpe.resteEtals());
		cpe.prendreEtal("Abraracourcix", "test", 2);
		assertFalse(cpe.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		assertEquals(cpe.prendreEtal("Test", "fleur", 2), 0);
		assertNotEquals(cpe.prendreEtal("Abraracourcix", "fleur", 3), 0);
		assertEquals(cpe.prendreEtal("Abraracourcix", "pot", 2), 0);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(cpe.verifierIdentite("Abraracourcix"));
		assertFalse(cpe.verifierIdentite("Not"));
	}

}
