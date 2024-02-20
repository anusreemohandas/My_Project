package testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	
	@Test(description = "Verify that the user can add a new location in the manage location page")
	public void verifyThatTheUserCanAddANewLocationInTheManageLocationPage() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(11, 0, "MenuPage");
		String country = ExcelUtility.getString(0, 1, "ManageLocationPage");
		String state = ExcelUtility.getString(1, 1, "ManageLocationPage");
		String location = ExcelUtility.getString(2, 1, "ManageLocationPage");
		String deliveryCharge = ExcelUtility.getString(3, 1, "ManageLocationPage");
		String expectedAlertMessage = ExcelUtility.getString(4, 1, "ManageLocationPage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageLocationPage managelocationpage = new ManageLocationPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		managelocationpage.clickOnNewButton();
		managelocationpage.selectCountryFromDropdown(country);
		managelocationpage.selectStateFromDropdown(state);
		managelocationpage.enterLocationOnLocationField(location);
		managelocationpage.enterDeliveryChargeOnDeliveryChargeField(deliveryCharge);
		managelocationpage.clickOnSaveButton();
		String actualAlertMessage = managelocationpage.getTextFromAlertMessage();
		assertEquals(expectedAlertMessage, actualAlertMessage, "User is not able to add a new location in the manage location page");
	}
}