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

import Com.DataDrivenFramework.Utilites.ExtentManager;


public class DummyTestB extends BaseTest{
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports extent;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	@Test
	public void testB1() throws IOException{
		
		 test = rep.startTest("Dummy TestB");
		 test.log(LogStatus.INFO, "Starting the test");
		// openBrowser(prop.getProperty("browser"));
		//openBrowser(prop.getProperty("browser"));
		openBrowser("firefox");
		test.log(LogStatus.INFO, "Open the browser");
		
		url("appurl");
		test.log(LogStatus.INFO, "input the url");
		type("email_css","ing.aponte@gmail.com");
		test.log(LogStatus.INFO, "input the email");
		click("button_xpath");
		test.log(LogStatus.INFO, "click the button");
		quit(null);
	
		
	}
	
	
	@AfterTest
	public void testB2() throws IOException{
	
		ExtentTest.endTest(test);
		ExtentTest.flush();

	}

}
