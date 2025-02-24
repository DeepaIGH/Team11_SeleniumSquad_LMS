package pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import driverFactory.DriverFactory;



public class TestClassPage {
	public static Map<String, Map<String, String>> classTestDataMap = new HashMap<>();
	
	public WebDriver driver = DriverFactory.getdriver();
	
	//Locators
    private By ClassBtn = By.xpath("//div[@class='ng-star-inserted']/button[4]");
	private By classDetailsHeading = (By.xpath("//*[@id='pr_id_32-label']"));
	private By MngClass = By.xpath("//div[text()=' Manage Class']");
	private By classPageTitle = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By classSearchBar = By.xpath("//input[@id='filterGlobal']");
	private By classHeaderPage = By.xpath("//table//tr/th[not(.//input[@type='checkbox'])]");
	private By classPaginatorPage = By.xpath("//button[@type='button']/../span[not(preceding-sibling::span)]");	
	private By classPageDeleteIcon = By.xpath("//button[contains(@class,'p-button-danger') and not(contains(@class,'p-button-rounded'))]");
	private By classPageTotalEntries = By.xpath("//div[@class='p-datatable-footer ng-star-inserted']");
	private By classAddNewClassBtn = By.xpath("//button[text()='Add New Class']");
	private By classPageAddPopUP = By.xpath("//div[contains(@class,'ng-trigger')]");
	private By classAddnewSavebtn = By .xpath("//span[text()='Save']");
	private By classCancelBtnPopup = By .xpath("//span[text()='Cancel']");
	private By classPageCloseBtn  = By.xpath("//button[contains(@class,'p-dialog-header-close')]");
	private By classPageInputFields = By.xpath("//input[@type='text']");
	private By classmngText = By.xpath("//div[normalize-space(text()) = 'Manage Class']");
	private By classLogoutbtn = By.xpath("//span[text()='Logout']");
    private By classBatchNamechkbox = By.xpath("//div[@class='p-checkbox-box']");
	private By  LoginBtn = By.xpath("//button[@id='login']");
	private By multiDelete = By.xpath("(//button[contains(@class,'p-button-danger')])[position()=1]");
	private By classconfirmIcon = By.xpath("(//button[contains(@class,'p-button-danger')])[2]");
	private By batcClassDropdown = By.xpath("//input[@placeholder='Select a Batch Name']");
	private By classTopic = By.id("classTopic");
	private By datePicker = By.id(("icon"));
	private By classnoDetails =By.id("classNo");
	
	private  By classstaffname =By.xpath("//input[@placeholder='Select a Staff Name']");
	private By classStatusActive=By.xpath ("//div[@class=\"p-radiobutton-box\"]");
	
	private By classCreateMsg = By.xpath("//div[contains(@class,'p-toast-message-content')]");
	private By classPickingdate= By.xpath ("//table[contains(@class,'p-datepicker-calendar')]//td//span[text()='31']");
	private By classLasteditbtn = By.xpath("(//span[@class='p-button-icon pi pi-pencil'])[last()]");
	private By classfirstEditBtn = By.xpath("(//button[@icon='pi pi-pencil'])[1]");
	private By classnewPopup = By .xpath("//*[contains(text(),'Class Details')]");
	private By classBatchNameDisable =By.xpath("//p-dropdown[@id='batchName']");
	private By classTopicField = By.xpath("//input[@id='classTopic']");
	private By classDescriptionField = By.xpath("//input[@id='classDescription']");
	private By saveBtnoneditPopUp = By.xpath("//span[text()='Save']");
	private By classAlertNobtn = By.xpath("//span[text()='No']");
	private By classEditIconCloseBtn = By.xpath("//button[contains(@class,'p-dialog-header-close')]");
	private By classLinkDashboardBtn =By.xpath("//div[@class='ng-star-inserted']/button[4]");
	private By classLinkClassPage = By.xpath("//button[contains(@class,'mat-focus-indicator')]/span[text()='Class']");
	private By classnextLink =By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By classnexttwoLink = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	
	//----------------to click on manage bt--------------
	
