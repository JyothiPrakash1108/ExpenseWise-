package com.mjp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.service.ExpenseService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private ExpenseService expenseService;
	@GetMapping("/home")
	public String gotoHome(Model model,HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		if(user.getRoom()!=null) {
			Room room = user.getRoom();
			List<Expense> expenses = expenseService.getExpenses(user.getRoom());
			model.addAttribute("roomExpenses", expenses);
			model.addAttribute("room", room);
		}
		return "home";
	}
	@GetMapping("/update")
	public String updateRoom(Model model) {
		model.addAttribute("room", new Room());
		return "update";
	}
}
