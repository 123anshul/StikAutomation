package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class DemoUI_Temp extends BaseUi {

	
	public DemoUI_Temp(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	/*****************WEB UI defined *****************************/
	
	@FindBy(css = ".content-bar>nav>h1")
	private WebElement directoryPageHeading;

	@FindBy(css = ".chosen-single>span")
	private WebElement selectIndustry;
	
	@FindBy(css = ".search-zip-input")
	private WebElement zipcodeInput;
		
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
	
}
