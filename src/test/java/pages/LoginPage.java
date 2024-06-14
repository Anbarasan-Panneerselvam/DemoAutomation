package pages;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.LoginPagePOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class LoginPage extends LoginPagePOM{
	 protected static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	    
	    private final LocalHelper localHelper = new LocalHelper();

	    private final WebDriver driver;
	    
	    public LoginPage(WebDriver driver) {
	        this.driver=driver;
	    }
	   
		public void enterUsername(String username) {
			localHelper.jsExecutorHighlight(userEmailBox, driver);
			localHelper.sendKeys(userEmailBox, username,driver);
		}
		public boolean CheckUsernameBox() {
			 localHelper.jsExecutorHighlight(userEmailBox, driver);
			 return driver.findElement(userEmailBox).isEnabled();
		 }
		public boolean CheckPasswordBox() {
			 localHelper.jsExecutorHighlight(userPasswordBox, driver);
			 return driver.findElement(userPasswordBox).isEnabled();
		 }
		public boolean CheckLoginbutton() {
			 localHelper.jsExecutorHighlight(loginButton, driver);			 
			 return driver.findElement(loginButton).isEnabled();
		 }
		public void enterPassword(String password) {
			localHelper.jsExecutorHighlight(userPasswordBox, driver);
			localHelper.sendKeys(userPasswordBox, password, driver);
		}
	    public void clickLoginButton() {
				try {
					localHelper.jsExecutorHighlight(loginButton, driver);
					localHelper.clickElement(loginButton, driver);
				}catch (ElementClickInterceptedException m) {
					localHelper.jsExecutorClick(loginButton, driver);
				}
				logger.info("Login button is clicked");
			}
		public String checkLoginSuccessMessage() {
			return localHelper.getText(loginSuccessMsg, driver);
		}
		public String checkInvalidCredentialErrorMessage() {
			return localHelper.getText(invalidUserCredentialErrorMsg, driver);
		}
		public String checkEmailIsRequiredErrorMessage() {
			localHelper.jsExecutorHighlight(userEmailBoxErrorMsg, driver);
			return localHelper.getText(userEmailBoxErrorMsg, driver);
		}
		public String checkPasswordIsRequiredErrorMessage() {
			localHelper.jsExecutorHighlight(userPasswordBoxErrorMsg, driver);
			return localHelper.getText(userPasswordBoxErrorMsg, driver);
		}
		public String checkInvalidEmailErrorMessage() {
			localHelper.jsExecutorHighlight(invalidEmailErrorMsg, driver);
			return localHelper.getText(invalidEmailErrorMsg, driver);
		}
		public void clickForgotPasswordButton() {
			try {
				localHelper.jsExecutorHighlight(forgotPassword, driver);
				localHelper.clickElement(forgotPassword, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(forgotPassword, driver);
			}
			logger.info("Forgot password button is clicked");
		}
		public void enterUserMail(String username) {
			localHelper.jsExecutorHighlight(forgotPasswordPageUserMailBox, driver);
			localHelper.sendKeys(forgotPasswordPageUserMailBox, username,driver);
		}
		public void enterNewPassword(String password) {
			localHelper.jsExecutorHighlight(forgotPasswordPageUserPasswordBox, driver);
			localHelper.sendKeys(forgotPasswordPageUserPasswordBox, password, driver);
		}
		public void enterConfirmNewPassword(String password) {
			localHelper.jsExecutorHighlight(forgotPasswordPageUserConfirmPasswordBox, driver);
			localHelper.sendKeys(forgotPasswordPageUserConfirmPasswordBox, password, driver);
		}
		public void clickSaveNewPasswordButton() {
			try {
				localHelper.jsExecutorHighlight(saveNewPasswordButton, driver);
				localHelper.clickElement(saveNewPasswordButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(saveNewPasswordButton, driver);
			}
			logger.info("Save new Password button is clicked");
		}
		public String checkPasswordChangedSuccessMessage() {
			return localHelper.getText(passwordChangedSuccessMsg, driver);
		}
		 public void enterUserPassword() throws IOException {
				localHelper.jsExecutorHighlight(userPasswordBox, driver);
				localHelper.sendKeys(userPasswordBox, TestUtil.readExcelWithGivenCellValueFromPropertyFile(), driver);
				logger.info("User password is entered from Excelfile");

			}
	
	

}
