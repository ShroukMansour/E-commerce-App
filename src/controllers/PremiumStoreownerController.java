package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import models.PremiumStoreowner;
import models.Product;
import models.Store;
import models.StoreOwner;

public class PremiumStoreownerController extends StoreOwnerController {


	public boolean isPremium(int id) throws ClassNotFoundException, IOException {
		PremiumStoreowner ps = new PremiumStoreowner();
	    ArrayList<StoreOwner> PremStoreOwners = new ArrayList();
		PremStoreOwners = ps.getAllStoreOwner();
		for (StoreOwner so : storeOwner) {
			if (so.getId() == id && so.getType() == 1) {
				System.out.println(so.getName() + " " + so.getType());
				return true;
			}
		}
		return false;
	}

}
