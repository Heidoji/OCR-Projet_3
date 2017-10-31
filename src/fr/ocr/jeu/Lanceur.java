package fr.ocr.jeu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.main.Main;
import fr.ocr.menu.ConfigMenu;
import fr.ocr.menu.FinMenu;
import fr.ocr.menu.JeuMenu;
import fr.ocr.menu.Menu;
import fr.ocr.mode.ChallengeMode;
import fr.ocr.mode.DefenseMode;
import fr.ocr.mode.DuelMode;
import fr.ocr.mode.Mode;

/**
 * <b>La classe Lanceur s'occupe de préparer le lancement du jeu</b>
 * <p>
 * Il gère :
 * <ul>
 * <li>l'affichage des menus</li>
 * <li>l'instanciation du mode de jeu</li>
 * <li>l'initialisation du jeu</li>
 * </p>
 * 
 * @see Lanceur#Lanceur()
 * @see Lanceur#LancerJeu()
 *
 * @author Heidoji
 * @since 0.2
 * @version 0.4
 */
public class Lanceur {
	/**
	 * <b>Cette variable initialise le logger de log4j2</b>
	 *
	 * @ since 0.4
	 */
	private static final Logger logger = LogManager.getLogger(Lanceur.class);
	
	/**
     * <b>Variable contenant l'objet Mode.</b>
	 * <p>
	 * Il permet de selection le type de mode de jeu choisis'
	 * Il exister 3 modes:
	 * <ul>
	 * <li> Le mode Challenge</li>
	 * <li> Le mode Defense</li>
	 * <li> Le mode Duel</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Lanceur#Lanceur()
	 * @see Lanceur#initialiserJeu()
	 * @see Lanceur#setMode()
	 * @see Mode#Mode()
	 *
	 * @since 0.2
	*/
	private Mode mode;
	
	/**
     * <b>Variable contenant l'objet Menu.</b>
	 * <p>
	 * Il permet de selection du menu a afficher'
	 * Il exister 3 menus:
	 * <ul>
	 * <li> Le menu principal</li>
	 * <li> Le mode de configuration</li>
	 * <li> Le mode de fin</li>
	 * </ul>
	 * </p>
	 * 
	 * @see Lanceur#lancerJeu()
	 * @see Menu
	 *
	 * @since 0.2
	*/
	private Menu menu;
	
	/**
     * <b>Variable contenant l'objet Configuration.</b>
	 * <p>
	 * Il permet de memoriser les preferences de l'utilisateur
	 * </p>
	 * 
	 * @see Lanceur#Lanceur()
	 * @see Lanceur#Lanceur(char, char, int, int, int, boolean)
	 * @see Lanceur#initialiserJeu()
	 * @see Menu
	 *
	 * @since 0.2
	*/
	private Configuration configuration;
	
	
	//Constructeurs
	
	/**
	 * <b>Constructeur vide Lanceur.</b>
	 * <p>
	 * Instancie le lancement du jeu en chargeant la configuration si elle est existe.
	 * Sinon, elle cree le fichier de configuration.
	 * </p>
	 * 
	 * @see Configuration#Configuration()
	 * @see Lanceur#Lanceur(char, char, int, int, int, boolean)
	 *
	 * @since 0.2
	 */
	public Lanceur() {
		logger.info("Entering Constructeur Lanceur");
		
		Path source = Paths.get("config.properties");
		if (Files.exists(source)) {
			logger.info("File config.properties exists");
			this.configuration = new Configuration();
		}
		else {
			logger.info("Create a new config.properties files");
			this.configuration = new Configuration('R', 'C', 4, 10, 4, false);
		}
	}
	
