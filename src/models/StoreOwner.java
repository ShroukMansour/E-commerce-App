package models;

import java.io.IOException;
import java.util.ArrayList;

public class StoreOwner extends Person {

//	private String name;
//	private String email;
//	private String password;
//	private Integer id;
	Integer type;
	public  ArrayList<Store> stores = new ArrayList();
	private FilesOperations fileOps = new FilesOperations();

	ArrayList<StoreOwner> storeOwner = new ArrayList();

	public StoreOwner(String name, String email, String password, Integer type) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
	}

	public StoreOwner() {
		type = 0;
	}

//	public Integer getId() {
//		return id;
//	}

//	public void setId(Integer id) {
//		this.id =;
//	}

	public StoreOwner(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}
	// public void createFirstSN() throws IOException {
	// StoreOwner SOW=new StoreOwner();
	// SOW.setId(1);
	// SOW.setName("Yasmin Shehab");
	// SOW.setEmail("jasmin@gmail.com");
	// SOW.setPassword("1234");
	//
	// storeOwner.add(SOW);
	// }
	//
	// public boolean createSN(String name, String email, String password) throws
	// IOException, ClassNotFoundException {
	// StoreOwner SN = new StoreOwner();
	// SN.setEmail(email);
	// SN.setName(name);
	// SN.setPassword(password);
	// int id = storeOwner.size()+1;
	// SN.setId(id);
	// storeOwner.add(SN);
	// return true;
	// }
	//

	public boolean addSOW(StoreOwner SN) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		fileOps.addSTON(SN);
		return true;
	}

	public int getNumOfStoreOwners() throws IOException {
		// TODO Auto-generated method stub
		int num = fileOps.getNumOfStoreOwners();
		return num;
	}

	public ArrayList<StoreOwner> getAllStoreOwner() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StoreOwner> storeOwners = fileOps.readAllStoreOwner();
		return storeOwners;
	}

}
