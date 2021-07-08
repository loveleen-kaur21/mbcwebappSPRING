package net.codejava.mbcwebapp;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ApplicationService appService;

    @RequestMapping("")
    public String Welcome (@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        System.out.println("saying Welcome to Meet Base Camp ....");
        return "welcome.html";
    }


    @GetMapping("/coursework")
    public String Coursework (Model model) {

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
        application.setStatus("submitted");
        application.setFullName(application.getFirstName() + " " + application.getLastName());
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
    public String viewHomePage(Model model) {
        List<Testimonials> listTestimonials = testimonalsService.findAll();
        model.addAttribute("listTestimonials", listTestimonials);
        return "testimonials";
    }

    @RequestMapping("/new_testimonial")
    public String showNewTestimonialPage(Model model) {
        Testimonials testimonials = new Testimonials();
        model.addAttribute("testimonials", testimonials);

        return "new_testimonial";
    }

    @RequestMapping(value = "/save_testimonial", method = RequestMethod.POST)
    public String save(@ModelAttribute("testimonials") Testimonials testimonials) {
        testRepo.save(testimonials);

        return "redirect:/testimonials";
    }

    @RequestMapping("/tips")
    public String viewTips(Model model) {
        List<Tip> listTips = tipRepo.findAll();
        model.addAttribute("listTips", listTips);
        return "tips";
    }

    @RequestMapping(value = "/save_tip", method = RequestMethod.POST)
    public String save(@ModelAttribute("tip") Tip tip, Model model) {
        tipRepo.save(tip);

        return "redirect:/tips";
    }

    @RequestMapping("/new_tip")
    public String showNewTipPage(Model model) {
        Tip tip = new Tip();
        model.addAttribute("tip", tip);

        return "new_tip";
    }

    @GetMapping("/view_all_applications")
    public String listApplications(Model model) {
        List<Application> listApplications = appRepo.findAll();
        model.addAttribute("listApplications", listApplications);
        return "view_all_applications";
    }

    @GetMapping("/view_status/{email}")
    public String viewStatus(@PathVariable(name = "email") String email, Model model) {
        Optional<Application> application = Optional.ofNullable(appRepo.findByEmail(email));
        System.out.println(email);
        if (application.isPresent()) {
            model.addAttribute("application", application.get());
            return "view_status";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<Application> application = appRepo.findById(id);
        if (application.isPresent()) {
            model.addAttribute("application", application.get());
            return "edit_application";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/edit/status", method = RequestMethod.POST)
    public String edit(Application newApplication) {
        Application oldApplication = appService.get(newApplication.getId());
        oldApplication.setStatus(newApplication.getStatus());

        appRepo.save(oldApplication);
        return "redirect:/view_all_applications";
    }

//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
//
//        userRepository.save(user);
//        return "redirect:/index";
//    }

}

