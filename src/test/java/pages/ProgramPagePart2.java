package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverFactory.DriverFactory;

public class ProgramPagePart2 extends BasePage{
	public WebDriver driver = DriverFactory.getdriver();

	public By programlink= By.cssSelector("button#program");
	public By programPageTitle = By.cssSelector("mat-card-title div.box:nth-child(1)");
	public By searchBox = By.cssSelector("input#filterGlobal");
	public By multiDeleteButton = By.cssSelector(".mat-card-title .p-button-danger");
	public By deleteButtons=By.cssSelector("#deleteProgram");
	public By checkBoxes=By.cssSelector("td div.p-checkbox-box");
	public By selectedCheckBoxes = By.cssSelector(".p-checkbox-box[aria-checked=\"true\"]");
	public By programTableRows=By.cssSelector((".p-datatable-tbody tr"));
	public By confirmationDialogBox= By.cssSelector("div.p-confirm-dialog");
	public By dialogBoxTitle = By.cssSelector("span.p-dialog-title ");
	public By dialogBoxclose = By.cssSelector("div.p-dialog-header-icons");
	public By deleteModelInfoIcon=By.cssSelector("i.pi-exclamation-triangle");
	public By dialogwarningMessage = By.cssSelector("span.p-confirm-dialog-message");
	public By dialogBoxNoButton=By.cssSelector("button.p-confirm-dialog-reject");
	public By dialogBoxYesButton= By.cssSelector("button.p-confirm-dialog-accept");
	public By firstPageButton=By.cssSelector(".p-paginator-first");
	public By prevPageButton=By.cssSelector(".p-paginator-prev");
	public By nextPageButton = By.cssSelector("button.p-paginator-next");
	public By lastPageButton=By.cssSelector("button.p-paginator-last");
	public By totalNumberOfPrograms = By.cssSelector("div.p-d-flex");
	public By currentDisplayedCount = By.cssSelector(".p-paginator-current");
	public By programNameHeader =By.cssSelector("th[psortablecolumn='programName']");
	public By programDescriptionHeader=By.cssSelector("th[psortablecolumn='programDescription']");
	public By programStatusHeader=By.cssSelector("th[psortablecolumn='programStatus']");
	public By successAlert=By.cssSelector( "div.p-toast");
	public By programNameCells=By.cssSelector("tr td:nth-child(2)");
	public By programDescriptionCells=By.cssSelector("tr td:nth-child(3)");
	public By programStatusCells=By.cssSelector("tr td:nth-child(4)");
	public By ProgramNameHeaderIcon=By.cssSelector("th[psortablecolumn='programName'] i.p-sortable-column-icon");
	public By programDescriptionHeaderIcon=By.cssSelector(("th[psortablecolumn='programDescription'] i.pi-sort-alt"));	
	public By programStatusHeaderIcon=By.cssSelector("th[psortablecolumn='programStatus']  i.p-sortable-column-icon");
	public By overlayBackdrop=By.cssSelector(".cdk-overlay-backdrop");
	public By addNewProgramButton=By.cssSelector(".mat-menu-panel button");
	public By programNameInput=By.cssSelector("input#programName");
	public By programDescriptionInput=By.cssSelector("input#programDescription");
	public By statusRadioButtons=By.cssSelector(".radio p-radiobutton");
	public By saveProgramButton=By.cssSelector("button#saveProgram");
	public By toastCloseIcon=By.cssSelector(".p-toast-icon-close-icon");
	public By pageNumberButtons=By.cssSelector("button.p-paginator-page");
	public By activePageNumberButton=By.cssSelector("button.p-paginator-page.p-highlight");
	public By editProgramButton=By.cssSelector("#editProgram");
	public By editProgramDialog=By.cssSelector("div.p-dialog");
	public By programEditNameField=By.cssSelector("input#programName");
	public By programEditDescriptionField=By.cssSelector("input#programDescription");
	public By editRadioButtons=By.cssSelector(".radio p-radiobutton");
	public By saveButtonOnEditDialog=By.cssSelector("button#saveProgram");
	public By cancelButtononEditDialog=By.cssSelector("button[label=\"Cancel\"]");
	public By astrickForNameField=By.cssSelector("label[for=\"programName\"] span");
	public By astrickForDescriptionField=By.cssSelector("label[for=\"programDescription\"] span");
	public By astrickForStatusField=By.cssSelector("label[for=\"online\"] span");

