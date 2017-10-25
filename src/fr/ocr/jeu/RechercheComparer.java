package fr.ocr.jeu;

/**
 * <b>Compare deux chaines de meme longueur et retourne une chaine composee de '+', '-' ou '=' selon
 * les differences entre chaque chiffre de meme indice</b>
 * 
 * @param pChiffreSecret
 * 	La valeur à découvrir initialisé en début de jeu a comparé avec le ChiffreJoueur
 *
 * @param pChiffreJoueur
 * 	La valeur donnée par le joueur a comparé avec le ChiffreSecret
 *
 * @return Le resultat de la comparaison composee de '+', '-' ou '='
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.2
 */
public class RechercheComparer implements Comparer{
	public void comparerChiffre(int pChiffreJoueur, int pChiffreSecret) {
		String str = "";
		String nombre[] = String.valueOf(pChiffreJoueur).split("");
		String nombre_secret[] = String.valueOf(pChiffreSecret).split("");
		
		for (int i=0 ; i < nombre.length ; i++) {
			if (Integer.parseInt(nombre[i]) > Integer.parseInt(nombre_secret[i]))
				str += "-";
			else if  (Integer.parseInt(nombre[i]) < Integer.parseInt(nombre_secret[i])) 
				str += "+";
			else
				str += "=";
		}
		
		System.out.println("Proposition : " + pChiffreJoueur + " -> Réponse :  " + str);
	}
}
