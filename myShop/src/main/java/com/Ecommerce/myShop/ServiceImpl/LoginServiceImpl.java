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
	
	@Autowired
	public EmailServiceImpl  emailService;
	
	private boolean checkUSer(Login loginInfo) {
		
		boolean isNewuser = true;
		
		List<Login> list =  jpaDao.findAll();
		for(Login info : list) {
			if(info.getEmail().equalsIgnoreCase(loginInfo.getEmail())) {
				isNewuser = false;
			}
		}
		return isNewuser;
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
			}else {
				
			}
		}
		return  statusMessage;
	}
	
	@Override
	public String login(Login loginInfo) {
		
//		if existing user dont update password only update access token
//		Login info = this.checkUSer(loginInfo);
		
		
		UUID uuid = UUID.randomUUID();

		
		String statusMessage = this.checkUSerCredentials(loginInfo);
		
		String message = "";
		try {
			if(statusMessage.equalsIgnoreCase("invalid password")) {
				message = "invalid password";
			}else {
				boolean isNewUser = this.checkUSer(loginInfo);
				loginInfo.setAccessToken(uuid.toString());
				message =   uuid.toString();
				jpaDao.save(loginInfo);	
				if(isNewUser) {
					emailService.sendEmailAfterRegistration(loginInfo);
				}
				
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
				l.setAccessToken("logout");
				jpaDao.save(l);
			}
		}
		
		return "logout successfully";
	}

	@Override
	public String getUser(String accessToken) {
		String email = "";
		List<Login> list =  jpaDao.findAll();
		
		for(Login l : list) {
			if(l.getAccessToken().equalsIgnoreCase(accessToken)) {
				email = l.getEmail();
			}
		}
		
		return email;
	}

}
