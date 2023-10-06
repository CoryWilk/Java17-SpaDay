package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {

    @RequestMapping("/user")

    public String displayAddUserForm(){
        return "add";
    }
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if (user.getPassword().equals(verify)) {
            model.addAttribute("message", "Welcome, " + user.getUserName() + "!");
            return "user/index";
        } else {
            model.addAttribute("error", "Password and verification do not match.");
            model.addAttribute("username", user.getUserName());
            model.addAttribute("email", user.getEmail());
            return "add";
        }
    }

}
