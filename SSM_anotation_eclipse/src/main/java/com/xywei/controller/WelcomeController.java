package com.xywei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 配置默认页面
 * 
 *
 */
@Controller
public class WelcomeController {

/*	@RequestMapping("index")
	public String toIndex() {
		return "login";
	}*/

	@RequestMapping("/")
	public String index() {
		return "login";
	 }
}
