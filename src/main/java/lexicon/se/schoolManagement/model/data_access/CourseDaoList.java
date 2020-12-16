package lexicon.se.schoolManagement.model.data_access;


import lexicon.se.schoolManagement.model.Course;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static List<Course> courses;

    public CourseDaoList() {
        courses = new LinkedList<>();
    }


    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course:courses) {
            if (course.getId() == id)
                return course;
        }
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> temp = new LinkedList<>();
        for (Course course:courses) {
            if (course.getStartDate().equals(date))
                temp.add(course);
        }
        return temp;
    }

    @Override
    public List<Course> findAll() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }
}
