package waittypes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseURL);

		WebElement logInButton = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		logInButton.click();

		/*
		 * WebElement emailAddressInput = driver.findElement(By.id("user_email"));
		 * emailAddressInput.sendKeys("test");
		 */

		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailAddressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailAddressInput.sendKeys("test");

		WebElement passwordInput = driver.findElement(By.id("user_password"));
		passwordInput.sendKeys("test");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
