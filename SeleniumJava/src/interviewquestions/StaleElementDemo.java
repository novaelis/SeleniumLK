package interviewquestions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementDemo {
	
	//STALE -> NOT FRESH
	// if the page changes/reloads DOM is rebuilt -> Previously found elemnts become stale
	//ON SE DESAVA I U PRIMERU U PACKAGEU workingwithautocomplete u Junitu
	//AutocompleteDemoWithListOdEleemnts kad skinemo break; statment
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	

	@Test
	public void test() {
		WebElement chechboxBMWElement = driver.findElement(By.id("bmwcheck"));
		// NE MORA BITI SAMO RELOAD MOZE I BITI NEKA AKCIJA KOJA PRAVI AJAX calls also change
		// part of the page
		// RECEPT JE DA CIM NADJEMO ELEMENT ODMAH IDU KOMANDE ISPOD STA DA RADIMO SA NJIM
		// NE TREBA PRE VREMENA PRONALAZITI ELELEMT
		driver.get(driver.getCurrentUrl());
		chechboxBMWElement.click();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
