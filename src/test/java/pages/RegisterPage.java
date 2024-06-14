package pages;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.RegisterPagePOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class RegisterPage extends RegisterPagePOM {
	 protected static final Logger logger = LoggerFactory.getLogger(RegisterPage.class);
	    
	    private final LocalHelper localHelper = new LocalHelper();

	    private final WebDriver driver;
	    
	    public RegisterPage(WebDriver driver) {
	        this.driver=driver;
	    }
	    public void clickRegisterButton() {
			try {
				localHelper.jsExecutorHighlight(registerHereButton, driver);
				localHelper.clickElement(registerHereButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(registerHereButton, driver);
			}
			logger.info("Login button is clicked");
		}
	    public void enterRegisterPageFirstName() {
			localHelper.jsExecutorHighlight(registerPageFirstNameBox, driver);
			localHelper.sendKeys(registerPageFirstNameBox,new TestUtil().init_Properties().getProperty("firstname"),driver);
			logger.info("Firstname passed in the Register page firstname box");
		}
	    public void enterRegisterPageFirstNameMaximumChracters() {
			localHelper.jsExecutorHighlight(registerPageFirstNameBox, driver);
			localHelper.sendKeys(registerPageFirstNameBox,new TestUtil().init_Properties().getProperty("firstnamemax"),driver);
			logger.info("Firstnamemax passed in the Register page firstname box");
		}
	    public void enterRegisterPageLastName() {
			localHelper.jsExecutorHighlight(registerPageLastNameBox, driver);
			localHelper.sendKeys(registerPageLastNameBox,new TestUtil().init_Properties().getProperty("lastname"),driver);
			logger.info("Lastname passed in the Register page Lastname box");
		}
	    public void enterRegisterPageLastNameMinimumChracters() {
			localHelper.jsExecutorHighlight(registerPageLastNameBox, driver);
			localHelper.sendKeys(registerPageLastNameBox,new TestUtil().init_Properties().getProperty("lastnamemin"),driver);
			logger.info("Lastnamemin passed in the Register page Lastname box");
		}
	    public void enterEmailId(String emailid) {
			localHelper.jsExecutorHighlight(registerPageUserEmailBox, driver);
		    localHelper.sendKeys(registerPageUserEmailBox,emailid, driver);
			logger.info("Email id passed in the Email box");
		}
	    public void enterPhoneNumber(String phonenum) {
			localHelper.jsExecutorHighlight(registerPageUserPhoneNumBox, driver);
			localHelper.sendKeys(registerPageUserPhoneNumBox,phonenum,driver);
			logger.info("Phone number passed in the Phone number box");
		}
	    public void enterOccupationDoctor() {
			localHelper.clickElement(registerPageOccupationDropdown, driver);
			localHelper.clickElement(registerPageOccupationDoctor, driver);
			logger.info("Occupation Doctor is clicked");
		}
	    public void enterOccupationStudent() {
			localHelper.clickElement(registerPageOccupationDropdown, driver);
			localHelper.clickElement(registerPageOccupationStudent, driver);
		    logger.info("Occupation Student is clicked");
	    }
	    public void enterOccupationEngineer() {
			localHelper.clickElement(registerPageOccupationDropdown, driver);
			localHelper.clickElement(registerPageOccupationEngineer, driver);
		    logger.info("Occupation Engineer is clicked");
	    }
	    public void enterOccupationScientist() {
			localHelper.clickElement(registerPageOccupationDropdown, driver);
			localHelper.clickElement(registerPageOccupationScientist, driver);
		    logger.info("Occupation Engineer is clicked");
	    }
	    public void clickGenderMaleRadioButton() {
			try {
				localHelper.clickElement(registerPageGenderMaleRadioButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(registerPageGenderMaleRadioButton, driver);
			}
			logger.info("Gender Male radio button is clicked");
		}
	    public void clickGenderFemaleRadioButton() {
			try {
				localHelper.clickElement(registerPageGenderFemaleRadioButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(registerPageGenderFemaleRadioButton, driver);
			}
			logger.info("Gender Female radio button is clicked");
		}
	    public void enterRegisterPagePassword(String password) {
			localHelper.jsExecutorHighlight(registerPageUserPasswordBox, driver);
			localHelper.sendKeys(registerPageUserPasswordBox, password, driver);
		}
	    public void enterRegisterPageConfirmPassword(String password) {
			localHelper.jsExecutorHighlight(registerPageUserConfirmPasswordBox, driver);
			localHelper.sendKeys(registerPageUserConfirmPasswordBox, password, driver);
		}
	    public void clickRegisterPageAgeCheckbox() {
			try {
				localHelper.clickElement(registerPageAgeCheckbox, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(registerPageAgeCheckbox, driver);
			}
			logger.info("Register page age checkbox is clicked");
		}
	    public void clickRegisterPageSubmitButton() {
			try {
				localHelper.jsExecutorHighlight(registerPageSubmitButton, driver);
				localHelper.clickElement(registerPageSubmitButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(registerPageSubmitButton, driver);
			}
			logger.info("Register page Submit button is clicked");
		}
	    public String checkRegisteredSuccessMessage() {
			return localHelper.getText(registeredSuccessMsg, driver);
		}
	    public String checkAccountCreatedSuccessMessage() {
	    	localHelper.jsExecutorHighlight(accountCreatedSuccessMsg, driver);
			return localHelper.getText(accountCreatedSuccessMsg, driver);
		}
	    public void clickAfterRegisterLoginButton() {
			try {
				localHelper.jsExecutorHighlight(afterRegLoginButton, driver);
				localHelper.clickElement(afterRegLoginButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(afterRegLoginButton, driver);
			}
			logger.info("After Registered Login button is clicked");
		}
	    public String checkFirstnameBoxErrorMessage() {
	    	localHelper.jsExecutorHighlight(firstnameErrorMsg, driver);
			return localHelper.getText(firstnameErrorMsg, driver);
		}
	    public String checkLastnameBoxErrorMessage() {
	    	localHelper.jsExecutorHighlight(lastnameErrorMsg, driver);
			return localHelper.getText(lastnameErrorMsg, driver);
		}
	    public String checkEmailBoxErrorMessage() {
	    	localHelper.jsExecutorHighlight(emailErrorMsg, driver);
			return localHelper.getText(emailErrorMsg, driver);
		}
	    public String checkPhoneNumBoxErrorMessage() {
	    	localHelper.jsExecutorHighlight(phoneNumErrorMsg2, driver);
			return localHelper.getText(phoneNumErrorMsg2, driver);
		}
	    public String checkPasswordBoxErrorMessage() {
	    	localHelper.jsExecutorHighlight(passwordErrorMsg, driver);
			return localHelper.getText(passwordErrorMsg, driver);
		}
	

}
