package Com.DataDrivenFramework.java;

import java.sql.*;

import org.openqa.selenium.WebDriver;
public class DBconnection extends Constructor {

	
	public static void main (String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		conectar();
		System.out.println(url+ " " +username+ " " +password+ " " +dbname+ " " +url+ "" +conn );
	}
	
	
	
	
	public static void main1111(String[] args, Object tabla) throws SQLException
	{
		
		//connectionDB();
		try{
		//	Class.forName(driverdb); //created a obeject 
			System.out.println(url);
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from city");
			while(rs.next()){
				
				System.out.println(rs.getString("city"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if((conn!=null) && (!((Connection) conn).isClosed()))
			{
				((WebDriver) conn).close();
			}
		}
	}
}
	

