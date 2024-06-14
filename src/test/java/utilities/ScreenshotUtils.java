package utilities;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;

public class ScreenshotUtils extends BaseClass {
	 public static String captureScreenshot(ITestResult result) {
	            ExtentTest test = ExtentReportListener.getTest();
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	         // Convert the screenshot bytes to Base64
	            String base64Screenshot = Base64.getEncoder().encodeToString(screenshot);

	            // Get the test method name for the screenshot filename
	            String testName = result.getMethod().getMethodName();
	            String screenshotName = testName + "_screenshot.png";

	            // Embed the Base64-encoded screenshot directly in the HTML report
	            String embeddedScreenshot = "<img src='data:image/png;base64, " + base64Screenshot + "' />";

	            // Append the embedded screenshot to the report
	            test.addScreenCaptureFromBase64String(base64Screenshot);
	            test.info(embeddedScreenshot);

	            return screenshotName;
	        }
	  public static void captureScreenshotDirect() throws InterruptedException {
		  Thread.sleep(2000);
	            ExtentTest test = ExtentReportListener.getTest();
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	         // Convert the screenshot bytes to Base64
	            String base64Screenshot = Base64.getEncoder().encodeToString(screenshot);

	            // Get the test method name for the screenshot filename
	            String screenshotName = "testName" + "_screenshot.png";

	            // Embed the Base64-encoded screenshot directly in the HTML report
	            String embeddedScreenshot = "<img src='data:image/png;base64, " + base64Screenshot + "' />";

	            // Append the embedded screenshot to the report
	            test.addScreenCaptureFromBase64String(base64Screenshot);
	            test.info(embeddedScreenshot);

	        }

}
