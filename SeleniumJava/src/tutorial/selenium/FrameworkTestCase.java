package tutorial.selenium;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.FlightsPage;
import page.classes.FlightsPageFactory;

public class FrameworkTestCase {

	private WebDriver driver;
	private String baseURL;
	private FlightsPageFactory fpf;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		fpf = new FlightsPageFactory(driver);
		baseURL = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException, ParseException{
		fpf.clickFlightsTab();
		
		fpf.clickLeavingCity();
		fpf.fillLeavingPopUp("New York");
		
		fpf.clickDestinationCity();
		fpf.fillDestinationPopUp("Chicago");
		fpf.clickDepartureDate();
		fpf.clickDateInTable(driver, "12/20/2020");
		fpf.clickDateInTable(driver, "12/25/2020");
		fpf.clickDoneButton();
		
		fpf.clickSearchButton();
		
		
		

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
