package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour l'utilisation hors échelle d'un chiffre</b>
 * <p>
 * Il permet de lever une exception en cas d'utilisation d'un chiffre hors
 * échelle tel que définit dans le fichier de configuration
 * </p>
 * 
 * @author Heidoji
 * @since 0.4.1
 * @version 0.4.1
 */
public class NombreEchelleException extends Exception {
	
	/**
	 * <b>Constructeur de l'exception sur l'échelle des chiffres utilisables</b>
	 * <p>
	 * Leve une exception si les chiffres utilisés pour composer un nombre sont hors echelle par 
	 * rapport à la configuration définit.
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le chiffre ayant levé l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NombreEchelleException (int cNombre) {
		super("Chiffre utilisé incorrect (hors échelle) : " + cNombre + "\n");
	}
}
