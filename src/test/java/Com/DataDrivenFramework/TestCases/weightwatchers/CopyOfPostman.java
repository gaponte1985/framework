package Com.DataDrivenFramework.TestCases.weightwatchers;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class CopyOfPostman {
	

		  public static void main(String[] args) {
			  
		 WebDriver driver = null;

		  System.setProperty("webdriver.chrome.driver", "/Users/aponte/Documents/workspace/TheJamStopDDF/DataDrivenFramework/chromedriver");
		 //   WebDriver driver = new ChromeDriver();
		    
		    ChromeOptions chromeOptions = new ChromeOptions();
		    chromeOptions.addExtensions(new File("/Users/aponte/Documents/workspace/TheJamStopDDF/DataDrivenFramework/Postman_v4.9.2.crx"));
		    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
		    driver = new ChromeDriver(desiredCapabilities);
		    
		    driver.get("https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en-US");
		   
		    
		    WebElement element = null;
		    
		    WebDriverWait wait = new WebDriverWait(driver, 60);
		    element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/html/body/div[6]/div[1]/div/div/div[2]/div[3]/div[1]/div/div/div[2]"))));
		    driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div[2]/div[3]/div[1]/div/div/div[2]")).click();
		    element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(" /html/body/div[16]/div/div/div/div/div/div/div/div[7]/div/span[1]"))));
		    driver.findElement(By.xpath(" /html/body/div[16]/div/div/div/div/div/div/div/div[7]/div/span[1]")).click();
		   
		  
		}

		}

