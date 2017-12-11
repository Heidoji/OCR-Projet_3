package fr.ocr.jeu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.mode.Mode;

/**
 * <b>MastermindComparer est la classe permettant la comparaison de deux nombres</b>
 * <p>
 * Il prend deux nombres :
 * </p>
 * <ul>
 * <li>Le chiffre choisis par le joueur</li>
 * <li>Le chiffre secret</li>
 * </ul>
 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.4.1
 */
public class MastermindComparer implements Comparer {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.5
	 */
	private static final Logger logger = LogManager.getLogger(Mode.class);
	
	/**
	 * <b>Compare deux chaines de meme longueur et retourne une chaine donnant le nombre de chiffre bien place
	 * et de chiffre present</b>
	 * 
	 * @see MastermindJeu#MastermindJeu()
	 * 
	 * @param pChiffreSecret
	 * 	La valeur � d�couvrir initialis� en d�but de jeu a compar� avec le ChiffreJoueur
	 *
	 * @param pChiffreJoueur
	 * 	La valeur donn�e par le joueur a compar� avec le ChiffreSecret
	 * 
	 * @return Le resultat de la comparaison sous la forme d'une cha�ne de caract�re
	 * 
	 * @author Heidoji
	 * @since 0.3
	 * @version 0.4.1
	 */	
	public String comparerChiffre(String pChiffreJoueur, String pChiffreSecret) {
		logger.info("CLASSE MASTERMINDCOMPARER : comparaison entre le nombre secret et le nombre joueur");
		String str = "";
		String chiffreJoueurNettoy� = "";
		String chiffreSecretNettoy� = "";
		
		int bienPlace = 0;
		int present = 0;
		
		for (int i = 0; i < pChiffreSecret.length(); i++) {
            if (pChiffreJoueur.charAt(i) == pChiffreSecret.charAt(i))
            	bienPlace++;
            if (chiffreJoueurNettoy�.indexOf(pChiffreJoueur.charAt(i)) < 0)
            	chiffreJoueurNettoy� += pChiffreJoueur.charAt(i);
            if (chiffreSecretNettoy�.indexOf(pChiffreSecret.charAt(i)) < 0)
            	chiffreSecretNettoy� += pChiffreSecret.charAt(i);
        }
		
		for (int i = 0; i < chiffreSecretNettoy�.length(); i++) {
            if (chiffreJoueurNettoy�.indexOf(chiffreSecretNettoy�.charAt(i)) >= 0)
            	present++;
        }
		
		if (present > 0)
			str += (present-bienPlace) + " pr�sent" + (present > 1 ? "s" : "") + (bienPlace > 0 ? ", " : "");
		
		if (bienPlace > 0)
			str += bienPlace + " bien plac�" + (bienPlace > 1 ? "s" : "");
		
		if ((present + bienPlace) == 0)
			str += "Aucun chiffre correct";
		
		System.out.println("Proposition : " + pChiffreJoueur + " -> R�ponse :  " + str);
		return (bienPlace + "" + present);
	}
}
