package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.FilesOperations;
import models.VoucherCard;

public class VoucherCardController {
	VoucherCard vc = new VoucherCard();
	
	public boolean verifySerialNum(int serialNum) throws IOException {
		boolean found = vc.getSerialNum(serialNum);
		return found;
	}


	public boolean addVoucherCard(int serialNum, int val) throws IOException {
		// TODO Auto-generated method stub
		vc.addVoucherCard(serialNum, val);
		return true;
	}
	

	public ArrayList<VoucherCard> getAllVouchers() throws IOException {
		ArrayList<VoucherCard> vouchers = new ArrayList<VoucherCard>();
		vouchers = vc.getAllVouchers();
		return vouchers;
	}

	public boolean verifyWithdraw(int productId, double productPrice, int serialNum) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<VoucherCard> vouchers = getAllVouchers();
		double value = -1;
		for (int i = 0; i < vouchers.size(); i++) {
			if (vouchers.get(i).getSerialNum() == serialNum) {
				value = vouchers.get(i).getValue();
				if (productPrice <= value) {
					if (productPrice - value == 0) {
						vouchers.remove(i);
					} else {
						vouchers.get(i).setValue(value - productPrice);
					}
					vc.updateVoucherCards(vouchers);
					break;
				}
			}
		}

		if (productPrice <= value) {
			
			vc.reduceVoucherValue(serialNum, productPrice);
			ProductController productController = new ProductController();
			productController.buyProduct(productId);
			return true;
		}
		return false;	
	}
}
