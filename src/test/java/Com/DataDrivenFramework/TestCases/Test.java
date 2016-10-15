package Com.DataDrivenFramework.TestCases;

import java.io.FileInputStream;
import java.util.Properties;

public class Test extends BaseTest {
	public static Properties prop1;
	public static void main (String args[])
	{
		System.out.println("hola");
		System.out.println(prop1.getProperty("appurl"));
	}
	public void init(){
		//init the prop file
		if(prop1==null){
			prop1=new Properties();
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties.properties");
				prop1.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
