package fr.ocr.affichage;

/**
 * Enumére tous les choix possibles pour le menu
 * 
 * @author Heidoji
 * @version 0.1
 */
public enum Choix {
	/**
	 * Objets directement construits.
	 */
	R ("Recherche +/-"),
	M ("Mastermind"),
	C ("Challenger"),
	D ("Défense"),
	U ("Duel"),
	Q ("Quitter"),
	O ("Option"),
	L ("Lancer la partie");
	
	/**
	 * Cette chaine représente le nom pour un choix dans le menu
	 * 
	 * @see Choix#Choix(String)
	 * @see Choix#toString()
	 */
	private String name ="";
	
	/**
	 * Constructeur de l'énumeration Choix
	 * 
	 * @param pName
	 * 		Chaine représentant le nom du Choix
	 * 
	 * @see Choix#name
	 */
	private Choix (String pName) {
		this.name = pName;
	}
	
	/**
	 * Retourne le nom de l'énumeration Choix
	 * 
	 * @return Le nom du choix de l'énumeration
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
