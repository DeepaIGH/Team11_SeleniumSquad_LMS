package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utils.ConfigReader;

public class LogoutPage {
	WebDriver driver = DriverFactory.getdriver();
	HomePage home=new HomePage(DriverFactory.getdriver());
	By LMSTitle=By.xpath("//mat-toolbar/span[1]");
	By loginMsg=By.xpath("//p[text()='Please login to LMS application']");
	By logoutBtn=By.id("logout");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean checkLogin() {
		driver.get(ConfigReader.getHomePageUrl());
		home.enterUserName();
	    home.enterPassword();
	    home.enterRole();
	    home.loginButtonClicked();
	    driver = DriverFactory.getdriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(LMSTitle));
		System.out.println("Title: "+title.getText());
		return title.isDisplayed();
	}
	
	public boolean checkHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(LMSTitle));
		System.out.println("Title: "+title.getText());
		return title.isDisplayed();
	}
	
	public void clickLogoutBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
		logout.click();
	}
	 //Check the Login page.
	 public boolean checkLoginPage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(loginMsg));
		 return title.isDisplayed();
	 }
	 
	 public void getBackButton() {
			driver.navigate().back();
		}
	
}
