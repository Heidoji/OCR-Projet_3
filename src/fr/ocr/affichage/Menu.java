package fr.ocr.affichage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;
import fr.ocr.configuration.*;

/**
 * <b>Menu est la classe g�n�rant et affichant le menu du jeu</b>
 * <p>
 * De plus, il permet de mettre � jour la configuration du jeu � travers la 
 * Class Configuration
 * Il est possible de choisir :
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>d'acceder � la configuration du jeu</li>
 * <li>de quitter le programme</li>
 * </ul>
 * </p>
 * <p>
 * A la fin d'une partie, il est possible de :
 * <ul>
 * <li>de rejouer</li>
 * <li>de revenir au menu pricipal</li>
 * <li>de quitter le programme</li>
 * </ul>
 * </p>
 * 
 * @see Choix
 * @see Configuration
 * 
 * @author Heidoji
 * @version 0.1
 */
public class Menu {
	
	/**
	 * Cet objet repr�sente la configuration du jeu. 
	 * 
	 * @see Configuration
	 * @see Menu#Menu()
	 * @see Menu#lanceur(String)
	 *
	 * @since 0.1
	 */
	private Configuration configuration;
	
	/**
	 * Constructeur vide Menu
	 * <p>
	 * Instancie un Menu chargeant les pr�f�rences de configuration sauvegard�es
	 * ou en cr�ant un nouveau fichier.
	 * </p>
	 * 
	 * @see Configuration
	 *
	 * @since 0.1
	 */
	public Menu() {
		Path source = Paths.get("config.properties");
		if (Files.exists(source)) {
			this.configuration = new Configuration();
		}
		else {
			this.configuration = new Configuration('R', 'C', 4, 10, 4);
		}
	}
	
	//Autre m�thodes
	
	/**
	 * Affiche le menu sur l'�cran.
	 * <b>
	 * Affiche �galement les pr�f�rences pr�d�finie
	 * </b>
	 *
	 * @since 0.1
	 */
	public void affichageMenu() {
		
		Scanner sc = new Scanner(System.in);
		String choix;
		
		System.out.println(" *********************************************************");
		System.out.println(" *                                                       *");
		System.out.println(" * **** **** ****   **** **** **** **** **** ****   **** *");
		System.out.println(" * *  * *    *  *   *  * *  * *  *   *  *      *       * *");
		System.out.println(" * *  * *    ***    **** ***  *  *   *  ***    *      ** *");
		System.out.println(" * **** **** *  *   *    *  * **** ***  ****   *    **** *");
		System.out.println(" *                                                       *");
		System.out.println(" *********************************************************");
		System.out.println("                                     ");
		System.out.println("    Choississez votre jeux :         ");
		System.out.println("    ----------------------           ");
		System.out.println("                                     ");
		System.out.println("R-  Recherche +/-                    " + (this.configuration.getJeu() == 'R' ? "X" : ""));
		System.out.println("M-  Mastermind                       " + (this.configuration.getJeu() == 'M' ? "X" : ""));
		System.out.println("                                     ");
		System.out.println("    Choississez votre mode de jeux : ");
		System.out.println("    ------------------------------   ");
		System.out.println("                                     ");
		System.out.println("C-  Challenger                       " + (this.configuration.getMode() == 'C' ? "X" : ""));
		System.out.println("D-  D�fense                          " + (this.configuration.getMode() == 'D' ? "X" : ""));
		System.out.println("U-  Duel                             " + (this.configuration.getMode() == 'U' ? "X" : ""));
		System.out.println("                                     ");
		System.out.println("    Autre action :                   ");
		System.out.println("    ------------                     ");
		System.out.println("                                     ");
		System.out.println("Q-  Quitter                          ");
		System.out.println("O-  Option                           ");
		System.out.println("                                     ");
		System.out.println("L-  Lancer la partie                 ");
		System.out.println("                                     ");
		System.out.print("    Votre choix : ");
		choix = sc.nextLine();

		try {
			this.lanceur(Choix.valueOf(choix));
		} catch (IllegalArgumentException e) {
			System.out.println("");
			System.out.println("Valeur non pr�sente dans le menu : " + e.getMessage());
			System.out.println("");
			this.affichageMenu();
		}
	}
	
	/**
	 * Gere le choix du joueur a travers le menu
	 * <b>
	 * Permet la s�lection du jeu et du mode de jeu, l'acc�s au mode de configuration
	 * Permet aussi de quitter l'application ou de lancer la partie
	 * </b>
	 * 
	 * @param pChoix
	 * 		Le choix venant du joueur � travers le menu
	 * 
	 * @see Menu#affichageMenu()
	 * @see Configuration#setJeu(String)
	 * @see Configuration#setMode(String)
	 *
	 * @since 0.1
	 */
	private void lanceur(Choix pChoix) {
		
		switch (pChoix.toString()) {
			case "Recherche +/-" : this.configuration.setJeu('R');
								   this.affichageMenu();
								   break; 
			case "Mastermind" : this.configuration.setJeu('M');
			   					this.affichageMenu();
								break; 
			case "Challenger" : this.configuration.setMode('C');
			   					this.affichageMenu();
								break; 
			case "D�fense" : this.configuration.setMode('D');
			   				 this.affichageMenu();
							 break; 
			case "Duel" : this.configuration.setMode('U');
			   			  this.affichageMenu();
						  break; 
			case "Quitter" : break; 
			case "Option" : this.configuration.affichageMenu();
							break; 
			case "Lancer la partie" : System.out.println(pChoix.toString());
									  break; 
			default: break;
		}
	}
}
