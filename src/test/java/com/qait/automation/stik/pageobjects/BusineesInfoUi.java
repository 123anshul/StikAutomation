package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.qait.automation.stik.util.SizzleSelector;

public class BusineesInfoUi extends  BaseUi{

	public BusineesInfoUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	
	}

	@FindBy(css="div[class='three columns setting-nav']>dl[class='tabs vertical hide-for-small']>dd>a[href='#businessInformation']")
	private WebElement businessInfoTab;
	
	@FindBy(css="div[id='statesDivAddAnother']>a[class='small button']")
	private WebElement addAnotherButton;
	
	
	@FindBy(css="div[id='businessInfoForm']>div[class='businessInfoItem summary']>div[id='summaryDiv']>textarea")
	private WebElement summaryTextArea;
	
	@FindBy(css="div[id='businessInfoForm']>div[class='businessInfoItem cities']>div>div>ul>li>input")
	private WebElement cityTextBox;
	
	@FindBy(css="div[id='businessInfoForm']>div[class='businessInfoItem cities']>div>div>div>div[class='textboxlist-autocomplete-placeholder']")
	private WebElement cityTextBoxSuggestionPlaceholder;
	
	
	@FindBy(css="div[class='button_action_container save']>a")
	private WebElement saveButtonOnBusinessInfoPage;
	
	@FindBy(css="div[class='businessInfoItem']>div>a[class='current']")
	private WebElement currentIndustry;
	
	
	@FindBy(css="div[class='textboxlist']>ul>li>a")
	private WebElement crossButtonForExistingCity;
	
	
	private String industrySelect="div[class='businessInfoItem']>div>ul>li:nth-child(index)"; 
	private String industryDropDownArrow="div[class='businessInfoItem']>div>a[class='selector']";
	
	private String stateDropDowns="div[class='businessInfoItem states']>div[class='businessInfoInput']>div[class='custom dropdown']";
	private String citySuggestionList="div[class='businessInfoItem cities']>div[class='businessInfoInput']>div>div>ul>li";
	private String existingCitiesList= "div[class='textboxlist']>ul>li";

	
	public WebElement get_businessInfoTab(){
		return businessInfoTab;
	}
	
	public WebElement get_SelectIndustryDropDown(){
		return driver.findElement(By.cssSelector(industrySelect.replaceAll("index", String.valueOf(5))));
	}
	
	public WebElement get_industryDropDownArrow(){
		return driver.findElement(By.cssSelector(industryDropDownArrow));
	}
	
	public WebElement getIndustrySelected(int index){
		return driver.findElement(By.cssSelector(industrySelect.replaceAll("index", String.valueOf(index))));
	}
	
	
	public WebElement get_addAnotherButton(){
		return addAnotherButton;
	}

	
	public List<WebElement> get_stateDropDown(){
		return driver.findElements(By.cssSelector(stateDropDowns));
	}
	
	public WebElement get_summaryTextArea(){
		return summaryTextArea;
	}
	
	public WebElement get_cityTextBox(){
		return cityTextBox;
	}
	
	public WebElement get_cityTextBoxSuggestionPlaceholder(){
		return cityTextBoxSuggestionPlaceholder;
	}
	
	public WebElement get_saveButtonOnBusinessInfoPage(){
		return saveButtonOnBusinessInfoPage;
	}
	public WebElement get_citySuggestionList(){
		return driver.findElement(By.cssSelector(citySuggestionList));
	}
	
	public String get_currentIndustry(){
		return currentIndustry.getText();
	}
	
	public List<WebElement> get_existingCitiesList(){
		return driver.findElements(By.cssSelector(existingCitiesList));
	}
	public WebElement get_crossButtonForExistingCity(){
		return crossButtonForExistingCity;
	}
}
