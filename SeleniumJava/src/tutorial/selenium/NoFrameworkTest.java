package tutorial.selenium;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.FlightsPage;

public class NoFrameworkTest {

	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException, ParseException {
		//sve rucno odradjeno bez pozivanja nasih metoda
		//kada bi razne kombinacije radili onda bi bilo pisanja mnogo koda
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		// driver.quit();
	}

}
