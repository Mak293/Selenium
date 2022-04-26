import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Functions_1 {
	
	By radio_b=By.xpath("//*[@id='hondaradio']");
	By multiple_s=By.cssSelector("#multiple-select-example > option:nth-child(2)");
	By drop_d=By.id("carselect");
	By check_b=By.xpath("//*[@id='bmwcheck']");
	By switch_w=By.xpath("//*[@id='openwindow']");
	By home_h=By.xpath("//*[@id='navbar-inverse-collapse']/ul/li[1]/a");
	By switch_t=By.xpath("//*[@id='opentab']");
	By alert_fill=By.xpath("//*[@id='name']");
	By alert_o=By.xpath("//*[@id='alertbtn']");
	By table_o=By.xpath("//*[@id='product']//th");
	By ele_disable=By.xpath("//*[@id='enabled-button']");//*[@id="enabled-button"]
	By hover_b=By.xpath("//*[@id='mousehover']");
	By hover_ele=By.xpath("//*[@id='mouse-hover-example-div']/div/fieldset/div/div/a[1]");
	By iframe_f=By.xpath("//*[@id='header5']/div/nav/div/div[1]/button/span[2]");
	By iframe_i=By.xpath("//*[@id='courses-iframe']");
	WebElement radio_ele;
	String alert_str;
	int col_count;
	String iframe_add;
	
	ChromeDriver driver;
	public Functions_1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.get("https://courses.letskodeit.com/practice");
	}
	
	
	public void check_box() throws InterruptedException 
	{
		driver.findElement(check_b).click();
	}
	
	public void drop_down(String val)
	{
		WebElement ddown=driver.findElement(drop_d);
		Select sec=new Select(ddown);
		sec.selectByVisibleText(val);
	}
	
	public void  radio_butto()
	{
		radio_ele=driver.findElement(radio_b);
		radio_ele.click();;
	}
	
	public void multiple_select()
	{
		driver.findElement(multiple_s).click();
	}
	
	public void switch_window()
	{
		String parent=driver.getWindowHandle();
		driver.findElement(switch_w).click();
		Set<String> st=driver.getWindowHandles();
		int count =st.size();
		System.out.println(count);
		
		for(String child:st)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				driver.findElement(home_h).click();
			}
		}
	}
	
	public void switch_tab()
	{
		String parent=driver.getWindowHandle();
		driver.findElement(switch_t).click();
		Set<String> st=driver.getWindowHandles();
		int count =st.size();
		System.out.println(count);
		
		for(String child:st)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				driver.findElement(home_h).click();
			}
		}
		
	}
	
	public void alert_optio() throws InterruptedException
	{
		driver.findElement(alert_fill).sendKeys("Mohit");
		driver.findElement(alert_o).click();
		alert_str=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	}
	
	public void table_optio()
	{
		 List<WebElement>allHeader=driver.findElements(table_o);
		 col_count=allHeader.size();
		 for(WebElement e: allHeader)
		 {
			 String val=e.getText();
			 System.out.println(val);
		 }
	}
	
	public void enb_dis()
	{
		driver.findElement(ele_disable).click();
		driver.findElement(By.xpath("//*[@id='enabled-example-input']")).sendKeys("mohit");
	}
	
	public void mouse_hover()
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(hover_b);
		act.moveToElement(ele).perform();
		
		driver.findElement(hover_ele).click();
	}
	
	public void i_frame() throws InterruptedException
	{
		WebElement ele=driver.findElement(iframe_i);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();;
		driver.switchTo().frame("courses-iframe");
		Thread.sleep(2000);
		driver.findElement(iframe_f).click();
		iframe_add=driver.getCurrentUrl();
	}
}
