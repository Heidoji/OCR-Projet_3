package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour un nombre negatif</b>
 * <p>
 * Il permet de lever une exception en cas de nombre négatif
 * </p>
 * 
 * @author Heidoji
 * @since 0.4.1
 * @version 0.4.1
 */
public class NombreNegatifException extends Exception {
	/**
	 * <b>Constructeur de l'exception pour un nombre négatif</b>
	 * <p>
	 * Leve une exception si le nombre est négatif
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le nombre négatif entré ayant levé l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NombreNegatifException (String cNombre) {
		super("Nombre saisi négatif : " + cNombre + "\n");
	}
}
