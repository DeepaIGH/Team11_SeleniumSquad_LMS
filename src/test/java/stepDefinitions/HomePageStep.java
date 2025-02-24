package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import utils.LoggerLoad;

public class HomePageStep {
	WebDriver driver = DriverFactory.getdriver();
	HomePage home=new HomePage(DriverFactory.getdriver());
	
	@When("Admin enter valid data in all field and  clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
		home.enterUserName();
	    home.enterPassword();
	    home.enterRole();
	    home.loginButtonClicked();
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		try {
	    Assert.assertTrue(home.checkLMSTitle(),"LMS -Learning management system title is displayed!");
	    LoggerLoad.info("LMS -Learning management system title is displayed!");
		}
		catch(NoSuchElementException e) {
			LoggerLoad.error("LMS -Learning management system title is not displayed!");
		}
	}
	
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		try {
			Thread.sleep(1000);
			Assert.assertTrue(home.verifyLMSTitleLeftAlignment(),"LMS title is on the top-left corner of the Home page.");
			LoggerLoad.info("Validating LMS title on top left corner.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		try {
			String barTexts="Home, Program, Batch, Class, Logout";
			 // Convert string to list
	        List<String> expectedTexts = Arrays.asList(barTexts.split("\\s*,\\s*"));

	        System.out.println("expectedTexts: "+expectedTexts);
	        List<String> actualTexts=home.checkNavBarSpelling();
	        System.out.println("actualTexts: "+actualTexts);
	        Assert.assertEquals(actualTexts, expectedTexts, "Navigation bar texts do not match!");
	        System.out.println("Test Passed: Navigation bar has the expected texts.");
	        LoggerLoad.info("Test Passed: Navigation bar has the expected texts.");

	        } catch (Exception e) {
	            System.out.println("Test Failed: " + e.getMessage());
	            LoggerLoad.error("Test Failed: " + e.getMessage());
	        }
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		try {
			Thread.sleep(1000);
			String actualtitle = home.verifyLMSTitle();
			System.out.println("Title: "+actualtitle);
			Assert.assertEquals(actualtitle, "LMS - Learning Management System");
			LoggerLoad.info("Admin sees correct spelling");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		home.verifyNavigationBarTextAndAlignment();
		LoggerLoad.info("Admin see the navigation bar text on the top right side");

	}

	@Then("Admin should see home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
		try {
	    String firstMenuItemText=home.testHomeIsFirstInNavBar();
	    // Assert "Home" is the first item
        Assert.assertEquals(firstMenuItemText, "Home", "Home is NOT the first menu option!");
        System.out.println("1st text in Navigation Bar is: "+firstMenuItemText);
        LoggerLoad.info("1st text in Navigation Bar is: "+firstMenuItemText);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		try {
		    String secondMenuItemText=home.testProgramIsSecondInNavBar();
		    // Assert "Program" is the second item
	        Assert.assertEquals(secondMenuItemText, "Program", "Program is NOT the second menu option!");
	        System.out.println("2nd option in Navigation Bar is: "+secondMenuItemText);
	        LoggerLoad.info("2nd option in Navigation Bar is: "+secondMenuItemText);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Then("Admin should see batch in the  3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
		try {
		    String thirdMenuItemText=home.testBatchIsThirdInNavBar();
		    // Assert "Batch" is the third item
	        Assert.assertEquals(thirdMenuItemText, "Batch", "Batch is NOT the third menu option!");
	        System.out.println("3rd option in Navigation Bar is: "+thirdMenuItemText);
	        LoggerLoad.info("3rd option in Navigation Bar is: "+thirdMenuItemText);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
		try {
		    String forthMenuItemText=home.testClassIsForthInNavBar();
		    // Assert "Class" is the forth item
	        Assert.assertEquals(forthMenuItemText, "Class", "Class is NOT the forth menu option!");
	        System.out.println("4th option in Navigation Bar is: "+forthMenuItemText);
	        LoggerLoad.info("4th option in Navigation Bar is: "+forthMenuItemText);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() {
		try {
		    String fifthMenuItemText=home.testLogoutIsFifthInNavBar();
		    // Assert "Logout" is the fifth item
	        Assert.assertEquals(fifthMenuItemText, "Logout", "Logout is NOT the fifth menu option!");
	        System.out.println("5th option in Navigation Bar is: "+fifthMenuItemText);
	        LoggerLoad.info("5th option in Navigation Bar is: "+fifthMenuItemText);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Then("Admin should see piechart")
	public void admin_should_see_piechart() {
		try {
	    boolean piePresence =home.checkPiechartPresence();
	    Assert.assertTrue(piePresence);
	    LoggerLoad.info("Pie chart is displayed on the home page!");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() {
	    
	    try {
		    boolean welcomeMsg =home.verifyWelcomeMsgUserRole();
		    Assert.assertTrue(welcomeMsg);
		    LoggerLoad.info("Welcome message with user name and role is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
		try {
		    boolean barPresence =home.checkBarChartPresence();
		    Assert.assertTrue(barPresence);
		    LoggerLoad.info("Bar chart is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
		try {
		    boolean userCountPresence =home.checkUserCount();
		    Assert.assertTrue(userCountPresence);
		    LoggerLoad.info("User count is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see staff count")
	public void admin_should_see_staff_count() {
		try {
		    boolean staffCountPresence =home.checkStaffCount();
		    Assert.assertTrue(staffCountPresence);
		    LoggerLoad.info("Staff count is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see Program count")
	public void admin_should_see_program_count() {
		try {
		    boolean programsCountPresence =home.checkProgramsCount();
		    Assert.assertTrue(programsCountPresence);
		    LoggerLoad.info("Programs count is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see batch  count")
	public void admin_should_see_batch_count() {
		try {
		    boolean batchesCountPresence =home.checkBatchesCount();
		    Assert.assertTrue(batchesCountPresence);
		    LoggerLoad.info("Batches count is displayed on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {
		try {
		    boolean staffTablePresence =home.checkStaffTableWithPaginationIcon();
		    Assert.assertTrue(staffTablePresence);
		    LoggerLoad.info("Staff Table is displayed with Pgination Icons on the home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer rows) {
		try {
		    int staffRows =home.checkStaffDataInPage();
		    Assert.assertEquals(staffRows,rows);
		    LoggerLoad.info("Staff Table is displayed with 5 staff data in a home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
		try {
		    boolean status =home.checkPreviousPageIconDisable();
		    Assert.assertEquals(status,true);
		    LoggerLoad.info("Previous Page icon is disabled in a home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
		try {
		    boolean status =home.checkFirstPageIconDisable();
		    Assert.assertEquals(status,true);
		    LoggerLoad.info("First Page icon is disabled in a home page!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}//end of HomePageStep class
