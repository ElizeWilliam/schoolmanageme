package lexicon.se;

import lexicon.se.data.PersonSequenser;
import lexicon.se.data.ToDoSequencer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ToDoSequencerTest {

    @Test
    public void testToDoId() {
        int numberOfTests =1000;
        ToDoSequencer.reset();

        for (int i=1; i < numberOfTests; i++)
            assertEquals("test ToDo",ToDoSequencer.nextToDoId(),i);


    }
    @Test
    public void testReset(){
        for (int i=0; i< 777;i++) {
            ToDoSequencer.reset();
            assertEquals("testReset", 1, ToDoSequencer.nextToDoId());


        }
    }

}
