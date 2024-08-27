package com.mjp.models;

import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long  id;
	private String gmail;
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	private String password;
	public User() {
		
	}
	public User(String gmail, Room room,String password) {
		super();
		this.password = password;
		this.gmail = gmail;
		this.room = room;
	}
	
	public User(long id, String gmail, String password) {
		super();
		this.id = id;
		this.gmail = gmail;
		this.password = password;
	}

	public User(long id, String gmail) {
		super();
		this.id = id;
		this.gmail = gmail;
	}
	public User(long id, String gmail, Room room) {
		super();
		this.id = id;
		this.gmail = gmail;
		this.room = room;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", gmail=" + gmail + ", room=" + room + ", password=" + password + "]";
	}
	
	
}
