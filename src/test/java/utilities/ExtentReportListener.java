package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener extends TestListenerAdapter{
	 public static ExtentTest test;
	    public static ExtentTest getTest() {
	    	return test;
	    }
	    public WebDriver driver;
	    public ExtentReportListener() {
	    }

	    public ExtentReportListener(WebDriver driver) {
	        this.driver = driver;
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = ExtentReportManager.createTest(result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test failed");
	        String screenshotPath = ScreenshotUtils.captureScreenshot(result);
	       
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test passed");
	    }

}

