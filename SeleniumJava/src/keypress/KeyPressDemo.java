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

public class KeyPressDemo {
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
		WebElement logInButton = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		logInButton.click();
		
		WebElement emailAdressTextField = driver.findElement(By.id("user_email"));
		emailAdressTextField.sendKeys("test@email.com");
		Thread.sleep(2000);
		emailAdressTextField.sendKeys(Keys.TAB);
		WebElement passwordTextField = driver.switchTo().activeElement();
		passwordTextField.sendKeys("test");
		Thread.sleep(2000);
		passwordTextField.sendKeys(Keys.ENTER);
		
//		WebElement passwordTextField = driver.findElement(By.id("user_password"));
//		passwordTextField.sendKeys("test");
//		//passwordTextField.sendKeys(Keys.ENTER);
//		
//		WebElement logInButtonOnLogInPage = driver.findElement(By.name("commit"));
//		logInButtonOnLogInPage.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
