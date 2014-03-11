package com.qait.automation.stik.actionfixtures;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.qait.automation.stik.pageobjects.BusineesInfoUi;
import com.qait.automation.stik.pageobjects.ClientsPageUi;
import com.qait.automation.stik.pageobjects.CompanyPageUi;
//import com.qait.automation.stik.pageobjects.DemoUI_Temp;
import com.qait.automation.stik.pageobjects.DemoUi;
import com.qait.automation.stik.pageobjects.DirectoryPageUi;
import com.qait.automation.stik.pageobjects.EnterprisePageUi;
import com.qait.automation.stik.pageobjects.FeaturePagesUi;
import com.qait.automation.stik.pageobjects.HomePageUi;
import com.qait.automation.stik.pageobjects.OnYourFacebookPageUi;
import com.qait.automation.stik.pageobjects.OnYourFacebookProfileUi;
import com.qait.automation.stik.pageobjects.OnYourWebsiteUi;
import com.qait.automation.stik.pageobjects.ProfessionalPageUi;
import com.qait.automation.stik.pageobjects.ProfileInfoPageUi;
import com.qait.automation.stik.pageobjects.ProfilePageUi;
import com.qait.automation.stik.pageobjects.ReferralPageUi;
import com.qait.automation.stik.pageobjects.ReviewPageUi;
import com.qait.automation.stik.pageobjects.SearchPageUi;
import com.qait.automation.stik.pageobjects.ShowcaseEMailUi;
import com.qait.automation.stik.pageobjects.UserHomePageUi;
import com.qait.automation.stik.util.SizzleSelector;
import com.qait.automation.stik.util.Utilities;
import com.thoughtworks.selenium.Selenium;


/**
 * This is the base class which provides functionalities to other classes
 * @author QAIT
 * 
 */

public class BaseFixture {
	 
	 public WebDriver driver;
	 public DesiredCapabilities capabilities;
	 public HttpCommandExecutor executor;
	 public Selenium sel;
	 public String browser;
	 public static String testUserName;
	 public static String testPassword;
	 public static Logger logger = Logger.getLogger(BaseFixture.class);
	 
	 public SizzleSelector sizzle;
	 public HomePageUi homePageUi;
	 public ProfileInfoPageUi profileInfoPageUi;
	 public ProfilePageUi profilePageUi;
	 public ReviewPageUi reviewPageUi;
	 public DirectoryPageUi directoryPageUi;
	 public SearchPageUi searchPageUi;
	 public ProfessionalPageUi professionalPageUi;
	 public ClientsPageUi clientsPageUi;
	 public ShowcaseEMailUi showcaseEmailUi;
	 public OnYourWebsiteUi onYourWebsiteUi;
	 public OnYourFacebookPageUi onYourFacebookPageUi;
	 public OnYourFacebookProfileUi onYourFacebookProfileUi;
	 public BusineesInfoUi businessInfoUi;
	 public DemoUi demoUi;
	 public UserHomePageUi userHomePageUi;
	 public ReferralPageUi referralPageUi;
	 public FeaturePagesUi featuresPageUi;
	 public CompanyPageUi companyPageUi;
	 public EnterprisePageUi enterprisePageUi;
	 public Utilities util;
	 public DirectoryPageUi directTemp;
	
		
	 public static int AJAX_WAIT;
	 
	public BaseFixture() {
		capabilities = new DesiredCapabilities();
	}
	
