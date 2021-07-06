package net.codejava.mbcwebapp;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ApplicationRepository appRepo;

    @Autowired
    private TestimonialsService testimonalsService;

    @Autowired
    private TipRepository tipRepo;

    @Autowired
    private TipService tipService;

    @Autowired
    private TestimonialRepository testRepo;
//    @GetMapping("")
//    public String viewHomePage() {
//        return "index";
//    }
    @RequestMapping("")
    public String Welcome (@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        System.out.println("saying Welcome to Meet Base Camp ....");
        return "welcome.html";
    }


    @GetMapping("/coursework")
    public String Coursework (@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("role", userDetails.getRole());

        return "courseworkdetails.html";
    }

    @GetMapping("/apply")
    public String Application (@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("role", userDetails.getRole());


        return "application.html";
    }

    @PostMapping("/application_submitted")
    public String processApplication(Application application, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        Long userId = userDetails.getUserId();
        model.addAttribute("role", userDetails.getRole());
        application.setUserid(userId);
        appRepo.save(application);
        return "application_success";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/users")
    public String showHome(Model model) {
        return "welcome.html";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @RequestMapping("/testimonials")
    public String viewHomePage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        List<Testimonials> listTestimonials = testimonalsService.findAll();
        model.addAttribute("listTestimonials", listTestimonials);
        model.addAttribute("role", userDetails.getRole());
        return "testimonials";
    }

    @RequestMapping("/new_testimonial")
    public String showNewTestimonialPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        Testimonials testimonials = new Testimonials();
        model.addAttribute("testimonials", testimonials);

        return "new_testimonial";
    }

    @RequestMapping(value = "/save_testimonial", method = RequestMethod.POST)
    public String save(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute("testimonials") Testimonials testimonials) {
        testRepo.save(testimonials);

        return "redirect:/testimonials";
    }

    @RequestMapping("/tips")
    public String viewTips(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        List<Tip> listTips = tipRepo.findAll();
        model.addAttribute("listTips", listTips);
        return "tips";
    }

    @RequestMapping(value = "/save_tip", method = RequestMethod.POST)
    public String save(@ModelAttribute("tip") Tip tip, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        tipRepo.save(tip);

        return "redirect:/tips";
    }

    @RequestMapping("/new_tip")
    public String showNewTipPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        Tip tip = new Tip();
        model.addAttribute("tip", tip);

        return "new_tip";
    }
}

