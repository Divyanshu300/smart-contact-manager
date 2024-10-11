package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



//jitne bhi routes hai unse ek webpage ko map krte hai isme
//iske madad se hmmlog frontend mein dynamic data bhej skte hai from backend to front end
@Controller
public class PageControllers {

    //UserService ka use hmlog krenge isliye usko import krr lo
    //construsctor injection recomended tareeka hai but hmlog abhi Autowired use krr rhe 
    @Autowired
    private UserService userService; 

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        // sending data to view
        //data ko backend se frontend mein bhejne ke liye hmlog ek model bnaate hai and uso bhejte hai
        //isme key orr value bhejte hai
        model.addAttribute("name", "Substring technologies"); // now we add name , value of attribute 
        model.addAttribute("youtubeChannel", "hello World!"); // now we add name , value of attribute 
        model.addAttribute("googleLink", "https://www.google.com"); // now we add name , value of attribute
        
        //String bhjte hai kyunki webpage ko as a string bhejte hai jitna hmm samajh paaye
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

    //RequestMapping and GetMapping same hota hai bss requestmapping mein koi bhi method use krr skte hai and get mein sirf GET method hota hai
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
    public String preocessRegister(@ModelAttribute UserForm  userForm , HttpSession session) {
        System.out.println("Processing Registration");
        //fetch data
        //validate form data
        //save to database:-
            //UserService:-
            //ab yhaa prr scene ye hai ki kisi bhi service ko use krne ke liye hme user bhejna padega but hmaare passiss controller mein formData hai
            //User ko build krna padega using userForm  
            // User user = User.builder()
            //             .name(userForm.getName())
                        // .email(userForm.getEmail())
                        // .password(userForm.getPassword())
                        // .about(userForm.getAbout())
                        // .phoneNumber(userForm.getPhoneNumber())
                        // .profilePic(
                        //     "https://res.cloudinary.com/dxo2kr9bz/image/upload/v1717842583/0ad7f306-d6da-4717-a82d-55da93b5486f.jpg"
                        // )
            //             .build();

            //builder mein default values nhi aa rhi thi so we are using this
            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            user.setAbout(userForm.getAbout());
            user.setPhoneNumber(userForm.getPhoneNumber());
            user.setProfilePic(
                "https://res.cloudinary.com/dxo2kr9bz/image/upload/v1717842583/0ad7f306-d6da-4717-a82d-55da93b5486f.jpg"
            );

            User savedUser = userService.saveUser(user);

        System.out.println("user created");
        //Message: "Registration successful"
        //addd the message
        Message message =  Message.builder().content("Registration Successful").type(MessageType.blue).build();
        //jaise hi yhaa prr pahuchega session data mmein ye attribute add ho jayega and fir hmm usko front end prr use krr lenge
        session.setAttribute("message", message);
        return "redirect:/register";
    }
}
