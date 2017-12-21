package views.storeowner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AdminController;
import controllers.PremiumStoreownerController;
import controllers.ProductController;
import controllers.StoreController;
import controllers.StoreOwnerController;
import models.PremiumStoreowner;
import models.Product;
import models.Store;
import views.ViewStores;
import views.admin.ControlPanelPage;
import views.customer.HomePage;

public class StoreOwnerPanel extends JDialog {
	private final JPanel contentPanel = new JPanel();
	Integer id;
	StoreOwnerController sowController  = new StoreOwnerController();

	public static void main(String[] args) {
		try {
			ControlPanelPage dialog = new ControlPanelPage(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public StoreOwnerPanel(int id) throws ClassNotFoundException, IOException {
		this.id  = id;

		setBounds(100, 100, 485, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAddAdmin = new JButton("Add Store");
		btnAddAdmin.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnAddAdmin.setForeground(new Color(255, 255, 255));
		btnAddAdmin.setBackground(new Color(147, 112, 219));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStorePage addStore = new AddStorePage(id);
				addStore.setVisible(true);
			}
		});
		btnAddAdmin.setBounds(23, 92, 166, 37);
		contentPanel.add(btnAddAdmin);
		
		JButton btnAddProduct = new JButton("View All Stores");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreController storeController = new StoreController();
				ArrayList<Store> stores = null;
				try {
					stores = storeController.getAllStores();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Store fakeStore = new Store("de", "R");
				ViewStores viewStores = null;
				try {
					viewStores = new ViewStores(fakeStore, 1);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					viewStores.display(stores, id);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				viewStores.setVisible(true);
			}			
		});
		btnAddProduct.setForeground(new Color(255, 255, 255));
		btnAddProduct.setBackground(new Color(147, 112, 219));
		btnAddProduct.setBounds(225, 92, 166, 37);
		contentPanel.add(btnAddProduct);
		
		JButton btnAddbrand = new JButton("Suggest Product");
		btnAddbrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestProductPage s = null;
				try {
					s = new SuggestProductPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				s.setVisible(true);
			}
		});
		btnAddbrand.setForeground(new Color(255, 255, 255));
		btnAddbrand.setBackground(new Color(147, 112, 219));
		btnAddbrand.setBounds(23, 169, 166, 37);
		contentPanel.add(btnAddbrand);
		
		JButton btnExploreProduct = new JButton("View All Products");
		btnExploreProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product("Dd", "dd", "dd",  true);
				ArrayList<Product> products = null;
		    	ProductController productController = new ProductController();
		    	try {
					products = productController.getAllProducts();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				HomePage homePage = new HomePage(product, id);
				try {
					homePage.display(products, id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				homePage.setVisible(true);
			}
		});
		btnExploreProduct.setForeground(new Color(255, 255, 255));
		btnExploreProduct.setBackground(new Color(147, 112, 219));
		btnExploreProduct.setBounds(225, 232, 166, 37);
		contentPanel.add(btnExploreProduct);
		
		JLabel lblAdminName = new JLabel(sowController.getName(id));
		lblAdminName.setFont(new Font("Snap ITC", Font.BOLD, 18));
		lblAdminName.setBounds(10, 11, 192, 27);
		contentPanel.add(lblAdminName);
		
		JButton btnSearchForProduct = new JButton("Search For Product");
		btnSearchForProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ArrayList<Product> products = null;
				  	String productName = JOptionPane.showInputDialog("Please enter product name: ");
				  	if (productName != null) 
				  	{
				  		ProductController productController = new ProductController();
					  	try {
							products = productController.search(productName);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  	Product fakeProduct = new Product("g", "f", "f", false);
					  	HomePage homePage = new HomePage(fakeProduct, id);
					  	try {
							homePage.display(products, id);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  	homePage.setVisible(true);
				  	}
				  
			}
		});
		btnSearchForProduct.setForeground(Color.WHITE);
		btnSearchForProduct.setBackground(new Color(147, 112, 219));
		btnSearchForProduct.setBounds(23, 232, 166, 37);
		contentPanel.add(btnSearchForProduct);
		
		JButton btnViewMyStores = new JButton("View My Stores");
		btnViewMyStores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreController storeController = new StoreController();
				ArrayList<Store> stores = null;
				try {
					stores = storeController.getStoreOwnerStores(id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Store fakeStore = new Store("de", "R");
				ViewStores viewStores = null;
				try {
					viewStores = new ViewStores(fakeStore, 1);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					viewStores.display(stores, id);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				viewStores.setVisible(true);
			}
		});
		btnViewMyStores.setForeground(Color.WHITE);
		btnViewMyStores.setBackground(new Color(147, 112, 219));
		btnViewMyStores.setBounds(225, 169, 166, 37);
		contentPanel.add(btnViewMyStores);
		
		JButton btnShowMostViewd = new JButton("Show most viewd products");
		btnShowMostViewd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = new Product();
				MostViewdProductsPage m = new MostViewdProductsPage(product, id);
		  		ProductController productController = new ProductController();
				ArrayList<Product> mostViewdroducts = null;
				try {
					mostViewdroducts = productController.getMostViewdProducts();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					m.display(mostViewdroducts, id);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowMostViewd.setForeground(Color.WHITE);
		btnShowMostViewd.setBackground(new Color(147, 112, 219));
		btnShowMostViewd.setBounds(129, 300, 166, 37);
		PremiumStoreownerController p = new PremiumStoreownerController();
		
		if (p.isPremium(id))
			contentPanel.add(btnShowMostViewd);
		
	}
}
