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
import java.util.Scanner;

import com.sun.glass.ui.Menu;

import fr.ocr.affichage.Choix;


/**
 * <b>Configuration est la classe permettant de configurer et de sauvegarder les options de jeu</b>
 * <p>
 * Il permet de sauvegarder dans un fichier :
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>la difficulté</li>
 * <li>le nombre d'essai</li>
 * </ul>
 * </p>
 * <p>
 * De plus, il est possible d'afficher un menu recapitulatif des options
 * et de les modifier directement
 * </p>
 * 
 * @author Heidoji
 * @version 0.1
 */
public class Configuration{
	/**
	 * <b>Variable contenant le jeu à lancer.</b>
	 * <p>
	 * Il est déterminé par deux valeurs :
	 * <ul>
	 * <li> R pour le jeu Recherche +/-</li>
	 * <li> M pour le jeu Mastermind</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getJeu()
	 * @see Configuration#setJeu(char)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 * @see Menu#Lanceur(Choix)
	 *
	 * @since 0.1
	 */
	private char jeu;
	
	/**
	 * <b>Variable contenant le mode de jeu à lancer.</b>
	 * <p>
	 * Il est déterminé par trois valeurs :
	 * <ul>
	 * <li> C pour le mode Challenger</li>
	 * <li> D pour le mode Défense</li>
	 * <li> U pour le mode Duel</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getMode()
	 * @see Configuration#setMode(char)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 * @see Menu#Lanceur(Choix)
	 *
	 * @since 0.1
	 */
	private char mode;
	
	/**
	 * <b>Variable contenant le nombre d'essai pour découvrir la combinaison secrète.</b>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getEssai()
	 * @see Configuration#setEssai(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 * @see Configuration#lanceurMenu()
	 *
	 * @since 0.1
	 */	
	private int essai;
	
	/**
	 * <b>Variable contenant le nombre de couleur possible pour former la combinaison secrète
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
	 * @see Configuration#affichageMenu()
	 * @see Configuration#lanceurMenu()
	 *
	 * @since 0.1
	 */	
	private int couleur;


	/**
	 * <b>Variable contenant le nombre de chiffre ou couleur a decouvrir dans la combinaison secrète.</b>
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
	 * @see Configuration#affichageMenu()
	 * @see Configuration#lanceurMenu()
	 *
	 * @since 0.1
	 */	
	private int chiffre;
	
	/**
	 * <b>Booléen activant le mode developpeur</b> 
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int, boolean)
	 * @see Configuration#getModDev()
	 * @see Configuration#setModDev(boolean)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 * @see Configuration#lanceurMenu()
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
	 * Instancie une Configuration à partir du fichier de configuration sauvegardé.
	 * </p>
	 * 
	 * @see Configuration#readSavedFile()
	 *
	 * @since 0.1
	 */
	public Configuration() {
		readSavedFile();
	}
	
	/**
	 * <b>Constructeur Configuration.</b>
	 * <p>
	 * Instancie un Menu avec les valeurs passées en paramètre et la sauve dans fichier de configuration.
	 * </p>
	 * 
	 * @param cJeu
	 * 		Donne la préférence du jeu joué
	 * @param cMode
	 * 		Donne la préférence du mode de jeu joué
	 * @param cEssai
	 * 		Donne le nombre d'essai possible pour découvrir le chiffre secret
	 * @param cCouleur
	 * 		Donne le nombre de couleur possible pour composer la combinaison dans le jeu Mastermind
	 * @param cChiffre
	 * 		Donne le nombre de chiffre ou couleur a decouvrir dans la combinaison secrète
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
		this.jeu = pJeu;
		this.mode = pMode;
		this.essai = pEssai;
		this.couleur = pCouleur;
		this.chiffre = pChiffre;
		this.modDev = pModDev;
		
		writeSavedFile();
	}
	
	//Assesseurs
	
	/**
	 * <b>Retourne la préférence du jeu enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return la préférence du jeu choisi
	 *
	 * @since 0.1
	 */
	public char getJeu() {
		return this.jeu;
	}
	
	/**
	 * <b>Retourne la préférence de mode de jeu enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return la préférence de mode de jeu choisi
	 *
	 * @since 0.1
	 */
	public char getMode() {
		return this.mode;
	}
	
	/**
	 * <b>Retourne le nombre d'essai pour découvrir la combinaison secrète enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le nombre d'essai pour découvrir la combinaison secrète
	 *
	 * @since 0.1
	 */
	public int getEssai() {
		return this.essai;
	}
	
	/**
	 * <b>Retourne le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind
	 *
	 * @since 0.1
	 */
	public int getCouleur() {
		return this.couleur;
	}

	/**
	 * <b>Retourne le nombre de chiffre ou couleur a decouvrir dans la combinaison secrète enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de chiffre ou couleur a decouvrir dans la combinaison secrète
	 *
	 * @since 0.1
	 */
	public int getChiffre() {
		return this.chiffre;
	}
	
	/**
	 * <b>Retourne si le mode Développeur est activé ou non, comme enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le booléen representant l'activiation du mode Développeur
	 *
	 * @since 0.2
	 */
	public boolean getModDev() {
		return this.modDev;
	}
	
	//Mutateurs
	
	/**
	 * <b>Mise a jour de la valeur du jeu préféré</b>
	 * 
	 * @param pJeu
	 * 		Mis à jour de la préférence du jeu joué
	 *
	 * @since 0.1
	 */
	public void setJeu(char pJeu) {
		this.jeu = pJeu;
		writeSavedFile();
	}
	
	/**
	 * <b>Mise a jour de la valeur du mode de jeu préféré</b>
	 * 
	 * @param pMode
	 * 		Mis à jour de la préférence du mode joué
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
	 * @param pMode
	 * 		Mis à jour du nombre d'essai possible
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
	 * <b>Mise a jour de la valeur du nombre de chiffre ou couleur a decouvrir dans la combinaison secrète.</b>
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
	 * @param pChiffre
	 *		Valeur du booleen du mode Developpeur
	 *
	 * @since 0.2
	 */
	public void setModDev(boolean pModDev) {
		this.modDev = pModDev;
		writeSavedFile();
	}
	
	//Autres méthodes
	
	/**
	 * <b>Lis les paramètres de la class Configuration depuis le fichier 
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
      
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }       
	}
	
	/**
	 * <b>Ecris les paramètres de la class Configuration dans le fichier 
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
      
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }       
	}
}
