package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.ExcelReader;
import utils.Helper;

public class AddNewProgramPage {
	WebDriver driver;
	By addNewProgramBtn = By.xpath("//button[@role='menuitem']");
	By popupwindow = By.xpath("//div[@role='dialog']");
	By ProgramwindowTitle = By.xpath("//span[text()='Program Details']");
	By mandFieldsAsterik = By.xpath("//span[text()='*']");
	By fieldRequiredMsg = By.xpath("//small[@class='p-invalid ng-star-inserted']");
	
	By saveBtn = By.xpath("//span[text()='Save']");
	By cancelBtn = By.xpath("//span[text()='Cancel']");
	By closeBtn = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c81-9 pi pi-times']");


	By progNameTxtBox = By.xpath("//input[@id='programName']");
	By progDescTxtBox = By.xpath("//input[@id='programDescription']");
	By radioactiveBtn = By.xpath("//p-radiobutton[@id='category']]");

	String Excelpath = ConfigReader.getExcelFilePath();
	ExcelReader excel = new ExcelReader();

	public AddNewProgramPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickaddNewBtn() {
		Helper.ScrolltoElementandClick(driver,driver.findElement(addNewProgramBtn),20);
	}
	public Boolean isPopupWndwDisplayed()
	{
		return driver.findElement(popupwindow).isDisplayed();
		
	}
	public String getWindowTitle() 
	{
		return driver.findElement(ProgramwindowTitle).getText();
	}
	
	public Boolean validateAsterikMark() 
	{
		int TotAstrieksSize = driver.findElements(mandFieldsAsterik).size();
		try {

			for (int i = 0; i < TotAstrieksSize; i++) {
				if (driver.findElements(mandFieldsAsterik).get(i).isDisplayed())
					return true;
			}
		} 
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public void clickSaveBtn() 
	{
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", driver.findElement(saveBtn));
//		Helper.webElement_Click(driver.findElement(saveBtn));
		Helper.ScrolltoElementandClick(driver, driver.findElement(saveBtn), 20);
	}
	public Boolean validateFieldsRequired()
	{
		int TotFieldsSize = driver.findElements(fieldRequiredMsg).size();
		try {

			for (int i = 0; i < TotFieldsSize; i++) {
				if (driver.findElements(fieldRequiredMsg).get(i).isDisplayed())
					return true;
			}
		} 
		catch (Exception e) {
			return false;
		}
		return false;
	}
	public void clickCancelBtn() {
		if(driver.findElement(popupwindow).isDisplayed())
		{
			System.out.println("popup window Is displayed.....");
		Helper.ScrolltoElementandClick(driver,driver.findElement(cancelBtn),20);
		}
		else
			System.out.println("popup window Is not displayed.....");

	}
	public void enterNameinTxtBox() throws Exception
	{
		Helper.webSendKeys(driver.findElement(progNameTxtBox),"program1");
	}
	public Boolean verifyEnteredPrgmName() throws Exception {
		Boolean result = Boolean.FALSE;
	    if (driver.findElement(popupwindow).isDisplayed()) {
	    	String pgmNameInputBoxValue = driver.findElement(progNameTxtBox).getAttribute("value");
	    	System.out.println("pgmNameInputBoxValue:"+pgmNameInputBoxValue);
	    	//String pgmDescInputBoxValue = driver.findElement(progDescTxtBox).getAttribute("value");
	    	if (!pgmNameInputBoxValue.isEmpty()) 
	    	{
	    		result = Boolean.TRUE;
	    	}
		}
	    return result;
	}
	public void enterDescipinTxtBox() throws Exception
	{
		Helper.webSendKeys(driver.findElement(progDescTxtBox),"Selenium");
	}
	public Boolean verifyEnteredDescripName() throws Exception {
		Boolean result = Boolean.FALSE;
	    if (driver.findElement(popupwindow).isDisplayed()) {
	    	String pgmDescInputBoxValue = driver.findElement(progDescTxtBox).getAttribute("value");
	    	System.out.println("pgmDescInputBoxValue:"+pgmDescInputBoxValue);

	    	if (!pgmDescInputBoxValue.isEmpty()) 
	    	{
	    		result = Boolean.TRUE;
	    	}
		}
	    return result;
	}
	public void clickCloseBtn() {
		if(driver.findElement(popupwindow).isDisplayed())
		{
			System.out.println("popup window Is displayed.....");
		Helper.ScrolltoElementandClick(driver,driver.findElement(closeBtn),20);
		}
		else 
			System.out.println("popup window Is not displayed.....");
	}
	public Boolean selectRadioBtnStatus(String radioBtn) 
	{
	int TotRadioBtnsSize = driver.findElements(radioactiveBtn).size();
	try {

		for (int i = 0; i < TotRadioBtnsSize; i++) {
			//if (driver.findElements(fieldRequiredMsg).get(i).isDisplayed())
			Helper.selectRadioButtonValue(driver.findElements(radioactiveBtn).get(i), radioBtn);
				return true;
		}
	}
		catch (Exception e) {
			return false;
		}
		return false;
		
	}
	public void enterProgramDetails(String sheetname, Integer rownumber) throws Exception {
		List<Map<String, String>> testdata = excel.getData(Excelpath, sheetname);
		String programName=testdata.get(rownumber).get("Name");
		System.out.println("programName:"+programName);
		String Desc = testdata.get(rownumber).get("Description");
		System.out.println("Description:"+Desc);
		
		Helper.webSendKeys(driver.findElement(progNameTxtBox), programName);
		Helper.webSendKeys(driver.findElement(progDescTxtBox), Desc);
		clickSaveBtn() ;
	}
}
