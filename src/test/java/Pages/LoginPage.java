package Pages;  // to create page specific test case in that class only 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;	 
	//*************************OBJECTS***********************//
	
	@FindBy(linkText ="Log in")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(className="rememberMe")
	WebElement Remember;
	
	@FindBy(name="btn_login")
	WebElement LoginClick;
	
	//******************************METHODS****************//
	
	public LoginPage(WebDriver basedriver)
	{
		this.driver= basedriver;
		PageFactory.initElements(basedriver, this);
	}
	
	public void login(String loginname , String password) throws InterruptedException  //dont hardcod value always pass parmaeter
	{
		Thread.sleep(5000);
		//step1.click on login 
		LoginLink.click();  //put cursor and check on loginlink // when login click then it will find @find by so login click fail so we need it intiaize so pagefacotry will be used
		
		//Step 2.enter user name
		UserName.sendKeys(loginname);
		
		//Step 3.enter password
		Password.sendKeys(password);
		
		//Step 4 Click on remember me checkbox
		Remember.click();
		
		//Step 5 click login button 
		LoginClick.click();
	}

}
