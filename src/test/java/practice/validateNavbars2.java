package practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import resources.base;

public class validateNavbars2 extends base {

	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	Landingpage lndp; 
	@BeforeTest
	public void Intialize() throws IOException {
		driver = InitializingDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void ValidateNavbar() throws IOException {

		// Two ways to calling objects present in otherclass 1.Inheritance. 2. creating
		// an object of that class an invoking it..

		lndp=new Landingpage(driver);

		System.out.println(lndp.navbar().isDisplayed());
		Assert.assertTrue(true);
		Log.info("Navigation bar is displayed");	
		
	}
		@Test
		public void ValidateHeadder() throws IOException{
			lndp=new Landingpage(driver);
		 Assert.assertEquals(lndp.getHeadder().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
			
		}

	

	@AfterTest
	public void teardown() {
		driver.close();

	}
}