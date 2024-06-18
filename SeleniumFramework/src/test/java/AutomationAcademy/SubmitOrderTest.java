package AutomationAcademy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationAcademy.TestComponnets.BaseTest;
import AutomationAcademyPageObject.CartPage;
import AutomationAcademyPageObject.CheckOutPage;
import AutomationAcademyPageObject.ConfirmationPage;
import AutomationAcademyPageObject.OrderPage;
import AutomationAcademyPageObject.ProductCatalogue;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws InterruptedException {

		landingPage.loginApplication(input.get("email"), input.get("password"));

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));

		CartPage cartPage = productCatalogue.goTocartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));

		Assert.assertFalse(match);
		CheckOutPage checkOutPage = cartPage.checkOut();
		checkOutPage.addCountry("India");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfimationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		landingPage.loginApplication("putty@gmail.com", "Password1234");

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		/*
		 * map.put("email", "putty@gmail.com"); map.put("password", "Password1234");
		 * map.put("product", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "temu@gmail.com"); map1.put("password", "Password0987");
		 * map1.put("product", "ADIDAS ORIGINAL");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\AutomationAcademy\\DataPackage\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
		// return new Object[][] { { "putty@gmail.com", "Password1234", "ZARA COAT 3"
		// },{ "temu@gmail.com", "Password0987", "ADIDAS ORIGINAL" } }; without using
		// HashCode
	}
	
	
}
