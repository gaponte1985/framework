package Com.DataDrivenFramework.Utilites;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {

			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(System.getProperty("user.dir")+"/reports/"+fileName, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/Com/DataDrivenFramework/Utilites/ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.1").addSystemInfo(
					"Environment", "Demo");
		
		return extent;
	}
}
