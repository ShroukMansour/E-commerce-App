package views.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ProductController;
import controllers.StoreController;
import models.Product;
import models.Store;
import views.ViewStores;
import views.storeowner.SuggestProductPage;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerPanelPage extends JDialog {

	private final JPanel contentPanel = new JPanel();



	public CustomerPanelPage(int id) {
		setBounds(100, 100, 450, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Search for product");
			btnNewButton.setBackground(new Color(147, 112, 219));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.addActionListener(new ActionListener() {
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
			btnNewButton.setBounds(43, 62, 136, 35);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("View All Product");
			btnNewButton_1.setBackground(new Color(147, 112, 219));
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.addActionListener(new ActionListener() {
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
			btnNewButton_1.setBounds(257, 62, 130, 35);
			contentPanel.add(btnNewButton_1);
		}
		
		JButton btnViewAllStores = new JButton("view all stores");
		btnViewAllStores.setBackground(new Color(147, 112, 219));
		btnViewAllStores.setForeground(new Color(255, 255, 255));
		btnViewAllStores.addActionListener(new ActionListener() {
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
		btnViewAllStores.setBounds(43, 131, 136, 35);
		contentPanel.add(btnViewAllStores);
		{
			JButton btnSuggestProduct = new JButton("Suggest Product");
			btnSuggestProduct.setBackground(new Color(147, 112, 219));
			btnSuggestProduct.setForeground(new Color(255, 255, 255));
			btnSuggestProduct.addActionListener(new ActionListener() {
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
			btnSuggestProduct.setBounds(257, 131, 136, 35);
			contentPanel.add(btnSuggestProduct);
		}
	}
}
