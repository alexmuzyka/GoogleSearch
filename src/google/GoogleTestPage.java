package google;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTestPage {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
	}

	@Test
	public void testSearch() {
		HomePage home = new HomePage(driver);
		ResultPage result = home.search("suspiciousObservers youtube");
		assertTrue(result.getFirstLink().contains("YouTube"));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
