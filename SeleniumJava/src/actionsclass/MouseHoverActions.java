package actionsclass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {

	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		jse = (JavascriptExecutor) driver;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {

		jse.executeScript("window.scrollBy(0, 600);");
		
		WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverButton).perform();;
		Thread.sleep(2000);

		WebElement mouseHoverButtonTopLink = driver
				.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		//mouseHoverButtonTopLink.click();
		action.moveToElement(mouseHoverButtonTopLink).click().perform();
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
