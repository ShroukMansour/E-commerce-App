package views.storeowner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import controllers.ProductController;
import models.Brand;
import models.Product;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SuggestProductPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public SuggestProductPage() throws IOException {
		setBounds(100, 100, 450, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			txtName.setText("Name");
			txtName.setBounds(31, 40, 140, 29);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		JTextField txtCategory = new JTextField();
		txtCategory.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		txtCategory.setText("Category");
		txtCategory.setBounds(31, 111, 140, 23);
		contentPanel.add(txtCategory);
		txtCategory.setColumns(10);
		
		JRadioButton rdbtnHardware = new JRadioButton("Hardware");
		rdbtnHardware.setForeground(new Color(255, 255, 255));
		rdbtnHardware.setBackground(new Color(147, 112, 219));
		rdbtnHardware.setBounds(31, 170, 172, 23);
		contentPanel.add(rdbtnHardware);
		
		JRadioButton rdbtnSoftware = new JRadioButton("Software");
		rdbtnSoftware.setForeground(new Color(255, 255, 255));
		rdbtnSoftware.setBackground(new Color(147, 112, 219));
		rdbtnSoftware.setBounds(244, 170, 163, 23);
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnSoftware);
		radioGroup.add(rdbtnHardware);
		contentPanel.add(rdbtnSoftware);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 80, 140, 20);
		Brand brand = new Brand();
		ArrayList<Brand> brands = new ArrayList<>();
		brands = brand.getAllBrands();
		for (Brand brand2 : brands) {
			comboBox.addItem(brand2.getName());
		}
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				okButton.setBackground(new Color(147, 112, 219));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = txtName.getText();
						String brand = (String) comboBox.getSelectedItem();
						String category = txtCategory.getText();
						boolean type;
						if (rdbtnHardware.isSelected()) {
							type = true;
						} else {
							type = false;
						}
						Product product = new Product(name, brand, category, type);
						ProductController productController = new ProductController();
						boolean productAdded = false;
						try {
							productAdded = productController.suggestProduct(product);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						if (productAdded) {
							System.out.println("Product suggested correctly");
						} else {
							System.out.println("Product not suggested");
						}
					}
				});
				okButton.setActionCommand("Suggest");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				cancelButton.setBackground(new Color(147, 112, 219));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
