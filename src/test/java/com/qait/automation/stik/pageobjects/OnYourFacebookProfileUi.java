package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class OnYourFacebookProfileUi extends BaseUi{

	public OnYourFacebookProfileUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);

	}

	@FindBy(css="div[id='install']>h2")
	private WebElement splashText;
	
	@FindBy(css="a[class='js-add-facebook-collection large facebook-button round button']")
	private WebElement getStartedButton;
	
	@FindBy(xpath=".//div[@id='message']/h5[1]")
	private WebElement connectToFacebookMessage;
	
	@FindBy(xpath=".//*[@id='message']/h3")
	private WebElement addToProfileTab;
	
	@FindBy(xpath=".//*[@id='message']/h5[2]")
	private WebElement addToProfileMessage;
	
	@FindBy(css="div[id='message']>h5>a")
	private WebElement facebookPageLink;
	
	
	/*********************** Getter Methods for WebElements************************************/
	public WebElement get_getStartedButton(){
		return getStartedButton;
	}
	
	public WebElement get_connectToFacebookMessage(){
		return connectToFacebookMessage;
	}
	
	public WebElement get_addToProfileTab(){
		return addToProfileTab;
	}
	
	public WebElement get_addToProfileMessage(){
		return addToProfileMessage;
	}
	
	public WebElement get_facebookPageLink(){
		return facebookPageLink;
	}
	
	public WebElement get_splashText(){
		return splashText;
	}
}
