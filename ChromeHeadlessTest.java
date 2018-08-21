import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeHeadlessTest {

		@Test
		//public void testExecution() throws IOException {
		public static void main(String args[]) {
				System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

				ChromeOptions options = setupChromeOptions();

				WebDriver driver = new ChromeDriver(options);
				driver.get("http://seleniumhq.org");

				System.out.println();
				testDoesSubmitElementExist(driver);
				testDoesSubmitDoesntExistElementExist(driver);
				System.out.println();

				driver.quit();
		}

		// Add options to Google Chrome. The window-size is important for responnsive sites.
		private static ChromeOptions setupChromeOptions() {
				ChromeOptions options = new ChromeOptions();

				options.addArguments("headless");
				options.addArguments("window-size=1200x600");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-gpu");

				return options;
		}
		
		// Test to see if the 'submit' element exists.
		private static void testDoesSubmitElementExist(WebDriver driver) {
				System.out.print("Does the 'submit' element exist: ");

				try {
						System.out.println(driver.findElement(By.id("submit")).isDisplayed());
				} catch (NoSuchElementException e) {
						System.out.println("NoSuchElementException");
				}
		}

		// Test to see if the 'submit_doesntexist' element exists.
		private static void testDoesSubmitDoesntExistElementExist(WebDriver driver) {
				System.out.print("Does the 'submit_doesntexist' element exist: ");

				try {
						System.out.println(driver.findElement(By.id("submit_doesntexist")).isDisplayed());
				} catch (NoSuchElementException e) {
						System.out.println("NoSuchElementException");
				}
		}
}

		