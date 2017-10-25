package fr.ocr.jeu;


/**
 * <b>Jeu est la classe regissant le jeu en fonction du type de jeu et du mode de jeu</b>
 * <p>
 * Il fonctionne avec des interfaces gérant :
 * <ul>
 * <li>le type de jeu</li>
 * <li>le mode de jeu</li>
 * <li>d'acceder à la configuration du jeu</li>
 * <li>de quitter le programme</li>
 * </ul>
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.2
 */
public abstract class Jeu {
	protected boolean gagne;
	protected int nbEssai;
	protected Gagner gagner;
	protected Comparer comparer;
	
	//Constructeur
	public Jeu () {
		this.gagne = false;
		this.nbEssai = 0;
	}

	//Assesseurs
	public boolean getGagne() {
		return this.gagne;
	}
	
	public boolean getGagne(int cChiffreJoueur, int cChiffreSecret) {
		if (cChiffreJoueur == cChiffreSecret) {
			this.setGagne(true);
		}
		
		return this.gagne;
	}
	
	public int getNbEssai() {
		return this.nbEssai;
	}
	
	public void getGagner() {
		this.gagner.gagnerPartie(getNbEssai());
	}
	
	public void getComparer(int cChiffreJoueur, int cChiffreSecret) {
		this.comparer.comparerChiffre(cChiffreJoueur, cChiffreSecret);
	}

	//Mutateurs
	public void setGagne(boolean pGagner) {
		this.gagne = pGagner;
	}
	public void setNbEssai() {
		this.nbEssai++;
	}
	public void setNbEssai(int pNbEssai) {
		this.nbEssai = pNbEssai;
	}
}
