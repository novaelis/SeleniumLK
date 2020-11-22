package workingwithscreenshots;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import usefulmethods.GenericMethods;

public class ScreenshotsDemo {
	
	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.facebook.com/";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseURL);
		gm.clickWhenReady(By.name("login"), 2);
	}
	

	@After
	public void tearDown() throws Exception {
		String filename = getRandomString(10) + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		
		driver.quit();
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqestuvwxyzABCDEFGHIJKLMNOPQESTUVWXYZ123456790";
		

		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random()*characters.length());
			sb.append(characters.charAt(index));
		}
		
		return sb.toString();
	}


}
