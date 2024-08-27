package com.mjp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjp.models.Expense;
import com.mjp.models.Room;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	List<Expense> findByRoomId(long roomId);
	List<Expense> findByUserId(long userId);
}
