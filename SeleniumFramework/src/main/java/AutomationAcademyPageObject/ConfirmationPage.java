package AutomationAcademyPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationAcademy.AbstractComponents.AbstarctComponents;

public class ConfirmationPage extends AbstarctComponents{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class = 'hero-primary']")
	WebElement confirmMessage;
	
	public String getConfimationMessage() {
		return confirmMessage.getText();
	}

}
