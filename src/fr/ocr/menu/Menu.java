package fr.ocr.menu;

/**
 * <b>L'interface Menu permet la g�n�ration de menu</b>
 * 
 * <p>
 * Elle est utilis�e par la classe Lanceur et est implent�e par :
 * </p>
 * <ul>
 * <li>JeuMenu</li>
 * <li>ConfigMenu</li>
 * <li>FinMenu</li>
 * </ul>
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public interface Menu {
	/**
	 * <b>Assesseur du char choix de la classe JeuMenu</b>
	 * 
	 * @return le char repr�sentant le choix donn� par le joueur
	 * 
	 * @since 0.2
	 */
	public char getChoix();
	
	/**
	 * <b>Mutateur du char choix</b>
	 * 
	 * @param pChoix
	 * 	char pass� en argument pour changer la valeur de choix
	 *
	 * @since 0.2
	 */
	public void setChoix(char pChoix);
	
	/**
	 * <b>Affiche le menu sur l'�cran.</b>
	 *
	 * @since 0.2
	 */
	public void afficherMenu();
	
	/**
	 * <b>Demande le choix de l'utilisateur et l'enregistre</b>
	 * <p>
	 * Le choix est enregistr� dans le char choix
	 * </p>
	 * 
	 * @since 0.2
	 */
	public void choisirMenu();
}
