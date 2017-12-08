package fr.ocr.joueur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.joueur.RechercheIA;

/**
 * <b>La classe OrdinateurJoueur permet de gerer les décision de l'ordinateur</b>
 * <p>
 * Elle gère :
 * </p>
 * <ul>
 * <li>Le choix du nombre secret par l'ordinateur</li>
 * <li>La proposition d'un nombre pour la découverte du nombre secret</li>
 * <li>La configuration de l'IA par rapport au jeu joué</li>
 * </ul>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class OrdinateurJoueur implements Joueur {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(OrdinateurJoueur.class);
	
	/**
     * <b>Variable contenant l'objet Configuration.</b>
	 * <p>
	 * Il permet de memoriser les preferences de l'utilisateur
	 * </p>
	 * 
	 * @see OrdinateurJoueur#choisirChiffreSecret()
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
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
	 * @see OrdinateurJoueur#setChiffreSecret(String)
	 *
	 * @since 0.2
	*/
	private String chiffreSecret;
	
	/**
     * <b>Variable contenant le chiffreJoueur du joueur Ordinateur.</b>
	 * <p>
	 * Il est determine par l'IA.
	 * </p>
	 * 
	 * @see OrdinateurJoueur#getChiffreJoueur()
	 * @see OrdinateurJoueur#setChiffreJoueur(String)
	 *
	 * @since 0.2
	*/
	private String chiffreJoueur;
	
	/**
	 * <b>Variable contenant le nombre de couleur possible pour former la combinaison secrète
	 * dans le jeu Mastermind</b>
	 * 
	 * <p>
	 * La valeur varie entre 4 et 10
	 * </p>
	 *
	 * @see OrdinateurJoueur#getCouleur()
	 * @see OrdinateurJoueur#setCouleur(String)
	 * @see OrdinateurJoueur#choisirChiffreSecret()
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
	 *
	 * @since 0.4.1
	 */	
	 private int couleur;
	 
	/**
	 * <b>Variable contenant l'objet IA pour la gestion de IA de l'ordinateur</b>
	 * 
	 * <p>
	 * L'objet contient soit l'IA pour le jeu Recherche ou Mastermind
	 * </p>
	 *
	 * @see OrdinateurJoueur#setIA()
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
	 *
	 * @since 0.4.1
	 */	
	 private IA ia;
	
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
	public String getChiffreSecret() {
		return this.chiffreSecret;
	}
	
	/**
	 * <b>Retourne le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.</b> 
	 * 
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
	 *
	 * @return le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public String getChiffreJoueur() {
		return this.chiffreJoueur;
	}
	
	/**
	 * <b>Retourne le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind
	 *
	 * @since 0.4.1
	 */
	public int getCouleur() {
		return this.couleur;
	}
	
	//Mutateurs
	
	/**
	 * <b>Met a jour le nombre secret choisi par le joueur Ordinateur.</b>
	 *
	 * @see OrdinateurJoueur#choisirChiffreSecret() 
	 * 
	 * @param pChiffreSecret
	 * 		la nouvelle valeur du nombre nombre secret choisi par le joueur Ordinateur.
	 *
	 * @since 0.2
	 */
	public void setChiffreSecret(String pChiffreSecret) {
		this.chiffreSecret = pChiffreSecret;
	}
	
	/**
	 * <b>Met a jour le nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.</b>
	 *
	 * @see OrdinateurJoueur#trouverChiffreSecret(String) 
	 * 
	 * @param pChiffreJoueur
	 * 		la nouvelle valeur du nombre choisi par le joueur Ordinateur pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public void setChiffreJoueur(String pChiffreJoueur) {
		this.chiffreJoueur = pChiffreJoueur;
	}
	
	/**
	 * <b>Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind</b>
	 * 
	 * @param pCouleur
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.4.1
	 */
	public void setCouleur(int pCouleur) {	
		if (configuration.getJeu() == 'R') {
			this.couleur = 10;
		}
		else {
			this.couleur = pCouleur;
		}
	}
	
	/**
	 * <b>Selection de l'IA par rapport au jeu joué</b>
	 * 
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
	 * 
	 * @since 0.4.1
	 */
	public void setIA() {	
		if (configuration.getJeu() == 'R') {
			this.ia = new RechercheIA();
		}
		else {
			this.ia = new MastermindIA();
		}
	}
	
	//Autres Méthodes
	
	/**
	 * <b>Methode qui choisi aleatoirement un chiffre secret</b>
	 *
	 * @see OrdinateurJoueur#setChiffreSecret(String)
	 * @see OrdinateurJoueur#getChiffreSecret()
	 * @see Configuration#getCouleur()
	 * @see Configuration#getJeu()
	 * @see Configuration#getChiffre() 
	 * 
	 * @since 0.2
	 */
	public String choisirChiffreSecret() {
		logger.info("Entre dans OrdinateurJoueur.choisirChiffreSecret()");
		int nombre = 0; 
		int couleur;
		if (configuration.getJeu() == 'R') {
			couleur = 10;
		}
		else 
			couleur = configuration.getCouleur();
		
		for (int i = 0; i < configuration.getChiffre(); i++) {
			nombre = nombre * 10 + (int) (Math.random() * couleur);
		}
		
		String Stringnombre = String.valueOf(nombre);
		
		while (Stringnombre.length() < configuration.getChiffre()) {
			Stringnombre = "0" + Stringnombre;
        }
			
		this.setChiffreSecret(Stringnombre);
		logger.debug("Chiffre Secret choisi par l'ordinateur : " + this.getChiffreSecret());
		return this.getChiffreSecret();
	}
	
	/**
	 * <b>Methode calculant une solution et retourne un nombre pour decouvrir le nombre secret</b>
	 *
	 * TO BE DONE 
	 * 
	 * @since 0.4.1
	 */
	public String trouverChiffreSecret(String pResultat) {
		logger.info("Entre dans OrdinateurJoueur.trouverChiffreSecret()");
		//System.out.println("OrdinateurJoueur : " + this.getChiffreJoueur() + "," + this.getChiffreSecret());
		
		if (this.getChiffreJoueur() == "") {
			this.setIA();
		}
		
		this.setChiffreJoueur(this.ia.trouverChiffreSecret(pResultat));
		return this.getChiffreJoueur();
	}
}
