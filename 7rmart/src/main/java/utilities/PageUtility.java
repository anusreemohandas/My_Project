package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectValueUsingSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectValueUsingSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectValueUsingSelectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void dragAndDrop(WebElement dragItem,WebElement dropItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragItem, dropItem).build().perform();
	}
	
	public void doubleClick(WebElement targetItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(targetItem).build().perform();
	}
	
	public void rightClick(WebElement targetItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(targetItem).build().perform();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void promtAlert (WebElement alertElement,String input, WebDriver driver) {
		driver.switchTo().alert().sendKeys(input);
   	  	driver.switchTo().alert().accept();
	}
	
	public void frame(WebElement iframe, WebDriver driver) {
		driver.switchTo().frame(iframe);
	}
	
	public void javaScriptClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public void scrollDownOfaWebPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void ScrollIntoViewOfAnElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public void verifyScrollToTheBottomOfaWebpage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void HorizontalScrollIntoViewOfAnElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
}