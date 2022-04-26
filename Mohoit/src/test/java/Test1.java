import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	
	ChromeDriver driver;
	
	@BeforeClass
	public void testsetup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void openBrower()
	{
		driver.get("https://www.facebook.com/login/");
	}
	
	@Test(description="This is for signup")
	public void sign_up()
	{
		driver.findElement(By.name("email")).sendKeys("chauhanmohit293@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("123456@m");
		driver.findElement(By.name("login")).click();
	}
	
	@AfterMethod
	public void postSign()
	{
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void afterurl()
	{
		driver.manage().window().maximize();
	}
}
