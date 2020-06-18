package com.bootstrap.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstrap.springboot.repository.UserRepository;

@Service
public class UserService {
	
	 @Autowired
	 private UserRepository userRepository;

	   
	 	
}
