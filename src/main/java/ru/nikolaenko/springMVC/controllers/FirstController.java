package ru.nikolaenko.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    //null params
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello: " + name + " " + surname);

        return "first/hello";
    }

    //error 400
    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam("name") String name,
                              @RequestParam("surname") String surname,
                              Model model) {
        //System.out.println("Bye-bye: " + name + " " + surname);
        model.addAttribute("message", "Bye-bye: " + name + " " + surname);

        return "first/goodbye";
    }
}
