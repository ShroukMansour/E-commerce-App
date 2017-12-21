package views.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AdminController;
import controllers.ProductController;
import models.Admin;
import models.Product;
import views.customer.HomePage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ControlPanelPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Integer id;
	AdminController adminController = new AdminController();

	public static void main(String[] args) {
		try {
			ControlPanelPage dialog = new ControlPanelPage(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ControlPanelPage(int id) throws ClassNotFoundException, IOException {
		this.id  = id;

		setBounds(100, 100, 485, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnAddAdmin.setForeground(new Color(255, 255, 255));
		btnAddAdmin.setBackground(new Color(147, 112, 219));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdminPage addAdmin = new AddAdminPage(id);
				addAdmin.setVisible(true);
			}
		});
		btnAddAdmin.setBounds(23, 92, 166, 37);
		contentPanel.add(btnAddAdmin);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductToSystemPage addProduct = null;
				try {
					addProduct = new AddProductToSystemPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addProduct.setVisible(true);
			}
			
		});
		btnAddProduct.setForeground(new Color(255, 255, 255));
		btnAddProduct.setBackground(new Color(147, 112, 219));
		btnAddProduct.setBounds(225, 92, 166, 37);
		contentPanel.add(btnAddProduct);
		
		JButton btnAddbrand = new JButton("Add Brand");
		btnAddbrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBrandToSystem addBrand = new AddBrandToSystem();
				addBrand.setVisible(true);
			}
		});
		btnAddbrand.setForeground(new Color(255, 255, 255));
		btnAddbrand.setBackground(new Color(147, 112, 219));
		btnAddbrand.setBounds(23, 153, 166, 37);
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
		btnExploreProduct.setBounds(225, 153, 166, 37);
		contentPanel.add(btnExploreProduct);
		
		JLabel lblAdminName = new JLabel(adminController.getName(id));
		lblAdminName.setFont(new Font("Snap ITC", Font.BOLD, 18));
		lblAdminName.setBounds(10, 11, 192, 27);
		contentPanel.add(lblAdminName);

		JButton btnProvideVoucherCard = new JButton("Provide Voucher Card");
		btnProvideVoucherCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVoucherCardPage addVC = new AddVoucherCardPage();
				addVC.setVisible(true);
			}
		});
		btnProvideVoucherCard.setForeground(Color.WHITE);
		btnProvideVoucherCard.setBackground(new Color(147, 112, 219));
		btnProvideVoucherCard.setBounds(225, 213, 166, 37);
		contentPanel.add(btnProvideVoucherCard);
		
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
		btnSearchForProduct.setBounds(23, 213, 166, 37);
		contentPanel.add(btnSearchForProduct);
		
		JButton btnViewSuggestedProducts = new JButton("View Suggested Products");
		btnViewSuggestedProducts.setBackground(new Color(147, 112, 219));
		btnViewSuggestedProducts.setForeground(new Color(255, 255, 255));
		btnViewSuggestedProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
	        		ProductController productController = new ProductController();
	        		ArrayList<Product> suggestedProducts = null;
	        		try {
						suggestedProducts = productController.getSuggestedProducts();
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
	        		SuggestedProductsPage sugestProductPage = null;
					try {
						sugestProductPage = new SuggestedProductsPage(new Product("s", " ", "d", true));
					} catch (ClassNotFoundException | IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	        		try {
	        			sugestProductPage.display(suggestedProducts);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		sugestProductPage.setVisible(true);
				
			}
		});
		btnViewSuggestedProducts.setBounds(23, 274, 368, 37);
		contentPanel.add(btnViewSuggestedProducts);
		
	}
}
