package KomalGupta.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KomalGupta.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="signin_username")
	WebElement username;
	
	@FindBy(id="signin_password")
	WebElement passwordEle;
	
	@FindBy(css=".primary")
	WebElement submit;
	
	@FindBy(css="[class*='signin_text experience-system-14td3vq']")
	WebElement errorMessage;

	
	public ProductCatalog loginApp(String userName, String password) {
		username.sendKeys(userName);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo() {
		driver.get("https://lt.gcom.grainger.com/myaccount/signin?frwdUrlPath=%2F%3FO%3D1p");
	}
}