	public void clickOnProgramPageLink() {
		waitForElementToBeVisible(driver, programlink);
		driver.findElement(programlink).click();
		driver.findElement(overlayBackdrop).click();
	}

	public void createProgram(String programName) {
		waitForElementToBeVisible(driver, programlink);
		driver.findElement(programlink).click();
		WebElement element = driver.findElement(addNewProgramButton);
		// Use JavaScript to click on the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		driver.findElement(programNameInput).sendKeys(programName);
		driver.findElement(programDescriptionInput).sendKeys(programName+" description");
		driver.findElements(statusRadioButtons).get(0).click();
		driver.findElement(saveProgramButton).click();
	}

	public void adminIsOnProgramPage()  {
		driver.findElement(programPageTitle ).isDisplayed();
	}

	public void searchProgram(String programName) {
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(programName);
	}

	public void clickOncheckBoxes(Integer numberOfCheckBoxes) throws InterruptedException {
		for (int i = 0; i < numberOfCheckBoxes; i++) {
			Thread.sleep(1000);
			driver.findElements(checkBoxes).get(i).click();
		}
	}

	public boolean areMultipleProgramsSelected() {
		if(driver.findElements(selectedCheckBoxes).size() > 1) {
			return true;
		}
		else {
			return false;
		}
	}


	public void clickElement(By locator) {
		waitForElementToBeVisible(driver, locator);
		waitForElementNotVisible(driver, overlayBackdrop, 30);
		driver.findElement(locator).click();
	}

	public void clickElementByPosition(By locator, Integer position) {
		waitForElementToBeVisible(driver, locator);
		waitForElementNotVisible(driver, overlayBackdrop, 30);
		driver.findElements(locator).get(position-1).click();
	}

	// Method to get the page title
	public String getTextForElement(WebElement element) {
		return element.getText();  // Return text from the given element
	}

	public void adminIsOncheckBoxes()  {
		driver.findElement(checkBoxes).isSelected();
	}

	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

	public String getCurrentUrl() {
		String elementText = driver.getCurrentUrl();
		return elementText;
	}

	public String getPageTitle() {
		String elementText = driver.getTitle();
		return elementText;
	}

	public Boolean validateElementDisplayed(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed(); // Returns true if element is not displayed
		} catch (NoSuchElementException e) {
			// If element is not found on the page
			return false; // Element is not displayed since it's not found
		}	
	}

	public String getAttributeForElement(By locator, String attributeName) {
		String attributeValue = driver.findElement(locator).getAttribute(attributeName);
		return attributeValue;
	}

	public static String getRandomString(Integer noOfChars) {
		// Define the characters that can be used in the random string
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		// Create a Random object
		Random random = new Random();

		// StringBuilder to store the random string
		StringBuilder randomString = new StringBuilder(5);

		// Generate a random string of 5 characters
		for (int i = 0; i < noOfChars; i++) {
			// Get a random index from the characters string
			int index = random.nextInt(characters.length());
			// Append the character at the random index
			randomString.append(characters.charAt(index));
		}
		return randomString.toString();
	}

	public String getLastPageNumber() {
		String displayedCountText = driver.findElement(currentDisplayedCount).getText();
		Integer totalNumberOfPrograms = Integer.parseInt(displayedCountText.split(" ")[5]);
		double result = (double) totalNumberOfPrograms / 10;
		return Integer.toString((int) Math.ceil(result));
	}

	public void updateProgramName(String programName) {
		driver.findElement(programEditDescriptionField).clear();
		driver.findElement(programEditDescriptionField).sendKeys(programName+" description updated");
		driver.findElement(saveProgramButton).click();
	}

	public void updateProgramDescription(String programName) {
		driver.findElement(programEditNameField).clear();
		driver.findElement(programEditNameField).sendKeys(programName + " updated");
		driver.findElement(saveProgramButton).click();
	}
}