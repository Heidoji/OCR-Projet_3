package fr.ocr.joueur;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ocr.configuration.Configuration;
import fr.ocr.mode.Mode;

/**
 * <b>MastermindIA est la classe permettant de g�rer l'IA du jeu Mastermind</b>
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
	 * <b>Cette variable repr�sente la derni�re proposition de nombre propos�.</b>
	 * 
	 * @see MastermindIA#getLastChiffre()
	 * @see MastermindIA#setLastChiffre(int)
	 *
	 * @since 0.3
	 */
	private String lastChiffre;
	
	/**
	 * <b>Cet objet repr�sente la configuration du jeu.</b>
	 * 
	 * @see Configuration
	 * @see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @since 0.3
	 */
	private Configuration configuration = new Configuration();
	
	/**
	 * <b>Ce bool�en marque si l'initialisation de l'IA et de la liste des
	 * possisibilit� a �t� faire</b>
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
	 * <b>Retourne la derni�re proposition de nombre (ChiffreJoueur) propos�.</b> 
	 * 
	 * see MastermindIA#trouverChiffreSecret(String)
	 *
	 * @return la derni�re proposition de nombre (ChiffreJoueur) propos�
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
	 * <b>Permet la modification de la derni�re valeur propos� (ChiffreJoueur).</b> 
	 * 
	 * @param pChiffre
	 * 		La nouvelle valeur pour la derni�re proposition pour le ChiffreJoueur
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
	 * 		La nouvelle valeur du bool�en d'initialisation de l'IA
	 * 
	 * @since 0.5
	 */
	public void setInit(boolean pInit) {
		this.init = pInit;
	}
	
	//Autres Methodes
	//TODO Integrer le code pour l'IA du mastermind
	/**
	 * <b>M�thode prenant un r�sultat de comparaison et retournant une proposition
	 * de nombre pour d�couvrir le nombre secret.</b>
	 * 
	 * @param pResultat
	 * 		Le r�sultat suite � la comparaison entre le nombre secret et le nombre joueur
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
			logger.info("CLASSE MASTERMINDIA : Nettoyage de la liste des possibilit�s");
			nettoyage(pResultat);
		}
		
		this.setLastChiffre(genererRandomProposition());
			
		return this.getLastChiffre();
	}
	
	/**
     * <b> M�thode initialisant une list avec toutes les possibilit�s de jeu possibles</b>
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
     * <b> M�thode choisissant al�atoirement une possibilit� dans la liste et la retourne</b>
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
     * <b> M�thode comparant deux nombres et retourne une chaine avec le resultat</b>
     * 
     * <p>
     * Le resultat est compos� :
     * </p>
     * <ul>
     * <li>du nombre de chiffre bien plac�</li>
     * <li>du nombre de chiffre pr�sent</li>
     * </ul>
     * 
     * @param pChiffre1
     * 		Premi�re variable � comparer
     * 
     * @param pChiffre2
     * 		Deuxi�me variable � comparer
     * 
     * @return Le r�sultat de la comparaison
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    public String comparerChiffre(String pChiffre1, String pChiffre2) {
		String chiffre1Nettoy� = "";
		
		int bienPlace = 0;
		int present = 0;
		
		for (int i = 0; i < pChiffre2.length(); i++) {
            if (pChiffre1.charAt(i) == pChiffre2.charAt(i))
            	bienPlace++;
            if (chiffre1Nettoy�.indexOf(pChiffre1.charAt(i)) < 0)
            	chiffre1Nettoy� += pChiffre1.charAt(i);
        }
		
		for (int i = 0; i < pChiffre2.length(); i++) {
            if (chiffre1Nettoy�.indexOf(pChiffre1.charAt(i)) >= 0)
            	present++;
        }

		if (present - bienPlace < 0) 
			present = 0;
		else
			present -= bienPlace;
		
		return (bienPlace + "" + present);
	}
    
    /**
     * <b> M�thode enlevant de la liste les �lements ayant un r�sultat de comparaison diff�rent</b>
     * 
     * @param pResultat
     * 		Variable comprenant le r�sultat � comparer.
     * 
     * @see MastermindIA#trouverChiffreSecret(String)
     * 
     * @version 0.5
     */
    private void nettoyage(String pResultat) {

        // Enleve la proposition faite
        this.combinaisons.remove(this.combinaisons.indexOf(this.getLastChiffre()));

        // Enleve les proposition n'ayant pas le m�me resultat
        for(int i = 0; i < this.combinaisons.size(); i++) {
            if (!pResultat.equals(comparerChiffre(this.combinaisons.get(i), this.getLastChiffre()))) {
                this.combinaisons.remove(i);
            }
        }

    }
}
