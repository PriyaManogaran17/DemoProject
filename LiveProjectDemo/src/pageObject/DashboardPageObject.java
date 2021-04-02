package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObject {

	@FindBy(id = "menu_admin_viewAdminModule")
	public static WebElement adminRole;
	
	@FindBy(id = "menu_admin_UserManagement")
	public static WebElement userRole;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	public static WebElement systemUserRole;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userCombo;
	
	@FindBy(id = "searchSystemUser_status")
	public static WebElement statusCombo;
	
	@FindBy(id = "searchBtn")
	public static WebElement searchButton;
	
	@FindBy(xpath = "//tr[1]/td[3]")
	public static WebElement userColumnValue;
	
	@FindBy(xpath = "//tr[1]/td[5]")
	public static WebElement statusColumnValue;
}
