package KomalGupta.pageobjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import KomalGupta.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".home__carousel-products")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".home__carousel-products");
	By addToCart = By.cssSelector(".add-to-cart form button");
	By toastMessage = By.id("addToCart");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector(".home__carousel-brand")).getText().equals("DAYTON")).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
	}
	
}
