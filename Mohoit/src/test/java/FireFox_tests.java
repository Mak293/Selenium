import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFox_tests{

	public FirefoxDriver driver;
	
	@Test
	public void FireFox_test1()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/");
	}
}



