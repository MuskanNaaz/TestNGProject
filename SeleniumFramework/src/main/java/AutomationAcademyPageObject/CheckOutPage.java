package AutomationAcademyPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AutomationAcademy.AbstractComponents.AbstarctComponents;


public class CheckOutPage extends AbstarctComponents {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class = 'form-group']/input")
	WebElement countrySelect;
	
	@FindBy(css = ".ta-item:nth-of-type(1)")
	WebElement countryClick;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrder;
	
	
	By countryList = By.cssSelector(".ta-item");	

	public void addCountry(String countryName) throws InterruptedException {
		Actions a = new Actions(driver);	
		a.sendKeys(countrySelect, countryName).build().perform();
		waitForElementToApear(countryList);
		countryClick.click();
		
	}
	public ConfirmationPage submitOrder() {
		placeOrder.click();
		return new ConfirmationPage(driver);
	}

	
	



	
	
	
	

}
