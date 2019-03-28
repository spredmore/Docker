package ClickSalesforceTestLoginButton;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestButtonClick {

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
        public void VerifySalesforceTestLoginButtonError() {
                chromeDriver.get("https://test.salesforce.com/");

                Assert.assertNotNull(chromeDriver.findElement(By.id("Login")), "The Id 'Login' doesn't exist on this page.");

                chromeDriver.findElement(By.id("Login")).submit();

                Assert.assertNotNull(chromeDriver.findElement(By.className("loginError")), "The class name 'loginError' doesn't exist on this page.");
        }
}