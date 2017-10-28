package fr.ocr.mode;

public class DuelMode extends Mode {
	//Autre méthode
		public void sequenceJeu() {
			this.afficheJoueur(1);
			this.player1.choisirChiffreSecret();
			this.player2.choisirChiffreSecret();
			
			//if (this.getModDev()) {
				this.commentDev();
			//}
			
			do {
				this.jeu.setNbEssai();
				
				this.afficheJoueur(1);
				this.jeu.getComparer(this.player1.trouverChiffreSecret(), this.player2.getChiffreSecret());
				if (jeu.getGagne(this.player1.getChiffreJoueur(), this.player2.getChiffreSecret())) {
					this.afficheJoueur(1);
					this.jeu.getGagner();
					this.afficheJoueur(2);
					System.out.println("");
					System.out.println("Vous avez perdu");
					System.out.println("");
					break;
				}
				
				this.afficheJoueur(2);
				this.jeu.getComparer(this.player2.trouverChiffreSecret(), this.player1.getChiffreSecret());
				if (jeu.getGagne(this.player2.getChiffreJoueur(), this.player1.getChiffreSecret())) {
					this.afficheJoueur(1);
					System.out.println("");
					System.out.println("Vous avez perdu");
					this.afficheJoueur(2);
					this.jeu.getGagner();
					System.out.println("");
					break;
				}
			} while (!(this.jeu.getNbEssai() > this.getEssai()));
		}
		
		protected void afficheJoueur(int cNumeroJoueur) {
			System.out.println("");
			System.out.println("Player " + cNumeroJoueur + " : ");
			System.out.println("-----------");
		}
}
