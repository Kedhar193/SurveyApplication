package com.example.project2.surveyapplication.controllers;






import org.springframework.security.crypto.password.PasswordEncoder;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import com.example.project2.surveyapplication.models.User;
import com.example.project2.surveyapplication.services.UserService;

@Controller
public class BaseController {

    private final UserService userService;
	private PasswordEncoder passwordEncoder;

    

 
    public BaseController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
       
    }

    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        return modelAndView;
    }

    @GetMapping("signup")
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User()); // Add an empty User object to the model
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping("signup")
    public ModelAndView processSignup(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        
        
       System.out.println("\n\n"+user.getUsername());
       System.out.println(user.getPassword()+"\n\n");
       
        // Set role based on email
        if (user.getUsername().equalsIgnoreCase("kedhar@gmail.com")) {
            user.addRole("ADMIN");
        } else {
            user.addRole("USER");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        userService.saveUser(user);

        // Redirect to login page or any other appropriate page
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }


    @GetMapping("login")
    public ModelAndView login() {
    	System.out.println("\n\n\n\n\ninside login controller method \n\n\n\n\n");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    



}
