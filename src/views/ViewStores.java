package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controllers.ProductController;
import controllers.StoreController;
import controllers.StoreOwnerController;
import models.Product;
import models.Store;
import views.customer.HomePage;
import views.storeowner.AddProductToStore;
import java.awt.Color;

public class ViewStores extends JPanel {

	StoreController storeController = new StoreController();
	public ViewStores(Store store, int id) throws ClassNotFoundException, IOException {
		setBackground(new Color(255, 255, 255));
        //this.setBorder(BorderFactory.createTitledBorder(product.getCategory()));
        
        JLabel lblNewLabel = new JLabel(store.getStoreName());
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton btnNewButton = new JButton("View products in this store");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { //////////////////
        		ProductController productController = new ProductController();
        		ArrayList<Product> productsInStore = null;
        		try {
					productsInStore = productController.getAllProductsInStore(store.getStore_id());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		HomePage homePage = new HomePage(new Product("s", " ", "d", true), id);
        		try {
					homePage.display(productsInStore, id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		homePage.setVisible(true);
        	}
        });
        GroupLayout layout = new GroupLayout(this);
        if (!storeController.hasStorOwnerThisStore(store.getStore_id(), id)) {
            layout.setHorizontalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(btnNewButton)
            			.addGap(18)
            			.addContainerGap(45, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addGap(26)
            			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
            				.addComponent(btnNewButton)
            				)
            			.addContainerGap(224, Short.MAX_VALUE))
            );
            
        } else {
            JButton btnNewButton_1 = new JButton("Add product to this store");
            btnNewButton_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) { 
            		AddProductToStore addProductToStore = null;
					try {
						addProductToStore = new AddProductToStore(store.getStore_id());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		addProductToStore.setVisible(true);
            			
            	}
            });
            layout.setHorizontalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addComponent(btnNewButton)
            			.addGap(18)
            			.addComponent(btnNewButton_1)
            			.addContainerGap(45, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addGap(26)
            			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
            				.addComponent(btnNewButton)
            				.addComponent(btnNewButton_1))
            			.addContainerGap(224, Short.MAX_VALUE))
            );
        }

        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    public static void display(ArrayList<Store> stores, int id) throws IOException, ClassNotFoundException {
        JFrame f = new JFrame("GroupPanel");
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 0; i < stores.size(); i++) {
        	f.getContentPane().add(new ViewStores(stores.get(i), id));
		}
        f.getContentPane().add(Box.createVerticalGlue());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
