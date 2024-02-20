package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage {
	
	public WebDriver driver;
	public FileUploadUtility fileuploadutility;
	public WaitUtility waitutility;
	public PageUtility pageutility;

	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='offer_code']") WebElement offerCodeField;
	@FindBy(xpath = "//input[@value='yes']") WebElement yesRadioButton;
	@FindBy(xpath = "//input[@id='offer_per']") WebElement percentageField;
	@FindBy(xpath = "//input[@id='offer_price']") WebElement amountField;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterOfferCodeOnOfferCodeField(String offerCode) {
		offerCodeField.sendKeys(offerCode);
	}
	
	public void clickOnYesRadioButton() {
		yesRadioButton.click();
	}
	
	public void enterPercentageOnPercentageField(String percentage) {
		percentageField.sendKeys(percentage);
	}
	
	public void enterAmountOnAmountField(String amount) {
		amountField.sendKeys(amount);
	}
	
	public void uploadImage() throws AWTException {
		fileuploadutility = new FileUploadUtility();
		waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, chooseFileButton);
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, GeneralUtility.PROMOCODE_IMG);
	}
	
	public void clickOnSaveButton() {
		waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, saveButton);
		pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, saveButton);
	}
	
	public String getTextFromAlertMessage() {
		return alertElement.getText();
	}
	
	
}