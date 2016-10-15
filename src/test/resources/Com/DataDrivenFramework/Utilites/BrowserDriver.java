package Com.DataDrivenFramework.Utilites;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

/**
 * @author Gerardo Aponte
 *
 */
public class BrowserDriver
{
	
	/*Properties prop = new Properties();
        FileInputStream tjs = new FileInputStream("utilites//TheJamStop.properties");
        prop.load(tjs);
	 */
	
	/*
	 */
	public static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url)
	
	{
	if (browserName.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if(browserName.equals("firefoxprofile")){
		
		ProfilesIni profile = new ProfilesIni();
		 
		FirefoxProfile myprofile = profile.getProfile("aponte");
		 
		WebDriver driver = new FirefoxDriver(myprofile);
		}
	else if (browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",".//Utilites//chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if (browserName.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.chrome.driver",".//Utilites//IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}
	else if (browserName.equals("opera"))
	{
		System.setProperty("webdriver.opera.driver", ".//Utilites//operadriver.exe");
        WebDriver driver = new OperaDriver();
	}
	else if (browserName.equals("html")){
		HtmlUnitDriver driver = new HtmlUnitDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	
	return driver;
	}
}
