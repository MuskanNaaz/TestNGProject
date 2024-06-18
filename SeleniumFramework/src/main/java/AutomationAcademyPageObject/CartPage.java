package AutomationAcademyPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationAcademy.AbstractComponents.AbstarctComponents;

public class CartPage extends AbstarctComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	@FindBy(xpath = "//*[@class = 'cartSection']/h3")
	private List<WebElement> productTitles;

	public Boolean verifyProductDisplay(String productName) {

		Boolean match = productTitles.stream()
				.anyMatch(cardProduct -> cardProduct.getText().equalsIgnoreCase(productName));
		return match;

	}

	public CheckOutPage checkOut() {
		checkOut.click();
		return new CheckOutPage(driver);
	}

}
