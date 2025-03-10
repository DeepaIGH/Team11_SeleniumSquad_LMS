package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public static String getBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException("Browser is  not specified in the Configuration.properties file.");
	}
	public static String getExcelFilePath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}

	// HomePage URL
	public static String getHomePageUrl() {
		String homePageurl = prop.getProperty("loginURL");
		if (homePageurl != null)
			return homePageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}
	public static String getDashboardPageUrl() {
		String dashboardPageURL = prop.getProperty("homepageURL");
		if (dashboardPageURL != null)
			return dashboardPageURL;
		else
			throw new RuntimeException("dashboardPageURL not specified in the Config.properties file");
	}
	public static String getManageProgramUrl() {
		String manageProgramURL = prop.getProperty("manageProgramURL");
		if (manageProgramURL != null)
			return manageProgramURL;
		else
			throw new RuntimeException("manageProgramURL not specified in the Config.properties file");
	}
	public static String getBatchUrl() {
		String manageBatchURL = prop.getProperty("batchURL");
		if (manageBatchURL != null)
			return manageBatchURL;
		else
			throw new RuntimeException("manageBatchURL not specified in the Config.properties file");
	}
	public static String getUserUrl() {
		String manageUserURL = prop.getProperty("userURL");
		if (manageUserURL != null)
			return manageUserURL;
		else
			throw new RuntimeException("manageUserURL not specified in the Config.properties file");
	}
	// ManageUserPage URL


	public static String getManageUserPage() {
		String userPageurl = prop.getProperty("userURL");
		if (userPageurl != null)
			return userPageurl;
		else
			throw new RuntimeException("userPageurl not specified in the Config.properties file");
	}
	
	public static String getUsername() {
		String username = prop.getProperty("user");
		if (username != null)
			return username;
		else
			throw new RuntimeException("username not specified in the Config.properties file");
	}
	
	public static String getPassword() {
		String password = prop.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Config.properties file");
	}
}

