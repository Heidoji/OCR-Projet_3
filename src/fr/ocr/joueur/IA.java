package fr.ocr.joueur;

/**
 * <b>IA est l'interface permettant de gérer l'IA des deux jeux</b>
 * <p>
 * Il est implementer dans deux classes :
 * </p> 
 * <ul>
 * <li>RechercheIA</li>
 * <li>MastermindIA</li>
 * </ul>

 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.4.1
 */
public interface IA {
	/**
	 * <b>Méthode prenant un résultat de comparaison et retournant une proposition
	 * de nombre pour découvrir le nombre secret.</b>
	 * 
	 * @param pResultat
	 *		Chaine de caractère représentant le résultat trouvé pour le précédant nombre
	 * 
	 * @see RechercheIA#trouverChiffreSecret(String)
	 * @see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @return La nouvelle proposition du Nombre Joueur
	 * 
	 * @since 0.3
	 */
	public int trouverChiffreSecret(String pResultat);
}
