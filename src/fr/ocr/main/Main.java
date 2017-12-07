package fr.ocr.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.jeu.Lanceur;

/**
 * <b>Main est la classe lance le jeu en créant le lanceur du jeu</b>
 * 
 * @see Lanceur#Lanceur()
 * @see Lanceur#lancerJeu()
 *
 * @author Heidoji
 * @version 0.4.1
 */

public class Main {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("Entering application");
		
		Lanceur lanceur = new Lanceur();
		lanceur.lancerJeu();
		
		logger.info("Exiting application");
	}
	
	
}
