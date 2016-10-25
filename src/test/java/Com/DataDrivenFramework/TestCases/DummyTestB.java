package Com.DataDrivenFramework.TestCases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.Properties;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.DataDrivenFramework.java.*;
import Com.DataDrivenFramework.Utilites.ExtentManager;


public class DummyTestB extends BaseTest{
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports screenshotFile;
	private static ExtentReports rep = ExtentManager.getInstance();
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DummyTestB.class.getName());
		
			ExtentTest test;
	
	@Test
	public void testB1() throws IOException{
		
		 test = rep.startTest("Dummy TestB");
		 test.log(LogStatus.INFO, "Starting the test");
		 
		 //test.log(LogStatus.FAIL, "Failing the test");
	     //test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));
		 
		 openBrowser("browser");
		 SSLCertificateHandle("browser");
		log.debug("urlKey");
    	log.info("urlKey world");
		test.log(LogStatus.INFO, "Open the browser ");
		//test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/photo.png"));
		
		url("url0");
		//url("url");
		
		
		test.log(LogStatus.INFO, "input the url");
	//	type("email_css","ing.aponte@gmail.com");
		test.log(LogStatus.INFO, "input the email");
	//	click("button_xpath");
		test.log(LogStatus.INFO, "click the button");
		takeScreenShoot();
		quit("appurl");		
	}
	@AfterTest
	public void testB2() throws IOException{
	
		rep.endTest(test);
		rep.flush();

	}

}
