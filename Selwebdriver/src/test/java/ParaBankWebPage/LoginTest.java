package ParaBankWebPage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
public class LoginTest {
	   static WebDriver driver;
 @Test
 
  public static void login() throws Exception{
	 try {
	HomePage home=new HomePage(driver);
	
	  home.name("navi");
	  home.pwd("123");
	  home.logbtn();
	  	String actualurl= "https://parabank.parasoft.com/parabank/overview.htm";
		 
		 String expectedurl=driver.getCurrentUrl();
		 
		 Assert.assertEquals(actualurl.contains("Welcome"), expectedurl);
		 
		 System.out.println("login successful");
		
	 }
	 
	catch (Throwable e)
     {
       e.printStackTrace();
      
     }
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
  
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get("https://parabank.parasoft.com/parabank/index.htm");
	  
  }
}
