package Tests_cases;
import Drivers_D.Drivers_dd;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listners_L.Listners.class)
public class Test_1 {

	FirefoxDriver dr;
	
	public Test_1()
	{
		
		Drivers_dd objt=new Drivers_dd();
		objt.main(null);;
		dr=objt.driver;
	}
	
	
	@Test
	public void login()
	{
		String title=dr.getTitle();
		Assert.assertEquals(title, "Log in to Facebook");
	}
	
	@Test
	public void Logo_show()
	{
		Boolean status=dr.findElement(By.xpath("//*[@id='content']/div/div[1]/img")).isDisplayed();
		Assert.assertTrue(status);
	}
}
