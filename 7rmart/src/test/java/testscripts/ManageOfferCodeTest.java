package testscripts;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import pages.MenuPage;
import retry.Retry;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class ManageOfferCodeTest extends Base {
	
	@Test(retryAnalyzer = Retry.class, description = "Verify whether the user is able to add a new offer code in the manage offer code page")
	public void verifyWhetherTheUserIsAbleToAddANewOfferCodeInTheManageOfferCodePage() throws AWTException, IOException {
		RandomUtility randomutility = new RandomUtility();
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menuToBeSelected = ExcelUtility.getString(6, 0, "MenuPage");
		//String offerCode = ExcelUtility.getString(0, 1, "ManageOfferCodePage");
		String offerCode = randomutility.generateCode();
		String percentage = ExcelUtility.getIntegerData(1, 1, "ManageOfferCodePage");
		String amount = ExcelUtility.getIntegerData(2, 1, "ManageOfferCodePage");
		String expectedAlertMessage = ExcelUtility.getString(3, 1, "ManageOfferCodePage");
		LoginPage loginpage = new LoginPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		menupage.clickOnTheMenuInDashboard(menuToBeSelected);
		manageoffercodepage.clickOnNewButton();
		manageoffercodepage.enterOfferCodeOnOfferCodeField(offerCode);
		manageoffercodepage.clickOnYesRadioButton();
		manageoffercodepage.enterPercentageOnPercentageField(percentage);
		manageoffercodepage.enterAmountOnAmountField(amount);
		manageoffercodepage.uploadImage();
		manageoffercodepage.clickOnSaveButton();
		String actualAlertMessage = manageoffercodepage.getTextFromAlertMessage();
		assertEquals(expectedAlertMessage, actualAlertMessage, "User is not able to add a new promo code in the manage offer code page");
	}
}