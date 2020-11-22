package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWin {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\novaelis\\eclipse-workspace\\libs\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		//WebElement element = driver.findElement(By.id("//input[@id=\"name\"]"));
		//driver.close();
	}
}
