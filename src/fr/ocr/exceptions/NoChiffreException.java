package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour l'utilisation de caractères autre que des chiffres</b>
 * <p>
 * Il permet de lever une exception en cas d'utilisation de caractères autre que des chiffres
 * </p>
 * 
 * @author Heidoji
 * @since 1.0.4
 * @version 1.0.4
 */
public class NoChiffreException extends Exception {
	
	/**
	 * <b>Constructeur de l'exception sur l'utilisation de caractères autres que les chiffres</b>
	 * <p>
	 * Leve une exception si des caractères autres que les chiffres sont utilisés.
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le chiffre ayant levé l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NoChiffreException (String cNombre) {
		super("Caractères utilisé incorrect (Chiffre uniquement) : " + cNombre + "\n");
	}
}