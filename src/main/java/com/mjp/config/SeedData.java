package com.mjp.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.service.DebtService;
import com.mjp.service.ExpenseService;
import com.mjp.service.RoomService;
import com.mjp.service.UserService;

@Component
public class SeedData implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private DebtService debtService;
	public void run(String... args) {/*
		Room room = roomService.createRoom("boys");
		User user = userService.saveUser(new User("jyothi1108@gmail.com",room,"456"));
		roomService.joinRoom(room.getId(),user.getId());
		expenseService.addExpense(new Expense(500,"groceries",LocalDate.now(), room, user));
		
		
		 User user1 = userService.saveUser(new User("alice@example.com", room,"password123"));
         User user2 = userService.saveUser(new User("bob@example.com",room ,"password456"));
         User user3 = userService.saveUser(new User("carol@example.com", room,"password789"));
         User user4 = userService.saveUser(new User("dave@example.com",room,"password101"));
	
         
         expenseService.addExpense(new Expense(100.0, "Groceries", LocalDate.now(), room, user1));
         expenseService.addExpense(new Expense(50.0, "Utilities", LocalDate.now().minusDays(5), room, user2));
         expenseService.addExpense(new Expense(25.0, "Internet", LocalDate.now().minusDays(10), room, user3));
         expenseService.addExpense(new Expense(75.0, "Rent", LocalDate.now().minusDays(15), room, user4));
         expenseService.addExpense(new Expense(60.0, "Transportation", LocalDate.now().minusDays(20), room, user1));
         expenseService.addExpense(new Expense(80.0, "Dining Out", LocalDate.now().minusDays(25), room, user2));
         expenseService.addExpense(new Expense(40.0, "Entertainment", LocalDate.now().minusDays(30), room, user3));
         expenseService.addExpense(new Expense(90.0, "Healthcare", LocalDate.now().minusDays(35), room, user4));
         expenseService.addExpense(new Expense(70.0, "Clothing", LocalDate.now().minusDays(40), room, user1));
         expenseService.addExpense(new Expense(110.0, "Electronics", LocalDate.now().minusDays(45), room, user2));
     
	*/}
}
