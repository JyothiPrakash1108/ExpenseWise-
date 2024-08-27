package com.mjp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mjp.models.Room;
import com.mjp.models.User;
import com.mjp.service.RoomService;
import com.mjp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private UserService userService;
	

    
	@PostMapping("/create")
	public String addRoom(@ModelAttribute("room") Room room, HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    Room createdRoom = roomService.createRoom(room.getRoomName());
	    roomService.joinRoom(createdRoom.getId(), user.getId());
	    session.setAttribute("user", user);

	    return "redirect:/home";
	}

	@GetMapping("/join")
	public String JoinRoom(Model model) {
		List<Room> rooms = roomService.getAllRooms();
		model.addAttribute("rooms", rooms);
		return "join";
	}
	@GetMapping("/join-room")
	public String joinRoom(@RequestParam("id")int id,HttpSession session) {
		User user = (User)session.getAttribute("user");
		Room room = roomService.joinRoom(id, user.getId());
		user.setRoom(room);
		return "redirect:/home";
	}
}
