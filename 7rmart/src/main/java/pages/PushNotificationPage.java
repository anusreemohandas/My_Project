package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {

	public WebDriver driver;
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[contains(@class,'fa-bell')]")WebElement pushNotificationMenu;
	@FindBy(xpath = "//input[@id='title']")WebElement titleField;
	@FindBy(xpath = "//input[@id='description']")WebElement descriptionField;
	@FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void clickOnPushNotificationMenu() {
		pushNotificationMenu.click();
	}
	
	public void enterTitleOnTitleField(String title) {
		titleField.sendKeys(title);
	}
	
	public void enterDescriptionOnDescriptionField(String description) {
		descriptionField.sendKeys(description);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public String getTextFromAlertMessage() {
		return alertElement.getText();
	}
}