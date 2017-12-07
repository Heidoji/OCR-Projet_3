package fr.ocr.exceptions;

import fr.ocr.joueur.HumainJoueur;

/**
 * <b>Class d'exception pour l'utilisation hors �chelle d'un chiffre</b>
 * <p>
 * Il permet de lever une exception en cas d'utilisation d'un chiffre hors
 * �chelle tel que d�finit dans le fichier de configuration
 * </p>
 * 
 * @author Heidoji
 * @since 0.4.1
 * @version 0.4.1
 */
public class NombreEchelleException extends Exception {
	
	/**
	 * <b>Constructeur de l'exception sur l'�chelle des chiffres utilisables</b>
	 * <p>
	 * Leve une exception si les chiffres utilis�s pour composer un nombre sont hors echelle par 
	 * rapport � la configuration d�finit.
	 * </p>
	 * 
	 * @param cNombre
	 * 		Donne le chiffre ayant lev� l'exception
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 *
	 * @since 0.4.1
	 */
	public NombreEchelleException (int cNombre) {
		super("Chiffre utilis� incorrect (hors �chelle) : " + cNombre + "\n");
	}
}
