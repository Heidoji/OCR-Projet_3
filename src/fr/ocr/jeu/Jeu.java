package fr.ocr.jeu;

import fr.ocr.configuration.Configuration;
import fr.ocr.joueur.HumainJoueur;
import fr.ocr.joueur.OrdinateurJoueur;
import fr.ocr.mode.Mode;

/**
 * <b>Jeu est la classe regissant le jeu en fonction du type de jeu et du mode de jeu</b>
 * <p>
 * Il fonctionne avec des interfaces g�rant :
 * </p>
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>d'acceder � la configuration du jeu</li>
 * <li>de quitter le programme</li>
 * </ul>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public abstract class Jeu {
	/**
	 * <b>Boolean indiquant si la partie est gagn�e ou pas</b>
	 *
	 * @see Jeu#Jeu()
	 * @see Jeu#getGagne()
	 * @see Jeu#setGagne(boolean)
	 *
	 * @since 0.2
	 */	
	protected boolean gagne;
	
	/**
	 * <b>Integer contenant le nombre d'essai effectu� pour trouver le chiffre secret</b>
	 *
	 * @see Jeu#Jeu()
	 * @see Jeu#getNbEssai()
	 * @see Jeu#setNbEssai()
	 * @see Jeu#setNbEssai(int)
	 * @see Jeu#getGagner()
	 *
	 * @since 0.2
	 */
	protected int nbEssai;
	
	/**
	 * <b>Objet contenant les informations la m�thode de comparaison en fonction du jeu</b>
	 *
	 * @see Jeu#getComparer(int, int)
	 *
	 * @since 0.2
	 */	
	protected Comparer comparer;
	
	//Constructeur
	
	/**
	 * <b>Constructeur Jeu.</b>
	 * <p>
	 * Initialise le jeu avec :
	 * </p>
	 * <ul>
	 * <li>Un nombre d'essai � z�ro</li>
	 * <li>le boolean de victoire (gagne) � false</li>
	 * </ul>
	 *
	 * @since 0.2
	 */
	public Jeu () {
		this.gagne = false;
		this.nbEssai = 0;
	}

	//Assesseurs
	/**
	 * <b>Retourne le boolean de victoire.</b> 
	 *
	 * @return le boolean de victoire (true si le chiffre secret est trouv�)
	 *
	 * @since 0.2
	 */
	public boolean getGagne() {
		return this.gagne;
	}
	
	/**
	 * <b>Retourne le boolean de victoire.</b>  
	 * 
	 * @see Mode#sequenceJeu()
	 *
	 * @param cChiffreJoueur
	 * 		Le nombre donn� par le joueur
	 * 
	 * @param cChiffreSecret
	 * 		Le nombre secret � d�couvrir 
	 *
	 * @return le boolean de victoire (true si le chiffre secret est trouv�)
	 *
	 * @since 0.2
	 */
	public boolean getGagne(int cChiffreJoueur, int cChiffreSecret) {
		if (cChiffreJoueur == cChiffreSecret) {
			this.setGagne(true);
		}
		
		return this.gagne;
	}
	
	/**
	 * <b>Retourne le nombre d'essai effectu�</b>  
	 * 
	 * @see Jeu#getGagner()
	 * @see Mode#sequenceJeu()
	 *
	 * @return le nombre d'essai effectu� pour d�couvrir le nombre secret
	 *
	 * @since 0.2
	 */
	public int getNbEssai() {
		return this.nbEssai;
	}
	
	/**
	 * <b>Retourne un String contenant le resultat de la comparaison en fonction du jeu selectionn�.</b>  
	 * 
	 * @see Mode#sequenceJeu()
	 *
	 * @param cChiffreJoueur
	 * 		Le nombre donn� par le joueur
	 * 
	 * @param cChiffreSecret
	 * 		Le nombre secret � d�couvrir 
	 *
	 * @return un String contenant le resultat de la comparaison
	 *
	 * @since 0.2
	 */
	public String getComparer(int cChiffreJoueur, int cChiffreSecret) {
		return this.comparer.comparerChiffre(cChiffreJoueur, cChiffreSecret);
	}

	//Mutateurs
	
	/**
	 * <b>Permet de modifier le bool�en inidiquant la victoire.</b>
	 * 
	 * @param pGagner
	 * 		La nouvelle valeur pour le bool�en
	 * 
	 * @since 0.2
	 */
	public void setGagne(boolean pGagner) {
		this.gagne = pGagner;
	}
	
	/**
	 * <b>Incremente le nombre d'essai de 1 pour suivre le nombre de coups jou�</b>
	 * 
	 * @see Mode#sequenceJeu()
	 * 
	 * @since 0.2
	 */
	public void setNbEssai() {
		this.nbEssai++;
	}
	
	/**
	 * <b>Permet de modifier le nombre de coups jou�</b>
	 * 
	 * @param pNbEssai
	 * 		La nouvelle valeur pour le nombre d'essai
	 * 
	 * @since 0.2
	 */
	public void setNbEssai(int pNbEssai) {
		this.nbEssai = pNbEssai;
	}
	
	//Autre m�thodes
	/**
	 * <b>Affiche � la console le message de victoire avec le nombre de coups jou�s</b>
	 * 
	 * @see Mode#sequenceJeu()
	 * 
	 * @since 0.2
	 */
	public void getGagner() {
		System.out.println("");
		System.out.println("**********************************");
		System.out.println("*           VICTOIRE             *");
		System.out.println("**********************************");
		System.out.println("");
		System.out.println("Vous avez gagner en " + this.getNbEssai() + " coups");
		System.out.println("");
	}
}
