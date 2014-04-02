package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class FeaturePagesUi extends BaseUi{

	public FeaturePagesUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
		
	}
	
	
	String uiFeaturesTabs="div[id='ui-features-tabs']>article>section:nth-child(index)";
	public String uiTabLinks="div[id='ui-features-tabs']>article>section:nth-child(index)>a";
	public String uiTabNames="div[id='ui-features-tabs']>article>section:nth-child(index)>a>h4";
	
	@FindBy(css="#ui-features-footer")
	private WebElement uiFooterSection;
	
	@FindBy(css="#ui-features-footer>article>section>div[class='text']>h2")
	private WebElement uiFooterText;
	
	@FindBy(css="#ui-features-footer>article>section>div>a")
	private WebElement uiFooterTryStikButton;
	
	public WebElement get_uiFeaturesTabs(int index){
		return driver.findElement(By.cssSelector(uiFeaturesTabs.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_uiTabLinks(int index){
		return driver.findElement(By.cssSelector(uiTabLinks.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_uiTabNames(int index){
		return driver.findElement(By.cssSelector(uiTabNames.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_uiFooterSection(){
		return uiFooterSection;
	}
	
	public WebElement get_uiFooterText(){
		return uiFooterText;
	}
	
	public WebElement get_uiFooterTryStikButton(){
		return uiFooterTryStikButton;
	}
	
	/**************************************Why Stik Section UI Elements*********************************/
	@FindBy(css="div[id='featureHero']>article>section[class='caption']")
	private WebElement captionSection;
	
	@FindBy(css="div[id='featureHero']>article>section[class='video']")
	private WebElement videoSection;
	
	@FindBy(css="div[id='featureHero']>article>section[class='caption']>a")
	private WebElement getStaredWithStikbutton;
	
	
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading']")
	private WebElement getReviewsSubSection;
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading']>img")
	private WebElement getReviewsSubSectionImage;
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading']>a")
	private WebElement getReviewsSubSectionLearnMoreButton;
	
	
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading second']")
	private WebElement getReferralSubSection;
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading second']>img")
	private WebElement getReferralSubSectionImage;
	
	@FindBy(css="div[id='featureBenefits']>article>section>div[class='heading second']>a")
	private WebElement getReferralSubSectionLearMoreButton;
	
	
	
	@FindBy(css="div[id='onlinePresenceCrossPlatform']>article>section")
	private WebElement standOutOnlineSubSection;
	
	@FindBy(css="div[id='onlinePresenceCrossPlatform']>article>section>div[class='image']>img")
	private WebElement standOutOnlineSubSectionImage;
	
	@FindBy(css="div[id='onlinePresenceCrossPlatform']>article>section>div[class='text']>h2")
	private WebElement standOutOnlineSubSectionHeading;
	
	@FindBy(css="div[id='onlinePresenceCrossPlatform']>article>section>div[class='text']>a")
	private WebElement standOutOnlineSubSectionLearnMoreButton;
	
	@FindBy(css=".large.button.orange")
	private WebElement footerTryStikForFreeButton;
	
	
	
	
	/********************************Getter Functions for Why Stik Section*********************************/
	
	public WebElement get_captionSection(){
		return captionSection;
	}
	
	public WebElement get_videoSection(){
		return videoSection;
	}
	
	public WebElement get_getStaredWithStikbutton(){
		return getStaredWithStikbutton;
	}
	
	public WebElement get_getReviewsSubSection(){
		return getReviewsSubSection;
	}
	
	public WebElement get_getReviewsSubSectionImage(){
		return getReviewsSubSectionImage;
	}
	
	public WebElement get_getReviewsSubSectionLearnMoreButton(){
		return getReviewsSubSectionLearnMoreButton;
	}
	
	public WebElement get_getReferralSubSection(){
		return getReferralSubSection;
	}
	
	public WebElement get_getReferralSubSectionImage(){
		return getReferralSubSectionImage;
	}
	
	public WebElement get_getReferralSubSectionLearMoreButton(){
		return getReferralSubSectionLearMoreButton;
	}
	
	public WebElement get_standOutOnlineSection(){
		return standOutOnlineSubSection;
	}
	
	public WebElement get_standOutOnlineSubSectionImage(){
		return standOutOnlineSubSectionImage;
	}
	
	public WebElement get_standOutOnlineSubSectionHeading(){
		return standOutOnlineSubSectionHeading;
	}
	
	public WebElement get_standOutOnlineSubSectionLearnMoreButton(){
		return standOutOnlineSubSectionLearnMoreButton;
	}
	
	public WebElement get_footerTryStikForFreeButton(){
		return footerTryStikForFreeButton;
	}
	
	/***********************************Reviews Section UI Elements*************************************/
	
	@FindBy(css="div[id='reviewsWizard']>article>section>div[class='text']")
	private WebElement reviewWizardSection;
	
	@FindBy(css="div[id='reviewsWizard']>article>section>div[class='text']>a")
	private WebElement reviewWizardTryStikForFreeButton;
	
	@FindBy(css="div[id='reviewsWizard']>article>section>div[class='image']>img")
	private WebElement reviewWizardImage;
	
	@FindBy(css="div[id='reviewsShowcase']>article>section>h2")
	private WebElement reviewShowcaseSection;
	
	@FindBy(css="div[id='reviewsShowcase']>article>section>img")
	private WebElement reviewShowcaseImage;
	
	@FindBy(css="div[id='reviewsShowcase']>article>section>a")
	private WebElement reviewShowcaseTryStikForFreeButton;
	
	@FindBy(css="div[id='reviewsVerified']>article>section>div[class='text']")
	private WebElement reviewsVerifiedSectionText;
	
	@FindBy(css="div[id='reviewsVerified']>article>section>div[class='text']>a")
	private WebElement reviewsVerifiedTryStikForFreeButton;
	
	@FindBy(css="div[id='reviewsVerified']>article>section>div[class='image']>img")
	private WebElement reviewsVerifiedImage;
	
	@FindBy(css="div[id='reviewsManage']>article>section>div[class='text']")
	private WebElement reviewsManageSectionText;
	
	@FindBy(css="div[id='reviewsManage']>article>section>div[class='text']>a")
	private WebElement reviewsManageTryStikForFreeButton;
	
	@FindBy(css="div[id='reviewsManage']>article>section>div[class='image']>img")
	private WebElement reviewsManageImage;
	
	/********************************Getter Functions for Reviews  Section*********************************/
	
	public WebElement get_reviewWizardSection(){
		return reviewWizardSection;
	}
	
	public WebElement get_reviewWizardTryStikForFreeButton(){
		return reviewWizardTryStikForFreeButton;
	}
	
	public WebElement get_reviewWizardImage(){
		return reviewWizardImage;
	}
	
	public WebElement get_reviewShowcaseSection(){
		return reviewShowcaseSection;
	}
	
	public WebElement get_reviewShowcaseImage(){
		return reviewShowcaseImage;
	}
	
	public WebElement get_reviewShowcaseTryStikForFreeButton(){
		return reviewShowcaseTryStikForFreeButton;
	}
	
	public WebElement get_reviewsVerifiedSectionText(){
		return reviewsVerifiedSectionText;
	}
	
	public WebElement get_reviewsVerifiedTryStikForFreeButton(){
		return reviewsVerifiedTryStikForFreeButton;
	}
	
	public WebElement get_reviewsVerifiedImage(){
		return reviewsVerifiedImage;
	}
	
	public WebElement get_reviewsManageSectionText(){
		return reviewsManageSectionText;
	}
	
	public WebElement get_reviewsManageTryStikForFreeButton(){
		return reviewsManageTryStikForFreeButton;
	}
	
	public WebElement get_reviewsManageImage(){
		return reviewsManageImage;
	}
	
	/*******************************Referral section UI Elements****************************************/
	
	@FindBy(css="#referralsCollection>article>section>h2")
	private WebElement referralCollectionHeading;
	
	@FindBy(css="#referralsCollection>article>section>a")
	private WebElement referralCollectiontryStikForFreeButton;
	
	@FindBy(css="#referralsCollection>article>section>img")
	private WebElement referralCollectionImage;
	
	@FindBy(css="#referralsInbox>article>section>div>img")
	private WebElement referralInboxImage;
	
	@FindBy(css="#referralsInbox>article>section>div[class='text']>h2")
	private WebElement referralInboxText;
	
	@FindBy(css="#referralsInbox>article>section>div[class='text']>a")
	private WebElement referralInboxTryStikForFreeButton;
	
	@FindBy(css="#referralsPermenance>article>section>div[class='text']>h2")
	private WebElement referralPermenanceText;
	
	@FindBy(css="#referralsPermenance>article>section>div[class='text']>a")
	private WebElement referralPermenanceTryStikForFreeButton;
	
	@FindBy(css="#referralsPermenance>article>section>div>img")
	private WebElement referralPermenanceImage;
	
	/********************************Getter Functions for Referral section  Section*********************************/
	
	public WebElement get_referralCollectionHeading(){
		return referralCollectionHeading;
	}
	
	public WebElement get_referralCollectiontryStikForFreeButton(){
		return referralCollectiontryStikForFreeButton;
	}
	
	public WebElement get_referralCollectionImage(){
		return referralCollectionImage;
	}
	
	public WebElement get_referralInboxImage(){
		return referralInboxImage;
	}
	
	public WebElement get_referralInboxText(){
		return referralInboxText;
	}
	
	public WebElement get_referralInboxTryStikForFreeButton(){
		return referralInboxTryStikForFreeButton;
	}
	
	public WebElement get_referralPermenanceText(){
		return referralPermenanceText;
	}
	
	public WebElement get_referralPermenanceTryStikForFreeButton(){
		return referralPermenanceTryStikForFreeButton;
	}
	
	public WebElement get_referralPermenanceImage(){
		return referralPermenanceImage;
	}
	
	/*****************************Stand Out Online section UI Elements***********************************/
	
	@FindBy(css="#onlinePresenceDirectory>article>section>div[class='text']>h2")
	private WebElement onlinePresenceDirectoryText;
	
	@FindBy(css="#onlinePresenceDirectory>article>section>div[class='text']>a")
	private WebElement onlinePresenceDirectoryTryStikForFreeButton;
	
	@FindBy(css="#onlinePresenceDirectory>article>section>div[class='image']>img")
	private WebElement onlinePresenceDirectoryImage;
	
	@FindBy(css="#onlinePresenceCrossPlatform>article>section>div[class='image']>img")
	private WebElement onlinePresenceCrossPlatformImage;
	
	@FindBy(css="#onlinePresenceCrossPlatform>article>section>div[class='text']>h2")
	private WebElement onlinePresenceCrossPlatformText;
	
	@FindBy(css="#onlinePresenceCrossPlatform>article>section>div[class='text']>a")
	private WebElement onlinePresenceCrossPlatformTryStikForFreeButton;
	
	/********************************Getter Functions for Stand Out Online Section*********************************/

	public WebElement get_onlinePresenceDirectoryText(){
		return onlinePresenceDirectoryText;
	}
	
	public WebElement get_onlinePresenceDirectoryTryStikForFreeButton(){
		return onlinePresenceDirectoryTryStikForFreeButton;
	}
	
	public WebElement get_onlinePresenceDirectoryImage(){
		return onlinePresenceDirectoryImage;
	}
	
	public WebElement get_onlinePresenceCrossPlatformImage(){
		return onlinePresenceCrossPlatformImage;
	}
	
	public WebElement get_onlinePresenceCrossPlatformText(){
		return onlinePresenceCrossPlatformText;
	}
	
	public WebElement get_onlinePresenceCrossPlatformTryStikForFreeButton(){
		return onlinePresenceCrossPlatformTryStikForFreeButton;
	}
	
	/*******************************ROI Section UI Elements*********************************************************/
	
	@FindBy(css="#marketingLift>article>section>h2")
	private WebElement marketingLiftSectionHeading;
	
	@FindBy(css="div[id='salesLift']>article>section>div>h2")
	private WebElement salesLiftHeading;
	
	@FindBy(css="div[id='referralsLift']>article>section>div>h2")
	private WebElement referralLiftHeading;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>h2")
	private WebElement roiCalculatorHeading;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>form>input")
	private WebElement roiNoOfCustomerTextBox;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>form>button")
	private WebElement roiCalculateButton;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>table>tbody>tr:nth-child(1)>td[class='reviews-value']")
	private WebElement roiReviewsValue;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>table>tbody>tr:nth-child(2)>td[class='referrals-value']")
	private WebElement roiReferralsValue;
	
	@FindBy(css="div[id='referralsCalculator']>article>section>table>tbody>tr:nth-child(3)>td[class='business-value']")
	private WebElement roiBusinessValue;
	
	@FindBy(css="#marketingLift>article>section>img")
	private WebElement marketingLiftImage;
	
	@FindBy(css="div[id='salesLift']>article>section>div>img")
	private WebElement SalesLiftImage;
	
	
	@FindBy(css="div[id='referralsLift']>article>section>div>img")
	private WebElement referralLiftImage;
	
	
	/********************************Getter Functions for ROI Section*********************************/
	public WebElement get_marketingLiftSectionHeading(){
		return marketingLiftSectionHeading;
	}
	
	public WebElement get_marketingLiftImage(){
		return marketingLiftImage;
	}
	
	public WebElement get_SalesLiftImage(){
		return SalesLiftImage;
	}
	
	public WebElement get_referralLiftImage(){
		return referralLiftImage;
	}
	
	public WebElement get_salesLiftHeading(){
		return salesLiftHeading;
	}
	
	public WebElement get_referralLiftHeading(){
		return referralLiftHeading;
	}
	
	public WebElement get_roiCalculatorHeading(){
		return roiCalculatorHeading;
	}
	
	public WebElement get_roiNoOfCustomerTextBox(){
		return roiNoOfCustomerTextBox;
	}
	
	public WebElement get_roiCalculateButton(){
		return roiCalculateButton;
	}
	
	public WebElement get_roiReviewsValue(){
		return roiReviewsValue;
	}
	
	public WebElement get_roiReferralsValue(){
		return roiReferralsValue;
	}
	
	public WebElement get_roiBusinessValue(){
		return roiBusinessValue;
	}
	
}
