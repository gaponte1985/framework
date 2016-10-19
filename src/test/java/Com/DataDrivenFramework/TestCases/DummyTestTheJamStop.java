package Com.DataDrivenFramework.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com.DataDrivenFramework.Utilites.ExtentManager;
import Com.DataDrivenFramework.java.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestTheJamStop extends BaseTest {
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports extent;
	private static ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	
	 @BeforeSuite
	    public void beforeMethod()  throws IOException {
	
		 openBrowser("browser");
	     
	     }
	 
	 @Test
		public void start() throws IOException, InterruptedException{
		 url("url2");
	 }
	
	 @AfterSuite
	 public void end()
{
	close("url2");
	test.log(LogStatus.INFO, "Closing the browser");
	//test.log(LogStatus.FAIL, "Not able to get the list of links");
	rep.endTest(test);
	rep.flush();

	
}
}
