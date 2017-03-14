package Com.DataDrivenFramework.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.DataDrivenFramework.Utilites.ExtentManager;
import Com.DataDrivenFramework.java.BaseTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestB extends BaseTest {
	private static Properties prop = BaseTest.getProperties();
	private static ExtentReports screenshotFile;
	public static ExtentReports rep = ExtentManager.getInstance();
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(DummyTestB.class.getName());

	static ExtentTest test;

	@BeforeTest
	public void setUp() {
		test = rep.startTest("Dummy TestB");
		setLogger(test);
	}

	public ExtentTest getReportLogger() {
		return test;
	}

	@Test
	public void testB1() throws IOException, InterruptedException {

		test.log(LogStatus.INFO, "Starting the test");

		test.log(LogStatus.FAIL, "Failing the test");
		// test.log(LogStatus.FAIL, "Screenshot the test" +
		// test.addScreenCapture(System.getProperty("user.dir")
		// +"/screenshots/photo.png/"));

		openBrowser("browser");
		// SSLCertificateHandle("browser");
		log.debug("urlKey");
		log.info("urlKey world");
		test.log(LogStatus.INFO, "Open the browser ");
		// test.log(LogStatus.FAIL, "Screenshot the test" +
		// test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/photo.png"));
		takeScreenShot();
		url("url");
		// url("url");

		test.log(LogStatus.INFO, "input the url");
		takeScreenShot();
		type("email_css","ing.aponte@gmail.com");
		takeScreenShot();
		test.log(LogStatus.INFO, "input the email");
		 click("button_xpath");
		 takeScreenShot();
		test.log(LogStatus.PASS, "Test B Passed");
		
		// screenshots

		quit("appurl");
	}

	@AfterTest
	public void testB2() throws IOException {

		rep.endTest(test);
		rep.flush();

	}

}
