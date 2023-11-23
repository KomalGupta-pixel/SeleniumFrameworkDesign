package KomalGupta.pageobjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import KomalGupta.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

WebDriver driver;

@FindBy(css = "#cart__form > div.checkout > div.checkout__layout > div.checkout__sidebar > div.checkout__button-wrapper > button")
WebElement checkoutEle;

@FindBy(css = "[class*='osdr-order-block-item-type']")
private List<WebElement> productNames;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

	
	
	
}
