package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.LoggerLoad;

public class ProgramPageValidation {
	WebDriver driver;
	By managePrgmHeader = By.xpath("//div[text()=' Manage Program']");
	By columnHeader = By.xpath("//*[contains(@class, 'p-datatable-thead')]");
	By deleteBtn = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By searchBar = By.xpath("//input[@id='filterGlobal']");
	By chechBox = By.xpath("//div[@class='p-checkbox-box']");
	By sorticons = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	By editDeleteIcons = By.xpath("//div[@class='action']");
	By programFooter = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	By programPaginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By previousPageBtn = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	By nextPageBtn = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By firstPageBtn =By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");
	By lastPageBtn = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	public ProgramPageValidation(WebDriver driver) {
		this.driver = driver;
	}
	public String getheading() {
		if (driver.findElement(managePrgmHeader).isDisplayed())
			return driver.findElement(managePrgmHeader).getText();
		else
		return null;
	}
	public Boolean ValidateDeleteBtn() 
	{
		if (!driver.findElement(deleteBtn).isEnabled()&& driver.findElement(deleteBtn).isDisplayed())
			return true;
		else return false;
	}
	public String validateColHeadernamesinOrder(String colHeader, String position) {
		WebElement  colHeaderName = driver.findElement(By.xpath("//table//tr//th["+position+"]"));
		//System.out.println("colHeaderName:"+colHeaderName.getText());
		return colHeaderName.getText();
	}
	public String validateSearchBar() {
		//if(driver.findElement(searchBar).isDisplayed()&& driver.findElement(searchBar).isEnabled()) ;
		return driver.findElement(searchBar).getAttribute("value");
	}
	public Boolean validateCheckBox() {
		if(!driver.findElement(chechBox).isSelected())
			return true;
		else return false;
	}
	public boolean validateSortIcons() {
		int iconsize = driver.findElements(sorticons).size();
		try {

			for (int i = 0; i < iconsize; i++) {
				if (driver.findElements(sorticons).get(i).isDisplayed())
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	public boolean validateEditDelIcons() {
		int EditDelIconsize = driver.findElements(editDeleteIcons).size();
		try {

			for (int i = 0; i < EditDelIconsize; i++) {
				if (driver.findElements(editDeleteIcons).get(i).isDisplayed())
					return true;
			}
		} 
		catch (Exception e) {
			return false;
		}
		return false;
	}
	public String getTotalProgramCountFromFooter() {
		String footerText = driver.findElement(programFooter).getText();
		 System.out.println("footerText: "+footerText);
		// In total there are 49 programs
		String totalProgramCount = footerText.trim().substring(19, footerText.length() - 9);
		 System.out.println("totalProgramCount: "+totalProgramCount);
		return footerText;
	}
	public void validatePaginationTextandIcons() throws InterruptedException {
		String expectedText = "";
//
//		Thread.sleep(1000);
		boolean areIconsPresent = driver.findElement(previousPageBtn).isDisplayed() && driver.findElement(nextPageBtn).isDisplayed()
				&& driver.findElement(firstPageBtn).isDisplayed() && driver.findElement(lastPageBtn).isDisplayed();
		try {
			if (areIconsPresent) {
				String textValidation = driver.findElement(programPaginator).getText();
				System.out.println("textValidation:"+textValidation);
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(textValidation);
				List<Integer> numericValues = new ArrayList<Integer>();
				while (matcher.find()) {
					int numericValue;
					numericValue = Integer.parseInt(matcher.group());
					numericValues.add(numericValue);
				}
				expectedText = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
						numericValues.get(2));
				// log.info(text);
				System.out.println("text:"+expectedText);
				Assert.assertEquals(textValidation,expectedText);
			}
		} catch (Exception e) {
			 LoggerLoad.error("Pagination Icons are not displayed" + e);
		}
	}
	
}
