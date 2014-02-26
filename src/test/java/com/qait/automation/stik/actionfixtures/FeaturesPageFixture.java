package com.qait.automation.stik.actionfixtures;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class FeaturesPageFixture extends HomePageFixture{
	
	private String email_signupURL="email-signup";
	public boolean verifyFeaturePageLoads(String featureurl, String tabName){
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().equals(featureurl), "Incorrect page opens up on clicking Why Stik !!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_videoSection()), "Video not displayed on features page- why stik section");
		Assert.assertTrue(featuresPageUi.get_uiTabNames(1).getText().equals(tabName) && featuresPageUi.get_uiFeaturesTabs(1).getAttribute("class").equals("active"), "Problems in active Ui Tab section!!");
		return true;
	}
	

	public boolean navigateToFeaturesPage(){
		Utilities.explicitWait(driver);
		homePageUi.get_stiklogo1().click();
		homePageUi.handleAlert();
	//	homePageUi.get_whyStikLink().click();
		Utilities.explicitWait(driver);
		return isDisplayed(featuresPageUi.get_captionSection());
	}
	
	public void moveBackToFeaturepageFromProfessionalPage(){
		Utilities.explicitWait(driver);
		if(driver.getCurrentUrl().trim().contains(email_signupURL) || driver.getCurrentUrl().trim().contains("features")){
			homePageUi.get_stiklogo1().click();
		}else{
			homePageUi.get_stiklogoOnProfessionalPage().click();
		}
		homePageUi.handleAlert();
		//homePageUi.get_whyStikLink().click();
		Utilities.explicitWait(driver);
	}
	
	public boolean verifyGetStartedButton(String getStartedUrl){
		Utilities.explicitWait(driver);
		featuresPageUi.get_getStaredWithStikbutton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(getStartedUrl) || driver.getCurrentUrl().trim().contains(email_signupURL), "Incorrect rediretion from Get Started Button!!!");
		Utilities.explicitWait(driver);
		moveBackToFeaturepageFromProfessionalPage();
		return true;
	}
	
	
	public boolean verifyWhyStikSection(String ReviewsTabName, String ReferralTabName, String standoutOnlineTabName, String roiTabName, String getReviewUrl, String getReferalURL, String standoutonlineurl, String getStartedUrl){
		boolean flag=false;
		
		Utilities.explicitWait(driver);
		scrollDown(300);
		
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReviewsSubSection()), "Get Reviews Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReviewsSubSectionImage()), "Image in Get Reviews Sub section is not present");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReviewsSubSectionLearnMoreButton()), "Learn more button in Get reviews sub section is not present");
		
		
		featuresPageUi.get_getReviewsSubSectionLearnMoreButton().click();
		
		
		homePageUi.waitForElementToAppear(featuresPageUi.get_reviewShowcaseSection());
		
		Assert.assertTrue(featuresPageUi.get_uiFeaturesTabs(2).getAttribute("class").equals("active") && featuresPageUi.get_uiTabNames(2).getText().equals(ReviewsTabName) , "Problem in Review UI Tab!!!");
		Assert.assertTrue(driver.getCurrentUrl().equals(getReviewUrl), "Incorrect url for Reviews section on features page");
		featuresPageUi.get_uiTabLinks(1).click();
		Utilities.explicitWait(driver);
		
		scrollDown(300);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReferralSubSection()), "Get Refferals Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReferralSubSectionImage()), "Image in Get Refferals Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_getReferralSubSectionLearMoreButton()), "Learn More button in Get Refferals Sub section is not present!!");
		featuresPageUi.get_getReferralSubSectionLearMoreButton().click();
		
		Utilities.explicitWait(driver);
		
		homePageUi.waitForElementToAppear(featuresPageUi.get_referralCollectionHeading());
		Assert.assertTrue(featuresPageUi.get_uiTabNames(3).getText().equals(ReferralTabName) && featuresPageUi.get_uiFeaturesTabs(3).getAttribute("class").equals("active"), "Problem in Referral UI Tab!!! ");
		System.out.println("URL from yml:- "+getReferalURL+" and URL from Page:- "+driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals(getReferalURL), "Incorrect url for Refferals section on features page");
		featuresPageUi.get_uiTabLinks(1).click();
		
		Utilities.explicitWait(driver);
		scrollDown(650);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_standOutOnlineSection()), "Stand Out online Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_standOutOnlineSubSectionHeading()), "Heading in Stand Out online Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_standOutOnlineSubSectionImage()), "Image in Stand Out online Sub section is not present!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_standOutOnlineSubSectionLearnMoreButton()), "Learn more button in Stand Out online Sub section is not present!!");
		featuresPageUi.get_standOutOnlineSubSectionLearnMoreButton().click();
		
		Utilities.explicitWait(driver);
		
		homePageUi.waitForElementToAppear(featuresPageUi.get_onlinePresenceDirectoryText());
		Assert.assertTrue(featuresPageUi.get_uiFeaturesTabs(4).getAttribute("class").equals("active") && featuresPageUi.get_uiTabNames(4).getText().equals(standoutOnlineTabName) , "Problem in Standout Online UI Tab!!! ");
		Assert.assertTrue(driver.getCurrentUrl().equals(standoutonlineurl), "Incorrect url for Stand out online section on features page");
		
		
		featuresPageUi.get_uiTabLinks(5).click();
		Utilities.explicitWait(driver);
		
		Assert.assertTrue(featuresPageUi.get_uiFeaturesTabs(5).getAttribute("class").equals("active") && featuresPageUi.get_uiTabNames(5).getText().equals(roiTabName) ,"Problem in ROI UI Tab!!!");
		
		featuresPageUi.get_uiTabLinks(1).click();
		Utilities.explicitWait(driver);
		
		flag=verifyGetStartedButton(getStartedUrl);
		
		return true && flag;
	}
	
	
	public boolean verifyReviewsSection(String tryStikForFreeLink){
		featuresPageUi.get_uiTabLinks(2).click();
		Utilities.explicitWait(driver);
		
		scrollDown(300);
		
		Assert.assertTrue(featuresPageUi.get_uiFeaturesTabs(2).getAttribute("class").equals("active"), "Reviews tab is not active!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewWizardSection()), "Problems in displaying Reviews Wizard section!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewWizardImage()), "Problem in displaying Image in Review Wizard section!!!");
		featuresPageUi.get_reviewWizardTryStikForFreeButton().click();
		System.out.println("Try Stik For Free button clicked for 1st time");
		
		Utilities.explicitWait(driver);
		
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeLink) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik for free button in Review Wizard section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(2).click();
		
		Utilities.explicitWait(driver);
		
		Reporter.log("No Problems in Review Wizard Sub section on Reviews tab...");
		scrollDown(700);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewShowcaseSection()), "Problems in displaying Reviews Showcase section!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewShowcaseImage()), "Problem in displaying Image in Review Showcase section!!!");
		featuresPageUi.get_reviewShowcaseTryStikForFreeButton().click();
		System.out.println("Try Stik For Free button clicked for 2nd time");
		
		Utilities.explicitWait(driver);
		
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeLink) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik for free button in Review Showcase section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(2).click();
		
		Utilities.explicitWait(driver);
		
		Reporter.log("No Problems in Review Showcase Sub section on Reviews tab...");
		scrollDown(1200);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewsVerifiedSectionText()), "Problems in displaying Reviews Verification section!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewsVerifiedImage()), "Problem in displaying Image in Review Verification section!!!");
		featuresPageUi.get_reviewsVerifiedTryStikForFreeButton().click();
		System.out.println("Try Stik For Free button clicked for 3rd time");
		
		Utilities.explicitWait(driver);
		
		
		
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeLink) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik for free button in Review Verification section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(2).click();
		Utilities.explicitWait(driver);
		Reporter.log("No Problems in Review Verification Sub section on Reviews tab...");
		
		scrollDown(1700);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewsManageSectionText()), "Problems in displaying Reviews Manage section!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewsManageImage()), "Problem in displaying Image in Review Manage section!!!");
		featuresPageUi.get_reviewsManageTryStikForFreeButton().click();
		System.out.println("Try Stik For Free button clicked for 4th time");
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeLink) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik for free button in Review Manage section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		
		Utilities.explicitWait(driver);
		Reporter.log("No Problems in Review Manage Sub section on Reviews tab...");
		return true;
	}
	
	
	public boolean verifyReferralSection(String tryStikForFreeURL){
		featuresPageUi.get_uiTabLinks(3).click();
		Utilities.explicitWait(driver);
		
		scrollDown(300);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralCollectionHeading()), "Problems in displaying Referral Collection heading!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralCollectionImage()), "Problems in displaying Image in Referral Collection section");
		featuresPageUi.get_referralCollectiontryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Referral Collection section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(3).click();
		Reporter.log("No Problems in Referral Collection Sub section on Referrals tab...");
		
		scrollDown(800);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralInboxText()), "Problems in displaying Referral Inbox text!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralInboxImage()), "Problems in displaying Image in Referral Inbox section");
		featuresPageUi.get_referralInboxTryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Referral Inbox section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(3).click();
		Reporter.log("No Problems in Referral Inbox Sub section on Referrals tab...");
		
		scrollDown(1150);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralPermenanceText()), "Problems in displaying Referral Permenance heading!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralPermenanceImage()), "Problems in displaying Image in Referral Permenance section");
		featuresPageUi.get_referralPermenanceTryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Referral Permenance section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
	
		Reporter.log("No Problems in Referral Permenance Sub section on Referrals tab...");
		return true;
	}
	
	public boolean verifyStandOutOnlineSection(String tryStikForFreeURL){
		featuresPageUi.get_uiTabLinks(4).click();
		Utilities.explicitWait(driver);
		
		scrollDown(300);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_onlinePresenceDirectoryText()), "Problems in displaying Directory heading!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_onlinePresenceDirectoryImage()), "Problems in displaying Image in online Directory section");
		featuresPageUi.get_onlinePresenceDirectoryTryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in online Directory sub section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(4).click();
		Reporter.log("No Problems in Online Directory Sub section on Stand Out Online tab...");
		
		scrollDown(650);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_onlinePresenceCrossPlatformText()), "Problems in displaying cross platform text!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_onlinePresenceCrossPlatformImage()), "Problems in displaying Image in cross platform section");
		featuresPageUi.get_onlinePresenceCrossPlatformTryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Cross Platform section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		featuresPageUi.get_uiTabLinks(4).click();
		Reporter.log("No Problems in Cross Platform Sub section on Stand Out Online tab...");
		
		scrollDown(1100);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewShowcaseSection()), "Problems in displaying Referral Permenance heading!!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_reviewShowcaseImage()), "Problems in displaying Image in Referral Permenance section");
		featuresPageUi.get_reviewShowcaseTryStikForFreeButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(tryStikForFreeURL) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Referral Permenance section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		
		Reporter.log("No Problems in Review Showcase Sub section on Stad Out Online tab...");
		
		return true;
	}
	
	
	public boolean checkROISection(String roiURL){
		featuresPageUi.get_uiTabLinks(5).click();
		Utilities.explicitWait(driver);
		
		Assert.assertTrue(driver.getCurrentUrl().trim().contains(roiURL), "Incorrect URL for ROI page!!");
		homePageUi.waitForElementToAppear(featuresPageUi.get_marketingLiftSectionHeading());
		
		scrollDown(300);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_marketingLiftImage()), "Problems in displaying Image under Marketing Lift section on ROI page");
		
		scrollDown(600);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_salesLiftHeading()), "Heading of Sales Lift section not displyaed on ROI page!!");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_SalesLiftImage()), "Image under Sales Lift sub section is not displayed on ROI page");
		
		
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralLiftHeading()), "Heading of Referral section not displayed on ROI page");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_referralLiftImage()), "Image under Referrals Lift sub section is not displayed on ROI page");
	
		scrollDown(700);
		
		Assert.assertTrue(isDisplayed(featuresPageUi.get_roiCalculatorHeading()), "ROI Calculator heading is not displayed!!");
		
		Assert.assertTrue(featuresPageUi.get_roiReviewsValue().getText().trim().equals("0"), "Initial Review value is not 0!!!");
		Assert.assertTrue(featuresPageUi.get_roiReferralsValue().getText().trim().equals("0"), "Initial Referral value is not 0!!!");
		Assert.assertTrue(featuresPageUi.get_roiBusinessValue().getText().trim().equals("$0"), "Initial Bussiness value is not 0!!!");
		Reporter.log("Default valies for all sections of ROI Calculator are fine...");
		
		featuresPageUi.get_roiNoOfCustomerTextBox().click();
		featuresPageUi.get_roiNoOfCustomerTextBox().clear();
		
		
		featuresPageUi.get_roiNoOfCustomerTextBox().sendKeys("80");
		featuresPageUi.get_roiCalculateButton().click();
		Utilities.hardWait(2);
		
		Assert.assertTrue(featuresPageUi.get_roiReviewsValue().getText().trim().equals("16"), "Review value after putting in number of customers is not correct!!!");
		Assert.assertTrue(featuresPageUi.get_roiReferralsValue().getText().trim().equals("1.60"), "Referral value after putting in number of customers is not correct!!!");
		Assert.assertTrue(featuresPageUi.get_roiBusinessValue().getText().trim().equals("$9,600"), "Business value after putting in number of customers is not correct!!!");		
	
		moveBackToFeaturepageFromProfessionalPage();
		return true;
	}
	
	
	
	
	
	public boolean checkFooter(String link){
		Utilities.explicitWait(driver);
		scrollDown(1500);
		Assert.assertTrue(isDisplayed(featuresPageUi.get_uiFooterSection()), "Problems in displaying Footer section");
		Assert.assertTrue(isDisplayed(featuresPageUi.get_uiFooterText()), "Problems in displaying text in Footer section");
		featuresPageUi.get_uiFooterTryStikButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().trim().equals(link) || driver.getCurrentUrl().trim().contains(email_signupURL), "Try Stik For Free button in Ui Footer section is redirecting to incorrect URL");
		moveBackToFeaturepageFromProfessionalPage();
		Reporter.log("No Problems in Ui Footer part...");
		return true;
	}
	
	
	
	

}
