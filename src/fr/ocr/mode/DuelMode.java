package fr.ocr.mode;

public class DuelMode extends Mode {
	//Autre méthode
		public void sequenceJeu() {
			System.out.println("");
			System.out.println("Player 1 : ");
			System.out.println("-----------");
			this.player1.choisirChiffreSecret();
			this.player2.choisirChiffreSecret();
			
			if (this.getModDev()) {
				this.commentDev();
			}
			
			while (!(this.jeu.getGagne(this.player2.getChiffreJoueur(), this.player1.getChiffreSecret()) 
					|| this.jeu.getGagne(this.player1.getChiffreJoueur(), this.player2.getChiffreSecret())
					 || this.jeu.getNbEssai() > this.getEssai())) {
				this.jeu.setNbEssai();
				System.out.println("");
				System.out.println("Player 1 : ");
				System.out.println("-----------");
				this.jeu.getComparer(this.player1.trouverChiffreSecret(), this.player2.getChiffreSecret());
				System.out.println("");
				System.out.println("Player 2 : ");
				System.out.println("-----------");
				this.jeu.getComparer(this.player2.trouverChiffreSecret(), this.player1.getChiffreSecret());
			} 
			
			if (jeu.getGagne(this.player1.getChiffreJoueur(), this.player2.getChiffreSecret())) {
				System.out.println("");
				System.out.println("Player 1 : ");
				System.out.println("-----------");
				this.jeu.getGagner();
				System.out.println("");
				System.out.println("Player 2 : ");
				System.out.println("-----------");
				System.out.println("");
				System.out.println("Vous avez perdu");
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println("Player 1 : ");
				System.out.println("-----------");
				System.out.println("");
				System.out.println("Vous avez perdu");
				System.out.println("");
				System.out.println("Player 2 : ");
				System.out.println("-----------");
				this.jeu.getGagner();
				System.out.println("");
			}
		}
		
		protected void commentDev() {
			System.out.println("");
			System.out.println("-----------------------");
			System.out.println("Mode Developpeur activé");
			System.out.println("-----------------------");
			System.out.println("");
			System.out.println("Le chiffre secret est " + this.player1.getChiffreSecret());
			System.out.println("Le chiffre secret est " + this.player2.getChiffreSecret());
			System.out.println("");
		}
}
