package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByLinkText {
	public static void main(String[] args) throws InterruptedException {
		String URL = "https://letskodeit.teachable.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		WebElement signIn = driver.findElement(By.linkText("Login"));
		signIn.click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		WebElement practice = driver.findElement(By.partialLinkText("Pract"));
		practice.click();
		
		//MOZEMO DA SAMO TRAZIMO U <a /a> elementu PO LINKTEXTU ILI PARTIALINK TEXTU 

	}
}
