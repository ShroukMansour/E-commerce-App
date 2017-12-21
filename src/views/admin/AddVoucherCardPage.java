package views.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.VoucherCardController;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddVoucherCardPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPriceValue;
	private JTextField txtSerialNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddVoucherCardPage dialog = new AddVoucherCardPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddVoucherCardPage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtPriceValue = new JTextField();
		txtPriceValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPriceValue.setForeground(new Color(255, 255, 255));
		txtPriceValue.setBackground(new Color(147, 112, 219));
		txtPriceValue.setText("Price value");
		txtPriceValue.setBounds(45, 37, 112, 37);
		contentPanel.add(txtPriceValue);
		txtPriceValue.setColumns(10);
		
		txtSerialNumber = new JTextField();
		txtSerialNumber.setForeground(new Color(255, 255, 255));
		txtSerialNumber.setBackground(new Color(147, 112, 219));
		txtSerialNumber.setText("Serial number");
		txtSerialNumber.setBounds(45, 88, 112, 37);
		contentPanel.add(txtSerialNumber);
		txtSerialNumber.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setForeground(new Color(147, 112, 219));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VoucherCardController vcController = new VoucherCardController();
						boolean serialExsits = true;
						try {
							serialExsits = vcController.verifySerialNum(Integer.parseInt(txtSerialNumber.getText()));
						} catch (NumberFormatException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (!serialExsits) {
							try {
								boolean added = vcController.addVoucherCard(Integer.parseInt(txtSerialNumber.getText()), 
										Integer.parseInt(txtPriceValue.getText()));
								if (added) {
									System.out.println("Voucher card addes");
								} else {
									System.out.println("Voucher not added");
								}
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				
						} else {
							System.out.println("Serial not added");
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
