package fr.ocr.joueur;

import fr.ocr.configuration.Configuration;

/**
 * <b>MastermindIA est la classe permettant de gérer l'IA du jeu Mastermind</b>
 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.4.1
 */
public class MastermindIA implements IA {
	/**
	 * <b>Cette variable représente la dernière proposition de nombre proposé.</b>
	 * 
	 * @see MastermindIA#getLastChiffre()
	 * @see MastermindIA#setLastChiffre(int)
	 *
	 * @since 0.3
	 */
	private int lastChiffre;
	
	/**
	 * <b>Cet objet représente la configuration du jeu.</b>
	 * 
	 * @see Configuration
	 * @see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @since 0.3
	 */
	private Configuration configuration = new Configuration();
	
	//Assesseurs	
	/**
	 * <b>Retourne la dernière proposition de nombre (ChiffreJoueur) proposé.</b> 
	 * 
	 * see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @return la dernière proposition de nombre (ChiffreJoueur) proposé
	 *
	 * @since 0.3
	 */
	public int getLastChiffre() {
		return lastChiffre;
	}
	
	//Mutateurs
	/**
	 * <b>Permet la modification de la dernière valeur proposé (ChiffreJoueur).</b> 
	 * 
	 * @param pChiffre
	 * 		La nouvelle valeur pour la dernière proposition pour le ChiffreJoueur
	 * 
	 * @since 0.3 
	 */
	public void setLastChiffre(int pChiffre) {
		lastChiffre = pChiffre;
	}
	
	//Autres Methodes
	//TODO Integrer le code pour l'IA du mastermind
	/**
	 * <b>Méthode prenant un résultat de comparaison et retournant une proposition
	 * de nombre pour découvrir le nombre secret.</b>
	 * <p>
	 * TO BE DONE
	 * </p>
	 *
	 * @since 0.4.1
	 */
	public int trouverChiffreSecret(String pResultat) {
		return 5555;
	}
}
