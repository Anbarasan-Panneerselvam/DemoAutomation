package pom;

import org.openqa.selenium.By;

public class LoginPagePOM {
	
	public By userEmailBox=By.xpath("//input[@id='userEmail']");
	public By userPasswordBox=By.xpath("//input[@id='userPassword']");
	public By loginButton=By.xpath("//input[@id='login']");
	public By loginSuccessMsg=By.xpath("//div[text()=' Login Successfully ']");
	public By forgotPassword=By.xpath("//a[text()='Forgot password?']");
	public By userEmailBoxErrorMsg=By.xpath("//div[text()='*Email is required']");
	public By userPasswordBoxErrorMsg=By.xpath("//div[text()='*Password is required']");
	public By invalidUserCredentialErrorMsg=By.xpath("//div[text()=' Incorrect email or password. ']");
	public By invalidEmailErrorMsg=By.xpath("//div[text()='*Enter Valid Email']");
	public By forgotPasswordPageUserMailBox=By.xpath("//input[@type='email']");
	public By forgotPasswordPageUserPasswordBox=By.xpath("//input[@id='userPassword']");
	public By forgotPasswordPageUserConfirmPasswordBox=By.xpath("//input[@id='confirmPassword']");
	public By saveNewPasswordButton=By.xpath("//button[text()='Save New Password']");
	public By passwordChangedSuccessMsg=By.xpath("//div[text()=' Password Changed Successfully ']");
	public By registerPageFirstNameBox=By.xpath("//input[@id='firstName']");
	public By registerPageLastNameBox=By.xpath("//input[@id='lastName']");
	public By registerPageUserEmailBox=By.xpath("//input[@id='userEmail']");
	public By registerPageUserPhoneNumBox=By.xpath("//input[@id='userMobile']");
	public By registerPageOccupationDropdown=By.xpath("//label[text()='Occupation']/following-sibling::select");
	public By registerPageOccupationDoctor=By.xpath("//label[text()='Occupation']/following-sibling::select/option[text()='Doctor']");
	public By registerPageOccupationStudent=By.xpath("//label[text()='Occupation']/following-sibling::select/option[text()='Student']");
	public By registerPageOccupationEngineer=By.xpath("//label[text()='Occupation']/following-sibling::select/option[text()='Engineer']");
	public By registerPageOccupationScientist=By.xpath("//label[text()='Occupation']/following-sibling::select/option[text()='Scientist']");
	public By registerPageGenderMaleRadioButton=By.xpath("//input[@Value='Male']");
	public By registerPageGenderFemaleRadioButton=By.xpath("//input[@Value='Female']");
	public By registerPageUserPasswordBox=By.xpath("//input[@id='userPassword']");
	public By registerPageUserConfirmPasswordBox=By.xpath("//input[@id='confirmPassword']");
	public By registerPageAgeCheckbox=By.xpath("//input[@type='checkbox']");
	public By registerPageSubmitButton=By.xpath("//input[@type='submit']");
	public By registeredSuccessMsg=By.xpath("//div[text()=' Registered Successfully ']");
	public By accountCreatedSuccessMsg=By.xpath("//h1[text()='Account Created Successfully']");
	public By afterRegLoginButton=By.xpath("//button[text()='Login']");
	

}
