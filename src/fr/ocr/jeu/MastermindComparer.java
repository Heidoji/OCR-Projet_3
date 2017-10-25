package fr.ocr.jeu;

/**
 * <b>Compare deux chaines de meme longueur et retourne une chaine donnant le nombre de chiffre bien place
 * et de chiffre present</b>
 * 
 * @param pChiffreSecret
 * 	La valeur à découvrir initialisé en début de jeu a comparé avec le ChiffreJoueur
 *
 * @param pChiffreJoueur
 * 	La valeur donnée par le joueur a comparé avec le ChiffreSecret
 * 
 * @return Le resultat de la comparaison
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.2
 */	
public class MastermindComparer implements Comparer {
	public void comparerChiffre(int pChiffreJoueur, int pChiffreSecret) {
		String str = "";
		String nombre[] = String.valueOf(pChiffreJoueur).split("");
		String nombre_secret[] = String.valueOf(pChiffreSecret).split("");
		
		int bienPlace = 0;
		int present = 0;
		
		for (int i=0 ; i < nombre.length ; i++) {
			if (Integer.parseInt(nombre[i]) == Integer.parseInt(nombre_secret[i]))
				bienPlace++;
			
			for (int j=0 ; j < nombre.length ; j++) {
				if  (Integer.parseInt(nombre[i]) == Integer.parseInt(nombre_secret[j])) {
					present++;
					break;
				}
			}
		}
		
		if (present > 0)
			str += present + " présent" + (present > 1 ? "s" : "") + (bienPlace > 0 ? ", " : "");
		
		if (bienPlace > 0)
			str += (bienPlace - present) + " bien placé" + (bienPlace > 1 ? "s" : "");
		
		if ((present + bienPlace) == 0)
			str += "Aucun chiffre correct";
		
		System.out.println("Proposition : " + pChiffreJoueur + " -> Réponse :  " + str);
	}
}
