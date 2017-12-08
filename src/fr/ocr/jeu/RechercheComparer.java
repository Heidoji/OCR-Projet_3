package fr.ocr.jeu;

/**
 * <b>Compare deux chaines de meme longueur et retourne une chaine composee de '+', '-' ou '=' selon
 * les differences entre chaque chiffre de meme indice</b>
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class RechercheComparer implements Comparer{
	/**
	 * <b>Compare deux chaines de meme longueur et retourne une chaine donnant pour chaque chiffre
	 * si le chiffre à decouvrir est plus grand ("+"), plus petit ("-") ou égale ("=") </b>
	 * 
	 * @param pChiffreSecret
	 * 	La valeur à découvrir initialisé en début de jeu a comparé avec le ChiffreJoueur
	 *
	 * @param pChiffreJoueur
	 * 	La valeur donnée par le joueur a comparé avec le ChiffreSecret
	 * 
	 * @return Le resultat de la comparaison sous la forme d'une chaîne de caractère
	 * 
	 * @author Heidoji
	 * @since 0.3
	 * @version 0.4.1
	 */	
	public String comparerChiffre(String pChiffreJoueur, String pChiffreSecret) {
		String str = "";
		String nombre[] = pChiffreJoueur.split("");
		String nombre_secret[] = pChiffreSecret.split("");
		
		for (int i=0 ; i < nombre.length ; i++) {
			//System.out.println("Valeur nombre secret : " + nombre_secret[i] + "Valeur nombre : " + nombre[i]);
			if (Integer.parseInt(nombre[i]) > Integer.parseInt(nombre_secret[i])) 
				str += "-";
			else if  (Integer.parseInt(nombre[i]) < Integer.parseInt(nombre_secret[i]))
				str += "+";
			else
				str += "=";
		}
		
		System.out.println("Proposition : " + pChiffreJoueur + " -> Réponse :  " + str);
		return str;
	}
}
