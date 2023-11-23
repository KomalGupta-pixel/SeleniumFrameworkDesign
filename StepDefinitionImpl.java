package KomalGupta.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import KomalGupta.TestComponents.BaseTest;
import KomalGupta.pageobjects.CartPage;
import KomalGupta.pageobjects.CheckoutPage;
import KomalGupta.pageobjects.ConfirmationPage;
import KomalGupta.pageobjects.LandingPage;
import KomalGupta.pageobjects.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalog productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		//code
	}

	@Given("Logged in with komal@att.com and testqa@{int}")
	public void logged_in_with_komal_att_com_and_testqa(Integer int1) {
	
		String username = "komal@att.com";
		String password = "testqa@1234";
		productCatalogue = landingPage.loginApp(username,password);
	
	}
	
	@When("I add product DAYTON to cart")
	public void i_add_product_dayton_to_cart() {
		List<WebElement> products = productCatalogue.getProductList();
		String productName = "DAYTON";
		productCatalogue.addProductToCart(productName);
	}
	
	@And("Checkout DAYTON and Submit the Order")
	public void checkout_dayton_and_submit_the_order() {
		CartPage cartPage = productCatalogue.goToCartPage();

		CheckoutPage checkoutPage = cartPage.goToCheckout();
		 confirmationPage = checkoutPage.submitOrder();
	}
	

    @Then("{string} message is displayed on Confirmation page")
    public void message_displayed_confirmationPage(String string)
    {
    	String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
    }
    
    @When("Logged in with komal@att.com and testqa1234")
    public void logged_in_with_komal_att_com_and_testqa1234() {
    	String username = "komal@att.com";
		String password = "testqa1234";
		productCatalogue = landingPage.loginApp(username,password);
    }
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
   
    	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
    	driver.close();
    }


}
