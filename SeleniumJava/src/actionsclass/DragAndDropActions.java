package actionsclass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://jqueryui.com/droppable/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		driver.switchTo().frame(0);

		WebElement elementForDrag = driver.findElement(By.id("draggable"));
		WebElement elementWhereWeDrop = driver.findElement(By.id("droppable"));

		// Drag and drop

		Actions action = new Actions(driver);
//		action.dragAndDrop(elementForDrag, elementWhereWeDrop).build().perform();;
//		
//		Thread.sleep(2000);
//		
		// Click and hold, move to element, release, build and perform

//		action.clickAndHold(elementForDrag).perform();
//		action.moveByOffset(170, 30).perform();
//		action.release().perform();
		action.clickAndHold(elementForDrag).moveToElement(elementWhereWeDrop).release().build().perform();
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
