# OCR-Projet_3


Projet 3 du Parcours Java de OCR



---

## Explication

Creation de deux jeux en mode console :
* Recherche +/-
* Mastermind

### Recherche +/-
Le but  : d�couvrir la combinaison � x chiffres de l'adversaire (le d�fenseur). Pour ce faire, l'attaquant fait une proposition. Le d�fenseur indique pour chaque chiffre de la combinaison propos�e si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c'est le bon chiffre (=).

L'attaquant doit deviner la combinaison secr�te en un nombre limit� d'essais.

### Mastermind
Le but : d�couvrir la combinaison � x chiffres/couleurs de l'adversaire (le d�fenseur). Pour ce faire, l'attaquant fait une proposition. Le d�fenseur indique pour chaque proposition le nombre de chiffre/couleur de la proposition qui apparaissent � la bonne place et � la mauvaise place dans la combinaison secr�te.

L'attaquant doit deviner la combinaison secr�te en un nombre limit� d'essais.

### Modes de jeu

Chaque jeu pourra �tre jou� selon 3 modes :

* Mode challenger o� vous devez trouver la combinaison secr�te de l'ordinateur
* Mode d�fenseur o� c'est � l'ordinateur de trouver votre combinaison secr�te
* Mode duel o� l'ordinateur et vous jouez tour � tour, le premier � trouver la combinaison secr�te de l'autre a gagn�

Voici le fonctionnement normal attendu dans l'application :

Au d�marrage, l'utilisateur doit choisir le jeu auquel il veut jouer parmi les choix propos�s.
L'utilisateur s�lectionne le jeu et le mode de son choix. L'application lance le jeu s�lectionn�.
L'utilisateur joue. S'il perd, l'application affiche la solution.

� la fin de la partie, l'utilisateur peut choisir :
* de rejouer au m�me jeu
* de lancer un autre jeu (retour � l'�cran de choix des jeux du d�but)
* de quitter l'application

Il doit �tre possible de lancer l'application dans un mode "d�veloppeur". Dans ce mode la solution est affich�e d�s le d�but. Cela permet de tester le bon comportement de l'application en cas de bonne ou de mauvaise r�ponse de l'utilisateur. Ceci est � r�aliser avec les m�canismes suivants :

* Passage d'un param�tre au lancement de l'application
* Propri�t� sp�cifique dans le fichier de configuration
* Un fichier de configuration (config.properties) permettra de param�trer l'application, notamment :

Pour chaque jeu :
* le nombre de cases de la combinaison secr�te
* le nombre d'essais possibles

Pour le Mastermind :
* le nombre couleur/chiffre utilisables (de 4 � 10)
* Un fichier de configuration (log4j.xml) permettra de param�trer les logs de l'application. La gestion des logs se fera avec Apache Log4j.

---

## Compilation et lancement

### Sous Windows

Double cliquez sur OCR_3-Project.bat pour lancer le jeu.
Pour lancer le monde developpeur, Double cliquez sur OCR_3-Project - Dev.bat 

### Sous Linux

Dans le terminal, allez � la racine du dossier et �crivez :
java -jar OCR-Projet_3.jar 0 pour le mode normal
java -jar OCR-Projet_3.jar 1 pour le mode developpeur

---

## Log

### Version 0.0.1

* Core game design done

### Version 0.1
* Ajout des annotations pour la Javadoc
* Ajout du menu
* Ajout du menu de configuration de sauvegarde
* Ajout de la sauvegarde de la configuration
* Ajout du mode de jeu
* Ajout du choix du jeu
* Ajout de la modification des param�tres de jeu

### Version 0.2
* Refonte de la structure du programme
* Rajout du plan UML du programme
* TODO : Finir la javadoc
* TODO : Gestion des exceptions
* TODO : Implentation de l'IA pour la recherche du Chiffre Secret
* TODO : Implementation de log4j
* TODO : Ajout de la prise en compte des arguments en ligne de commande
* BUG : Egalite entre configuration.getJeu() et 'M' ou 'R'

### Version 0.3
* DONE : Prise en compte de l'argument configuration.couleur et configuration.chiffre pour la generation automatique du chiffre secret
* DONE : Mise en place d'un texte explicatif avant l'input du chiffre joueur
* DONE : Checking du nommbre rentre par le joueur en conformite avec configuration.couleur et configuration.chiffre
* DONE : Refactoring de l'affichage des textes 
* DEBUG : Egalite entre configuration.getJeu() et 'M' ou 'R'
* DEBUG : Initialisation de la configuration au demarage pour le changement de mode

### Version 0.4
* DONE : Retirer getChiffre() de la Class Mode
* DONE : Retirer setChiffre() de la Class Mode
* DONE : Retirer getCouleur() de la Class Mode
* DONE : Retirer setCouleur() de la Class Mode
* DONE : Javadoc fait pour les packages Menu, Mode et Joueur
* DONE : Mise en place de log4j2 pour Main, Configuration, Menu, Mode et Joueur

### Version 0.4.1
* DONE : Mise � jour de la Javadoc

### Version 0.4.2
* DONE : G�n�ration de la Javadoc

### Version 0.5
* DONE : Impl�mentation de l'IA Mastermind
* DONE : Changement de Int � String des variables ChiffreSecret et ChiffreJoueur 

### Version 0.5.1
* DONE : Mise � jour de la Javadoc

### Version 1.0
* DONE : Cr�ation de l'executable

### Version 1.0.1
* BUG : Probl�me d'initialisation de l'IA

### Version 1.0.2
* DONE : Am�lioration de MastermindComparer
* DONE : Correction Orthographique

### Version 1.0.3
* DONE : Correction de la m�thode de compilation dans le README

---
