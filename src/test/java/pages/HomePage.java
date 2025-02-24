package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.DriverFactory;
import utils.ConfigReader;

public class HomePage {
	WebDriver driver = DriverFactory.getdriver();
	By loginMsg=By.xpath("//p[text()='Please login to LMS application']");
	By LMSLoginMsg=By.xpath("//p");
	By UserName = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By role=By.xpath("//div[@id='mat-select-value-1']/span");
	By adminrole=By.xpath("//mat-option/span[text()=' Admin ']");
	By Login = By.xpath("//button[@id='login']");
	By dashboard=By.xpath("//div[@class='box']");
	By LMSTitle=By.xpath("//mat-toolbar/span[1]");
	By navigationBarText=By.xpath("//div[@class='ng-star-inserted']/button/span[1]");
	By navigationBarBtn=By.xpath("//div[@class='ng-star-inserted']/button");
	By navigationBar=By.xpath("//div[@class='ng-star-inserted']");
	By piechart=By.xpath("//app-doughnutchart");
	By WelcomeMsgUser=By.xpath("//div[@class='top']/strong");
	By WelcomeMsgRole=By.xpath("//div[text()='ADMIN']");
	//By barChart=By.xpath("//figure[@class='mat-figure']/div/div/canvas[@width='339']");
	By barChart=By.xpath("//mat-card-content[@class='mat-card-content']//canvas[@class='chartjs-render-monitor']");
	//user
	By userCount=By.xpath("//div[@class='widget green']//div[@class='top']");
	By userText=By.xpath("//div[@class='widget green']//div[@class='bottom']");
	//Staff
	By staffCount=By.xpath("//div[@class='widget yellow']//div[@class='top']");
	By staffText=By.xpath("//div[@class='widget yellow']//div[@class='bottom']");
	//Batches
	By batchesCount=By.xpath("//div[@class='widget red']//div[@class='top']");
	By batchesText=By.xpath("//div[@class='widget red']//div[@class='bottom']");
	//Programs
	By programsCount=By.xpath("//div[@class='widget blue']//div[@class='top']");
	By programsText=By.xpath("//div[@class='widget blue']//div[@class='bottom']");
	//Staff Table
	By staffTable=By.xpath("//app-staffdata");
	By staffTableTitle=By.xpath("//app-staffdata/h3");
	By paginationIcons=By.className("mat-paginator-range-actions"); 
	By pagination=By.xpath("//div[@class='mat-paginator-range-actions']/div");
	//Number of rows in Staff Table in a page
	By staffRows=By.xpath("//mat-row");
	//previous buttons
	By previousFirst=By.xpath("//button[@aria-label='First page']");
	By previousSecond=By.xpath("//button[@aria-label='Previous page']");
	
