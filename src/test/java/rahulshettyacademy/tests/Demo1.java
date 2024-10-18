package rahulshettyacademy.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//WebDriver driver;
System.setProperty("webdriver.gecko.driver","E:\\eclipse-workspace\\RahulshettyAcademy1\\drivers\\geckodriver.exe");
 WebDriver driver = new FirefoxDriver();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.manage().deleteAllCookies();
driver.get("www.google.com/");
System.out.println(driver.getTitle());
	}

}
