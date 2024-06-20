package AutomationAcademyPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationAcademy.AbstractComponents.AbstarctComponents;

public class OrderPage extends AbstarctComponents {
	WebDriver driver;
	

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class = 'btn btn-primary col-md-2']")
	WebElement checkOut;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public Boolean verifyOrderDisplay(String productName) {

		Boolean match = productNames.stream()
				.anyMatch(cardProduct -> cardProduct.getText().equalsIgnoreCase(productName));
		return match;

	}

}
