package views.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.BrandController;
import models.Brand;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddBrandToSystem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddBrandToSystem dialog = new AddBrandToSystem();
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddBrandToSystem() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtName.setBackground(new Color(255, 255, 255));
			txtName.setForeground(new Color(147, 112, 219));
			txtName.setText("Name");
			txtName.setBounds(151, 90, 115, 32);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setForeground(new Color(147, 112, 219));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Brand brand = new Brand(txtName.getText());
						BrandController brandController = new BrandController();
						boolean brandAdded = false;
						try {
							brandAdded = brandController.addBrandToSystem(brand);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (brandAdded) {
							System.out.println("Brand added correctly");
						} else {
							System.out.println("Brand not added");
						}
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setForeground(new Color(147, 112, 219));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
