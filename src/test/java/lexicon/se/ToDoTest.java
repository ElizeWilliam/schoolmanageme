package lexicon.se;
import static org.junit.Assert.*;
import lexicon.se.model.Person;
import lexicon.se.model.ToDo;
import org.junit.Test;


public class ToDoTest {
    ToDo toDo =new ToDo(79,"i should study");

    //Test constructor
    @Test
    public void createToDo()
    {
        assertEquals("Test getToDoId",79,toDo.getTodoId());
        assertEquals("Test getDescription","i should study",toDo.getDescription());

    }
    public void testToDo() {

        //Test getAssignee if empty
        assertEquals("Test getAssignee = null", null,toDo.getAssignee());

        //test if getassignee returns person set
        Person person = new Person(83, "Sara", "Iranshahi");
        toDo.setAssignee(person);
        assertEquals("Test getAssignee = person", person,toDo.getAssignee());

        //test if getAssignee return updated person
        Person person2 = new Person(83, "Elize", "Fransson");
        toDo.setAssignee(person);
        assertEquals("Test getAssignee = person2", person2,toDo.getAssignee());

        //Test isDone
        assertEquals("test isDone",false,toDo.isDone());
        toDo.setDone(true);
        assertEquals("test isDone",true,toDo.isDone());
        toDo.setDone(false);
        assertEquals("test isDone",false,toDo.isDone());
    }

}
