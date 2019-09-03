package com.hermanramos.lausd.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hermanramos.lausd.models.User;
import com.hermanramos.lausd.services.LoginAndRegistrationService;


@Controller
public class LoginAndRegCtrl {
	@Autowired
	LoginAndRegistrationService lgS;
	
    @RequestMapping("/")
    public String loginAndReg(@ModelAttribute("user") User user) {
        return "loginAndReg/loginAndRegPage.jsp";
    }
    
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "loginAndReg/loginAndRegPage.jsp";
    	}else {
    		lgS.registerUser(user);
    		session.setAttribute("user", user);
    		return "redirect:/home";
    	}
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        if(lgS.authenticateUser(email, password) == false) {
        	model.addAttribute("error", "Email or password not found");
        	return "loginAndReg/loginAndRegPage.jsp";
        } else if (lgS.authenticateUser(email, password) == true) {
        		Object foundUser = lgS.findByEmail(email);
        		session.setAttribute("user", foundUser);
        	}
        	return "redirect:/home";
        }
    
    
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user");
    	return "redirect:/";
    }

    
    
}
