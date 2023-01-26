package com.hw.ticketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw.ticketapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
