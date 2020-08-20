package Resuable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserdetails {

	public Properties prob;
	public WebDriver driver;
	
	
	public WebDriver browser() throws IOException
	{
		prob=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Saiful\\eclipse-workspace\\spicejet\\src\\main\\java\\Resuable\\spice.properties");
		prob.load(fis);
		String browsername=prob.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Saiful\\Desktop\\Selenium\\webdriver\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Saiful\\Desktop\\Selenium\\webdriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
}
