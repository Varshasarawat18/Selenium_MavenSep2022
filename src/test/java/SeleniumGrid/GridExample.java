package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap= new DesiredCapabilities();   //Desired capabilities is a class which set 
		cap.setPlatform(Platform.WINDOWS);   //we need to set platform on which it run 
		// cap.setPlatform(Platform.LINUX);
		
		cap.setBrowserName("chrome");
		
		URL HubURL = new URL ("http://172.20.10.14:4444/wd/hub");   //give URL of client here prompting on command prompt
		
		WebDriver driver= new RemoteWebDriver(HubURL,cap);   //here we are not running on chrome but on remote driver
		
		driver.get("https://lms.simplilearn.com/");   //so here we dont define desired capabilities . so here hub will redirect command to node machine
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement loginLink = driver.findElement(By.linkText("log in"));
		loginLink.click();		
		

	}

}
