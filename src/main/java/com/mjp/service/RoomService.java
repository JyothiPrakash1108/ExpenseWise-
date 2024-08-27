package com.mjp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjp.models.Expense;
import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.repository.RoomRepository;
import com.mjp.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Room createRoom(String roomName) {
	    Room room = new Room(roomName);
	    room.setUsers(new ArrayList<>()); // Initialize the users list to avoid NPE
	    return roomRepository.save(room);
	}
	public Room findRoom(long roomId) {
		return roomRepository.findById(roomId).get();
	}
	public Room joinRoom(long roomId, long userId) {
	    Room room = roomRepository.findById(roomId).get();
	    User user = userRepository.findById(userId).get();
	    room.addUser(user); // Use the addUser method to maintain bidirectional relationship
	    roomRepository.save(room);
	    return room;
	}

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	public long getUserscount(Room room) {
		return roomRepository.count();
	}
	


	
}
