package Com.DataDrivenFramework.TestCases;

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



public class DummyCNNTest extends BaseTest {
	
	private static Properties prop = BaseTest.getProperties();
	private static Properties url = BaseTest.getProperties();
	private static ExtentReports extent;
	private static ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	 
	@BeforeTest
	public void before() throws IOException{
		test = rep.startTest("Cnn");
		openBrowser("browser");
		 test.log(LogStatus.INFO, "Starting the test");
		// test.log(LogStatus.FAIL, "Failing the test");
		// test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));
	}
	
	@Test 
	public void start() throws IOException, InterruptedException{
		
		
		url("cnn");
		
		test.log(LogStatus.INFO, "Going to cnn.com");
		
	//    test.log(LogStatus.FAIL, "Not able to go cnn.com");
	//    test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));
		
		 mouseMove("mousemove_xpath");
		 test.log(LogStatus.INFO, "Moving my mouse");
	//	 test.log(LogStatus.FAIL, "Not able to Moved my mouse");
	//	 test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));
		 
		 WebElement links = driver.findElement(By.xpath(prop.getProperty("mousemove_xpath")));
		 List<WebElement> namesLinks = links.findElements(By.tagName("a"));
		 test.log(LogStatus.INFO, "Getting the list of links");
		 System.out.println("Total links -----"+ namesLinks.size());
		 test.log(LogStatus.INFO, "Number of links present: " +namesLinks.size());
	//	 test.log(LogStatus.FAIL, "Not able to get the list of links");
	//	 test.log(LogStatus.FAIL,  "Screenshot the test" + test.addScreenCapture(System.getProperty("user.dir") +"/screenshots/photo.png/"));


				for(int i= 0; i< namesLinks.size();i++)
				{
				String frnd = namesLinks.get(i).getText();
				if (!frnd.trim().equals("")){
					System.out.println(frnd);
					 test.log(LogStatus.INFO, "Link # " +i+ " \n Linked name: " +frnd);
				//	 test.log(LogStatus.FAIL, "Not able to get the list of links");
				}
			}
				
	}
	@AfterTest
	public void end()
	{
		close("cnn");
		test.log(LogStatus.INFO, "Closing the browser");
		//test.log(LogStatus.FAIL, "Not able to get the list of links");
		rep.endTest(test);
		rep.flush();

		
	}

}
