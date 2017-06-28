package com.xywei.service;

import com.xywei.domain.User;

public interface UserTestService {
	
	User findUser(String username, String password);
}
