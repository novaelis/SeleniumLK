package browserprofiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class ProfilesDemo {
	public static void main(String[] args) {
		String URL = "https://letskodeit.teachable.com/p/practice";
		WebDriver driver;
		

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("automationprofile");

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

	}

}
