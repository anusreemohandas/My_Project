package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	
	@Test(description = "Verify that the user can search a delivery boy in the Manage Delivery boy page by providing the name, email and phone number")
	public void verifyThatWhenTheUserSearchDeliveryBoyUsingNameEmailAndPhoneNumberItShouldDisplayTheDetailsOfDeliveryBoy() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(8, 0, "MenuPage");
		String name = ExcelUtility.getString(0, 1, "ManageDeliveryBoyPage");
		String email = ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		String phoneNumber = ExcelUtility.getString(2, 1, "ManageDeliveryBoyPage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		managedeliveryboypage.clickOnSearchLink();
		managedeliveryboypage.enterNameonNameField(name);
		managedeliveryboypage.enterEmailonEmailField(email);
		managedeliveryboypage.enterPhoneNumberonPhoneNumberField(phoneNumber);
		managedeliveryboypage.clickOnSearchButton();
		boolean isSearchSuccessful = managedeliveryboypage.verifyDetailsOfSearchedDeliveryBoy(name, email, phoneNumber);
		assertTrue(isSearchSuccessful, "Details of the delivery boy searched is not displayed");
	}
	
}