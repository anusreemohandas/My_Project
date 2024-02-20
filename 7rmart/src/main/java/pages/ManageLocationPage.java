package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	
	public WebDriver driver;
	public PageUtility pageutility;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") WebElement countryDropdown;
	@FindBy (xpath = "//select[@id='st_id']") WebElement stateDropdown;
	@FindBy(xpath = "//input[@id='location']") WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']") WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@name='create']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void selectCountryFromDropdown(String country) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(countryDropdown, country);
	}
	
	public void selectStateFromDropdown(String state) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(stateDropdown, state);
	}
	
	public void enterLocationOnLocationField(String location) {
		locationField.sendKeys(location);
	}
	
	public void enterDeliveryChargeOnDeliveryChargeField(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public String getTextFromAlertMessage() {
		return alertElement.getText();
	}
	
	
}