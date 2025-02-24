package pages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import driverFactory.DriverFactory;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage {
	WebDriver driver = DriverFactory.getdriver();
	By loginMsg=By.xpath("//p[text()='Please login to LMS application']");
	By LMSLoginMsg=By.xpath("//p");
	By UserName = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By role=By.xpath("//div[@id='mat-select-value-1']/span");
	By adminrole=By.xpath("//mat-option/span[text()=' Admin ']");
	By Login = By.xpath("//button[@id='login']");
	By dashboard=By.xpath("//div[@class='box']");
	By userLabel=By.xpath("//label[@id='mat-form-field-label-1']/span[1]");
	By passwordLabel=By.xpath("//label[@id='mat-form-field-label-3']/span[1]");
	By logo=By.xpath("//*[@src='assets/img/LMS-logo.jpg']");
	By userAsterisk=By.xpath("//label[@id='mat-form-field-label-1']/span[2]");
	By passwordAsterisk=By.xpath("//label[@id='mat-form-field-label-3']/span[2]");
	By dropdownOptions=By.className("mat-option-text");
	public String invalideURL="https://1234hackathon-bbfd38d67ea9.herokuapp.com";
	By dashboardMSG=By.className("box");
//	public static final String userName = "sdetnumpyninja@gmail.com";
//	public static final String password = "Feb@2025";

	By userErrorMsg=By.xpath("//mat-error[@id='mat-error-0']");
	By passwordErrorMsg=By.xpath("//mat-error[@id='mat-error-1']");
	
	public static final String invalidUserName = "testAdmin@gmail.com";
	public static final String invalidPassword = "admin@02";

//----------------------------------------------------------------------------------------------------------------------------	
	
	//To check whether browser is open or not.
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	 public boolean isBrowserOpen(WebDriver driver) {
	        try {
	            return !driver.getWindowHandles().isEmpty();
	        } catch (Exception e) {
	            return false;
	        }
	 }
	 
	 //entering the correct LMS portal URL
	 public void enterCorrect_LMS_url() {
		driver.get(ConfigReader.getHomePageUrl());
	 }

	 //Check the Login page.
	 public boolean checkLoginPage() {
		 return driver.findElement(loginMsg).isDisplayed();
	 }
	 
	 //entering invalid URL
	 public void enter_Invalid_URL() {
		 System.out.println("Invalid URL: "+invalideURL);
		 driver.get(invalideURL);
	 }
	 
	 public String getInvalid_URL() {
		 return invalideURL;
	 }
	 
	 
	 //Check application error
	 public boolean checkApplicationError(String url) {
		 driver.get(url);
		 if(driver.getTitle().contains("Heroku | Application Error")) {
			 System.out.println("Page title: "+driver.getTitle());
			 return true;
		 }
		 else
			 return false;
	 }
	 public int checkResponseCode(String URL_address) throws IOException {
		 int ResponseCode; 
		        @SuppressWarnings("deprecation")
				URL url = new URL(URL_address);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		        connection.setRequestMethod("GET");
		        connection.connect();
		        ResponseCode= connection.getResponseCode();
		        return ResponseCode;
		    }

	 public boolean checkTextSpelling() {
		 String userText=driver.findElement(userLabel).getText();
		 String passwordText=driver.findElement(passwordLabel).getText();
		 String roleText=driver.findElement(role).getText();
		 System.out.println("Spellings: "+userText+"  "+passwordText+"  "+roleText);
		 if(userText.equalsIgnoreCase("User") && 
				 passwordText.equalsIgnoreCase("Password") &&
				 roleText.equalsIgnoreCase("Select the role")){
			 return true;
		 }
		 else
			 return false;
	 }
	 
	 public boolean isLMSLogoDisplayed() {
			return driver.findElement(logo).isDisplayed();
		}
	 
	 public boolean companyNameOnLogo() throws IOException,TesseractException {
		 URL url=null;
		 @SuppressWarnings("deprecation")
		String imageURL=driver.findElement(logo). getAttribute("src");
		 try {
			 url=new URL(imageURL);
			 System.out.println("Image URL: "+imageURL);
		 }
		 catch(MalformedURLException e) {
			 System.out.println("System Error: "+e.getMessage());
		 }
		 //create a buffered image from the imageURL
		 BufferedImage image1=ImageIO.read(url);
		 
		 //Initializes Tesseract instance
		 Tesseract tesseract=new Tesseract();
		 
		 //set dataPath and language
		 tesseract.setDatapath("./tessdata");
		 tesseract.setLanguage("eng");
		 
		 //// Extract text using Tesseract OCR
		 String extractedText = tesseract.doOCR(image1);
         System.out.println("Extracted Text: " + extractedText);
         
         if(extractedText.contains("NumpyNinja")) {
        	 return true;
         }
         else
        	 return false;
	 }

	 public String isLMS_LoginMsg_Displayed() {
		 if(driver.findElement(loginMsg).isDisplayed()) {
		String loginMsg= driver.findElement(LMSLoginMsg).getText();
		return loginMsg;
		 }
		 else
			 return "LMS Login not displayed!";
	 }
	 
	 public boolean isTextFieldsVisible() {
			return (driver.findElement(UserName).isDisplayed() && driver.findElement(Password).isDisplayed());
		}

	 public String isUserLabelDisplayed() {
		 if(driver.findElement(userLabel).isDisplayed()) {
			return driver.findElement(userLabel).getText();
			}
		 else 
			 return "User field not displayed!";
		}

	 public boolean isDropdownDisplayed() {
		 return driver.findElement(role).isDisplayed();
		}
	 
	 public boolean isMandatoryFieldAsterikVisible() {
		 return driver.findElement(userAsterisk).isDisplayed() && driver.findElement(passwordAsterisk).isDisplayed();
	 }
	 
	 public boolean isPasswordLabelDisplayed() {
			return driver.findElement(passwordLabel).isDisplayed();
		}
		
	 public boolean isPasswordAsterickVisible() {
			return driver.findElement(passwordAsterisk).isDisplayed();
		}
	 
	 public String checkRolePlaceholder() {
		 return driver.findElement(role).getText();
	 }

	 public List<String> check_dropdownOptions() {
		 driver.findElement(role).click();// Click to open the dropdown (if it's hidden)
		 // Locate all dropdown options (span elements)
         List<WebElement> options = driver.findElements(dropdownOptions);
         
      // Extract the text of each option
         List<String> actualOptions = new ArrayList<>();
         for (WebElement option : options) {
             actualOptions.add(option.getText().trim());
         }
		 return actualOptions;
	 }
	 
	 public boolean checkPosition() {
		 int user_X=driver.findElement(UserName).getLocation().getX();
		 int password_X=driver.findElement(Password).getLocation().getX();
		 int role_X=driver.findElement(role).getLocation().getX();
		 System.out.println("User X-co-ordinator: "+user_X);
		 System.out.println("Password X-co-ordinator: "+password_X);
		 System.out.println("Role X-co-ordinator: "+role_X);
		 if(user_X==password_X && user_X==role_X) {
			 return true;
		 }
		 else
			 return false;
	 }
	public boolean isLoginButtonDisplayed() {
		return driver.findElement(Login).isDisplayed();
	}
		
	public String getUserFontColor() {
		return driver.findElement(userLabel).getCssValue("color");
	}
	
	public String getPasswordFontColor() {
		return driver.findElement(passwordLabel).getCssValue("color");
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
	
	public void invalid_dataInputs() {
		driver.findElement(UserName).sendKeys("abcd@gmail.com");
		driver.findElement(Password).sendKeys("xyz");
		driver.findElement(role).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(adminrole));
		driver.findElement(adminrole).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
		driver.findElement(Login).click();
		}
			
	public boolean isErrorUserNameDisplayed() {
		return driver.findElement(userErrorMsg).isDisplayed();
	}
	
	public boolean isErroPasswordDisplayed() {
		return driver.findElement(passwordErrorMsg).isDisplayed();
	}
	
	public void enterLoginBtn_keyboad() {
		driver.findElement(Login).sendKeys(Keys.ENTER);
	}
	

}//end of LogiPage class
