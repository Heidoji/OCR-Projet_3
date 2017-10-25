package fr.ocr.menu;

import java.util.Scanner;

import fr.ocr.configuration.Configuration;

/**
 * <b>La classe ConfigMenu s'occupe d'afficher et de gérer le menu de configuration du jeu</b>
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
public class ConfigMenu implements Menu {
	/**
	 * Ce char représente le choix de l'utilisateur. 
	 * 
	 * @see ConfigMenu#getChoix()
	 * @see ConfigMenu#setChoix(char)
	 * @see ConfigMenu#choisirMenu()
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
	 * <b>Assesseur du char choix de la classe ConfigMenu</b>
	 * 
	 * @since 0.2
	 */
	public char getChoix() {
		return this.choix;
	}
	
	//Mutateur
	
	/**
	 * <b>Mutateur du char choix de la classe ConfigMenu</b>
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
	 * <b>Affiche le menu de configuration a l'écran.</b>
	 * <p>
	 * Affiche également les préfèrences de configuration prédéfinies
	 * </p>
	 *
	 * @see Configuration#getEssai()
	 * @see Configuration#getCouleur()
	 * @see Configuration#getChiffre()
	 *
	 * @since 0.2
	 */
	public void afficherMenu() {
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
		System.out.println("E-  Nombre Essai                      : " + this.configuration.getEssai());
		System.out.println("C-  Nombre de chiffre par combinaison : " + this.configuration.getChiffre());
		System.out.println("O-  Nombre de couleur - Mastermind    : " + this.configuration.getCouleur());
		System.out.println("                                        ");
		System.out.println("R-  Retour                              ");
		System.out.println("                                        ");
		System.out.print("    Votre choix : ");
	}
	
	/**
	 * <b>Demande le choix de l'utilisateur et l'enregistre</b>
	 * <p>
	 * Le choix est enregistré dans le char choix
	 * </p>
	 * 
	 * @see ConfigMenu#choix
	 * @see Configuration#setJeu(String)
	 * @see Configuration#setMode(String)
	 *
	 * @since 0.2
	 */
	public void choisirMenu() {
		Scanner sc = new Scanner(System.in);
		this.setChoix(sc.nextLine().charAt(0));
		
		switch (this.choix) {
		case 'E' : this.configuration.setEssai(choisirValeur());
				   break; 
		case 'C' : this.configuration.setChiffre(choisirValeur());
				   break; 
		case 'O' : this.configuration.setCouleur(choisirValeur());
		}
	}
	
	/**
	 * <b>Cette classe permet à l'utilisateur de choisir une valeur</b>
	 * <p>
	 * Cette valeur est comprise entre 4 et 10.</br>
	 * Cette classe est utilisée pour configurer les valeurs d'essai, de couleur et de chiffre du fichier de Configuration
	 * </p>
	 * 
	 * @see ConfigMenu#choisirMenu()
	 * 
	 * @return la valeur choisie par l'utilisateur
	 * @since 0.2
	 */
	private int choisirValeur() {
		Scanner sc = new Scanner(System.in);
		int valeur;
		
		do {
		  System.out.println("Veuillez entrer une valeur entre 4 et 10 : ");
		  valeur = sc.nextInt();
		  sc.nextLine();
		} while (valeur < 4 || valeur > 10);
		return valeur; 
	}
}
