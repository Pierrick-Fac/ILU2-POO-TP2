package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomClient) {
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}
	
	public Gaulois[] trouverVendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		int quantiteAchete = -1;
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null && quantite >= 0) {
			quantiteAchete = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
		}
		return quantiteAchete;
	}
}
