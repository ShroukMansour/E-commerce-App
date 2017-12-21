package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.FilesOperations;
import models.Product;
import models.Customer;

public class CustomerController {
	
	Customer user = new Customer();

	public boolean register(Customer user1) throws IOException {
		boolean found = existEmail(user1.getEmail());
		if (!found) {
			int id = user.getNumOfUsers() + 1;
			user1.setId(id);
			System.out.println(user1.getId());
			user.addUser(user1);
			return true;
		}
		return false;
			
	}
	

	private boolean existEmail(String email) throws IOException {
		ArrayList<Customer> users = user.getAllUsers();
		for (Customer user : users) {
			if (user.getEmail().equals(email))
				return true;
		}
		return false;
	}


	public int login(String email, String pass) throws IOException {
		
		ArrayList<Customer> users = user.getAllUsers();
		int id = -1;
		for (Customer user : users) {
			if (user.getEmail().equals(email)&& user.getPassword().equals(pass))
				id = user.getId();
		}
		return id;
	}

	public boolean isCustomer(int id) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Customer> users = user.getAllUsers();
		for (Customer user : users) {
			if (user.getId() == id);
				return true;
		}
		return false;
	}
	

}
