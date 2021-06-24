package parabankTestNG;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RegTestNg {
	static WebDriver driver;	

  @Test (description= "This test is used to test the registration Priority=1")
		  public void Reg() {
 
	   driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	   
	   String reg="Signing up is easy!";
	   Assert.assertTrue(reg.contains("Signing up is easy!"));
	   System.out.println("Registration page");
	   
	   driver.findElement(By.name("customer.firstName")).sendKeys("Vihaan");
		
		driver.findElement(By.name("customer.lastName")).sendKeys("Guda");
		
		driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > form:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).sendKeys("Hethrington Road");
		
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Ranui");
		
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Auckland");
		
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("N1213");
		
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("7352674");

		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("126");

		driver.findElement(By.id("customer.username")).sendKeys("aaa");
		driver.findElement(By.name("customer.password")).sendKeys("123");
	
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("123");
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		String welcome = driver.findElement(By.xpath("//b[normalize-space()='Welcome']")).getText();
		Assert.assertTrue(welcome.contains("Welcome"));
	
		System.out.println("Registration was successful");
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
