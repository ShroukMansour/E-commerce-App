//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.CustomerController;
//import controller.ProductController;
//import model.Product;
//import model.User;
//
//public class ProductControllerTest {
//
// /* @Test
//  public void addProductToSystem() {
//    throw new RuntimeException("Test not implemented");
//  }
//
//  @Test
//  public void buyProduct() {
//    throw new RuntimeException("Test not implemented");
//  }*/
//	ProductController obj =  new ProductController(); 
//	static Product product = new Product("Dell","Dell","Lab",true); 
//	
//	  @DataProvider(name = "Test")
//	  public static Object[][] registerCustomer(){
//	      return new Object[][]{{true,2},{true,3}};
//	  }
//	  @Test(dataProvider ="Test") 
//	  public void buyProduct(boolean done, int productId ) throws ClassNotFoundException, IOException{
//		  Assert.assertEquals(done, obj.buyProduct(productId));
//	  }
//	  
//	  @DataProvider(name = "Test1")
//	  public static Object[][] loginCust(){
//	      return new Object[][]{{true,product}};
//	  }
//	  @Test(dataProvider ="Test1") 
//	  public void LoginCustomer(boolean added , Product product) throws ClassNotFoundException, IOException{
//	  Assert.assertEquals(added,obj.addProductToSystem(product));
//	  }
//	  @DataProvider(name = "Test2")
//	  public static Object[][] AddProducToStore(){
//	      return new Object[][]{{true,product}};
//	  }
//	  @Test(dataProvider ="Test2") 
//	  public void AddProducToStore(boolean added , Product product , int store_id) throws ClassNotFoundException, IOException{
//		  Assert.assertEquals(added,obj.addProductToStore(product, store_id));
//	  }
//	  /// return false if product exist
//	  @DataProvider(name = "SuggestProduct")
//	  public static Object[][] SuggestProduct(){
//	      return new Object[][]{{true,product}};
//	  }
//	  @Test(dataProvider ="SuggestProduct") 
//	  public void SuggestProduct(boolean exist , Product product ) throws ClassNotFoundException, IOException{
//		  Assert.assertEquals(exist,obj.suggestProduct(product));
//	  }
//}
