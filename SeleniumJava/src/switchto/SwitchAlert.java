package switchto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchAlert {
	private WebDriver driver;
	private String baseURL;
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}


	@Test
	public void test1() throws InterruptedException {
		WebElement enterYourName = driver.findElement(By.id("name"));
		enterYourName.sendKeys("Dejan");
		Thread.sleep(2000);
		
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void test2() throws InterruptedException {
		WebElement enterYourName = driver.findElement(By.id("name"));
		enterYourName.sendKeys("Dejan");
		Thread.sleep(2000);
		
		WebElement alertButton = driver.findElement(By.id("confirmbtn"));
		alertButton.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
