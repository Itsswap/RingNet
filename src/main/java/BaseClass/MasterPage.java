package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterPage {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Properties loc;
	public static Properties td;

	public MasterPage() throws Exception {
	
		FileInputStream fs = new FileInputStream(".\\src\\main\\resources\\Config\\config.properties");
		prop = new Properties();
		prop.load(fs);
		
		FileInputStream fs1 = new FileInputStream(".\\src\\main\\resources\\Config\\locators.properties");
		loc = new Properties();
		loc.load(fs1);
		
		FileInputStream fs2 = new FileInputStream(".\\src\\main\\resources\\Config\\testdata.properties");
		td = new Properties();
		td.load(fs2);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser not found !!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
				
		public void teardown()
		{
			
			
		}	

}
