package fr.ocr.joueur;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;

public class OrdinateurJoueur implements Joueur {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @ since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(OrdinateurJoueur.class);
	
	/**
     * <b>Variable contenant l'objet Configuration.</b>
	 * <p>
	 * Il permet de memoriser les preferences de l'utilisateur
	 * </p>
	 * 
	 * @see OrdinateurJoueur#choisirChiffreSecret()
	 * @see OrdinateurJoueur#trouverChiffreSecret()
	 *
	 * @since 0.2
	*/
	private Configuration configuration = new Configuration();
	
	/**
     * <b>Variable contenant le chiffreSecret du joueur Ordinateur.</b>
	 * <p>
	 * Il est choisi aleatoirement par l'Ordinateur
	 * </p>
	 * 
	 * @see OrdinateurJoueur#getChiffreSecret()
	 * @see OrdinateurJoueur#setChiffreSecret(int)
	 *
	 * @since 0.2
	*/
	private int chiffreSecret;
	
	/**
     * <b>Variable contenant le chiffreJoueur du joueur Ordinateur.</b>
	 * <p>
	 * Il est determine par l'IA.
	 * </p>
	 * 
	 * @see OrdinateurJoueur#getChiffreJoueur()
	 * @see OrdinateurJoueur#setChiffreJoueur(int)
	 *
	 * @since 0.2
	*/
	private int chiffreJoueur;
	
	//Assesseurs
	
	/**
	 * <b>Retourne le nombre secret choisi par le joueur Ordinateur.</b> 
	 * 
	 * @see OrdinateurJoueur#choisirChiffreSecret()
	 *
	 * @return le nombre secret choisi par le joueur Ordinateur.
	 *
	 * @since 0.2
	 */
	public int getChiffreSecret() {
		return this.chiffreSecret;
	}
	
	/**
	 * <b>Retourne le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.</b> 
	 * 
	 * @see OrdinateurJoueur#trouverChiffreSecret()
	 *
	 * @return le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public int getChiffreJoueur() {
		return this.chiffreJoueur;
	}
	
	//Mutateurs
	
	/**
	 * <b>Met a jour le nombre secret choisi par le joueur Ordinateur.</b>
	 *
	 * @see OrdinateurJoueur#choisirChiffreSecret() 
	 * 
	 * @param la nouvelle valeur du nombre nombre secret choisi par le joueur Ordinateur.
	 *
	 * @since 0.2
	 */
	public void setChiffreSecret(int pChiffreSecret) {
		this.chiffreSecret = pChiffreSecret;
	}
	
	/**
	 * <b>Met a jour le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.</b>
	 *
	 * @see OrdinateurJoueur#trouverChiffreSecret() 
	 * 
	 * @param la nouvelle valeur du nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public void setChiffreJoueur(int pChiffreJoueur) {
		this.chiffreJoueur = pChiffreJoueur;
	}
	
	//Autres Méthodes
	
	/**
	 * <b>Methode qui choisi aleatoirement un chiffre secret</b>
	 *
	 * @see OrdinateurJoueur#setChiffreSecret(int)
	 * @see OrdinateurJoueur#getChiffreSecret()
	 * @see Configuration#getCouleur()
	 * @see Configuration#getJeu()
	 * @see Configuration#getChiffre() 
	 * 
	 * @since 0.2
	 */
	public int choisirChiffreSecret() {
		logger.info("Entre dans OrdinateurJoueur.choisirChiffreSecret()");
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
		logger.debug("Chiffre Secret choisi par l'ordinateur : " + this.getChiffreSecret());
		return this.getChiffreSecret();
	}
	
	/**
	 * <b>Methode calculant une solution et retourne un nombre pour decouvrir le nombre secret</b>
	 *
	 * TO BE DONE 
	 * 
	 * @since x.x
	 */
	public int trouverChiffreSecret() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
	    System.out.println("Proposez un chiffre : ");
	    this.setChiffreJoueur(Integer.parseInt(sc.nextLine()));
		return this.getChiffreJoueur();
	}
}
