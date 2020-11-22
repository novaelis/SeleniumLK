package workingwithelements;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonsAndCheckBoxesJUnit {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	

	@Test
	public void test() throws InterruptedException {
		//bmw radio button click
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		bmwRadioButton.click();
		//benz radio button click
		WebElement hondaRadioButton = driver.findElement(By.id("hondaradio"));
		hondaRadioButton.click();
		//bmw checkbox click
		WebElement bmwCheckbox = driver.findElement(By.id("bmwcheck"));
		bmwCheckbox.click();
		//benz checkbox click
		WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
		benzCheckbox.click();
		Thread.sleep(2000);
		//check is selected all radio and checkboxes?
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.name("cars"));
		for (WebElement webElement : list) {
			if(webElement.isSelected()) {
				System.out.println(webElement.getAttribute("value").toUpperCase()+" "+webElement.getAttribute("type")+" element is selected.");
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
