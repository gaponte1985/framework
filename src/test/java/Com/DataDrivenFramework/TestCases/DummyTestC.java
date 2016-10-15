package Com.DataDrivenFramework.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;



public class DummyTestC extends BaseTest{
	
	@Test
	public void testC1() throws IOException{
		
		openBrowser("firefox");
		
		navigate("http://gmail.com");
		
		
	}

}
