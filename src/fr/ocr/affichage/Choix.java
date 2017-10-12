package fr.ocr.affichage;

/**
 * Enum�re tous les choix possibles pour le menu
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
	D ("D�fense"),
	U ("Duel"),
	Q ("Quitter"),
	O ("Option"),
	L ("Lancer la partie");
	
	/**
	 * Cette chaine repr�sente le nom pour un choix dans le menu
	 * 
	 * @see Choix#Choix(String)
	 * @see Choix#toString()
	 */
	private String name ="";
	
	/**
	 * Constructeur de l'�numeration Choix
	 * 
	 * @param pName
	 * 		Chaine repr�sentant le nom du Choix
	 * 
	 * @see Choix#name
	 */
	private Choix (String pName) {
		this.name = pName;
	}
	
	/**
	 * Retourne le nom de l'�numeration Choix
	 * 
	 * @return Le nom du choix de l'�numeration
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
