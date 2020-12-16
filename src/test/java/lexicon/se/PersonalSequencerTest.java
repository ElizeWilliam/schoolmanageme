package lexicon.se;

import static org.junit.Assert.*;

import lexicon.se.data.PersonSequenser;
import org.junit.Test;


public class PersonalSequencerTest {

    @Test
    public void testNextPersonId() {
        int numberOfTests =1000;
        PersonSequenser.reset();
        for (int i=1; i < numberOfTests; i++)
        assertEquals("test nextPersonId",PersonSequenser.nextPersonId(),i);
    }
    @Test
    public void testReset(){
        for (int i=0; i< 777;i++) {
            PersonSequenser.reset();
            assertEquals("testReset", 1, PersonSequenser.nextPersonId());
        }
    }

}
