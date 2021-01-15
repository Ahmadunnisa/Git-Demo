package practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Logingpage;
import pageObjects.forgotpassword;
import resources.base;

public class Homepage extends base {

	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void Intialize() throws IOException {
		driver = InitializingDriver();

	}

	@Test(dataProvider = "getData")
	public void HomePage(String userName, String password, String text) throws IOException {

		// Two ways to calling objects present in otherclass 1.Inheritance. 2. creating
		// an object of that class an invoking it..
		driver.get(prop.getProperty("url"));
		
		
		Landingpage lndp = new Landingpage(driver);
		Logingpage lp=lndp.getLogin();
		
		lp.getemail().sendKeys(userName);
		lp.getpassword().sendKeys(password);
		// System.out.println(text); //we donot need to print it as we are printing in
		// logs directly..
		Log.info(text);
		lp.getLoginBtn().click();
		forgotpassword fpwd=lp.forgotpwd();
	fpwd.resetpasswordmail().sendKeys("xxxx");
    fpwd.sendmeinstructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		// rows stands for no.of data types starting from 0
		// columns stands for no.ofdata for each cycle starting from index zero.
		Object data[][] = new Object[2][3]; // 2rows 0&1 ,&3 columns-0,1,2
		// row-1
		data[0][0] = "nonristricteduser@qa.com";
		data[0][1] = "12345";
		data[0][2] = "Allowed";
		// row-2
		data[1][0] = "Ristricteduser@qa.com";
		data[1][1] = "9876";
		data[1][2] = "notAllowed";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();

	}
}
