package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElevatorTest {

    @Test
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

}
