//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.ProductController;
//import controller.VoucherCardController;
//import model.Product;
//
//public class VoucherCardControllerTest {
//
//   
//		VoucherCardController obj = new VoucherCardController(); 
//		  @DataProvider(name = "Test")
//		  public static Object[][] registerCustomer(){
//		      return new Object[][]{{true,2,4},{true,3,4}};
//		  }
//		  @Test(dataProvider ="Test") 
//		  public void buyProduct(boolean done, int serialNum, int val ) throws ClassNotFoundException, IOException{
//			  Assert.assertEquals(done, obj.addVoucherCard(serialNum, val));
//		  }
//  }
//
