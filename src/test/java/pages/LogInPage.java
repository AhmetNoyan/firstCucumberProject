package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class LogInPage {

	
	public LogInPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	@FindBy (name="email")
	public WebElement emailField;
	
	@FindBy (name="password")
	public WebElement password;
	
	@FindBy (xpath="//button[text()='Login']")
	public WebElement button ;
	
	
	@FindBy(xpath="//h6[textt()='']")
	public WebElement header;
}
