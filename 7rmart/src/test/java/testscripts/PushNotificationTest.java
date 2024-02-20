package testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PushNotificationPage;
import utilities.ExcelUtility;

public class PushNotificationTest extends Base {

	@Test(description = "Verify that the user can send a message in the push notification page")
	public void verifyThatTheUserCanSendAMessageInPushNotificationPage() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(0, 1, "PushNotificationPage");
		String description = ExcelUtility.getString(1, 1, "PushNotificationPage");
		String expectedAlertMessage = ExcelUtility.getString(2, 1, "PushNotificationPage");
		LoginPage loginpage = new LoginPage(driver);
		PushNotificationPage pushnotificationpage = new PushNotificationPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButon();
		pushnotificationpage.clickOnPushNotificationMenu();
		pushnotificationpage.enterTitleOnTitleField(title);
		pushnotificationpage.enterDescriptionOnDescriptionField(description);
		pushnotificationpage.clickOnSaveButton();
		String actualAlertMessage = pushnotificationpage.getTextFromAlertMessage();
		assertEquals(actualAlertMessage, expectedAlertMessage, "User is not able to send a message in the push notification page");
		
	}
}