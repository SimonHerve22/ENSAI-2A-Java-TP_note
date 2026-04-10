# TP noté de Java - 10 avril 2026
## Membres du groupes : Simon HERVÉ et Marine PACHY

Toutes les questions ont été complétées, avec pour chacune une explication sur comment nous l'avons réalisé.

### Partie 2.1

* On modifie le paramétre du fichier resources > application.yml
    spawn-probability:
        ground: 0.6 -> 0.65

* Actuellement, la méthjode utilisée est "floors.add(new Floor(numero));" pour chaque ascenseur à créer, ce qui n'est pas trés pratique.
    -> Création d'une boucle for, avec le nombre d'ascenseurs et d'étages stocké dans le fichiers resources > application.yml

* Dans la classe Person : on remplace le random.nextInt(4) par random.Config.getInt(key:"hotel.elevators").

* Création d'une fonction isFull() qui renvoie un boolean si l'ascenseur est complet (this.passengers.size() == this.capacity)

* Cette fonction est réutilisée dans la fonction loadPassengers(Floor floor), qui vérifie si l'ascenseur n'est pas plein avant de charger des passagers supplémentaires.

### Partie 2.2

* Modification de la fonction requestElevator(List<Elevator>) avec les deux conditions demandées.
    Nous avons choisi le nombre d'étages dans la file de l'ascenseur comme comparaison pour l'affluence, car un ascenseur ne peut pas avoir plus de destinations qu'il n'y a d'étages dans l'hôtel (à part s'il décide d'avoir une destination sur un étage qui n'existe pas, ou une destination en double, ce qui serait un problème).

* JavaDoc mis à jour (comme sur les autres questions dès que nécessaires).

### Partie 2.3

* Modification de la fonction generateTargetFloor() en enlevant le static et en modifiant les appels de cette fonction dans cette classe. Désormais, l'étage visé est retiré au sort dès lors qu'il est égal à l'étage de départ.


### Partie 2.4

* Pour tester si un ascenseur est plein, il faut faire appel à beaucoup d'autres fonctions, notamment ajouter des gens à l'ascenseur... Il est assez difficile de contrôler en temps réel le nombre de personnes dans un ascenseur.

* Pour resoudre ce problçme, nous avons créé un nouveau constructeur qui prend directement une liste de passagers. Cela va nous simplifier les tests.

* Cinq tests réalisés : pour isFull(), nous testons les cas où il doit être plein et où il ne doit pas être plein. Pour addDestination(), nous testons les cas où nous ajoutons une destination, deux destinations, et deux fois la même destination.

### Partie 2.5

* On crée la classe CrazyElevator par héritage de Elevator.

* Mise à jour de la fonction move() en ajoutant les différents cas de figures. Un nombre entier est tiré au sort pour simuler les trois cas de figure à probabilité égale. Nous simulons le passage à la destination d'après en supprimant deux fois le premier indice via destinationQueue.removeFirst().

* Mise à jour de unloadPassengers(Floor floor) : une fois sur deux, il ne décharge pas ses passagers.

* Mise à jour de la fonction isFull() : renvoie true si l'ascenseur était plein, mais n'oublie pas de supprimer les membres de l'ascenseur avant. Sinon, false.

* Ajout d'ascenseurs fous dans le main, en ajoutant une variable dans application.yml pour configurer le nombre d'ascenseurs fous.

## Partie 2.6 

* On crée la variable direction, en ayant choisi un type Boolean (BOOLEAN.True vers le haut, BOOLEAN.False vers le bas et null pour inactif) -> pour prendre en compte la valeur null.
    Nous n'avons pas ajouté la direction des personnes car nous n'avons pas trouvé d'utilité à ce paramètre (nous n'affichons que la direction de l'ascenseur au final...)

* Mise à jour de la fonction move() d'Elevator et CrazyElevator pour modifier la direction de l'ascenseur

* Ajout des fléches dans le tableau, en modifiant la classe Hotel et en ajoutant dans Elevator une fonction showDirection() renvoyant un String correspondant à la direction. Cela permet à la fonction display() dans Hotel d'afficher la direction !


