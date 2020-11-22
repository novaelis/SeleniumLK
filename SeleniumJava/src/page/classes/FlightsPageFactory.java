package page.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class FlightsPageFactory {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Flights']")
	WebElement flightTab;

	@FindBy(xpath="//span[text()='Roundtrip']")
	WebElement roundtripButton;
	
	@FindBy(xpath="//span[text()='One-way']")
	WebElement oneWayButton;
	
	@FindBy(xpath = "//span[text()='Multi-city']")
	WebElement multiCityButton;
	
	@FindBy(xpath = "//button[@aria-label='Leaving from']")
	WebElement leavingCity;
	
	@FindBy(id = "location-field-leg1-origin")
	WebElement leavingPopUp;
	
	@FindBy(xpath = "//button[@aria-label='Going to']")
	WebElement destinationCity;
	
	@FindBy(id = "location-field-leg1-destination")
	WebElement destinationPopUp;
	
	@FindBy(id = "d1-btn")
	WebElement departureDate;
	
	@FindBy(id = "d2-btn")
	WebElement returnDate;
	
	@FindBy(xpath = "//span[contains(text(),'Done')]")
	WebElement doneButton;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;
	
	
	public FlightsPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickFlightsTab() {
		flightTab.click();
	}
	
	public void clickLeavingCity() {
		leavingCity.click();
	}
	
	public void fillLeavingPopUp(String fromWhatCity) {
		leavingPopUp.sendKeys(fromWhatCity);
		leavingPopUp.sendKeys(Keys.ENTER);
	}
	
	public void clickDestinationCity() {
		destinationCity.click();
	}
	
	public void fillDestinationPopUp(String goingToWhatCity) {
		destinationPopUp.sendKeys(goingToWhatCity);
		destinationPopUp.sendKeys(Keys.ENTER);
	}
	
	public void clickDepartureDate() {
		departureDate.click();
	}
	
	public void clickReturnDate() {
		returnDate.click();
	}
	
	public void clickDateInTable(WebDriver driver, String date) throws ParseException {
		WebElement element = driver.findElement(By.xpath("//button[@aria-label='" + convertIntoProperDate(date) + "']"));
		element.click();

	}
	
	public void clickDoneButton() {
		doneButton.click();

	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public static String convertIntoProperDate(String date) throws ParseException {
		Date d = new Date();
		SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formattedDate = new SimpleDateFormat("MMM dd, yyyy");
		d = originalFormat.parse(date);

		return formattedDate.format(d);
	}
	
	
	
}
