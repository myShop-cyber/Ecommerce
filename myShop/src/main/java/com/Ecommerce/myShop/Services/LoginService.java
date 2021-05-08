package com.Ecommerce.myShop.Services;

import com.Ecommerce.myShop.Entity.Login;

public interface LoginService {

	public String login(Login loginInfo); 
	public String logout(String email); 
	public String getUser(String accessToken);
}
