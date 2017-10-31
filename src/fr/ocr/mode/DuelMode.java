package fr.ocr.mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <b>La classe DuelMode est basee sur la classe Mode</b>
 * <p>
 * La sequence de jeu est revu pour permettre le jeu a deux joueurs 
 * chechant le chiffre secret simultanement.
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4
 */
public class DuelMode extends Mode {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @ since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(Mode.class);
	
	//Autre méthode
	
	/**
	 * <b>Cette classe determine la sequence de jeu.</b>
	 * <p>
	 * Cette classe appelle les classes chargees de :
	 * <ul>
	 * <li>La creation du chiffre secret</li>
	 * <li>La resolution de la recherche du chiffre secret</li>
	 * <li>L'affichage du vainqueur,?li>
	 * </ul>
	 * </p>
	 *
	 * @see Mode#getModDev()
	 * @see Mode#commentDev()
	 * @see Mode#afficheJoueur()
	 * @see player1#choisirChiffreSecret()
	 * @see player1#getChiffreSecret()
	 * @see player2#choisirChiffreSecret()
	 * @see player2#getChiffreJoueur()
	 * @see jeu#getGagne(int, int)
	 * @see jeu#getNbEssai()
	 * @see jeu#getComparer(int, int)
	 * @see jeu#getGagner()
	 *
	 * @since 0.2
	 */
	public void sequenceJeu() {
		logger.info("Debut de la sequence de jeu en DualMode");
		this.afficheJoueur(1);
		this.player1.choisirChiffreSecret();
		this.player2.choisirChiffreSecret();
			
		if (this.getModDev()) {
			this.commentDev();
		}
			
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
				logger.info("Jeu gagne par joueur 1 en DualMode");
				logger.info("Jeu perdu par joueur 2 en DualMode");
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
				logger.info("Jeu gagne par joueur 2 en DualMode");
				logger.info("Jeu perdu par joueur 1 en DualMode");
				break;
			}
		} while (!(this.jeu.getNbEssai() > this.getEssai()));
	}
	
    /**
	 * <b>Cette classe affiche le texte pour identifier le tour du joueur</b>
	 * 
	 * @param cNumeroJoueur
	 * 		Reprensente le numero du joueur 1 ou 2
	 *
	 * @since 0.2
	 */
	protected void afficheJoueur(int cNumeroJoueur) {
		System.out.println("");
		System.out.println("Player " + cNumeroJoueur + " : ");
		System.out.println("-----------");
	}
}
