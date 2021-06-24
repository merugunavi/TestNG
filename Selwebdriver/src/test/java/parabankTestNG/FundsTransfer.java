package parabankTestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class FundsTransfer {
	
	static WebDriver driver;
		@BeforeMethod
			public void log() {
			
			WebDriverManager.chromedriver().setup();
				
			driver= new ChromeDriver();
				
			driver.manage().window().maximize();
				
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			 
			 driver.findElement(By.name("username")).sendKeys("aaa");
			
			 driver.findElement(By.name("password")).sendKeys("123");
			 
			 driver.findElement(By.xpath("//input[@value='Log In']")).click();
			 
			
		  }
	 @Test(description="Displays the account details page ", priority=1)
	
	 	 public void tf()  {
		String account = driver.findElement(By.xpath("//h2[normalize-space()='Account Services']")).getText();
		
		Assert.assertTrue(account.contains("Account Services"));
			
		 driver.findElement(By.xpath("//a[normalize-space()='Transfer Funds']")).click();
		 
		 String tf = driver.findElement(By.className("title")).getText();
		 
		 Assert.assertTrue(tf.contains("Transfer Funds"));
		 
		 driver.findElement(By.name("input")).sendKeys("200");
	  
		 
  }
 

  @AfterMethod
  public void afterMethod() {
		  driver.findElement(By.linkText("Log Out")).click();
		  
		  driver.close();
		  
		  driver.quit();
	  
  }

 

}
