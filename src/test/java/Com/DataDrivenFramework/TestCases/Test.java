package Com.DataDrivenFramework.TestCases;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import Com.DataDrivenFramework.TestCases.*;
import Com.DataDrivenFramework.java.*;

public class Test extends BaseDB {
	
	private static Connection conn = BaseDB.conn;
	private static Properties prop = BaseTest.getProperties();
	
	
	public static void main(String[] args) throws IOException, SQLException{
	
		
		//connectionDB("");
		try{ 
			
		    connectionDB("mysql");
			//created a obeject 
			BaseDB.Class.forName(BaseBD.driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, username, password);
			System.out.println(conn.isClosed());
			Statement st =conn.createStatement();
			ResultSet rs = st.executeQuery("select * from city");
			while(rs.next()){
				
				System.out.println(rs.getString("city"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if((conn!=null) && (!conn.isClosed()))
			{
				conn.close();
			}
		}
	}
}
