package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorTest {

    @Test
    /*
    Tests whether an elevator considers itself full if the capacity is maxed.
    */
    void testIsFull(){

        // GIVEN
        Person p1 = new Person(0);
        Person p2 = new Person(0);
        Person p3 = new Person(0);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(p1);
        listPerson.add(p2);
        listPerson.add(p3);
        Elevator e1 = new Elevator(1, 0, 3, listPerson);

        // THEN
        assertTrue(e1.isFull());
    }

    @Test
    /*
    Tests whether an elevator doesn't consider itself full if the capacity isn't maxed.
    */
    void testIsNotFull(){

        // GIVEN
        Person p4 = new Person(0);
        Person p5 = new Person(0);
        List<Person> listPerson2 = new ArrayList<>();
        listPerson2.add(p4);
        listPerson2.add(p5);
        Elevator e2 = new Elevator(2, 0, 3, listPerson2);

        // THEN
        assertFalse(e2.isFull());
    }

    @Test
    /*
    Tests everything that should happen when we add a destination to an elevator.
    */
    void testAddDestination(){

        // GIVEN
        Elevator e3 = new Elevator(3, 0, 3);
        int destination1 = 3;
        int destination2 = 4;

        // WHEN
        e3.addDestination(destination1);

        // THEN
        assertEquals(1, e3.getDestinationQueueSize());
        assertTrue(e3.containDestination(destination1));
        assertFalse(e3.containDestination(destination2));
    }

    @Test
    /*
    Tests everything that should happen when we add TWICE the same destination to an elevator.
    */
    void testAddTwiceSameDestination(){

        // GIVEN
        Elevator e3 = new Elevator(3, 0, 3);
        int destination1 = 3;
        int destination2 = 4;

        // WHEN
        e3.addDestination(destination1);
        e3.addDestination(destination1);

        // THEN
        assertEquals(1, e3.getDestinationQueueSize());
        assertTrue(e3.containDestination(destination1));
        assertFalse(e3.containDestination(destination2));
    }

    @Test
    /*
    Tests everything that should happen when we add two destinations to an elevator.
    */
    void testAddTwoDestinations(){

        // GIVEN
        Elevator e3 = new Elevator(3, 0, 3);
        int destination1 = 3;
        int destination2 = 4;

        // WHEN
        e3.addDestination(destination1);
        e3.addDestination(destination2);

        // THEN
        assertEquals(2, e3.getDestinationQueueSize());
        assertTrue(e3.containDestination(destination1));
        assertTrue(e3.containDestination(destination2));
    }

}
