package usefulmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.util.List;

public class GenericMethods {

	private WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {

		if (type.equals("id")) {
			System.out.println("Element found with id and value of id: " + locator);
			return driver.findElement(By.id(locator));
		} else if (type.equals("class")) {
			System.out.println("Element found with class name and value of class name: " + locator);
			return driver.findElement(By.className(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath and value of xpath: " + locator);
			return driver.findElement(By.xpath(locator));

		} else {
			System.out.println("Not supported locator or type");
			return null;
		}

	}

	public List<WebElement> getElements(String locator, String type) {

		String lowerCaseLocator = locator.toLowerCase();
		String lowerCaseType = type.toLowerCase();

		List<WebElement> listOfElements;

		if (lowerCaseType.equals("id")) {
			listOfElements = this.driver.findElements(By.id(lowerCaseLocator));
		} else if (lowerCaseType.equals("xpath")) {
			listOfElements = this.driver.findElements(By.xpath(lowerCaseLocator));
		} else if (type.equals("class")) {
			listOfElements = this.driver.findElements(By.className(locator));
		} else {
			System.out.println("Not supported locator or type");
			return null;
		}

		if (listOfElements.isEmpty()) {
			System.out.println("Element not found with " + type + ": " + locator);
		} else {
			System.out.println("Element found with " + type + ": " + locator);
		}

		return listOfElements;

	}

	public boolean isElementPresent(String locator, String type) {

		String lowerCaseLocator = locator.toLowerCase();
		String lowerCaseType = type.toLowerCase();

		int numberOfElements = getElements(locator, type).size();

		if (numberOfElements > 0) {
			return true;
		} else
			return false;

	}

	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			System.out.println("Element appeared on the web page");

		} catch (Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}

	public void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeout + " seconds for element to be clickable");

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));

			element.click();
			System.out.println("Element clicked on the web page");

		} catch (Exception e) {
			System.out.println("Element is not clickable on the web page");
		}

	}

	public void writeIntoFile(String filepath, String text) {

		try {
			FileWriter myWriter = new FileWriter(filepath);
			myWriter.write(text);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (Exception e) {
			System.out.println("An error occurred while writing text in  file.");
			e.printStackTrace();
		}

	}

}
