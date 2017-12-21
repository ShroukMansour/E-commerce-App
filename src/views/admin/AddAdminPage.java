package views.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AdminController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddAdminPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	Integer id;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public AddAdminPage(int id) {
		this.id = id;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Snap ITC", Font.PLAIN, 13));
			txtName.setText("Name");
			txtName.setBounds(42, 62, 219, 26);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblEnterAdminInfromation = new JLabel("Enter admin infromation");
			lblEnterAdminInfromation.setForeground(new Color(147, 112, 219));
			lblEnterAdminInfromation.setFont(new Font("Snap ITC", Font.PLAIN, 15));
			lblEnterAdminInfromation.setBounds(10, 11, 251, 26);
			contentPanel.add(lblEnterAdminInfromation);
		}
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		txtEmail.setText("Email");
		txtEmail.setBounds(42, 103, 219, 26);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		txtPassword.setText("Password");
		txtPassword.setBounds(42, 144, 219, 26);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 225, 434, 36);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AdminController adminController = new AdminController();
						String name = txtName.getText();
						String email = txtEmail.getText();
						String password = txtPassword.getText();
						boolean adminAdded = false;
						try {
							try {
								adminAdded = adminController.addAdmin(id, name, email, password);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (adminAdded) {
							System.out.println("Addin added");
						} else {
							System.out.println("Addin notttt added");
						}
						
					}
				});
				okButton.setFont(new Font("Snap ITC", Font.PLAIN, 13));
				okButton.setForeground(new Color(147, 112, 219));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setBounds(263, 5, 74, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("Snap ITC", Font.PLAIN, 13));
				cancelButton.setForeground(new Color(147, 112, 219));
				cancelButton.setBounds(347, 5, 82, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


}
