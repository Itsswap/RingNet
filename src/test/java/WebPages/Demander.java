package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.Commonmethods;

public class Demander extends Commonmethods{

	public Demander() throws Exception {
		super();
	}
	
	public void ToVerifyDemanderTabClick()
	{
		WebElementClick("demandertab");
	}
	public void ToVerifyDemanderSearch()
	{
		WebElementClick("demandersearch");
	}
	
	public void ToVerifyDoubleclickOnDemander()
	{
		List<WebElement> data= driver.findElements(By.xpath("//table[@id='grid_169915252_0_content_table']//tbody//tr"));
		int size=data.size();
		String excepted= td.getProperty("demandername");
		
		for(int i=0;i<size;i++) 
		{
			if(data.get(i).getText().equalsIgnoreCase(excepted))
			{
				data.get(i).click();
			}
			else 
				System.out.println("Data does not matched");
		}
				
	}
	public void ToVerifyOpenDemander()
	{
		WebElementClick("demanderopen");
	}
	
	

}
