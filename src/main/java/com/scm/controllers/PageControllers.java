package com.scm.controllers;

// import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.System;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;


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
    
}