	/**
	 * function to initialize Page objects
	 */
	private void _initObjects() {
		PropertyConfigurator.configure("data/log4j.properties");
		sizzle = new SizzleSelector(driver);
		homePageUi = new HomePageUi(driver,sizzle);
		profileInfoPageUi = new ProfileInfoPageUi(driver, sizzle);
		profilePageUi = new ProfilePageUi(driver, sizzle);
		reviewPageUi = new ReviewPageUi(driver, sizzle);
		directoryPageUi = new DirectoryPageUi(driver, sizzle);
		searchPageUi = new SearchPageUi(driver, sizzle);
		professionalPageUi = new ProfessionalPageUi(driver, sizzle); 
		clientsPageUi = new ClientsPageUi(driver, sizzle);
		showcaseEmailUi = new ShowcaseEMailUi(driver, sizzle);
		onYourWebsiteUi = new OnYourWebsiteUi(driver, sizzle);
		onYourFacebookPageUi= new OnYourFacebookPageUi(driver, sizzle);
		onYourFacebookProfileUi = new OnYourFacebookProfileUi(driver, sizzle);
		businessInfoUi= new BusineesInfoUi(driver, sizzle);
		demoUi=new DemoUi(driver, sizzle);
		userHomePageUi=new UserHomePageUi(driver, sizzle);
		referralPageUi= new ReferralPageUi(driver, sizzle);
		featuresPageUi=new FeaturePagesUi(driver, sizzle);
		companyPageUi=new CompanyPageUi(driver, sizzle);
		enterprisePageUi=new EnterprisePageUi(driver,sizzle);
		
		directTemp= new DirectoryPageUi(driver, sizzle);
	}

