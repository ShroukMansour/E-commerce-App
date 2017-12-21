//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.BrandController;
//import controller.ProductController;
//import model.Brand;
//
//public class BrandControllerTest {
//	static Brand brand = new Brand("giza");
//	static Brand brand1 = new Brand("Dokki");
//	BrandController obj =  new BrandController(); 
//
//	  @DataProvider(name = "Test1")
//	  public static Object[][] loginCust(){
//	      return new Object[][]{{true,brand},{true,brand1}};
//	  }
//	  @Test(dataProvider ="Test1") 
//	  public void AddBrand(boolean x, Brand brand) throws ClassNotFoundException, IOException{
//	  Assert.assertEquals(x,obj.addBrandToSystem(brand));
//	  
//	  }
//  
//  
//}
