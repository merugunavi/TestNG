package ParaBankWebPage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	  

	By abtus=By.xpath("//ul[@class='leftmenu']//li//a[@href='about.htm'][normalize-space()='About Us']");
	By services=By.xpath("//ul[@class='leftmenu']//li//a[@href='services.htm'][normalize-space()='Services']");
	By products=By.xpath("//ul[@class='leftmenu']//a[normalize-space()='Products']");
	By locations=By.xpath("//ul[@class='leftmenu']//a[normalize-space()='Locations']");
	By adminpg=By.xpath("//a[normalize-space()='Admin Page']");
	By name=By.name("username");
	By pwd=By.name("password");
	By logbtn= By.xpath("//input[@value='Log In']");
	By forgotlogin=By.xpath("//a[normalize-space()='Forgot login info?']");
	By register=By.linkText("Register");
	
@Test
	@Parameters({"username","password"})
	
	 public void aboutus() {
			driver.findElement(abtus).click();
		  }
	 public void services() {
			driver.findElement(services).click();
		  }
	 public void products() {
			driver.findElement(products).click();
		  }
	 public void locations() {
			driver.findElement(locations).click();
		  }
	 public void adminpg() {
			driver.findElement(adminpg).click();
		  }
	
	 public void name(String username) {
		 	driver.findElement(name).sendKeys(username);
	 		}
	 public void pwd(String password) {
			driver.findElement(pwd).sendKeys(password);
		  }
	 public void logbtn() {
			driver.findElement(logbtn).click();
		  }
	 public void flogin() {
		 driver.findElement(forgotlogin).click();
	 }
	 public void reg() {
		 driver.findElement(register).click();
	 }

	

}
