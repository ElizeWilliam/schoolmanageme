package lexicon.se.data;

public class PersonSequenser {
    private static int personId = 0;

    public static int nextPersonId() {
        return ++personId;
    }

    public static void reset() {
        personId = 0;
    }
}
