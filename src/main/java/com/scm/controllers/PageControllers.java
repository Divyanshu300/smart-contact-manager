package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;




@Controller
public class PageControllers {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        // sending data to view
        model.addAttribute("name", "Substring technologies"); // now we add name , value of attribute 
        model.addAttribute("youtubeChannel", "hello World!"); // now we add name , value of attribute 
        model.addAttribute("googleLink", "https://www.google.com"); // now we add name , value of attribute
        return "home";
    }

    //About pages
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About Page loading");
        return "about";
    }


    //Services
    @RequestMapping("/services")
    public String servicePage() {
        System.out.println("Service page Loading");
        return "services";
    }
    

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("Contact Page");
        return "contact";
    }

    @GetMapping("/register")
    public String register(Model model) {
        System.out.println("Register Page");

        //create an object of UserForm
        UserForm userForm = new UserForm();

        //Send the object to the HTML page to either display or save the data
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login Page");
        return "login";
    }
    
    //Processing register
    @RequestMapping(value = "/do-register" , method = RequestMethod.POST)
    //UseForm waala object mein data fetch kroo
    public String preocessRegister(@ModelAttribute UserForm  userForm) {
        System.out.println("Processing Registration");
        //fetch data
        //validate form data
        //save to database
        //Message: "Registration successful"
        return "redirect:/login";
    }
}
