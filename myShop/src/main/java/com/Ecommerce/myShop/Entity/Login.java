package com.Ecommerce.myShop.Entity;



import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Login {

  @Id
  private  String email;
  private  String password;
  private  int accessToken;
  
public String getEmail() {
	return email;
}
public int getAccessToken() {
	return accessToken;
}
public void setAccessToken(int accessToken) {
	this.accessToken = accessToken;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

  
  
  
}