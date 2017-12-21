package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CustomerController;
import controllers.PremiumStoreownerController;
import controllers.ProductController;
import controllers.StoreOwnerController;
import models.Product;
import models.Store;
import models.Customer;
import views.customer.BuyByVoucherPage;

import javax.swing.JLabel;

public class ViewProductPage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ViewProductPage dialog = new ViewProductPage();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public ViewProductPage(Product product, int id) throws IOException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("NAme");
			lblNewLabel.setBounds(10, 22, 115, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Category");
			lblNewLabel_1.setBounds(10, 80, 126, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("PRice");
			lblNewLabel_2.setBounds(10, 55, 89, 22);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Brand");
			lblNewLabel_3.setBounds(10, 113, 89, 22);
			contentPanel.add(lblNewLabel_3);
		}
		
		// number of views for Premium store owner and buy for both
		
		JButton btnNewButton = new JButton("Buy");

		btnNewButton.setBounds(271, 175, 89, 23);
			
		JLabel lblNewLabel_4 = new JLabel("Number of views:");
		lblNewLabel_4.setBounds(10, 146, 100, 22);

		JLabel lblNewLabel_5 = new JLabel(Integer.toString(product.getNumOfUsersExplored()));
		lblNewLabel_5.setBounds(109, 150, 46, 14);
		CustomerController customerController = new CustomerController();
		ProductController pc = new ProductController();
		PremiumStoreownerController pswController = new PremiumStoreownerController();
		boolean isCustomer = customerController.isCustomer(id);
		boolean premSOW = false;
		try {
			premSOW = pswController.isPremium(id);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (isCustomer) {
			contentPanel.add(btnNewButton);
			pc.increaseNumOfViews(product.getId());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BuyByVoucherPage bbvp = new BuyByVoucherPage(product.getId(), product.getPrice());
					bbvp.setVisible(true);
				}
			});
		} if(premSOW) {
			contentPanel.add(lblNewLabel_4);
			contentPanel.add(lblNewLabel_5);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			}
		}
	}
}
