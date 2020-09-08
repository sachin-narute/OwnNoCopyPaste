package PageObjects.Customers;

import org.openqa.selenium.support.PageFactory;

import BaseTest.TestBase;

public class customersPage extends TestBase{

	public customersPage() {
		PageFactory.initElements(driver, this);
	}

	//label
	public String CustomerPageTitleTxt="Customers / nopCommerce administration";
	
	//webelements

	//action/methods

	public String getTitle(){
		return driver.getTitle();
	}


}
