package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise2FindAuthorGreenMile {
	public static void main(String[] args) {
		String URL = "http://dhtmlx.com/docs/products/dhtmlxGrid/";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		WebElement numberOfHoursCatherineJohnson = driver.findElement(By.xpath(
				"//div[@id=\"grid-demo\"]//div[contains(text(),'Catherine Johnson')]//parent::div//following-sibling::div[1]"));
		System.out.println(numberOfHoursCatherineJohnson.getText());
	}
}
