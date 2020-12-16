package lexicon.se.schoolManagement.model.data_access;


import lexicon.se.schoolManagement.model.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);
    Course findById(int id);
    List<Course> findByDate(LocalDate date);
    List<Course>findAll();
    boolean removeCourse(Course course);


}
