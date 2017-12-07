package fr.ocr.joueur;

import fr.ocr.configuration.Configuration;

/**
 * <b>RechercheIA est la classe permettant de g�rer l'IA du jeu Recherche</b>
 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.4.1
 */
public class RechercheIA implements IA {
	/**
	 * <b>Cette variable repr�sente la derni�re proposition de nombre (ChiffreJoueur) propos�.</b>
	 * 
	 * @see RechercheIA#getLastChiffre()
	 * @see RechercheIA#setLastChiffre(int)
	 *
	 * @since 0.3
	 */
	private int lastChiffre;
	
	/**
	 * <b>Cet objet repr�sente la configuration du jeu.</b>
	 * 
	 * @see Configuration
	 * @see RechercheIA#trouverChiffreSecret(String)
	 *
	 * @since 0.3
	 */
	private Configuration configuration = new Configuration();
	
	//Assesseurs
	/**
	 * <b>Retourne la derni�re proposition de nombre (ChiffreJoueur) propos�.</b> 
	 * 
	 * @see RechercheIA#trouverChiffreSecret(String)
	 *
	 * @return la derni�re proposition de nombre (ChiffreJoueur) propos�
	 *
	 * @since 0.3
	 */
	public int getLastChiffre() {
		return lastChiffre;
	}
	
	//Mutateurs
	/**
	 * <b>Permet la modification de la derni�re valeur propos� (ChiffreJoueur).</b> 
	 * 
	 * @param pChiffre
	 * 		La nouvelle valeur pour la derni�re proposition pour le ChiffreJoueur
	 * 
	 * @since 0.3 
	 */
	public void setLastChiffre(int pChiffre) {
		lastChiffre = pChiffre;
	}
	
	//Autres Methodes
	/**
	 * <b>M�thode prenant un r�sultat de comparaison et retournant une proposition
	 * de nombre pour d�couvrir le nombre secret.</b>
	 *
	 * @since 0.3
	 */
	public int trouverChiffreSecret(String pResultat) {
		int nombreChiffre = configuration.getChiffre();
		String resultat = pResultat;
		//System.out.println(pResultat + "," + this.lastChiffre);
		
		int solution = 0;
		int unite;
		int lastProposition = this.getLastChiffre();
		
		if (pResultat == null) { //Premiere evaluation - resultat pas encore initi�
			for (int i = 0; i < nombreChiffre ; i++) {
				solution = solution * 10 + 5;
			}
		}
		else {
			for (int i = nombreChiffre - 1; i >= 0 ; i--) {
				unite = lastProposition % 10;
				int newDigit;
				lastProposition /= 10;
				
				if (unite > 5) 
					newDigit = unite - 5;
				else
					newDigit = unite;
					
				//System.out.println("unite : " + unite + ", Chiffre Restant : " + lastProposition + ", digit calcul� : " + newDigit + ", i " + i);
				
				if (resultat.charAt(i) == '=') {
					solution = (int) (solution + unite * Math.pow(10, (nombreChiffre - i - 1)));
					//System.out.println("solution = " + solution + " avec " + resultat.charAt(i));
				}
				else if (resultat.charAt(i) == '-') {
					solution = (int) (solution + (unite - newDigit / 2) * Math.pow(10, (nombreChiffre - i - 1)));
					//System.out.println("solution = " + solution + " avec " + resultat.charAt(i));
				}
				else {
					solution = (int) (solution + (unite + newDigit / 2) * Math.pow(10, (nombreChiffre - i - 1)));
					//System.out.println("solution = " + solution + " avec " + resultat.charAt(i));
				}
				
			}
		}

		this.setLastChiffre(solution);
		//System.out.println(solution + "," + this.lastChiffre);
		//System.out.println(solution);
		
		return solution;
	}
}
