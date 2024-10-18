package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.LandingPage;

public class SubmitAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium webdriver -New 6 pm\\109 chromedriver\\chromedriver_win32\\chromedriver.exe");
		//we will connect selenium webDriver object with remote driver object
		WebDriver driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.manage().window().maximize();
					driver.get("https://rahulshettyacademy.com/client");
					LandingPage landingPage = new LandingPage(driver);
				//	LandingPage landingPage = new LandingPage(driver);
					driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
					driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
					driver.findElement(By.id("login")).click();
			//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
						List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//products.stream().filter(product-> product.getText().equals("ZARA COAT 3"));
				WebElement prod= products.stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	}

}
