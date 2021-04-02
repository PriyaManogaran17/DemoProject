package testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObject.LoginPageObject;
import pageObject.UserPageObject;


public class TestUserRole extends CommonFunctions{

	String actualValue;
	static Logger logger = Logger.getLogger(TestUserRole.class);
	
	public void loginCheck() {
		logger.info("Logging to the application");
		PageFactory.initElements(driver, LoginPageObject.class);
		LoginPageObject.userName.sendKeys(property.getProperty("username"));
		LoginPageObject.password.sendKeys(property.getProperty("password"));
		LoginPageObject.loginButton.click();
	}
	
	public void getValue() {
//		PageFactory.initElements(driver, UserPageObject.class);
//		actualValue = UserPageObject.textValue.getText();
	}
	
	@Test
	public void doExecute() {
		loginCheck();
//		logger.info("Getting leave request");
//		getValue();
//		logger.info("verifying user value");
//		Assert.assertEquals(actualValue, "01. Paul Collings 2020-11-02");
//		logger.info("End of TestUserRole testcase");
	}
}
