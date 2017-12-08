package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour un nombre negatif</b>
 * <p>
 * Il permet de lever une exception en cas de nombre n�gatif
 * </p>
 * 
 * @author Heidoji
 * @since 0.4.1
 * @version 0.4.1
 */
public class NombreNegatifException extends Exception {
	/**
	 * <b>Constructeur de l'exception pour un nombre n�gatif</b>
	 * <p>
	 * Leve une exception si le nombre est n�gatif
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le nombre n�gatif entr� ayant lev� l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NombreNegatifException (String cNombre) {
		super("Nombre saisi n�gatif : " + cNombre + "\n");
	}
}
