package org.orangedevelopers.onlinestore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	public String Razaaaaaaaaaaaa;
	//waqas shah	
		
		public String TEST;
//waqas shah	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String loginUser(){
		return "login";
		//RAZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa
	}
//waqas shah		
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
	//waqas shah	
		return "login";
		//RAZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response){
		//TODO login by checking from DB credentials
		//waqas shah	
		if(username.equalsIgnoreCase("test") && password.equalsIgnoreCase("test")){
		//waqas shah	
			return "home";
<<<<<<< HEAD
			//waqas shah	
=======
			//RAZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa
>>>>>>> origin/master
		}else{
			request.setAttribute("errorMsg", "in both username and password type: test");
			//waqas shah	
			return "login";
			//waqas shah	
		}
	}
}
