package testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObject.DashboardPageObject;

public class AdminCheck extends CommonFunctions{
	
	Logger logger = Logger.getLogger(AdminCheck.class);
	
	public void clickButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(DashboardPageObject.adminRole);
		actions.moveToElement(DashboardPageObject.userRole);
		logger.info("User button click action");
		actions.moveToElement(DashboardPageObject.systemUserRole).click().build().perform();
	}
	
	private void searchCheck() {
		Select userComboValue = new Select(DashboardPageObject.userCombo);
		userComboValue.selectByIndex(1);
		Select statusComboValue = new Select(DashboardPageObject.statusCombo);
		statusComboValue.selectByIndex(1);
		DashboardPageObject.searchButton.click();
	}

	@Test
	public void verifyPendingLeave() {
		PageFactory.initElements(driver, DashboardPageObject.class);
		logger.info("Navigating to user page");
		clickButton();
		logger.info("Search button check");
		searchCheck();
		String actualUserRole = DashboardPageObject.userColumnValue.getText();
		String actualStatusValue = DashboardPageObject.statusColumnValue.getText();
		logger.info("Verifying the actualUserRole");
		Assert.assertEquals(actualUserRole, "Admin");
		logger.info("Verifying the actualStatusValue");
		Assert.assertEquals(actualStatusValue, "Enabled");
		logger.info("End of TestUserRole testcase");
		
	}

}
