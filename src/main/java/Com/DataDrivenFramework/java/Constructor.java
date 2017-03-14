package Com.DataDrivenFramework.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Constructor extends BaseTest {
	   
	   private static Properties prop = BaseTest.getProperties();
	
	   static String  driverdb ;
	   static String  name ;
	   static String url;
	   static String username ;
	   static  String password ;
	   static  String dbname;
	   static Connection conn = null;
	   static String all;

	   public static void conectar() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	   {
	
	if (prop.getProperty("databaseName").equalsIgnoreCase("mysql"))
	{
		  
		     driverdb = prop.getProperty("driverdb");
		     name = prop.getProperty("databaseName");
		    url = prop.getProperty("dburl");;
		    username = prop.getProperty("dbusername");
		    password = prop.getProperty("dbpassword");
		    dbname = prop.getProperty("dbname");
		
		Class.forName(driverdb).newInstance();
		conn = DriverManager.getConnection(url+dbname, username, password);
		System.out.println(url+ " " +username+ " " +password+ " " +dbname+  ""+conn);
	}
	
	if (prop.getProperty("databaseName").equalsIgnoreCase("sql"))
	{
		     driverdb = prop.getProperty("driverdb");
		     name = prop.getProperty("databaseName");
		    url = prop.getProperty("dburl");;
		    username = prop.getProperty("dbusername");
		    password = prop.getProperty("dbpassword");
		    dbname = prop.getProperty("dbname");
		    Class.forName(driverdb);
		   conn = DriverManager.getConnection(url, username, password);
		 System.out.println(url+ " " +username+ " " +password+ " " +dbname+  ""+conn);
	}
	else {
		System.out.println("error");
	}
	//return conn;


 System.out.println(url+ " " +username+ " " +password+ " " +dbname+  "");

 System.out.println(url+ " " +username+ " " +password+ " " +dbname+  ""+conn);

	
	
}


	
}


