package keypress;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPressDemo1 {
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
	public void test() throws InterruptedException {

		//Find any element that is not TextField
		WebElement openWindowButton = driver.findElement(By.id("openwindow"));
//		openWindowButton.sendKeys(Keys.CONTROL + "a");
		String selectAll = Keys.chord(Keys.CONTROL,"a");
		openWindowButton.sendKeys(selectAll);
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
