package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest
{
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws Exception
	{
		// TODO Auto-generated method stub
		
//removed line ------LandingPage landingPage = launchApplication();
//ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));	
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.getToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	//Extent Reports -
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","anshika@gmail.com");
//		map.put("password","Iamking@000");
//		map.put("product","ZARA COAT 3");
		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","gajul@gmail.com");
//		map1.put("password","Ns@gmail1");
//		map1.put("product","ADIDAS ORIGINAL");
		
		//Object[][] = is multidimensional array stores multiple array of data
List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+
		"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");

	return new Object[][] {{data.get(0)},{data.get(1)}};
	
	}

}

		
	//	@DataProvider
	//	public Object[][] getData()
	//	{
	//		return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"gajul@gmail.com","Ns@gmail1","ADIDAS ORIGINAL"}};
	//	}
//	}
//}
		//removed line due to page object file created--		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		//removed line--			driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		//removed line--			driver.findElement(By.id("login")).click();
		//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
				//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
					
			//	WebElement prod =	products.stream().filter(product->
			//		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
			//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			  //		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    	//      ng-animating
		    //		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
					
					//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
				//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		//		Assert.assertTrue(match);
			//	driver.findElement(By.cssSelector(".totalRow button")).click();
				
	//			Actions a = new Actions(driver);
	//			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
				
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
				
		//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		//		driver.findElement(By.cssSelector(".action__submit")).click();
				
		//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			//	driver.close();
		//		
				

//	}

//}
//WebDriverManager.chromedriver().setup();
///		System.setProperty("webdriver.chrome.driver","E:\\Selenium webdriver -New 6 pm\\109 chromedriver\\chromedriver_win32\\chromedriver.exe");
//we will connect selenium webDriver object with remote driver object

//			WebDriverManager.chromedriver().setup();
	//		WebDriver driver = new ChromeDriver();
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//		driver.manage().window().maximize();