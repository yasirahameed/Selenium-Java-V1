package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import utilities.ConfigLoader;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage; //LoginPage object
	private HomePage homePage; //HomePage object
	
	// loginTest to test login functionality
    @Test
    public void loginTest() {
    	
        //Object creation and initialization of login page elements
        loginPage = new LoginPage(driver);
       
        //Method call to test login functionality
		loginPage.login(ConfigLoader.getProperty("username"), ConfigLoader.getProperty("password"));
        
		//Object creation and initialization of home page elements
		homePage = new HomePage(driver);

        // Assert the home page title to verify login success
        Assert.assertEquals(homePage.getHomePageTitle(), "GTPL Bank Manager HomePage");		
    }
}

