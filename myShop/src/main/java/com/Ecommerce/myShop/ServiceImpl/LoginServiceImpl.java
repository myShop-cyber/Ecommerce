package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.myShop.Dao.loginJpaDao;
import com.Ecommerce.myShop.Entity.Login;
import com.Ecommerce.myShop.Services.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public loginJpaDao jpaDao;
	
	private Login checkUSer(Login loginInfo) {
		List<Login> list =  jpaDao.findAll();
		for(Login info : list) {
			if(info.getEmail().equalsIgnoreCase(loginInfo.getEmail())) {
			  if(!info.getPassword().equalsIgnoreCase(loginInfo.getPassword())) {
				
			  }
				loginInfo.setPassword(info.getPassword());
			}
		}
		return loginInfo;
	}
	
	private String checkUSerCredentials(Login loginInfo) {
		
		String statusMessage = "";
		
		List<Login> list =  jpaDao.findAll();
		for(Login info : list) {
			
			if(info.getEmail().equalsIgnoreCase(loginInfo.getEmail())) {
			  if(info.getPassword().equalsIgnoreCase(loginInfo.getPassword())) {
				  
			  }else {
				  statusMessage = "invalid password";
			  }
			}
		}
		return  statusMessage;
	}
	
	@Override
	public String login(Login loginInfo) {
		
//		if existing user dont update password only update access token
//		Login info = this.checkUSer(loginInfo);
		
		int min = 100;
	    int max = 999;
		int int_random = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		UUID uuid = UUID.randomUUID();

		
		String statusMessage = this.checkUSerCredentials(loginInfo);
		
		String message = "";
		try {
			if(statusMessage.equalsIgnoreCase("invalid password")) {
				message = "invalid password";
			}else {
				loginInfo.setAccessToken(uuid.toString());
				jpaDao.save(loginInfo);	
				message =   uuid.toString();
			}
		}
		catch(Exception e)
		{
			message = "Something went erro";
		}
		
		return message;
	}

	@Override
	public String logout(String email) {
		List<Login> list =  jpaDao.findAll();
		
		for(Login l : list) {
			if(l.getEmail().equalsIgnoreCase(email)) {
				l.setAccessToken("");
				jpaDao.save(l);
			}
		}
		
		return "logout successfully";
	}

}
