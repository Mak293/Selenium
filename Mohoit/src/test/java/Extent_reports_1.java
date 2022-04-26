import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_reports_1 {

	
	public ExtentReports report;
	public ExtentTest logger;
	FirefoxDriver driver;
	
	@BeforeClass
	public void setExtent()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"/test-output/Z_1.html",true);
		
	}
	
	@AfterClass
	public void endReport()
	{
		
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/");
	}
	
	@Test
	public void login()
	{
		logger=report.startTest("Login To facebook");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Log in to Facebook");
		logger.log(LogStatus.PASS, "Test CAse Passed");
	}
	
	@Test
	public void picture()
	{
		logger=report.startTest("FaceBook Logo");
		Boolean status=driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img")).isDisplayed();
		Assert.assertTrue(status);
		logger.log(LogStatus.PASS, "Test CAse Passed");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.FAIL, "Test CAse Passed"+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getName());
			logger.log(LogStatus.SKIP, "Test CAse Passed"+result.getThrowable());
		}
		report.endTest(logger);			
	}
}