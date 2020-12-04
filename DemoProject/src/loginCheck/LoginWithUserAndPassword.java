package loginCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginWithUserAndPassword {

	String[][] data = null;
	
	@DataProvider(name="dataCheck")
	public String[][] dataDrivenCheck() throws BiffException, IOException {
		data = getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\lenovo\\Desktop\\SampleExcel\\TestData.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();
		String testData[][] = new String[rowCount-1][columnCount];
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				testData[i-1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}
	
	@Test(dataProvider = "dataCheck")
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
