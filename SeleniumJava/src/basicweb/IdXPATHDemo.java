package basicweb;

import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdXPATHDemo {
	public static void main(String[] args) {
		String URL = "https://letskodeit.teachable.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		WebElement signIn = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		signIn.click();
		
		WebElement username = driver.findElement(By.id("user_email"));
		username.click();
		username.sendKeys("letskodeit@gmail.com");
		
		WebElement password = driver.findElement(By.id("user_password"));
	}
}
