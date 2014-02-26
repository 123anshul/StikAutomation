package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class DirectoryPageUi extends BaseUi {

	
	public DirectoryPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	/*****************WEB UI defined *****************************/
	//old directory code
	@FindBy(css="div[id='companiesSelect_chosen']>a[class='chosen-single']")
	private WebElement companyDropDown;
	
	@FindBy(css="div[id='statesSelect_chosen']>a[class='chosen-single chosen-default']")
	private WebElement stateDropDown;
	
	@FindBy(css="div[id='citiesSelect_chosen']>a[class='chosen-single chosen-default']")
	private WebElement cityDropDown;
	
	String companiesInList="div[id='companiesSelect_chosen']>div>ul>li";
	String statesInList="div[id='statesSelect_chosen']>div>ul>li";
	String citiesInList="div[id='citiesSelect_chosen']>div>ul>li";
	String cssIndustries = "div[id = 'directory_industry']>ul>li";
	String highlightable = "div[class='highlightable']";
	String cssState = "div[id= 'directory_state']>ul>li";
	String cssCity = "div[id= 'directory_city']>ul>li>a";
	String searchTerm="div[id='mainSection']>div[id='splashSection']>div[id='info']>div[class='twelve columns']>h1";
	
	//End of old directory code
	
	@FindBy(css = ".content-bar>nav>h1")
	private WebElement directoryPageHeading;

	@FindBy(css = ".chosen-single>span")
	private WebElement selectIndustry;
	
	@FindBy(css=".industry>div>div>ul>li")
	private List<WebElement> industryList;
	
	@FindBy(css = ".search-zip-input")
	private WebElement zipcodeInput;
	
	@FindBy(xpath = ".//*[@id='listings']/div[2]/div[2]/div[1]/div[1]/div/div[2]/address")
	private WebElement zipcodeOnEmployeePersonalInfo;
	
	@FindBy(css = ".professional-search-submit.button")
	private WebElement continueButton;
	
	@FindBy(css = ".popular>h2")
	private WebElement headingPopularIndustries;
	
	@FindBy(css = ".industry-group>a[href='insurance']")
	private WebElement insuranceHeading;
	
	@FindBy(css = ".industry-group>a[href='insurance']>h2")
	private WebElement insuranceHeadingText;
	
	@FindBy(css = ".industry-group>a[href='real-estate']")
	private WebElement RealtorsHeading;
	
	@FindBy(css = ".industry-group>a[href='real-estate']>h2")
	private WebElement RealtorsHeadingText;
	
	@FindBy(css = ".industry-group>a[href='auto-sales-repair']")
	private WebElement autoProfessionHeading;
	
	@FindBy(css = ".industry-group>a[href='auto-sales-repair']>h2")
	private WebElement autoProfessionHeadingText;
	
	@FindBy(css = ".industry-group>a[href='home-services']")
	private WebElement homeContractorsHeading;
	
	@FindBy(css = ".industry-group>a[href='home-services']>h2")
	private WebElement homeContractorsHeadingText;
	
	@FindBy(css = ".industry-group>a[href='health-wellness']")
	private WebElement healthCareHeading;
	
	@FindBy(css = ".industry-group>a[href='health-wellness']>h2")
	private WebElement healthCareHeadingText;
	
	@FindBy(css = ".industry-group>a[href='arts-entertainment']")
	private WebElement artistsHeading;
	
	@FindBy(css = ".industry-group>a[href='arts-entertainment']>h2")
	private WebElement artistsHeadingText;

	@FindBy(css = ".industry-group>h2")
	private WebElement othersHeading;
	
	//@FindBy(css = ".no-cover-image")
	@FindBy(xpath = ".//*[@id='layout']/h1")
	private WebElement industryHeading;
	
	@FindBy(xpath = ".//*[@id='listings']/div[2]/div[1]/p")
	private WebElement recommendProfessionalsText;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[1]/ul/li/a")
	 private List<WebElement> insuranceIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[2]/ul/li/a")
	 private List<WebElement> realtorsIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[3]/ul/li/a")
	 private List<WebElement> autoProfessionalIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[4]/ul/li/a")
	 private List<WebElement> homeContractorsIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[5]/ul/li/a")
	 private List<WebElement> healthCareIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[6]/ul/li/a")
	 private List<WebElement> artistsIndustriesList;
	
	@FindBy(xpath = ".//*[@id='directory']/article[2]/div[7]/ul/li/a")
	 private List<WebElement> othersIndustriesList;
	
	
	@FindBy(css=".professionals>div>div[class='user-info']>div>div[class='identity']>a>*[class='name']")
	private List<WebElement> employeeList;
	
	@FindBy(css = ".framing-text>p")
	private WebElement framingText;
	

	@FindBy(css = "div[class='industry']>div>.chosen-single>span")
	private WebElement selectedIndustryOnSubPage;
	
	@FindBy(css = "aside[id='sidebar']>div[id='industries']>div>div>div[class='chosen-drop']>ul>li")
	private WebElement industryDropDownOnSideBar;
	
	@FindBy(css=".map>img")
	private WebElement mapOnSubPage;
	
	@FindBy(css="aside[id='sidebar']>div[id='states']>div>div>a>span")
	private WebElement stateDropDownElement;
	
	@FindBy(css="aside[id='sidebar']>div[id='states']>div>div>div>ul>li")
	private List<WebElement> stateList;
	
	@FindBy(css="aside[id='sidebar']>div[id='cities']>div>div>a>span")
	private WebElement cityDropDownElement;
	
	@FindBy(css="aside[id='sidebar']>div[id='cities']>div>div>div>ul>li")
	private List<WebElement> cityList;
	
	@FindBy(css=".content-bar>h1")
	private WebElement finalHeaderContent;
	
	@FindBy(xpath="//div[@class='breadcrumb-container']/ul/li/a/span")
	private List<WebElement> breadCrumbText;

	public WebElement getInsuranceHeadingText() {
		return insuranceHeadingText;
	}
	
	public WebElement getRealtorsHeadingText() {
		return RealtorsHeadingText;
	}

	public WebElement getAutoProfessionHeadingText() {
		return autoProfessionHeadingText;
	}

	public WebElement getHomeContractorsHeadingText() {
		return homeContractorsHeadingText;
	}

	public WebElement getHealthCareHeadingText() {
		return healthCareHeadingText;
	}

	public WebElement getArtistsHeadingText() {
		return artistsHeadingText;
	}
	
	public WebElement getRecommendProfessionalsText() {
		return recommendProfessionalsText;
	}

	public WebElement getIndustryHeading() {
		return industryHeading;
	}
	
	public WebElement getRealtorsHeading() {
		return RealtorsHeading;
	}

	public WebElement getAutoProfessionHeading() {
		return autoProfessionHeading;
	}

	public WebElement getHomeContractorsHeading() {
		return homeContractorsHeading;
	}

	public WebElement getHealthCareHeading() {
		return healthCareHeading;
	}

	public WebElement getArtistsHeading() {
		return artistsHeading;
	}

	public WebElement getOthersHeading() {
		return othersHeading;
	}

	public List<WebElement> getRealtorsIndustriesList() {
		return realtorsIndustriesList;
	}

	public List<WebElement> getAutoProfessionalIndustriesList() {
		return autoProfessionalIndustriesList;
	}

	public List<WebElement> getHomeContractorsIndustriesList() {
		return homeContractorsIndustriesList;
	}

	public List<WebElement> getHealthCareIndustriesList() {
		return healthCareIndustriesList;
	}

	public List<WebElement> getArtistsIndustriesList() {
		return artistsIndustriesList;
	}

	public List<WebElement> getOthersIndustriesList() {
		return othersIndustriesList;
	}

	public WebElement getInsuranceHeading() {
		return insuranceHeading;
	}

	public List<WebElement> getInsuranceIndustriesList() {
		return insuranceIndustriesList;
	}

	
	public WebElement getHeadingPopularIndustries() {
		return headingPopularIndustries;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}

	public WebElement getZipcodeInput() {
		return zipcodeInput;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getDirectoryPageHeading() {
		return directoryPageHeading;
	}
	
	//old directory getters
	public List<WebElement> getIndustries(){
		return driver.findElements(By.cssSelector(cssIndustries));
	}
	
	public List<WebElement> getSearchData(){
		return driver.findElements(By.cssSelector(highlightable));
	}
	 
	public List<WebElement> getStates(){
		return driver.findElements(By.cssSelector(cssState));
	}
	
	public List<WebElement> getCities(){
		return driver.findElements(By.cssSelector(cssCity));
	}
	
	public String getSearchTermOnCompanyPage(){
		return driver.findElement(By.cssSelector(searchTerm)).getText();
	}
	
	public WebElement get_companyDropDown(){
		return companyDropDown;
	}
	
	public List<WebElement> get_companyFromDropDown(){
		return driver.findElements(By.cssSelector(companiesInList));
	}
	
	public WebElement get_stateDropDown(){
		return stateDropDown;
	}
	
	public List<WebElement> get_stateFromDropDown(){
		return driver.findElements(By.cssSelector(statesInList));
	}
	
	public WebElement get_cityDropDown(){
		return cityDropDown;
	}
	
	public List<WebElement> get_cityFromDropDown(){
		return driver.findElements(By.cssSelector(citiesInList));
	}
	
	public List<WebElement> get_industryList(){
		return industryList;
	}
	
	
	public List<WebElement> get_employeeList(){
		return employeeList;
	}
	
	public WebElement get_framingText(){
		return framingText;
	}
	
	
	public WebElement get_mapOnSubPage(){
		return mapOnSubPage;
	}
	
	public WebElement get_stateDropDownElement(){
		return stateDropDownElement;
	}
	
	public List<WebElement> get_stateList(){
		return stateList;
	}
	
	public WebElement get_cityDropDownElement(){
		return cityDropDownElement;
	}
	
	public List<WebElement> get_cityList(){
		return cityList;
	}
	
	public WebElement get_finalHeaderContent(){
		return finalHeaderContent;
	}
	
	public List<WebElement> get_breadCrumbText(){
		return breadCrumbText;
	}
	
	public WebElement get_zipcodeInput(){
		return zipcodeInput;
	}
	
	public WebElement get_zipcodeOnEmployeePersonalInfo(){
		return zipcodeOnEmployeePersonalInfo;
	}
	
	// End of old directory getters
}