package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CrazyElevator extends Elevator {

    private static final Logger logger = LogManager.getLogger(CrazyElevator.class);

    private static Random random = new Random();

    public CrazyElevator(int id, int startFloor, int capacity){
        super(id, startFloor, capacity);
    }

    @Override
    /**
     * MOVES IN A CRAZY WAY !
     * One chance out of three : the elevator doesn't move.
     * One chance out of three : the elevator does what it's supposed to do, and goes to the next floor.
     * One chance out of three : the elevator skips a destination !
     * Removes that floor from the queue.
     * Indicates if the elevator is going up (Boolean.TRUE), down (Boolean.FALSE) or is idle (null).
     */
    public void move() {
        int originalFloor = this.currentFloor;
        int tirage1 = random.nextInt(3); /* nombre entre 0 et 2, pour générer un des trois cas possibles */
        logger.info("destinationQueue.size = {}, passengers = {}, tirage1 = {}",
                    destinationQueue.size(),
                    passengers,
                    tirage1);
        /* minimum deux destinations, pour pouvoir en supprimer assez */
        if (tirage1 == 2 && !destinationQueue.isEmpty())
            this.currentFloor = destinationQueue.removeFirst();
        if (tirage1 == 1 && destinationQueue.size()>=2) {
            this.currentFloor = destinationQueue.removeFirst();
            this.currentFloor = destinationQueue.removeFirst();
    
            /* si on tire 0, on ne bouge pas (if tirage == 0) */
        }
        if (this.currentFloor < originalFloor) this.direction = Boolean.FALSE;
        if (this.currentFloor > originalFloor) this.direction = Boolean.TRUE;
        if (this.currentFloor == originalFloor) this.direction = null;
    }

    @Override
    /**
     * Unloads passengers whose target floor matches the current floor... if the crazy elevator wants to, half of the time.
     * Updates the last unloaded list.
     * 
     * @param floor the Floor where passengers might exit
     * @return the number of passengers unloaded
     */
    public int unloadPassengers(Floor floor) {
        this.lastUnloaded.clear();
        int tirage2 = random.nextInt(2); /* nombre entre 0 et 1, pour générer un des deux cas possibles */
        logger.info("tirage2 = {}",
                    tirage2);
        if (tirage2 == 1){

            List<Person> remaining = new ArrayList<>();

            for (Person p : this.passengers) {
                if (p.getTargetFloor() == floor.getNumber()) {
                    this.lastUnloaded.add(p);
                    logger.info("Floor {}: {}{} leaves Elevator {}",
                            floor.getNumber(),
                            p.getNickname(),
                            p.getTargetFloor(),
                            this.id);
                } else {
                    remaining.add(p);
                }
            }
            this.passengers = remaining;
            return this.lastUnloaded.size();
        }
        /* si tirage = 0, alors les passagers ne sont pas descendus ! */
        return 0;
    }

    @Override
    /**
     * Checks if the elevator is full.
     * If the elevator is full, sends its passengers into another dimension (death, probably).
     * @return boolean : true if the elevator is full, false otherwise
     */
    public boolean isFull(){
        if (this.passengers.size() == this.capacity){
            passengers.clear();
            System.out.println("L'ascenseur fou est plein... pardon, ÉTAIT plein.");
            return true;
        }
        return false;
    }
}
