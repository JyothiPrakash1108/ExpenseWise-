package com.mjp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.repository.ExpenseRepository;
import com.mjp.repository.RoomRepository;
import com.mjp.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public Room addExpense(Expense expense) {
	    Room room = expense.getRoom();
	    User user = expense.getUser();
	    
	    if (room != null && user != null) {
	        expense.setRoom(room);
	        expense.setUser(user);
	        room.addExpense(expense);
	        expenseRepository.save(expense);
	        roomRepository.save(room);
	        
	    } 
	    return room;
	}

	public List<Expense> getExpenses(Room room){
		return expenseRepository.findByRoomId(room.getId());
	}
	public List<Expense> getUserExpense(User user){
		return expenseRepository.findByUserId(user.getId());
	}
   
}
