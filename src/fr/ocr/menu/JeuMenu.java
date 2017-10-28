package fr.ocr.menu;

import java.util.Scanner;

import fr.ocr.configuration.Configuration;

/**
 * <b>La classe JeuMenu s'occupe d'afficher et de gérer le menu principal du jeu</b>
 * 
 * <p>
 * De plus, il permet de mettre à jour la configuration du jeu à travers la 
 * Class Configuration
 * Il est possible de choisir :
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>d'acceder à la configuration du jeu</li>
 * <li>de quitter le programme</li>
 * </ul>
 * </p>
 * 
 * @see Configuration#Configuration()
 * @see Configuration#getJeu()
 * @see Configuration#getMode()
 * @see Configuration#setJeu(String)
 * @see Configuration#setMode(String) 
 * @see JeuMenu#choix
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.2
 */
public class JeuMenu implements Menu {
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
	 * @param
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
	 * @see Configuration#setJeu(String)
	 * @see Configuration#setMode(String)
	 *
	 * @since 0.2
	 */
	public void choisirMenu() {
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("Configuration du jeu : " + configuration.getMode());
	}
}
