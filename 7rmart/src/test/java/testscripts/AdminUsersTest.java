package testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.MenuPage;
import retry.Retry;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class AdminUsersTest extends Base {
	
	@Test(retryAnalyzer = Retry.class, description = "Verify whether a new user can be added to the admin users page")
	public void verifyWhetherTheUserIsAbleToAddANewUserInTheAdminUsersPage() {
		RandomUtility randomUtility = new RandomUtility();
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(2, 0, "MenuPage");
		String newUsername = randomUtility.generateFullName();
		String newPassword = ExcelUtility.getString(1, 1, "AdminUsersPage");
		String newUsertype = ExcelUtility.getString(2, 1, "AdminUsersPage");
		String expectedAlertMessage = ExcelUtility.getString(3, 1, "AdminUsersPage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsernameOnUsernameField(newUsername);
		adminuserspage.enterPasswordOnPasswordField(newPassword);
		adminuserspage.selectUsertype(newUsertype);
		adminuserspage.clickOnSaveButton();
		String actualAlertMessage = adminuserspage.getTheAlertMessage();
		assertEquals(expectedAlertMessage, actualAlertMessage, "Unable to add a new user in the admin users page");
	}
}