package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.myShop.Dao.loginJpaDao;
import com.Ecommerce.myShop.Entity.Login;
import com.Ecommerce.myShop.Services.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public loginJpaDao jpaDao;
	
	@Override
	public String login(Login loginInfo) {
		
		int min = 100;
	    int max = 999;
		int int_random = (int)Math.floor(Math.random()*(max-min+1)+min);
		System.out.println("int random"+ int_random);
		loginInfo.setAccessToken(int_random);
		
		String message = "";
		try {
			jpaDao.save(loginInfo);
			message = "Logged in Successfully";
			
		}
		catch(Exception e)
		{
			message = "Something went erro";
		}
		
		return message;
	}

	@Override
	public String logout(String email) {
		Login lg = new Login();
		List<Login> list =  jpaDao.findAll();
		
		for(Login l : list) {
			if(l.getEmail().equalsIgnoreCase(email)) {
				l.setAccessToken(0);
				jpaDao.save(l);
			}
		}
		
		return "logout successfully";
	}

}
