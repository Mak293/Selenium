package Drivers_D;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers_dd {
 
	
	public static FirefoxDriver driver;
	
	public static void main(String []args)
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/");
	}
	


}
