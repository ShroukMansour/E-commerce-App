package models;

import java.io.IOException;
import java.io.Serializable;

public class Person  {
	
	String name;
	String email;
	String password;
	Integer id;
	
//	public Boolean login(String email, String password) throws ClassNotFoundException, IOException {
//		return true;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
