package TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends BaseClass {
	
	
	@Test
	public void test1()
	{
		test.log(LogStatus.INFO, "Test2 Started");
		System.out.println("Inside Home Test");
		System.out.println("Test1 Home passed and executed");

	}

}
