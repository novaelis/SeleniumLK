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

import utilities.WaitTypes;

public class ExplicitWaitWithUtilityDemo {

	private WebDriver driver;
	private String baseURL;
	private WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseURL);

		WebElement logInButton = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		logInButton.click();

		WebElement emailAddressInput = wt.waitForElement(By.id("user_email"),3);
		emailAddressInput.sendKeys("test");

		WebElement passwordInput = driver.findElement(By.id("user_password"));
		passwordInput.sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 1);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
