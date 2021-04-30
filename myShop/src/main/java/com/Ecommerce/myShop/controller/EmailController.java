package com.Ecommerce.myShop.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.myShop.Entity.EmailQuery;
import com.Ecommerce.myShop.Services.EmailService;


@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@CrossOrigin
	@RequestMapping(value = "/sendemail")
	public String send(@RequestBody EmailQuery emailQuery) throws AddressException, MessagingException, IOException {
		emailService.sendEmail(emailQuery);
//		sendingEmailApplication.sendEmailWithAttachment();
	   return "Email sent successfully";   
	}
	
}
