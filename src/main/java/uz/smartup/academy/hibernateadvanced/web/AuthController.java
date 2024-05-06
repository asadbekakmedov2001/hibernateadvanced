package uz.smartup.academy.studentmanagementsystem.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.smartup.academy.studentmanagementsystem.service.InstructorServis;
import uz.smartup.academy.studentmanagementsystem.service.StudentServise;


@Controller
public class AuthController {


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    private UserDetails getLoggetInUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return (UserDetails) principal;
        }
        return null;
    }

    @RequestMapping("/")
    public String index() {
        UserDetails userDetails = getLoggetInUser();

        return "index";
    }
}
