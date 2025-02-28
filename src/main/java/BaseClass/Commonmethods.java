package BaseClass;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonmethods extends MasterPage{

	public Commonmethods() throws Exception {
		super();
		
	}
	//Screenshots
public String getScreenshot(String screenShotName) throws IOException 
{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenShotName + dateName + ".jpg";
		File finalDestination = new File(destination);	
		Source.renameTo(finalDestination);
		FileUtils.copyFile(Source, finalDestination);				
		return destination;
	}
    //Click
	public void WebElementClick(String xpathkey) {
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).click();
	}
	//Sendkeys
	public void WebElementSendkeys(String xpathkey, String testdata) {
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).sendKeys(td.getProperty(testdata));
	}
	//Waits
	public void waits(String xpathkeys)
	{
		WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(200));
		waits.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(xpathkeys))));
	}
	public void wait(String xpathkeys)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty(xpathkeys))));
	}
	//Actions
	public void actiononclick(String xpathkey)
	{
		Actions a = new Actions(driver);
		WebElement element=driver.findElement(By.xpath(loc.getProperty(xpathkey)));
		a.contextClick(element);
		
	}
	public void actionondoubleclick(String xpathkey)
	{
		Actions a = new Actions(driver);
		WebElement element=driver.findElement(By.xpath(loc.getProperty(xpathkey)));
		a.doubleClick(element);
		
	}
	public void dragdrop(String xpathkey)
	{
		Actions a = new Actions(driver);
		WebElement source=driver.findElement(By.xpath(loc.getProperty(xpathkey)));
		WebElement destination=driver.findElement(By.xpath(loc.getProperty(xpathkey)));
		a.dragAndDrop(source, destination);
		
	}
	public void actiononscroll(String xpathkey)
	{
		Actions a = new Actions(driver);
		WebElement element=driver.findElement(By.xpath(loc.getProperty(xpathkey)));
		a.click(element);
		
	}
	//Javascript
	public void javascriptexe(String xpathkey)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpathkey));
		js.executeScript("");
		
	}
	//Static DropDown
	public void dropdownbyvalue(String xpathkey, String testdata)
	{
		WebElement element=driver.findElement(By.xpath(xpathkey));
		Select s= new Select(element);
		s.selectByValue(td.getProperty(testdata));
	
	}
	public String dropdownbyid(String xpathkey, int index)
	{
		try {
		WebElement element=driver.findElement(By.xpath(xpathkey));
		Select select= new Select(element);
		if (index >= 0 && index < select.getOptions().size()) {
            
            WebElement option = select.getOptions().get(index);
            return option.getText();
        } else {
            System.out.println("Invalid index: " + index);
            return null;
        }
    } catch (Exception e) 
    {
        // Handle exception (e.g., element not found)
        System.out.println("Error retrieving dropdown value: " + e.getMessage());
        return null;
    }
	}
	
	//Dynamic DropDown
	public void dropdownbyvisibletext(String xpathkey, String testdata)
	{
		WebElement element=driver.findElement(By.xpath(xpathkey));
		Select s= new Select(element);
		s.selectByValue(td.getProperty(testdata));
	}
	
	public void dropdowndynamic(String xpath, String testdata)
	{
		
		List<WebElement> list= driver.findElements(By.xpath(xpath));
		int size=list.size();
		for(int i=0;i<=size;i++)
		{
			String excepted= td.getProperty(testdata);
			if(list.get(i).getText().equalsIgnoreCase(excepted))
			{
				list.get(i).click();
			}
			else
			{
				System.out.println("Not found data");
			}
		}			
	}	
}
