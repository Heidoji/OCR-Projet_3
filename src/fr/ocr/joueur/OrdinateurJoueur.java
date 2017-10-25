package fr.ocr.joueur;

import java.util.Random;
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
		Random rand = new Random();
		this.setChiffreSecret(rand.nextInt((int) Math.pow(10, configuration.getChiffre())));
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
