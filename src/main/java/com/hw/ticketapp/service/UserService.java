package com.hw.ticketapp.service;

import java.util.List;

import com.hw.ticketapp.model.User;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
	User findById(Long id) throws Exception;
	List<User> findAllUser();
}
