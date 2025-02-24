package pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return waitForElementToBeVisible(driver, locator, 30);  // Default timeout 30 seconds
    }
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
        try {
            // Wait for the element to be visible
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Element not visible after " + timeoutInSeconds + " seconds: " + e.getMessage());
            return null;
        }
    }

	public void waitForElementNotVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            System.out.println("Element is no longer visible.");
        } catch (Exception e) {
            System.out.println("Element still visible after " + timeoutInSeconds + " seconds.");
        }
    }
}
