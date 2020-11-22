package javascriptexecution;

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

import usefulmethods.GenericMethods;

public class JavaScriptClickPracticalExample {
	private WebDriver driver;
	private JavascriptExecutor js;
	private String baseURL;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		baseURL = "https://www.retailmenot.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		
		WebElement logInElement = driver.findElement(By.xpath("//button[@class='sc-pkHUE jgzVcc anchor-button sc-qZuGl gyLSbr login-button']"));
		logInElement.click();
		
		WebElement emailAddressTextBox = driver.findElement(By.id("identifier"));
		emailAddressTextBox.sendKeys("test@test.com");
		
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys("test@test.com");
		
		Thread.sleep(2000);
		
		WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		logInButton.click();
		
		Thread.sleep(2000);
		
		//KORISTIMO JS KADA NAM IZADJE Exception ElementNotInteractableException
		//Kada radimo inspection DOMa i hoverujemo iznad nekog elementa i on se ne oznaci
		//tu najvervatnije mozemo da koristimo javascipt
		//js.executeScript("arguments[0].click();",logInButton);
	}
	

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
