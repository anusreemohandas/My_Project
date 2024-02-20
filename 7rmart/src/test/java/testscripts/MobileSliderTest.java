package testscripts;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;
import pages.MenuPage;

public class MobileSliderTest extends Base {
	
	@Test(description = "Verify that the user can add a new slider in the mobile slider page")
	public void verifyThatTheUserCanAddANewSliderInTheMobileSliderPage() throws AWTException {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(12, 0, "MenuPage");
		String category = ExcelUtility.getString(0, 1, "MobileSliderPage");
		String expectedAlertMessage = ExcelUtility.getString(1, 1, "MobileSliderPage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		MobileSliderPage mobilesliderpage = new MobileSliderPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		mobilesliderpage.clickOnNewButton();
		mobilesliderpage.selectCategoryFromDropdown(category);
		mobilesliderpage.uploadImage();
		mobilesliderpage.clickOnSaveButton();
		String actualAlertMessage = mobilesliderpage.getTextFromAlertMessage();
		assertEquals(expectedAlertMessage, actualAlertMessage, "User is not able to add a new slider in the mobile slider page");
	}
}