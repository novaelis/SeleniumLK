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

public class PageObjectModel {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException, ParseException {
		FlightsPage.navigateToFlightsTab(driver);

		FlightsPage.clickOnLeavingFromFlightTextbox(driver);
		FlightsPage.fillLeavingFromFlightPopUpTextbox(driver, "New York");
		Thread.sleep(2000);
		// destination text box send "Chicago"
		// SearchPage.findGoingToFlightTextbox(driver).sendKeys("Chicago");
		FlightsPage.clickOnGoingToFlightTextbox(driver);
		FlightsPage.fillGoingToFlightPopUpTextbox(driver, "Chicago");
		Thread.sleep(2000);
		// departure date text box send date
		FlightsPage.clickOnDepartingDateTextbox(driver);
		FlightsPage.clickOnDateInTable(driver, "12/15/2020");
		FlightsPage.clickOnDateInTable(driver, "12/20/2020");
		FlightsPage.clickOnDoneButtonInTimeTable(driver);
		Thread.sleep(2000);
		// click on search button
		FlightsPage.clickOnSearchButton(driver);
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}

}
