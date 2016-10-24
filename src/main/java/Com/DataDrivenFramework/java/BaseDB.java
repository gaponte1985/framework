package Com.DataDrivenFramework.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDB {
	public static final String Class = null;
	public static Properties prop = new Properties();
	public static Connection conn ;
	public static String Dire = System.getProperty("user.dir");
	
	
	public static Properties getProperties() {

        FileInputStream fileInput;
     
          File file = new File(Dire +"/src/test/resources/Com/DataDrivenFramework/Utilites/Properties.properties");
     
        try {

            fileInput = new FileInputStream(file);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
            return null;
        }

        // load properties file
        try {
            prop.load(fileInput);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
	
	
	
	public static void connectionDB(String databaseName)throws SQLException{
		
		//String databaseName = prop.getProperty("db"); 
	   
		if (prop.getProperty(databaseName).equalsIgnoreCase("mysql"))
		{
			Connection conn = null;
			String url =prop.getProperty("dburl");
			String driver =prop.getProperty("dbdriver");
			String dbName = prop.getProperty("dbname");
			String username = prop.getProperty("dbusername");
			String password =prop.getProperty("dbpassword");
			
		
		
		}
		if (prop.getProperty(databaseName).equalsIgnoreCase("sql"))
		{
			   String driver = prop.getProperty("dbdricer");
			   String name = prop.getProperty("dbname");
			   String url = prop.getProperty("dburl");
			   String username = prop.getProperty("dbusername");
			   String password = prop.getProperty("dbpassword");
			   
		}
		else {
			System.out.println("error");
		}
		
	
		
	}
}
