package fr.ocr.mode;

import fr.ocr.joueur.HumainJoueur;
import fr.ocr.joueur.OrdinateurJoueur;

public class ChallengeMode extends Mode{
	public ChallengeMode () {
		super();
		
		this.player1 = new OrdinateurJoueur();
		this.player2 = new HumainJoueur();
	}
}
