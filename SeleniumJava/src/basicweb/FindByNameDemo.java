package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByNameDemo {
	public static void main(String[] args) {
		String URL = "https://letskodeit.teachable.com/p/practice";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		WebElement enterYourName = driver.findElement(By.name("enter-name"));
		
		enterYourName.sendKeys("proba");
	}
}
