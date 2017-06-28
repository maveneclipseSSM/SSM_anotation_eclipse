package com.xywei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xywei.domain.User;
import com.xywei.service.UserTestService;

@Controller
public class UserTestController {

	@Autowired
	private UserTestService userTestService;

	@RequestMapping("login")
	public String login(String username, String password, Model model) {
		User user = userTestService.findUser(username, password);
		System.out.println(user);
		model.addAttribute("user", user);
		return "welcome";
	}

}
