package fr.ocr.joueur;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.mode.Mode;

/**
 * <b>MastermindIA est la classe permettant de gérer l'IA du jeu Mastermind</b>
 * 
 * @author Heidoji
 * @since 0.3
 * @version 0.5
 */
public class MastermindIA implements IA {
	/**
	 * <b>Cet variable initialise le logger de log4j2</b>
	 *
	 * @since 0.5
	 */
	private static final Logger logger = LogManager.getLogger(Mode.class);
	
	/**
	 * <b>Cette variable représente la dernière proposition de nombre proposé.</b>
	 * 
	 * @see MastermindIA#getLastChiffre()
	 * @see MastermindIA#setLastChiffre(int)
	 *
	 * @since 0.3
	 */
	private String lastChiffre;
	
	/**
	 * <b>Cet objet représente la configuration du jeu.</b>
	 * 
	 * @see Configuration
	 * @see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @since 0.3
	 */
	private Configuration configuration = new Configuration();
	
	/**
	 * <b>Ce booléen marque si l'initialisation de l'IA et de la liste des
	 * possisibilité a été faire</b>
	 * 
	 * @see MastermindIA#trouverChiffreSecret(String)
	 * 
	 * @since 0.5.0
	 */
	private boolean init = false;
	
	/**
	 * <b>Liste contenant tous les combinaisons possibles pour le Mastermind</b>
	 * 
	 * @see MastermindIA#genererCombinaisons()
	 * 
	 * @since 0.5.0
	 */
	private List<String> combinaisons = new LinkedList<String>();
	
	//Assesseurs	
	/**
	 * <b>Retourne la dernière proposition de nombre (ChiffreJoueur) proposé.</b> 
	 * 
	 * see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @return la dernière proposition de nombre (ChiffreJoueur) proposé
	 *
	 * @since 0.3
	 */
	public String getLastChiffre() {
		return this.lastChiffre;
	}
	
	/**
	 * <b>Retourne le boolean indiquant l'initialisation ou non de l'IA.</b> 
	 * 
	 * see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @return le boolean indiquant l'initialisation ou non de l'IA
	 *
	 * @since 0.5
	 */
	public boolean getInit() {
		return this.init;
	}
	
	//Mutateurs
	/**
	 * <b>Permet la modification de la dernière valeur proposé (ChiffreJoueur).</b> 
	 * 
	 * @param pChiffre
	 * 		La nouvelle valeur pour la dernière proposition pour le ChiffreJoueur
	 * 
	 * @since 0.3 
	 */
	public void setLastChiffre(String pChiffre) {
		this.lastChiffre = pChiffre;
	}
	
	/**
	 *  <b>Permet la modification du boolean d'initialisation de l'IA.</b>
	 *  
	 * @param pInit
	 * 		La nouvelle valeur du booléen d'initialisation de l'IA
	 * 
	 * @since 0.5
	 */
	public void setInit(boolean pInit) {
		this.init = pInit;
	}
	
	//Autres Methodes
	//TODO Integrer le code pour l'IA du mastermind
	/**
	 * <b>Méthode prenant un résultat de comparaison et retournant une proposition
	 * de nombre pour découvrir le nombre secret.</b>
	 * 
	 * @param pResultat
	 * 		Le résultat suite à la comparaison entre le nombre secret et le nombre joueur
	 * 
	 * @return la proposition faite par l'ordinateur
	 *
	 * @since 0.4.1
	 */
	public String trouverChiffreSecret(String pResultat) {
		System.out.println(pResultat);
		
		if (!init) { 
			logger.info("CLASSE MASTERMINDIA : initialisation de l'IA");
			this.genererCombinaisons();
			this.init = true;
		}
		else {
			logger.info("CLASSE MASTERMINDIA : Nettoyage de la liste des possibilités");
			nettoyage(pResultat);
		}
		
		this.setLastChiffre(genererRandomProposition());
			
		return this.getLastChiffre();
	}
	
	/**
     * <b> Méthode initialisant une list avec toutes les possibilités de jeu possibles</b>
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    private void genererCombinaisons() {
    	int chiffre = configuration.getChiffre();
    	int couleur = configuration.getCouleur();
    	int nbCombinations = (int) Math.pow(couleur, chiffre);

        for (int i = 0; i < nbCombinations; i++) {
            String combinaison = Integer.toString(i, couleur);
            while (combinaison.length() < chiffre) {
            	combinaison = "0" + combinaison;
            }
            combinaisons.add(combinaison);
        }
    }
    
    /**
     * <b> Méthode choisissant aléatoirement une possibilité dans la liste et la retourne</b>
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    private String genererRandomProposition() {

        int index = (int) (Math.random() * this.combinaisons.size());
        return this.combinaisons.get(index);
    }
    
    /**
     * <b> Méthode comparant deux nombres et retourne une chaine avec le resultat</b>
     * 
     * <p>
     * Le resultat est composé :
     * </p>
     * <ul>
     * <li>du nombre de chiffre bien placé</li>
     * <li>du nombre de chiffre présent</li>
     * </ul>
     * 
     * @param pChiffre1
     * 		Première variable à comparer
     * 
     * @param pChiffre2
     * 		Deuxième variable à comparer
     * 
     * @return Le résultat de la comparaison
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    public String comparerChiffre(String pChiffre1, String pChiffre2) {
		String chiffre1Nettoyé = "";
		
		int bienPlace = 0;
		int present = 0;
		
		for (int i = 0; i < pChiffre2.length(); i++) {
            if (pChiffre1.charAt(i) == pChiffre2.charAt(i))
            	bienPlace++;
            if (chiffre1Nettoyé.indexOf(pChiffre1.charAt(i)) < 0)
            	chiffre1Nettoyé += pChiffre1.charAt(i);
        }
		
		for (int i = 0; i < pChiffre2.length(); i++) {
            if (chiffre1Nettoyé.indexOf(pChiffre1.charAt(i)) >= 0)
            	present++;
        }

		if (present - bienPlace < 0) 
			present = 0;
		else
			present -= bienPlace;
		
		return (bienPlace + "" + present);
	}
    
    /**
     * <b> Méthode enlevant de la liste les élements ayant un résultat de comparaison différent</b>
     * 
     * @param pResultat
     * 		Variable comprenant le résultat à comparer.
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    private void nettoyage(String pResultat) {

        // Enleve la proposition faite
        this.combinaisons.remove(this.combinaisons.indexOf(this.getLastChiffre()));

        // Enleve les proposition n'ayant pas le même resultat
        for(int i = 0; i < this.combinaisons.size(); i++) {
            if (!pResultat.equals(comparerChiffre(this.combinaisons.get(i), this.getLastChiffre()))) {
                this.combinaisons.remove(i);
            }
        }

    }
}
