package fr.ocr.jeu;

public class RechercheGagner implements Gagner{
	public void gagnerPartie(int cNbEssai) {
		System.out.println("");
		System.out.println("**********************************");
		System.out.println("*           VICTOIRE             *");
		System.out.println("**********************************");
		System.out.println("");
		System.out.println("Vous avez gagner en " + cNbEssai + " coups");
		System.out.println("");
	}
}
