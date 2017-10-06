package fr.ocr.main;

import fr.ocr.chiffre.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chiffre chiffre_secret = new Chiffre("Random");
		Chiffre chiffre_joueur = new Chiffre();
		String resultat = "";
		Scanner sc = new Scanner(System.in);

		while (resultat.compareTo("====") != 0) {
			System.out.println("(Combinaison secrète : " + chiffre_secret.getValeur() + ")");
			System.out.print("Veuillez saisir votre chiffre : ");
			chiffre_joueur.setValeur(sc.nextLine());
			resultat = chiffre_joueur.ComparaisonDesordonnee(chiffre_secret);
			System.out.println(resultat);
			resultat = chiffre_joueur.ComparaisonOrdonnee(chiffre_secret);
			System.out.println(resultat);
		}
		
		System.out.println("Trouvé");
		sc.close();
	}
	

}
