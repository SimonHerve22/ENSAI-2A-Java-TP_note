# TP noté de Java - 10 avril 2026
## Membres du groupes : Simon HERVÉ et Marine PACHY

### Partie 2.1

* On modifie le paramétre du fichier resourses > application.yml
    spawn-probability:
        ground: 0.6 en 0.65

* Il suffit de rajouter un étage dans le main
    floors.add(new Floor(i)); ce qui n'est pas trés pratique.
    Création d'une boucle for avec le nombre d'ascenseurs et d'étages stocké dans le fichiers resourses > application.yml

*  on remplace le random.nextInt(4) par random.Config.getInt(key:"hotel.elevators)

* Création d'une fonction qui renvoie un booléan si l'ascenseurs est complet

* On l'utilise dans la fonction loadPassengers(Floor floor)

### Partie 2.2

* Modification de la fonction requestElevator(List<Elevator>) avec les deux conditions
    Nous avons choisit le nombre d'étage comme comparaisons car c'est la valeur maximale du nombre de destination de l'ascenseur.

* Mise à jour des JavaDoc

### Partie 2.3


### Question 4

### Question 5
