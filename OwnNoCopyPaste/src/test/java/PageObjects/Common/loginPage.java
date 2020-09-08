package PageObjects.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.TestBase;

public class loginPage extends TestBase{

	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	//
	public String loginPageTitle="Your store. Login";
	public String lblEmailErrortxt="Please enter your email";
	public String lblLoginSummaryErrortxt="Login was unsuccessful. Please correct the errors and try again";
	
	
	
	//List all webElements on home page
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[contains(@id,'Password')]")
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='Log in']")
	WebElement btnLogIn;

	@FindBy(xpath="//input[@id='RememberMe']")
	WebElement checkBoxRemMe;

	@FindBy(xpath = "//span[@id='Email-error']")
	WebElement lblEmailError;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	WebElement lblLoginSummaryError;


	//List all methods

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogIn() {		
		return btnLogIn;
	}
	
	public String getLblEmailError() {
		return lblEmailError.getText();
	}

	public String getlblLoginSummaryError() {
		return lblLoginSummaryError.getText();
	}


	public void setTxtEmail(String Email) {
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}

	public void setTxtPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void setCheckBoxRemMe() {
		if(!checkBoxRemMe.isSelected())
		{
			checkBoxRemMe.click();
		}	
	}

	
	
	public homePage clickonLogIn(){
		btnLogIn.click();
		return new homePage();
	}
	
	public homePage clickonLogIn(String email, String pwd){
		setTxtEmail(email);
		setTxtPassword(pwd);
		btnLogIn.click();
		return new homePage();
	}

	public String getTitle(){
		return driver.getTitle();
	}



}
