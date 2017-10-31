package fr.ocr.mode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.joueur.HumainJoueur;
import fr.ocr.joueur.OrdinateurJoueur;


/**
 * <b>La classe ChallengeMode est basee sur la classe Mode</b>
 * <p>
 * Seul l'inversion du joueur ordinateur en player1 et du joueur humain
 * en player2.
 * </p>
 * 
 * @author Heidoji
 * @since 0.2
 * @version 0.4
 */
public class ChallengeMode extends Mode{
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @ since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(ChallengeMode.class);
	
	/**
	 * <b>Constructeur vide ChallengeMode.</b>
	 * <p>
	 * Instancie un Mode en se basant sur la class mère Mode
	 * Mais en changeant
	 * <ul>
	 * <li>Le player1 en un joueur Ordinateur</li>
	 * <li>Le player2 en un joueur Humain</li>
	 * </ul>
	 * </p>
	 *
	 * @since 0.2
	 */
	public ChallengeMode () {
		super();
		
		logger.info("Mode intancie en ChallengeMode");
		
		this.player1 = new OrdinateurJoueur();
		this.player2 = new HumainJoueur();
	}
}
