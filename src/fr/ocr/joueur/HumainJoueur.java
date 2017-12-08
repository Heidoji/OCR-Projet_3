package fr.ocr.joueur;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.exceptions.NombreEchelleException;
import fr.ocr.exceptions.NombreLongueurException;
import fr.ocr.exceptions.NombreNegatifException;

/**
 * <b>La classe HumainJoueur permet de gerer l'interface avec le joueur humain</b>
 * <p>
 * Elle gère :
 * </p>
 * <ul>
 * <li>Le choix du nombre secret par le joueur</li>
 * <li>La proposition d'un nombre pour la découverte du nombre secret</li>
 * <li>L'affichage des consignes de jeu</li>
 * <li>La vérification du nombre rentré</li>
 * </ul>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class HumainJoueur implements Joueur {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(HumainJoueur.class);
	
	/**
     * <b>Variable contenant l'objet Configuration.</b>
	 * <p>
	 * Il permet de memoriser les preferences de l'utilisateur
	 * </p>
	 * 
	 * @see HumainJoueur#afficherTexte()
	 * @see HumainJoueur#verifierNombre(String)
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
	 * @see HumainJoueur#setChiffreSecret(String)
	 *
	 * @since 0.2
	*/
	private String chiffreSecret;
	
	/**
     * <b>Variable contenant le chiffreJoueur du joueur Humain.</b>
	 * <p>
	 * Il est entre par l'utilisateur
	 * </p>
	 * 
	 * @see HumainJoueur#getChiffreJoueur()
	 * @see HumainJoueur#setChiffreJoueur(String)
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
	 * @see HumainJoueur#getCouleur()
	 * @see HumainJoueur#setCouleur(int)
	 * @see HumainJoueur#choisirChiffreSecret()
	 * @see HumainJoueur#trouverChiffreSecret(String)
	 *
	 * @since 0.4.1
	 */	
	 private int couleur;
	 
	
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
	public String getChiffreSecret() {
		return this.chiffreSecret;
	}
	
	/**
	 * <b>Retourne le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.</b> 
	 * 
	 * @see HumainJoueur#trouverChiffreSecret(String)
	 *
	 * @return le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.
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
	 * <b>Met a jour le nombre secret choisi par le joueur Humain.</b>
	 *
	 * @see HumainJoueur#choisirChiffreSecret() 
	 * 
	 * @param pChiffreSecret
	 * 		la nouvelle valeur du nombre nombre secret choisi par le joueur Humain.
	 *
	 * @since 0.2
	 */
	public void setChiffreSecret(String pChiffreSecret) {
		this.chiffreSecret = pChiffreSecret;
	}
	
	/**
	 * <b>Met a jour le nombre choisi par le joueur Humain pour decouvrir le Nombre secret.</b>
	 *
	 * @see HumainJoueur#trouverChiffreSecret(String) 
	 * 
	 * @param pChiffreJoueur
	 * 		la nouvelle valeur du nombre choisi par le joueur Humain pour decouvrir le Nombre secret.
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
	
	//Autres Méthodes
	
	/**
	 * <b>Methode qui demande au joueur Humain de rentrer un chiffre secret</b>
	 *
	 * @see HumainJoueur#afficherTexte()
	 * @see HumainJoueur#setChiffreSecret(String)
	 * @see HumainJoueur#verifierNombre(String)
	 * @see HumainJoueur#getChiffreSecret()
	 * 
	 * @since 0.2
	 */
	public String choisirChiffreSecret() {
		logger.info("Entre dans HumainJoueur.choisirChiffreSecret()");
		Scanner sc = new Scanner(System.in);
		boolean checkedNumber = false;
		
		do {
			this.afficherTexte();
			System.out.println("Choississez votre chiffre Secret : ");
			this.setChiffreSecret(sc.nextLine());
			try {
				checkedNumber = this.verifierNombre(this.getChiffreSecret());
			}
			catch (NombreNegatifException | NombreLongueurException | NombreEchelleException e) {
				System.out.println(e.getMessage());	
			}
			
		} while (!(checkedNumber));
			
		logger.info("Verification faite et correcte");
		logger.debug("Chiffre Secret choisi par le joueur : " + this.getChiffreSecret());
		return this.getChiffreSecret();
	}
	
	/**
	 * <b>Methode qui demande au joueur Humain de rentrer un nombre pour decouvrir le nombre secret</b>
	 *
	 * @see HumainJoueur#setChiffreJoueur(String)
	 * @see HumainJoueur#verifierNombre(String)
	 * @see HumainJoueur#getChiffreSecret()
	 * 
	 * @since 0.2
	 */
	public String trouverChiffreSecret(String pResultat) {
		logger.info("Entre dans HumainJoueur.trouverChiffreSecret()");
		boolean checkedNumber = false;
		Scanner sc = new Scanner(System.in);

		do {
			this.afficherTexte();
			System.out.println("Proposez un chiffre : ");
			this.setChiffreJoueur(sc.nextLine());
			
			try {
				checkedNumber = this.verifierNombre(this.getChiffreJoueur());
			}
			catch (NombreNegatifException | NombreLongueurException | NombreEchelleException e2) {
				System.out.println(e2.getMessage());	
			}
			
		} while (!(checkedNumber));
		
		logger.info("Verification faite et correcte");	
		logger.debug("Chiffre Joueur choisi par le joueur : " + this.getChiffreJoueur());
		return this.getChiffreJoueur();
	}
	
	/**
	 * <b>Méthode affichant le texte pour la proposition du nombre Joueur</b>
	 * <p>
	 * Cette méthode a pour but :
	 * </p>
	 * <ul>
	 * <li>d'afficher les règles à respecter dans la composition du nombre.</li>
	 * <li>de configurer le nombre de couleur pour le jeu Mastermind</li> 
	 * </ul>
	 * 
	 * @see Configuration#getCouleur()
	 * @see Configuration#getJeu()
	 * @see Configuration#getChiffre()
	 * @see Configuration#getEssai()
	 * 
	 * @version 0.2
	 */
	private void afficherTexte() {
		System.out.println("");
		System.out.println("Player 1 :");
		System.out.println("----------");
		System.out.println("");
		System.out.println("Le nombre doit comporter " + configuration.getChiffre() + " chiffres");
		System.out.println("Les chiffres autorisées sont : 0 à " + (this.getCouleur() - 1));
		System.out.println("Vous avez " + configuration.getEssai() + " essais");
		System.out.println("");
	}
	
	/**
	 * <b>Méthode vérifiant si la proposition du nombre Joueur respecte les règles définies</b>
	 * <p>
	 * Cette méthode vérifie :
	 * </p>
	 * <ul>
	 * <li>si le nombre n'est pas négatif.</li>
	 * <li>si la longueur du nombre est correct</li> 
	 * <li>si la plage des chiffres utilisés est respecté</li> 
	 * </ul>
	 * 
	 * @param cNombre
	 * 		Le nombre a vérifier
	 * 
	 * @throws NombreNegatifException
	 * 		Si le nombre est négatif
	 * @throws NombreLongueurException
	 * 		Si la longueur du nombre est incorrect
	 * @throws NombreEchelleException
	 * 		Si le nombre utilise des chiffres hors echelle
	 * 
	 * @see HumainJoueur#ecrireTexte(String)
	 * @see Configuration#getCouleur()
	 * @see Configuration#getJeu()
	 * @see Configuration#getChiffre()
	 * 
	 * @return Le booleen de verification du nombre 
	 * 
	 * @version 0.2
	 */
	private boolean verifierNombre(String cNombre) throws NombreNegatifException, NombreLongueurException, NombreEchelleException {
	    boolean checkedNumber = true;
		logger.info("Verification du nombre rentre");	
		int nombre = Integer.parseInt(cNombre);
		{
			if (nombre < 0) {
				logger.error("Nombre saisi négatif : " + cNombre);
				checkedNumber = false;
				throw new NombreNegatifException(cNombre);
			}
		
			String stringNombre = String.valueOf(cNombre);
			if (stringNombre.length() != configuration.getChiffre()) {
				logger.error("Nombre saisi de longueur incorrect : " + cNombre);
				checkedNumber = false;
				throw new NombreLongueurException(cNombre);
			}

			for (int i = 0; i < configuration.getChiffre(); i++) {
				String carac = "" + stringNombre.charAt(i);
				int chiffre = Integer.parseInt(carac);
				if (chiffre > this.getCouleur()) {
					checkedNumber = false;
					logger.error("Chiffre utilisé incorrect (hors échelle) : " + cNombre);
					throw new NombreEchelleException(cNombre);
				}
			}
		}
			
		return checkedNumber;
	}
	
	/**
	 * <b>Méthode qui ecris un texte en l'espacant avec des sauts de ligne</b>
	 * 
	 * @param cTexte
	 * 		Texte a afficher sur l'écran
	 * 
	 * @since version 0.2
	 * @deprecated version 0.4.1
	 */
	private void ecrireTexte(String cTexte) {
		System.out.println("");
		System.out.println(cTexte);
		System.out.println("");
	}
	
	
}
