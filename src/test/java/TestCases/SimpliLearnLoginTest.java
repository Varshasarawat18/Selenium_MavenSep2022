package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

@Listeners(ListenerExample.class)   // this is for listerexample class what it will do it always listerns to the class whenever run

public class SimpliLearnLoginTest extends BaseClass {

	@Test
	public void Test1() throws InterruptedException {
		
		test.log(LogStatus.INFO, "Test1 Started");   //for extent report this line added here
		LoginPage lp = new LoginPage(driver);
		lp.login("abc@gmail.com", "Simpli@13");

		// step 6 to validate error
		WebElement Error = driver.findElement(By.id("msg_box"));

		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError,ExpError);
		System.out.println("Test1 passed and executed");

	}

	@Test
	@Parameters({"uname","pwd"})
	public void Test2(String UserName,String Password) throws InterruptedException {
		
		test.log(LogStatus.INFO, "Test2 Started");

		LoginPage lp = new LoginPage(driver);
		lp.login(UserName, Password);      // here we are passing value as parameter and taking input form testng.xml
		System.out.println("Test2 passed and executed");
	}

	@Test
	public void Test3()throws InterruptedException
	{
		test.log(LogStatus.INFO, "Test3 Started");

		String UserName= xsheet.getRow(1).getCell(0).getStringCellValue();  //taking input from sheet
		String Password= xsheet.getRow(1).getCell(1).getStringCellValue();

		LoginPage lp = new LoginPage(driver);
		lp.login(UserName, Password);
		System.out.println("Test3 passed with reading date from excel and executed");

	}
	
	
}
