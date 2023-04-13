package step_definition;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps {

	LogInPage loginPage = new LogInPage();
	BrowserUtils utils=new BrowserUtils();

	//Valid login scenario
	
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginPage.emailField,DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.password,DataReader.getProperty("password"));
		
		//loginPage.emailField.sendKeys(DataReader.getProperty("username"));
		//loginPage.password.sendKeys(DataReader.getProperty("password"));
	}

	@When("I clicked on login button")
	public void i_click_on_login_button()
	{
		loginPage.button.click();
		
	}

	@Then("I should be on user profile page")
	public void i_should_be_on_user_profile_page() {
		Assert.assertTrue(loginPage.header.isDisplayed());
	}
	
	//Invalid login scenario
	
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
	    utils.actionsSendKeys(loginPage.emailField, DataReader.getProperty("invalidUsername"));
	    utils.actionsSendKeys(loginPage.password,DataReader.getProperty("password"));
	}
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		utils.waitUntilElementVisible(loginPage.errrorMessage);
	   Assert.assertTrue(loginPage.errrorMessage.isDisplayed());
	   
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		
	    Assert.assertTrue(loginPage.emailField.isDisplayed());
	}
	
	//invalid password login step
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		utils.actionsSendKeys(loginPage.emailField, DataReader.getProperty("username"));
	    utils.actionsSendKeys(loginPage.password,DataReader.getProperty("invalidpassword"));
	}
	
}
