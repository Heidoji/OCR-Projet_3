package fr.ocr.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * <b>La classe FinMenu s'occupe d'afficher et de gérer le menu de fin de partie du jeu</b>
 * 
 * <p>
 * Il est possible de choisir :
 * </p>
 * <ul>
 * <li>de relancer le jeu</li>
 * <li>de quitter le jeu</li>
 * <li>de revenir au menu du jeu</li>
 * </ul>
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class FinMenu implements Menu {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(FinMenu.class);
	
	/**
	 * Ce char représente le choix de l'utilisateur. 
	 * 
	 * @see FinMenu#getChoix()
	 * @see FinMenu#setChoix(char)
	 * @see FinMenu#choisirMenu()
	 * @since 0.2
	 */
	private char choix;

	//Assesseur
	
	/**
	 * <b>Assesseur du char choix de la classe FinMenu</b>
	 * 
	 * @since 0.2
	 */
	public char getChoix() {
		return this.choix;
	}
	
	//Mutateur
	
	/**
	 * <b>Mutateur du char choix de la classe FinMenu</b>
	 * 
	 * @param pChoix
	 * 		char passé en argument pour changer la valeur de choix
	 *
	 * @since 0.2
	 */
	public void setChoix(char pChoix) {
		this.choix = pChoix;
	}
	
	//Autres méthodes
	
	/**
	 * <b>Affiche le menu de fin de partie a l'écran.</b>
	 *
	 * @since 0.2
	 */
	public void afficherMenu() {
		logger.info("Entre dans choisirMenu de fin de partie");
		
		System.out.println("                                                          ");
		System.out.println(" *********************************************************");
		System.out.println(" *                                                       *");
		System.out.println(" * **** **** ****   **** **** **** **** **** ****   **** *");
		System.out.println(" * *  * *    *  *   *  * *  * *  *   *  *      *       * *");
		System.out.println(" * *  * *    ***    **** ***  *  *   *  ***    *      ** *");
		System.out.println(" * **** **** *  *   *    *  * **** ***  ****   *    **** *");
		System.out.println(" *                                                       *");
		System.out.println(" *********************************************************");
		System.out.println("                               ");
		System.out.println("    Choississez vos options :  ");
		System.out.println("    ----------------------     ");
		System.out.println("                               ");
		System.out.println("L-  Lancer une nouvelle partie ");
		System.out.println("R-  Retour au menu du jeu      ");
		System.out.println("Q-  Quitter la partie          ");
		System.out.println("                               ");
		System.out.print("    Votre choix : ");
	}
	
	/**
	 * <b>Demande le choix de l'utilisateur et l'enregistre</b>
	 * <p>
	 * Le choix est enregistré dans le char choix
	 * </p>
	 * 
	 * @see FinMenu#choix
	 *
	 * @since 0.2
	 */
	public void choisirMenu() {
		logger.info("Entre dans choisirMenu de fin de partie");
		
		Scanner sc = new Scanner(System.in);
		this.setChoix(sc.nextLine().charAt(0));
		
		logger.debug("Configuration du jeu choisi dans le menu de fin de partie : " + this.getChoix());
	}
}

