package myfirstprj.Selwebdriver;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParabankLogin {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		driver.findElement(By.name("username")).sendKeys("navitha");
		
		driver.findElement(By.name("password")).sendKeys("vishnu");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
	//	String msg=driver.findElement(By.name("error")).getText();
		}
}
