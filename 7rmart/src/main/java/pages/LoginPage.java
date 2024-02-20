package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") WebElement signInButton;
	@FindBy(xpath = "//li[contains(@class,'active')]") WebElement dashboardLink;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButon() {
		signInButton.click();
	}
	
	public boolean isDashboardLinkDisplayed() {
		return dashboardLink.isDisplayed();
	}
	
	public String getActualErrorMessage() {
		return alertElement.getText();
	}
	
	
}