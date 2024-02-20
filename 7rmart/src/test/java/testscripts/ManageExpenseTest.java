package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageExpensePage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class ManageExpenseTest extends Base {

	@Test(description = "Verify that the user can add a new expense in the manage expense page")
	public void verifyThatTheUserCanAddANewExpenseInTheManageExpensePage() throws IOException {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(14, 0, "MenuPage");
		String user = ExcelUtility.getString(0, 1, "ManageExpensePage");
		String category = ExcelUtility.getString(2, 1, "ManageExpensePage");
		String orderId = ExcelUtility.getIntegerData(3, 1, "ManageExpensePage");
		String purchaseId = ExcelUtility.getIntegerData(4, 1, "ManageExpensePage");
		String expenseType = ExcelUtility.getString(5, 1, "ManageExpensePage");
		String amount = ExcelUtility.getIntegerData(6, 1, "ManageExpensePage");
		String remarks = ExcelUtility.getString(7, 1, "ManageExpensePage");
		String expectedAlertMessage = ExcelUtility.getString(8, 1, "ManageExpensePage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageExpensePage manageExpensePage = new ManageExpensePage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		manageExpensePage.clickOnNewButton();
		manageExpensePage.selectUserFromUserDropdown(user);
		manageExpensePage.selectCategoryFromCategoryDropdown(category);
		manageExpensePage.selectOrderIdFromOrderIdDropdown(orderId);
		manageExpensePage.selectPurchaseIdFromPurchaseIdDropdown(purchaseId);
		manageExpensePage.selectExpenseTypeFromExpenseTypeDropdown(expenseType);
		manageExpensePage.enterAmountOnAmountField(amount);
		manageExpensePage.enterRemarksOnRemarksField(remarks);
		manageExpensePage.uploadFile();
		manageExpensePage.clickOnSaveButton();
		String actualAlertMessage = manageExpensePage.getTextFromAlertMessage();
		assertEquals(actualAlertMessage, expectedAlertMessage, "User is not able to add a new expense in the manage expense page");
	}
}