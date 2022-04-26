import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assertions_rd {
	
	Functions_1 obj=new Functions_1();
	String check_url="https://courses.letskodeit.com/practice";
	String Windo=obj.driver.getWindowHandle();
	
	@Test(priority=1)
	public void drop_assert()
	{
		obj.drop_down("BMW");
		Select sec=new Select(obj.driver.findElement(obj.drop_d));
		String opt=sec.getFirstSelectedOption().getText();
		Assert.assertEquals("BMW",opt);
	}
	
	@Test(priority=2)
	public void radio_asser()
	{
		obj.radio_butto();
		Assert.assertEquals(obj.radio_b,By.xpath("//*[@id='hondaradio']"));
		
	}
	
	@Test(priority=3)
	public void check_assert() throws InterruptedException
	{
		obj.check_box();
		String url=obj.driver.getCurrentUrl();
		Assert.assertEquals(check_url, url);
	}
	
	@Test(priority=10)
	public void Switch_wind_assert()
	{
		obj.driver.switchTo().window(Windo);
		obj.switch_window();
		Assert.assertEquals("https://courses.letskodeit.com/",obj.driver.getCurrentUrl());
	}
	
	@Test
	public void alert_ssert() throws InterruptedException
	{
		obj.alert_optio();
		Assert.assertEquals(obj.alert_str,"Hello Mohit, share this practice page and share your knowledge");	
	}
	
	@Test
	public void table_assert()
	{
		obj.table_optio();
		Assert.assertEquals(3,obj.col_count);
	}
	
	@Test
	public void mouser_assert()
	{
		obj.mouse_hover();
		Assert.assertTrue(obj.driver.findElement(obj.hover_ele).isDisplayed());
	}
	
	@Test(priority=8)
	public void iFrame_assert() throws InterruptedException
	{
		obj.driver.switchTo().window(Windo);
		Assert.assertEquals(obj.iframe_add,null);
	}

}
