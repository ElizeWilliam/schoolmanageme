package lexicon.se.data;

public class ToDoSequencer {
    private static int toDoId = 0;

    public static int nextToDoId() {
        return ++toDoId;
    }

    public static void reset() {
        toDoId = 0;
    }
}
