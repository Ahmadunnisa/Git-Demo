package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotpassword {
     
	public WebDriver driver;
	 
	By resetpwdmail=By.cssSelector("[name*='email']");
	By sndmeinstruct=By.cssSelector("[type='submit']");
	
	
	
	
	
	public forgotpassword(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	public WebElement resetpasswordmail()
	{
	return driver.findElement(resetpwdmail);
	
	}
	
	public WebElement sendmeinstructions()
	{
		return driver.findElement(sndmeinstruct);
	}
	
}
