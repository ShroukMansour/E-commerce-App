package models;

import java.io.IOException;
import java.util.ArrayList;

public class Brand {
	
	int id;
	String name;
	int numOfUsersExplored;
	FilesOperations filesOps = new FilesOperations();	

	public Brand(String n) {
		name = n;
		numOfUsersExplored = -1;
	}
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfUsersExplored() {
		return numOfUsersExplored;
	}

	public void setNumOfUsersExplored(int numOfUsersExplored) {
		this.numOfUsersExplored = numOfUsersExplored;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumOfBrands() throws IOException {
		int num = filesOps.getNumOfBrands();
		return num;
	}

	public boolean addBrand(Brand brand) throws IOException {
		boolean added = filesOps.addBrand(brand);
		return false;
	}

	public ArrayList<Brand> getAllBrands() throws IOException {
		ArrayList<Brand> brands;
		brands = filesOps.readAllBrands();
		return brands;
	}
}
