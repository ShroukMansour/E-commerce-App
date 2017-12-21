package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AdminController;
import controllers.CustomerController;
import controllers.StoreOwnerController;
import models.Customer;
import views.admin.ControlPanelPage;
import views.customer.CustmerRegisterationPage;
import views.customer.CustomerPanelPage;
import views.storeowner.StoreOwnerPanel;
import views.storeowner.StoreOwnerRegistrationPage;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class WelcomePage2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WelcomePage2 dialog = new WelcomePage2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WelcomePage2() {
		setBounds(100, 100, 544, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(31, 86, 105, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(31, 117, 105, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(213, 86, 99, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(213, 117, 99, 20);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(374, 86, 105, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(374, 117, 105, 20);
		contentPanel.add(textField_5);
		
		JButton btnNewButton = new JButton("sign in");
		btnNewButton.setBackground(new Color(147, 112, 219));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				String pass = textField_1.getText();
				boolean notFound = false;
				CustomerController customerController = new CustomerController();
				int id = -1;
				try {
					id = customerController.login(email, pass);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (id > -1) {
					CustomerPanelPage cpp = new CustomerPanelPage(id);
					cpp.setVisible(true);
				} else {
					System.out.println("Bad sign in");
				}
			}
		});
		btnNewButton.setBounds(31, 173, 105, 28);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("sign in");
		button.setBackground(new Color(147, 112, 219));
		button.setForeground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreOwnerController stowController = new StoreOwnerController();
				try {
					int id = stowController.login(textField_2.getText(), textField_3.getText());
					if (id > -1) {
						StoreOwnerPanel stowPanel = new StoreOwnerPanel(id);
						stowPanel.setVisible(true);
					} else {
						System.out.println("Not logged");
					}
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(213, 173, 99, 28);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("sign in");
		button_1.setBackground(new Color(147, 112, 219));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminController adminController = new AdminController();
				try {
					adminController.createFirstAdmin();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String email = textField_4.getText();
				String password = textField_5.getText();
				try {
					int id = adminController.login(email, password);
					if (id > -1) {
						ControlPanelPage cpp = new ControlPanelPage(id);
						cpp.setVisible(true);
					} else {
						
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(374, 173, 105, 74);
		contentPanel.add(button_1);
		
		JButton btnNewButton_1 = new JButton("register");
		btnNewButton_1.setBackground(new Color(147, 112, 219));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustmerRegisterationPage crp = new CustmerRegisterationPage();
				crp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(31, 219, 105, 28);
		contentPanel.add(btnNewButton_1);
		
		JButton button_2 = new JButton("register");
		button_2.setBackground(new Color(147, 112, 219));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreOwnerRegistrationPage stowPage = new StoreOwnerRegistrationPage();
				stowPage.setVisible(true);
			}
		});
		button_2.setBounds(213, 219, 99, 28);
		contentPanel.add(button_2);
		
		JLabel lblCustomer = new JLabel("customer");
		lblCustomer.setForeground(new Color(0, 0, 0));
		lblCustomer.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblCustomer.setBounds(32, 43, 115, 28);
		contentPanel.add(lblCustomer);
		
		JLabel lblStoreOwner = new JLabel("store owner");
		lblStoreOwner.setForeground(new Color(147, 112, 219));
		lblStoreOwner.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblStoreOwner.setBounds(213, 43, 124, 28);
		contentPanel.add(lblStoreOwner);
		
		JLabel lblAdmin = new JLabel("admin");
		lblAdmin.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblAdmin.setBounds(374, 43, 99, 28);
		contentPanel.add(lblAdmin);
	}
}
