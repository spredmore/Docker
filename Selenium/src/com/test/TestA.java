package com.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestA {

        WebDriver chromeDriver;

        @BeforeClass
        public void init() {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

                ChromeOptions options = setupChromeOptions();

                chromeDriver = new ChromeDriver(options);
        }

        @Test
        public void testGooglePageInChrome() {
                chromeDriver.get("http://www.google.com");
                String pageTitle = chromeDriver.getTitle();
                Assert.assertTrue(pageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
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

}
