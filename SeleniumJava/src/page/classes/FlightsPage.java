package page.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage {

	private static WebElement element = null;

	/**
	 * Returns the flights tab button element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findFlightsTabButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[text()='Flights']"));
		return element;
	}
	
	/**
	 * Navigate to flights tab
	 * 
	 * @param driver
	 */

	public static void navigateToFlightsTab(WebDriver driver) {
		element = findFlightsTabButton(driver);
		element.click();
	}

	/**
	 * Returns the flight leaving from text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findLeavingFromFlightTextbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
		return element;
	}

	/**
	 * Clicks at leaving from flight text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnLeavingFromFlightTextbox(WebDriver driver) {
		element = findLeavingFromFlightTextbox(driver);
		element.click();
	}

	/**
	 * Fill flight leaving from text box element and send key enter
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void fillLeavingFromFlightPopUpTextbox(WebDriver driver, String fromWhatCity) {
		element = driver.findElement(By.id("location-field-leg1-origin"));
		element.sendKeys(fromWhatCity);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Returns the flight going to text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findGoingToFlightTextbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
		return element;
	}

	/**
	 * Clicks at flight going text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnGoingToFlightTextbox(WebDriver driver) {
		element = findGoingToFlightTextbox(driver);
		element.click();
	}

	/**
	 * Fill flight going to text box element and send key enter
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void fillGoingToFlightPopUpTextbox(WebDriver driver, String goingToWhatCity) {
		element = driver.findElement(By.id("location-field-leg1-destination"));
		element.sendKeys(goingToWhatCity);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Returns the departure date text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findDepartingDateTextbox(WebDriver driver) {
		element = driver.findElement(By.id("d1-btn"));
		return element;
	}

	/**
	 * Clicks at departing date going text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnDepartingDateTextbox(WebDriver driver) {
		element = findDepartingDateTextbox(driver);
		element.click();
	}

	/**
	 * Returns the return date text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findReturningDateTextbox(WebDriver driver) {
		element = driver.findElement(By.id("d2-btn"));
		return element;
	}

	/**
	 * Clicks at returning date going text box element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnReturningDateTextbox(WebDriver driver) {
		element = findReturningDateTextbox(driver);
		element.click();
	}

	/**
	 * Clicks at Date in table
	 * 
	 * @param driver
	 * 
	 * @return
	 * @throws ParseException
	 */

	public static void clickOnDateInTable(WebDriver driver, String date) throws ParseException {
		element = driver.findElement(By.xpath("//button[@aria-label='" + convertIntoProperDate(date) + "']"));
		element.click();

	}

	/**
	 * Returns the done button element in table of date
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findDoneButtonInTimeTable(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Done')]"));
		return element;
	}

	/**
	 * Clicks at Date in table
	 * 
	 * @param driver
	 * 
	 * @return
	 * @throws ParseException
	 */

	public static void clickOnDoneButtonInTimeTable(WebDriver driver) {
		element = findDoneButtonInTimeTable(driver);
		element.click();

	}

	/**
	 * Returns the search button element
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static WebElement findSearchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Search']"));
		return element;
	}

	/**
	 * Click on search button
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnSearchButton(WebDriver driver) {
		element = findSearchButton(driver);
		element.click();
	}

	/**
	 * Click at search button wiith wait
	 * 
	 * @param driver
	 * 
	 * @return
	 */

	public static void clickOnSearchButtonWithWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\"//button[text()='Search']\""))).click();
	}



	/**
	 * Format into date that is used for clicking element
	 * 
	 * @param driver
	 * 
	 * @return
	 * @throws ParseException
	 */

	public static String convertIntoProperDate(String date) throws ParseException {
		Date d = new Date();
		SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formattedDate = new SimpleDateFormat("MMM dd, yyyy");
		d = originalFormat.parse(date);

		return formattedDate.format(d);
	}

}
