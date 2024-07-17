package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    // Constructor to initialize the elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Example method to verify the home page
    public String getHomePageTitle() {
        return driver.getTitle();
    }
}

