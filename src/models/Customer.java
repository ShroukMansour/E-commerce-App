package models;

import java.io.IOException;
import java.util.ArrayList;

public class Customer extends Person{
	int type ;  // 1 customer 
	FilesOperations filesOps= new FilesOperations();
	
	public Customer(Customer user ) {
	this.setName(user.getName());
	this.setEmail(user.getEmail());
	this.setPassword(user.getPassword());
	
	}
	public Customer () {
		this.email =""; 
		this.name="";
		this.password="";
		
	}

	public Customer(String name, String email , String pass ) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(pass);
		
	}
	public void setType(int t ) {
		this.type = t;
	}
	
	public ArrayList<Customer> getAllUsers() throws IOException {
		ArrayList<Customer> users = filesOps.readAllUsers();
		return users;
	}
	public int getNumOfUsers() throws IOException {
		int num = filesOps.getNumOfUsers(); 
		return num;
	}
	public void addUser(Customer user) throws IOException {
		filesOps.addUser(user);
	}

}
