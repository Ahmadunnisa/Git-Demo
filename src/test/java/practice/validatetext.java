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

public class validatetext extends base {

	public WebDriver driver;

	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void Intialize() throws IOException {
		driver = InitializingDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info(" Navigated to home page");
	}

	@Test
	public void validateText() throws IOException {

		// Two ways to calling objects present in otherclass 1.Inheritance. 2. creating
		// an object of that class an invoking it..

		Landingpage lndp = new Landingpage(driver);

		// compare the text from the browser and actual value.
		Assert.assertEquals(lndp.gettitle().getText(), "FEATURED COURSES");
		//System.out.println(lndp.gettitle().getText());
		Log.info("Successfully validated the text");

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}

}
