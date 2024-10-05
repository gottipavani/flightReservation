package com.flight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.entities.User;
import com.flight.repository.UserRepository;

@Controller
public class UserController {
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showReg()
	{
		LOGGER.info("Inside showReg()");
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute User user,ModelMap modelMap )
	{
		LOGGER.info("inside saveReg()");
		userRepo.save(user);
		modelMap.addAttribute("msg", "Record is saved");
		return "login/showReg";
	}
	@RequestMapping("/showLogin")
	public String showLogin()
	{
		LOGGER.info("inside showLogin()");
		return "login/login";
		
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email")String email,@RequestParam("password") String password,ModelMap modelMap)
	{
		LOGGER.info("inside verifyLogin()");
		User user = userRepo.findByEmail(email);
		if(user.getEmail().equals(email)&& user.getPassword().equals(password))
		{
			return "searchFlight";
		}else
		{
			modelMap.addAttribute("msg", "Invalid userName/ password");
			return "login/login";
		}
		
	}
	

}
