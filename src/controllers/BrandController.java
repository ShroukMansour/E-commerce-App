package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.Brand;
import models.FilesOperations;
import models.Product;

public class BrandController {

	
	ArrayList<Brand> brands = new ArrayList<>();
	Brand brand = new Brand();
	public boolean addBrandToSystem(Brand brand) throws IOException {
		int id = brand.getNumOfBrands() + 1;
		brand.setId(id);
		if (brand.addBrand(brand)) {
			brands = brand.getAllBrands();
//			for (Brand brand2 : brands) {
//				System.out.println(brand2.getId() + " " + brand2.getName());
//			}
			return true;
		}
		return true;
	}
	public ArrayList<Brand> getAllBrands() throws IOException {
		ArrayList<Brand> brands = brand.getAllBrands();
		return brands;
	}
}
