package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	public static Properties property;
	public static WebDriver driver;
	
	static Logger logger = Logger.getLogger(CommonFunctions.class);//Factory design pattern
	
	public Properties loadPropertyFile() throws IOException {
		//property file should load & return
		FileInputStream fileInput = new FileInputStream("config.properties");
		property = new Properties();
		property.load(fileInput);
		return property;
	}
	
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test Begins");
		logger.info("Loading property file");
		loadPropertyFile();
		String browserName = property.getProperty("browser");
		String urlValue = property.getProperty("url");
		String chromeDriver = property.getProperty("chromeDriverLocation");
		String firefoxDriver = property.getProperty("firefoxDriverLocation");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			logger.info("Launching chrome");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver", firefoxDriver);
			logger.info("Launching firefox");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		logger.info("Navigating to application");
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void closeBrowser() {
		logger.info("Execution done.Closing the browser");
		driver.quit();
	}
}
