package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListner implements ITestListener
{
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info on the report
	public ExtentTest test; //creating test cases entries in the report and update status of the test methhods.
	
	public void onStart(ITestContext context)
	{
		sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extentreport.html");
		sparkReporter.config().setDocumentTitle("Ringnet Report");	
		sparkReporter.config().setReportName("Daily CheckList");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "6011");
		extent.setSystemInfo("Tester Name", "Tejal Patel");
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("OS", "Windows 10");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED IS:" +result.getName());
			
	}
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED IS:" +result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is :" +result.getThrowable());
		
			
	}
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED IS:" +result.getName());
			
	}
	

}
