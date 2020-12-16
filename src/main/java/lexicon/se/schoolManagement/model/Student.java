package lexicon.se.schoolManagement.model;


public class Student {
    private int id;
    private static int nextFreeId = 1;
    private String name, email, address;

    public Student() {
        id = nextFreeId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
