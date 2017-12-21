//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import controller.AdminController;
//
//public class AdminControllerTest {
//
//	
//	AdminController obj = new AdminController();
//
// 
//  @DataProvider(name = "Test1")
//  public static Object[][] loginAdmin(){
//      return new Object[][]{{2,"eman","1234"},{3,"yasmin","1234"}};
//  }
//  @Test(dataProvider ="Test1") 
//  public void login(int x, String email , String password) throws ClassNotFoundException, IOException{
//  Assert.assertEquals(x,obj.login(email, password));
//  }
//  @DataProvider(name = "Test")
//  public static Object[][] AddAdmin(){
//      return new Object[][]{{true,7,"eman","eman","1234"},{true,7,"yasmin","yasmin","1234"}};
//  }
//  @Test(dataProvider ="Test") 
//  public void register(boolean x,int id,String name,String email , String password) throws ClassNotFoundException, IOException{
//  Assert.assertEquals(x,obj.addAdmin(id, name, email, password));
//  }
//  
//  
//}
