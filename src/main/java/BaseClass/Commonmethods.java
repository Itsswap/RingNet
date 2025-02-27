package BaseClass;

import org.openqa.selenium.By;

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
	
	//public void waits()
	{
		//sWebDriverWaits waits=new WebD
	}

}
