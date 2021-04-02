package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPageObject {

	@FindBy(xpath = "//*[@id=\"task-list-group-panel-menu_holder\"]/table/tbody/tr[1]/td/a")
	public static WebElement textValue;
}
