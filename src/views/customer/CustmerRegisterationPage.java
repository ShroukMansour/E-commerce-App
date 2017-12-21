package views.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CustomerController;
import controllers.ProductController;
import models.FilesOperations;
import models.Product;
import models.Customer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class CustmerRegisterationPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustmerRegisterationPage dialog = new CustmerRegisterationPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public CustmerRegisterationPage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(194, 17, 0, 0);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel.setBounds(24, 17, 74, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			textName = new JTextField();
			textName.setBounds(117, 17, 142, 28);
			contentPanel.add(textName);
			//textName.setText("Enter Your Name");
			textName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Email");
			lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(24, 61, 60, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("password");
			lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(10, 96, 88, 23);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textEmail = new JTextField();
			textEmail.setBounds(117, 52, 142, 26);
			contentPanel.add(textEmail);
			textEmail.setColumns(10);
		}
		{
			textPass = new JTextField();
			textPass.setBounds(117, 91, 142, 28);
			contentPanel.add(textPass);
			textPass.setColumns(10);
		}
		
	
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(147, 112, 219));
				okButton.setBackground(new Color(255, 255, 255));
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Customer user = new Customer ();
						user.setName(textName.getText());
						user.setEmail( textEmail.getText());					
						user.setPassword(textPass.getText());
						user.setType(0);
						
						CustomerController customerController = new CustomerController();
						boolean customerAdded = false;
						try {
							customerAdded = customerController.register(user);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						if (customerAdded) {
							System.out.println("Custmoer added correctly");
						} else {
							System.out.println("Custmoer not added");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(147, 112, 219));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
