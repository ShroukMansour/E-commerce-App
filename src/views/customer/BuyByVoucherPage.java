package views.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.VoucherCardController;
import models.FilesOperations;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class BuyByVoucherPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textSerial;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			BuyByVoucherPage dialog = new BuyByVoucherPage(75.10);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public BuyByVoucherPage(int productId, double productPrice) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setForeground(new Color(147, 112, 219));
		lblSerialNumber.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblSerialNumber.setBounds(23, 43, 112, 31);
		contentPanel.add(lblSerialNumber);
		
		textSerial = new JTextField();
		textSerial.setBounds(158, 40, 144, 34);
		contentPanel.add(textSerial);
		textSerial.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enter");
				okButton.setForeground(new Color(147, 112, 219));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						VoucherCardController card = new VoucherCardController();
						try {
							if (card.verifySerialNum(Integer.parseInt(textSerial.getText()))) {
								
								if (card.verifyWithdraw(productId, productPrice, Integer.parseInt(textSerial.getText()))) {
									JOptionPane.showMessageDialog(null,"Succefully sold");
								}
								else {
									JOptionPane.showMessageDialog(null,"Sorry, Not Have Value Enough To Buy Product");
								}
								
							}
							else {
								JOptionPane.showMessageDialog(null,"Wrong Serial Number");
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
