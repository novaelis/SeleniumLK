package workingwithcalendar;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;
import utilities.WaitTypes;

public class CalendarSelectionWithElements {
	
	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseURL);
		
		//click on check-in calendar
		gm.clickWhenReady(By.id("d1-btn"), 2);
		
		//grab whole table for December
		WebElement tableOfDecember = gm.waitForElement(By.xpath("//h2[text()='December 2020']//parent::div//table"),2);
		List<WebElement> listOfAllTDsOfDecember = tableOfDecember.findElements(By.tagName("button"));
		
		for (WebElement webElement : listOfAllTDsOfDecember) {
			if(webElement.getAttribute("data-day").equals("31")) {
				webElement.click();
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
