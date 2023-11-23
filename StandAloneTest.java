package KomalGupta.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;


import java.util.List;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;
import KomalGupta.pageobjects.LandingPage;
import KomalGupta.pageobjects.OrderPage;
import KomalGupta.pageobjects.ProductCatalog;
import KomalGupta.TestComponents.BaseTest;
import KomalGupta.pageobjects.CartPage;
import KomalGupta.pageobjects.CheckoutPage;
import KomalGupta.pageobjects.ConfirmationPage;

public class StandAloneTest extends BaseTest {
	String productName = "DAYTON";
    @Test(dataProvider="getData",groups={"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ProductCatalog productCatalog = landingPage.loginApp(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage=productCatalog.goToCartPage();
		CheckoutPage checkoutpage = cartPage.goToCheckout();
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();
	
		
		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".checkout-product-detail__brand"));		
		//Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("DAYTON"));
		//Assert.assertTrue(match);
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout__sidebar")));
		//driver.findElement(By.cssSelector("#cart__form > div.checkout > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")).click();
		//driver.findElement(By.cssSelector("#order-review__form > div > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")).click();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Order Confirmation"));
		
			
 
	}
    @Test(dependsOnMethods= {"SubmitOrder"})
    public void OrderHistoryTest() {
    	ProductCatalog productCatalog = landingPage.loginApp("komal@att.com", "testqa@1234");
    	OrderPage orderpage = productCatalog.goToOrdersPage();
    	Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
}
    @DataProvider
    public Object[][] getData() throws IOException{
    	
    	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\KomalGupta\\Data\\PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
    }
}
