package PageObjects.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;








import BaseTest.TestBase;
import PageObjects.Customers.GDPRrequestsPage;
import PageObjects.Customers.activatyLogPage;
import PageObjects.Customers.activityTypesPage;
import PageObjects.Customers.customerRolePage;
import PageObjects.Customers.customersPage;
import PageObjects.Customers.onlineCustPage;
import PageObjects.Customers.vendorsPage;
import PageObjects.Sales.giftcardsPage;
import PageObjects.Sales.ordersPage;
import PageObjects.Sales.recurringPaymentsPage;
import PageObjects.Sales.returnRequestsPage;
import PageObjects.Sales.shipmentsPage;
import PageObjects.Sales.shoppingCartsandwishlistsPage;

public class homePage extends TestBase{

	public Object result;
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}

	//
	public String DashboadPageTitle="Dashboard / nopCommerce administration";
	public String lblUserNametxt="John Smith";

	// List all webelements on home page 

	@FindBy(xpath = "//li[@class='account-info']")
	WebElement lblUserName;

	@FindBy(xpath = "//a[contains(.,'Logout')]")
	WebElement linkLogout;

	//@FindBy(xpath = "//li[@class='dropdown open']//i[@class='fa fa-gears']")
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement linkSetting;

	@FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Clear cache')]")
	WebElement lblclearCache;

	@FindBy(xpath = "//span[@class='logo-lg']")
	WebElement imgLogo;

	@FindBy(xpath = "//a[@class='sidebar-toggle']")
	WebElement sidebarToggle;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;

	@FindBy(xpath = "//span[@class='menu-item-title'][contains(.,'Dashboard')]")
	WebElement lnkDashBoard;

	@FindBy (xpath="//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement lnkMenu;

	@FindBy (xpath="//span[@class='menu-item-title'][contains(text(),'Customers')]")
	WebElement lnkMenuitem;



	// List all actions/methods on home page

	public String getTitle(){
		return driver.getTitle();
	}

	public String getUserName(){
		return lblUserName.getText();
	}

	public boolean validatelogoonHomeScreen(){
		return imgLogo.isDisplayed();
	}

	public loginPage clickOnLogout(){
		linkLogout.click();
		return new loginPage();
	}

	public void clearCatche(){
		linkSetting.click();
		lblclearCache.click();
	}

	public void HideUnHideMenuBar(){
		sidebarToggle.click();
	}

	public void searchMenuBar(String SearchValue){
		txtSearch.sendKeys("SearchValue");
	}
	
	public dashboardPage clickonDashoard(){
		lnkDashBoard.click();
		return new dashboardPage();
	}

	public void clickonMainMenu(String MainMenuName){
		System.out.println(MainMenuName);
		driver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'"+MainMenuName+"')]")).click();
	}

	public void clickonMenuItem(String MainItemName){
		System.out.println(MainItemName);
		driver.findElement(By.xpath("//span[@class='menu-item-title'][contains(text(),'"+MainItemName+"')]")).click();
	}
	
	/*public Object Navigaion(String MainMenuName, String MainItemName){
				
		switch (MainItemName) {
        case "Customers":
            result=new customersPage();
            break;
        case "Customer roles":
        	result=new customerRolePage();
        	break;
        case "Online customers":
        	result=new onlineCustPage();
        	break;
        case "Vendors":
        	result=new vendorsPage();
        	break;
        case "Activity log":
        	result=new activatyLogPage();
        	break;
        case "Activity Types":
        	result=new activityTypesPage();
        	break;
        case "GDPR requests (log)":
        	result=new GDPRrequestsPage();
        	break;
        case "Orders":
        	result=new ordersPage();
        	break;
        case "Shipments":
        	result=new shipmentsPage();
        	break;
        case "Return requests":
        	result=new returnRequestsPage();
        	break;
        case "Recurring payments":
        	result=new recurringPaymentsPage();
        	break;
        case "Gift cards":
        	result=new giftcardsPage();
        	break;
        case "Shopping carts and wishlists":
        	result=new shoppingCartsandwishlistsPage();
        	break;
        default:
        	result=new dashboardPage();
    }
		return result;
		
	}
*/	
	
}

