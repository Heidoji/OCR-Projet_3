package fr.ocr.joueur;

import java.util.Scanner;

import fr.ocr.configuration.Configuration;

public class HumainJoueur implements Joueur {
	private int chiffreSecret;
	private int chiffreJoueur;
	private Configuration configuration = new Configuration();
	
	//Assesseurs
	public int getChiffreSecret() {
		return this.chiffreSecret;
	}
	public int getChiffreJoueur() {
		return this.chiffreJoueur;
	}
	
	//Mutateurs
	public void setChiffreSecret(int pChiffreSecret) {
		this.chiffreSecret = pChiffreSecret;
	}
	public void setChiffreJoueur(int pChiffreJoueur) {
		this.chiffreJoueur = pChiffreJoueur;
	}
	
	//Autres Méthodes
	public int choisirChiffreSecret() {
		Scanner sc = new Scanner(System.in);
		do {
			this.afficherTexte();
			System.out.println("Choississez votre chiffre Secret : ");
			this.setChiffreSecret(Integer.parseInt(sc.nextLine()));
		} while (!(this.verifierNombre(this.getChiffreSecret())));
			
		return this.getChiffreSecret();
	}
	
	public int trouverChiffreSecret() {
		Scanner sc = new Scanner(System.in);
		
		do {
			this.afficherTexte();
			System.out.println("Proposez un chiffre : ");
			this.setChiffreJoueur(Integer.parseInt(sc.nextLine()));
		} while (!(this.verifierNombre(this.getChiffreJoueur())));
		
		return this.getChiffreJoueur();
	}
	
	private void afficherTexte() {
		int couleur = configuration.getCouleur();
		
		if (configuration.getJeu() == 'R') {
			couleur = 10;
		}
		
		System.out.println("Player 1 :");
		System.out.println("----------");
		System.out.println("");
		System.out.println("Le nombre doit comporter " + configuration.getChiffre() + " chiffres");
		System.out.println("Les chiffres autorisées sont : 0 à " + (couleur - 1));
		System.out.println("Vous avez " + configuration.getEssai() + " essais");
		System.out.println("");
	}
	
	private boolean verifierNombre(int cNombre) {	
		int couleur = configuration.getCouleur();
		
		if (configuration.getJeu() == 'R') {
			couleur = 10;
		}
		
		if (cNombre < 0) {
			this.ecrireTexte("Nombre négatif");
			return false;
		}
		
		String stringNombre = String.valueOf(cNombre);
		if (stringNombre.length() != configuration.getChiffre()) {
			this.ecrireTexte("Nombre de longueur incorrect");
			return false;
		}

		for (int i = 0; i < configuration.getChiffre(); i++) {
			String carac = "" + stringNombre.charAt(i);
			int chiffre = Integer.parseInt(carac);
			if (chiffre > couleur) {
				this.ecrireTexte("Chiffre utilisé incorrect (hors échelle)");
				return false;
			}
		}
		
		return true;
	}
	
	private void ecrireTexte(String cTexte) {
		System.out.println("");
		System.out.println(cTexte);
		System.out.println("");
	}
	
	
}
