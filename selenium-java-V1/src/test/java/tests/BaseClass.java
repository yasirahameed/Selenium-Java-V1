package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.ConfigLoader;
import utilities.DriverFactory;

// Base Class to configure the testing environment 
// all testing will be based on this class
public class BaseClass {

	protected WebDriver driver; //Web Driver object

	//Method used to setup the basic testing environment
	@BeforeSuite
	public void setUp() {
		String browser = ConfigLoader.getProperty("browser"); // getting browser name from config.properties file
		
		//getting the right browser object initialized
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = DriverFactory.getChromeDriver();
			break;
		case "firefox":
			driver = DriverFactory.getFirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		// Set an implicit wait time of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		//baseURL value from config.properties file
        driver.get(ConfigLoader.getProperty("baseURL"));
        
	}

	//Method to release all resources at the end of the testing
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
