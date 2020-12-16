package lexicon.se.schoolManagement.model.data_access;

import lexicon.se.schoolManagement.model.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class StudentDaoList implements StudentDao{
    private static List<Student> students;

    public StudentDaoList() {
        students = new LinkedList<>();
    }

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student student:students) {
            if (student.getEmail().equals(email))
                return student;
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> temp = new LinkedList<>();
        for (Student student:students)
            if (student.getName().equals(name))
                temp.add(student);
        return temp;
    }

    @Override
    public Student findById(int id) {
        for (Student student:students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }
}
