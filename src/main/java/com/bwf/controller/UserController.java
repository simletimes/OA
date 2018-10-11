package com.bwf.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	
	@GetMapping("login")
	public String login(){
		return "user/login";
	}
	
	@PostMapping("dologin")
	public String dologin(User user){
		
		logger.info("{},{}",user.getUsername(),user.getPassword());
		
		return null;
	}

}
