package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import utilities.ExtentReportListener;
import utilities.ExtentReportManager;
import utilities.LocalHelper;
import utilities.TestUtil;

@Listeners(ExtentReportListener.class)
public class BaseClass {
	protected static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
	private final LocalHelper localHelper = new LocalHelper();
    protected EmailAttachment attachment;
    protected MultiPartEmail email;
	public static WebDriver driver;
	
	private ArrayList<String> testStatusList = new ArrayList<>();
	public ExtentReportListener extentReportListener;
    ExtentReports extent = ExtentReportManager.getInstance();
    
    @BeforeMethod(alwaysRun = true)
	protected void SetUp() throws IOException {
		localHelper.loadProperties();
		String browser=Constants.Browser;
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"DriverFolder"+File.separator+"chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")){
			  WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
			logger.error("Please check the Browser name");
		logger.info(browser+" BROWSER WAS STARTED SUCCESSFULLY");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constants.App_url);
		extentReportListener=new ExtentReportListener(driver);	
	    
	}
    
	@AfterSuite(alwaysRun = true)
	public void sendEmail()throws EmailException {
        
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Test Results: ");

        for (String results : testStatusList) {
        	 emailContent.append(results).append(" "); 
        }
	 	EmailAttachment  attachment = new EmailAttachment();
	 	attachment.setPath(System.getProperty("user.dir") + File.separator + "extented.html");
	 	attachment.setDisposition(EmailAttachment.ATTACHMENT);
	 	attachment.setDescription("Selenium Report");
	 	attachment.setName("reports.html");
	 	//Send an Email
	    email = new MultiPartEmail();
	    email.setHostName("smtp.mail.yahoo.com");
	    email.setSmtpPort(465);
	 	email.setSSLOnConnect(true);
	 	email.setAuthentication("anbarasan_ps@yahoo.com","xlsjlkhdebdysjdv");
	 	email.setFrom("anbarasan_ps@yahoo.com");
	    email.addTo("anbarasan.psk@gmail.com");
	 	email.setMsg("Hi sir, Automated Mail");
	 	email.setSubject("Demo-"+emailContent.toString()+"- "+dateAndTime());
	 	email.setSocketConnectionTimeout(60000);
	    //Timeout for sending email
	    email.setSocketTimeout(60000);
	 	email.attach(attachment);
	 	try {
	 	    email.send();
	 	    System.out.println("Email sent successfully");
	 	} catch (EmailException e) {
	 	    e.printStackTrace();
	 	    System.out.println("Error sending email: " + e.getMessage());
	 	}
	 	logger.info("Send Email method ");
	 	
	 	}
	@AfterMethod(alwaysRun = true)
	protected void tearDown(ITestResult result) throws EmailException {
		logger.info(("[tearDown]"));
		if(result.getStatus()==ITestResult.FAILURE||result.getStatus()==ITestResult.SKIP){
			try {
				TestUtil.getScreenshot(driver, String.valueOf(result.getName()));
				attachScreenshotsToAllureReport(driver);
				attachLog(String.valueOf(result.getMethod()).replaceAll("[()]",""));
				logger.info("Screenshot taken for Failed TC");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			attachLog(String.valueOf(result.getMethod()).replaceAll("[()]",""));
		}
		 if(result.getStatus() == ITestResult.FAILURE) {
		        testStatusList.add(getResultStatus(result.getStatus()));
			    }
		driver.quit();
		extent.flush();
	}
	 private String getResultStatus(int status) {
	      switch (status) {
	        case ITestResult.SUCCESS:
	            return "PASSED: " ;
	        case ITestResult.FAILURE:
	            return "FAILED: " ;
	        case ITestResult.SKIP:
	             return "SKIPPED: ";
	        default:
	             return "UNKNOWN: ";
	        }
	
}

	@Attachment(value = "Failed TC Screenshot",type = "image/png")
	public void attachScreenshotsToAllureReport(WebDriver driver){
		((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}",type = "text/plain")
	public static void attachLog(String message){
		logger.info(message);
	}
	
	public String dateAndTime() {
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        //Date format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMMyyyy h.mma");
	        String formattedDateTime = currentDateTime.format(formatter);
            return formattedDateTime;
		
	}
   
}

