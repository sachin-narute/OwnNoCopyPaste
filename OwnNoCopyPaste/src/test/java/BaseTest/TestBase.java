package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;

	public static WebDriver initialization(){

		String browser=TestBase.getProperty("browser");
		String testUrl=TestBase.getProperty("url");
		int implicitlyWait =Integer.parseInt(TestBase.getProperty("implicitlyWait"));
		int pageLoadTimeout =Integer.parseInt(TestBase.getProperty("pageLoadTimeout"));

		if (browser.equalsIgnoreCase("chrome")) {

			/*			String browserPath = System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";

			// Create object of ChromeOptions class
			// Chrome options class is used to manipulate various properties of Chrome driver
			ChromeOptions options = new ChromeOptions();

			// options.addArguments("--headless"); //-–headless are predefined arguments provided by Chrome Options class for using Chrome browser in headless mode
			// options.addArguments("--incognito"); //--incognito are predefined arguments provided by Chrome Options class for using Chrome browser in incognito mode
			options.addArguments("--start-maximized"); //Start Chrome maximized
			options.setAcceptInsecureCerts(true);
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking")); //Block pop-up windows
			options.setCapability("webdriver.chrome.driver", browserPath);

			//Create an object of Desired Capabilities class and merge the Desired Capabilities class object 
			//with Chrome Options class object using merge method
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);



			System.setProperty("webdriver.chrome.driver", browserPath);
			driver=new ChromeDriver(options);*/

			WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();

		} else if(browser.equalsIgnoreCase("firefox")) {

			/*	System.out.println("Firefox Browser");

			//It create firefox profile
			FirefoxProfile profile=new FirefoxProfile();

			// This will set the true value
			profile.setAssumeUntrustedCertificateIssuer(true);
			profile.setAcceptUntrustedCertificates(true);

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile);

			String browserPath = System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", browserPath);
			driver=new FirefoxDriver(firefoxOptions);
			//How to remove log statements in console:
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");*/

			WebDriverManager.firefoxdriver().setup();

			driver=new FirefoxDriver();


		} else if(browser.equalsIgnoreCase("IE")) {

			/*System.out.println("Internet Explorer Browser"); 
			String browserPath = System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", browserPath);
			driver=new InternetExplorerDriver();*/

			WebDriverManager.iedriver().setup();

			driver=new InternetExplorerDriver();

		} else {
			System.out.println("Wrong bowser name in properties file...");
		}

		driver.manage().window().maximize();
		driver.get(testUrl);
		driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

		return driver;
	}

	public static String getProperty(String Name){

		prop=new Properties();
		try {
			String path = System.getProperty("user.dir")+"\\src\\test\\java\\ConfigurationFiles\\config.properties";
			//System.out.println(path);
			fis=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("Propertise file is missing...");
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String propValue=prop.getProperty(Name);

		return propValue;

	}

	public static void takeScreenShot(){
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String destPath = System.getProperty("user.dir")+"\\Result\\"+System.currentTimeMillis()+".png";
		File dest=new File(destPath);

		try {
			//FileHandler.copy(src, dest);
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
