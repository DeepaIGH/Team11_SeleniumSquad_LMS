package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramNavigPage;
import utils.ConfigReader;
import utils.LoggerLoad;

public class ProgramNavigAndMenuBarSteps {
	public WebDriver driver = DriverFactory.getdriver();
	ProgramNavigPage programobj = new ProgramNavigPage(driver);//calls the constr in ProgramPageNavi
	
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() 
	{
		LoggerLoad.info("Admin is on home page after Login");
	}

	@When("Admin clicks <Program> on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() 
	{
		programobj.clickProgramButton();
	    LoggerLoad.info("Admin clicks on program btn");

	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() 
	{
		String programpageUrl = programobj.getCurrentUrl();
		Assert.assertEquals(programpageUrl, ConfigReader.getManageProgramUrl());
	    LoggerLoad.info("Admin clicks on login btn");
	}
	//Menu Bar
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		Boolean logoutPresent = programobj.checkLogoutBtn();
		Assert.assertTrue(logoutPresent);
	    LoggerLoad.info("Admin clicks on login btn");
	}
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String expectedHeading) {
		String actualHeading = programobj.getHeading();
		Assert.assertEquals(actualHeading,expectedHeading);
	    LoggerLoad.info("Admin sees the heading Manage program");

	}
//	@Then("Admin should see the page names as in order {string}")
//	public void admin_should_see_the_page_names_as_in_order(String expecPageNamesOrder) {
//		String actualOrder = programobj.getPageNamesOrder();
//		//List<String> actualOrder = programobj.getPageNamesOrder();
//		//Assert.assertEquals(actualOrder,Arrays.asList(expOrder));
//		Assert.assertEquals(actualOrder, expecPageNamesOrder);
//	    LoggerLoad.info("Admin clicks on login btn");
//	}
	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String expectedSubMenu) {
		String actualSubMenu = programobj.getSubMenu();
		Assert.assertEquals(actualSubMenu,expectedSubMenu);
	    LoggerLoad.info("Admin sees sub menu in menu bar");
	}
	@Then("Admin Should see the page names in order {string} in {string}")
	public void admin_should_see_the_page_names_in_order_in(String pageName, String order) {
		String actualPageName= programobj.validatePagenamesinOrder(pageName,order);
		Assert.assertEquals(actualPageName,pageName);
	    LoggerLoad.info("Admin sees the page names in order");
	}
}
