package com.panda.service;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.config.PandaConfiguration;
import com.panda.constant.Driver;
import com.panda.constant.DriverType;
import com.panda.constant.OS;
import com.panda.utils.OSInformation;

@Service
public class WebDriverService {

    private final Logger logger = LoggerFactory.getLogger(WebDriverService.class);

    private static final String WEBDRIVER_WINDOWS_CHROME_PATH = "src/test/resources/webdriver/windows/chrome/chromedriver.exe";

    private static final String WEBDRIVER_WINDOWS_FIREFOX_PATH = "src/test/resources/webdriver/windows/firefox/geckodriver.exe";

    private static final String WEBDRIVER_LINUX_CHROME_PATH = "src/test/resources/webdriver/linux/chrome/chromedriver";

    private static final String WEBDRIVER_LINUX_FIREFOX_PATH = "src/test/resources/webdriver/linux/firefox/geckodriver";

    @Autowired
    private PandaConfiguration configuration;

    WebDriver driver = null;

    public WebDriver getChromeDriver() {

        ChromeOptions options = new ChromeOptions();

        if (configuration.isHttpProxyEnabled()) {
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(configuration.getHttpProxy())
                    .setSslProxy(configuration.getHttpProxy());
            options.setProxy(proxy);
        }

        if (OSInformation.getOs().getOsName().equals(OS.WINDOWS.getOsName())) {
            System.setProperty(Driver.CHROME.getDriverName(), WEBDRIVER_WINDOWS_CHROME_PATH);
            options.addArguments("window-size=1440,960");
        }

        if (OSInformation.getOs().getOsName().equals(OS.LINUX.getOsName())) {
            System.setProperty(Driver.CHROME.getDriverName(), WEBDRIVER_LINUX_CHROME_PATH);
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
        }

        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--ignore-certificate-errors");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.merge(capabilities);

        logger.info(options.toString());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return driver;
    }

    public WebDriver getFirefoxDriver() {
        System.setProperty(Driver.FIREFOX.getDriverName(), DriverType.WEBDRIVER_WINDOWS_FIREFOX_PATH);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("log", "{level: trace}");

        capabilities.setCapability("marionette", true);
        capabilities.setCapability("moz:firefoxOptions", options);

        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public void waitForPageLoad(WebDriver driver, int pageLoadTimeout) {
        new WebDriverWait(driver, pageLoadTimeout == 0 ? configuration.getPageLoadTimeout() : pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }

}
