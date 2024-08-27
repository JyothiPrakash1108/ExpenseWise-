package com.mjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjp.models.User;
import com.mjp.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String verifyRegistration(@ModelAttribute("user")User user,BindingResult result) {
		User exUser = userService.findByGmail(user.getGmail());
		if(exUser==null) {
			userService.saveUser(user);
			return "redirect:/login";
		}
		else {
			result.rejectValue("password", "error.user","Existing user , Please Login");
			return "Login";
		}
		
	}
}
