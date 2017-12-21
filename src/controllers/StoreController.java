package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.FilesOperations;
import models.Store;
import models.StoreOwner;

public class StoreController {
	
	Store store = new Store();
	ArrayList<Store> stores = new ArrayList();

	public Boolean addStore(Store St, int id) throws IOException {
		stores = store.getAllStores();
		int index = -1;
		St.setStore_owner_id(id);
		int store_id = store.getNumOfStores();
		St.setStore_id(store_id + 1);
		for (int i = 0; i < stores.size(); i++) {
			if (stores.get(i).getStoreName().equals(St.getStoreName())) {
				System.out.println("the store is already exist ");
				return false;
			}
		}
		store.addStore(St);
		return true;
		
	}

	public ArrayList<Store> getStoreOwnerStores(int id) throws IOException {
		ArrayList<Store> stores = store.getAllStores();
		ArrayList<Store> storeOwnerStores = new ArrayList<Store>();
		for (Store store : stores) {
			if (store.getStore_owner_id() == id)
				storeOwnerStores.add(store);
		}
		return storeOwnerStores;
	}

	public ArrayList<Store> getAllStores() throws IOException {
		ArrayList<Store> stores = store.getAllStores();
		return stores;
	}

	public boolean hasStorOwnerThisStore(int store_id, int id) throws IOException {
		ArrayList<Store> stores = store.getAllStores();
		Store store2 = null;
		for (Store store : stores) {
			System.out.println("stooooooore" + store.getStore_owner_id()  + " " + id);
			if (store.getStore_id() == store_id) {
				store2 = store;
				break;
			}
		}
		if (store2 != null && store2.getStore_owner_id() == id)
			return true;
		return false;
	}
	
	
}
