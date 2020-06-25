package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;
import utilities.ExtentListener;

@SuppressWarnings("javadoc")
public class BaseTest {

	WebDriver driver;
	homePage homePage;
	ExtentListener extentListener;
	
	@BeforeTest(alwaysRun = true)
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new homePage(driver);
	}

	@AfterTest(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}
