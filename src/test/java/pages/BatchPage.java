package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

import driverFactory.DriverFactory;
import utils.LoggerLoad;
import org.testng.Assert;


public class BatchPage {
	public WebDriver driver = DriverFactory.getdriver();

	public BatchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators 	
		
	    By batchButton = By.xpath("//span[text()='Batch']");
	    By addNewBatch = By.xpath("//button[text()='Add New Batch']");
		By LMSlogo = By.xpath("//span[text()=' LMS - Learning Management System ']");
		By manageBatch = By.xpath("//div[text()=' Manage Batch']");
		By disabledDeleteButton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
		By datatableCheckbox = By.xpath("//th[text()='Batch Name ']/preceding::div[@class='p-checkbox-box']");
		By searchButton = By.id("\"filterGlobal\"");
		By searchSpan = By.xpath("//div[text()=' Manage Batch']/following::div[3]");	
		By editBatch = By.xpath("//button[@ng-reflect-icon = 'pi pi-pencil']");
		By batchDetails = By.xpath("//span[text() = 'Batch Details']");
		By ProgramNamefield = By.id("\"programName\"");
		By ProgramNameDropdown = By.xpath("//label[text()='Program Name ']/following::span[1]");
		By ProgramNameInput = By.xpath("//label[text()='Program Name ']/following::input[1]");
		By noOfClassesInput = By.id("batchNoOfClasses");
		By Status = By.xpath("//lable[text()='Status : ']");
		By descriptionHeader = By.xpath("//label[text()='Description ']");
		By batchDescription = By.xpath("//input[@id='batchDescription']");
		By activeStatus_ = By.xpath("//input[@id ='ACTIVE']");
		By selectStatus = By.xpath("//p-radiobutton[@id='batchStatus']");
		By batchNameSuffix = By.xpath("//input[@id='batchName'][1]");
		By saveButton = By.xpath("//span[text()='Save']");
		By editsaveButton = By.xpath("//button[@ng-reflect-label='Save']");
		By closeButton = By.xpath("//span[text() ='Batch Details']/following::button[1]");
		By cancelButton = By.xpath("//span[text()='Cancel']");
		By firstProgramNameOption = By.xpath("//label[text()='Program Name ']/following::li[1]");
		By secondProgramNameOption = By.xpath("//label[text()='Program Name ']/following::li[2]");
		By batchNamePrefix = By.xpath("//input[id='batchProg']");
		By batchdescerrormsg = By.xpath("//label[text()='Description ']/following::small[1]");
		By batchNameInput = By.xpath("//label[text()='Description ']/preceding::input[@id='batchName'][1]");
		By errorMessageforBatchnumber = By.xpath("//small[text()='This field accept only numbers and max 5 count. ']");
		By mandatemessage = By.xpath("//small[text()='Status is required.']");
		By editedfield = By.xpath("//td[text()='batch']");
		By allcheckBoxes = By.xpath("//span[@class='p-checkbox-icon']");
		By deleteButtons = By.xpath("//button[@ng-reflect-icon='pi pi-trash']");
		By editsuccessfulmsg = By.xpath("//div[text()='Successful']");
		
		
		// ---Methods to interact with the page----

		// Scenario Verify sub menu displayed in batch menu bar
		public void checkaddNewBatch() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			driver.findElement(batchButton).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			driver.findElement(manageBatch).isDisplayed();
			
		}

		// Page Navigation methods
		public void checkLogoOnBatchPage() {
			/*if (driver.findElement(manageBatch).isDisplayed()) {
				 LoggerLoad.info("Landed on Batch Page");*/
			
			/*if (driver.findElement(batchButton).click()) {
				 LoggerLoad.info("LMS logo is visible");
			}*/
		}
		
		public void checkDisabledDeleteIcon() {
		//	driver.findElement(manageBatch).click();
			//driver.findElement(disabledDeleteButton).getAttribute("disabled");
			
		}
		
		public boolean checkEditButtonsonPage() {
			List<WebElement> editbuttons = driver.findElements(By.xpath("//button[@ng-reflect-icon ='pi pi-pencil']"));
			return !editbuttons.isEmpty();
		}
		
		public boolean checkDeleteButtonsonPage() {
			List<WebElement> deletebuttons = driver.findElements(By.xpath("//button[@ng-reflect-icon='pi pi-trash']"));
			return !deletebuttons.isEmpty();
		}
		
		public boolean checkboxesonPage() {
			List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@class='p-checkbox-icon']"));
			return !checkboxes.isEmpty();
		}
		
		public void checkboxDatatable() {
			//driver.findElement(manageBatch).click();
		//	datatableCheckbox.isDisplayed();
		}
		
		
}
