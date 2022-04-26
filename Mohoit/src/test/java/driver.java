import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class driver {
	
	By name=By.name("email");
	By pass=By.name("pass");
	By login=By.name("login");
	
	FirefoxDriver drivers;
	@Test
	public void driver()
	{
		WebDriverManager.firefoxdriver().setup();
		drivers = new FirefoxDriver();
		drivers.get("https://www.facebook.com/login/");
	}
	@Test
	public void login()
	{
WebElement user_na=drivers.findElement(name);
user_na.sendKeys("chauhanmohit293@gmail.com");
WebElement password=drivers.findElement(pass);
password.sendKeys("123456@m");
String st=drivers.getTitle();
String name=user_na.getAttribute("value");
String pass_fil=password.getAttribute("value");

if(name.isEmpty())
{
	System.out.println("Error : Empty username");
	Assert.assertTrue(false);
}
if(pass_fil.isEmpty())
{
	System.out.println("Error : Empty password");
	Assert.assertTrue(false);
}

drivers.findElement(login).click();
		Assert.assertEquals("Log in to Facebook",st);
	}
}
