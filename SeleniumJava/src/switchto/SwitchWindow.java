package switchto;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

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

		// OVO DOLE NECE PROCI ZATO STO KAD SE OTVORI NOVI PROZOR FOKUS I DALJE
		// OSTAJE NA PARENT WINDOWU
		/*
		 * WebElement openWindowButton = driver.findElement(By.id("openwindow"));
		 * openWindowButton.click();
		 * 
		 * WebElement findACourseTextField =
		 * driver.findElement(By.id("search-courses"));
		 * findACourseTextField.sendKeys("python");
		 */
		// Get the handle

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent handle: " + parentHandle);

		// Find Open Window button

		WebElement openWindowButton = driver.findElement(By.id("openwindow"));
		openWindowButton.click();

		// Find all handles

		Set<String> allHandles = driver.getWindowHandles();

		// Switching between handles

		for (String handle : allHandles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				WebElement findACourseTextField = driver.findElement(By.id("search-courses"));
				findACourseTextField.sendKeys("python");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}

		// Switch back to the parent window

		driver.switchTo().window(parentHandle);
		WebElement enterYourNameTextField = driver.findElement(By.id("name"));
		enterYourNameTextField.sendKeys("test successful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
