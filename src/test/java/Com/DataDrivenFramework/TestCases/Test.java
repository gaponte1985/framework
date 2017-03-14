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

public class Test extends BaseDB throws IOException, SQLException {
	
	private static final BaseDB BaseBD = null;
	private static Connection conn = BaseDB.connectionDB();
	private static Properties prop = BaseDB.prop;
	private static Connection url = BaseDB.connectionDB();
	private static Connection username = BaseDB.connectionDB();
	private static Connection password = BaseDB.connectionDB();
	private static Connection dbName = BaseDB.connectionDB();
	public static void main(String[] args) throws IOException, SQLException{
	
		
		connectionDB();
		try{ 
			
		   
			//created a obeject 
			BaseDB.Class.forName(BaseDB.driver).newInstance();
			conn = DriverManager.getConnection(url, username, password);
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
