package lexicon.se.schoolManagement.model;


import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Course {
    private int id;
    private static int nextFreeID = 1;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course() {
        students = new LinkedList<>();
        id = nextFreeID++;
    }

    public void register(Student student) {
        students.add(student);
    }

    public void unregister(Student student) {
        students.remove(student);
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }


    public List<Student> getStudents() {  //
        return Collections.unmodifiableList(students);
    }

}
