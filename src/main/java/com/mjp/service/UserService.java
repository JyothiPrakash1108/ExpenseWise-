package com.mjp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjp.models.User;
import com.mjp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User findUserById(long id) {
		Optional<User> users = userRepository.findById(id);
		return users.get();
	}
	public User findByGmail(String gmail) {
		return userRepository.findByGmail(gmail);
	}
}
