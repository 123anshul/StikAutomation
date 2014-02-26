package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class EnterprisePageUi extends HomePageUi {
	
	public EnterprisePageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	@FindBy(css="section[class='active']")
	private WebElement activeTab;
	
	@FindBy(css="section>a[href='/enterprise']>h4")
	private WebElement overviewTabText;
	
	@FindBy(css="section>a[href='/enterprise']")
	private WebElement overviewTabLink;
	
	@FindBy(css="section>a[href='/enterprise/roi']>h4")
	private WebElement roiTabText;
	
	@FindBy(css="section>a[href='/enterprise/roi']")
	private WebElement roiTabLink;
	
	@FindBy(css="section>a[href='/enterprise/features']>h4")
	private WebElement featuresTabText;
	
	@FindBy(css="section>a[href='/enterprise/features']")
	private WebElement featuresTabLink;
	
	@FindBy(css="section[class='video']")
	private WebElement vedioSection;
	
	@FindBy(css="div[id='collectReviews']>article>section>div[class='text']>h2")
	private WebElement getReviewText;
	
	@FindBy(css="div[id='collectReviews']>article>section>div[class='image']>a>img[class='desktop']")
	private WebElement getReviewImage;
	
	@FindBy(css="div[id='collectReviews']>article>section>div[class='text']>p>a")
	private WebElement getReviewLearnMoreLink;
	
	@FindBy(css="div[id='websiteModal']")
	private WebElement websiteModal;
	
	@FindBy(css="a[data-reveal-id='websiteModal']>img[class='desktop']")
	private WebElement websiteModalImage;
	
	@FindBy(css="div[id='websiteModal']>div>div>h3")
	private WebElement websiteModalText;
	
	@FindBy(css="div[id='websiteModal']>div>div>img:nth-child(2)")
	private WebElement websiteModalPersonalProfileImage;
	
	@FindBy(css="div[id='websiteModal']>div>div>img:nth-child(3)")
	private WebElement websiteModalComapnyPageImage;
	
	@FindBy(css="div[id='websiteModal']>div>div>h3")
	private WebElement websiteModalCross;
	
	@FindBy(css="div[id='websiteModal']>div>div>h3")
	private WebElement reviewMarketingText;
	
	@FindBy(css="div[id='websiteModal']>div>div>h3")
	private WebElement reviewMarketingLeanMoreLink;
	
	@FindBy(css="div[id='widgetModal']")
	private WebElement widgetModal;
	
	@FindBy(css="a[data-reveal-id='widgetModal']>img[class='desktop']")
	private WebElement widgetModalImage;
	
	@FindBy(css="div[id='widgetModal']>div>div>h3")
	private WebElement widgetModalText;
	
	@FindBy(css="div[id='widgetModal']>div>div>a")
	private WebElement widgetModalCross;
	
	@FindBy(css="div[id='referralsCollection']>article>section>h2")
	private WebElement getReferalText;
	
	@FindBy(css="div[id='referralsCollection']>article>section>img")
	private WebElement getReferalImage;
	
	@FindBy(css="div[id='roiHero']>h1")
	private WebElement roiPageText;
	
	@FindBy(css="div[id='roiHero']>img")
	private WebElement roiPageImage;
	
	@FindBy(css="div[id='marketingLift']>article>section>h2")
	private WebElement roiMarketingLiftText;
	
	@FindBy(css="div[id='marketingLift']>article>section>img")
	private WebElement roiMarketingLiftImage;
	
	@FindBy(css="div[id='salesLift']>article>section>div[class='text']>h2")
	private WebElement roiSalesLiftText;
	
	@FindBy(css="div[id='salesLift']>article>section>div[class='image']>img")
	private WebElement roiSalesLiftImage;
	
	@FindBy(css="div[id='referralsLift']>article>section>div[class='text']>h2")
	private WebElement roiReferralsLiftText;
	
	@FindBy(css="div[id='referralsLift']>article>section>div[class='image']>img")
	private WebElement roiReferralsLiftImage;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>h2")
	private WebElement roiReferralsCalculatorText;
	
	@FindBy(css="input[id='submittedClientTotal']")
	private WebElement roiReferralsCalculatorInputbox;
	
	@FindBy(css="form[class='js-roi-calculator']>button")
	private WebElement roiReferralsCalculatorButton;
	
	@FindBy(css="td[class='reviews-value']")
	private WebElement roiReferralsReviewCount;
	
	@FindBy(css="td[class='referrals-value']")
	private WebElement roiReferralsCount;
	
	@FindBy(css="td[class='business-value']")
	private WebElement roiBusinessCount;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='caption']>h1")
	private WebElement featuresPageText;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='image']>img")
	private WebElement featuresPageImage;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='caption']>h1")
	private WebElement noSoftwareText;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='image']>img")
	private WebElement noSoftwareImage;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='caption']>h1")
	private WebElement reviewManageText;
	
	@FindBy(css="div[id='featuresHero']>article>section[class='image']>img")
	private WebElement reviewManageImage;
	
	@FindBy(css="div[id='homepageVerification']>article>section>header>h2")
	private WebElement homepageVerificationHeaderText;
	
	@FindBy(css="div[id='homepageVerification']>article>section>div[class='left']>img")
	private WebElement homepageVerificationLeftImg;
	
	@FindBy(css="div[id='homepageVerification']>article>section>div[class='right']>h3")
	private WebElement homepageVerificationRightText;
	
	@FindBy(css="div[id='homepageVerification']>article>section>div[class='middle']>h3")
	private WebElement homepageVerificationMiddleText;
	
	@FindBy(css="div[id='leadGenForm']")
	private WebElement talkToStikLead;
	
	@FindBy(css="input[placeholder='Name']")
	private WebElement talkToStikLeadName;
	
	@FindBy(css="input[placeholder='Email']")
	private WebElement talkToStikLeadEmail;
	
	@FindBy(css="input[placeholder='Phone Number']")
	private WebElement talkToStikLeadPhoneNumber;
	
	@FindBy(css="form>button[type='submit']")
	private WebElement talkToStikLeadSubmitButton;
	
	public WebElement get_activeTab(){
		return activeTab;
	}
	
	public WebElement get_overviewTabText(){
		return overviewTabText;
	}
	
	public WebElement get_overviewTabLink(){
		return overviewTabLink;
	}
	
	public WebElement get_roiTabText(){
		return roiTabText;
	}
	
	public WebElement get_roiTabLink(){
		return roiTabLink;
	}
	
	public WebElement get_featuresTabText(){
		return featuresTabText;
	}
	
	public WebElement get_featuresTabLink(){
		return featuresTabLink;
	}
	
	public WebElement get_vedioSection(){
		return vedioSection;
	}
	
	public WebElement get_getReviewText(){
		return getReviewText;
	}
	
	public WebElement get_getReviewImage(){
		return getReviewImage;
	}
	
	public WebElement get_getReviewLearnMoreLink(){
		return getReviewLearnMoreLink;
	}
	
	public WebElement get_websiteModal(){
		return websiteModal;
	}
	
	public WebElement get_websiteModalImage(){
		return websiteModalImage;
	}
	
	public WebElement get_websiteModalText(){
		return websiteModalText;
	}
	
	public WebElement get_websiteModalPersonalProfileImage(){
		return websiteModalPersonalProfileImage;
	}
	
	public WebElement get_websiteModalComapnyPageImage(){
		return websiteModalComapnyPageImage;
	}
	
	public WebElement get_websiteModalCross(){
		return websiteModalCross;
	}
	
	public WebElement get_widgetModal(){
		return widgetModal;
	}
	
	public WebElement get_widgetModalImage(){
		return widgetModalImage;
	}
	
	public WebElement get_widgetModalCross(){
		return widgetModalCross;
	}
	
	public WebElement get_widgetModalText(){
		return widgetModalText;
	}
	
	public WebElement get_reviewMarketingText(){
		return reviewMarketingText;
	}
	
	public WebElement get_reviewMarketingLeanMoreLink(){
		return reviewMarketingLeanMoreLink;
	}
	

	public WebElement get_getReferalText(){
		return getReferalText;
	}
	
	public WebElement get_getReferalImage(){
		return getReferalImage;
	}
	
	public WebElement get_roiPageText(){
		return roiPageText;
	}
	
	public WebElement get_roiPageImage(){
		return roiPageImage;
	}
	
	public WebElement get_roiMarketingLiftText(){
		return roiMarketingLiftText;
	}
	
	public WebElement get_roiMarketingLiftImage(){
		return roiMarketingLiftImage;
	}
	
	public WebElement get_roiSalesLiftText(){
		return roiSalesLiftText;
	}
	
	public WebElement get_roiSalesLiftImage(){
		return roiSalesLiftImage;
	}
	
	public WebElement get_roiReferralsLiftText(){
		return roiReferralsLiftText;
	}
	
	public WebElement get_roiReferralsLiftImage(){
		return roiReferralsLiftImage;
	}
	
	public WebElement get_roiReferralsCalculatorText(){
		return roiReferralsCalculatorText;
	}
	
	public WebElement get_roiReferralsCalculatorInputbox(){
		return roiReferralsCalculatorInputbox;
	}
	
	public WebElement get_roiReferralsCalculatorButton(){
		return roiReferralsCalculatorButton;
	}
	
	public WebElement get_roiReferralsReviewCount(){
		return roiReferralsReviewCount;
	}
	
	public WebElement get_roiReferralsCount(){
		return roiReferralsCount;
	}
	
	public WebElement get_roiBusinessCount(){
		return roiBusinessCount;
	}
	
	public WebElement get_featuresPageText(){
		return featuresPageText;
	}
	
	public WebElement get_featuresPageImage(){
		return featuresPageImage;
	}
	
	public WebElement get_noSoftwareImage(){
		return noSoftwareImage;
	}
	
	public WebElement get_noSoftwareText(){
		return noSoftwareText;
	}
	
	public WebElement get_reviewManageText(){
		return reviewManageText;
	}
	
	public WebElement get_reviewManageImage(){
		return reviewManageImage;
	}
	
	public WebElement get_homepageVerificationHeaderText(){
		return homepageVerificationHeaderText;
	}
	
	public WebElement get_homepageVerificationLeftImg(){
		return homepageVerificationLeftImg;
	}
	
	public WebElement get_homepageVerificationRightText(){
		return homepageVerificationRightText;
	}
	
	public WebElement get_homepageVerificationMiddleText(){
		return homepageVerificationMiddleText;
	}
	
	public WebElement get_talkToStikLead(){
		return talkToStikLead;
	}
	
	public WebElement get_talkToStikLeadName(){
		return talkToStikLeadName;
	}
	
	public WebElement get_talkToStikLeadEmail(){
		return talkToStikLeadEmail;
	}
	
	public WebElement get_talkToStikLeadPhoneNumber(){
		return talkToStikLeadPhoneNumber;
	}
	
	public WebElement get_talkToStikLeadSubmitButton(){
		return talkToStikLeadSubmitButton;
	}
	
}
