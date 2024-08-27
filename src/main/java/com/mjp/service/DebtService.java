package com.mjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjp.models.Debt;
import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.repository.DebtRepository;

@Service
public class DebtService {
	@Autowired
	private DebtRepository debtRepository;
	@Autowired
	private RoomService roomService;
	public void computeDebts(Room room,Expense expense) {
		long count = roomService.getUserscount(room);
		List<User> users = room.getUsers();
		double amount = expense.getAmount()/users.size();
		for(User user : users) {
			if(user.getId()!=expense.getUser().getId()) {
				Debt debt = debtRepository.findByCreditorAndDebtor(expense.getUser(), user)
                        .orElse(new Debt());
				debt.setCreditor(expense.getUser());
				debt.setDebtor(user);
				debt.setAmount(debt.getAmount()+amount);
				debtRepository.save(debt);
			}
		}
	}
	
	public Debt clearDebt(User cr,User dr) {
		return debtRepository.findByCreditorAndDebtor(cr, dr).orElse(null);
	}
}
