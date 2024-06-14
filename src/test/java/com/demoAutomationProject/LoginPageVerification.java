package com.demoAutomationProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import baseClass.BaseClass;
import constants.Constants;
import pages.LoginPage;

public class LoginPageVerification extends BaseClass {
	private LoginPage loginPage;
	
	@Test(priority = 0,groups = {"Smoke" ,"Positive"},enabled = true)
	public void verifyLoginWithValidUserCredentials() {
		logger.info("User login with valid credentials");
		loginPage=new LoginPage(driver);
		logger.info("Checking Username box is present or not");
		Assert.assertTrue(loginPage.CheckUsernameBox(), "Assertion failure verifying username box");
		logger.info("Username box is present");
		logger.info("Checking password box is present or not");
		Assert.assertTrue(loginPage.CheckPasswordBox(), "Assertion failure verifying password box");
		logger.info("User password box is present");
		logger.info("Checking Login button is enabled or not");
		Assert.assertTrue(loginPage.CheckLoginbutton(), "Assertion failure verifying Login button");
		logger.info("Login button is enabled");
		loginPage.enterUsername(Constants.username);
		loginPage.enterPassword(Constants.password);
		loginPage.clickLoginButton();
		extentReportListener.test.log(Status.INFO, "Username,Password entered and Login button clicked");
		logger.info("Checking Login sucessfully or not ");
		Assert.assertEquals(loginPage.checkLoginSuccessMessage(),"Login Successfully","Assertion failure on verifying login ");
		logger.info("Login succesfully");
		extentReportListener.test.log(Status.INFO, "Login successfully verified");
	}
	@Test(priority = 1,groups = {"Negative"},enabled = true)
	public void verifyLoginWithInValidUserCredentials() {
		logger.info("User login with Invalid credentials");
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.username);
		loginPage.enterPassword(Constants.wrongpassword);
		loginPage.clickLoginButton();
		logger.info("Checking invalid credential login error message receive or not ");
		Assert.assertEquals(loginPage.checkInvalidCredentialErrorMessage(),"Incorrect email or password.","Assertion failure on verifying login ");
		logger.info("Error message receive");
		extentReportListener.test.log(Status.INFO, "Login with invalid credentials and Incorrect email or password Error message verified");
		
	}
	@Test(priority = 2,groups = {"Negative"},enabled = true)
	public void verifyLoginWithWithoutUserCredentials() {
		logger.info("User login without credentials");
		loginPage=new LoginPage(driver);
		loginPage.clickLoginButton();
		logger.info("Checking without user credential login Email box error message receive or not ");
		Assert.assertEquals(loginPage.checkEmailIsRequiredErrorMessage(),"*Email is required","Assertion failure on verifying login ");
		logger.info("Email box Error message receive");
		logger.info("Checking without user credential login Password box error message receive or not ");
		Assert.assertEquals(loginPage.checkPasswordIsRequiredErrorMessage(),"*Password is required","Assertion failure on verifying login ");
		logger.info("Password box Error message receive");
		extentReportListener.test.log(Status.INFO, "Login without user credentials,Email and Password Required Error message verified");
		
	}
	@Test(priority = 3,groups = {"Negative"},enabled = true)
	public void verifyLoginWithInvalidEmail() {
		logger.info("User login with Invalid email");
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.wrongpassword);
		loginPage.enterPassword(Constants.wrongpassword);
		loginPage.clickLoginButton();
		logger.info("Checking user enter Invalid Email error message receive or not ");
		Assert.assertEquals(loginPage.checkInvalidEmailErrorMessage(),"*Enter Valid Email","Assertion failure on verifying login ");
		logger.info("Email invalid Error message receive");
		extentReportListener.test.log(Status.INFO, "Login with invalid email,Enter valid Email Error message verified");
		
		
	}
	@Test(priority = 4,groups = {"Positive"},enabled = true)
	public void verifyForgetPasswordAndResetPassword() {
		logger.info("User forgot password and reset the new password");
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.username);
		loginPage.clickForgotPasswordButton();
		loginPage.enterUserMail(Constants.username);
		loginPage.enterNewPassword(Constants.password);
		loginPage.enterConfirmNewPassword(Constants.password);
		loginPage.clickSaveNewPasswordButton();
		logger.info("Checking Password changed success message receive or not ");
		Assert.assertEquals(loginPage.checkPasswordChangedSuccessMessage(),"Password Changed Successfully","Assertion failure on verifying login ");
		logger.info("Password changed success message receive");
		extentReportListener.test.log(Status.INFO, "User forgot password and Reset password verified");
		
		
	}
	@Test(priority = 5,groups = {"Positive"},enabled = true)
	public void verifyLoginWithUserCredentialFromExcelFile() throws IOException {
		logger.info("User login with valid credentials from Excel file");
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.username);
		loginPage.enterUserPassword();
		loginPage.clickLoginButton();
		logger.info("Checking Login sucessfully or not ");
		Assert.assertEquals(loginPage.checkLoginSuccessMessage(),"Login Successfully","Assertion failure on verifying login ");
		logger.info("Login succesfully");
		extentReportListener.test.log(Status.INFO, "Login with user credential from Excel file");
		
		
	}
	
	

}
