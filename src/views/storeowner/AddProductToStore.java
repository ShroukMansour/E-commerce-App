package views.storeowner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import controllers.BrandController;
import controllers.ProductController;
import models.Brand;
import models.Product;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddProductToStore extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCategory;
	private JTextField txtPrice;
	
	BrandController brandController = new BrandController();
	ProductController productController = new ProductController();
	private JTextField txtNumOfItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProductToStore dialog = new AddProductToStore(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public AddProductToStore(int store_id) throws IOException {
		setBounds(100, 100, 450, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(31, 69, 124, 20);
		comboBox2.setBounds(31, 69, 86, 20);
		ArrayList<Brand> brands = new ArrayList<>();
		brands = brandController.getAllBrands();
		for (Brand brand2 : brands) {
			comboBox2.addItem(brand2.getName());
		}
		contentPanel.add(comboBox2);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 99, 86, 20);
		ArrayList<Product> products = new ArrayList<>();
		products = productController.getAllProducts();
		for (Product product : products) {
			comboBox.addItem(product.getName());
		}
		contentPanel.add(comboBox);
		
		txtCategory = new JTextField();
		txtCategory.setForeground(new Color(255, 255, 255));
		txtCategory.setBackground(new Color(147, 112, 219));
		txtCategory.setText("Category");
		txtCategory.setBounds(31, 132, 129, 20);
		contentPanel.add(txtCategory);
		txtCategory.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(new Color(147, 112, 219));
		txtPrice.setText("Price");
		txtPrice.setColumns(10);
		txtPrice.setBounds(31, 163, 129, 20);
		contentPanel.add(txtPrice);
		JRadioButton rdbtnHardware = new JRadioButton("Hardware");
		rdbtnHardware.setForeground(new Color(147, 112, 219));
		rdbtnHardware.setBackground(new Color(255, 255, 255));
		rdbtnHardware.setBounds(31, 253, 109, 23);
		contentPanel.add(rdbtnHardware);
		
		JRadioButton rdbtnSoftware = new JRadioButton("Software");
		rdbtnSoftware.setForeground(new Color(147, 112, 219));
		rdbtnSoftware.setBackground(new Color(255, 255, 255));
		rdbtnSoftware.setBounds(31, 279, 109, 23);
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnSoftware);
		radioGroup.add(rdbtnHardware);
		contentPanel.add(rdbtnSoftware);
		
		txtNumOfItems = new JTextField();
		txtNumOfItems.setBackground(new Color(147, 112, 219));
		txtNumOfItems.setText("Num of items");
		txtNumOfItems.setColumns(10);
		txtNumOfItems.setBounds(31, 194, 129, 20);
		contentPanel.add(txtNumOfItems);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				okButton.setForeground(new Color(147, 112, 219));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Product product = new Product(comboBox.getSelectedItem().toString(), comboBox2.getSelectedItem().toString()
								, txtCategory.getText(), Double.parseDouble(txtPrice.getText())
								, Integer.parseInt(txtNumOfItems.getText()));
						if (rdbtnSoftware.isSelected())
							product.setType(false);
						else 
							product.setType(true);
						productController.addProductToStore(product, store_id);
							
					
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				cancelButton.setForeground(new Color(147, 112, 219));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
