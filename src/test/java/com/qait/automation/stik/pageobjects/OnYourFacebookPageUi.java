package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class OnYourFacebookPageUi extends BaseUi {

	public OnYourFacebookPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}
	
	/******************Web Elements on UI************************/
	
	@FindBy(css="div[class='ui-install']>div[id='install']>h2")
	private WebElement splashText;
	
	@FindBy(css="div[class='button-container']>a[id='ask-facebook-tab']")
	private WebElement fGetStartedButton;
	
	@FindBy(css="div[class='twelve columns js-facebook-page-picker-container']>h4")
	private WebElement couldNotFindMessage;

	@FindBy(css="div[class='twelve columns js-facebook-page-picker-container']>p>a")
	private WebElement fbLinkToCreatePage;
	
	public String numberOfPagesOnFacebook=" div[class='row']>div[class='seven columns centered pages']>div[class='page']";

	
	public String allDoneInstacnes= "//div[contains(text(),'Done')]";
	public String allSelectInstances= "//a[contains(text(),'Select')]";
	
	
	public WebElement get_fGetStartedButton(){
		return fGetStartedButton;
	}
	public List<WebElement> get_numberOfPagesOnFacebook(){
		return driver.findElements(By.cssSelector(numberOfPagesOnFacebook));
	}

	public List<WebElement> get_allDoneInstacnes(){
		return driver.findElements(By.xpath(allDoneInstacnes));
	}
	
	public List<WebElement> get_allSelectInstances(){
		return driver.findElements(By.xpath(allSelectInstances));
	}
	
	public WebElement get_couldNotFindMessage(){
		return couldNotFindMessage;
	}
	
	public WebElement get_fbLinkToCreatePage(){
		return fbLinkToCreatePage;
	}
	
	public WebElement get_splashText(){
		return splashText;
	}

}
