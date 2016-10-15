package Com.DataDrivenFramework.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.DataDrivenFramework.Utilites.ExtentManager;

public class DummyTestB extends BaseTest{
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	@Test(priority=1)
	public void testB1() throws IOException{
		ExtentReports rep = ExtentManager.getInstance();
		 test = rep.startTest("Dummy TestB");
		// openBrowser(prop.getProperty("browser"));
		//openBrowser(prop.getProperty("browser"));
		openBrowser("firefox");
		test.log(LogStatus.INFO, "Open the browser");
		navigate("appurl");
		
		
	}
	



}
