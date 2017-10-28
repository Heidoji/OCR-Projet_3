package fr.ocr.mode;

import fr.ocr.configuration.Configuration;
import fr.ocr.jeu.Jeu;
import fr.ocr.jeu.MastermindJeu;
import fr.ocr.jeu.RechercheJeu;
import fr.ocr.joueur.HumainJoueur;
import fr.ocr.joueur.Joueur;
import fr.ocr.joueur.OrdinateurJoueur;

public abstract class Mode {
	protected Configuration configuration = new Configuration();
	public Jeu jeu;
	protected Joueur player1;
	protected Joueur player2;
	protected int essai;
	protected int chiffre;
	protected int couleur;
	protected boolean modDev;
	
	public Mode () {
		this.player1 = new HumainJoueur();
		this.player2 = new OrdinateurJoueur();
		
		this.essai = configuration.getEssai();
		this.chiffre = configuration.getChiffre();
		this.couleur = configuration.getCouleur();
		this.modDev = configuration.getModDev();
		
		if (configuration.getJeu() == 'M') {
			this.jeu = new MastermindJeu();
		}
		else {
			this.jeu = new RechercheJeu();
		}
	}
	
	//Assesseur
	public int getEssai() {
		return this.essai;
	}
	
	public int getChiffre() {
		return this.chiffre;
	}
	public int getCouleur() {
		return this.couleur;
	}
	public boolean getModDev() {
		return this.modDev;
	}
	
	//Mutateur
	public void getEssai(int pEssai) {
		this.essai = pEssai;
	}
	
	public void getChiffre(int pChiffre) {
		this.chiffre = pChiffre;
	}
	
	public void getCouleur(int pCouleur) {
		this.couleur = pCouleur;
	}
	
	public void getModDev(boolean pModDev) {
		this.modDev = pModDev;
	}
	
	//Autre méthode
	public void sequenceJeu() {
		this.player1.choisirChiffreSecret();
		
		//if (this.getModDev()) {
			this.commentDev();
		//}
		
		while (!(this.jeu.getGagne(this.player2.getChiffreJoueur(), this.player1.getChiffreSecret()) 
				|| this.jeu.getNbEssai() >= this.essai)) {
			this.jeu.setNbEssai();
			this.jeu.getComparer(this.player2.trouverChiffreSecret(), this.player1.getChiffreSecret());
		}
		
		if (this.jeu.getGagne()) {
			this.jeu.getGagner();
		}
		else {
			System.out.println("Vous avez perdu");
		}
			
	}
	
	protected void commentDev() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Mode Developpeur activé");
		System.out.println("-----------------------");
		System.out.println("");
		System.out.println("Le chiffre secret est " + this.player1.getChiffreSecret());
		System.out.println("Le chiffre secret est " + this.player2.getChiffreSecret());
		System.out.println("");
		System.out.println("Le chiffre joueur est " + this.player1.getChiffreJoueur());
		System.out.println("Le chiffre joueur est " + this.player2.getChiffreJoueur());
		System.out.println("");
	}
}
