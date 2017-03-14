package Com.DataDrivenFramework.TestCases;

import java.io.IOException;
import Com.DataDrivenFramework.java.*;
import org.testng.annotations.Test;


public class DummyTestA extends BaseTest {
	
	@Test(priority=1)
	public void testA1() throws IOException{
		//openBrowser(prop.getProperty("browser"));
	//	System.out.println(prop.getProperty("browser"));
	
	}
	
	@Test(priority=2, dependsOnMethods={"testA1"})
	public void testA2(){
		
	}
	
	@Test(priority=3, dependsOnMethods={"testA1", "testA2"})
	public void testA3(){
		
	}

}
