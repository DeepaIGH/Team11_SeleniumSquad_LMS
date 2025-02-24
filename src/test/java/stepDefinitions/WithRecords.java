package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class WithRecords {


@Given("Admin is logged in to LMS Portal with >={int} records in program list")
public void admin_is_logged_in_to_lms_portal_with_records_in_program_list(Integer int1) {
  System.out.println("Inside Step- Admin is logged in to LMS Portal with >={int} records in program list ");
}

@Then("Admin should see pagination icons disabled")
public void admin_should_see_pagination_icons_disabled() {
	System.out.println("Inside Step- Admin should see pagination icons disabled ");
}
}
