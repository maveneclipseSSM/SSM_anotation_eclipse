package com.xywei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xywei.domain.User;
import com.xywei.mapper.UserTestMapper;
import com.xywei.service.UserTestService;

@Service
public class UserTestServiceImpl implements UserTestService {

	@Autowired
	private UserTestMapper usermapper;

	@Override
	public User findUser(String username, String password) {
		User user = usermapper.findUser(username, password);
		return user;
	}

}
