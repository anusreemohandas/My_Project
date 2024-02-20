package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void fileUploadUsingSendKeys(WebElement element, String locationOfFile) {
		element.sendKeys(locationOfFile);
	}
	
	public void fileUploadUsingRobotClass(WebElement element, String locationOfFile) throws AWTException {
		element.click();
		StringSelection stringselection = new StringSelection(locationOfFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}