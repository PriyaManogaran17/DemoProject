package phpTravelsLogin;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjectModel.PageModel;

public class LoginCheck {

	@Test
	public static void loginCheck() throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");

		PageFactory.initElements(driver, PageModel.class);
		PageModel.userName.sendKeys("user@phptravels.com");
		PageModel.userPassword.sendKeys("demouser");
		PageModel.submitButton.click();
		
		
		/*
		 * PageModel.userName(driver).sendKeys("user@phptravels.com");
		 * PageModel.userPassword(driver).sendKeys("demouser");
		 * PageModel.submitButton(driver).click();
		 */
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Unpaid']")));
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("D:\\Screenshot\\sample.png");
		FileHandler.copy(sourceFile, destinationFile);
		driver.quit();

		
	}
}
