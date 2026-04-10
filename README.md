# TP noté de Java - 10 avril 2026
## Membres du groupes : Simon HERVÉ et Marine PACHY


Toutes les questions ont été complétées avec pour chacune une explication

### Partie 2.1

* On modifie le paramétre du fichier resourses > application.yml
    spawn-probability:
        ground: 0.6 en 0.65

* Il suffit de rajouter un étage dans le main
    floors.add(new Floor(i)); ce qui n'est pas trés pratique.
    Création d'une boucle for avec le nombre d'ascenseurs et d'étages stocké dans le fichiers resourses > application.yml

* On remplace le random.nextInt(4) par random.Config.getInt(key:"hotel.elevators")

* Création d'une fonction qui renvoie un booléan si l'ascenseur est complet

* On l'utilise dans la fonction loadPassengers(Floor floor)

### Partie 2.2

* Modification de la fonction requestElevator(List<Elevator>) avec les deux conditions
    Nous avons choisi le nombre d'étage dans la file de l'ascenseur comme comparaison pour l'affluence car c'est la valeur maximale du nombre de destination de l'ascenseur.

* Mise à jour des JavaDoc

### Partie 2.3

* Modification de la fonction generateTargetFloor() en enlevant le static et en modifiant les appelles de cette fonction dans cette classes


### Partie 2.4

* Pour tester si un ascenseur est pleins, il faut faire appelle à beaucoup d'autre fonctions Comme ajouter des gens à l'ascenseur...

* Pour resoudre ce probleme on creer un nouveaux constructeur qui prends une liste de passagers

* On fait plusieurs tests (deux differents, deux pareils)

### Partie 2.5

* On créé CrazyElevator par heritage de Elevator 

* Mise à jour de la fonction move() en ajoutant des probabilités

* Mise à jour de unloadPassengers(Floor floor) en ajoutant des probabilités

* Mise à jour de la fonction isFull() en supprimant tous les passagers si l'assenseur est plein

* Ajout d'un ascenseur fou dans le main. Avec un changement dans les id pour avoir la somme égal au parametre dans ressources

## Partie 2.6 

* On choisit de créer direction un Boolean (True vers le haut, False vesr le bas et Null pour inactif)
    Nous n'avons pas ajouté la direction des personnes car nous n'avons pas trouvé d'utilité à ce parametre

* Mise à jour de la fonction move() d'Elevator et CrazyElevator

* Ajout des fléches dans le tableau


