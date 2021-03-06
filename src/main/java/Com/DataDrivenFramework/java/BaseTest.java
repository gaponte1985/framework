package Com.DataDrivenFramework.java;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opera.core.systems.OperaDriver;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;

import Com.DataDrivenFramework.Utilites.ExtentManager;

public class BaseTest {

	public WebDriver driver;
	public static ExtentTest test;
	public static ExtentTest ExtentReporter;
	public static ExtentReports screenshotFile;
	public static ExtentReports extent;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static Properties prop = new Properties();
	public static String Dire = System.getProperty("user.dir");
	public static File scrFile;
	public Actions act;
	private static Logger log = Logger.getLogger(BaseTest.class.getName());

	public void setLogger(ExtentTest test2) {
		test = test2;
	}

	public static Properties getProperties() {

		FileInputStream fileInput;

		File file = new File("/Users/aponte/Documents/workspace/TheJamStopDDF/DataDrivenFramework/src/test/resources/Com/DataDrivenFramework/Utilites/Properties.properties");

		try {

			fileInput = new FileInputStream(file);
		} catch (IOException ioe) {
			System.out.println(ioe.toString());
			return null;
		}

		// load properties file
		try {
			prop.load(fileInput);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public WebDriver openBrowser(String browserName) throws IOException {

		if (prop.getProperty(browserName).equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.debug("firefox ");
			log.info("hello world");
		} else if (prop.getProperty(browserName).equalsIgnoreCase(
				"firefoxprofile")) {

			ProfilesIni profile = new ProfilesIni();

			FirefoxProfile myprofile = profile.getProfile("aponte");

			driver = new FirefoxDriver(myprofile);
		} else if (prop.getProperty(browserName).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		} else if (prop.getProperty(browserName).equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver",
					".//Utilites//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (prop.getProperty(browserName).equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver",
					".//Utilites//operadriver.exe");
			driver = new OperaDriver();
		} else if (prop.getProperty(browserName).equalsIgnoreCase("html")) {
			driver = new HtmlUnitDriver();
		} else {
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public String navigate(String urlKey) {
		driver.navigate().to(prop.getProperty(urlKey));
		log.debug("urlKey ");
		log.info("urlKey world");
		return urlKey;
	}

	public String navigateBack(String urlKey) {
		driver.navigate().back();
		return navigateBack(null);
	}

	public String navigateFoward(String urlKey) {
		driver.navigate().forward();
		return navigateFoward(null);
	}

	public String url(String urlKey) {

		driver.get(prop.getProperty(urlKey));
		log.debug("urlKey ");
		log.info("urlKey world");
		return urlKey;

	}

	public void close(String urlKey) {

		driver.close();
	}

	public void quit(String urlKey) {

		driver.quit();

	}

	public void click(String locatorKey) throws IOException {
		getElement(locatorKey).click();

	}

	public void type(String locatorKey, String Data) throws IOException {
		getElement(locatorKey).sendKeys(Data);
	}

	public void clear(String locatorKey, String Data) throws IOException {
		getElement(locatorKey).clear();
	}

	// This methods is the one that will send a click or send keys or clear
	public WebElement getElement(String locatorKey) throws IOException {
		WebElement e = null;

		try {
			if (locatorKey.endsWith("_id")) {
				e = driver.findElement(By.id(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_name")) {
				e = driver.findElement(By.name(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_xpath")) {
				e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_css")) {
				e = driver.findElement(By.cssSelector(prop
						.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_link_text")) {
				e = driver
						.findElement(By.linkText(prop.getProperty(locatorKey)));
			}

			else {
				reportFailure("Locator not correct" + locatorKey);
				Assert.fail("Failed the test: " + locatorKey);
			}
			return e;
		} catch (Exception ex) {
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test: " + ex.getMessage());
		}
		return e;
	}

	public void SelectDate(String Date) throws IOException, ParseException {
		// convert the string date(input) in a date object
		click("dateTextField");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		Date dateToBeSelected = sdf.parse(Date);
		Date currentDate = new Date();
		sdf = new SimpleDateFormat("MMMM");
		String monthToBeSelect = sdf.format(dateToBeSelected);
		sdf = new SimpleDateFormat("yyyy");
		String yearToBeSelect = sdf.format(dateToBeSelected);

		String monthYearToBeSelect = monthToBeSelect + " " + yearToBeSelect;

		while (true) {
			if (currentDate.compareTo(dateToBeSelected) == 1) {

			} else if (currentDate.compareTo(dateToBeSelected) == -1) {
				click("back_xpath");
			}
			if (monthYearToBeSelect.equals(getText("xpath"))) {
				click("foward_xpath");
			}
		}
	}

	public WebElement mouseMove(String locatorKey) throws IOException {
		act = new Actions(driver);
		WebElement icon = getElement(locatorKey);
		
		act.dragAndDropBy(icon, 50, 0).build().perform();
		return icon;
	}

	/****************************************** Validations ******************************************/

	public boolean verifyTtile(String locatorKey, String ecpectedTextKey) {

		return false;

	}

	public boolean isElementPresent(String locatorKey) throws IOException {

		List<WebElement> elementList = null;

		if (locatorKey.endsWith("_id")) {
			elementList = driver.findElements(By.id(prop
					.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_name")) {
			elementList = driver.findElements(By.name(prop
					.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_xpath")) {
			elementList = driver.findElements(By.xpath(prop
					.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_css")) {
			elementList = driver.findElements(By.cssSelector(prop
					.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_link_text")) {
			elementList = driver.findElements(By.linkText(prop
					.getProperty(locatorKey)));
			
		}

		else {
			reportFailure("Locator not correct" + locatorKey);
			Assert.fail("Failed the test: " + locatorKey);
		}
		if (elementList.size() == 0) {
			return true;
		} else
			return true;

	}

	public boolean verifyText(String locatorKey, String expectedTextKey)
			throws IOException {
		String actualText = getElement(locatorKey).getText().trim();
		String expectedText = prop.getProperty(expectedTextKey);
		if (actualText.equals(expectedText)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickAndWait(String locator_clicked, String locator_pres)
			throws IOException {
		int count = 5;
		for (int i = 0; i < count; i++) {
			getElement(locator_clicked).click();
			wait(2);
			if (isElementPresent(locator_pres))
				break;
		}
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document...ready");

		while (state.equals("complete")) {
			wait(2);
			state = (String) js.executeScript("return document...ready");

		}
	}

	public void wait(int timeToWait) {
		try {
			Thread.sleep(timeToWait * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getText(String locatorKey) throws IOException {
		test.log(LogStatus.INFO, "Getting text from: " + locatorKey);
		return getElement(locatorKey).getText();

	}

	/******************************************
	 * Reporting
	 * 
	 * @return
	 * @throws InterruptedException
	 *****************************************************/

	public void reportPass(String msg) {
		test.log(LogStatus.PASS, msg);
	}

	public void reportFailure(String msg) {
		test.log(LogStatus.FAIL, msg);
		takeScreenShot();
		Assert.fail(msg);
	}

	public void takeScreenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_")
				.replace(" ", "_")
				+ ".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshots//", screenshotFile));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.INFO, "Unable to log screenshot");

		}

		test.log(
				LogStatus.INFO,
				"Screenshot-> "
						+ test.addScreenCapture(System.getProperty("user.dir")
								+ "/screenshots/" + screenshotFile));

	}


	

	/****************************************** Windows Handles *****************************************************/
	protected WebDriver handlePopups(String browserName) throws IOException {

		Set<String> windowIds = driver.getWindowHandles();
		System.out.println("Total windows opened -> " + windowIds.size());
		Iterator<String> it = windowIds.iterator();
		System.out.println(it.next());
		System.out.println("-------------------------");
		navigate(browserName);
		// popup
		windowIds = driver.getWindowHandles();
		System.out.println("Total windows opened -> " + windowIds.size());
		if (windowIds.size() > 1) {
			it = windowIds.iterator();
			String mainWindow = it.next();
			String popupWindow = it.next();
			System.out.println(mainWindow);
			System.out.println(popupWindow);
			driver.switchTo().window(popupWindow);
			driver.switchTo().activeElement();// IE
			driver.close(); // closes the window on which focus is there
			return driver.switchTo().window(mainWindow);
		} else {
			return driver;
		}
	}

	protected WebDriver handleAlert(String browserName) throws IOException {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		return driver;
	}

	protected WebDriver SSLCertificateHandle(String browsername)
			throws IOException {

		if ((browsername).equalsIgnoreCase("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			WebDriver driver = new FirefoxDriver(profile);
		}
		if ((browsername).equalsIgnoreCase("IE")) {
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver", "IE driver path");
			WebDriver driver = new InternetExplorerDriver(cap);
		}
		if ((browsername).equalsIgnoreCase("Chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			WebDriver driver = new ChromeDriver(cap);
		}
		if ((browsername).equalsIgnoreCase("Safari")) {

			DesiredCapabilities cap = DesiredCapabilities.safari();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.safari.driver", "Safari driver path");
			WebDriver driver = new SafariDriver(cap);
		}
		return driver;
	}

}
