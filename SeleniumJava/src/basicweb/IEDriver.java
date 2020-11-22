package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver {
	public static void main(String[] args) {
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\novaelis\\eclipse-workspace\\libs\\drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
	}
}
