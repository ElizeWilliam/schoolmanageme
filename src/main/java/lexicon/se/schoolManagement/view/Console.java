package lexicon.se.schoolManagement.view;

import lexicon.se.schoolManagement.model.Course;
import lexicon.se.schoolManagement.model.Student;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Console {
    private int option;

    public void displayMenu() {
        printStars();
        System.out.println("\nSchool Management");
        printStars();
        System.out.println("1.\tCreate new Courses and Students");
        System.out.println("2.\tRegister and remove Students to/from Courses");
        System.out.println("3.\tFinding Students and Courses in various ways");
        System.out.println("4.\tEdit Students and Courses");
        System.out.println("5.\tQuit");
        System.out.print("Enter option: ");
    }

    private void printStars() {
        System.out.println("*******************************************************\n");
    }

    public void askUserForOption() {
        option = askUserForInt();
    }
    private int askUserForInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean wantsToCreate() {
        return option == 1;
    }

    public boolean wantsToRegister() {
        return option == 2;
    }

    public boolean wantsToFind() {
        return option == 3;
    }

    public boolean wantsToEdit() {
        return option == 4;
    }

    public boolean wantsToQuit() {
        return option == 5;
    }

    public void displayCreateSubMenu() {
        System.out.println("\n\n1.\tCreate Course");
        System.out.println("2.\tCreate Student");
        System.out.println("Enter option: ");
    }

    public boolean wantsToCreateCourse() {
        return option == 1;
    }

    public String askUserForCourseName() {
        System.out.print("\nEnter a course name: ");
        return askUserString();
    }
    private String askUserString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LocalDate askUserForStartDate() {
        System.out.println("\nEnter a start date for the course");
        System.out.print("year: ");
        int year = askUserForInt();
        System.out.print("\nmonth: ");
        int month = askUserForInt();
        System.out.print("\nday: ");
        int day = askUserForInt();
        try{
            return LocalDate.of(year,month,day);
        } catch (DateTimeException e) {
            System.out.println("Invalid date!!!");
            return askUserForStartDate();
        }
    }

    public int askUserForCourseDuration() {
        System.out.println("\nEnter the duration of the course in weeks: ");
        return askUserForInt();
    }

    public boolean wantsToCreateStudent() {
        return option == 2;
    }


    public String askForStudentName() {
        System.out.println("\nEnter the name of the student: ");
        return askUserString();
    }

    public String askForStudentAddress() {
        System.out.println("\nEnter the students address: ");
        return askUserString();
    }

    public String askForStudentEmail() {
        System.out.println("\nEnter the students email: ");
        return askUserString();
    }
    public void displayRegisterSubMenu() {
        System.out.println("\n\n1.\tRegister Student");
        System.out.println("2.\tRemove Student");
        System.out.println("Enter option: ");
    }

    public boolean wantsToRegisterStudent() {
        return option == 1;
    }

    public int askUserForCourseId() {
        System.out.print("\nEnter course Id: ");
        return askUserForInt();
    }

    public int askUserForStudentId() {
        System.out.print("\nEnter student Id: ");
        return askUserForInt();
    }

    public boolean wantsToRemoveStudent() {
        return option == 2;
    }

    public void displayFindSubMenu() {
        System.out.println("\n\n1.\tFind Student");
        System.out.println("2.\tFind Course");
        System.out.println("Enter option: ");
    }
    public boolean wantsToFindStudent() {
        return option == 1;
    }

    public boolean wantsToFindCourse() {
        return option == 2;
    }

    public void displayFindSubMenuStudent() {
        System.out.println("\n\n1.\tFind by id");
        System.out.println("2.\tFind by name");
        System.out.println("3.\tFind by email");
        System.out.println("Enter option: ");
    }
    public void displayFindSubMenuCourse() {
        System.out.println("\n\n1.\tFind by id");
        System.out.println("2.\tFind by date");
        System.out.println("3.\tFind all");
        System.out.println("Enter option: ");
    }

    public boolean wantsToFindByID() {
        return option == 1;
    }
    public boolean wantsToFindByNameOrDate() {
        return option == 2;
    }
    public boolean wantsToFindByEmailOrAll() {
        return option == 3;
    }

    public void displayStudent(Student student) {
        System.out.println("\nStudent");
        printStars();
        System.out.println("Id     : " + student.getId());
        System.out.println(("Name  : " + student.getName()));
        System.out.println("Address: " + student.getAddress());
        System.out.println("Email  : " + student.getEmail());
    }

    public void displayCourse(Course course) {
        System.out.println("\nCourse");
        printStars();
        System.out.println("Id     : " + course.getId());
        System.out.println("Name  : " + course.getCourseName());
        System.out.println("Start date: " + course.getStartDate());
        System.out.println("Email  : " + course.getWeekDuration());
        System.out.println("Students: ");
        for (Student student: course.getStudents()) {
            System.out.println("Student Id: " + student.getId() + "\tstudent name: " + student.getName());
        }
    }

    public void displayEditSubMenu() {
        System.out.println("\n\n1.\tEdit Student");
        System.out.println("2.\tEdit Course");
        System.out.println("Enter option: ");
    }

    public boolean wantsToEditStudent() {
        return option == 1;
    }
    public boolean wantsToEditCourse() {
        return option == 2;
    }

    public void displayNotFound() {
        System.out.println("\nNo Student or Course with that id exists!!!");
    }
}
