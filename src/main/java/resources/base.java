package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class base {                                        // null pointer--when there is no life for driver
					                                       // file not found--when path is wrong.
	public WebDriver driver;                               // No such element--when there is a wrong locator.
	public Properties prop;                               // Array out of bound--Arraysize must be two if we are passing Two kinds of data

	public WebDriver InitializingDriver() throws IOException { // i.e[2]-for 2 rows, internally it will take as 0,1
																// &[3]--0,1,2 for columns for
			

							// values.(username,password,text)

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
       //  String browserName=System.getProperty("browser");    //To run through jenkins build in choice parameters
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
			  options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver..driver",System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("Edge")) {    //"Edge" to run in dataproperty file
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
		      driver=new EdgeDriver();
		} 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(Source,new File(destinationFile));
		return destinationFile;
	}
	
	
	
	
	
}
