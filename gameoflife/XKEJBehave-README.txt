XKE JBEHAVE sujet 
-----------------

Notes :
Le hands on est découpé en 8 parties permettant de faire un tour (presque) exhaustif de JBehave.
Chaque partie est dans un package dédié.
La solution se trouve toujours dans le sous package finished.
La partie suivante redémarre généralement de celle en cours (mais pas tout le temps)



Part 1:
-------
Objectif : lancer une première story simple

Initialisation simple de JBehave :
 - Création d'une JUnitStory
 - Création des annotations pour lire le fichier


Part 2:
-------
Objectif : lancer plusieurs story simple, et sortir les ressources dans src/test/resources

Jeu de plusieurs stories dans un même test JUNIT :
 - Création d'une deuxième story avec une cellule vivante initialisée
 - Changement de JunitStory en JunitStories
 - Déplacement des stories dans le répertoire src/test/resources


Part 3:
-------
Objectif : voir quelques premières possibilité d'interprétation des stories


 - Ajout d'une table de paramètre dans les tests
 - Ajout d'un alias pour reconnaitre un step sous plusieurs syntaxes


Part 4 :
--------
Objectif : Faire une représentation sympa de l'état de la grille en fin de story 

 - Implémentation de la représentation de la grille sous forme de chaine
 - Ajout d'une validation de l'état final


Part 5 :
--------
Objectif : Composition des stories

 - Ajout de plusieurs round avec un même état initial externalisé


Part 6 :
--------
Objectif : Generation des rapports


Part 7 :
--------
Objectif : Classification des stories en fonction de meta données

 - ajout d'un JUnitMaps 


Part 8 :
--------
Objectif : Faire des stories en français !!

 - Ajout d'un keyset localisé


Extras :
---------------------------
Configuration par annotation (dans le projet)
présentation Jbehave web





