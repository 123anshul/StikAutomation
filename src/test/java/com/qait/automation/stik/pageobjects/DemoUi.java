package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class DemoUi extends BaseUi{


	public DemoUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
		
	}

	/*****************************************Web Elements*********************************/
	//adding webelements for newly added page /demo/connect
		@FindBy(xpath="//div[@id='uiTabs']/article/section/h2")
		private WebElement demoHeading;
		
		@FindBy(xpath="//a[@href='/demo']")
		private WebElement demoTab;
		
		@FindBy(xpath="//div[@id='demoHero']/div/div/div/div")
		private WebElement joinDemoButtonNew;
		
		@FindBy(xpath="//a[@href='/demo/gallery']")
		private WebElement galleryTab;
		
		@FindBy(xpath="//a[@href='/demo/roi']")
		private WebElement roiTab;
		
		@FindBy(xpath="//div[@class='return']/span[@id='roiCaption']")
		private WebElement roiCaption;
		
		@FindBy(xpath="//div[@class='bar'][@style='top: 87.04%;']")
		private WebElement roiGraphBar1;
		
		@FindBy(xpath="//form[@id='roiForm']/fieldset[@class='close-rate']/input")
		private WebElement closeRateInputOnROIPage;
			
		@FindBy(xpath="//form[@id='roiForm']/fieldset[@class='revenue']/input")
		private WebElement revenueInputOnROIPage;
		
		@FindBy(xpath="//a[@href='/demo/pricing']")
		private WebElement pricingTab;
		
		@FindBy(css=".avatar>img")
		private WebElement stikLogoOnDemoConnectPage;
		
		@FindBy(xpath="//div[@id='lead-form']/div")
		private WebElement leadFormOnDemoPage;
		
		@FindBy(xpath="//input[@id='name']")
		private WebElement nameInputOnLeadForm;
		
		@FindBy(xpath="//input[@id='phone']")
		private WebElement phoneInputOnLeadForm;
		
		@FindBy(xpath="//input[@id='email']")
		private WebElement emailInputOnLeadForm;
		
		@FindBy(xpath= "//div[@class='fields']/div[4]/div/a")
		private WebElement selectIndustryDropdownOnLeadForm;
		
		@FindBy(xpath= "//div[@class='fields']/div[4]/div/div/ul/li")
		private List<WebElement> selectIndustryDropdownListOnLeadForm;
		
		@FindBy(xpath="//button[@ah-label='Button-Continue']")
		private WebElement continueButtonOnLeadForm;
		
		@FindBy(xpath="//p[@class='title']")
		private WebElement successOnThankYouWizard;
		
		@FindBy(xpath="//a[@href='http://www.stik.com']")
		private WebElement stikLinkOnThankYouPage;
		
		@FindBy(xpath="//div[@id='pricingHero']")
		private WebElement pricingTable;
		
	////End of newly added elements
	@FindBy(css=".splash.row")
	private WebElement splashSection;
	
	@FindBy(css="div[class='splash row']>div[class='rating']>div[class='stars']")
	private WebElement ratingSectionUnderSplash;
	
	@FindBy(css="div[class='splash row']>div>h1")
	private WebElement splashText;

	@FindBy(css="div[class='medium button success dropdown js-remove-button']")
	private WebElement joinDemoButton;
	
	private String joinDemoOptions="div[class='wrapper']>div>ul>li>a";
	
	@FindBy(css="div[id='stikFeatures']>div>div")
	private WebElement getReviewsSection;
	
	private String getReviewsTabNames="dl[class='tabs']>dd:nth-child(index)";
	private String getReviewsTabLinks="dl[class='tabs']>dd:nth-child(index)>a";
	private String getReviewsTabContents="ul[class='tabs-content']>li:nth-child(index)";
	
	@FindBy(css="li[id='googleWidgetTab']>div>div>div>a:nth-child(1)>img")
	private WebElement googleWidgetLink;
	
	@FindBy(css="div[id='googleModal']")
	private WebElement googleWidgetContent;
	
	@FindBy(css="div[id='googleModal']>div>div>a>i")
	private WebElement closeButtonForGoogleWidget;
	
	@FindBy(className="facebook")
	private WebElement facebookWidgetLink;
	
	@FindBy(css="div[id='facebookModal']")
	private WebElement facebookWidgetContent;
	
	@FindBy(css="div[id='facebookModal']>div>div>a>i")
	private WebElement closeButtonForFacebookWidget;
	
	@FindBy(className="website")
	private WebElement yourWebsiteWidgetLink;
	
	@FindBy(css="div[id='websiteModal']")
	private WebElement websiteWidgetContent;
	
	@FindBy(css="div[id='websiteModal']>div>div>a>i")
	private WebElement closeButtonForWebsiteWidget;
	
	@FindBy(className="email")
	private WebElement emailWidgetLink;
	
	@FindBy(css="div[id='emailModal']")
	private WebElement emailWidgetContent;
	
	@FindBy(css="div[id='emailModal']>div>div>a>i")
	private WebElement closeButtonForEmailWidget;
	
	@FindBy(css="div[id='stikReferrals']>div>div>h1")
	private WebElement getReferralSection;
	
	@FindBy(css="div[id='stikReferrals']>div>div>div>div:nth-child(1)>ul")
	private WebElement leftPartOfGetReferralSection;
	
	@FindBy(css="div[id='stikReferrals']>div[class='section-title']>h2")
	private WebElement getReferralSectionHeading;
	
	@FindBy(css="div[id='stikReferrals']>div[class='text-container']>div[class='text row']>div>div[class='arrow arrow-right']>i")
	private WebElement rightArrowForReferralWheel;
	
	public String referralTextSteps="div[id='stikReferrals']>div[class='text-container']>div[class='text row']>div>div[id='index']";


	public String referralImages="div[id='stikReferrals']>div[class='referral-slider']>div>div>div[class='index']>img";
	
	public String referralTextToBeMatched="div[id='stikReferrals']>div[class='text-container']>div[class='text row']>div>div[id='index']>h2";
	
	@FindBy(css="div[class='referral-slider']>div>div[class='wheel']")
	private WebElement wheelForReferralSteps;
	
	
	@FindBy(css="div[id='stikReferrals']>div>div>div>div:nth-child(2)>img")
	private WebElement rightPartOfGetReferralSection;
	
	@FindBy(css="div[id='stikProtect']>div>div>h1")
	private WebElement staySafeSection;
	
	@FindBy(css="div[id='stikProtect']>div>div>div[class='animate-group']>div>img")
	private WebElement staySafeImage;
	
	@FindBy(css="div[id='stikPremium']>div>div>h1")
	private WebElement stikPremiumSection;
	
	@FindBy(css="div[id='stikPremium']>div>div>div>div[class='animate-group']>div>div[class='rating']")
	private WebElement leftSectionOnStikPremiumSection;
	
	@FindBy(css="div[id='stikPremium']>div>div>div>div>img[class='review']")
	private WebElement rightSectiononStikPremiumSection;
	
	@FindBy(css="div[id='companyPage']>div>div>h1")
	private WebElement companyPageSection;
	
	@FindBy(css="div[id='companyPage']>div>div>div[class='row']>div:nth-child(1)")
	private WebElement leftpartOnCompanyPageSection;
	
	@FindBy(css="div[id='companyPage']>div>div>div[class='row']>div:nth-child(2)>div>a>img")
	private WebElement rightpartOnCompanyPageSection;
	
	@FindBy(css="div[id='companyModal']")
	private WebElement companyModalWidget;
	
	@FindBy(css="div[id='companyModal']>div>div>a>i")
	private WebElement closeButtonForCompanyModal;
	
	@FindBy(css="a[href='/menu']")
	private WebElement plansAndPricingButton;
	
	@FindBy(css="a[class='jmLink']")
	private WebElement joinMeLinkOnJoinPage;

	/****************************Getter Methods******************************************/
	public WebElement get_splashSection(){
		return splashSection;
	}

	public WebElement get_ratingSectionUnderSplash(){
		return ratingSectionUnderSplash;
	}
	
	public WebElement get_splashText(){
		return splashText;
	}
	
	public WebElement get_joinDemoButton(){
		return joinDemoButton;
	}
	
	public List<WebElement> get_joinDemoOptions(){
		return driver.findElements(By.cssSelector(joinDemoOptions));
	}
	
	public WebElement get_getReviewsSection(){
		return getReviewsSection;
	}
	
	public WebElement get_getReviewsTabName(int index){
		return driver.findElement(By.cssSelector(getReviewsTabNames.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_getReviewsTabContents(int index){
		return driver.findElement(By.cssSelector(getReviewsTabContents.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_getReviewsTabLinks(int index){
		return driver.findElement(By.cssSelector(getReviewsTabLinks.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_googleWidgetLink(){
		return googleWidgetLink;
	}
	
	public WebElement get_googleWidgetContent(){
		return googleWidgetContent;
	}
	
	public WebElement get_closeButtonForGoogleWidget(){
		return closeButtonForGoogleWidget;
	}
	
	public WebElement get_facebookWidgetLink(){
		return facebookWidgetLink;
	}
	
	public WebElement get_facebookWidgetContent(){
		return facebookWidgetContent;
	}
	
	public WebElement get_closeButtonForFacebookWidget(){
		return closeButtonForFacebookWidget;
	}
	
	public WebElement get_yourWebsiteWidgetLink(){
		return yourWebsiteWidgetLink;
	}
	
	public WebElement get_websiteWidgetContent(){
		return websiteWidgetContent;
	}
	
	public WebElement get_closeButtonForWebsiteWidget(){
		return closeButtonForWebsiteWidget;
	}
	
	public WebElement get_emailWidgetLink(){
		return emailWidgetLink;
	}
	
	public WebElement get_emailWidgetContent(){
		return emailWidgetContent;
	}
	
	public WebElement get_closeButtonForEmailWidget(){
		return closeButtonForEmailWidget;
	}
	
	public WebElement get_getReferralSection(){
		return getReferralSection;
	}
	
	public WebElement get_leftPartOfGetReferralSection(){
		return leftPartOfGetReferralSection;
	}
	
	public WebElement get_rightPartOfGetReferralSection(){
		return rightPartOfGetReferralSection;
	}
	
	public WebElement get_staySafeSection(){
		return staySafeSection;
	}
	
	public WebElement get_staySafeImage(){
		return staySafeImage;
	}
	
	public WebElement get_stikPremiumSection(){
		return stikPremiumSection;
	}
	
	public WebElement get_leftSectionOnStikPremiumSection(){
		return leftSectionOnStikPremiumSection;
	}
	
	public WebElement get_rightSectiononStikPremiumSection(){
		return rightSectiononStikPremiumSection;
	}
	
	public WebElement get_companyPageSection(){
		return companyPageSection;
	}
	
	public WebElement get_leftpartOnCompanyPageSection(){
		return leftpartOnCompanyPageSection;
	}
	
	public WebElement get_rightpartOnCompanyPageSection(){
		return rightpartOnCompanyPageSection;
	}
	
	public WebElement get_companyModalWidget(){
		return companyModalWidget;
	}
	
	public WebElement get_closeButtonForCompanyModal(){
		return closeButtonForCompanyModal;
	}
	
	public WebElement get_plansAndPricingButton(){
		return plansAndPricingButton;
	}
	
	public WebElement get_joinMeLinkOnJoinPage(){
		return joinMeLinkOnJoinPage;
	}
	
	public WebElement get_getReferralSectionHeading(){
		return getReferralSectionHeading;
	}
	
	public WebElement get_rightArrowForReferralWheel(){
		return rightArrowForReferralWheel;
	}
	
	public WebElement get_referralTextSteps(int index){
		return driver.findElement(By.cssSelector(referralTextSteps.replaceAll("index", "referralStep"+String.valueOf(index))));
	}
	
	
	public WebElement get_referralTextToBeMatched(int index){
		return driver.findElement(By.cssSelector(referralTextToBeMatched.replaceAll("index", "referralStep"+String.valueOf(index))));
	}
	
	public WebElement get_wheelForReferralSteps(){
		return wheelForReferralSteps;
	}
	
	public WebElement get_referralImages(int index){
		return driver.findElement(By.cssSelector(referralImages.replaceAll("index", "step step-"+String.valueOf(index))));
	}
	
	//adding getters for newly newly added web elements on /demo/connect page
		public WebElement get_demoHeading() {
			return demoHeading;		
		}
		
		public WebElement get_demoTab() {
			return demoTab;
		}
		
		public WebElement get_joinDemoButtonNew() {
			return joinDemoButtonNew;
		}
		
		public WebElement get_galleryTab() {
			return galleryTab;
		}
		
		public WebElement get_roiTab() {
			return roiTab;
		}
		
		public WebElement get_roiCaption() {
			return roiCaption;
		}
		
		public WebElement get_roiGraphBar1() {
			return roiGraphBar1;
		}
		
		public WebElement get_closeRateInputOnROIPage() {
			return closeRateInputOnROIPage;
		}
		
		public WebElement get_revenueInputOnROIPage() {
			return revenueInputOnROIPage;
		}
		
		public WebElement get_pricingTab() {
			return pricingTab;
		}
		
		public WebElement get_stikLogoOnDemoConnectPage() {
			return stikLogoOnDemoConnectPage;
		}
		
		public WebElement get_leadFormOnDemoPage() {
			return leadFormOnDemoPage;
		}
		
		public WebElement get_nameInputOnLeadForm() {
			return nameInputOnLeadForm;
		}
		
		public WebElement get_phoneInputOnLeadForm() {
			return phoneInputOnLeadForm;
		}
		
		public WebElement get_emailInputOnLeadForm() {
			return emailInputOnLeadForm;
		}
		
		public WebElement get_selectIndustryDropdownOnLeadForm() {
			return selectIndustryDropdownOnLeadForm;
		}
		
		public List<WebElement> get_selectIndustryDropdownListOnLeadForm() {
			return selectIndustryDropdownListOnLeadForm;
		}
		
		public WebElement get_continueButtonOnLeadForm() {
			return continueButtonOnLeadForm;
		}
		
		public WebElement get_successOnThankYouWizard() {
			return successOnThankYouWizard;
		}
		
		public WebElement get_stikLinkOnThankYouPage() {
			return stikLinkOnThankYouPage;
		}
		
		public WebElement get_pricingTable() {
			return pricingTable;
		}
}