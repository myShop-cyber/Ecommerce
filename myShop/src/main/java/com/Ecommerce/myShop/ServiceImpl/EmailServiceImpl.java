package com.Ecommerce.myShop.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Ecommerce.myShop.Entity.EmailQuery;
import com.Ecommerce.myShop.Entity.Login;
import com.Ecommerce.myShop.Services.EmailService;

@Service
public class EmailServiceImpl  implements EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(EmailQuery emailQuery) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("prasadvikas0557@gmail.com");

	        msg.setSubject("my shop customer query");
	        if(emailQuery.getContactNo() != null || emailQuery.getContactNo() != "") {
	        	msg.setText("name:- "+emailQuery.getName() + "\nContact no:- "+ emailQuery.getContactNo() +"\nquery:- "+emailQuery.getMessage());
	        }else {
	        	msg.setText("name:- "+emailQuery.getName()  +"\nquery:- "+emailQuery.getMessage());
	        }
	        
	        javaMailSender.send(msg);
		
	}
	
	
	public void sendEmailAfterRegistration(Login loginInfo) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(loginInfo.getEmail());

	        msg.setSubject("My Shop registration success");
	       
	        	msg.setText("Thank you for registration, for any query Please feel free to contact us in (About) section if you need any further information");
	        
	        
	        javaMailSender.send(msg);
		
	}

}
