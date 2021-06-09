package net.codejava.mbcwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String Welcome () {
        System.out.println("saying Welcome to Meet Base Camp ....");
        return "welcome.html";
    }

    @RequestMapping("/tips")
    public String Tips () {
        return "tips.html";
    }

    @RequestMapping("/testimonials")
    public String Testimonials () {
        return "testimonials.html";
    }

    @RequestMapping("/coursework")
    public String Coursework () {
        return "courseworkdetails.html";
    }
}

