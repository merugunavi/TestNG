package myfirstprj.Selwebdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Skryabin {
	
	static WebDriver driver;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		
		driver.findElement(By.xpath("//input[@id='name']")).click();
		
		driver.findElement(By.xpath("//div[@role='dialog']"));
		
		driver.findElement(By.name("firstName")).sendKeys("Navitha");
		
		driver.findElement(By.name("lastName")).sendKeys("Merugu");

		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		
		driver.findElement(By.name("countryOfOrigin")).click();
		
	
		Select se = new Select(driver.findElement(By.xpath("//select[@name='countryOfOrigin']")));
		 
		se.selectByValue("Canada");
		se.selectByIndex(3);
		
		driver.findElement(By.id("address")).sendKeys("Hetherington road, ranui");
		
		driver.findElement(By.xpath("//button[normalize-space()='3rd party agreement (click)']")).click();
		
		driver.switchTo().alert().accept();
	
		//driver.findElement(By.xpath("//label[@class='required checkbox_radio']")).click();
		
		driver.findElement(By.name("username")).sendKeys("navitha");
		
		driver.findElement(By.name("password")).sendKeys("vishnu");
		
		driver.findElement(By.name("phone")).sendKeys("0221912708");
		
		driver.findElement(By.xpath("//div[@id='samplePageForm']//div[5]")).click();
		
		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		Select op = new Select(driver.findElement(By.name("carMake")));
		op.selectByVisibleText("BMW");
		
		driver.findElement(By.xpath("//button[normalize-space()='Related documents (click)']")).click();
			
		driver.switchTo().window("http://skryabin.com/webdriver/html/sample.html");
	
		driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-8 col-lg-8 md-padding-left']//div[2]")).click();
		driver.findElement(By.name("email")).sendKeys("merugunavi@gmail.com");
		
		driver.findElement(By.name("confirmPassword")).sendKeys("vishnu");
		
		//driver.findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("27/05/90");
			
		driver.findElement(By.xpath("//div[6]//label[2]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//html")));
		driver.findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("vishnu");
		driver.findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("02014567");
		
	
	}
	
}