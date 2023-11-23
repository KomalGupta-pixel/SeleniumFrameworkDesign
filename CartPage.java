package KomalGupta.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import KomalGupta.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

WebDriver driver;

@FindBy(css = "#cart__form > div.checkout > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")
WebElement checkoutEle;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
		

	}
	
	
	
	
}
