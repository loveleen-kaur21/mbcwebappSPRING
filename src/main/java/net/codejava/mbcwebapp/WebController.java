package net.codejava.mbcwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepo;


    @RequestMapping("")
    public String viewHomePage() {
        return "index";
    }
    @RequestMapping("/welcome")
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

    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }
}

