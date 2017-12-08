package fr.ocr.jeu;

/**
 * <b>Comparer est l'interface permettant de comparer deux nombres</b>
 * <p>
 * Il est implementer dans deux classes :
 * </p>
 * <ul>
 * <li>RechercheComparer</li>
 * <li>MastermindComparer</li>
 * </ul>
 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.4.1
 */
public interface Comparer {
	/**
	 * <b>M�thode comparant deux chiffres et retourne un String comme r�sultat.</b>
	 * 
	 * @see RechercheComparer#comparerChiffre(String, String)
	 * @see MastermindComparer#comparerChiffre(String, String)
	 *
	 * @param pChiffreJoueur
	 * 		La variable contenant la proposition du joueur
	 * @param pChiffreSecret
	 * 		La variable contenant le nombre secret
	 * 
	 * @return Retourne une cha�ne de caract�re contenant le resultat
	 *
	 * @since 0.3
	 */
	public String comparerChiffre(String pChiffreJoueur, String pChiffreSecret);
}
