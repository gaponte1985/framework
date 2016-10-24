package Com.DataDrivenFramework.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import Com.DataDrivenFramework.java.*;
import Com.DataDrivenFramework.java.*;

public class DummyTestC extends BaseTest{
	
	@Test
	public void testC1() throws IOException{
		
		openBrowser("chrome");
		url("http://www.gmail.com");
		type("email_path", "ing.aponte@gmail.com");
		click("button_xpath");
		
	}

}
