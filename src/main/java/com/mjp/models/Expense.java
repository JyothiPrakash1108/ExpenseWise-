package com.mjp.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	private double amount;
	private String description;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Expense() {
		super();
	}
	
	public Expense(double amount, String description, LocalDate date, Room room, User user) {
		super();
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.room = room;
		this.user = user;
	}

	public Expense(long id, double amount, String description, LocalDate date, Room room, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.room = room;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
