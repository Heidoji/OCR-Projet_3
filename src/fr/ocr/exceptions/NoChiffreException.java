package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour l'utilisation de caract�res autre que des chiffres</b>
 * <p>
 * Il permet de lever une exception en cas d'utilisation de caract�res autre que des chiffres
 * </p>
 * 
 * @author Heidoji
 * @since 1.0.4
 * @version 1.0.4
 */
public class NoChiffreException extends Exception {
	
	/**
	 * <b>Constructeur de l'exception sur l'utilisation de caract�res autres que les chiffres</b>
	 * <p>
	 * Leve une exception si des caract�res autres que les chiffres sont utilis�s.
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le chiffre ayant lev� l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NoChiffreException (String cNombre) {
		super("Caract�res utilis� incorrect (Chiffre uniquement) : " + cNombre + "\n");
	}
}