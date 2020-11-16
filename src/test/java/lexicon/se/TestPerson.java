package lexicon.se;

import static org.junit.Assert.*;


import lexicon.se.model.Person;
import org.junit.Test;

public class TestPerson {


    @Test
    public void createPerson()
    {
       Person person=new Person(20,"William","Fransson");
        assertEquals("Test getFirstName","William",person.getFirstName());
        assertEquals("Test getLastName","Fransson",person.getLastName());
        assertEquals("Test getPersonalId",20, person.getPersonaId());
    }
}
