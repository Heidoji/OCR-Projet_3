package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour une longueur incorrecte d'un nombre</b>
 * <p>
 * Il permet de lever une exception en cas de longueur incorrecte
 *  tel que d�finit dans le fichier de configuration
 * </p>
 * 
 * @author Heidoji
 * @since 0.4.1
 * @version 0.4.1
 */
public class NombreLongueurException extends Exception{
	/**
	 * <b>Constructeur de l'exception sur la longueur incorrecte d'un nombre</b>
	 * <p>
	 * Leve une exception si le nombre de chiffre pour composer un nombre est incorrect par 
	 * rapport � la configuration d�finit.
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le nombre de chiffre entr� ayant lev� l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NombreLongueurException (int cNombre) {
		super("Nombre saisi de longueur incorrect : " + cNombre + "\n");
	}
}
