package fr.ocr.joueur;

public interface Joueur {
	public int getChiffreSecret();
	public int getChiffreJoueur();
	public void setChiffreSecret(int pChiffreSecret);
	public void setChiffreJoueur(int pChiffreSecret);
	public int choisirChiffreSecret();
	public int trouverChiffreSecret();
}
