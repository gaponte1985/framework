package Com.DataDrivenFramework.TestCases;

import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opera.core.systems.OperaDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.DataDrivenFramework.Utilites.ExtentManager;

public class BaseTest {
	//public static Properties prop;
	public WebDriver driver;
	public ExtentTest test;
	
	public static Properties prop = new Properties();
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

	public WebDriver openBrowser(String browserName) throws IOException{
		
			if (browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("firefoxprofile")){
				
				ProfilesIni profile = new ProfilesIni();
				 
				FirefoxProfile myprofile = profile.getProfile("aponte");
				 
				 driver = new FirefoxDriver(myprofile);
				}
			else if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","chromedriver");
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
		         driver = new OperaDriver();
			}
			else if (browserName.equalsIgnoreCase("html")){
				 driver = new HtmlUnitDriver();
			} else {
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			
			
			return driver;
			}
		
	public void url(String urlKey){
		
		driver.get(prop.getProperty("url"));
		
	}
	
public void close(String urlKey){
		
		driver.close();
		
	}

public void quit(String urlKey){
	
	driver.quit();
	
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
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//put screenshot file in reports
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		
	}
	public void reportFailure(String string){
		
	}



}


