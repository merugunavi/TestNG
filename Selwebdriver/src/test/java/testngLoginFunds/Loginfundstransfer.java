package testngLoginFunds;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Loginfundstransfer {
 
  static WebDriver driver;	

  @Test (description="This test is to check the login functionality", priority=1)
  
  @Parameters({"username","password"})
  public void log(String username,String password) {
	 	
	driver.findElement(By.name("username")).sendKeys(username);
	
	 driver.findElement(By.name("password")).sendKeys(password);
	 
	 driver.findElement(By.xpath("//input[@value='Log In']")).click();
	 
	 String url= "https://parabank.parasoft.com/parabank/overview.htm";
	 
	 System.out.println("login successful");

  }
  @Test(description="transfer funds once enters into login ", priority=2)
  @Parameters({"username","password"})
	 public void tf(String username,String password)  {
	  
	 driver.findElement(By.name("username")).sendKeys(username);
		
	 driver.findElement(By.name("password")).sendKeys(password);
		 
	 driver.findElement(By.xpath("//input[@value='Log In']")).click();
		 
		 
	String account = driver.findElement(By.xpath("//h2[normalize-space()='Account Services']")).getText();
	
	Assert.assertTrue(account.contains("Account Services"));
		
	 driver.findElement(By.xpath("//a[normalize-space()='Transfer Funds']")).click();
	 
	 String tf = driver.findElement(By.className("title")).getText();
	 
	 Assert.assertTrue(tf.contains("Transfer Funds"));
	 
	 driver.findElement(By.name("input")).sendKeys("200");
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	 
  }

  @AfterMethod
  public void afterMethod() {
	
	  driver.close();
	  driver.quit();
 
  }
  

}
