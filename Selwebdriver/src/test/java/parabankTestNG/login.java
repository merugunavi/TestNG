package parabankTestNG;

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

public class login {
 
  static WebDriver driver;	

  @Test (description="This test is to check the login functionality")
  
 
  public void log() {
	 	
	 driver.findElement(By.name("username")).sendKeys("aaa");
	
	 driver.findElement(By.name("password")).sendKeys("123");
	 
	 driver.findElement(By.xpath("//input[@value='Log In']")).click();
	 
	 String actualurl= "https://parabank.parasoft.com/parabank/overview.htm";
	 
	 String expectedurl=driver.getCurrentUrl();
	 
	 Assert.assertEquals(actualurl, expectedurl);
	 
	 System.out.println("login successful");

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
