package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.FilesOperations;
import models.StoreOwner;

public class StoreOwnerController {
	
	ArrayList<StoreOwner> storeOwner = new ArrayList();
	StoreOwner SOW = new StoreOwner();


	private int getNumOfStoreOwners() throws IOException {
		// TODO Auto-generated method stub
		int num = SOW.getNumOfStoreOwners();
		return num;
	}

	public int login(String email, String password) throws ClassNotFoundException, IOException {
		// createFirstAdmi n();
		// SOW = storeOwner.readAllAdmins();
		int id = searchSpecificSN(email, password);
		return id;
	}

	private int searchSpecificSN(String email, String password) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		storeOwner = SOW.getAllStoreOwner();
		for (int i = 0; i < storeOwner.size(); i++) {
			StoreOwner SN = storeOwner.get(i);
			// System.out.println(SN.getEmail() + " " + SN.getPassword());
			if (email.equals(SN.getEmail()) && password.equals(SN.getPassword())) {
				return SN.getId();
			}
		}
		return -1;
	}

	public boolean addSN(String name, String email, String password, int type) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		StoreOwner SN = new StoreOwner();
		SN.setEmail(email);
		SN.setName(name);
		SN.setPassword(password);
		SN.setType(type);
		System.out.println("Name: " + name + " " + email + " " + password + " " + type);
		int id = getNumOfStoreOwners() + 1;
		SN.setId(id);
		SOW.addSOW(SN);
		return true;
	}

	public String getName(int id) throws ClassNotFoundException, IOException {

		for (StoreOwner SN : storeOwner) {
			if (SN.getId() == id)
				return SN.getName();
		}
		return "Welcome";
	}

//	public boolean isStoreOwner(int store_id, int id) throws ClassNotFoundException, IOException {
//		ArrayList<StoreOwner> storeOwners = SOW.getAllStoreOwner();
//		for (StoreOwner storeOwner : storeOwners) {
//			if (storeOwner.getId() == id)
//				return true;
//		}
//		return false;
//	}

}
