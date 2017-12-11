# OCR-Projet_3


Projet 3 du Parcours Java de OCR



---

## Explication

Creation de deux jeux en mode console :
* Recherche +/-
* Mastermind

### Recherche +/-
Le but  : découvrir la combinaison à x chiffres de l'adversaire (le défenseur). Pour ce faire, l'attaquant fait une proposition. Le défenseur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c'est le bon chiffre (=).

L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.

### Mastermind
Le but : découvrir la combinaison à x chiffres/couleurs de l'adversaire (le défenseur). Pour ce faire, l'attaquant fait une proposition. Le défenseur indique pour chaque proposition le nombre de chiffre/couleur de la proposition qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.

L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.

### Modes de jeu

Chaque jeu pourra être joué selon 3 modes :

* Mode challenger où vous devez trouver la combinaison secrète de l'ordinateur
* Mode défenseur où c'est à l'ordinateur de trouver votre combinaison secrète
* Mode duel où l'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné

Voici le fonctionnement normal attendu dans l'application :

Au démarrage, l'utilisateur doit choisir le jeu auquel il veut jouer parmi les choix proposés.
L'utilisateur sélectionne le jeu et le mode de son choix. L'application lance le jeu sélectionné.
L'utilisateur joue. S'il perd, l'application affiche la solution.

À la fin de la partie, l'utilisateur peut choisir :
* de rejouer au même jeu
* de lancer un autre jeu (retour à l'écran de choix des jeux du début)
* de quitter l'application

Il doit être possible de lancer l'application dans un mode "développeur". Dans ce mode la solution est affichée dès le début. Cela permet de tester le bon comportement de l'application en cas de bonne ou de mauvaise réponse de l'utilisateur. Ceci est à réaliser avec les mécanismes suivants :

* Passage d'un paramètre au lancement de l'application
* Propriété spécifique dans le fichier de configuration
* Un fichier de configuration (config.properties) permettra de paramétrer l'application, notamment :

Pour chaque jeu :
* le nombre de cases de la combinaison secrète
* le nombre d'essais possibles

Pour le Mastermind :
* le nombre couleur/chiffre utilisables (de 4 à 10)
* Un fichier de configuration (log4j.xml) permettra de paramétrer les logs de l'application. La gestion des logs se fera avec Apache Log4j.

---

## Compilation et lancement

### Sous Windows

Double cliquez sur OCR_3-Project.bat pour lancer le jeu.
Pour lancer le monde developpeur, Double cliquez sur OCR_3-Project - Dev.bat 

### Sous Linux

Dans le terminal, allez à la racine du dossier et écrivez :
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
* Ajout de la modification des paramètres de jeu

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
* DONE : Mise à jour de la Javadoc

### Version 0.4.2
* DONE : Génération de la Javadoc

### Version 0.5
* DONE : Implémentation de l'IA Mastermind
* DONE : Changement de Int à String des variables ChiffreSecret et ChiffreJoueur 

### Version 0.5.1
* DONE : Mise à jour de la Javadoc

### Version 1.0
* DONE : Création de l'executable

### Version 1.0.1
* BUG : Problème d'initialisation de l'IA

### Version 1.0.2
* DONE : Amélioration de MastermindComparer
* DONE : Correction Orthographique

### Version 1.0.3
* DONE : Correction de la méthode de compilation dans le README

---
