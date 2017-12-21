package models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends Person {
	
	Integer admin_id;
	transient ArrayList<Admin> admins = new ArrayList<>();
	transient private FilesOperations fileOps = new FilesOperations();
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public void createFirstAdmin() throws IOException {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setName("Shrouk Mansour");
		admin.setEmail("shrouk");
		admin.setPassword("1234");
		admin.setAdmin_id(0);
		fileOps.writeFirstAdmin(admin);
	}
	
	
	public ArrayList<Admin> readAllAdmins() throws ClassNotFoundException, IOException {
		return fileOps.readAllAdmins();
	}



	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public boolean createAdmin(String name, String email, String password, Integer admin_id) throws IOException, ClassNotFoundException {
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setName(name);
		admin.setPassword(password);
		admin.setAdmin_id(admin_id);
		int id = fileOps.getNumOfAdmins();
		admin.setId(id + 1);
		boolean addedCorrectly = fileOps.addAdmin(admin);
		return true;
	}

}
