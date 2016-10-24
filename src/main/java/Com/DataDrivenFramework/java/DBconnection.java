package Com.DataDrivenFramework.java;

import java.sql.*;
public class DBconnection {

	public static void main(String[] args) throws SQLException
	{
		Connection conn = null;
		String url ="jdbc:mysql://192.168.1.12:3306";
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbName = "/world";
		String username = "root";
		String password ="1234";
		//connect to DB
		
		try{
			Class.forName(driver).newInstance(); //created a obeject 
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
