package com.panda;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TecAdminSeleniumTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://google.com");

		Thread.sleep(1000);

		System.out.println("this is page source : " + driver.getPageSource());
		if (driver.getPageSource().contains("I'm Feeling Lucky")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();
	}
}
