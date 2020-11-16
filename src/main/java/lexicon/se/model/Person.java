package lexicon.se.model;

public class Person {
    private final int personaId;
    private String firstName, lastName;

    public Person(int personaId, String firstName, String lastName) {
        this.personaId = personaId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPersonaId() {
        return personaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
