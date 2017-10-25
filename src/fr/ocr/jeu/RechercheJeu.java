package fr.ocr.jeu;

public class RechercheJeu extends Jeu{
	public RechercheJeu () {
		this.gagner = new RechercheGagner();
		this.comparer = new RechercheComparer();
	}
}
