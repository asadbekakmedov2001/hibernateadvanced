package uz.smartup.academy.hibernateadvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandlingController {

    @RequestMapping("/access-denied")
    public String handleAccessDenied() {
        return "access_denied";
    }

}
