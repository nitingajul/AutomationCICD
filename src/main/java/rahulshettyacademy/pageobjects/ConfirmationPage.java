package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	//it's dedicated to actions, not for test cases execution, and initialization of webe elements
	public String getConfirmationMessage()
	{
	//	CheckoutPage cp = new CheckoutPage(driver);
		return confirmationMessage.getText();
	}

}
