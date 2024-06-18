package AutomationAcademyPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationAcademy.AbstractComponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// PageFactory

	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*= 'flyInOut']" )
	WebElement errorMessage;
	
	public void loginApplication(String email, String password1) {
		userEmail.sendKeys(email);
		password.sendKeys(password1);
		submit.click();
		
	}
	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitForWebElementToApear(errorMessage);
		return errorMessage.getText();
	}
	
}
