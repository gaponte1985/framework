package Com.DataDrivenFramework.TestCases;

import java.io.IOException;
import Com.DataDrivenFramework.TestCases.BaseTest;
import org.testng.annotations.Test;



public class DummyTestC extends BaseTest{
	
	@Test
	public void testC1() throws IOException{
		
		openBrowser("firefox");
		url("http://www.gmail.com");
		type("email_path", "ing.aponte@gmail.com");
		click("button_xpath");
		
	}

}
