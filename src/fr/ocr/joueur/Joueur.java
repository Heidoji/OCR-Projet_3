package fr.ocr.joueur;

import fr.ocr.exceptions.NombreEchelleException;
import fr.ocr.exceptions.NombreLongueurException;
import fr.ocr.exceptions.NombreNegatifException;

/**
 * <b>Interface gerant les joueurs</b>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public interface Joueur {
	/**
	 * <b>Retourne le nombre secret choisi</b> 
	 * 
	 * @see HumainJoueur#choisirChiffreSecret()
	 * @see OrdinateurJoueur#choisirChiffreSecret()
	 *
	 * @return le nombre secret choisi.
	 *
	 * @since 0.2
	 */
	public int getChiffreSecret();
	
	/**
	 * <b>Retourne le nombre choisi pour decouvrir le Nombre secret.</b> 
	 * 
	 * @see HumainJoueur#trouverChiffreSecret(String)
	 * @see OrdinateurJoueur#trouverChiffreSecret(String)
	 *
	 * @return le nombre choisi pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public int getChiffreJoueur();
	
	/**
	 * <b>Retourne le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind enregistrée dans le fichier de configuration.</b>
	 * 
	 * @return le nombre de possibilité pour former la combinaison secrète dans le jeu Mastermind
	 *
	 * @since 0.4.1
	 */
	public int getCouleur();
	
	/**
	 * <b>Met a jour le nombre secret.</b>
	 *
	 * @see HumainJoueur#choisirChiffreSecret() 
	 * @see OrdinateurJoueur#choisirChiffreSecret() 
	 * 
	 * @param pChiffreSecret 
	 * 		la nouvelle valeur du nombre nombre secret choisi.
	 *
	 * @since 0.2
	 */
	public void setChiffreSecret(int pChiffreSecret);
	
	/**
	 * <b>Met a jour le nombre choisi pour decouvrir le Nombre secret.</b>
	 *
	 * @see HumainJoueur#trouverChiffreSecret(String) 
	 * @see OrdinateurJoueur#trouverChiffreSecret(String) 
	 * 
	 * @param pChiffreJoueur 
	 * 		la nouvelle valeur du nombre pour decouvrir le Nombre secret.
	 *
	 * @since 0.2
	 */
	public void setChiffreJoueur(int pChiffreJoueur);
	
	/**
	 * <b>Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind</b>
	 * 
	 * @param pCouleur
	 *		Mise a jour de la valeur du nombre de couleur possible dans une combinaison de Mastermind
	 *
	 * @since 0.4.1
	 */
	public void setCouleur(int pCouleur);
	
	/**
	 * <b>Methode qui demande de choisir un chiffre secret</b>
	 *
	 * @see HumainJoueur#afficherTexte()
	 * @see HumainJoueur#setChiffreSecret(int)
	 * @see HumainJoueur#verifierNombre(int)
	 * @see HumainJoueur#getChiffreSecret()
	 * @see OrdinateurJoueur#setChiffreSecret(int)
	 * @see OrdinateurJoueur#getChiffreSecret()
	 * 
	 * @return Le nombre Secret choisi
	 * 
	 * @since 0.2
	 */
	public int choisirChiffreSecret();
	
	/**
	 * <b>Methode qui donne un nombre pour decouvrir le nombre secret</b>
	 *
	 * @see HumainJoueur#setChiffreJoueur(int)
	 * @see HumainJoueur#getChiffreSecret()
	 * @see OrdinateurJoueur#setChiffreJoueur(int)
	 * @see OrdinateurJoueur#getChiffreSecret()
	 * 
	 * @param pResultat
	 * 		Chaine de caractère représentant le résultat trouvé pour le précédant nombre
	 * 
	 * @return La nouvelle proposition du Nombre Joueur
	 * 
	 * @since 0.2
	 */
	public int trouverChiffreSecret(String pResultat);
}