	private WebDriverWait wait;
	public void clickonClassPageLinkDb() {
		driver.findElement(classLinkDashboardBtn).click();
	}
	public void clickonClassPageLinkClassPG() {
		driver.findElement(classLinkClassPage).click();
	}
	
	public void clickondoubleNext() {
		WebElement nextPageButton = driver.findElement(classnexttwoLink);

	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", nextPageButton);

	   
	    nextPageButton.click();
	}
	public void clickNextLink() {
		WebElement nextPageButton1 = driver.findElement(classnextLink);


	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", nextPageButton1);

	   
	    nextPageButton1.click();
	}

	
	
	
	
	public TestClassPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void btnClass() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement manageBatchElement1  =  wait.until(ExpectedConditions.visibilityOfElementLocated(ClassBtn));

	    manageBatchElement1.click();
	    manageBatchElement1.click();
//		driver.switchTo().defaultContent();
	}
	
	public String mngBatchTxt() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
	    WebElement manageBatchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text()) = 'Manage Batch']")));    
	    
	    return manageBatchElement.getText();
	}
	public String mngClassTxt() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
	    WebElement manageBatchElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text()) = 'Manage Class']")));    
	    
	    return manageBatchElement1.getText();
	}
	
	
	
	public String getManageClassTitle() {
		return driver.findElement(classPageTitle).getText().trim(); 
		
	}
	
	public boolean classSearchbarField() {
		return driver.findElement(classSearchBar).isDisplayed();
		
	}
	
	
	public List<String> getActualClassColumnHeaders() {
	    
	    List<WebElement> headerElements = driver.findElements(classHeaderPage);

	    
	    return headerElements.stream()
	            .map(header -> header.getText().trim().toLowerCase())  
	            .collect(Collectors.toList());
	}
	public String getPaginatorText() {
		return driver.findElement(classPaginatorPage).getText();
	}
	public boolean isClassPaginatorTextVisibleOrNot() {
		return driver.findElement(classPaginatorPage).isDisplayed();
	}
	
	public boolean isSortIconPresentInHeadersClasspage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    List<WebElement> sortIcons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		        By.xpath("//i[contains(@class,'p-sortable-column-icon')]")
		    ));
		    return sortIcons.stream().allMatch(WebElement::isDisplayed);
		}
	public void getClickOnAddNewBtn() {
		WebElement addNewClassButton = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-item ng-tns-c230-7']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewClassButton);
	}
	
	public Boolean isClassPageDeleteIconIsDisplyed() {
		return driver.findElement(classPageDeleteIcon).isDisplayed();
	}
	public Boolean isClassPageTotalEntryIconIsDisplyed() {
		return driver.findElement(classPageTotalEntries).isDisplayed();
	}
	
	public WebElement getPopup() {
		return driver.findElement(classPageAddPopUP);
	}

	public WebElement getSaveButton() {
		return driver.findElement(classAddnewSavebtn);
	}

	public WebElement getCancelButton() {
		return driver.findElement(classCancelBtnPopup);
	}

	public WebElement getCloseButton() {
		return driver.findElement(classPageCloseBtn);
	}

	
	
	public boolean arePopupFieldsEmpty() {
	    List<WebElement> popupFields = driver.findElements(By.xpath("//input[@type='text']"));
	    for (WebElement field : popupFields) {
	        
	        if (!field.getDomProperty("value").isEmpty()) {
	            return false;
	        }
	    }
	    return true; 
	}
	public List<WebElement> getInputfields() {
		return driver.findElements(classPageInputFields);
	}
	
	public void clickonBatchLink() {
        WebElement batchButton = driver.findElement(By.xpath("//span[text()='Batch']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(batchButton).click().perform();
    }
	
	

	
	public void classClickOnlogoutBtn() {
	    WebElement logoutBtn = driver.findElement(By.xpath("//span[text()='Logout']"));
	    
	    
	    Actions actions = new Actions(driver);
	    actions.moveToElement(logoutBtn).click().perform();
	}
	
	public void waitForLoginButton() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login']")));
	}

	public Boolean classLoginBtnIsDisplayed() {
	    waitForLoginButton(); 
	    WebElement loginButton = driver.findElement(By.xpath("//button[@id='login']"));
	    return loginButton.isDisplayed();
	}
	public WebElement getSearchbar() {
		return driver.findElement(classSearchBar);
	}
	public int getSearchResultsCount() {
	    List<WebElement> results = driver.findElements(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")); 
	    return results.size();
	}
	public void getClickOnBatchNameCheckbox() {
	    WebElement checkbox = driver.findElement(classBatchNamechkbox);
	    	   
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	}

public boolean getisMultiDeleteEnabled() {

	return driver.findElement(multiDelete).isEnabled();
}
public void clickOndeleteBtn() {
	driver.findElement(classconfirmIcon).click();
	Alert alert = driver.switchTo().alert();
	alert.accept(); 

}
public void getCreateClass(String testCaseName) throws InterruptedException {
    Map<String, String> testData = classTestDataMap.get(testCaseName);  
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

    
    WebElement batchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select a Batch Name']")));
    batchInput.click();  

   
    WebElement batchOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//li[text()='" + testData.get("Batch Name") + "']")
    ));
    batchOption.click();  

    
    WebElement classTopicInput = wait.until(ExpectedConditions.elementToBeClickable(classTopic));
    classTopicInput.sendKeys(testData.get("Class Topic"));

 
    driver.findElement(datePicker).click(); // Open date picker
    driver.findElement(classPickingdate).click(); // Select a date


    WebElement staffNameInput = wait.until(ExpectedConditions.elementToBeClickable(classstaffname));
    staffNameInput.sendKeys(testData.get("Staff Name"));


    WebElement classStatusElement = wait.until(ExpectedConditions.elementToBeClickable(classStatusActive));
    classStatusElement.click(); // Mark as active

  
    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(classAddnewSavebtn));
    saveButton.click();
}