	//("//div[normalize-space()='49']");
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for Username field and enter text
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
		driver.findElement(UserName).sendKeys(ConfigReader.getUsername());
	}
	
	public void enterPassword() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		driver.findElement(Password).sendKeys(ConfigReader.getPassword());
	}
	
	public void enterRole() {
		driver.findElement(role).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement role = wait.until(ExpectedConditions.visibilityOfElementLocated(adminrole));
		driver.findElement(adminrole).click();
		// Wait for an element on the homepage to ensure successful login
       // wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardMSG));
	}
	
	public void loginButtonClicked() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
		driver.findElement(Login).click();
	}
	
	public boolean checkLMSTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(LMSTitle));
		System.out.println("Title: "+title.getText());
		return title.isDisplayed();
	}
	
	public boolean verifyLMSTitleLeftAlignment() {

		Point lmsTitle = driver.findElement(By.xpath("//span[text()=' LMS - Learning Management System ']")).getLocation();

		int titleX = lmsTitle.getX();
		System.out.println("LMS title X-Coordinate: "+titleX);
		int titleY = lmsTitle.getY();
		System.out.println("LMS title Y-Coordinate: "+titleY);
		if(titleX <= 16 && titleY <= 16) {
			return true;
		}
		return false;
		
	}
	
	public List<String> checkNavBarSpelling(){
		 
		 // Locate all navigation bar text (span elements)
         List<WebElement> barTexts = driver.findElements(navigationBarText);
         
      // Extract the text of each option
         List<String> actualBarTexts = new ArrayList<>();
         for (WebElement text : barTexts) {
        	 actualBarTexts.add(text.getText().trim());
         }
		 return actualBarTexts;
	}
	
	public String verifyLMSTitle() {

		return driver.findElement(LMSTitle).getText();

	}
	
	public void verifyNavigationBarTextAndAlignment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
		List<WebElement> barTexts = driver.findElements(navigationBarBtn);
         
	      // Extract the text of each option
	         
	         for (WebElement text : barTexts) {
	        	 int x_bar_text=text.getLocation().getX();
	        	 int y_bar_text=text.getLocation().getY();
	        	 System.out.println(" ("+x_bar_text+" , "+y_bar_text+" )"+" : (X , Y) co-ordinator of "+text.getText());
	        	 Assert.assertTrue( x_bar_text > 1000 && y_bar_text < 20,"Navigation bar item is aligned to the top right side.");
	         }
	}
	
	 public String testHomeIsFirstInNavBar() {
	        // Locate all navigation bar options 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
			List<WebElement> navItems = driver.findElements(navigationBarText);
	       
			// Ensure at least one menu item exists
	        Assert.assertFalse(navItems.isEmpty(), "Navigation bar is empty!");

	        // Get the first menu item text
	        String firstMenuItemText = navItems.get(0).getText().trim();

	       return firstMenuItemText;
	    }

	 public String testProgramIsSecondInNavBar() {
	        // Locate all navigation bar options 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
			List<WebElement> navItems = driver.findElements(navigationBarText);
	       
			// Ensure at least one menu item exists
	        Assert.assertFalse(navItems.isEmpty(), "Navigation bar is empty!");

	        // Get the second menu item text
	        String secondMenuItemText = navItems.get(1).getText().trim();

	       return secondMenuItemText;
	    }
	 
	 public String testBatchIsThirdInNavBar() {
	        // Locate all navigation bar options 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
			List<WebElement> navItems = driver.findElements(navigationBarText);
	       
			// Ensure at least one menu item exists
	        Assert.assertFalse(navItems.isEmpty(), "Navigation bar is empty!");

	        // Get the third menu item text
	        String thirdMenuItemText = navItems.get(2).getText().trim();

	       return thirdMenuItemText;
	    }
	 
	 public String testClassIsForthInNavBar() {
	        // Locate all navigation bar options 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
			List<WebElement> navItems = driver.findElements(navigationBarText);
	       
			// Ensure at least one menu item exists
	        Assert.assertFalse(navItems.isEmpty(), "Navigation bar is empty!");

	        // Get the forth menu item text
	        String forthMenuItemText = navItems.get(3).getText().trim();

	       return forthMenuItemText;
	    }
	 
	 public String testLogoutIsFifthInNavBar() {
	        // Locate all navigation bar options 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement navbar  = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBar));
			List<WebElement> navItems = driver.findElements(navigationBarText);
	       
			// Ensure at least one menu item exists
	        Assert.assertFalse(navItems.isEmpty(), "Navigation bar is empty!");

	        // Get the fifth menu item text
	        String fifthMenuItemText = navItems.get(4).getText().trim();

	       return fifthMenuItemText;
	    }
	 
	 public boolean checkPiechartPresence() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement pie  = wait.until(ExpectedConditions.visibilityOfElementLocated(piechart));
			if(pie.isDisplayed()) {
				return true;
			}
			else
				return false;
	 }

	 public boolean verifyWelcomeMsgUserRole() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement user  = wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeMsgUser));
			WebElement role  = wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeMsgRole));
			if(user.isDisplayed() && role.isDisplayed()) {
				System.out.println("Message displayed:  \n"+user.getText());
				System.out.println(role.getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkBarChartPresence() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement barchart  = wait.until(ExpectedConditions.visibilityOfElementLocated(barChart));
			if(barchart.isDisplayed()) {
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkUserCount() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement usercount  = wait.until(ExpectedConditions.visibilityOfElementLocated(userCount));
			WebElement usertxt  = wait.until(ExpectedConditions.visibilityOfElementLocated(userText));
			if(usercount.isDisplayed()&& usertxt.isDisplayed()) {
				System.out.println("User count is displayed as: \n"+usercount.getText()+"\n"+usertxt.getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkStaffCount() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement staffcount  = wait.until(ExpectedConditions.visibilityOfElementLocated(staffCount));
			WebElement stafftxt  = wait.until(ExpectedConditions.visibilityOfElementLocated(staffText));
			if(staffcount.isDisplayed()&& stafftxt.isDisplayed()) {
				System.out.println("User count is displayed as: \n"+staffcount.getText()+"\n"+stafftxt.getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkBatchesCount() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement batchescount  = wait.until(ExpectedConditions.visibilityOfElementLocated(batchesCount));
			WebElement batchestxt  = wait.until(ExpectedConditions.visibilityOfElementLocated(batchesText));
			if(batchescount.isDisplayed()&& batchestxt.isDisplayed()) {
				System.out.println("User count is displayed as: \n"+batchescount.getText()+"\n"+batchestxt.getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkProgramsCount() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programscount  = wait.until(ExpectedConditions.visibilityOfElementLocated(programsCount));
			WebElement programstxt  = wait.until(ExpectedConditions.visibilityOfElementLocated(programsText));
			if(programscount.isDisplayed()&& programstxt.isDisplayed()) {
				System.out.println("User count is displayed as: \n"+programscount.getText()+"\n"+programstxt.getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public boolean checkStaffTableWithPaginationIcon() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement staff_table  = wait.until(ExpectedConditions.visibilityOfElementLocated(staffTable));
			WebElement pagination_icon  = wait.until(ExpectedConditions.visibilityOfElementLocated(paginationIcons));
			if(staff_table.isDisplayed()&& pagination_icon.isDisplayed()) {
				System.out.println("Staff Table is displayed withPagination Icons! \n Table Title: "+driver.findElement(staffTableTitle).getText()+"\n Pgination: "+driver.findElement(pagination).getText());
				return true;
			}
			else
				return false;
	 }
	 
	 public int checkStaffDataInPage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement stafftable  = wait.until(ExpectedConditions.visibilityOfElementLocated(staffTable));
			List<WebElement> staffData = driver.findElements(staffRows);
	       
			// Ensure at least one menu item exists
	        if(staffData.isEmpty()) {
	        	System.out.println("Staff table is empty!");
	        }
	        

	        // Get the rows in a table in a home Page
	        int staffrows = staffData.size();
	        System.out.println("Number of rows in a Staff Table in a home page are: "+staffrows);

	       return staffrows;
	 }
	 
	 public boolean checkPreviousPageIconDisable() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement preFirst  = wait.until(ExpectedConditions.visibilityOfElementLocated(previousFirst));
			WebElement preSecond  = wait.until(ExpectedConditions.visibilityOfElementLocated(previousSecond));
			
	        if(!preSecond.isEnabled()) {
	        	System.out.println("Is Previous Page Icon disabled: "+ !preSecond.isEnabled()  );
	        	return true;
	        }
	        else
	        	return false;
	 }
	 
	 public boolean checkFirstPageIconDisable() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement preFirst  = wait.until(ExpectedConditions.visibilityOfElementLocated(previousFirst));
			
			
	        if(!preFirst.isEnabled()) {
	        	System.out.println("Is First Page Icon disabled: "+ !preFirst.isEnabled()  );
	        	return true;
	        }
	        else
	        	return false;
	 }
	 

	 
}//end of class
