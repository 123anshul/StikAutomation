package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ProfileInfoPageUi extends BaseUi{

	public ProfileInfoPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	/******** Facebook UI elements ********/
	@FindBy(css = "li[id='accountInformationTab']>div>div[class='seven columns']>h2")
	private WebElement profilePageHeading;
	
	private String profilePageHead = "Profile Info";
	
	@FindBy(css = "input[id='vch_first_name']")
	private WebElement firstNameTextBox;
	
	@FindBy(css = "input[id='vch_last_name']")
	private WebElement lastNameTextBox;
	
	@FindBy(css = "input[id = 'vch_company']")
	private WebElement companyTextBox;
	
	@FindBy(css = "input[id='vch_username']")
	private WebElement userNameTextBox;
	
	@FindBy(css = "input[id='vch_email']")
	private WebElement emailTextBox;
	
	@FindBy(css = "input[id='vch_phone_full']")
	private WebElement phoneNumberTextBox;
	
	@FindBy(css = "input[id='vch_title']")
	private WebElement titleTextBox;
	
	@FindBy(xpath=".//*[@id='vch_license']")
	private WebElement licenseTextBox;
	
	@FindBy(css = "input[id='vch_website']")
	private WebElement websiteTextBox;
	
	@FindBy(css = "input[id='vch_address']")
	private WebElement addressTextBox;
	
	@FindBy(css = "input[id='vch_city']")
	private WebElement cityNameTextBox;
	
	@FindBy(css = "select[id='int_state_id']")
	private WebElement stateIdSelect;
	
	@FindBy(css = "select[id='int_country_id']")
	private WebElement countryIdSelect;
	
	@FindBy(css = "input[id='txt_zip']")
	private WebElement zipCodeTextBox;
	
	@FindBy(css = "div[class = 'avatar-and-figures']>img")
	private WebElement imageSrc;
	
	@FindBy(css = "div[class = 'avatar-and-figures']>a[id= 'change_picture_photo']")
	private WebElement changePictureLink;
	
	@FindBy(css="a[id='outsideTheUs']")
	private WebElement outSideUSLink;
	
	private String stateDropDown="div[id='accountInfoForm']>div";
	
	
	private String dropdownArrow=".//*[@id='accountInfoForm']/div[12]/div/a[2]";
	private String stateToSelectFromList=".//*[@id='accountInfoForm']/div[12]/div/ul/li[6]";

//	@FindBy(css = "a[class='button alert large button_action']")
//	private WebElement saveButton;
	
	@FindBy(linkText = "Save")
	private WebElement saveButton;
	
	
	
	/************ Getter Methods to get WEB Elements ************************/
	public WebElement get_profilePageHeading(){
		return profilePageHeading;
	}
	
	public String get_profilePageHead(){
		return profilePageHead;
	}
	
	public WebElement get_firstNameTextBox(){
		return firstNameTextBox;
	}
	
	public WebElement get_lastNameTextBox(){
		return lastNameTextBox;
	}
	
	public WebElement get_saveButton(){
		return saveButton;
	}
	
	public WebElement get_companyTextBox(){
		return companyTextBox;
	}
	
	public WebElement get_userNameTextBox(){
		return userNameTextBox;
	}
	
	public WebElement get_emailTextBox(){
		return emailTextBox;
	}
	
	public WebElement get_phoneNumberTextBox(){
		return phoneNumberTextBox;
	}
	
	public WebElement get_titleTextBox(){
		return titleTextBox;
	}
	
	public WebElement get_licenseTextBox(){
		return licenseTextBox;
	}
	
	public WebElement get_websiteTextBox(){
		return websiteTextBox;
	}
	
	public WebElement get_addressTextBox(){
		return addressTextBox;
	}
	
	public WebElement get_cityNameTextBox(){
		return cityNameTextBox;
	}
	
	public WebElement get_zipCodeTextBox(){
		return zipCodeTextBox;
	}
	
	public WebElement get_imageSrc(){
		return imageSrc;
	}
	
	public WebElement get_changePictureLink(){
		return changePictureLink;
	}
	
	public WebElement get_outSideUSLink(){
		return outSideUSLink;
	}
	
	public List<WebElement> get_stateDropDown(){
		return driver.findElements(By.cssSelector(stateDropDown));
	}
	

	public WebElement get_stateDropDownSingle(){
		return driver.findElement(By.cssSelector(stateDropDown));
	}
	
	public WebElement get_dropdownArrow(){
		return driver.findElement(By.xpath(dropdownArrow));
	}
	
	public WebElement get_stateToSelectFromList(){
		return driver.findElement(By.xpath(stateToSelectFromList));
	}
}
