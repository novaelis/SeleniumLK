package usefulmethods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAtrributeDemo {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get(baseURL);
		
		WebElement enterYourNameTextbox = driver.findElement(By.id("name"));
		System.out.println("Value of Id Attribute of Enter Your Name textbox: "+enterYourNameTextbox.getAttribute("id"));
		System.out.println("Value of Name Attribute of Enter Your Name textbox: "+enterYourNameTextbox.getAttribute("name"));
		System.out.println("Value of Class Attribute of Enter Your Name textbox: "+enterYourNameTextbox.getAttribute("class"));
		System.out.println("Value of Placeholder Attribute of Enter Your Name textbox: "+enterYourNameTextbox.getAttribute("placeholder"));
		System.out.println("Value of Type Attribute of Enter Your Name textbox: "+enterYourNameTextbox.getAttribute("type"));
		//find attribute vlaue of class
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
