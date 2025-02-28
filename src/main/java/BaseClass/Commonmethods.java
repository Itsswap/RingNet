package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonmethods extends MasterPage{

	public Commonmethods() throws Exception {
		super();
		
	}
	public void WebElementClick(String xpathkey) {
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).click();
	}
	
	public void WebElementSendkeys(String xpathkey, String testdata) {
		driver.findElement(By.xpath(loc.getProperty(xpathkey))).sendKeys(td.getProperty(testdata));
	}
	
	public void waits()
	{
		//WebDriverWait waits=new WebDriverWait(driver, );
		
		
	}
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
	
	public void javascriptexe(String xpathkey)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpathkey));
		js.executeScript("");
		
	}
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
	
	
	public void dropdownbyvisibletext(String xpathkey, String testdata)
	{
		WebElement element=driver.findElement(By.xpath(xpathkey));
		Select s= new Select(element);
		s.selectByValue(td.getProperty(testdata));
	
	}
	
}
