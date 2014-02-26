package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

// Verify content of IFrame on Page:- On Your Website
public class OnYourWebsiteUi extends BaseUi{

	public OnYourWebsiteUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}
	
	/******************Web Elements on UI************************/
	
	@FindBy(css="div[class='splash-section']>div>div[class='text five columns push-seven']>h1")
	private WebElement splashText;
	
	@FindBy(css= "div[class='button-container']>a[class='large orange button hide-for-small']")
	private WebElement getStartedNowButton;
	
	@FindBy(xpath=".//*[@id='widgetStyle']/div[2]/div/a[1]")
	private WebElement reviewsStyleButton;
	
	@FindBy(xpath=".//*[@id='widgetStyle']/div[2]/div/a[2]")
	private WebElement recommendStyleButton;
	
	@FindBy(css="div[class='button-container']>a[class='button show-email-dialog']")
	private WebElement sendToMyWebmasterButton_first;
	
	@FindBy(css="div[class='custom dropdown']>a[class= 'selector']")
	private WebElement selectThemeDropDown;
	
	@FindBy(css="class='custom dropdown']>a[class= 'current']")
	private WebElement currentSelectedTheme;
	
	@FindBy(css = "div[class = 'custom dropdown open']>ul>li:nth-child(3)")
	private WebElement selectedTheme;
	
	@FindBy(css="input[name='height']")
	private WebElement heightOfFrame;
	
	@FindBy(css= "input[name='width']")
	private WebElement widthOfFrame;
	
	public String showFooterRadio="radio1";
	
	public String hideFooterRadio="radio2";
	
	@FindBy(xpath=".//div[@id='stikWidgetFrame']/iframe")
	private WebElement iFrameObject;
	
	@FindBy(css= "div[id='reviewsWidgetWrapper']")
	private WebElement iFrameReviewWidgetWrapper;
	
	@FindBy(css= "div[id='reviewsWidgetWrapper']>div[class= 'header']")
	private WebElement iFrameheader;
	
	@FindBy(css = "div[class='header']>div[class='avatar']>a")
	private WebElement iFrameProfilePic;
	
	@FindBy(css="div[class='info']>div[class='name']>a")
	private WebElement iFrameProfileName;
	
	@FindBy(css="div[class='info']>div[class='detail']")
	private WebElement iFrameProfileDetails;
	
	@FindBy(css= ".small.button.recommend")
	private WebElement iFrameReviewMeButton;
	
	@FindBy(css="div[class='content']>ul[class='reviews']")
	private WebElement isIFrameReviewListPresent;
	
	public String iFrameReviewsList= "div[class='content']>ul[class='reviews']>div[class='review row']";
	public String iFrameReviewRatings="div[class='content']>ul[class='reviews']>div[class='review row']:nth-child(index)>div>div>div[class='rating']>i[class='icon-star']";
	
	@FindBy(css="div[id='reviewsWidgetWrapper']>div[class='cta']>a")
	private WebElement iFrameFooter;
	

	
	public String sendToMyWebMasterButton="document.getElementsByClassName('button show-email-dialog')[0].click()";
	
	@FindBy(css="div[class='reveal-modal large open']>div[class='email-webmaster']>form>input[name='webmasterEmail']")
	private WebElement webMasterEmailTextBox;
	
	@FindBy(css= "div[class='reveal-modal large open']>div[class='email-webmaster']>form>a[class='email-webmaster button']")
	private WebElement emailMyWebMasterButton;

	@FindBy(css="div[class='row']>div[id='alertBox']>div[class='alert-box']>p[]")
	private WebElement successMessageOnSendingEmailToWebMaster_1;
	
	@FindBy(xpath=".//*[@id='alertBox']/div/p")
	private WebElement successMessageOnSendingEmailToWebMaster;
	
	
	@FindBy(xpath=".//*[@class='review row']/div/div/div[1]/img")
	private WebElement firstReviewerInIframe_ProfilePic;
	
	@FindBy(xpath=".//*[@class='review row']/div/div/div[5]/span")
	private WebElement firstReviewerInIframe_ProfileName;
	
	@FindBy(xpath=".//*[@class='review row']/div/div[1]/p")
	private WebElement firstReviewerInIframe_ProfileDetails;
	
	@FindBy(xpath=".//*[@class='review row']/div/div/div[6]/div")
	private WebElement firstReviewerInIframe_ProfileDate;
	
		
	/**********************Getter Methods for Web Elements*******************************/
	
	public WebElement get_GetStartedNow(){
		//executeJavaScript("document.getElementsByClassName('large alert button')[0].click()");
		return getStartedNowButton;
	}
	
	public WebElement get_sendToMyWebmasterButton_first(){
		return sendToMyWebmasterButton_first;
	}
	
	public WebElement get_reviewsStyleButton(){
		return reviewsStyleButton;
	}
	
	public WebElement get_recommendStyleButton(){
		return recommendStyleButton;
	}
	
	public WebElement get_selectThemeDropDown(){
		return selectThemeDropDown;
	}
	
	public WebElement get_selectedTheme(){
		return selectedTheme;
	}
	
	public WebElement get_heightOfFrame(){
		return heightOfFrame;
	}
	
	public WebElement get_widthOfFrame(){
		return widthOfFrame;
	}
	
	public List<WebElement> get_OptionInTheme(){
		return driver.findElements(By.tagName("option"));
	}
	
	public void get_showFooterRadio(){
		executeJavaScript("document.getElementById('radio1').click()");
	}
	
	public void get_hideFooterRadio(){
		executeJavaScript("document.getElementById('radio2').click()");
	}
	
	public WebElement get_iFrameObject(){
		return iFrameObject;
	}
	
	public WebElement get_iFrameReviewWidgetWrapper(){
		return iFrameReviewWidgetWrapper;
	}
	
	public WebElement get_iFrameheader(){
		return iFrameheader;
	}
	
	public WebElement get_iFrameProfilePic(){
		return iFrameProfilePic;
	}
	
	public WebElement get_iFrameProfileName(){
		return iFrameProfileName;
	}
	public WebElement get_iFrameProfileDetails(){
		return iFrameProfileDetails;
	}
	
	public WebElement get_iFrameReviewMeButton(){
		return iFrameReviewMeButton;
	}
	
	public WebElement get_isIFrameReviewsListPresent(){
		return isIFrameReviewListPresent;
	}
	
	public List<WebElement> get_iFrameReviewsList(){
		return driver.findElements(By.cssSelector(iFrameReviewsList));
	}
	
	public WebElement get_iFrameFooter(){
		return iFrameFooter;
	}
	
	public void get_sendToMyWebMasterButton(){
		executeJavaScript(sendToMyWebMasterButton);
	}
	

	
	public WebElement get_webMasterEmailTextBox(){
		return webMasterEmailTextBox;
	}
	
	public WebElement get_emailMyWebMasterButton(){
		return emailMyWebMasterButton;
	}
	
	public WebElement get_successMessageOnSendingEmailToWebMaster(){
		return successMessageOnSendingEmailToWebMaster;
	}
	
	
	public WebElement get_firstReviewerInIframe_ProfilePic(){
		return firstReviewerInIframe_ProfilePic;
	}
	
	public WebElement get_firstReviewerInIframe_ProfileName(){
		return firstReviewerInIframe_ProfileName;
	}
	
	public WebElement get_firstReviewerInIframe_ProfileDetails(){
		return firstReviewerInIframe_ProfileDetails;
	}
	
	public WebElement get_firstReviewerInIframe_ProfileDate(){
		return firstReviewerInIframe_ProfileDate;
	}
	
	public WebElement get_splashText(){
		return splashText;
	}
	
	public List<WebElement> get_iFrameReviewRatings(int index){
		return driver.findElements(By.cssSelector(iFrameReviewRatings.replaceAll("index", String.valueOf(index))));
	}
}
