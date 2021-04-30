package com.Ecommerce.myShop.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Ecommerce.myShop.Entity.EmailQuery;
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
	        if(emailQuery.getContactNo() != null) {
	        	msg.setText("name:- "+emailQuery.getName() + "\nContact no:= "+ emailQuery.getContactNo() +"\nquery:- "+emailQuery.getMessage());
	        }else {
	        	msg.setText("name:- "+emailQuery.getName()  +"\nquery:- "+emailQuery.getMessage());
	        }
	        
	        javaMailSender.send(msg);
		
	}

}
