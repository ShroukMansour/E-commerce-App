package models;

import java.io.IOException;
import java.util.ArrayList;

public class Product {

	int id;
	String name;
	String brand;
	String category;
	double price;
	boolean type; // 0 for soft  1 for hard
	int numOfUsersBuyed;
	int numOfUsersExplored;
	int numOfItems;
	int store_id;
	FilesOperations filesOps = new FilesOperations();

	
	public Product(String n, String b, String cat, boolean t) {
		name = n;
		brand = b;
		category = cat;
		numOfItems = 0;
		type = t;
		price = 0;
		numOfUsersBuyed = -1;
		numOfUsersExplored = -1;
		store_id = 0;
	}
	
    public Product(String name, String brand, String category, double price, int numOfItems) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.numOfItems = numOfItems;
        numOfUsersExplored = 0;
        numOfUsersBuyed = 0;
    }
     public Product() {
        type = false;
        numOfUsersBuyed = 0;
        numOfUsersExplored = 0;
        numOfItems = 0;       
    }

 	public ArrayList<Product> getAllProductsFromStores() throws IOException {
		ArrayList<Product> products = filesOps.readAllProductsFromStores();
		return products;
	}
	public void addProductToStore(Product prodct) throws IOException {
		filesOps.addProductToStore(prodct);
	}
	

	public int getNumOfProducts() throws IOException {
		// TODO Auto-generated method stub
		int num = filesOps.getNumOfProducts();
		return num;
	}
	public boolean addProduct(Product product) throws IOException {
		boolean added = filesOps.addProduct(product);
		return added;
	}
	public ArrayList<Product> getAllProducts() throws IOException {
		ArrayList<Product> products;
		products = filesOps.readAllProducts();
		return products;
	}
	public void updateProducts(ArrayList<Product> products) throws IOException {
		// TODO Auto-generated method stub
		filesOps.updateProducts(products);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public int getNumOfUsersBuyed() {
		return numOfUsersBuyed;
	}
	public void setNumOfUsersBuyed(int numOfUsersBuyed) {
		this.numOfUsersBuyed = numOfUsersBuyed;
	}
	public int getNumOfUsersExplored() {
		return numOfUsersExplored;
	}
	public void setNumOfUsersExplored(int numOfUsersExplored) {
		this.numOfUsersExplored = numOfUsersExplored;
	}
	public int getNumOfItems() {
		return numOfItems;
	}
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public ArrayList<Product> getAllProductsInStore(int store_id) throws IOException {
		 ArrayList<Product> products = filesOps.getAllProductsInStore(store_id);
		return products;
	}

	public ArrayList<Product> getSuggestedProducts() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Product> products = filesOps.getSuggestedProduct();
		return products;
	}

	public boolean suggestProduct(Product product2) throws IOException {
		// TODO Auto-generated method stub
		 return filesOps.suggestProduct(product2);	
	}



	

}
