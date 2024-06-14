package pom;

import org.openqa.selenium.By;

public class RegisterPagePOM {
	public By registerHereButton=By.xpath("//a[text()='Register here']");
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
	public By firstnameErrorMsg=By.xpath("//div[text()='*First Name must be 12 or less character long']");
	public By lastnameErrorMsg=By.xpath("//div[text()=' last Name must be 3 to 20 characters long! ']");
	public By emailErrorMsg=By.xpath("//div[text()='*Enter Valid Email']");
	public By phoneNumErrorMsg1=By.xpath("//div[text()='*only numbers is allowed']");
	public By phoneNumErrorMsg2=By.xpath("//div[text()='*Phone Number must be 10 digit']");
	public By passwordErrorMsg=By.xpath("//div[text()='Password and Confirm Password must match with each other.']");

}
