package workingwithelements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationBetweenPagesJUnit {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseURL);
		// getTitle
		String webSiteTitle = driver.getTitle();
		System.out.println("Title of the page is: "+webSiteTitle);
		// getCurrentURL

		System.out.println("Current URL is : "+ driver.getCurrentUrl());
		// navigate to
		driver.navigate().to("https://letskodeit.teachable.com/p/practice");
		Thread.sleep(2000);
		// currentURL
		System.out.println("Current URL is : "+ driver.getCurrentUrl());
		// navigate back
		driver.navigate().back();
		System.out.println("Navigate back");
		Thread.sleep(2000);
		// currentURL
		System.out.println("Current URL is : "+ driver.getCurrentUrl());
		// navigate forward
		driver.navigate().forward();
		System.out.println("Navigate forward");
		Thread.sleep(2000);
		// currentURL
		System.out.println("Current URL is : "+ driver.getCurrentUrl());
		// refresh
		driver.navigate().refresh();
		// refresh going on URL
		driver.get(driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
