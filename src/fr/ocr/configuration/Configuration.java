package fr.ocr.configuration;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * <b>Configuration est la classe permettant de configurer et de sauvegarder les options de jeu</b>
 * <p>
 * Il permet de sauvegarder dans un fichier :
 * </p>
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>la difficult�</li>
 * <li>le nombre d'essai</li>
 * </ul>
 *
 * <p>
 * De plus, il est possible d'afficher un menu recapitulatif des options
 * et de les modifier directement
 * </p>
 * 
 * @author Heidoji
 * @since 0.1
 * @version 0.4.1
 */
public class Configuration{
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(Configuration.class);
	
	/**
	 * <b>Variable contenant le jeu � lancer.</b>
	 * <p>
	 * Il est d�termin� par deux valeurs :
	 * </p>
	 * <ul>
	 * <li> R pour le jeu Recherche +/-</li>
	 * <li> M pour le jeu Mastermind</li>
	 * </ul>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getJeu()
	 * @see Configuration#setJeu(char)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	private char jeu;
	
	/**
	 * <b>Variable contenant le mode de jeu � lancer.</b>
	 * <p>
	 * Il est d�termin� par trois valeurs :
	 * </p>
	 * <ul>
	 * <li> C pour le mode Challenger</li>
	 * <li> D pour le mode D�fense</li>
	 * <li> U pour le mode Duel</li>
	 * </ul>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getMode()
	 * @see Configuration#setMode(char)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	private char mode;
	
	/**
	 * <b>Variable contenant le nombre d'essai pour d�couvrir la combinaison secr�te.</b>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getEssai()
	 * @see Configuration#setEssai(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */	
	private int essai;
	
	/**
	 * <b>Variable contenant le nombre de couleur possible pour former la combinaison secr�te
	 * dans le jeu Mastermind</b>
	 * 
	 * <p>
	 * La valeur varie entre 4 et 10
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getCouleur()
	 * @see Configuration#setCouleur(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */	
	private int couleur;

	/**
	 * <b>Variable contenant le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te.</b>
	 * 
	 * <p>
	 * La valeur varie entre 4 et 10
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getChiffre()
	 * @see Configuration#setChiffre(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */	
	private int chiffre;
	
	/**
	 * <b>Bool�en activant le mode developpeur</b> 
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getModDev()
	 * @see Configuration#setModDev(boolean)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.2
	 */
	private boolean modDev;
	
	/**
	 * <b>Chaine contenant le chemin du fichier de configuration.</b>
	 * 
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	String saveFile = "config.properties";
	
	//Constructeurs
	
	/**
	 * <b>Constructeur vide Configuration.</b>
	 * <p>
	 * Instancie une Configuration � partir du fichier de configuration sauvegard�.
	 * </p>
	 * 
	 * @see Configuration#readSavedFile()
	 *
	 * @since 0.1
	 */
	public Configuration() {
		logger.info("CLASS CONFIGURATION : Entering Constructeur Empty Configuration");
		readSavedFile();
		logger.info("CLASS CONFIGURATION : Saved File Read");
	}
	
	/**
	 * <b>Constructeur Configuration.</b>
	 * <p>
	 * Instancie un Menu avec les valeurs pass�es en param�tre et la sauve dans fichier de configuration.
	 * </p>
	 * 
	 * @param pJeu
	 * 		Donne la pr�f�rence du jeu jou�
	 * @param pMode
	 * 		Donne la pr�f�rence du mode de jeu jou�
	 * @param pEssai
	 * 		Donne le nombre d'essai possible pour d�couvrir le chiffre secret
	 * @param pCouleur
	 * 		Donne le nombre de couleur possible pour composer la combinaison dans le jeu Mastermind
	 * @param pChiffre
	 * 		Donne le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 * @param pModDev
	 * 		Donne le booleen d'activation pour l'affichage du mode d�veloppeur
	 * 
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * @see Configuration#modDev
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	public Configuration(char pJeu, char pMode, int pEssai, int pCouleur, int pChiffre, boolean pModDev) {
		logger.info("CLASS CONFIGURATION : Entering Constructeur Configuration");
		this.jeu = pJeu;
		this.mode = pMode;
		this.essai = pEssai;
		this.couleur = pCouleur;
		this.chiffre = pChiffre;
		this.modDev = pModDev;
		
		writeSavedFile();
		logger.info("CLASS CONFIGURATION : Files created");
	}
	
	//Assesseurs
	
	/**
	 * <b>Retourne la pr�f�rence du jeu enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return la pr�f�rence du jeu choisi
	 *
	 * @since 0.1
	 */
	public char getJeu() {
		return this.jeu;
	}
	
	/**
	 * <b>Retourne la pr�f�rence de mode de jeu enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return la pr�f�rence de mode de jeu choisi
	 *
	 * @since 0.1
	 */
	public char getMode() {
		return this.mode;
	}
	
	/**
	 * <b>Retourne le nombre d'essai pour d�couvrir la combinaison secr�te enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return le nombre d'essai pour d�couvrir la combinaison secr�te
	 *
	 * @since 0.1
	 */
	public int getEssai() {
		return this.essai;
	}
	
