package Com.DataDrivenFramework.TestCases;


import java.io.FileNotFoundException;

import java.util.Properties;

import Com.DataDrivenFramework.java.*;

public class Test extends BaseTest {
	private static Properties prop = BaseTest.getProperties();
	public static void main (String args[]) throws FileNotFoundException
	{
	
		System.out.println("hola");
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("mousemove_xpath"));
		
	}
	
}