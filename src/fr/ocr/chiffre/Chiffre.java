package fr.ocr.chiffre;

import java.util.Random;

public class Chiffre {
	private String valeur;
	
	//Constructeur vide
	public Chiffre() {
		this.valeur = "";
	}
	
	//Constructeur 
	public Chiffre(String pValeur) {
		if (pValeur == "Random") {
			String random = "";
			Random rand = new Random();
			for(int i = 0 ; i < 4 ; i++) {
				random += rand.nextInt(9) + 1;
			}
			pValeur = random;
		}
		
		this.valeur = pValeur;
	}
	
	//Assesseurs
	public String getValeur() {
		return this.valeur;
	}
	
	//Mutateurs
	public void setValeur(String cValeur) {
		this.valeur = cValeur;
	}
	
	//Autres méthodes
	public String ComparaisonOrdonnee(Chiffre pChiffreSecret) {
		String str = "Réponse : ";
		String nombre[] = this.valeur.split("");
		String nombre_secret[] = pChiffreSecret.valeur.split("");
		
		for (int i=0 ; i < nombre.length ; i++) {
			if (Integer.parseInt(nombre[i]) > Integer.parseInt(nombre_secret[i]))
				str += "-";
			else if  (Integer.parseInt(nombre[i]) < Integer.parseInt(nombre_secret[i])) 
				str += "+";
			else
				str += "=";
		}
		
		return str;
	}
	
	public String ComparaisonDesordonnee(Chiffre pChiffreSecret) {
		String str = "Réponse : ";
		String nombre[] = this.valeur.split("");
		String nombre_secret[] = pChiffreSecret.valeur.split("");
		
		int bienPlace = 0;
		int present = 0;
		
		for (int i=0 ; i < nombre.length ; i++) {
			if (Integer.parseInt(nombre[i]) == Integer.parseInt(nombre_secret[i]))
				bienPlace++;
			
			for (int j=0 ; j < nombre.length ; j++) {
				if  (Integer.parseInt(nombre[i]) == Integer.parseInt(nombre_secret[j])) {
					present++;
					break;
				}
			}
		}
		
		if (present > 0)
			str += present + " présent" + (present > 1 ? "s" : "") + (bienPlace > 0 ? ", " : "");
		
		if (bienPlace > 0)
			str += bienPlace + " bien placé" + (bienPlace > 1 ? "s" : "");
		
		if ((present + bienPlace) == 0)
			str += "Aucun chiffre correct";
		
		return str;
	}
}

