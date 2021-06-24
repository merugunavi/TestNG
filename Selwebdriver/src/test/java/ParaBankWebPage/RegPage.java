package ParaBankWebPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegPage {
	WebDriver driver;
	public RegPage(WebDriver driver) {
		this.driver=driver;
	}

	By fname=By.name("customer.firstName");
	By lname=By.name("customer.lastName");
	By add=By.name("customer.address.street");
	By city =By.name("customer.address.city");
	By state=By.name("customer.address.state");
	By zcode=By.name("customer.address.zipCode");
	By phone=By.name("customer.phoneNumber");
	By ssn=By.name("customer.ssn");
	By uname=By.name("customer.username");
	By pwd=By.name("customer.password");
	By cpwd=By.name("repeatedPassword");
	By regbtn=By.xpath("//input[@value='Register']");
	
	@Test
	 public void fname(String name) {
		driver.findElement(fname).sendKeys(name);
	  }
 public void lname(String lastname) {
		driver.findElement(lname).sendKeys(lastname);
	  }
 public void add(String address) {
		driver.findElement(add).sendKeys(address);
	  }
 public void city(String c) {
		driver.findElement(city).sendKeys(c);
	  }
public void state(String st) {
		driver.findElement(state).sendKeys(st);
	  }
public void zcode(String code) {
		driver.findElement(zcode).sendKeys(code);
	  }
public void phone(String ph) {
	driver.findElement(phone).sendKeys(ph);
  }
public void ssn(String sn) {
	driver.findElement(ssn).sendKeys(sn);
  }
public void uname(String username) {
	driver.findElement(uname).sendKeys(username);
  }
public void pwd(String password) {
	driver.findElement(pwd).sendKeys(password);
  }
public void confirm(String cpassword) {
	driver.findElement(cpwd).sendKeys(cpassword);
  }
public void regbt() {
	driver.findElement(regbtn).click();
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
