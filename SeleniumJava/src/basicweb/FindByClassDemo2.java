package basicweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassDemo2 {

	public static void main(String[] args) {
		String URL = "https://facebook.com";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		List<WebElement> btnClassElements = driver.findElements(By.className("inputtext"));
		btnClassElements.get(1).click();
		btnClassElements.get(1).sendKeys("Test");

	}

}
