package workingwithautocomplete;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;

public class AutocompleteDemo {
	
	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.goibibo.com/";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		
		driver.get(baseURL);
		
		String partialTextForSearch = "Del";
		String textToSelect = "Delhi, India(DEL)";
		
		WebElement textFieldForSearching = gm.waitForElement(By.id("gosuggest_inputSrc"), 2);
		textFieldForSearching.sendKeys(partialTextForSearch);
		
		WebElement ulElementWithAllOptions = gm.waitForElement(By.id("react-autosuggest-1"), 2);
		String ULinnnerHTML = ulElementWithAllOptions.getAttribute("innerHTML");
		
		gm.writeIntoFile("C:\\Users\\novaelis\\Documents\\Selenium kurs dokumenta\\goibiboULinnerHTML", ULinnnerHTML);
		

		//
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}

	

}
