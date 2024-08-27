package com.mjp.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String roomName;
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<>();
	@OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
	private List<Expense> expenses = new ArrayList<>();
	public void addUser(User user) {
        users.add(user);
        user.setRoom(this);
    }
	public void addExpense(Expense expense) {
		expenses.add(expense);
		expense.setRoom(this);
    }
	public Room() {
		
	}
	
	
	public Room(long id, String roomName) {
		super();
		this.id = id;
		this.roomName = roomName;
	}
	public Room(String roomName) {
		super();
		this.roomName = roomName;
	}

	public Room(long id, List<User> users, List<Expense> expenses) {
		super();
		this.id = id;
		this.users = users;
		this.expenses = expenses;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

/*
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", users=" + users + ", expenses=" + expenses + "]";
	}*/
    @Override
    public String toString() {
        return "Room [id=" + id + ", roomName=" + roomName + "]";
    }
	
}
