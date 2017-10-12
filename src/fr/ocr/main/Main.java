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
		 * Le chiffre a découvrir.
		 * 
		 * @see Chiffre#chiffre(String)
		 * @see Chiifre#getValeur()
		 */ 
		Chiffre chiffre_secret = new Chiffre("Random");


		/** 
		 * Le chiffre donné par le joueur
		 * 
		 * @see Chiffre#chiffre(String)
		 * @see Chiifre#getValeur()
		 */ 
		Chiffre chiffre_joueur = new Chiffre();

		/**
		 * Le resultat donné après comparaison entre le chiffre à découvrir et le chiffre donné par le joueur
		 * <p>
		 * Le résultat peut avoir deux valeurs : 
		 * <ul>
		 * <li>Une valeur qui retourne le résultat de la comparaison dans l'ordre</li>
		 * <li>Une valeur qui retourne le résultat sous la forme de chiffre bien placé ou présent dans le chiffre secret</li>
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
			System.out.println("(Combinaison secrète : " + chiffre_secret.getValeur() + ")");
			System.out.print("Veuillez saisir votre chiffre : ");
			chiffre_joueur.setValeur(sc.nextLine());
			resultat = chiffre_joueur.ComparaisonDesordonnee(chiffre_secret);
			System.out.println(resultat);
			resultat = chiffre_joueur.ComparaisonOrdonnee(chiffre_secret);
			System.out.println("Réponse : " + resultat);
		}
		
		System.out.println("Trouvé");
	}
	

}
