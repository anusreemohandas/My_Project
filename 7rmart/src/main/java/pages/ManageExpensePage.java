package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpensePage {

	public WebDriver driver;
	public PageUtility pageutility;
	public FileUploadUtility fileuploadutility;
	public WaitUtility waitutility;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//select[@name='user_id']") WebElement userDropdown;
	@FindBy(xpath = "//select[@name='ex_cat']") WebElement categoryDropdown;
	@FindBy(xpath = "//select[@name='order_id']") WebElement orderIdDropdown;
	@FindBy(xpath = "//select[@name='purchase_id']") WebElement purchaseIdDropdown;
	@FindBy(xpath = "//select[@name='ex_type']") WebElement expenseTypeDropdown;
	@FindBy(xpath = "//input[@id='amount']") WebElement amountField;
	@FindBy(xpath = "//textarea") WebElement remarksField;
	@FindBy(xpath = "//input[@type='file']") WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void selectUserFromUserDropdown(String user) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(userDropdown, user);
	}
	
	public void selectCategoryFromCategoryDropdown(String category) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(categoryDropdown, category);
	}
	
	public void selectOrderIdFromOrderIdDropdown(String orderId) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(orderIdDropdown, orderId);
	}
	
	public void selectPurchaseIdFromPurchaseIdDropdown(String purchaseId) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(purchaseIdDropdown, purchaseId);
	}
	
	public void selectExpenseTypeFromExpenseTypeDropdown(String expenseType) {
		pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(expenseTypeDropdown, expenseType);
	}
	
	public void enterAmountOnAmountField(String amount) {
		amountField.sendKeys(amount);
	}
	
	public void enterRemarksOnRemarksField(String remarks) {
		remarksField.sendKeys(remarks);
	}
	
	public void uploadFile() {
		fileuploadutility = new FileUploadUtility();
		waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, chooseFileButton);
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, GeneralUtility.ICECREAM_IMG);
	}
	
	public void clickOnSaveButton() {
		pageutility.javaScriptClick(driver, saveButton);
	}
	
	public String getTextFromAlertMessage() {
		return alertElement.getText();
	}
}