package views.storeowner;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import models.Product;
import views.ViewProductPage;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.ProductController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/** @see http://stackoverflow.com/questions/8492065 */
public class MostViewdProductsPage extends JPanel {
	

    public MostViewdProductsPage(Product product, int id) {
    	setBackground(new Color(255, 255, 255));
        this.setBorder(BorderFactory.createTitledBorder(product.getCategory()));
        
        JLabel lblNewLabel = new JLabel(product.getName());
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JLabel lblNewLabel_1 = new JLabel(Integer.toString(product.getNumOfUsersExplored()));
        
        JButton btnNewButton = new JButton("View this product");
        btnNewButton.setBackground(new Color(147, 112, 219));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewProductPage vpb = null;
				try {
					vpb = new ViewProductPage(product, id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		vpb.setVisible(true);
        	}
        });
        
        JLabel lblNewLabel_3 = new JLabel("Number if views");
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        					.addGap(29)
        					.addComponent(lblNewLabel_1)))
        			.addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_3)
        				.addComponent(lblNewLabel_1))
        			.addGap(27)
        			.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    public static void display(ArrayList<Product> products, int id) throws IOException {
        JFrame f = new JFrame("GroupPanel");
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 0; i < products.size(); i++) {
        	if ( products.get(i).getNumOfUsersExplored() > -1)
        		f.getContentPane().add(new MostViewdProductsPage(products.get(i), id));
		}
        f.getContentPane().add(Box.createVerticalGlue());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}