import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeHeadlessTest {

	@Test
	//public void testExecution() throws IOException {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		// Add options to Google Chrome. The window-size is important for responsive sites
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://seleniumhq.org");

		// a guarantee that the test was really executed               
		if(driver.findElement(By.id("q")).isDisplayed()) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}

		driver.quit();
    }
}
