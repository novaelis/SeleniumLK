package usefulmethods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IsElementPresentDemo {
	GenericMethods gm;
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		gm = new GenericMethods(driver);
	}

	@Test
	public void test() {
		driver.get(baseURL);

		// WebElement enterYourNameTextBox = driver.findElement(By.id("name"));
		
		boolean isPresentElementName = gm.isElementPresent("name", "id");
		System.out.println("Is Element present: " + isPresentElementName);
		boolean isPresentElementNameNotFound = gm.isElementPresent("name-not-found", "id");
		System.out.println("Is Element present: " + isPresentElementNameNotFound);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
