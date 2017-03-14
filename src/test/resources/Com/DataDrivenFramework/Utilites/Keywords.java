package Com.DataDrivenFramework.Utilites;
import java.io.IOException;

import Com.DataDrivenFramework.java.BaseTest;


public class Keywords {
	public static void main(String[] arg) throws IOException
	{
		BaseTest app = new BaseTest();
		app.openBrowser(" ");
		app.navigate("http://google.com");
		
	}

}
