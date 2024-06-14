package com.demoAutomationProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import baseClass.BaseClass;
import constants.Constants;
import pages.RegisterPage;

public class RegisterPageVerification extends BaseClass {
	Faker faker = new Faker();
	public static String emailid;
	private RegisterPage registerPage;
	

	@Test(priority = 0,groups = {"Smoke" ,"Positive",},enabled = true)
	public void verifyUserRegisterPageWithFilledAllDetails() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstName();
		registerPage.enterRegisterPageLastName();
		emailid=faker.name().firstName()+".demo123@mailinator.com";
		registerPage.enterEmailId(emailid);
		registerPage.enterPhoneNumber(faker.number().digits(10));
		registerPage.enterOccupationDoctor();
		registerPage.enterOccupationStudent();
		registerPage.enterOccupationEngineer();
		registerPage.enterOccupationScientist();
		registerPage.clickGenderMaleRadioButton();
		registerPage.enterRegisterPagePassword(Constants.password);
		registerPage.enterRegisterPageConfirmPassword(Constants.password);
		registerPage.clickRegisterPageAgeCheckbox();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking Register sucessfully or not ");
		Assert.assertEquals(registerPage.checkRegisteredSuccessMessage(),"Registered Successfully","Assertion failure on verifying Register page ");
		logger.info("Registered succesfully");
		extentReportListener.test.log(Status.INFO, "user registered successfuly verified");
		logger.info("Checking Account created sucessfully or not ");
		Assert.assertEquals(registerPage.checkAccountCreatedSuccessMessage(),"Account Created Successfully","Assertion failure on verifying Register page ");
		logger.info("Account created succesfully");
		extentReportListener.test.log(Status.INFO, "Account created successfully verified");
		
	}
	@Test(priority = 1,groups = {"Negative"},enabled = true)
	public void verifyUserRegisterPageFirstnameWithMaximumCharacter() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstNameMaximumChracters();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking Firstname box indicating error msg or not ");
		Assert.assertEquals(registerPage.checkFirstnameBoxErrorMessage(),"*First Name must be 12 or less character long","Assertion failure on verifying Register page ");
		logger.info("Firstname box error msg received ");
		extentReportListener.test.log(Status.INFO, "First name filled with maximum limit and verified Error message ");
			
	}
	@Test(priority = 2,groups = {"Negative"},enabled = true)
	public void verifyUserRegisterPageLastnameWithMinimumCharacter() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstName();
		registerPage.enterRegisterPageLastNameMinimumChracters();
		emailid=faker.name().firstName()+".demo123@mailinator.com";
		registerPage.enterEmailId(emailid);
		registerPage.enterPhoneNumber(faker.number().digits(10));
		registerPage.enterOccupationDoctor();
		registerPage.enterOccupationStudent();
		registerPage.enterOccupationEngineer();
		registerPage.enterOccupationScientist();
		registerPage.clickGenderMaleRadioButton();
		registerPage.enterRegisterPagePassword(Constants.password);
		registerPage.enterRegisterPageConfirmPassword(Constants.password);
		registerPage.clickRegisterPageAgeCheckbox();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking Lastname box indicating error msg or not ");
		Assert.assertEquals(registerPage.checkLastnameBoxErrorMessage(),"last Name must be 3 to 20 characters long!","Assertion failure on verifying Register page ");
		logger.info("Lastname box error msg received ");
		extentReportListener.test.log(Status.INFO, "Last name filled with below minimum limit verified Error message");
			
	}
	@Test(priority = 3,groups = {"Negative"},enabled = true)
	public void verifyUserRegisterPageInvalidEmailId() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstName();
		registerPage.enterRegisterPageLastName();
		emailid=faker.name().firstName()+"demo123456";
		registerPage.enterEmailId(emailid);
		registerPage.enterPhoneNumber(faker.number().digits(10));
		registerPage.enterOccupationDoctor();
		registerPage.enterOccupationStudent();
		registerPage.enterOccupationEngineer();
		registerPage.enterOccupationScientist();
		registerPage.clickGenderMaleRadioButton();
		registerPage.enterRegisterPagePassword(Constants.password);
		registerPage.enterRegisterPageConfirmPassword(Constants.password);
		registerPage.clickRegisterPageAgeCheckbox();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking Email box indicating error msg or not ");
		Assert.assertEquals(registerPage.checkEmailBoxErrorMessage(),"*Enter Valid Email","Assertion failure on verifying Register page ");
		logger.info("Email box error msg received ");
		extentReportListener.test.log(Status.INFO, "Email entered invalid format and verified error message");
		
	}
	@Test(priority = 4,groups = {"Negative"},enabled = true)
	public void verifyUserRegisterPageInvalidPhoneNumber() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstName();
		registerPage.enterRegisterPageLastName();
		emailid=faker.name().firstName()+"demo123456";
		registerPage.enterEmailId(emailid);
		registerPage.enterPhoneNumber(faker.number().digits(12));
		registerPage.enterOccupationDoctor();
		registerPage.enterOccupationStudent();
		registerPage.enterOccupationEngineer();
		registerPage.enterOccupationScientist();
		registerPage.clickGenderMaleRadioButton();
		registerPage.enterRegisterPagePassword(Constants.password);
		registerPage.enterRegisterPageConfirmPassword(Constants.password);
		registerPage.clickRegisterPageAgeCheckbox();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking PhoneNum box indicating error msg or not ");
		Assert.assertEquals(registerPage.checkPhoneNumBoxErrorMessage(),"*Phone Number must be 10 digit","Assertion failure on verifying Register page ");
		logger.info("PhoneNum box error msg received ");
		extentReportListener.test.log(Status.INFO, "Phone number entered more than 10 number and verified Error message");
		
	}
	@Test(priority = 5,groups = {"Negative"},enabled = true)
	public void verifyUserRegisterPagePasswordAndConfirmPasswordMismatch() {
		logger.info("User Register page verification");
		registerPage=new RegisterPage(driver);
		registerPage.clickRegisterButton();
		registerPage.enterRegisterPageFirstName();
		registerPage.enterRegisterPageLastName();
		emailid=faker.name().firstName()+"demo123456";
		registerPage.enterEmailId(emailid);
		registerPage.enterPhoneNumber(faker.number().digits(10));
		registerPage.enterOccupationDoctor();
		registerPage.enterOccupationStudent();
		registerPage.enterOccupationEngineer();
		registerPage.enterOccupationScientist();
		registerPage.clickGenderMaleRadioButton();
		registerPage.enterRegisterPagePassword(Constants.password);
		registerPage.enterRegisterPageConfirmPassword(Constants.wrongpassword);
		registerPage.clickRegisterPageAgeCheckbox();
		registerPage.clickRegisterPageSubmitButton();
		logger.info("Checking Password box indicating error msg or not ");
		Assert.assertEquals(registerPage.checkPasswordBoxErrorMessage(),"Password and Confirm Password must match with each other.","Assertion failure on verifying Register page ");
		logger.info("Password box error msg received ");
		extentReportListener.test.log(Status.INFO, "Both password and confirmpassword given by mismatch and verified error message");
		
	}
	
	
	
	

}
