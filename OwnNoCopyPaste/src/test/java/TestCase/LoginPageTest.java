package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import PageObjects.Common.homePage;
import PageObjects.Common.loginPage;

public class LoginPageTest  {
	
	loginPage loginPage;
	homePage homePage;

	/*public LoginPageTest() {
		super();
	}*/

	@BeforeMethod
	public void preReq(){
		TestBase TestBase=new TestBase();
		TestBase.initialization();
		loginPage=new loginPage();
		homePage=new homePage();
	}

	@Test
	public void LoginWithBlankUsernamePasswordtest(){
		
		loginPage.setTxtEmail("");
		loginPage.setTxtPassword("");
		loginPage.clickonLogIn();
		Assert.assertEquals(loginPage.getLblEmailError(), loginPage.lblEmailErrortxt,"Validation Error-----");

	}
	
	@Test
	public void LoginWithValidUsernameBlankPasswordtest(){
		loginPage.setTxtEmail(TestBase.getProperty("emailid"));
		loginPage.setTxtPassword("");
		loginPage.clickonLogIn();
		
		Assert.assertTrue(loginPage.getlblLoginSummaryError().contains(loginPage.lblLoginSummaryErrortxt));
		
	}
	
	@Test
	public void LoginWithValidUsernamePasswordtest(){
		//loginPage.setTxtEmail();
		//loginPage.setTxtPassword();
		loginPage.clickonLogIn(TestBase.getProperty("emailid"),TestBase.getProperty("password"));
		Assert.assertEquals(homePage.getTitle(), homePage.DashboadPageTitle,"Login Failed--------");
		Assert.assertEquals(homePage.getUserName(), homePage.lblUserNametxt, "Invalid Logged in User Name in Header.");

	}

	@AfterMethod
	public void tearDown(){
		//driver.close();
		TestBase.driver.quit();
	}


}
