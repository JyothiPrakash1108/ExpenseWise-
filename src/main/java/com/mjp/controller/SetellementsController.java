package com.mjp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mjp.models.Debt;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.repository.DebtRepository;
import com.mjp.service.DebtService;
import com.mjp.service.RoomService;
import com.mjp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SetellementsController {
	@Autowired
	private DebtService debtService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private DebtRepository debtRepository;
	@Autowired
	private UserService userService;
	@GetMapping("/settle")
	public String getSettlementsPage(HttpSession session,Model model) {
		 User loggedInUser = (User) session.getAttribute("user");
		    Room room = loggedInUser.getRoom();
		    
		    List<User> users = room.getUsers();
		    Map<User, Double> userOwes = new HashMap<>();
		    Map<User, Double> userGets = new HashMap<>();
		    for (User user : users) {
		        if (!user.equals(loggedInUser)) {
		            Debt debtAsCreditor = debtRepository.findByCreditorAndDebtor(loggedInUser, user).orElse(null);
		            Debt debtAsDebtor = debtRepository.findByCreditorAndDebtor(user, loggedInUser).orElse(null);
		            
		            if (debtAsCreditor != null) {
		                userGets.put(user, debtAsCreditor.getAmount());
		            }
		            
		            if (debtAsDebtor != null) {
		                userOwes.put(user, debtAsDebtor.getAmount());
		            }
		        }
		    }
		    
		    model.addAttribute("userOwes", userOwes);
		    model.addAttribute("userGets", userGets);
		    return "settle";
	}
	@PostMapping("/settleDebt")
	public String settleDebt(@RequestParam("debtorId") long id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		User dr = userService.findUserById(id);
		Debt debt = debtService.clearDebt(user, dr);
		debtRepository.delete(debt);
		return "redirect:/settle";
	}
}
