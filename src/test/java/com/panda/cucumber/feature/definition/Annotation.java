package com.panda.cucumber.feature.definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.panda.constant.Driver;
import com.panda.constant.DriverType;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Annotation {

    WebDriver driver = null;

    // @Autowired
    // WebDriverService webDriverService;

    @Before
    public void setUp() {
        System.setProperty(Driver.FIREFOX.getDriverName(), DriverType.WEBDRIVER_WINDOWS_FIREFOX_PATH);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("log", "{level: trace}");

        capabilities.setCapability("marionette", true);
        capabilities.setCapability("moz:firefoxOptions", options);

        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // if (driver == null) {
        // driver = webDriverService.getChromeDriver();
        // }
    }

    @Given("^I am on Facebook login page$")
    public void goToFacebook() {

        driver.navigate().to("https://www.facebook.com/");
    }

    @When("^I enter username as \"(.*)\"$")
    public void enterUsername(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @When("^I enter password as \"(.*)\"$")
    public void enterPassword(String arg1) {
        driver.findElement(By.id("pass")).sendKeys(arg1);
        driver.findElement(By.id("u_0_2")).click();
    }

    @Then("^Login should fail$")
    public void checkFail() {
        if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }
    }

    @Then("^Login should successfully$")
    public void login_should_successfully() throws Throwable {
        if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
    }

    @But("^Relogin option should be available$")
    public void checkRelogin() {
        if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
