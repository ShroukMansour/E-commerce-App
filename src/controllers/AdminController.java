package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.Admin;

public class AdminController {

	Admin admin = new Admin();
	ArrayList<Admin> admins = new ArrayList<Admin>();
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	public void createFirstAdmin() throws IOException {
		// TODO Auto-generated method stub
		admin.createFirstAdmin();
		
	}

	public int login(String email, String password) throws ClassNotFoundException, IOException {
		//createFirstAdmin();
		admins = admin.readAllAdmins();
		int id = searchSpecificAdmin(email, password);
		return id;
	}


	private int searchSpecificAdmin(String email, String password) {
		// TODO Auto-generated method stub
		for (int i = 0; i < admins.size(); i++) {
			Admin admin2 = admins.get(i);
			System.out.println(admin2.getEmail() + " " + admin2.getPassword());
			if (email.equals(admin2.getEmail()) && password.equals(admin2.getPassword())) {
				return admin2.getId();
			}
		}
		return -1;
	}

	public boolean addAdmin(int id, String name, String email, String password) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean addedCorrectly = admin.createAdmin(name, email, password, id);
		if(addedCorrectly)
			return true;
		return false;
	}

	public String getName(int id) throws ClassNotFoundException, IOException {
		admins = admin.readAllAdmins();
		for (Admin admin : admins) {
			if (admin.getId() == id)
				return admin.getName();
		}
		return "Welcome";
	}
	
	

}
