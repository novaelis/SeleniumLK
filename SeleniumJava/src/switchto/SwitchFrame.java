package switchto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {
	
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//OVO NECE PROCI ZATO STO JE U IFRAMEU ELEMENT I MORAMO DA SWITCHUEMO NA NJEGA
		// Switch frame with id
		//driver.switchTo().frame("courses-iframe");
		// Switch frame with name
		//driver.switchTo().frame("iframe-name");
		// Switch frame with index
		//NE RADI NESTO u GOOGLE CHROMEU ALI U FIREFOXU HOCE
		driver.switchTo().frame(0);
		
		WebElement findACourse = driver.findElement(By.id("search-courses"));
		findACourse.sendKeys("python");
		
		js.executeScript("window.scrollBy(0, 1600);");
		Thread.sleep(5000);
		
		
		driver.switchTo().defaultContent();
		WebElement enterYourNameTextField = driver.findElement(By.id("name"));
		enterYourNameTextField.sendKeys("test successful");
		
		js.executeScript("window.scrollBy(0, -1600);");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
