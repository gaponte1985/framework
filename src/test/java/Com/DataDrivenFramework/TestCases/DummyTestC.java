package Com.DataDrivenFramework.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import Com.DataDrivenFramework.Utilites.ExtentManager;
import Com.DataDrivenFramework.java.*;
import Com.DataDrivenFramework.java.*;

public class DummyTestC extends BaseTest{
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports screenshotFile;
	private static ExtentReports rep = ExtentManager.getInstance();
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DummyTestB.class.getName());
	@Test
	public void testC1() throws IOException{
		
		openBrowser("browser");
		url("url");
		type("email_path", "ing.aponte@gmail.com");
		click("button_xpath");
		
	}

}
