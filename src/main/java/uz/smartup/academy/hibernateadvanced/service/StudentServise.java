package uz.smartup.academy.studentmanagementsystem.service;



import uz.smartup.academy.studentmanagementsystem.dto.CourseDTO;
import uz.smartup.academy.studentmanagementsystem.dto.ReviewDTO;
import uz.smartup.academy.studentmanagementsystem.dto.StudentDTO;

import java.util.List;

public interface StudentServise {

    List<StudentDTO>  studentAll();

    List<StudentDTO> findStudentByFirstName(String firstName);

    void deleteStudent(int id);

    void enrollCourse(int id, int courseId);

    List<CourseDTO> getStudentCourses(int id);

    List<CourseDTO> getCourseFilteredStudentById(int id);

    void excludeStudentFromCourse(int id, int courseId);

    void addReview(int id, int courseId, ReviewDTO review);

    List<ReviewDTO> getReviews(int id, int courseId);

    void updateReview(int id, int courseId, ReviewDTO review);

}
