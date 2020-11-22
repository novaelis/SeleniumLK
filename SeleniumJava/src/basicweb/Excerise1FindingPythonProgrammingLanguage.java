package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excerise1FindingPythonProgrammingLanguage {

	public static void main(String[] args) {

		String URL = "https://letskodeit.teachable.com/p/practice";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		WebElement pythonCoursePrice = driver.findElement(By.xpath(
				"//table[@id=\"product\"]//td[text()='Python Programming Language']//following-sibling::td"));
		System.out.println(pythonCoursePrice.getText());

	}

}
