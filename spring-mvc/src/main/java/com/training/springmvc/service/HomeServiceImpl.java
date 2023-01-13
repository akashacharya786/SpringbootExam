package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.dao.HomeDao;
import com.training.springmvc.model.User;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	HomeDao dao;
	
	@Override
	public boolean validate(String username, String password) {
		
		List<User> userList = dao.getUsers();
		
		boolean isValid = false;
		
		for(User user:userList) {
			if(user.getUserName().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
				isValid = true;
			}
		}
		return isValid;
		
	}

}
