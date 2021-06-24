package ParaBankWebPage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class RegTest {
	static WebDriver driver;
  @Test
  public void reg() throws Exception{
	  try {
		  
		  HomePage page=new HomePage(driver);
		  page.reg();
		  String reg="Signing up is easy!"; 
		  Assert.assertTrue(reg.contains("Signing up is easy!"));
		RegPage re=new RegPage(driver);
		re.fname("navitha");
		re.lname("merugu");
		re.add("ranui");
		re.city("auck");
		re.state("auckland");
		re.zcode("5643");
		re.phone("967543345");
		re.ssn("1234");
		re.uname("navitha");
		re.pwd("123");
		re.confirm("123");
		re.regbt();
	  }
	  catch(Throwable e)
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
