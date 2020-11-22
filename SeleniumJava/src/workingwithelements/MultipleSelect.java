package workingwithelements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {
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
		WebElement carSelectDropdown = driver.findElement(By.id("multiple-select-example"));
		Select sec = new Select(carSelectDropdown);
		
		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sec.selectByValue("orange");

		
		Thread.sleep(2000);
		System.out.println("De-select orange by value");
		sec.deselectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Select peach by index");
		sec.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sec.selectByVisibleText("Apple");
		
		Thread.sleep(2000);
		System.out.println("Print all selected options");
		for (WebElement element : sec.getAllSelectedOptions()) {
			System.out.println(element.getText());
		}
		System.out.println("De-select all selected options");
		sec.deselectAll();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
