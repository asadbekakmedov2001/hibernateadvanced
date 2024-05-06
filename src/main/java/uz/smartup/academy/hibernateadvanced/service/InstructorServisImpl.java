package uz.smartup.academy.hibernateadvanced.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.smartup.academy.studentmanagementsystem.dao.AppDAO;
import uz.smartup.academy.studentmanagementsystem.dto.CourseDTO;
import uz.smartup.academy.studentmanagementsystem.dto.CourseDTOUtil;
import uz.smartup.academy.studentmanagementsystem.dto.InstructorDTO;
import uz.smartup.academy.studentmanagementsystem.dto.InstructorDTOUtil;
import uz.smartup.academy.studentmanagementsystem.entity.Course;
import uz.smartup.academy.studentmanagementsystem.entity.Instructor;

import java.util.List;

@Service
public class InstructorServisImpl implements InstructorServis{

   InstructorDTOUtil instructorDTOUtil;
   AppDAO appDAO;
   CourseDTOUtil courseDTOUtil;
    public InstructorServisImpl(InstructorDTOUtil instructorDTOUtil, AppDAO appDAO, CourseDTOUtil courseDTOUtil) {
        this.instructorDTOUtil = instructorDTOUtil;
        this.appDAO = appDAO;
        this.courseDTOUtil=courseDTOUtil;
    }

    public InstructorDTO instructorFindById(int id){
        InstructorDTO instructorDTO=instructorDTOUtil.toDTO(appDAO.instructorFindBuId(id));
        if(instructorDTO==null)
            return null;
        return instructorDTO;
    }

    @Override
    public List<InstructorDTO> findInstructorByFirstName(String firstName) {
        List<Instructor> instructors = appDAO.findInstructorByFirstname(firstName);
        return instructorDTOUtil.toDTOS(instructors);
    }

    @Override
    public List<InstructorDTO> instructorAll() {
       List<Instructor> instructors=appDAO.instructorAll();
        return instructorDTOUtil.toDTOS(instructors);
    }

    @Transactional
    @Override
    public void instructorMerge(InstructorDTO instructorDTO) {
        Instructor instructor=appDAO.instructorFindBuId(instructorDTO.getId());
        //System.out.println(instructor);
        appDAO.instructorMerge(instructorDTOUtil.toEntity(instructor,instructorDTO));

    }

    @Transactional
    @Override
    public void instructorPersist(InstructorDTO instructorDTO) {
        appDAO.instructorPersist(instructorDTOUtil.toEntity(instructorDTO));
    }

    @Transactional
    @Override
    public void instructorDeleteById(int id) {
        appDAO.instructorDeleteById(id);
    }

    @Override
    public void instructorAddCourse(CourseDTO courseDTO) {
//        Course course=
//        appDAO.instructorAddCourse();
    }

    @Override
    public List<CourseDTO> instructorAllCourse(int id) {
        List<Course> courses=appDAO.instructorAllCourse(id);
        return courseDTOUtil.toDTOs(courses);
    }

    @Override
    public List<CourseDTO> findInstructorCourseBuTitle(int instructorId, String title) {
        List<Course> courses = appDAO.findInstructorCourseBuTitle(instructorId, title);
        return courseDTOUtil.toDTOs(courses);
    }

    @Transactional
    @Override
    public void instructorAddCourseSave(CourseDTO courseDTO) {
        Course course=courseDTOUtil.toEntity(courseDTO);
        Instructor instructor=appDAO.instructorFindBuId(courseDTO.getInstructorId());
        course.setInstructor(instructor);
        appDAO.instructorAddCourseSave(course);
    }
}
