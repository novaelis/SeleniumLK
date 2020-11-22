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
//morao sam maunuelno da dodam path do Select
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
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
		WebElement carSelectDropdown = driver.findElement(By.id("carselect"));
		Select sec = new Select(carSelectDropdown);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		sec.selectByValue("benz");

		
		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		sec.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		sec.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		for (WebElement element : sec.getOptions()) {
			System.out.println(element.getText());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
