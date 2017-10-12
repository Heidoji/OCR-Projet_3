package fr.ocr.main;

import fr.ocr.chiffre.*;
import fr.ocr.affichage.*;

import java.util.Scanner;

/**
 * <b>Main est la classe contenant l'amorce du jeu</b>
 * <p>
 * <ul>
 * <li>Il permet de lancer les deux jeux presents - Mastermind et Recherche +/-</li>
 * <li>Il permet de choisir aleatoirement un chiffre a decouvrir</li>
 * </ul>
 *  
 * @see Chiffre
 * @see Affichage
 *
 * @author Heidoji
 * @version 0.0.1
 */

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Le chiffre a d�couvrir.
		 * 
		 * @see Chiffre#chiffre(String)
		 * @see Chiifre#getValeur()
		 */ 
		Chiffre chiffre_secret = new Chiffre("Random");


		/** 
		 * Le chiffre donn� par le joueur
		 * 
		 * @see Chiffre#chiffre(String)
		 * @see Chiifre#getValeur()
		 */ 
		Chiffre chiffre_joueur = new Chiffre();

		/**
		 * Le resultat donn� apr�s comparaison entre le chiffre � d�couvrir et le chiffre donn� par le joueur
		 * <p>
		 * Le r�sultat peut avoir deux valeurs : 
		 * <ul>
		 * <li>Une valeur qui retourne le r�sultat de la comparaison dans l'ordre</li>
		 * <li>Une valeur qui retourne le r�sultat sous la forme de chiffre bien plac� ou pr�sent dans le chiffre secret</li>
		 * </ul>
		 * 
		 * @see Chiffre#ComparaisonOrdonnee(Chiffre)
		 * @see Chiffre#ComparaisonDesordonnee(Chiffre)
		 */
		String resultat = "";
		
		Menu menu = new Menu();
		menu.affichageMenu();

		Scanner sc = new Scanner(System.in);
		while (resultat.compareTo("====") != 0) {
			System.out.println("(Combinaison secr�te : " + chiffre_secret.getValeur() + ")");
			System.out.print("Veuillez saisir votre chiffre : ");
			chiffre_joueur.setValeur(sc.nextLine());
			resultat = chiffre_joueur.ComparaisonDesordonnee(chiffre_secret);
			System.out.println(resultat);
			resultat = chiffre_joueur.ComparaisonOrdonnee(chiffre_secret);
			System.out.println("R�ponse : " + resultat);
		}
		
		System.out.println("Trouv�");
	}
	

}
