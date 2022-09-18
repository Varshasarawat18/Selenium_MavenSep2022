package TestCases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	WebDriver driver;  //As webdriver is abstract class we cannot create
	
	XSSFWorkbook wbook;  //Using when we need to take input from xcel file and for that apache poi plugin is aslo added here 
	XSSFSheet xsheet;
	
	ExtentReports report;   //whenever report variable is created we need to initialize report before test and close it after test 
	ExtentTest test;
	
	@BeforeTest
	public void TestDataSetup() throws IOException
	{
		FileInputStream fis= new FileInputStream("exceldata.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		xsheet= wbook.getSheet("Sheet1");  //from sheet 1 need to reed data		
		
		report=new ExtentReports("ExtentReport.html");   //extent repott 
	}
	
	@AfterTest
	public void testDataCleanup() throws IOException
	{
		wbook.close();
		
		report.flush();     //this will remove everything from memory it will not keep anything in memory extent report
		report.close();
	}
	
	@BeforeMethod
	public void testSetup(Method method)
	{
		test = report.startTest(method.getName());	

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	}	
	
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		driver.close();
		
	}

}