public void getClickOnFirstEditIcon() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	try { 
	   
	    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(classfirstEditBtn));	    
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	    System.out.println("Button clicked using JavaScript");

	} catch (Exception e) {
	    System.err.println("Error: " + e.getMessage());
	}

}


public boolean isClassDetailsHeadingPresent() {
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = driver.switchTo().alert();

	    String alertText = alert.getText();
	    System.out.println(alertText);

	    WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pr_id_32-label']")));
	    
	    
	    return element3.isDisplayed();
	}

	public Boolean verifyPopUpIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(classnewPopup));
		return driver.findElement(classnewPopup).isDisplayed();
				
		
	}
	
	public Boolean verifyBatchNamaeFieldIsDiosabled() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(classBatchNameDisable));
		return driver.findElement(classBatchNameDisable).isEnabled();
	}
	public Boolean verifyClassTopiceFieldIsDisabled() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(classTopicField));
		return driver.findElement(classTopicField).isEnabled();
	}
	public void updateEditopopup() {
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(classDescriptionField).sendKeys("Test");
				
				
}
	public void clickonSaveBtn() {
	    WebElement saveButton = driver.findElement(By.xpath("//span[text()='Save']"));

	  
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));

	    
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
	}
	public boolean isSuccessMessageDisplayed() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	    try {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'success-message')]"))).isDisplayed();
	    } catch (TimeoutException e) {
	        System.out.println("Success message not found within timeout.");
	        return false;
	    }
	}
	public void updateInvaliddataEditopopup() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(classDescriptionField).sendKeys("456$%");
			
}
	public boolean errorMsgDisplayed() {
		return false;
	}

	public boolean areErrorMessagesDisplayed() {
		
		return false;
	}
	public void classEditCloseIcon() {
		driver.findElement(classEditIconCloseBtn).click();
	}
	
}
    









