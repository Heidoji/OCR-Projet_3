package fr.ocr.joueur;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;

public class HumainJoueur implements Joueur {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @ since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(HumainJoueur.class);
	
	/**
     * <b>Variable contenant l'objet Configuration.</b>
	 * <p>
	 * Il permet de memoriser les preferences de l'utilisateur
	 * </p>
	 * 
	 * @see HumainJoueur#afficherTexte()
	 * @see HumainJoueur#verifierNombre(int)
	 *
	 * @since 0.2
	*/
	private Configuration configuration = new Configuration();
	
	/**
     * <b>Variable contenant le chiffreSecret du joueur Humain.</b>
	 * <p>
	 * Il est entre par l'utilisateur
	 * </p>
	 * 
	 * @see HumainJoueur#getChiffreSecret()
	 * @see HumainJoueur#setChiffreSecret(int)
	 *
	 * @since 0.2
	*/
	private int chiffreSecret;
	
	/**
     * <b>Variable contenant le chiffreJoueur du joueur Humain.</b>
	 * <p>
	 * Il est entre par l'utilisateur
	 * </p>
	 * 
	 * @see HumainJoueur#getChiffreJoueur()
	 * @see HumainJoueur#setChiffreJoueur(int)
	 *
	 * @since 0.2
	*/
	private int chiffreJoueur;
	
	//Assesseurs
	
	/**
	 * <b>Retourne le nombre secret choisi par le joueur Humain.</b> 
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @return le nombre secret choisi par le joueur Humain.
	 *
	 * @since 0.2
	 */
	public int getChiffreSecret() {
		return this.chiffreSecret;
	}
	
	/**
	 * <b>Retourne le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.</b> 
	 * 
	 * @see HumainJoueur#trouverChiffreSecret()
	 *
	 * @return le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public int getChiffreJoueur() {
		return this.chiffreJoueur;
	}
	
	//Mutateurs
	
	/**
	 * <b>Met a jour le nombre secret choisi par le joueur Humain.</b>
	 *
	 * @see HumainJoueur#choisirChiffreSecret() 
	 * 
	 * @param la nouvelle valeur du nombre nombre secret choisi par le joueur Humain.
	 *
	 * @since 0.2
	 */
	public void setChiffreSecret(int pChiffreSecret) {
		this.chiffreSecret = pChiffreSecret;
	}
	
	/**
	 * <b>Met a jour le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.</b>
	 *
	 * @see HumainJoueur#trouverChiffreSecret() 
	 * 
	 * @param la nouvelle valeur du nombre choisi par le joueur Humain pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public void setChiffreJoueur(int pChiffreJoueur) {
		this.chiffreJoueur = pChiffreJoueur;
	}
	
	//Autres Méthodes
	
	/**
	 * <b>Methode qui demande au joueur Humain de rentrer un chiffre secret</b>
	 *
	 * @see HumainJoueur#afficherTexte()
	 * @see HumainJoueur#setChiffreSecret(int)
	 * @see HumainJoueur#verifierNombre(int)
	 * @see HumainJoueur#getChiffreSecret()
	 * 
	 * @since 0.2
	 */
	public int choisirChiffreSecret() {
		logger.info("Entre dans HumainJoueur.choisirChiffreSecret()");
		Scanner sc = new Scanner(System.in);
		do {
			this.afficherTexte();
			System.out.println("Choississez votre chiffre Secret : ");
			this.setChiffreSecret(Integer.parseInt(sc.nextLine()));
		} while (!(this.verifierNombre(this.getChiffreSecret())));
			
		logger.debug("Chiffre Secret choisi par le joueur : " + this.getChiffreSecret());
		return this.getChiffreSecret();
	}
	
	/**
	 * <b>Methode qui demande au joueur Humain de rentrer un nombre pour decouvrir le nombre secret</b>
	 *
	 * @see HumainJoueur#setChiffreJoueur(int)
	 * @see HumainJoueur#verifierNombre(int)
	 * @see HumainJoueur#getChiffreSecret()
	 * 
	 * @since 0.2
	 */
	public int trouverChiffreSecret() {
		logger.info("Entre dans HumainJoueur.trouverChiffreSecret()");
		Scanner sc = new Scanner(System.in);
		
		do {
			this.afficherTexte();
			System.out.println("Proposez un chiffre : ");
			this.setChiffreJoueur(Integer.parseInt(sc.nextLine()));
		} while (!(this.verifierNombre(this.getChiffreJoueur())));
		
		logger.debug("Chiffre Joueur choisi par le joueur : " + this.getChiffreJoueur());
		return this.getChiffreJoueur();
	}
	
	/**
	 * <b>Méthode affichant le texte pour la proposition du nombre Joueur</b>
	 * <p>
	 * Cette méthode a pour but :
	 * <ul>
	 * <li>d'afficher les règles à respecter dans la composition du nombre.</li>
	 * <li>de configurer le nombre de couleur pour le jeu Mastermind</li> 
	 * </ul>
	 * </p>
	 * 
	 * @see configuration#getCouleur()
	 * @see configuration#getJeu()
	 * @see configuration.getChiffre()
	 * @see configuration.getEssai()
	 * 
	 * @version 0.2
	 */
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
	
	/**
	 * <b>Méthode vérifiant si la proposition du nombre Joueur respecte les règles définies</b>
	 * <p>
	 * Cette méthode vérifie :
	 * <ul>
	 * <li>si le nombre n'est pas négatif.</li>
	 * <li>si la longueur du nombre est correct</li> 
	 * <li>si la plage des chiffres utilisés est respecté</li> 
	 * </ul>
	 * </p>
	 * 
	 * @see HumainJoueur#ecrireTexte(String)
	 * @see configuration#getCouleur()
	 * @see configuration#getJeu()
	 * @see configuration.getChiffre()
	 * 
	 * @version 0.2
	 */
	private boolean verifierNombre(int cNombre) {
	    logger.info("Verification du nombre rentre");		
		int couleur = configuration.getCouleur();
		
		if (configuration.getJeu() == 'R') {
			couleur = 10;
		}
		
		if (cNombre < 0) {
			this.ecrireTexte("Nombre saisi négatif");
			logger.error("Nombre saisi négatif");
			return false;
		}
		
		String stringNombre = String.valueOf(cNombre);
		if (stringNombre.length() != configuration.getChiffre()) {
			this.ecrireTexte("Nombre saisi de longueur incorrect");
			logger.error("Nombre saisi de longueur incorrect");
			return false;
		}

		for (int i = 0; i < configuration.getChiffre(); i++) {
			String carac = "" + stringNombre.charAt(i);
			int chiffre = Integer.parseInt(carac);
			if (chiffre > couleur) {
				this.ecrireTexte("Chiffre utilisé incorrect (hors échelle)");
				logger.error("Chiffre utilisé incorrect (hors échelle)");
				return false;
			}
		}
		
		logger.info("Verification faite et correcte");		
		return true;
	}
	
	/**
	 * <b>Méthode qui ecris un texte en l'espacant avec des sauts de ligne</b>
	 * 
	 * @param cTexte
	 * 		Texte a afficher sur l'écran
	 * 
	 * @since version 0.2
	 */
	private void ecrireTexte(String cTexte) {
		System.out.println("");
		System.out.println(cTexte);
		System.out.println("");
	}
	
	
}
