package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import models.FilesOperations;
import models.Product;
import models.StoreOwner;
import models.VoucherCard;

public class ProductController {

	ArrayList<Product> products = new ArrayList<>();
	Product product = new Product();

	public boolean addProductToSystem(Product product) throws IOException {
		int id = product.getNumOfProducts() + 1;
		product.setId(id);
		System.out.println(product.getName());
		if (product.addProduct(product)) {
			return true;
		}
		return true;
	}

	public ArrayList<Product> getAllProducts() throws IOException {
		products = product.getAllProducts();
		return products;
	}

	public ArrayList<Product> getAllProductsInStore(int store_id) throws IOException {
		ArrayList<Product> products = product.getAllProductsInStore(store_id);
		return products;
	}

	public ArrayList<Product> search(String productName) throws IOException {
		ArrayList<Product> products;
		ArrayList<Product> foundProducts = new ArrayList<Product>();
		products = product.getAllProducts();
		for (Product product : products) {
			if (product.getName().equals(productName))
				foundProducts.add(product);
			System.out.println(product.getName());

		}
		return foundProducts;
	}

	public boolean buyProduct(int productId) throws IOException {
		products = getAllProducts();
		int numOfItems;
		boolean sold = false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == productId) {
				numOfItems = products.get(i).getNumOfItems();
				if (numOfItems == 1) {
					products.remove(i);
					sold = true;
				} else {
					products.get(i).setNumOfItems(numOfItems - 1);
					sold = true;
				}
				product.updateProducts(products);
				break;
			}
		}
		return sold;
	}

	public boolean addProductToStore(Product prodct, int store_id) {
		int indx = -1;
		boolean Added = false;
		if (store_id > 0) {
			prodct.setStore_id(store_id);
			ArrayList<Product> storeProducts = new ArrayList<Product>();

			prodct.setStore_id(store_id);
			try {
				product.addProductToStore(prodct);
				Added = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return Added;
	}

	public ArrayList<Product> getSuggestedProducts() throws IOException {
		ArrayList<Product> products = product.getSuggestedProducts();
		return products;
	}

	public boolean suggestProduct(Product product2) throws IOException {
		return product.suggestProduct(product2);
	}

	public void increaseNumOfViews(int productId) throws IOException {
		products = getAllProducts();
		int numOfViews;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == productId) {
				numOfViews = products.get(i).getNumOfUsersExplored();
				products.get(i).setNumOfUsersExplored(numOfViews + 1);	
				System.out.println(numOfViews);
				product.updateProducts(products);
				break;
			}
		}
	}
    public ArrayList<Product> getMostViewdProducts() throws IOException {
        int index = -1;
        ArrayList<Product> allProduct = getAllProducts();
        allProduct.sort(Comparator.comparing(Product::getNumOfUsersExplored).reversed());
        return allProduct;
    }

}
