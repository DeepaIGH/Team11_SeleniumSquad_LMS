package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import utils.ConfigReader;

public class TestLoginPage {
	public WebDriver driver = DriverFactory.getdriver();
	By UserName = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By role=By.xpath("//div[@id='mat-select-value-1']/span");
	By adminrole=By.xpath("//mat-option/span[text()=' Admin ']");
	By Login = By.xpath("//button[@id='login']");
	By dashboard=By.xpath("//div[@class='box']");
	
	public TestLoginPage() {
		this.driver = driver;
	}
	public void loginUsingValues(String username,String password) {
	//driver.findElement(UserName).clear();
		driver.get(ConfigReader.getHomePageUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(UserName).sendKeys(username);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(Password).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(role).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(adminrole).click();
	}
	
	public void clickLoginBtn() {
		driver.findElement(Login).click();
	}
	public void getHomepageurl() {
		//driver.findElement(dashboard).)
	}
}
