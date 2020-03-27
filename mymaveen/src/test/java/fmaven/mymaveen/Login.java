package fmaven.mymaveen;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
	Logger log = Logger.getLogger(Login.class);
	@BeforeMethod
	public void setup()
	{
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
        driver=new ChromeDriver(options);
        driver.get("https://www.zoho.com/");
        driver.manage().window().maximize();	
	}
	
	@Test(priority=1)
	public void titleTest() {
	    String title = driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals(title, "Google");
	}
	@Test(priority=2)
	public void test1()
	{
		WebDriverWait driverwait= new  WebDriverWait(driver,100);
        //driverwait.until(ExpectedConditions.presenceOfElementLocated(By.id("geoLocPopUp")));
        driverwait.until(ExpectedConditions.presenceOfElementLocated(By.className("zh-customers")));
        driver.findElement(By.className("zh-customers")).click();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver.quit();
		
	}
}