	/**
	 * <p>
	 * If inconsistent values are provided, it would switch to firefox
	 * <p>
	 */
	public boolean startBrowser(String browserName) {
		if(browserName.isEmpty())
			browserName = util.getYamlValue("browser");
		browser= browserName;
		URL url =null;
		try {
			url = new URL(util.getYamlValue("selenium_remote_server"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if(util.getYamlValue("environment").equalsIgnoreCase("remote")){
        	startRemoteDriver(browserName,url);
		}else{
			startLocalDriver(browserName);
		}
		AJAX_WAIT = Integer.parseInt(getYamlVal("AJAX_WAIT"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		maximizePage();
		_initObjects();
		return true;
	}

	private void maximizePage(){
    	((JavascriptExecutor)driver).executeScript("if (window.screen){window.moveTo(0, 0);window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
    }
	
	private void startLocalDriver(String browserName){
		
		capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
	
		if (browserName.contains("firefox")) {
			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver();
			
			Reporter.log("Started Local firefox...");
		} else if (browserName.contains("iexplore")) {
			if ((System.getProperty("os.arch")).equalsIgnoreCase("x86")) {
				System.out.println(System.getProperty("os.arch"));
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer2.30x32.exe");
				driver = new InternetExplorerDriver();
				Reporter.log("Started Local Internet Explorer (32-bit)");
			} else {
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer2.30x64.exe");
				driver = new InternetExplorerDriver();
				Reporter.log("Started Local Internet Explorer (64-bit)");
			}
		} else if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", "DriverServer/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Started Local Google Chrome");
		}else if(browserName.equalsIgnoreCase("safari")){
    		capabilities = DesiredCapabilities.safari();
    		capabilities.setJavascriptEnabled(true);
    		driver = new SafariDriver(capabilities);
    		Reporter.log("Started Local Safari");
    	} else {
			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver();
			Reporter.log("Started local default Firefox");
		}
	}
	
	private void startRemoteDriver(String browserName, URL url){
		/****** Code to access using MOZILLA FIREFOX*********/
    	if(browserName.equalsIgnoreCase("firefox")){
    		capabilities = DesiredCapabilities.firefox();
	   		capabilities.setJavascriptEnabled(true);
      		capabilities.setBrowserName("firefox");
      		executor = new HttpCommandExecutor(url);
      		driver = new RemoteWebDriver(executor, capabilities);
      		Reporter.log("Started Remote firefox");
	   	/******** Code to access using INTERNET EXPLORER******/
    	}else if(browserName.equalsIgnoreCase("iexplore")){
			if ((System.getProperty("os.arch")).equalsIgnoreCase("x86")) {
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer32.exe");
				capabilities = DesiredCapabilities.internetExplorer();
     		   	driver = new RemoteWebDriver(url, capabilities);
     		   	Reporter.log("Started Remote Internet Explorer (32-bit) driver");
			} else {
				System.setProperty("webdriver.ie.driver","DriverServer/IEDriverServer.exe");
				capabilities = DesiredCapabilities.internetExplorer();
     		   	driver = new RemoteWebDriver(url, capabilities);
     		    Reporter.log("Started Remote Internet Explorer (64-bit) driver");
			}
		}else if ((browserName.equalsIgnoreCase("chrome"))){
    		/* Code to access using GOOGLE CHROME version 2*******
    		 * The advantage of using this method is that you can execute 
    		 * your test-cases in a remote machine and this is advantageous when you want to run it on grid.
    		 * First start selenium server using: 
    		 * java -Dwebdriver.chrome.driver=C:\chromedriver.exe  -jar selenium-server-standalone-2.7.0.jar 
    		 */
          	   System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    		   capabilities = DesiredCapabilities.chrome();
    		   driver = new RemoteWebDriver(url, capabilities);
    		   Reporter.log("Started Remote Google Chrome");
    	} else if(browserName.equalsIgnoreCase("safari")){
    		capabilities = DesiredCapabilities.safari();
    		capabilities.setJavascriptEnabled(true);
    		driver = new SafariDriver(capabilities);
    		Reporter.log("Started Remote Safari");
    	}
	}
	
	/**
	 * @param dataFilePath : path to set .yml location
	 * @return : yaml path
	 */
	public void setUpDataFile(String dataFilePath) {
		if(dataFilePath.isEmpty()){
			String name = System.getProperty("name", "null");
			dataFilePath = "data/"+name+"testData.yml";
		}
		util = new Utilities(dataFilePath);
		AJAX_WAIT = Integer.parseInt(util.getYamlValue("AJAX_WAIT"));
    }

	public boolean launchUrl(String url) {
		driver.get(url);
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getTitle().contains("Stik.com") || driver.getTitle().contains("Professional"));
		Reporter.log("Launched URL and verified that title contains Stik.com...");
		return true;
	}

	public String getYamlVal(String yamlMapObj) {
		return util.getYamlValue(yamlMapObj);
	}

	/**
	 * Function to close the browser
	 */
	public boolean closeBrowser() {
		driver.quit();
		Reporter.log("Closed Browser session...");
		return true;
	}
	
	public boolean isDisplayed(WebElement wElement){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try{
			wElement.isDisplayed();
		}catch(Exception ex){
			driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
		return true;
	}

	public String get_Browser(){
		return browser;
	}
	
	public void ifExistsDebugClickClose(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try{
			driver.findElement(By.cssSelector(homePageUi.get_debugCloseCSS())).click();
		}catch(Exception ex){
		
		}
		driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
	}
	
	public void scrollDown(int vertical){
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		String scroll="window.scrollBy(0,ver)".replaceAll("ver", String.valueOf(vertical));
		jsx.executeScript(scroll, "");
		Utilities.hardWait(1);
	}
	
	public int generateRandomNumber(int MinRange, int MaxRange){
		int randomNumber= MinRange + (int)(Math.random()*((MaxRange-MinRange)+1));
		return randomNumber;
	}
	
	/***********Browser initialization for Linkedin Related Test case for setting up Proxy**********/
	public boolean startBrowserWithProxyForLinkedinTestCase(String browserName){
		if(browserName.isEmpty())
			browserName = util.getYamlValue("browser");
		browser= browserName;
		URL url =null;
		try {
			url = new URL(util.getYamlValue("selenium_remote_server"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if(util.getYamlValue("environment").equalsIgnoreCase("remote")){
        	startRemoteDriverForLinkedin(browserName,url);
		}else{
			startLocalDriverForLinkedin(browserName);
		}
		AJAX_WAIT = Integer.parseInt(getYamlVal("AJAX_WAIT"));
		driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		maximizePage();
		_initObjects();
		Utilities.dynamicWaitForLinkedinTC(driver);
		return true;
	}
		
	public void startLocalDriverForLinkedin(String browserName){
		
		capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);

		Proxy proxyForQAServer=new Proxy();
		proxyForQAServer.setSslProxy("72.29.101.11"+":"+8089); 
		proxyForQAServer.setFtpProxy("72.29.101.11"+":"+8089);
		proxyForQAServer.setHttpProxy("72.29.101.11"+":"+8089);
		capabilities.setCapability(CapabilityType.PROXY, proxyForQAServer);
	
		if (browserName.contains("firefox")) {
			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver(capabilities);
			Reporter.log("Started Local firefox...");
		} else if (browserName.contains("iexplore")) {
			if ((System.getProperty("os.arch")).equalsIgnoreCase("x86")) {
				System.out.println(System.getProperty("os.arch"));
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer2.30x32.exe");
				driver = new InternetExplorerDriver();
				Reporter.log("Started Local Internet Explorer (32-bit)");
			} else {
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer2.30x64.exe");
				driver = new InternetExplorerDriver();
				Reporter.log("Started Local Internet Explorer (64-bit)");
			}
		} else if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", "DriverServer/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Started Local Google Chrome");
		}else if(browserName.equalsIgnoreCase("safari")){
    		capabilities = DesiredCapabilities.safari();
    		capabilities.setJavascriptEnabled(true);
    		driver = new SafariDriver(capabilities);
    		Reporter.log("Started Local Safari");
    	} else {
			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver();
			Reporter.log("Started local default Firefox");
		}
	}
	
	
	public void startRemoteDriverForLinkedin(String browserName, URL url){
		/****** Code to access using MOZILLA FIREFOX*********/
    	if(browserName.equalsIgnoreCase("firefox")){
    		capabilities = DesiredCapabilities.firefox();
	   		capabilities.setJavascriptEnabled(true);
      		capabilities.setBrowserName("firefox");
      		executor = new HttpCommandExecutor(url);
      		driver = new RemoteWebDriver(executor, capabilities);
      		Reporter.log("Started Remote firefox");
	   	/******** Code to access using INTERNET EXPLORER******/
    	}else if(browserName.equalsIgnoreCase("iexplore")){
			if ((System.getProperty("os.arch")).equalsIgnoreCase("x86")) {
				System.setProperty("webdriver.ie.driver", "DriverServer/IEDriverServer32.exe");
				capabilities = DesiredCapabilities.internetExplorer();
     		   	driver = new RemoteWebDriver(url, capabilities);
     		   	Reporter.log("Started Remote Internet Explorer (32-bit) driver");
			} else {
				System.setProperty("webdriver.ie.driver","DriverServer/IEDriverServer.exe");
				capabilities = DesiredCapabilities.internetExplorer();
     		   	driver = new RemoteWebDriver(url, capabilities);
     		    Reporter.log("Started Remote Internet Explorer (64-bit) driver");
			}
		}else if ((browserName.equalsIgnoreCase("chrome"))){
    		/* Code to access using GOOGLE CHROME version 2*******
    		 * The advantage of using this method is that you can execute 
    		 * your test-cases in a remote machine and this is advantageous when you want to run it on grid.
    		 * First start selenium server using: 
    		 * java -Dwebdriver.chrome.driver=C:\chromedriver.exe  -jar selenium-server-standalone-2.7.0.jar 
    		 */
          	   System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    		   capabilities = DesiredCapabilities.chrome();
    		   driver = new RemoteWebDriver(url, capabilities);
    		   Reporter.log("Started Remote Google Chrome");
    	} else if(browserName.equalsIgnoreCase("safari")){
    		capabilities = DesiredCapabilities.safari();
    		capabilities.setJavascriptEnabled(true);
    		driver = new SafariDriver(capabilities);
    		Reporter.log("Started Remote Safari");
    	}
	}
/*******************************************************************************/	
	public void setTestUserName(String userName){
		testUserName = userName;
	}
	
	public void setTestPassword(String password){
		testPassword = password;
	}
	
	public String getTestUserName(){
		return testUserName;
	}
	
	public String getTestPassword(){
		return testPassword;
	}
}
