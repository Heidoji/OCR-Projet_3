package fr.ocr.jeu;

/**
 * <b>RechercheJeu est la classe regissant le jeu Recherche</b>
 * 
 * <p>
 * Il modifie la variable comparer en lui assignant RechercheComparer()
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class RechercheJeu extends Jeu {
	/**
	 * <b>Constructeur RechercheJeu.</b>
	 * <p>
	 * Il modifie la variable comparer en lui assignant RechercheComparer()
	 * </p>
	 *
	 * @since 0.2
	 */
	public RechercheJeu () {
		this.comparer = new RechercheComparer();
	}
}
