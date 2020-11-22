package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\novaelis\\eclipse-workspace\\libs\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		WebElement element = driver.findElement(By.id("//input[@id=\"name\"]"));
		driver.close();
	}
}
