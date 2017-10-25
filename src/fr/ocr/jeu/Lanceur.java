package fr.ocr.jeu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.ocr.configuration.Configuration;
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
 * @version 0.2
 */
public class Lanceur {
	private Mode mode;
	private Menu menu;
	private Configuration configuration;
	
	public Lanceur() {
		Path source = Paths.get("config.properties");
		if (Files.exists(source)) {
			this.configuration = new Configuration();
		}
		else {
			this.configuration = new Configuration('R', 'C', 4, 10, 4, false);
		}

		switch (configuration.getMode()) {
			case 'U' : this.mode = new DuelMode();
			           break;
			case 'C' : this.mode = new ChallengeMode();
					   break;
			case 'D' : this.mode = new DefenseMode();
		}
	}
	
	public Lanceur(char cJeu, char cMode, int cEssai, int cCouleur, int cChiffre, boolean cModDev) {
		this.configuration = new Configuration(cJeu, cMode, cEssai, cCouleur, cChiffre, cModDev);
		switch (cMode) {
			case 'U' : this.mode = new DuelMode();
					   break;
			case 'C' : this.mode = new ChallengeMode();
					   break;
			case 'D' : this.mode = new DefenseMode();
		}
	}
	
	public void lancerJeu() {
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
				this.menu = new FinMenu();
				this.initialiserJeu();
				this.mode.sequenceJeu();
			}
		}
	}
	
	public void initialiserJeu() {
		this.mode.jeu.setNbEssai(0);
		this.mode.jeu.setGagne(false);
	}
}