	/**
	 * <b>Retourne le nombre de possibilit� pour former la combinaison secr�te dans le jeu Mastermind enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de possibilit� pour former la combinaison secr�te dans le jeu Mastermind
	 *
	 * @since 0.1
	 */
	public int getCouleur() {
		return this.couleur;
	}

	/**
	 * <b>Retourne le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 *
	 * @since 0.1
	 */
	public int getChiffre() {
		return this.chiffre;
	}
	
	/**
	 * <b>Retourne si le mode D�veloppeur est activ� ou non, comme enregistr�e dans le fichier de configuration.</b>
	 * 
	 * @return le bool�en representant l'activiation du mode D�veloppeur
	 *
	 * @since 0.2
	 */
	public boolean getModDev() {
		return this.modDev;
	}
	
	//Mutateurs
	
	/**
	 * <b>Mise a jour de la valeur du jeu pr�f�r�</b>
	 * 
	 * @param pJeu
	 * 		Mis � jour de la pr�f�rence du jeu jou�
	 *
	 * @since 0.1
	 */
	public void setJeu(char pJeu) {
		this.jeu = pJeu;
		writeSavedFile();
	}
	
	/**
	 * <b>Mise a jour de la valeur du mode de jeu pr�f�r�</b>
	 * 
	 * @param pMode
	 * 		Mis � jour de la pr�f�rence du mode jou�
	 *
	 * @since 0.1
	 */
	public void setMode(char pMode) {
		this.mode = pMode;
		writeSavedFile();
	}
	
	/**
	 * <b>Mise a jour de la valeur du nombre d'essai possible</b>
	 * 
	 * @param pEssai
	 * 		Mis � jour du nombre d'essai possible
	 *
	 * @since 0.1
	 */
	public void setEssai(int pEssai) {
		this.essai = pEssai;
		writeSavedFile();
	}
	
	/**
	 * <b>Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind</b>
	 * 
	 * @param pCouleur
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.1
	 */
	public void setCouleur(int pCouleur) {
		this.couleur = pCouleur;
		writeSavedFile();
	}

	/**
	 * <b>Mise a jour de la valeur du nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te.</b>
	 * 
	 * @param pChiffre
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.1
	 */
	public void setChiffre(int pChiffre) {
		this.chiffre = pChiffre;
		writeSavedFile();
	}
	
	/**
	 * <b>Mise a jour du boolean du mode developpeur.</b>
	 * 
	 * @param pModDev
	 *		Valeur du booleen du mode Developpeur
	 *
	 * @since 0.2
	 */
	public void setModDev(boolean pModDev) {
		this.modDev = pModDev;
		writeSavedFile();
	}
	
	//Autres m�thodes
	
	/**
	 * <b>Lis les param�tres de la class Configuration depuis le fichier 
	 * contenu dans la chaine "saveFile" et instancie la class Configuration</b>
	 * 
	 * @see Configuration#saveFile
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * @see Configuration#modDev
	 * 
	 * @since 0.2
	 */
	private void readSavedFile(){
		logger.info("CLASS CONFIGURATION : Sauvegarde du fichier de configuration");
		DataInputStream dis;
		
	    try {
	      dis = new DataInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File(saveFile))));     

	      this.jeu = dis.readChar();
	      this.mode = dis.readChar();
	      this.essai = dis.readInt();
	      this.couleur = dis.readInt();
	      this.chiffre = dis.readInt();
	      this.modDev = dis.readBoolean();
	      logger.info("CLASS CONFIGURATION : Fichier de configuration sauvegard�");
      
	    } catch (FileNotFoundException e) {
	       logger.error("CLASS CONFIGURATION : Files Not found Exception : " + e);
	       e.printStackTrace();
	    } catch (IOException e) {
	       logger.error("CLASS CONFIGURATION : IO Exception : " + e);
	       e.printStackTrace();
	    }       
	}
	
	/**
	 * <b>Ecris les param�tres de la class Configuration dans le fichier 
	 * contenu dans la chaine "saveFile".</b>
	 * 
	 * @see Configuration#saveFile
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * @see Configuration#modDev
	 * 
	 * @since 0.2
	 */
	private void writeSavedFile(){
		logger.info("CLASS CONFIGURATION : Lecture du fichier de configuration");
		DataOutputStream dos;
		
	    try {
	      dos = new DataOutputStream(
	              new BufferedOutputStream(
	                new FileOutputStream(
	                  new File(saveFile))));     

	      dos.writeChar(this.jeu);
	      dos.writeChar(this.mode);
	      dos.writeInt(this.essai);
	      dos.writeInt(this.couleur);
	      dos.writeInt(this.chiffre);
	      dos.writeBoolean(this.modDev);
	      dos.close();
	      logger.info("CLASS CONFIGURATION : Fichier de configuration lu");
      
	    } catch (FileNotFoundException e) {
	    	logger.error("CLASS CONFIGURATION : Files Not found Exception : " + e);
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	logger.error("CLASS CONFIGURATION : IO Exception : " + e);
	    	e.printStackTrace();
	    }       
	}
}
