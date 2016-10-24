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
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opera.core.systems.OperaDriver;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.DataDrivenFramework.Utilites.ExtentManager;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentTest test;
	public static ExtentReports screenshotFile;
	public static ExtentReports extent;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static Properties prop = new Properties();
	public static String Dire = System.getProperty("user.dir");
	public Actions act;
	private static Logger log = Logger.getLogger(BaseTest.class.getName());
	
	
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
		
			if (prop.getProperty(browserName).equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				log.debug("firefox ");
		    	log.info("hello world");
			}
			else if(prop.getProperty(browserName).equalsIgnoreCase("firefoxprofile")){
				
				ProfilesIni profile = new ProfilesIni();
				 
				FirefoxProfile myprofile = profile.getProfile("aponte");
				 
				 driver = new FirefoxDriver(myprofile);
				}
			else if (prop.getProperty(browserName).equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","chromedriver");
				driver= new ChromeDriver();
			}
			else if (prop.getProperty(browserName).equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.chrome.driver",".//Utilites//IEDriverServer.exe");
				driver= new InternetExplorerDriver();
			}
			else if (prop.getProperty(browserName).equalsIgnoreCase("opera"))
			{
				System.setProperty("webdriver.opera.driver", ".//Utilites//operadriver.exe");
		         driver = new OperaDriver();
			}
			else if (prop.getProperty(browserName).equalsIgnoreCase("html")){
				 driver = new HtmlUnitDriver();
			} else {
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			
			
			return driver;
			}
	
	public String navigate(String urlKey)
	{
		driver.navigate().to(prop.getProperty(urlKey));
		log.debug("urlKey ");
    	log.info("urlKey world");
		return urlKey;
	}
	
	public String navigateBack(String urlKey)
	{
		driver.navigate().back();
		return navigateBack(null);
	}
	public String navigateFoward(String urlKey)
	{
		driver.navigate().forward();
		return navigateFoward(null);
	}
	public String url(String urlKey){
		
		driver.get(prop.getProperty(urlKey));
		log.debug("urlKey ");
    	log.info("urlKey world");
		return urlKey;
		
	
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
	
	public WebElement mouseMove(String locatorKey){
		act = new Actions(driver);
	    WebElement icon = getElement(locatorKey);
		act.dragAndDropBy(icon, 50, 0).build().perform();
		return icon;
	}

	
	/****************************************** Validations******************************************/
	
	public boolean verifyTtile(String locatorKey, String ecpectedTextKey){

		return false;
		
	}
	public boolean isElementPresent(String locatorKey){
		
		List<WebElement> elementList = null;
		
		if(locatorKey.endsWith("_id")){
			elementList = driver.findElements(By.id(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_name")){
			elementList =	driver.findElements(By.name(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_xpath")){
			elementList = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_css")){
			elementList= driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_link_text")){
			elementList= driver.findElements(By.linkText(prop.getProperty(locatorKey)));
		}
		
		else {
			reportFailure("Locator not correct"+locatorKey );
			Assert.fail("Failed the test: " +locatorKey);
		}
		if(elementList.size()==0)
		{
			return true;
		}
		else 
		return true;
		
	}
	
	
	public boolean verifyText(String locatorKey,String expectedTextKey){
			String actualText=getElement(locatorKey).getText().trim();
			String expectedText=prop.getProperty(expectedTextKey);
			if(actualText.equals(expectedText)){
				return true;
				}else{ 
					return false;
			          }
	}
		
	
		
	
		
		
		
		
		
		
	/****************************************** Reporting *****************************************************/

	public void takeScreenShoot() throws IOException{
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.getProperty("user.dir")+"/screenshots/"+screenshotFile);
	//	test.log(LogStatus.PASS,"Screenshot the test" +test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/"+screenshotFile));

		return;
	}
	
	public void reportPass(String msg){
		test.log(LogStatus.PASS, msg);
	}
	
	public void reportFailure(String msg) throws IOException{
		test.log(LogStatus.FAIL, msg);
		takeScreenShoot();
		Assert.fail(msg);
	}





}


