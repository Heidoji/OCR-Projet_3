package fr.ocr.joueur;

import java.util.Scanner;

import fr.ocr.configuration.Configuration;

public class OrdinateurJoueur implements Joueur {
	private Configuration configuration = new Configuration();
	private int chiffreSecret;
	private int chiffreJoueur;
	
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
		int nombre = 0; 
		int couleur = configuration.getCouleur();
		if (configuration.getJeu() == 'R') {
			couleur = 10;
		}
		
		do {
			for (int i = 0; i < configuration.getChiffre(); i++) {
				nombre = nombre * 10 + (int) (Math.random() * couleur);
			}
		} while (false);
			
		this.setChiffreSecret(nombre);
		return this.getChiffreSecret();
	}
	
	public int trouverChiffreSecret() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
	    System.out.println("Proposez un chiffre : ");
	    this.setChiffreJoueur(Integer.parseInt(sc.nextLine()));
		return this.getChiffreJoueur();
	}
}
