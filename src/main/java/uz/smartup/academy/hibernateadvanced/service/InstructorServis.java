package uz.smartup.academy.studentmanagementsystem.service;
import uz.smartup.academy.studentmanagementsystem.dto.CourseDTO;
import uz.smartup.academy.studentmanagementsystem.dto.InstructorDTO;
import uz.smartup.academy.studentmanagementsystem.entity.Course;

import java.util.List;

public interface InstructorServis {

    void instructorPersist(InstructorDTO instructorDTO);

    InstructorDTO instructorFindById(int id);

    List<InstructorDTO> findInstructorByFirstName(String firstName);

    List<InstructorDTO> instructorAll();

    void instructorMerge(InstructorDTO instructorDTO);

    void instructorDeleteById(int id);

    void instructorAddCourse(CourseDTO courseDTO);

    List<CourseDTO> instructorAllCourse(int id);

    List<CourseDTO>findInstructorCourseBuTitle(int instructorId, String title);

    void instructorAddCourseSave(CourseDTO courseDTO);

}
