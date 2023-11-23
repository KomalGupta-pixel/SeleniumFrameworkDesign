package KomalGupta.pageobjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import KomalGupta.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

WebDriver driver;

@FindBy(css = "#cart__form > div.checkout > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")
WebElement checkoutEle;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#order-review__form > div > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")
	 private WebElement submit;
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
		
		
	}
	
	
	
	
}
