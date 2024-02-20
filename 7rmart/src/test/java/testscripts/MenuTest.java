package testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class MenuTest extends Base {
	
	@Test(description = "Verify whether the user can click different menu present in the dashboard")
	public void verifyThatWhenTheUserClickOnMenuInTheDashboardItShouldNavigateToTheCorrespondingPage() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menu = ExcelUtility.getString(8, 0, "MenuPage");
		String expectedHeader = ExcelUtility.getString(8, 1, "MenuPage");
		LoginPage loginPage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menu);
		String actualHeader = menupage.getHeaderOfThePage();
		assertEquals(actualHeader, expectedHeader, "User is not able to click on the selected menu");
	}
}