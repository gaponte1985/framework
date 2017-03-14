package Com.DataDrivenFramework.TestCases.weightwatchers;


import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.DataDrivenFramework.java.BaseTest;
 
public class weightwatchersBroken extends BaseTest{
 
	private static Properties prop = BaseTest.getProperties();
	private static Properties url = BaseTest.getProperties();
	static ExtentTest test;
	 
	@BeforeTest
	public void before() throws IOException{
		test = rep.startTest("Weight Watchers broken links ");
		setLogger(test);
		openBrowser("browser");
		 test.log(LogStatus.INFO, "Starting the test");
		
	}
	
	public ExtentTest getReportLogger() {
		return test;
	}
	
	
	    @Test
	    public void start() throws IOException, InterruptedException{
	    
	    	url("weightwatchers");
			test.log(LogStatus.INFO, "Going to WEbMD.com");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
	
		 test.log(LogStatus.INFO, "Total links are "+links.size());
		
		 
		 for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
		//	String name = (links.get(i).getText());
			
			String url=ele.getAttribute("href");
			String name2=ele.getText();
		//System.out.println(name2);
			
			verifyLinkActive(url, name2);
			
		}
		
	
	    }
	
	private static void verifyLinkActive(String linkUrl, String page)
	{
		
        try 
        {      
          
        	 URL url = new URL(linkUrl);
        	
        	
        	
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
              // System.out.println(page+ " , "+linkUrl+" - The links is: --> "+httpURLConnect.getResponseMessage());
               test.log(LogStatus.PASS, "There not broken links found in this page"); 
           }
           else  if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(page+ " , " +linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
               test.log(LogStatus.FAIL, "Link broke:  " +page+ " , "+linkUrl);
           
           }
        
        } catch (Exception e) {
           
        }
    } 
	@AfterTest
	public void end()
	{
		close("webmd");
		test.log(LogStatus.INFO, "Closing the browser");
		
		rep.endTest(test);
		rep.flush();

		
	}
	
	 
 
}