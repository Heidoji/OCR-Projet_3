package fr.ocr.joueur;

/**
 * <b>Interface gerant les joueurs</b>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4
 */
public interface Joueur {
	public int getChiffreSecret();
	public int getChiffreJoueur();
	public void setChiffreSecret(int pChiffreSecret);
	public void setChiffreJoueur(int pChiffreSecret);
	public int choisirChiffreSecret();
	public int trouverChiffreSecret();
}
