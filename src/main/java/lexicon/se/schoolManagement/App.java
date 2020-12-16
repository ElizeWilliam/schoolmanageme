package lexicon.se.schoolManagement;


import lexicon.se.schoolManagement.model.Course;
import lexicon.se.schoolManagement.model.Student;
import lexicon.se.schoolManagement.model.data_access.CourseDao;
import lexicon.se.schoolManagement.model.data_access.CourseDaoList;
import lexicon.se.schoolManagement.model.data_access.StudentDao;
import lexicon.se.schoolManagement.model.data_access.StudentDaoList;
import lexicon.se.schoolManagement.view.Console;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        CourseDao courseDao = new CourseDaoList();
        StudentDao studentDao = new StudentDaoList();

        while (!console.wantsToQuit()) {
            console.displayMenu();
            console.askUserForOption();
            if (console.wantsToCreate()) {
                console.displayCreateSubMenu();
                console.askUserForOption();
                if (console.wantsToCreateCourse()) {
                    Course course = new Course();
                    course.setCourseName(console.askUserForCourseName());
                    course.setStartDate(console.askUserForStartDate());
                    course.setWeekDuration(console.askUserForCourseDuration());
                    courseDao.saveCourse(course);
                }
                if (console.wantsToCreateStudent()) {
                    Student student = new Student();
                    student.setName(console.askForStudentName());
                    student.setAddress(console.askForStudentAddress());
                    student.setEmail(console.askForStudentEmail());
                    studentDao.saveStudent(student);
                }
            }
            if (console.wantsToRegister()) {
                console.displayRegisterSubMenu();
                console.askUserForOption();
                if (console.wantsToRegisterStudent()) {
                    courseDao.findById(console.askUserForCourseId())
                            .register(studentDao.findById(console.askUserForStudentId()));
                }
                if (console.wantsToRemoveStudent()) {
                    courseDao.findById(console.askUserForCourseId())
                            .unregister(studentDao.findById(console.askUserForStudentId()));
                }

            }
            if (console.wantsToFind()) {
                console.displayFindSubMenu();
                console.askUserForOption();
                if (console.wantsToFindStudent()) {
                    console.displayFindSubMenuStudent();
                    console.askUserForOption();
                    if (console.wantsToFindByID()) {
                        console.displayStudent(studentDao.findById(console.askUserForStudentId()));
                    }
                    if (console.wantsToFindByNameOrDate()) {
                        List<Student> students = studentDao.findByName(console.askForStudentName());
                        for (Student student: students) {
                            console.displayStudent(student);
                        }
                    }
                    if (console.wantsToFindByEmailOrAll()) {
                        console.displayStudent(studentDao.findByEmail(console.askForStudentEmail()));
                    }
                }
                if (console.wantsToFindCourse()) {
                    console.displayFindSubMenuCourse();
                    console.askUserForOption();
                    if (console.wantsToFindByID()) {
                        console.displayCourse(courseDao.findById(console.askUserForCourseId()));
                    }
                    if (console.wantsToFindByNameOrDate()) {
                        List<Course> courses = courseDao.findByDate(console.askUserForStartDate());
                        for (Course course: courses) {
                            console.displayCourse(course);
                        }
                    }
                    if (console.wantsToFindByEmailOrAll()) {
                        List<Course> courses = courseDao.findAll();
                        for (Course course: courses) {
                            console.displayCourse(course);

                        }
                    }
                }
            }
            if (console.wantsToEdit()) {
                console.displayEditSubMenu();
                console.askUserForOption();
                if (console.wantsToEditStudent()) {
                    Student student = studentDao.findById(console.askUserForStudentId());
                    if (student != null) {
                        student.setName(console.askForStudentName());
                        student.setAddress(console.askForStudentAddress());
                        student.setEmail(console.askForStudentEmail());
                    } else console.displayNotFound();
                }
                if (console.wantsToEditCourse()) {
                    Course course = courseDao.findById(console.askUserForCourseId());
                    if (course != null) {
                        course.setCourseName(console.askUserForCourseName());
                        course.setStartDate(console.askUserForStartDate());
                        course.setWeekDuration(console.askUserForCourseDuration());
                    } else console.displayNotFound();
                }
            }
        }
    }
}
