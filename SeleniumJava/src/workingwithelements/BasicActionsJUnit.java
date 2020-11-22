package workingwithelements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActionsJUnit {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseURL);
		WebElement logInButton = driver.findElement(By.xpath("//div[@id=\"navbar\"]//a[@href=\"/sign_in\"]"));
		logInButton.click();
		WebElement username = driver.findElement(By.id("user_email"));
		username.sendKeys("test@test.com");
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("test");
		Thread.sleep(3000);
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
