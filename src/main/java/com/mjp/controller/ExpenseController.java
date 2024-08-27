package com.mjp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.service.DebtService;
import com.mjp.service.ExpenseService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private DebtService debtService;
	@GetMapping("/transactions")
	public String showTransactions(Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		List<Expense> expenses = expenseService.getUserExpense(user);
		model.addAttribute("transactions", expenses);
		return "transactions";
	}
	@GetMapping("/summary")
	public String getSummary(HttpSession session,Model model) {
		User user =(User) session.getAttribute("user");
		Room room = user.getRoom();
		System.out.println(room.getExpenses());
		model.addAttribute("users",room.getUsers());
		model.addAttribute("expenses", room.getExpenses());
		return "summary";
	}
	@GetMapping("/addExpense")
	public String addExpense(Model model,HttpSession session) {
		model.addAttribute("expense",new Expense());
		return "expenseForm";
	}
	@PostMapping("/addExpense")
	public String updateExpense(@ModelAttribute("expense") Expense expense,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Room room = user.getRoom();
		expense.setUser(user);
		expense.setRoom(room);
		expenseService.addExpense(expense);
		debtService.computeDebts(room, expense);
		return "redirect:/home";
	}
}
