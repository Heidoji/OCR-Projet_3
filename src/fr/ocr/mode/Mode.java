package fr.ocr.mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.jeu.Jeu;
import fr.ocr.jeu.MastermindJeu;
import fr.ocr.jeu.RechercheJeu;
import fr.ocr.joueur.HumainJoueur;
import fr.ocr.joueur.Joueur;
import fr.ocr.joueur.OrdinateurJoueur;

/**
 * <b>La classe Mode permet de gerer la seqeunce de jeu selon le mode choisi</b>
 * <p>
 * Elle est la classe mere des classes suivantes :
 * </p>
 * <ul>
 * <li>DuelMode</li>
 * <li>ChallengeMode</li>
 * <li>DefenseMode</li>
 * </ul>
 *
 * <p>
 * De plus,  elle affiche un etat des variables ChiffreSecret et ChiffreJoueur 
 * En mode developpeur.
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public abstract class Mode {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(Mode.class);
	
	/**
	 * <b>Cet objet représente la configuration du jeu.</b>
	 * 
	 * @see Configuration
	 * @see Mode#Mode
	 *
	 * @since 0.2
	 */
	protected Configuration configuration = new Configuration();
	
	/**
	 * <b>Variable contenant le jeu à lancer.</b>
	 * <p>
	 * Il est déterminé par deux valeurs :
	 * </p>
	 * <ul>
	 * <li> R pour le jeu Recherche +/-</li>
	 * <li> M pour le jeu Mastermind</li>
	 * </ul>
     * 
	 * @see Jeu
	 * @see Mode#sequenceJeu
	 *
	 * @since 0.2
	 */
	public Jeu jeu;
	
	/**
	 * <b>Objet contenant les informations sur le joueur devant deviner le nombre secret</b>
	 * <p>
	 * Contient principalement le ChiffreSecret et le ChiffreJoueur.
	 * </p>
	 *
	 * @see Mode#sequenceJeu
	 * @see Mode#commentDev
	 *
	 * @since 0.2
	 */	
	protected Joueur player1;
	
	/**
	 * <b>Objet contenant les informations sur le joueur devant faire deviner le nombre secret</b>
	 * <p>
	 * Contient principalement le ChiffreSecret et le ChiffreJoueur.
	 * </p>
	 *
	 * @see Mode#sequenceJeu
	 * @see Mode#commentDev
	 *
	 * @since 0.2
	 */	
	protected Joueur player2;
	
	/**
	 * <b>Variable contenant le nombre d'essai pour découvrir la combinaison secrète.</b>
	 * 
	 * @see Mode#Mode
	 * @see Mode#getEssai
	 * @see Mode#setEssai(int)
	 * @see Mode#sequenceJeu
	 *
	 * @since 0.2
	 */	
	protected int essai;
	
	/**
	 * <b>Variable contenant le nombre d'essai pour découvrir la combinaison secrète.</b>
	 * 
	 * @see Mode#Mode
	 * @see Mode#getModDev
	 * @see Mode#setModDev(boolean)
	 * @see Mode#sequenceJeu
	 *
	 * @since 0.2
	 */	
	protected boolean modDev;
	
	/**
	 * <b>Variable contenant le nombre d'essai pour découvrir la combinaison secrète.</b>
	 * 
	 * @see Mode#Mode
	 * @see Mode#getModDev
	 * @see Mode#setModDev(boolean)
	 * @see Mode#sequenceJeu
	 *
	 * @since 0.2
	 */	
	protected String resultat;
	
	/**
	 * <b>Constructeur vide Mode.</b>
	 * <p>
	 * Instancie un Mode et :
	 * </p>
	 * <ul>
	 * <li>Un joueur humain</li>
	 * <li>Un joueur gere par l'ordinateur</li>
	 * <li>le nombre d'essai pour deviner le chiffre secret</li>
	 * <li>l'activation du mode de developpeur</li>
	 * <li>le jeu selectionne</li>
	 * </ul>
	 * 
	 * @see Configuration#getEssai
	 * @see Configuration#getModDev
	 * @see Configuration#getJeu
	 * @see HumainJoueur
	 * @see OrdinateurJoueur
	 *
	 * @since 0.2
	 */
	public Mode () {
		logger.info("Entering Constructeur Empty Mode");
		
		this.player1 = new HumainJoueur();
		this.player1.setChiffreJoueur("null");
		this.player1.setCouleur(configuration.getCouleur());
		this.player2 = new OrdinateurJoueur();
		this.player2.setChiffreJoueur("null");
		
		this.essai = configuration.getEssai();
		this.modDev = configuration.getModDev();
		
		if (configuration.getJeu() == 'M') {
			this.jeu = new MastermindJeu();
		}
		else {
			this.jeu = new RechercheJeu();
		}
	}
	
	//Assesseur
	
	/**
	 * <b>Retourne le nombre d'essai enregistrée dans le fichier de configuration.</b> 
	 * 
	 * @see Mode#sequenceJeu()
	 *
	 * @return le nombre d'essai pour decouvrir le nombre secret
	 *
	 * @since 0.2
	 */
	public int getEssai() {
		return this.essai;
	}

	/**
	 * <b>Retourne le booleen d'activation du mode developpeur enregistrée dans le fichier de configuration.</b>
	 * 
	 * @see Mode#sequenceJeu()
	 *
	 * @return le booleen d'activation du mode developpeur
	 *
	 * @since 0.2
	 */
	public boolean getModDev() {
		return this.modDev;
	}
	
	public String getResultat() {
		return this.resultat;
	}
	
	//Mutateur
	
	/**
	 * <b>Met a jour le nombre d'essai enregistrée dans le fichier de configuration.</b>
	 * 
	 * @param pEssai
	 * 		la nouvelle valeur du nombre d'essai pour decouvrir le nombre secret
	 *
	 * @since 0.2
	 */
	public void setEssai(int pEssai) {
		this.essai = pEssai;
	}
	
	/**
	 * <b>Met a jour le booleen d'activation du mode developpeur enregistrée dans le fichier de configuration.</b>
	 * 
	 * @param pModDev
	 * 		la nouvelle valeur du booleen d'activation du mode developpeur
	 *
	 * @since 0.2
	 */
	public void setModDev(boolean pModDev) {
		this.modDev = pModDev;
	}
	
	public void setResultat(String pResultat) {
		this.resultat = pResultat;
	}
	
	//Autre méthode
	
	/**
	 * <b>Cette classe determine la sequence de jeu.</b>
	 * <p>
	 * Cette classe appelle les classes chargees de :
	 * </p>
	 * <ul>
	 * <li>La creation du chiffre secret</li>
	 * <li>La resolution de la recherche du chiffre secret</li>
	 * <li>L'affichage du vainqueur</li>
	 * </ul>
	 *
	 * @see Mode#getModDev()
	 * @see Mode#commentDev()
	 * @see Joueur#choisirChiffreSecret()
	 * @see Joueur#getChiffreSecret()
	 * @see Joueur#getChiffreJoueur()
	 * @see Jeu#getGagne(String, String)
	 * @see Jeu#getNbEssai()
	 * @see Jeu#getComparer(String, String)
	 * @see Jeu#getGagner()
	 *
	 * @since 0.2
	 */
	public void sequenceJeu() {
		logger.info("Debut de la sequence de jeu");
		this.player1.choisirChiffreSecret();
		
		if (this.getModDev()) {
			this.commentDev();
		}
			
		while (!(this.jeu.getGagne(this.player2.getChiffreJoueur(), this.player1.getChiffreSecret()) 
				|| this.jeu.getNbEssai() >= this.essai)) {
			this.jeu.setNbEssai();
			System.out.println("--------------------------------------");
			System.out.println("Il vous reste " + (10 - this.jeu.getNbEssai()) + " essai" + (((10 - this.jeu.getNbEssai()) < 2) ? "" : "s"));
			logger.info("Nouveau passage dans la boucle de découverte du chiffre");
			this.setResultat(this.jeu.getComparer(this.player2.trouverChiffreSecret(this.getResultat()), this.player1.getChiffreSecret()));
		}
		
		if (this.jeu.getGagne()) {
			logger.info("Jeu gagne");
			this.jeu.getGagner();
		}
		else {
			logger.info("Jeu perdu");
			System.out.println("--------------------------------------");
			System.out.println("Vous avez perdu");
			System.out.println("Le nombre secret est : " + this.player1.getChiffreSecret());
		}
			
	}
	
	/**
	 * <b>Cette classe affiche des inforamtions concernant le jeu.</b>
	 * <p>
	 * Cette classe est utilisee en phase de developpement pour 
	 * permettre une verification plus aisee des mecaniques du jeu
	 * </p>
	 *
	 * @see Joueur#getChiffreSecret()
	 * @see Joueur#getChiffreJoueur()
	 *
	 * @since 0.2
	 */
	protected void commentDev() {
		logger.info("Mode developpeur active");
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Mode Developpeur activé");
		System.out.println("-----------------------");
		System.out.println("");
		System.out.println("Le chiffre secret du joueur 1 est " + this.player1.getChiffreSecret());
		System.out.println("Le chiffre secret du joueur 2 est " + this.player2.getChiffreSecret());
		System.out.println("");
		System.out.println("Le chiffre joueur du joueur 1 est " + this.player1.getChiffreJoueur());
		System.out.println("Le chiffre joueur du joueur 2 est " + this.player2.getChiffreJoueur());
		System.out.println("");
	}
}
