package TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import PageObjects.Common.homePage;
import PageObjects.Common.loginPage;
import PageObjects.Customers.customersPage;

public class HomePageTest {

	loginPage loginPage;
	homePage homePage;
	customersPage customersPage;
	

	/*public LoginPageTest() {
		super();
	}*/

	@BeforeMethod
	public void preReq(){
		TestBase TestBase=new TestBase();
		TestBase.initialization();
		loginPage=new loginPage();
		homePage=new homePage();
		customersPage=new customersPage();
		loginPage.clickonLogIn(TestBase.getProperty("emailid"),TestBase.getProperty("password"));
	}

	@Test
	public void Logouttest(){
		homePage.clickOnLogout();
		Assert.assertEquals(loginPage.getTitle(), loginPage.loginPageTitle,"Error on logout-----------");
	}
	
	@Test
	public void clearCatchetest(){
		homePage.clearCatche();
	}
	
	@Test
	public void validateLoggedInUserNametest(){
		Assert.assertEquals(homePage.getUserName(), homePage.lblUserNametxt, "Invalid Logged in User Name in Header.");		
	}
		
	@Test
	public void validateHideUnhideMenubartest(){
		Assert.assertEquals(homePage.getUserName(), homePage.lblUserNametxt, "Invalid Logged in User Name in Header.");		
	}
	
	@Test
	public void validateNavigtiontocustomermenutest(){
		homePage.clickonMainMenu("Customers");
		homePage.clickonMenuItem("Customers");
	}
		

	@AfterMethod
	public void tearDown(){
		//driver.close();
		TestBase.driver.quit();
	}
	
}
