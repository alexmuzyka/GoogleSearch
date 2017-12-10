package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public ResultPage search(String text) {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		return new ResultPage(driver);
	}

}
