package views.storeowner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.PremiumStoreownerController;
import controllers.StoreOwnerController;
import controllers.VoucherCardController;
import models.PremiumStoreowner;
import models.StoreOwner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class StoreOwnerRegistrationPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StoreOwnerRegistrationPage dialog = new StoreOwnerRegistrationPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StoreOwnerRegistrationPage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel.setBounds(28, 35, 88, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(142, 32, 124, 23);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mail");
			lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(28, 72, 88, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(142, 72, 124, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(28, 117, 88, 23);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(142, 117, 124, 23);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PremiumStoreOwner");
		rdbtnNewRadioButton.setForeground(new Color(147, 112, 219));
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(163, 167, 133, 34);
		{
			JButton btnNewButton = new JButton("Register");
			btnNewButton.setForeground(new Color(147, 112, 219));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.addActionListener(new ActionListener() {

				int type = 0;
				public void actionPerformed(ActionEvent e) {
					String name = textField.getText();
					String email = textField_1.getText();
					String password = textField_2.getText();
					if (rdbtnNewRadioButton.isSelected()) {
						type = 1;
//						int serialNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter serial num: "));
//						VoucherCardController card = new VoucherCardController();
//						try {
//							if (card.verifySerialNum(serialNum)) {
//								
//								if (card.verifyWithdraw(productId, productPrice, Integer.parseInt(textSerial.getText()))) {
//									JOptionPane.showMessageDialog(null,"Succefully sold");
//								}
//								else {
//									JOptionPane.showMessageDialog(null,"Sorry, Not Have Value Enough To Buy Product");
//								}
//								
//							}
//							else {
//								JOptionPane.showMessageDialog(null,"Wrong Serial Number");
//							}
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						PremiumStoreownerController psow = new PremiumStoreownerController();
						try {
							psow.addSN(name, email, password, type);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						StoreOwnerController sowController = new StoreOwnerController();
						try {
							sowController.addSN(name, email, password, type);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						
			
				}
			});
			btnNewButton.setBounds(28, 167, 103, 34);
			contentPanel.add(btnNewButton);
		}
		

		contentPanel.add(rdbtnNewRadioButton);
	}
}
