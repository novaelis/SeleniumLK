package browserprofiles;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeOptionsDemo {
	public static void main(String[] args) {
		
		
		String URL = "https://letskodeit.teachable.com/p/practice";
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\novaelis\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aippcjnckhedlldemggbpammdiamikce\\0.0.1.29_0.crx"));

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		//C:\Users\novaelis\AppData\Local\Google\Chrome\User Data\Default\Extensions\aippcjnckhedlldemggbpammdiamikce\0.0.1.29_0.crx
	}
}
