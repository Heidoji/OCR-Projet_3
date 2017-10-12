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
 * <li>la difficult�</li>
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
	 * Variable contenant le jeu � lancer. 
	 * <p>
	 * Il est d�termin� par deux valeurs :
	 * <ul>
	 * <li> R pour le jeu Recherche +/-</li>
	 * <li> M pour le jeu Mastermind</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int)
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
	 * Variable contenant le mode de jeu � lancer. 
	 * <p>
	 * Il est d�termin� par trois valeurs :
	 * <ul>
	 * <li> C pour le mode Challenger</li>
	 * <li> D pour le mode D�fense</li>
	 * <li> U pour le mode Duel</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int)
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
	 * Variable contenant le nombre d'essai pour d�couvrir la combinaison secr�te. 
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int)
	 * @see Configuration#getEssai()
	 * @see Configuration#setEssai(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 *
	 * @since 0.1
	 */	
	private int essai;
	
	/**
	 * Variable contenant le nombre de couleur possible pour former la combinaison secr�te
	 * dans le jeu Mastermind
	 * 
	 * <p>
	 * La valeur varie entre 4 et 10
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int)
	 * @see Configuration#getCouleur()
	 * @see Configuration#setCouleur(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 *
	 * @since 0.1
	 */	
	private int couleur;


	/**
	 * Variable contenant le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 * 
	 * <p>
	 * La valeur varie entre 4 et 10
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Configuration#Configuration(char, char, int, int, int)
	 * @see Configuration#getChiffre()
	 * @see Configuration#setChiffre(int)
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 * @see Configuration#affichageMenu()
	 *
	 * @since 0.1
	 */	
	private int chiffre;
	
	/**
	 * Chaine contenant le chemin du fichier de configuration
	 * 
	 * @see Configuration#readSavedFile()
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	String saveFile = "config.properties";
	
	//Constructeurs
	
	/**
	 * Constructeur vide Configuration
	 * <p>
	 * Instancie une Configuration � partir du fichier de configuration sauvegard�.
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
	 * Constructeur Configuration
	 * <p>
	 * Instancie un Menu avec les valeurs pass�es en param�tre et la sauve dans fichier de configuration.
	 * </p>
	 * 
	 * @param cJeu
	 * 		Donne la pr�f�rence du jeu jou�
	 * @param cMode
	 * 		Donne la pr�f�rence du mode de jeu jou�
	 * @param cEssai
	 * 		Donne le nombre d'essai possible pour d�couvrir le chiffre secret
	 * @param cCouleur
	 * 		Donne le nombre de couleur possible pour composer la combinaison dans le jeu Mastermind
	 * @param cChiffre
	 * 		Donne le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 * 
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * @see Configuration#writeSavedFile()
	 *
	 * @since 0.1
	 */
	public Configuration(char pJeu, char pMode, int pEssai, int pCouleur, int pChiffre) {
		this.jeu = pJeu;
		this.mode = pMode;
		this.essai = pEssai;
		this.couleur = pCouleur;
		this.chiffre = pChiffre;
		
		writeSavedFile();
	}
	
	//Assesseurs
	
	/**
	 * Retourne la pr�f�rence du jeu enregistr�e dans le fichier de configuration
	 * 
	 * @return la pr�f�rence du jeu choisi
	 *
	 * @since 0.1
	 */
	public char getJeu() {
		return this.jeu;
	}
	
	/**
	 * Retourne la pr�f�rence de mode de jeu enregistr�e dans le fichier de configuration
	 * 
	 * @return la pr�f�rence de mode de jeu choisi
	 *
	 * @since 0.1
	 */
	public char getMode() {
		return this.mode;
	}
	
	/**
	 * Retourne le nombre d'essai pour d�couvrir la combinaison secr�te enregistr�e dans le fichier de configuration
	 * 
	 * @return le nombre d'essai pour d�couvrir la combinaison secr�te
	 *
	 * @since 0.1
	 */
	public int getEssai() {
		return this.essai;
	}
	
	/**
	 * Retourne le nombre de possibilit� pour former la combinaison secr�te dans le jeu Mastermind enregistr�e dans le fichier de configuration
	 * 
	 * @return le nombre de possibilit� pour former la combinaison secr�te dans le jeu Mastermind
	 *
	 * @since 0.1
	 */
	public int getCouleur() {
		return this.couleur;
	}

	/**
	 * Retourne le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te enregistr�e dans le fichier de configuration
	 * 
	 * @return le nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 *
	 * @since 0.1
	 */
	public int getChiffre() {
		return this.chiffre;
	}
	
	//Mutateurs
	
	/**
	 * Mise a jour de la valeur du jeu pr�f�r�
	 * 
	 * @param cJeu
	 * 		Mis � jour de la pr�f�rence du jeu jou�
	 *
	 * @since 0.1
	 */
	public void setJeu(char cJeu) {
		this.jeu = cJeu;
		writeSavedFile();
	}
	
	/**
	 * Mise a jour de la valeur du mode de jeu pr�f�r�
	 * 
	 * @param cMode
	 * 		Mis � jour de la pr�f�rence du mode jou�
	 *
	 * @since 0.1
	 */
	public void setMode(char cMode) {
		this.mode = cMode;
		writeSavedFile();
	}
	
	/**
	 * Mise a jour de la valeur du nombre d'essai possible
	 * 
	 * @param cMode
	 * 		Mis � jour du nombre d'essai possible
	 *
	 * @since 0.1
	 */
	public void setEssai(int cEssai) {
		this.essai = cEssai;
		writeSavedFile();
	}
	
	/**
	 * Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 * 
	 * @param cCouleur
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.1
	 */
	public void setCouleur(int cCouleur) {
		this.couleur = cCouleur;
		writeSavedFile();
	}

	/**
	 * Mise a jour de la valeur du nombre de chiffre ou couleur a decouvrir dans la combinaison secr�te
	 * 
	 * @param cChiffre
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.1
	 */
	public void setChiffre(int cChiffre) {
		this.chiffre = cChiffre;
		writeSavedFile();
	}
	
	//Autres m�thodes
	
	/**
	 * Lis les param�tres de la class Configuration depuis le fichier 
	 * contenu dans la chaine "saveFile" et instancie la class Configuration
	 * 
	 * @see Configuration#saveFile
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * 
	 * @since 0.1
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
      
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }       
	}
	
	/**
	 * Ecris les param�tres de la class Configuration dans le fichier 
	 * contenu dans la chaine "saveFile".
	 * 
	 * @see Configuration#saveFile
	 * @see Configuration#jeu
	 * @see Configuration#mode
	 * @see Configuration#essai
	 * @see Configuration#couleur
	 * @see Configuration#chiffre
	 * 
	 * @since 0.1
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
	      dos.close();
      
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }       
	}
	
	/**
	 * Affiche le menu de configuration a l'�cran.
	 * <b>
	 * Affiche �galement les pr�f�rences de configuration pr�d�finies
	 * </b>
	 *
	 * @since 0.1
	 */
	public void affichageMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("                                                               ");
		System.out.println(" **************************************************************");
		System.out.println(" *                                                            *");
		System.out.println(" * **** **** *  * **** * **** *  * **** **** **** * **** *  * *");
		System.out.println(" * *    *  * ** * *    * *    *  * *  * *  *   *  * *  * ** * *");
		System.out.println(" * *    *  * * ** ***  * *  * *  * **** ****   *  * *  * * ** *");
		System.out.println(" * **** **** *  * *    * **** **** * *  *  *   *  * **** *  * *");
		System.out.println(" *                                                            *");
		System.out.println(" **************************************************************");
		System.out.println("                                        ");
		System.out.println("    Choississez vos options :           ");
		System.out.println("    ----------------------              ");
		System.out.println("                                        ");
		System.out.println("E-  Nombre Essai                      : " + this.getEssai());
		System.out.println("C-  Nombre de chiffre par combinaison : " + this.getChiffre());
		System.out.println("O-  Nombre de couleur - Mastermind    : " + this.getCouleur());
		System.out.println("                                        ");
		System.out.println("Q-  Quitter                             ");
		System.out.println("                                        ");
		System.out.print("    Votre choix : ");
		
		this.lanceur(sc.nextLine());
	}

	/**
	 * Gere le choix du joueur a travers le menu de configuration
	 * <b>
	 * Permet de mettre a jour les choix du joueur, de lancer le menu de configuration, de quitter le jeu 
	 * ou de lancer la partie
	 * </b>
	 * 
	 * @param pChoix
	 * 		Le choix venant du joueur � travers le menu de configuration
	 * 
	 * @see Configuration#AffichageMenu()
	 * @see Configuration#setEssa(int)
	 * @see Configuration#setCouleur(int)
	 * @see Configuration#setChiffre(int)
	 *
	 * @since 0.1
	 */
	private void lanceur(String pChoix) {
		int entree;
		Scanner sc = new Scanner(System.in);
		
		switch (pChoix) {
			case "E" : 
				   System.out.print("Rentrez la nouvelle valeur pour le nombre d'essai (4-10) : ");
				   entree = Integer.parseInt(sc.nextLine());
				   
				   if (entree > 3 && entree < 11)
					   this.setEssai(entree);
				   else
					   System.out.println("Le nombre doit �tre compris entre 4 et 10");
				   	   System.out.println("");
				   
				   this.affichageMenu();
				   break; 

			case "O" : 
				   System.out.print("Rentrez la nouvelle valeur pour le nombre de couleur (4-10) : ");
				   entree = Integer.parseInt(sc.nextLine());

				   if (entree > 3 && entree < 11)
					   this.setCouleur(entree);
				   else
					   System.out.println("Le nombre doit �tre compris entre 4 et 10");
				   	   System.out.println("");
				   
			   	   this.affichageMenu();
				   break; 

			case "C" :
				   System.out.print("Rentrez la nouvelle valeur pour le nombre de chiffre a decouvrir (4-10) : ");
				   entree = Integer.parseInt(sc.nextLine());

				   if (entree > 3 && entree < 11)
					   this.setChiffre(entree);
				   else
					   System.out.println("Le nombre doit �tre compris entre 4 et 10");
				   	   System.out.println("");

			   	   this.affichageMenu();
				   break; 

			case "Q" : break;

			default: System.out.println("Votre choix " + pChoix + " n'est pas correct");
				     this.affichageMenu();
				     break;
		}
	}

}
