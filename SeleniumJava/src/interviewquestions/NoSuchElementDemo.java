package interviewquestions;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoSuchElementDemo {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}



	@Test
	public void test() {
		
		// 1. Timing Issues // OVO DOLE PUCA AKO NE STAVIMO implicitly or expicitly wait
		WebElement logInButton = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		logInButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailAdressTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
//		WebElement emailAdressTextField = driver.findElement(By.id("user_email"));
		emailAdressTextField.sendKeys("test@email.com");
		
		
		
//		WebElement logInButtonOnLogInPage = driver.findElement(By.name("commit"));
//		logInButtonOnLogInPage.sendKeys(Keys.ENTER);
		
		// 2. Incorrect locator or type of locator
//		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		
		// 3. Element is in iFrame
		
//		driver.switchTo().frame("courses-iframe");
//		WebElement findACourseTextField = driver.findElement(By.id("search-courses"));
//		findACourseTextField.sendKeys("python");
//		driver.switchTo().defaultContent();
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
