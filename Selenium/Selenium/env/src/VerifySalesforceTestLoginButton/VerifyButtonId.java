package VerifySalesforceTestLoginButton;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyButtonId {

	WebDriver chromeDriver;

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		ChromeOptions options = setupChromeOptions();

		chromeDriver = new ChromeDriver(options);
	}

	// Add options to Google Chrome. The window-size is important for responnsive sites.
	private ChromeOptions setupChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");

		return options;
	}

	@Test
	public void VerifySalesforceTestLoginButtonId() {
		chromeDriver.get("https://test.salesforce.com/");

		WebElement element = chromeDriver.findElement(By.id("Login"));

		Assert.assertNotNull(element, "The Id 'Login' doesn't exist on this page.");
	}
}