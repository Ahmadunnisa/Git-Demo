package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logingpage {

	public WebDriver driver;
	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By loginbtn = By.cssSelector("[type='submit']");
	By forgotpwd=By.cssSelector("[href*='password/new']");

	public Logingpage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getemail() {

		return driver.findElement(email);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
		
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginbtn);
	}
	
	

	public forgotpassword forgotpwd() {
		// TODO Auto-generated method stub
		driver.findElement(forgotpwd).click();
        return new forgotpassword(driver);
	
	}

	 

	
}