package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagName {

	public static void main(String[] args) {
		String URL = "https://letskodeit.teachable.com/p/practice";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		driver.findElement(By.tagName("a")).click();
		
		//KAKO SVE MOZEMO NACI ELEMNTE U SELENIUMU
		//ID - fastest 
		//NAME
		//CLASSNAME
		//XPATH - NAJVISE KORISCENI
		//LINK TEXT
		//PARTIAL LINK TEXT
		//TAG NAME
		//CSS SELECTOR - NAJVISE KORISCENI	

	}

}
