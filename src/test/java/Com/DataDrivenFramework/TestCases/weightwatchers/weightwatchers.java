package Com.DataDrivenFramework.TestCases.weightwatchers;


	import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

	import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	import Com.DataDrivenFramework.Utilites.ExtentManager;
import Com.DataDrivenFramework.java.*;



	public class weightwatchers extends BaseTest {
		
		private static Properties prop = BaseTest.getProperties();
		private static Properties url = BaseTest.getProperties();
		ExtentTest test;
		 
		@BeforeTest
		public void before() throws IOException{
			test = rep.startTest("webmd");
			setLogger(test);
			openBrowser("browser");
			 test.log(LogStatus.INFO, "Starting the test");
			 test.log(LogStatus.FAIL, "Failing the test");
		}
		
		public ExtentTest getReportLogger() {
			return test;
		}
		
		@Test 
		public void start() throws IOException, InterruptedException{
			
			
			url("weightwatchers");
			test.log(LogStatus.INFO, "Going to WEbMD.com");
			 
			 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			 test.log(LogStatus.INFO, "Getting the links");
				System.out.println(links.size());
		 
				for (int i = 1; i!=links.size(); i++)
		 
				{
		 
					System.out.println(links.get(i).getText());
		 
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
