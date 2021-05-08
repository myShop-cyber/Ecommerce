package com.Ecommerce.myShop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.myShop.Services.LoginService;

@RestController
public class UserLoginController {
	
	@Autowired
	private LoginService  loginService;

	@CrossOrigin
	@PostMapping("/Login")
	public String Login(@RequestBody com.Ecommerce.myShop.Entity.Login loginDetail) {
		
		return loginService.login(loginDetail);
	}
	
	@CrossOrigin
	@GetMapping("/Logout/{email}")
	public String Logout(@PathVariable String email) {
		
		return loginService.logout(email);
	}
	
	@CrossOrigin
	@GetMapping("/getUser/{accesstoken}")
	public String getUserInfo(@PathVariable String accesstoken) {
		
		return loginService.getUser(accesstoken);
	}
	
}

