package utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import baseClass.BaseClass;
import constants.Constants;
import io.qameta.allure.Allure;

public class TestUtil extends BaseClass{
	 private Properties prop;
	 
	    public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
	                + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        ExtentReportListener.test.addScreenCaptureFromPath(destination);
	        String attachmentName = "Screenshot_" + System.currentTimeMillis();
	        Allure.addAttachment(attachmentName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	    }
	    
	    public Properties init_Properties(){
	        prop = new Properties();
	        try {
	            FileInputStream inputStream=new FileInputStream("./src/test/resources/config.properties");
	            prop.load(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }

	    public static String readExcelWithGivenCellValueFromPropertyFile() throws IOException {
	   	 
	        String excelFilePath =System.getProperty("user.dir")+"\\UserData.xlsx";
	        String sheetName = "Sheet1";
	        String password = null;
	      
	            FileInputStream fileInputStream = new FileInputStream(excelFilePath);
	            Workbook workbook = new XSSFWorkbook(fileInputStream);
	            Sheet sheet = workbook.getSheet(sheetName);

	            int searchColumnIndex = 1;  
	            String searchValue = Constants.username;
	            for (Row row : sheet) {
	                Cell cell = row.getCell(searchColumnIndex);
	                if (cell != null) {
	                    String cellValue = cell.getStringCellValue();
	                    if (cellValue.equals(searchValue)) {
	                    	password = row.getCell(2).getStringCellValue();
	                        
	                    }
	                }
	            }
	            workbook.close();
	            fileInputStream.close();
	    		return password;
	        
	    }
	   

}
