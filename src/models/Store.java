package models;

import java.io.IOException;
import java.util.ArrayList;

public class Store {

    private String storeName;
    private String description;
    private String location;
    private int mobile;
    private int type;
    private int store_id;
    private int store_owner_id;
   
    public int getStore_owner_id() {
		return store_owner_id;
	}

	public void setStore_owner_id(int store_owner_id) {
		this.store_owner_id = store_owner_id;
	}


	FilesOperations filesOps = new FilesOperations();

    public Store(String storeName, String description, String location, int mobile, int type, int store_id) {
        this.storeName = storeName;
        this.description = description;
        this.location = location;
        this.mobile = mobile;
        this.type = type;
        this.store_id = store_id;
    }
   

    private ArrayList<Product> products = new ArrayList();
    

    public Store() {
        type = 0;
    }

    public Store(String text, String text2) {
		storeName = text;
		description = text2;
	}

	public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


	public ArrayList<Store> getAllStores() throws IOException {
		ArrayList<Store> stores = filesOps.readAllStores();
		return stores;
	}


	public void addStore(Store st) throws IOException {
		filesOps.addStrore(st);
	}

	public int getNumOfStores() throws IOException {
		int num = filesOps.getNumOfStore();
		return num;
	}
	
	

   
}
