package loginCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginUsingApachePOI {

	public void loginCheck() {
		
	}
	
	public void usingPOI() throws FileNotFoundException {
		FileInputStream file = new FileInputStream("C:\\Users\\lenovo\\Desktop\\SampleExcel\\TestData.xls");
		
	}
	
	@Test
	public void loginWithCorrectCredential(String userName, String password) {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.get("https://opensource-demo.orangehrmlive.com/");
     
     WebElement userText = driver.findElement(By.id("txtUsername"));
     userText.sendKeys(userName);
     
     WebElement passwordText = driver.findElement(By.id("txtPassword"));
     passwordText.sendKeys(password);
     
     WebElement loginButton  = driver.findElement(By.id("btnLogin"));
     loginButton.click();
     
     driver.quit();
	}
}
