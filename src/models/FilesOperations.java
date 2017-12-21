package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FilesOperations {

	public FilesOperations() {
		// TODO Auto-generated constructor stub
	}

	public void writeFirstAdmin(Admin admin) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\DB\\AdminDB.txt");
		DataOutputStream out = new DataOutputStream(fileOut);
		out.writeInt(1);
		out.writeInt(admin.getId());
		out.writeUTF(admin.getName());
		out.writeUTF(admin.getEmail());
		out.writeUTF(admin.getPassword());
		out.writeInt(admin.getAdmin_id());
		out.close();
		fileOut.close();
	}

	public ArrayList<Admin> readAllAdmins() throws ClassNotFoundException, IOException {
		ArrayList<Admin> admins = new ArrayList<>();
		FileInputStream fileIn = null;
		fileIn = new FileInputStream(
				"C:\\DB\\AdminDB.txt");
		DataInputStream in = null;
		in = new DataInputStream(fileIn);
		in.skipBytes(0);
		int numOfAdmins = in.readInt();
		for (int i = 0; i < numOfAdmins; i++) {
			Admin readAdmin = new Admin();
			try {
				readAdmin.setId(in.readInt());
				readAdmin.setName(in.readUTF());
				readAdmin.setEmail(in.readUTF());
				readAdmin.setPassword(in.readUTF());
				readAdmin.setAdmin_id(in.readInt());
			} catch (EOFException e) {
				e.printStackTrace();
				break;
			}
			if (readAdmin != null)
				admins.add(readAdmin);
		}
		in.close();
		fileIn.close();
		return admins;
	}

	public void writeNumOfAdmins(int size) throws IOException {
		String fileName = "C:\\DB\\AdminDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		file.writeInt(size);
		file.close();
	}

	public void updateNumOfAdmins() throws IOException {
		String fileName = "C:\\DB\\AdminDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int numOfAdmins = file.readInt();
		file.seek(0);
		file.writeInt(numOfAdmins + 1);
		file.close();
	}

	public int getNumOfAdmins() throws IOException {
		String fileName = "C:\\DB\\AdminDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num = file.readInt();
		file.close();
		return num;
	}

	public boolean addAdmin(Admin admin) throws IOException, ClassNotFoundException {
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\DB\\AdminDB.txt",
				true);
		DataOutputStream out = new DataOutputStream(fileOut);
		out.writeInt(admin.getId());
		out.writeUTF(admin.getName());
		out.writeUTF(admin.getEmail());
		out.writeUTF(admin.getPassword());
		out.writeInt(admin.getAdmin_id());
		out.close();
		fileOut.close();
		updateNumOfAdmins();
		readAllAdmins();
		out.close();
		return true;
	}

	//////////////////////////////////////////////////////////// Product////////////////////////////////////////////////////

	public int getNumOfProducts() throws IOException {
		String fileName = "C:\\DB\\ProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		file.close();
		return num;
	}

	public boolean addProduct(Product product) throws IOException {
		String fileName = "C:\\DB\\ProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(num);
		file.writeUTF(product.getName());
		file.writeUTF(product.getBrand());
		file.writeUTF(product.getCategory());
		file.writeDouble(product.getPrice());
		file.writeBoolean(product.isType());
		file.writeInt(product.getNumOfUsersBuyed());
		file.writeInt(product.getNumOfUsersExplored());
		file.writeInt(product.getNumOfItems());
		file.writeInt(product.getStore_id());
		file.close();
		return true;
	}
	public boolean suggestProduct(Product product) throws IOException {
		boolean exist = true;
		ArrayList<Product> products= searchProduct(product.getName());
		for (int i = 0 ; i < products.size();i++) {
			if(products.get(i).getName()==product.getName()) {
				exist = false;
				return exist;
			}
			else {
				continue;
			}
		}
		String fileName = "C:\\DB\\SuggestedProducts.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(num);
		file.writeUTF(product.getName());
		file.writeUTF(product.getBrand());
		file.writeUTF(product.getCategory());
		file.writeDouble(product.getPrice());
		file.writeBoolean(product.isType());
		file.writeInt(product.getNumOfUsersBuyed());
		file.writeInt(product.getNumOfUsersExplored());
		file.writeInt(product.getNumOfItems());
		file.writeInt(product.getStore_id());
		file.close();
		return exist;
	}

	public void updateProducts(ArrayList<Product> products) throws IOException {
		FileOutputStream fileIn = new FileOutputStream("C:\\DB\\\\ProductDB.txt");
		DataOutputStream file = new DataOutputStream(fileIn);
		file.writeInt(products.size());
		for (Product product : products) {
			file.writeInt(product.getId());
			file.writeUTF(product.getName());
			file.writeUTF(product.getBrand());
			file.writeUTF(product.getCategory());
			file.writeDouble(product.getPrice());
			file.writeBoolean(product.isType());
			file.writeInt(product.getNumOfUsersBuyed());
			file.writeInt(product.getNumOfUsersExplored());
			file.writeInt(product.getNumOfItems());
			file.writeInt(product.getStore_id());
		}
		file.close();
	}

	public ArrayList<Product> readAllProducts() throws IOException {
		ArrayList<Product> products = new ArrayList<>();
		FileInputStream fileIn = null;
		fileIn = new FileInputStream("C:\\DB\\\\ProductDB.txt");
		DataInputStream file = null;
		file = new DataInputStream(fileIn);
		file.skipBytes(0);
		int num = file.readInt();
		for (int i = 0; i < num; i++) {
			Product p = new Product();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setBrand(file.readUTF());
			p.setCategory(file.readUTF());
			p.setPrice(file.readDouble());
			p.setType(file.readBoolean());
			p.setNumOfUsersBuyed(file.readInt());
			p.setNumOfUsersExplored(file.readInt());
			p.setNumOfItems(file.readInt());
			p.setStore_id(file.readInt());
			if (p != null)
				products.add(p);
		}
		file.close();
		return products;
	}

	public ArrayList<Product> searchProduct(String productName) throws IOException {
		ArrayList<Product> products = new ArrayList<>();
		String fileName = "C:\\DB\\\\ProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		for (int i = 0; i < num; i++) {
			Product p = new Product();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setBrand(file.readUTF());
			p.setCategory(file.readUTF());
			p.setPrice(file.readDouble());
			p.setType(file.readBoolean());
			p.setNumOfUsersBuyed(file.readInt());
			p.setNumOfUsersExplored(file.readInt());
			p.setNumOfItems(file.readInt());
			p.setStore_id(file.readInt());
			if (p != null && productName.equals(p.getName())) {
				products.add(p);
			}
		}
		file.close();
		return products;
	}

	
	public ArrayList<Product> getSuggestedProduct() throws IOException {
		ArrayList<Product> products = new ArrayList<>();
		String fileName = "C:\\DB\\\\SuggestedProducts.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		num = file.readInt();
		for (int i = 0; i < num; i++) {
			Product p = new Product();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setBrand(file.readUTF());
			p.setCategory(file.readUTF());
			p.setPrice(file.readDouble());
			p.setType(file.readBoolean());
			p.setNumOfUsersBuyed(file.readInt());
			p.setNumOfUsersExplored(file.readInt());
			p.setNumOfItems(file.readInt());
			p.setStore_id(file.readInt());
			if (p != null) {
				products.add(p);
			}
		}
		file.close();
		return products;
	}
	////////////////////////////////////////////////////////// Brand/////////////////////////////////////////////

	public int getNumOfBrands() throws IOException {
		String fileName = "C:\\DB\\\\BrandDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		file.close();
		return num;
	}

	public boolean addBrand(Brand brand) throws IOException {
		String fileName = "C:\\DB\\\\BrandDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(brand.getId());
		file.writeUTF(brand.getName());
		file.writeInt(brand.getNumOfUsersExplored());
		file.close();
		return true;
	}

	public ArrayList<Brand> readAllBrands() throws IOException {
		ArrayList<Brand> brands = new ArrayList<>();
		String fileName = "C:\\DB\\\\BrandDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		num = file.readInt();
		for (int i = 0; i < num; i++) {
			Brand p = new Brand();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setNumOfUsersExplored(file.readInt());
			if (p != null)
				brands.add(p);
		}
		file.close();
		return brands;
	}

	///////////////////////////////////////////////////// voucher
	///////////////////////////////////////////////////// card///////////////////////////////////

	public boolean readSerialNum(int serialNum) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "C:\\DB\\VoucherCardBD.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		if (file.length() == 0) {
			return false;
		} else {
			int numOfVC = file.readInt();
			for (int i = 0; i < numOfVC; i++) {
				int serial = file.readInt();
				float val = file.readInt();
				if (serial == serialNum)
					return true;
			}
		}
		file.close();
		return false;
	}

	public void addVoucherCard(int serialNum, int val) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "C:\\DB\\VoucherCardBD.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		if (file.length() == 0) {
			file.writeInt(1);
		} else {
			int numOfVC = file.readInt();
			file.seek(0);
			file.writeInt(numOfVC + 1);
		}
		file.seek(file.length());
		file.writeInt(serialNum);
		file.writeInt(val);
		file.close();
	}

	public ArrayList<VoucherCard> readAllVouchers() throws IOException {
		ArrayList<VoucherCard> vouchers = new ArrayList<>();
		FileInputStream fileIn = null;
		fileIn = new FileInputStream("C:\\DB\\VoucherCardBD.txt");
		DataInputStream file = null;
		file = new DataInputStream(fileIn);
		file.skipBytes(0);
		int num;
		num = file.readInt();
		for (int i = 0; i < num; i++) {
			VoucherCard card = new VoucherCard();
			card.setSerialNum(file.readInt());
			card.setValue(file.readInt());

			if (card != null)
				vouchers.add(card);
		}
		file.close();

		return vouchers;
	}

	public void updateVoucherCards(ArrayList<VoucherCard> vouchers) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "C:\\DB\\VoucherCardBD.txt";
		RandomAccessFile file;
		file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		file.writeInt(vouchers.size());
		for (VoucherCard vc : vouchers) {
			file.writeInt(vc.getSerialNum());
			file.writeDouble(vc.getValue());
		}
		file.close();
	}

	///////////////////// USer///////////////////////////////////
	public int getNumOfUsers() throws IOException {
		String fileName = "C:\\DB\\Customer.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		file.close();
		return num;
	}



	public boolean addUser(Customer user) throws IOException {
		String fileName = "C:\\DB\\Customer.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(user.getId());
		file.writeUTF(user.getName());
		file.writeUTF(user.getEmail());
		file.writeUTF(user.getPassword());
		file.close();
		return true;

	}

	public ArrayList<Customer> readAllUsers() throws IOException {
		ArrayList<Customer> customers = new ArrayList<>();
		String fileName = "C:\\DB\\Customer.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		for (int i = 0; i < num; i++) {
			Customer user = new Customer();
			user.setId(file.readInt());
			user.setName(file.readUTF());
			user.setEmail(file.readUTF());
			user.setPassword(file.readUTF());
			if (user != null)
				customers.add(user);
		}
		file.close();
		return customers;
	}


	///////////////////////////////////////////////// store owner////////////////////////////////
	public ArrayList<StoreOwner> readAllStoreOwner() throws ClassNotFoundException, IOException {
		ArrayList<StoreOwner> StoreOnwer = new ArrayList<>();
		
		FileInputStream fileIn = null;
		fileIn = new FileInputStream("C:\\DB\\StoreOwner.txt");
		DataInputStream in = null;
		in = new DataInputStream(fileIn);
		in.skipBytes(0);
		
//		String fileName = "C:\\DB\\StoreOwner.txt";
//		RandomAccessFile in = new RandomAccessFile(fileName, "rw");
//		in.seek(0);
		int numOfAdmins = in.readInt();
		for (int i = 0; i < numOfAdmins; i++) {
			StoreOwner readSON = new StoreOwner();
			try {
				readSON.setId(in.readInt());
				readSON.setName(in.readUTF());
				readSON.setEmail(in.readUTF());
				readSON.setPassword(in.readUTF());
				readSON.setType(in.readInt());
//				System.out.println(readSON.getId());
//				System.out.println(readSON.getName());
//				System.out.println(readSON.getEmail());
//				System.out.println(readSON.getPassword());
//				System.out.println(readSON.getType());
			} catch (EOFException e) {
				e.printStackTrace();
				break;
			}
			if (readSON != null)
				StoreOnwer.add(readSON);
		}
		in.close();
		return StoreOnwer;
	}

	public void writeNumOfSTON(int size) throws IOException {
		String fileName = "C:\\DB\\StoreOwner.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		file.writeInt(size);
		file.close();
	}

	public int getNumOfStoreOwners() throws IOException {
		String fileName = "C:\\DB\\StoreOwner.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0) 
			num = 0;
		else 
			num = file.readInt();
		file.close();
		return num;
	}

	public boolean addSTON(StoreOwner SN) throws IOException, ClassNotFoundException {
		String fileName = "C:\\DB\\StoreOwner.txt";
		RandomAccessFile out = new RandomAccessFile(fileName, "rw");
		out.seek(0);
		int num;
		if (out.length() == 0)
			num = 1;
		else
			num = out.readInt() + 1;
		out.seek(0);
		out.writeInt(num);
		out.seek(out.length());
		out.writeInt(SN.getId());
		out.writeUTF(SN.getName());
		out.writeUTF(SN.getEmail());
		out.writeUTF(SN.getPassword());
		out.writeInt(SN.getType());
		out.close();
		readAllStoreOwner();
		return true;
	}

	////////////////////////////////////////////////////////////Product in  Stores////////////////////////////////////////////////////

	public int getNumOfProductsInStore() throws IOException {
		String fileName = "C:\\DB\\StoreProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		file.close();
		return num;
	}
	public ArrayList<Product> getAllProductsInStore(int store_id) throws IOException {
		ArrayList<Product> products = new ArrayList<>();
		String fileName = "C:\\DB\\\\StoreProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		for (int i = 0; i < num; i++) {
			Product p = new Product();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setBrand(file.readUTF());
			p.setCategory(file.readUTF());
			p.setPrice(file.readDouble());
			p.setType(file.readBoolean());
			p.setNumOfUsersBuyed(file.readInt());
			p.setNumOfUsersExplored(file.readInt());
			p.setNumOfItems(file.readInt());
			p.setStore_id(file.readInt());
			if (p != null && p.getStore_id() == store_id)
				products.add(p);
		}
		file.close();
		return products;
	}


	public boolean addProductToStore(Product product) throws IOException {
		String fileName = "C:\\DB\\StoreProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(product.getId());
		file.writeUTF(product.getName());
		file.writeUTF(product.getBrand());
		file.writeUTF(product.getCategory());
		file.writeDouble(product.getPrice());
		file.writeBoolean(product.isType());
		file.writeInt(product.getNumOfUsersBuyed());
		file.writeInt(product.getNumOfUsersExplored());
		file.writeInt(product.getNumOfItems());
		file.writeInt(product.getStore_id());
		file.close();
		return true;
	}

	public ArrayList<Product> readAllProductsFromStores() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<>();
		String fileName = "C:\\DB\\StoreProductDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		num = file.readInt();
		for (int i = 0; i < num; i++) {
			Product p = new Product();
			p.setId(file.readInt());
			p.setName(file.readUTF());
			p.setBrand(file.readUTF());
			p.setCategory(file.readUTF());
			p.setPrice(file.readDouble());
			p.setType(file.readBoolean());
			p.setNumOfUsersBuyed(file.readInt());
			p.setNumOfUsersExplored(file.readInt());
			p.setNumOfItems(file.readInt());
			p.setStore_id(file.readInt());
			if (p != null)
				products.add(p);
		}
		file.close();
		return products;
	}

	////////////////////////////////////////////////////////// Store/////////////////////////////////////////////

	public int getNumOfStore() throws IOException {
		String fileName = "C:\\DB\\StoreDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		file.close();
		return num;
	}

	public boolean addStrore(Store store) throws IOException {
		String fileName = "C:\\DB\\StoreDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 1;
		else
			num = file.readInt() + 1;
		file.seek(0);
		file.writeInt(num);
		file.seek(file.length());
		file.writeInt(store.getStore_id());
		file.writeInt(store.getStore_owner_id());
		file.writeUTF(store.getStoreName());
		file.writeUTF(store.getDescription());
		file.writeInt(store.getType());
		file.writeInt(store.getMobile());
		file.close();
		return true;
	}

	public ArrayList<Store> readAllStores() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Store> store = new ArrayList<>();
		String fileName = "C:\\DB\\StoreDB.txt";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		file.seek(0);
		int num;
		if (file.length() == 0)
			num = 0;
		else
			num = file.readInt();
		for (int i = 0; i < num; i++) {
			Store S = new Store();
			S.setStore_id(file.readInt());
			S.setStore_owner_id(file.readInt());
			S.setStoreName(file.readUTF());
			S.setDescription(file.readUTF());
			S.setType(file.readInt());
			S.setMobile(file.readInt());
			if (S != null)
				store.add(S);
		}
		file.close();
		return store;
	}






}
