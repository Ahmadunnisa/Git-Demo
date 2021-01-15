package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

	public WebDriver driver;

	private By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	private By title = By.cssSelector(".text-center");
	private By nbar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By headder =By.cssSelector("div[class='col-sm-6 col-md-8 hidden-xs video-banner'] p");
	

	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;

	}

	public Logingpage getLogin() {
		driver.findElement(signin).click();
		Logingpage lp = new Logingpage(driver);
		return lp;
	}

	public WebElement gettitle() {
		return driver.findElement(title);
	}

	public WebElement navbar() {
		return driver.findElement(nbar);
	}
	
	public WebElement getHeadder() {
		return driver.findElement(headder);
	}

}