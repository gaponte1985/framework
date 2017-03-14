package Com.DataDrivenFramework.java;


import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opera.core.systems.OperaDriver;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseDB extends BaseTest {
	public static final String Class = null;
	public static WebDriver driver;
	public ExtentTest test;
	public static ExtentReports screenshotFile;
	public static ExtentReports extent;
	
	public static Properties prop = new Properties();
	public static String Dire = System.getProperty("user.dir");
	public Actions act;
	private static Logger log = Logger.getLogger(BaseTest.class.getName());
	private static Connection conn = null;
	
	public static Connection connectionDB()throws SQLException{
		
		//String databaseName = prop.getProperty("db"); 

		if (prop.getProperty("databaseName").equalsIgnoreCase("mysql"))
		{
			
		
			String driverdb =prop.getProperty("dbdriver");
			String dbName = prop.getProperty("dbname");
			String username = prop.getProperty("dbusername");
			String password =prop.getProperty("dbpassword");	
			String url =prop.getProperty("ur;");	
			
			
			conn = DriverManager.getConnection(url+dbName, username, password);
		}
		
		
		if (prop.getProperty("databaseName").equalsIgnoreCase("sql"))
		{

			   String  driverdb = prop.getProperty("dbdricer");
			   String  name = prop.getProperty("dbname");
			   String url = prop.getProperty("dburl");
			   String username = prop.getProperty("dbusername");
			   String password = prop.getProperty("dbpassword");
			   conn = DriverManager.getConnection(url, username, password);
		}
		else {
			System.out.println("error");
		}
		return conn;
		
	}
	}




