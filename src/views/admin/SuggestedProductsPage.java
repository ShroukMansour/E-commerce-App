package views.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
import models.Product;
import models.Store;
import java.awt.Color;

public class SuggestedProductsPage extends JPanel {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	StoreController storeController = new StoreController();
	public SuggestedProductsPage(Product product) throws ClassNotFoundException, IOException {
		setBackground(new Color(255, 255, 255));
        //this.setBorder(BorderFactory.createTitledBorder(product.getCategory()));
        
        JLabel lblNewLabel = new JLabel(product.getName());
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton btnNewButton = new JButton("Add product to system");
        btnNewButton.setBackground(new Color(147, 112, 219));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { //////////////////
        		ProductController productController = new ProductController();
        		Product product = new Product(lblNewLabel.getText(), "general", "general", true);
        		try {
					productController.addProductToSystem(product);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
        			.addGap(55)
        			.addComponent(btnNewButton)
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(39)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(234, Short.MAX_VALUE))
        );
        

        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    public static void display(ArrayList<Product> products) throws IOException, ClassNotFoundException {
        JFrame f = new JFrame("GroupPanel");
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 0; i < products.size(); i++) {
        	f.getContentPane().add(new SuggestedProductsPage(products.get(i)));
		}
        f.getContentPane().add(Box.createVerticalGlue());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
