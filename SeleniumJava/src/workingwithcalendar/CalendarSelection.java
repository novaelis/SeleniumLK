package workingwithcalendar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;
import utilities.WaitTypes;

public class CalendarSelection {
	
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
		gm.clickWhenReady(By.id("d1-btn"), 2);
		gm.clickWhenReady(By.xpath("//h2[text()='December 2020']//parent::div//button[@data-day='6']"), 1);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	

}
