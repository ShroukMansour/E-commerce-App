//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.PremiumStoreownerController;
//import model.Product;
//
//public class PremiumStoreownerControllerTest {
//	PremiumStoreownerController obj = new PremiumStoreownerController();
//	static Product product = new Product("Dell","Dell","Lab",true); 
//
//	  @DataProvider(name = "Test1")
//	  public static Object[][] loginCust(){
//	      return new Object[][]{{true,product}};
//	  }
//	  @Test(dataProvider ="Test1") 
//	  public void LoginCustomer(Product product, int store_id ) throws ClassNotFoundException, IOException{
//	  Assert.assertEquals(product,obj.showMostProductView(store_id));
//	  }
//}
