package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class MenuPage {
	
	public WebDriver driver;
	public PageUtility pageutility;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'small')]//child::div[@class='inner']") List<WebElement> menuList;
	@FindBy(xpath = "//a[@class='small-box-footer']") List<WebElement> menuLink;
	@FindBy(xpath = "//h1") WebElement headerElement;
	
	public void clickOnTheMenuInDashboard(String menuToBeClicked) {
		int menuIndex;
		for (WebElement menuItem : menuList) {
			menuIndex = menuList.indexOf(menuItem);
			if(menuIndex!=-1 && menuItem.getText().contains(menuToBeClicked)) {
				pageutility = new PageUtility();
				pageutility.javaScriptClick(driver, menuLink.get(menuIndex));
				break;
			} 
		}	
	}
	
	public String getHeaderOfThePage() {
		return headerElement.getText();
	}
}