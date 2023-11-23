package KomalGupta.Tests;

import java.io.IOException;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.AssertJUnit;

//import java.time.Duration;


import java.util.List;
import KomalGupta.TestComponents.Retry;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


//import io.github.bonigarcia.wdm.WebDriverManager;
import KomalGupta.pageobjects.LandingPage;
import KomalGupta.pageobjects.ProductCatalog;
import KomalGupta.TestComponents.BaseTest;
import KomalGupta.pageobjects.CartPage;
import KomalGupta.pageobjects.CheckoutPage;
import KomalGupta.pageobjects.ConfirmationPage;

public class ErrorValidation extends BaseTest {
	
    @Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "DAYTON";
		ProductCatalog productCatalog = landingPage.loginApp("komal@att.com", "testqa1234");
		Assert.assertEquals("Your User ID  or Password is incorrect. Try again.", landingPage.getErrorMessage());
			
 
	}
    @Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "DAYTON";
		ProductCatalog productCatalog = landingPage.loginApp("komal@att.com", "testqa@1234");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		//Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		//Assert.assertFalse(match);
		
	

	}


}
