package parabankTestNG;

import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
public class DataProviderExcel {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		 
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

	}
	@Test(dataProvider="loginData")
	  public void Login(String userName, String passWord) {
			
			driver.findElement(By.name("username")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(passWord);
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			
			String welcome = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
			Assert.assertTrue(welcome.contains("Welcome"));
			driver.findElement(By.linkText("Log Out")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
		driver.quit();
	}
	
	
	@DataProvider(name="loginData")
    public Object[][] getDataFromDataprovider(){
	    Object [] [] loginCredentials = readExcelData("C:/Users/64210/Desktop/naviexcel.xlsx", "Sheet1");
	    return loginCredentials;

    }
	
	public String[][] readExcelData(String fileName, String sheetName){
		
		String[][] data = null;   	
  	  	try
  	  	{
  	   	FileInputStream fis = new FileInputStream(fileName);
  	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
  	   	XSSFSheet sh = wb.getSheet(sheetName);
  	   	XSSFRow row = sh.getRow(0);
  	   	int noOfRows = sh.getPhysicalNumberOfRows();
  	   	int noOfCols = row.getLastCellNum();
  	   	Cell cell;
  	   	data = new String[noOfRows-1][noOfCols];
  	   	for(int i =1; i<noOfRows;i++){
  		     for(int j=0;j<noOfCols;j++){
  		    	   row = sh.getRow(i);
  		    	   cell= row.getCell(j);
  		    	   data[i-1][j] = cell.getStringCellValue();
  	   	 	   }
  	   	}
  	  	}
  	  	catch (Exception e) {
  	     	   System.out.println("The exception is: " +e.getMessage());
  	     	           	}
        	return data;
	}
}