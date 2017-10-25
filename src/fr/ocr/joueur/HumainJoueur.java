package fr.ocr.joueur;

import java.util.Scanner;

public class HumainJoueur implements Joueur {
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
		Scanner sc = new Scanner(System.in);
		System.out.println("");
	    System.out.println("Choississez votre chiffre Secret : ");
	    this.setChiffreSecret(Integer.parseInt(sc.nextLine()));
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
