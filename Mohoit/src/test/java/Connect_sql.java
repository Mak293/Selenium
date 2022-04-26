import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Connect_sql {

	Connection con;
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","root");
	}

}

