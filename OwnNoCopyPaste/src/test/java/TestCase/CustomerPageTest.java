package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import PageObjects.Common.homePage;
import PageObjects.Common.loginPage;

public class CustomerPageTest {

	loginPage loginPage;
	homePage homePage;
	WebDriver driver;
	
	@BeforeMethod
	public void preReq(){
		//TestBase TestBase=new TestBase();
		TestBase.initialization();
		loginPage=new loginPage(driver);
		homePage=new homePage(driver);
		loginPage.clickonLogIn(TestBase.getProperty("emailid"),TestBase.getProperty("password"));
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
