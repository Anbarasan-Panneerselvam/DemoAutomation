package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.Constants;

public class LocalHelper {
	public static int timeOutInSeconds = 40;
	public static int minTime = 20;
	public static int avgTime = 50;
	protected static final Logger logger = LoggerFactory.getLogger(LocalHelper.class);
	protected static List<WebElement> elementList;

	public void clickElement(By element, WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			driver.findElement(element).click();
		}catch (NoSuchElementException | TimeoutException e){
			logger.error("Error found on click Element.");
			logger.error(e.getMessage());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.findElement(element).click();
		}catch (ElementClickInterceptedException e){
			logger.error("Error found on click Element : ElementClickInterceptedException");
			logger.info("Element : ");
			logger.info(String.valueOf(element));
			jsExecutorClick(element,driver);
		}
	}
	public void sendKeys(By element_by,String text,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		try {
			WebElement element = driver.findElement(element_by);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			} catch (NoSuchElementException | TimeoutException e) {
				logger.error("No such element exception or Time out exception  on sendKeys");
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				logger.info("We found the element on second time");
			}
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element_by));
				element.click();
			} catch (ElementClickInterceptedException e) {
				WebDriverWait wait2 = new WebDriverWait(driver, minTime);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				wait2.until(ExpectedConditions.elementToBeClickable(element_by));
				scrollIntoView(element_by, driver);
				jsExecutorClick(element_by, driver);
			}
			try {
				element.clear();
				element.sendKeys(text);
			} catch (NoSuchElementException | TimeoutException e) {
				logger.error("Time out Exception or no such element exception found on ");
				logger.info(String.valueOf(element_by));
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				element.clear();
				element.sendKeys(text);
			}
		}catch (NoSuchElementException e){
			logger.info("Send Keys - No such element exception");
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}
	public String getText(By element_by,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			return element.getText();
		}catch(NoSuchElementException | TimeoutException e) {
			logger.error("Time out exception or No such element exception");
			WebElement element = driver.findElement(element_by);
			WebDriverWait wait2 = new WebDriverWait(driver, avgTime);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait2.until(ExpectedConditions.presenceOfElementLocated(element_by));
			return element.getText();
		}
	}

	public void jsExecutorClick(By element_by,WebDriver driver){
		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		wait.until(ExpectedConditions.elementToBeClickable(element_by));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(element_by);
		js.executeScript("arguments[0].click()",element);
		logger.info("Button clicked using Js Executor");
	}
	
	public void jsExecutorHighlight(By element_by,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
		wait.until(ExpectedConditions.elementToBeClickable(element_by));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(element_by);
		js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid yellow;');", element);
		logger.info("Button Highlighted using Js Executor");
	}
	public void scrollIntoView(By element_by, WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		WebElement element = driver.findElement(element_by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
		wait.until(ExpectedConditions.elementToBeClickable(element_by));
	}
	
	public void closeTab(WebDriver driver){
		driver.close();
	}
	public String readPropertyFile(String key) throws IOException {
	     String filePath = System.getProperty("user.dir")+ File.separator + "src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"config.properties";
		FileInputStream stream=new FileInputStream(new File(filePath));
		Properties properties=new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}
	public void loadProperties() throws IOException {
	    String filePath = System.getProperty("user.dir")+ File.separator + "src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"config.properties";
		FileInputStream stream=new FileInputStream(new File(filePath));
		Properties properties=new Properties(); 
		properties.load(stream);
		Constants.App_url=properties.getProperty("appurl");
		Constants.Browser=properties.getProperty("browser");
		Constants.username=properties.getProperty("username");
		Constants.password=properties.getProperty("password");
		Constants.wrongpassword=properties.getProperty("wrongpassword");
	}
	public void clickEnterUsingRobot() throws AWTException, InterruptedException {
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
