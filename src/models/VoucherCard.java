package models;

import java.io.IOException;
import java.util.ArrayList;

public class VoucherCard {

	double value;
	int serialNum;
	FilesOperations filesOps = new FilesOperations();

	
	public double getValue() {
		return value;
	}
	public void setValue(double d) {
		this.value = d;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public boolean getSerialNum(int serialNum) throws IOException {
		// TODO Auto-generated method stub
		boolean found = filesOps.readSerialNum(serialNum);
		return found;
	}
	public void addVoucherCard(int serialNum2, int val) throws IOException {
		// TODO Auto-generated method stub
		filesOps.addVoucherCard(serialNum2, val);	
	}
	public ArrayList<VoucherCard> getAllVouchers() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<VoucherCard> vouchers = new  ArrayList<VoucherCard>();
		vouchers = filesOps.readAllVouchers();
		return vouchers;
	}
	public void reduceVoucherValue(int serialNum2, double productPrice) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<VoucherCard> vouchers = getAllVouchers();
	}
	public void updateVoucherCards(ArrayList<VoucherCard> vouchers) throws IOException {
		filesOps.updateVoucherCards(vouchers);
	}
}













