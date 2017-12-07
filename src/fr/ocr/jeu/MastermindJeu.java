package fr.ocr.jeu;

/**
 * <b>MastermindJeu est la classe regissant le Mastermind</b>
 * 
 * <p>
 * Il modifie la variable comparer en lui assignant MastermindComparer()
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4.1
 */
public class MastermindJeu extends Jeu{
	/**
	 * <b>Constructeur MastermindJeu.</b>
	 * <p>
	 * Il modifie la variable comparer en lui assignant MastermindComparer()
	 * </p>
	 *
	 * @since 0.2
	 */
	public MastermindJeu () {
		this.comparer = new MastermindComparer();
	}
}
