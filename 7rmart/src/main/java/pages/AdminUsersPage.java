package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	public PageUtility pageutility;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='username']") WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']") WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement usertypeField;
	@FindBy(xpath = "//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") WebElement alertElement;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void selectUsertype(String usertype) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByValue(usertypeField, usertype);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public String getTheAlertMessage() {
		return alertElement.getText();
	}
	
	
}
