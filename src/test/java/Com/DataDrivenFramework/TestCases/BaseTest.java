package Com.DataDrivenFramework.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class BaseTest {
	
	public WebDriver driver;
	public static Properties prop;
	//public ExtentReports rep = ExtentManager.getInstance();
	//public ExtentTest test;

	public void init(){
		//init the prop file
		if(prop==null){
			prop=new Properties();
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Properties.properties");
				prop.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public WebDriver openBrowser(String browserName) throws IOException{
		
			if (browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("firefoxprofile")){
				
				ProfilesIni profile = new ProfilesIni();
				 
				FirefoxProfile myprofile = profile.getProfile("aponte");
				 
				WebDriver driver = new FirefoxDriver(myprofile);
				}
			else if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",".//Utilites//chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.chrome.driver",".//Utilites//IEDriverServer.exe");
				driver= new InternetExplorerDriver();
			}
			else if (browserName.equalsIgnoreCase("opera"))
			{
				System.setProperty("webdriver.opera.driver", ".//Utilites//operadriver.exe");
		        WebDriver driver = new OperaDriver();
			}
			else if (browserName.equalsIgnoreCase("html")){
				HtmlUnitDriver driver = new HtmlUnitDriver();
			} else {
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			
			
			return driver;
			}
		
	public void navigate(String urlKey){
		
		driver.get(prop.getProperty(urlKey));
		
	}
	
	public void click(String locatorKey){
		getElement(locatorKey).click();
		
	}
	
	public void type(String locatorKey,String Data){
		getElement(locatorKey).sendKeys(Data);
		}
	
	public void clear(String locatorKey,String Data){
		getElement(locatorKey).clear();
		}
	//This methods is the one that will send a click or send keys or clear
	public WebElement getElement(String locatorKey){
		WebElement e= null;
		
		try{
		if(locatorKey.endsWith("_id")){
			e = driver.findElement(By.id(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_name")){
		e =	driver.findElement(By.name(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_xpath")){
			e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_css")){
			e= driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_link_text")){
			e= driver.findElement(By.linkText(prop.getProperty(locatorKey)));
		}
		
		else {
			reportFailure("Locator not correct"+locatorKey );
			Assert.fail("Failed the test: " +locatorKey);
		}
		return e;
	}catch(Exception ex){
		reportFailure(ex.getMessage());
		ex.printStackTrace();
		Assert.fail("Failed the test: " +ex.getMessage());
	}
		return e;
	}
	
	
	
	public void type(){
		
	}

	
	/****************************************** Validations******************************************/
	
	public boolean verifyTtile(){
		return false;
		
	}
	public boolean isElementPresent(){
		return false;
		
	}
	
	public boolean isTextPresent(){
		return false;
	}
	
	
	/****************************************** Reporting *****************************************************/

	public void takeScreenShoot(){
		
	}
	public void reportFailure(String string){
		
	}
}



