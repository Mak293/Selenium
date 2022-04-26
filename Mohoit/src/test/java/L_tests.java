import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listners_practice.class)
public class L_tests {
	
	FirefoxDriver dr;
	FireFox_tests objt;
	public L_tests()
	{
		objt=new FireFox_tests();
		objt.FireFox_test1();
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