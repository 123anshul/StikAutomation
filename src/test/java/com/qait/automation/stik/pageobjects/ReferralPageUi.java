package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ReferralPageUi extends BaseUi{

	public ReferralPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
		
	}
	
	/************************************UI Elements for fresh user***************************************/
	
	@FindBy(css="div[id='referralInbox']>div>h1")
	private WebElement yourReferralText;
	
	@FindBy(css="div[class='panel tip ui-alert']>h5")
	private WebElement alertHeading;
	
	@FindBy(css="div[class='panel tip ui-alert']>p>strong")
	private WebElement alertText;
	
	@FindBy(css="a[href='/zf/profile/settings#referrals']")
	private WebElement settingsButton;
	
	@FindBy(css="dl[class='tabs contained']>dd[class='active']>a>span")
	private WebElement yourProspectsNumber;
	
	@FindBy(css="ul[class='tabs-content contained']>li>ul>li>div>h2")
	private WebElement noReferralMessageHeading;
	
	@FindBy(css="ul[class='tabs-content contained']>li>ul>li>div>img")
	private WebElement noreferralImage;
	
	@FindBy(css="div[class='control']>a")
	private WebElement startCollectingReviewsButton;
	
	@FindBy(css="div[class='contact-cta js-lead-form']>form>label[class='call-us']>p")
	private WebElement callUsNumber;
	
	@FindBy(css="input[name='phone']")
	private WebElement callMeTextBox;
	
	@FindBy(css="button[class='small orange button expand postfix']")
	private WebElement requestConsultationButton;
	
	@FindBy(css="div[class='contact-cta js-lead-form success']>form>label>div[class='alert-box success']")
	private WebElement successMessageOnRequestingConsultation;
	
	@FindBy(css=".close")
	private WebElement closeButtonForSuccessMessage;
	
	/*******************************UI Elements for already referred user********************************/
	
	@FindBy(css="ul[class='referral-message-container']>li>div[class='center-column']>div>div>div>a>span[class='info']")
	private List<WebElement> listOfReferrals_Name;
	
	@FindBy(css="ul[class='referral-message-container']>li>div[class='center-column']>div[class='supporter']>div[class='name']")
	private List<WebElement> listOfReferrals_Supporter;
	
	@FindBy(css="div[class='date']")
	private List<WebElement> referralDates;
	
	/***************************Referral Setting Page********************************************/
	
	@FindBy(css="li[id='referralsTab']>h2")
	private WebElement settingsReferralText;
	
	@FindBy(css="li[id='referralsTab']>form>fieldset>label:nth-child(3)>input")
	private WebElement yesRadioButton;
	
	@FindBy(css="li[id='referralsTab']>form>fieldset>label:nth-child(4)>input")
	private WebElement noRadioButton;
	
	@FindBy(css="div[id='reminderEmailBody']")
	private WebElement emailBodySection;
	
	@FindBy(css="div[id='reminderEmailBody']>p>textarea")
	private WebElement emailBodyTextArea;
	
	@FindBy(css="li[id='referralsTab']>form>button")
	private WebElement saveButton;
	
	@FindBy(css="div[id='alertBox']")
	private WebElement successAlert;
	
	/***********************************Getter Functions************************************************/
	
	public WebElement get_yourReferralText(){
		return yourReferralText;
	}
	
	public WebElement get_alertHeading(){
		return alertHeading;
	}
	
	public WebElement get_alertText(){
		return alertText;
	}
	
	public WebElement get_settingsButton(){
		return settingsButton;
	}
	
	public WebElement get_yourProspectsNumber(){
		return yourProspectsNumber;
	}
	
	public WebElement get_noReferralMessageHeading(){
		return noReferralMessageHeading;
	}
	
	public WebElement get_noreferralImage(){
		return noreferralImage;
	}
	
	public WebElement get_startCollectingReviewsButton(){
		return startCollectingReviewsButton;
	}
	
	public WebElement get_callUsNumber(){
		return callUsNumber;
	}
	
	public WebElement get_callMeTextBox(){
		return callMeTextBox;
	}
	
	public WebElement get_requestConsultationButton(){
		return requestConsultationButton;
	}
	
	public WebElement get_successMessageOnRequestingConsultation(){
		return successMessageOnRequestingConsultation;
	}
	
	public WebElement get_closeButtonForSuccessMessage(){
		return closeButtonForSuccessMessage;
	}
	
	public List<WebElement> get_listOfReferrals_Name(){
		return listOfReferrals_Name;
	}
	
	public List<WebElement> get_listOfReferrals_Supporter(){
		return listOfReferrals_Supporter;
	}
	
	public List<WebElement> get_referralDates(){
		return referralDates;
	}
	
	public WebElement get_settingsReferralText(){
		return settingsReferralText;
	}

	public WebElement get_yesRadioButton(){
		return yesRadioButton;
	}
	
	public WebElement get_noRadioButton(){
		return noRadioButton;
	}
	
	public WebElement get_emailBodySection(){
		return emailBodySection;
	}
	
	public WebElement get_emailBodyTextArea(){
		return emailBodyTextArea;
	}
	
	public WebElement get_saveButton(){
		return saveButton;
	}
	
	public WebElement get_successAlert(){
		return successAlert;
	}
}
