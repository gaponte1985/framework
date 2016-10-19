package Com.DataDrivenFramework.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;

import Com.DataDrivenFramework.Utilites.ExtentManager;


public class DummyTestB extends BaseTest{
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports extent;
	private static ExtentReports rep = ExtentManager.getInstance();
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DummyTestB.class.getName());
		
			ExtentTest test;
	
	@Test
	public void testB1() throws IOException{
		
		 test = rep.startTest("Dummy TestB");
		 test.log(LogStatus.INFO, "Starting the test");
		// test.log(LogStatus.FAIL, "Failing the test");
	//	 test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));
		 
		 
		openBrowser("browser");
		log.debug("urlKey ");
    	log.info("urlKey world");
		test.log(LogStatus.INFO, "Open the browser ");
		test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png"));
      
		
		url("url");
		test.log(LogStatus.INFO, "input the url");
		type("email_css","ing.aponte@gmail.com");
		test.log(LogStatus.INFO, "input the email");
		click("button_xpath");
		test.log(LogStatus.INFO, "click the button");
		quit("appurl");		
	}
	@AfterTest
	public void testB2() throws IOException{
	
		rep.endTest(test);
		rep.flush();

	}

}
