package workingwithelements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayedJUnit {

	WebDriver driver;
	String baseURL1;
	String baseURL2;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL1 = "https://letskodeit.teachable.com/p/practice";
		baseURL2 = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * @Test public void testLetsKodeIt() throws InterruptedException {
	 * driver.get(baseURL1); WebElement displayedTextBox =
	 * driver.findElement(By.id("displayed-text"));
	 * System.out.println("Displated Text box is displayed: "+displayedTextBox.
	 * isDisplayed());
	 * 
	 * WebElement hideButton = driver.findElement(By.id("hide-textbox"));
	 * hideButton.click(); System.out.println("Hide button is clicked");
	 * Thread.sleep(2000);
	 * System.out.println("Displated Text box is displayed: "+displayedTextBox.
	 * isDisplayed());
	 * 
	 * 
	 * WebElement showButton = driver.findElement(By.id("show-textbox"));
	 * showButton.click(); System.out.println("Show button is clicked");
	 * Thread.sleep(2000);
	 * 
	 * System.out.println("Displated Text box is displayed: "+displayedTextBox.
	 * isDisplayed());
	 * 
	 * }
	 */
	@Test
	public void testExpedia() throws InterruptedException {
		driver.get(baseURL2);
		WebElement buttonStays = driver.findElement(By.xpath("//ul[@id=\"uitk-tabs-button-container\"]/li[1]/a"));
		buttonStays.click();

		WebElement travelersButton = driver.findElement(By.xpath("//div[@id=\"adaptive-menu\"]/a"));
		System.out.println("is traverlers button displayed: "+travelersButton.isDisplayed());
		//travelersButton.click();
		Thread.sleep(2000);
		

		WebElement travelersButton2 = driver.findElement(By.xpath("//div[@id=\"adaptive-menu\"]/div[1]/button[1]"));
		//travelersButton2.click();
		System.out.println("is traverlers button displayed: "+travelersButton2.isDisplayed());
		Thread.sleep(2000);
		WebElement removeChildrenButton = driver
				.findElement(By.xpath("//div[@id=\"adaptive-menu\"]/div[2]/div/section/div[1]/div[2]/div/button[1]"));
		removeChildrenButton.click();
		Thread.sleep(2000);
		WebElement dropdownChild1Age = driver.findElement(By.id("child-age-input-0-0"));
		System.out.println("Displated Text box is displayed: " + dropdownChild1Age.isDisplayed());

		// find childDropdown
		// syso is chold dropdown displyed
		// ul[@id="uitk-tabs-button-container"]/li[1]/a

		// div[@id="adaptive-menu"]/div[1]/button[1]
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
