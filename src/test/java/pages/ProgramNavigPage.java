package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverFactory.DriverFactory;
import utils.Helper;

public class ProgramNavigPage {
	public WebDriver driver = DriverFactory.getdriver();
	By programBtn = By.xpath("//span[text()='Program']");
	By logoutBtb = By.xpath("//span[text()='Logout']");
	By ProgrampageHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	By pageNamesOrder = By.xpath("//div[@class='ng-star-inserted']");
	By prgmMenuButton = By.xpath("//*[@role='menuitem']");
	public ProgramNavigPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProgramButton() 
	{
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", driver.findElement(programBtn));
//		Helper.webElement_Click(driver.findElement(programBtn));
	Helper.ScrolltoElementandClick(driver, driver.findElement(programBtn), 20);
	}

	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}

	public Boolean checkLogoutBtn() {
		if(driver.findElement(logoutBtb).isDisplayed())
		return true;
		else
			return false;
	}
	public String getHeading() {
		return driver.findElement(ProgrampageHeading).getText();
	}

	public String getPageNamesOrder() {
		if (driver.findElement(pageNamesOrder).isDisplayed())
		  return driver.findElement(pageNamesOrder).getText(); 
		else return null;
	}
	
//	public List<String> getPageNamesOrder() {
//		List<String> actualOrder = new ArrayList<>();
//		for (int i = 0; i < driver.findElements(pageNamesOrder).size() - 1; i++) {
//			actualOrder.add(driver.findElements(pageNamesOrder).get(i).getText());
//		}
//		return actualOrder;
//	}

//	public void validateModuleNames(String expectedOrder) {
//
//		List<String> actualOrder = new ArrayList<>();
//
//		for (int i = 0; i < headers.size() - 1; i++) {
//			actualOrder.add(headers.get(i).getText());
//		}
//
//		String[] expectedOrderArray = expectedOrder.split(" ");
//		assertEquals(Arrays.asList(expectedOrderArray), actualOrder);
//
//	}
	public String getSubMenu() {
		if (driver.findElement(prgmMenuButton).isDisplayed())
			return driver.findElement(prgmMenuButton).getText();
		else
			return null;
	}
	public String validatePagenamesinOrder(String buttonIcon,String order) 
	{
		WebElement  PageName = driver.findElement(By.xpath("//span[text()='"+buttonIcon+"']"));
		System.out.println("PageName: "+PageName.getText());
		return PageName.getText();
	}
}
