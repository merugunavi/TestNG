package myfirstprj.Selwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Registration {

		static WebDriver driver;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm");

		driver.findElement(By.name("customer.firstName")).sendKeys("Vihaan");
		
		driver.findElement(By.name("customer.lastName")).sendKeys("Merugu");
		
		driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > form:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).sendKeys("Hethrington Road");
		
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Ranui");
		
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Auckland");
		
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("N1213");
		
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("7352674");

		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("4566");

		driver.findElement(By.id("customer.username")).sendKeys("navitha");
		
		driver.findElement(By.name("customer.password")).sendKeys("vishnu");
	
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("vishnu");
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
	 
	}

}
