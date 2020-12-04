package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageModel {
	
	
	  @FindBy(how = How.NAME, using = "username") 
	  public static WebElement userName;
	  
	  @FindBy(name = "password") 
	  public static WebElement userPassword;
	  
	  @FindBy(xpath = "//button[text()='Login']") 
	  public static WebElement submitButton;
	 

		/*
		 * public static WebElement userName(WebDriver driver) { return
		 * driver.findElement(By.name("username")); }
		 * 
		 * public static WebElement userPassword(WebDriver driver) { return
		 * driver.findElement(By.name("password"));
		 * 
		 * }
		 * 
		 * public static WebElement submitButton(WebDriver driver) { return
		 * driver.findElement(By.xpath("//button[text()='Login']")); }
		 */}
