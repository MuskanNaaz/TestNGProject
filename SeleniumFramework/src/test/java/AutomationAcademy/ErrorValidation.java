package AutomationAcademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AutomationAcademy.TestComponnets.BaseTest;
import AutomationAcademy.TestComponnets.Retry;
import AutomationAcademyPageObject.CartPage;
import AutomationAcademyPageObject.ProductCatalogue;
import junit.framework.Assert;

public class ErrorValidation extends BaseTest {

	@Test(groups = { "ErrorValadiation" }, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("putty@gmail.com", "Password124");

		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void productValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";

		landingPage.loginApplication("putty@gmail.com", "Password1234");

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		CartPage cartPage = productCatalogue.goTocartPage();
		Boolean match = cartPage.verifyProductDisplay("Zara coat");

		Assert.assertFalse(match);

	}

}