	/**
	 * <b>Constructeur Lanceur.</b>
	 * <p>
	 * Instancie le lancement du jeu en creant une nouvelle configuration avec les valeurs passees en parametre.
	 * </p>
	 *
	 * @param cJeu
	 * 		Donne la préférence du jeu joué
	 * @param cMode
	 * 		Donne la préférence du mode de jeu joué
	 * @param cEssai
	 * 		Donne le nombre d'essai possible pour découvrir le chiffre secret
	 * @param cCouleur
	 * 		Donne le nombre de couleur possible pour composer la combinaison dans le jeu Mastermind
	 * @param cChiffre
	 * 		Donne le nombre de chiffre ou couleur a decouvrir dans la combinaison secrète
	 * 
	 * @see Lanceur#Lanceur(char, char, int, int, int, boolean)
	 *
	 * @since 0.2
	 */
	public Lanceur(char cJeu, char cMode, int cEssai, int cCouleur, int cChiffre, boolean cModDev) {
		this.configuration = new Configuration(cJeu, cMode, cEssai, cCouleur, cChiffre, cModDev);
	}
	
	//Autres methodes
	
	/**
	 * <b>Methode gerant le lancement du jeu.</b>
	 * <p>
	 * Gere la selection des menus a travers de boucles.
	 * Appelle egalement l'initialisation du jeu.
	 * </p>
	 * 
	 * @see Lanceur#initialiserJeu()
	 * @see Menu#Menu()
	 * @see Menu#getChoix()
	 * @see Menu#afficheMenu()
	 * @see Menu#choisirMenu()
	 * @see ConfigMenu
	 * @see JeuMenu
	 * @see FinMenu
	 * @see Mode#sequenceJeu()
	 *
	 * @since 0.2
	 */
	public void lancerJeu() {
		logger.info("Entre dans la class lancerJeu");
		this.menu = new JeuMenu();
		
		while (this.menu.getChoix() != 'Q') {
			while (this.menu.getChoix() != 'Q' && this.menu.getChoix() != 'L') {
				this.menu.afficherMenu();
				this.menu.choisirMenu();
				
				if (this.menu.getChoix() == 'O') {
					this.menu = new ConfigMenu();
				}
				
				if (this.menu.getChoix() == 'R') {
					this.menu = new JeuMenu();
				}
			}
			
			if (this.menu.getChoix() == 'L') {
				logger.info("Lancement du jeu");
				this.menu = new FinMenu();
				this.initialiserJeu();
				this.mode.sequenceJeu();
			}
		}
	}
	
	/**
	 * <b>Methode initialisant le jeu.</b>
	 * <p>
	 * Recharge la configuration pour nitialiser le Mode.
	 * Remet a zero le nombre d'essai et le booleen indiquant que le chiffre est trouve
	 * </p>
	 * 
	 * @see Lanceur#setMode(char)
	 * @see Configuration
	 * @see Configuration#getMode()
	 * @see Jeu#setNbEssai(int)
	 * @see Jeu#setGagne(boolean)
	 *
	 * @since 0.2
	 */
	private void initialiserJeu() {
		logger.info("Initialisation du jeu");
		this.configuration = new Configuration();
		this.setMode(configuration.getMode());
		this.mode.jeu.setNbEssai(0);
		this.mode.jeu.setGagne(false);
	}
	
	/**
	 * <b>Methode modifiant le Mode de jeu.</b>
	 * <p>
	 * Recharge la configuration pour nitialiser le Mode.
	 * Remet a zero le nombre d'essai et le booleen indiquant que le chiffre est trouve
	 * </p>
	 * 
	 * @see Lanceur#setMode(char)
	 * @see Configuration
	 * @see Configuration#getMode()
	 * @see Jeu#setNbEssai(int)
	 * @see Jeu#setGagne(boolean)
	 *
	 * @param cMode
	 * 		La valeur char representant le type de mode de jeu.
	 * @since 0.2
	 */
	private void setMode(char cMode) {
		logger.info("Entre dans setMode de la class Lanceur");
		
		switch (cMode) {
		case 'C' : this.mode = new ChallengeMode();
				   break;
		case 'U' : this.mode = new DuelMode();
				   break;
		case 'D' : logger.info("Mode intancie en DefenseMode");
		           this.mode = new DefenseMode();
		}
		
		logger.debug("Mode choisi : " + cMode);
		logger.debug("Mode instancie " + this.mode.getClass());
	}
}