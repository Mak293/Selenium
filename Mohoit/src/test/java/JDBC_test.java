import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBC_test {
	
	Connect_sql ob=new Connect_sql();
	
	@Test
	public void test() throws ClassNotFoundException, SQLException
	{
		ob.testDB();
		Statement st=ob.con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from user;");
		
		while(rs.next())
		{
			System.out.println(rs.getString("f_name"));
		}
		
		
	}

}
