package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOrdersPage {

	public WebDriver driver;

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[contains(@class,'table-bordered')]//tbody//tr") List<WebElement> rowList;
	@FindBy(xpath = "//div[contains(@class,'text-left')]") WebElement textElement;
	
	public void clickOnViewButton(String orderId) {
		for (WebElement row : rowList) {
			List<WebElement> columnList = row.findElements(By.tagName("td"));
			if (orderId.equals(columnList.get(0).getText())) {
				columnList.get(6).findElement(By.xpath(".//a[text()='View']")).click();
				break;
			}
		}
	}
	
	public boolean isOrderIdMatching(String orderId) {
		String expectedText="Order ID : "+orderId;
		if(textElement.getText().contains(expectedText)) {
			return true;
		}
		return false;
	}
}