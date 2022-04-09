package com.kelvinappdev.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvinappdev.app.ws.shared.Utils;
import com.kelvinappdev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.kelvinappdev.app.ws.ui.model.response.UserRest;
import com.kelvinappdev.app.ws.userservice.UserService;

@Service
public class UserServiceImplementation implements UserService {

	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImplementation() {
		
	}
	
	@Autowired
	public UserServiceImplementation(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}
	
}
