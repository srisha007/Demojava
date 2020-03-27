package fmaven.mymaveen;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Logger log = Logger.getLogger(App.class);
    	log.info("Started");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\workspace\\mymaveen\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("enable-automation"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--disable-browser-side-navigation"); 
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
        //options.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension"));
                //DesiredCapabilities caps = DesiredCapabilities.chrome(); 
        //caps.setCapability(ChromeOptions.CAPABILITY, options); 
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://www.zoho.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait driverwait= new  WebDriverWait(driver,100);
        //driverwait.until(ExpectedConditions.presenceOfElementLocated(By.id("geoLocPopUp")));
        driverwait.until(ExpectedConditions.presenceOfElementLocated(By.className("zh-customers")));
        driver.findElement(By.className("zh-customers")).click();
        log.info("Ended");
        
    }
}
