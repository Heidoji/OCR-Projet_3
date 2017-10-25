package fr.ocr.main;

import fr.ocr.jeu.Lanceur;

/**
 * <b>Main est la classe lance le jeu en créant le lanceur du jeu</b>
 * 
 * @see Lanceur#Lanceur()
 * @see Lanceur#LancerJeu()
 *
 * @author Heidoji
 * @version 0.2
 */

public class Main {
	public static void main(String[] args) {
		Lanceur lanceur = new Lanceur();
		lanceur.lancerJeu();
	}
}
