package com.mjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjp.models.User;

@Repository
public interface UserRepository extends  JpaRepository<User,Long>{
	public User findByGmail(String gmail);
}
