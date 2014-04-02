package com.qait.automation.stik.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class CompanyPageUi extends SearchPageUi {
	
	public CompanyPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}
	
	@FindBy(css="a[href='/company/stik']")
	private WebElement stikEmployeePage;
	
	@FindBy(xpath=".//*[@id='companiesSelect']/option[@selected and @value='/company/stik/stik']")
	private WebElement companySelectDropDownDefault;
	
	@FindBy(xpath="//select[@id='companiesSelect']")
	private WebElement companySelectDropDown;
	
	@FindBy(xpath=".//*[@id='companiesSelect_chosen']/a/div/b")
	private WebElement companyDropDownArrow;
	
	@FindBy(xpath="//div[@id='companiesSelect_chosen']/div/ul/li")
	private List<WebElement> companySelectDropDownList;
	
	@FindBy(xpath="//div[@id='companiesSelect_chosen']/div/div/input")
	private WebElement companySearchTextBoxInDropDown;
	
	@FindBy(xpath=".//*[@id='listings']/div[1]/div[1]/ul/li[2]/a/span")
	private WebElement companyName;
	
	@FindBy(xpath=".//*[@id='statesSelect_chosen']/a/div/b")
	private WebElement stateDropDownArrow;
	
	@FindBy(xpath=".//*[@id='statesSelect_chosen']/div/div/input")
	private WebElement stateSearchTextBoxInDropDown;
	
	@FindBy(xpath=".//*[@id='statesSelect_chosen']/div/ul/li")
	private List<WebElement> stateSelectDropDownList;
	
	@FindBy(xpath=".//*[@id='listings']/div[1]/div[1]/ul/li[3]/a/span")
	private WebElement stateName;
	
	@FindBy(xpath=".//*[@id='citiesSelect_chosen']/a/div/b")
	private WebElement cityDropDownArrow;
	
	@FindBy(xpath="//div[@id='citiesSelect_chosen']/div/div/input")
	private WebElement citySearchTextBoxInDropDown;
	
	@FindBy(xpath="//div[@id='citiesSelect_chosen']/div/ul/li")
	private List<WebElement> citySelectDropDownList;
	
	@FindBy(xpath=".//*[@id='listings']/div[1]/div[1]/ul/li[4]/a/span")
	private WebElement cityName;
	
	@FindBy(xpath=".//*[@id='companyContact']/div/a[2]")
	private WebElement companyWebSiteLink;
	
	@FindBy(css="#companyContact>header")
	private WebElement companyContactHeading;
	
	@FindBy(xpath=".//*[@id='companyContact']/div/a[1]")
	private WebElement companyContactNumber;
	
	@FindBy(css=".blur-header")
	private WebElement stikCoverImage;
	
	@FindBy(css=".professionals>div")
	private List<WebElement> employeeList;
	
	@FindBy(xpath=".//*[@id='listings']/div[2]/div[2]/div[1]/div[1]/div/div[1]/a")
	private WebElement employeeName;
	
	@FindBy(css="h1[itemprop='name']")
	private WebElement nameOnProfile;
	
	@FindBy(css="li[class='name logo']>a")
	private WebElement stikLogo;
	
	
	public WebElement get_stikEmployeePage(){
		return stikEmployeePage;
	}
	
	public WebElement get_companySelectDropDownDefault(){
		return companySelectDropDownDefault;
	}
	
	public WebElement get_companySelectDropDown(){
		return companySelectDropDown;
	}
	
	public List<WebElement> get_companySelectDropDownList(){
		return companySelectDropDownList;
	}
	
	public WebElement get_companyName(){
		return companyName;
	}
	
	public WebElement get_stateName(){
		return stateName;
	}
	
	public WebElement get_cityName(){
		return cityName;
	}
	
	public WebElement get_EmployeeName(){
		return employeeName;
	}
	
	public WebElement get_NameOnProfile(){
		return nameOnProfile;
	}
	
	public WebElement get_companyWebsiteLink(){
		return companyWebSiteLink;
	}
	
	public WebElement get_companyContactHeading(){
		return companyContactHeading;
	}
	
	public WebElement get_companyContactNumber(){
		return companyContactNumber;
	}
	
	public WebElement get_stikCoverImage(){
		return stikCoverImage;
	}
	
	public WebElement get_stikLogo(){
		return stikLogo;
	}
	
	public List<WebElement> get_EmployeeList(){
		return employeeList;
	}
	
	public WebElement get_companyDropDownArrow(){
		return companyDropDownArrow;
	}
	
	public WebElement get_companySearchTextBoxInDropDown(){
		return companySearchTextBoxInDropDown;
	}
	
	public WebElement get_stateDropDownArrow() {
		return stateDropDownArrow;
	}
	
	public WebElement get_stateSearchTextBoxInDropDown() {
		return stateSearchTextBoxInDropDown;
	}
	
	public List<WebElement> get_stateSelextDropDownList(){
		return stateSelectDropDownList;
	}
	
	public WebElement get_cityDropDownArrow(){
		return cityDropDownArrow;
	}
	
	public WebElement get_citySearchTextBoxInDropDown(){
		return citySearchTextBoxInDropDown;
	}
	
	public List<WebElement> get_citySelectDropDownList(){
		return citySelectDropDownList;
	}
}
