package interviewquestions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementNotClicableDemo {
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver; 
		baseURL = "https://freecrm.com/index.html";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() {
		// OVDE PUCA ERROR ZATO STO SE VIDI SPINNER(U ZAGLAVLJU TABA ILI NA SAMOJ
		// STRANICI
		// A TO ZNACI DA SE AJAX JOS UVEK LOADUJE ONDA
		// PRIMENJUJEMO OVAJ PRISTUP DA PRAVIMO EXPLICIT WAIT

		//NJEMU NI OVO NIJE POMOGLO ZATO STO MU NEKI DRUGI ELEMENT OVERLAPUJE PREKO logInButtona
		WebDriverWait wait = new WebDriverWait(driver, 3);
//		WebElement logInButton = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Log In']")));
//		WebElement logInButton = driver.findElement(By.xpath("//span[text()='Log In']"));
//		logInButton.click();
		
		//NJEMU JE OVO POMOGLO DA SACEKA DA POSTANE NEVIDLJI ELEMENT SA KOJIM SE PREKLAPA logInButton
		
//		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//		if(invisible) {
//			WebElement logInButton = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Log In']")));
//			logInButton.click();
//		}
		
		//DRUGI NACIN DA RESIMO PREKO Javascripta
		WebElement logInButton = driver.findElement(By.xpath("//span[text()='Log In']"));

		jse.executeAsyncScript("arguments[0].click()", logInButton);
		
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
