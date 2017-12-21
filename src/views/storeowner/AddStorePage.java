package views.storeowner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.StoreController;
import models.Store;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddStorePage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddStorePage dialog = new AddStorePage(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddStorePage(int id) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setForeground(new Color(147, 112, 219));
			lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			lblNewLabel.setBounds(35, 33, 110, 24);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setForeground(new Color(147, 112, 219));
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 84, 110, 24);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(165, 37, 117, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 88, 117, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(147, 112, 219));
			buttonPane.setForeground(new Color(147, 112, 219));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			btnNewButton.setForeground(new Color(147, 112, 219));
			btnNewButton.setBackground(new Color(255, 255, 255));
			buttonPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Store store = new Store(textField.getText(), textField_1.getText());
					StoreController storeController = new StoreController();
					try {
						storeController.addStore(store, id);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setForeground(new Color(147, 112, 219));
				cancelButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
