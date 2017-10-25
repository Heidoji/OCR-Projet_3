package fr.ocr.jeu;

public class MastermindJeu extends Jeu{
	public MastermindJeu () {
		this.gagner = new MastermindGagner();
		this.comparer = new MastermindComparer();
	}
}
