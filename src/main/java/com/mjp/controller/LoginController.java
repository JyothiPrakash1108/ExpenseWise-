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

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("user",new User());
		return "Login";
	}
	@PostMapping("/login")
	public String getUserDetails(@ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		User dbUser = userService.findByGmail(user.getGmail());
		if(dbUser==null) {
			result.rejectValue("password", "error.user","Invalid gmail or password");
			return "Login";
		}
		else {
			if(dbUser.getPassword().equals(user.getPassword())){
				session.setAttribute("user", dbUser);
				return "redirect:/home";
			}
			else {
				result.rejectValue("password", "error.user","Invalid gmail or password");
				return "Login";
			}
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
