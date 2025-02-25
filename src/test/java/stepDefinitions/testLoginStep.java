package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.LoggerLoad;

import io.cucumber.java.en.*;
import pages.TestLoginPage;
import driverFactory.DriverFactory;
import utils.ConfigReader;

public class testLoginStep {
	public WebDriver driver=DriverFactory.getdriver();
	TestLoginPage tl=new TestLoginPage();
	
	@Given("User enters the LMS url {string}")
	public void user_enters_the_lms_url(String string) {
		driver.get(ConfigReader.getHomePageUrl());
		
	}

	@And("enters username {string} and password {string} and select role as Admin")
	public void enters_username_and_password_and_select_role_as_admin(String username, String password) {
	    tl.loginUsingValues(username, password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	    tl.clickLoginBtn();
	    LoggerLoad.info("Admin clicks on login btn");
	}

	@Then("user lands on Homepage")
	public void user_lands_on_homepage() {
		String Actualurl=driver.getCurrentUrl();
		Assert.assertEquals(Actualurl,"https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login");
	}


}
