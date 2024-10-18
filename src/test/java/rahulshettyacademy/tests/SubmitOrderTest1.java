package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String productName = "ZARA COAT 3";
				WebDriverManager.chromedriver().setup();
				WebDriver driver =new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.manage().window().maximize();
				LandingPage landingPage = new LandingPage(driver);
				landingPage.goTo();
					ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
				
				List<WebElement> products = productCatalogue.getProductList();
				productCatalogue.addProductToCart(productName);
				CartPage cartPage = productCatalogue.goToCartPage();
				
				Boolean match =cartPage.VerifyProductDisplay(productName);
				Assert.assertTrue(match);
				CheckoutPage checkoutPage = cartPage.getToCheckout();
				checkoutPage.selectCountry("india");
		//		Thread.sleep(2000);
			//	WebElement l = driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"));
			//	JavascriptExecutor j = (JavascriptExecutor) driver;
			//	j.executeScript("arguments[0].click()", l);
		///	//	driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
				
				ConfirmationPage confirmationPage = checkoutPage.submitOrder();
				String confirmMessage = confirmationPage.getConfirmationMessage();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				driver.close();
	}

	
}
