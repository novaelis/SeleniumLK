package tutorial.selenium;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.FlightsPageFactory;

public class FindLinks {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@Test
	public void test() throws MalformedURLException {

		List<WebElement> links = new ArrayList<WebElement>();
		links = clicableLinks(driver);
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			try {
				System.out.println("Link is: " + href + " and response message: " + linkStatus(new URL(href)));
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static List<WebElement> clicableLinks(WebDriver driver) {

		List<WebElement> linksToClick = new ArrayList<WebElement>();

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("link")));

		for (WebElement e : elements) {
			if (e.getAttribute("href") != null)
				linksToClick.add(e);

		}

		return linksToClick;

	}

	public static String linkStatus(URL url) {
		try {
			HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
