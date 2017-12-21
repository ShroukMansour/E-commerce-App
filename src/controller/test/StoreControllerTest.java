//package  controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.StoreController;
//import model.Product;
//import model.Store;
//
//public class StoreControllerTest {
//	
//	static Store store = new Store("Areas", "description" , "location",19777,0,5);
//	static Store store1 = new Store("Areas", "description" , "location",155,0,6);
//	StoreController obj = new StoreController();
//
//
//  @DataProvider(name = "test")
//  public static Object[][] AddStoree(){
//      return new Object[][]{{true,store,5},{true,store1,6}};
//  }
//  @Test(dataProvider ="test") 
//  public void AddStore(boolean added , Store St , int id) throws ClassNotFoundException, IOException{
//	 Assert.assertNotEquals(added, obj.addStore(St, id));
//  }
//}
