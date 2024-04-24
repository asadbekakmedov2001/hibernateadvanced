package uz.smartup.academy.hibernateadvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.smartup.academy.hibernateadvanced.service.InstructorService;

@Controller
@RequestMapping("/web/instructors")
public class InstructorWebController {
    private InstructorService service;

    public InstructorWebController(InstructorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getInstructors(Model model) {
        model.addAttribute("instructors", service.getInstructors());

        return "instructor_list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable long id) {
//        service.deleteInstructor(id);
        System.out.printf("Instructor with id %d is deleted%n", id);
        return "redirect:/web/instructors/";
    }
}
