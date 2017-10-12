package fr.ocr.chiffre;

import java.util.Random;

/** 
 * <b>Chiffre est la classe controlant la creation et la comparaison des valeurs</b>
 * <p>
 * Un chiffre peut appartenir a deux categories :
 * <ul>
 * <li>Soit donné par le joueur pour découvrir le Chiffre Secret</li>
 * <li>Soit representé le Chiffre_Secret a découvrir</li>
 * </ul>
 * </p>
 * <p>
 * De plus, les Chiffres peuvent etre comparés entre eux, retournant un résultat
 * donnant une indication sur la présence de chiffre communs entre les deux Chiffres 
 * </p>
 * 
 * @author Heidoji
 * @version 0.0.1
 */

public class Chiffre {

	/**
	 * Cette chaine représente la valeur donnée au Chiffre
	 * 
	 * @see Chiffre#Chiffre()
	 * @see Chiffre#Chiffre(String)
	 * @see Chiffre#getValeur()
	 * @see Chiffre#setValeur(String)
	 */
	private String valeur;
	
	/**
	 * Constructeur vide Chiffre
	 * <p>
	 * Instancie un Chiffre vide avec comme valeur une chaine vide
	 * </p>
	 * 
	 * @see Chiffre#valeur
	 */
	public Chiffre() {
		this.valeur = "";
	}
	
	/**
	 * Constructeur Chiffre
	 * <p>
	 * Instancie un Chiffre
	 * </p>
	 * 
	 * @param pValeur
	 * 	Peut avoir une chaine représentant un nombre ou "Random" qui génére un nombre aléatoire
	 * 
	 * @see Chiffre#valeur
	 */
	public Chiffre(String pValeur) {
		if (pValeur == "Random") {
			String random = "";
			Random rand = new Random();
			for(int i = 0 ; i < 4 ; i++) {
				random += rand.nextInt(9) + 1;
			}
			pValeur = random;
		}
		
		this.valeur = pValeur;
	}
	
	//Assesseurs

	/**
	 * Retourne la valeur du Chiffre
	 *
	 * @return La valeur du nombre
	 */
	public String getValeur() {
		return this.valeur;
	}
	
	//Mutateurs

	/**
	 * Mise a jour de la valeur du Chiffre
	 *
	 * @param cValeur
	 * 	La nouvelle valeur du nombre
	 *
	 */
	public void setValeur(String cValeur) {
		this.valeur = cValeur;
	}
	
	//Autres méthodes

	/**
	 * Compare deux chaines de meme longueur et retourne une chaine composee de '+', '-' ou '=' selon
	 * les differences entre chaque chiffre de meme indice
	 * 
	 * @param pChiffreSecret
	 * 	La valeur a comparer, qui est toujours le chiffre a decouvrir
	 *
	 * @return Le resultat de la comparaison composee de '+', '-' ou '='
	 *
	 * @see Chiffre#valeur
	 */
	public String ComparaisonOrdonnee(Chiffre pChiffreSecret) {
		String str = "";
		String nombre[] = this.valeur.split("");
		String nombre_secret[] = pChiffreSecret.valeur.split("");
		
		for (int i=0 ; i < nombre.length ; i++) {
			if (Integer.parseInt(nombre[i]) > Integer.parseInt(nombre_secret[i]))
				str += "-";
			else if  (Integer.parseInt(nombre[i]) < Integer.parseInt(nombre_secret[i])) 
				str += "+";
			else
				str += "=";
		}
		
		return str;
	}

	/**
	 * Compare deux chaines de meme longueur et retourne une chaine donnant le nombre de chiffre bien place
	 * et de chiffre present
	 * 
	 * @param pChiffreSecret
	 * 	La valeur a comparer, qui est toujours le chiffre a decouvrir
	 *
	 * @return Le resultat de la comparaison
	 *
	 * @see Chiffre#valeur
	 */	
	public String ComparaisonDesordonnee(Chiffre pChiffreSecret) {
		String str = "Resultat : ";
		String nombre[] = this.valeur.split("");
		String nombre_secret[] = pChiffreSecret.valeur.split("");
		
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
			str += bienPlace + " bien placé" + (bienPlace > 1 ? "s" : "");
		
		if ((present + bienPlace) == 0)
			str += "Aucun chiffre correct";
		
		return str;
	}
}

