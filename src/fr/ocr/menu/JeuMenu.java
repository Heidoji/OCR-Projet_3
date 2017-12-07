package fr.ocr.menu;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;

/**
 * <b>La classe JeuMenu s'occupe d'afficher et de gérer le menu principal du jeu</b>
 * 
 * <p>
 * De plus, il permet de mettre à jour la configuration du jeu à travers la 
 * Class Configuration
 * </p>
 * Il est possible de choisir :
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>d'acceder à la configuration du jeu</li>
 * <li>de quitter le programme</li>
 * </ul>
 * 
 * @see Configuration#Configuration()
 * @see Configuration#getJeu()
 * @see Configuration#getMode()
 * @see Configuration#setJeu(char)
 * @see Configuration#setMode(char) 
 * @see JeuMenu#choix
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class JeuMenu implements Menu {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(JeuMenu.class);
	
	/**
	 * Ce char représente le choix de l'utilisateur. 
	 * 
	 * @see JeuMenu#getChoix()
	 * @see JeuMenu#setChoix(char)
	 * @see JeuMenu#choisirMenu()
	 * @since 0.2
	 */
	private char choix;
	
	/**
	 * Cet objet représente la configuration du jeu. 
	 * 
	 * @see Configuration
	 *
	 * @since 0.2
	 */
	private Configuration configuration = new Configuration();

	//Assesseur
	
	/**
	 * <b>Assesseur du char choix de la classe JeuMenu</b>
	 * 
	 * @since 0.2
	 */
	public char getChoix() {
		return this.choix;
	}
	
	//Mutateur
	
	/**
	 * <b>Mutateur du char choix de la classe JeuMenu</b>
	 * 
	 * @param pChoix
	 * 	char passé en argument pour changer la valeur de choix
	 *
	 * @since 0.2
	 */
	public void setChoix(char pChoix) {
		this.choix = pChoix;
	}
	
	//Autres méthodes
	
	/**
	 * <b>Affiche le menu sur l'écran.</b>
	 * <p>
	 * Affiche également les préfèrences prédéfinie
	 * </p>
	 *
	 * @see Configuration#getJeu()
	 * @see Configuration#getMode() 
	 *
	 * @since 0.2
	 */
	public void afficherMenu() {
		logger.info("Entre dans l'afficherMenu du jeu");
		
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
		System.out.println("D-  Défense                          " + (this.configuration.getMode() == 'D' ? "X" : ""));
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
	}
	
	/**
	 * <b>Demande le choix de l'utilisateur et l'enregistre</b>
	 * <p>
	 * Le choix est enregistré dans le char choix
	 * </p>
	 * 
	 * @see JeuMenu#choix
	 * @see Configuration#setJeu(char)
	 * @see Configuration#setMode(char)
	 *
	 * @since 0.2
	 */
	public void choisirMenu() {
		logger.info("Entre dans choisirMenu du jeu");
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		this.setChoix(sc.nextLine().charAt(0));
		
		switch (this.choix) {
		case 'R' : this.configuration.setJeu('R');
				   break; 
		case 'M' : this.configuration.setJeu('M');
				   break; 
		case 'C' : this.configuration.setMode('C');
				   break; 
		case 'D' : this.configuration.setMode('D');
				   break; 
		case 'U' : this.configuration.setMode('U');
		}

	    logger.debug("Configuration du jeu choisi dans le menu jeu : " + this.getChoix());
	}
}
