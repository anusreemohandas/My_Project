package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.GeneralUtility;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {
	
public WebDriver driver;
public Properties properties;
public FileInputStream fileinputstream ;
	
String browser = "chrome";
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	
	public void initializeBrowser(String browser) throws Exception {
		
		properties = new Properties();
		fileinputstream = new FileInputStream(GeneralUtility.CONFIG_FILE);
		properties.load(fileinputstream);
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Invalid browser");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void driverQuit(ITestResult itestresult) throws IOException {
		if(itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenShot(driver, itestresult.getName());
		}
		driver.quit();
	}
}