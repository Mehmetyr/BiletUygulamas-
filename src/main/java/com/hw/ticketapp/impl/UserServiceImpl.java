package com.hw.ticketapp.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.hw.ticketapp.model.User;
import com.hw.ticketapp.repository.UserRepository;
import com.hw.ticketapp.service.UserService;
 

@Service
public class UserServiceImpl implements UserService {
	
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}




	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User findById(Long id) throws Exception {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isEmpty() || optionalUser.get()  == null ) {
			throw new Exception("User not Found");
		}
		return optionalUser.get();
	}

}
