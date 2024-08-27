package com.mjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjp.models.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

}
