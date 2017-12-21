//package controller.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import controller.CustomerController;
//import model.User;
//
//public class CustomerControllerTest {
//	CustomerController obj =  new CustomerController(); 
//	static User user = new User("sama", "sama","sama");
//	static User user2 = new User("nada", "nada","nada");
//	  @DataProvider(name = "Test")
//	  public static Object[][] registerCustomer(){
//	      return new Object[][]{{true,user},{true,user2}};
//	  }
//	  @Test(dataProvider ="Test") 
//	  public void registeration(boolean id, User user) throws ClassNotFoundException, IOException{
//	  Assert.assertEquals(id,obj.register(user));
//	  }
//	  
//	  @DataProvider(name = "Test1")
//	  public static Object[][] loginCust(){
//	      return new Object[][]{{1,"shrouk","1234"},{2,"mai","mai"}};
//	  }
//	  @Test(dataProvider ="Test1") 
//	  public void LoginCustomer(int x, String email , String password) throws ClassNotFoundException, IOException{
//	  Assert.assertEquals(x,obj.login(email, password));
//	  }
//
//
//}
