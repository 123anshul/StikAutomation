package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;

public class EnterprisePageFixture extends HomePageFixture {

	public void verifyEnterprisePage(String enterpriseUrl,String tabName){
		Assert.assertTrue(driver.getCurrentUrl().equals(enterpriseUrl), "Correct URL of enterprise page is not open");
		Assert.assertTrue(isDisplayed(enterprisePageUi.get_vedioSection()), "Vedio section is not displayed");
		Assert.assertTrue(enterprisePageUi.get_overviewTabText().getText().equals(tabName));
	}

	public void verifyOverviewTab(String getReviewText,String websiteModalText,String reviewMarketingText,String widgetModaltext,String getReferralText){
		verifyCollectReviewSection(getReviewText,websiteModalText);
		verifyReviewMarketingSection(reviewMarketingText,widgetModaltext);
		verifyGetReferralsSection(getReferralText);
	}

	public void verifyCollectReviewSection(String getReviewText,String websiteModalText ){
		Assert.assertTrue(enterprisePageUi.get_getReviewText().getText().equals(getReviewText), "Get Review text is not displayed");
		Assert.assertTrue(isDisplayed(enterprisePageUi.get_getReviewImage()), "Collect Review Image is Not displayed");
		Assert.assertTrue(isDisplayed(enterprisePageUi.get_getReviewLearnMoreLink()), "Get more link is not displayed");
		enterprisePageUi.get_getReviewLearnMoreLink().click();
		homePageUi.waitForElementToAppear(enterprisePageUi.get_websiteModalText());
		Assert.assertTrue(enterprisePageUi.get_websiteModal().getAttribute("style").contains("visibility: visible"));
		Assert.assertTrue(enterprisePageUi.get_websiteModalText().equals(websiteModalText),"Website Modal text is not displayed");
		Assert.assertTrue(enterprisePageUi.get_websiteModalPersonalProfileImage().isDisplayed(), "Personal Profile image is not present");
		Assert.assertTrue(enterprisePageUi.get_websiteModalComapnyPageImage().isDisplayed(), "Company Page image is not present");
		Assert.assertTrue(enterprisePageUi.get_websiteModalCross().isDisplayed(), "Website modal cross button is not present");
		enterprisePageUi.get_websiteModalCross().click();
	}

	public void verifyReviewMarketingSection(String reviewMarketingText,String widgetModaltext){
		Assert.assertTrue(enterprisePageUi.get_reviewMarketingText().getText().equals(reviewMarketingText), "Review marketing text doest not matches");
		Assert.assertTrue(enterprisePageUi.get_reviewMarketingLeanMoreLink().isDisplayed(), "Review marketing learn more link is not displayed");
		enterprisePageUi.get_reviewMarketingLeanMoreLink().click();
		homePageUi.waitForElementToAppear(enterprisePageUi.get_widgetModalText());
		Assert.assertTrue(enterprisePageUi.get_widgetModal().getAttribute("style").contains("visibility: visible"), "Widget model is not opened");
		Assert.assertTrue(enterprisePageUi.get_widgetModalText().equals(widgetModaltext), "Widget model text doesnt matches");
		Assert.assertTrue(enterprisePageUi.get_widgetModalImage().isDisplayed(), "Widget model image is not present");
		Assert.assertTrue(enterprisePageUi.get_widgetModalCross().isDisplayed(), "Widget model cross is not displayed");
		enterprisePageUi.get_widgetModalCross().click();
	}

	public void verifyGetReferralsSection(String getReferralText){
		Assert.assertTrue(enterprisePageUi.get_getReferalText().equals(getReferralText), "Get Referral text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_getReferalImage().isDisplayed(), "Get referral image doesnot displayed");
	}

	public void navigateToRoiTab(String roiTabUrl,String roiPageText,String roiTabText){
		Assert.assertTrue(enterprisePageUi.get_roiTabLink().isDisplayed(), "Roi tab is not displayed");
		enterprisePageUi.get_roiTabLink().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(roiTabUrl), "Correct Page is not open on clicing Roi tab");
		Assert.assertTrue(enterprisePageUi.get_roiTabText().getText().equals(roiTabText), "Roi tab text does not matches");
		Assert.assertTrue(enterprisePageUi.get_roiPageText().getText().equals(roiPageText), "Roi page text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_roiPageImage().isDisplayed(), "Roi Page image is not displayed");
	}

	public void verifyRoiTab(String roiMarketingLiftText,String roiSalesLiftText,String roiReferralsLiftText,String referralsCalculatorText,String noOfCustomers){
		verifyRoiMarketingLiftSection(roiMarketingLiftText);
		verifyRoiSaleLiftSection(roiSalesLiftText);
		verifyReferralsLiftSection(roiReferralsLiftText);
		verifyRoiCalculatorSection(referralsCalculatorText,noOfCustomers);
	}

	public void verifyRoiMarketingLiftSection(String roiMarketingLiftText){
		Assert.assertTrue(enterprisePageUi.get_roiMarketingLiftText().equals(roiMarketingLiftText), "Roi marketing lift text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_roiMarketingLiftImage().isDisplayed(),"Roi marketing lift image is not present");
	}

	public void verifyRoiSaleLiftSection(String roiSalesLiftText){
		Assert.assertTrue(enterprisePageUi.get_roiSalesLiftText().equals(roiSalesLiftText), "Roi marketing lift text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_roiSalesLiftImage().isDisplayed(),"Roi sales lift image is not present");
	}

	public void verifyReferralsLiftSection(String roiReferralsLiftText){
		Assert.assertTrue(enterprisePageUi.get_roiReferralsLiftText().equals(roiReferralsLiftText), "Roi referrals lift text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_roiReferralsLiftImage().isDisplayed(),"Roi referrals lift image is not present");
	}

	public void verifyRoiCalculatorSection(String referralsCalculatorText,String noOfCustomers){
		Assert.assertTrue(enterprisePageUi.get_roiReferralsCalculatorText().equals(referralsCalculatorText), "Referrals calculator text not matched");
		Assert.assertTrue(enterprisePageUi.get_roiReferralsCalculatorInputbox().isDisplayed(), "Referrals calculator input box is not displayed");
		enterprisePageUi.get_roiReferralsCalculatorInputbox().sendKeys(noOfCustomers);
		enterprisePageUi.get_roiReferralsCalculatorButton().click();
		enterprisePageUi.get_roiReferralsCount().getText().equals("16");
		enterprisePageUi.get_roiBusinessCount().getText().equals("1.60");
	}

	public void navigateToFeaturesTab(String featureTabUrl,String featureTabText,String featurePageText ){
		Assert.assertTrue(enterprisePageUi.get_featuresTabLink().isDisplayed(), "Feature tab is not displayed");
		enterprisePageUi.get_featuresTabLink().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(featureTabUrl), "Correct Page is not open on clicking features tab");
		Assert.assertTrue(enterprisePageUi.get_featuresTabText().getText().equals(featureTabText), "Features tab text does not matches");
		Assert.assertTrue(enterprisePageUi.get_featuresPageText().equals(featurePageText), "Features page text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_featuresPageImage().isDisplayed(), "Features Page image is not displayed");
	}

	public void verifyFeaturesTab(String noSoftwareText,String reviewManageText,String headerText,String middleText,String rightText){
		verifyNoSoftwareSection(noSoftwareText);
		verifyReviewsManageSection(reviewManageText);
		verifyHomepageVerificationSection(headerText,middleText,rightText);
	}

	public void verifyNoSoftwareSection(String noSoftwareText){
		Assert.assertTrue(enterprisePageUi.get_noSoftwareText().getText().equals(noSoftwareText), "No software section text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_noSoftwareImage().isDisplayed(), "no Software section image is not displayed");
	}

	public void verifyReviewsManageSection(String reviewManageText){
		Assert.assertTrue(enterprisePageUi.get_reviewManageText().getText().equals(reviewManageText), "Review manage section text doesnot matches");
		Assert.assertTrue(enterprisePageUi.get_reviewManageImage().isDisplayed(), "Review manage section image is not displayed");
	}

	public void verifyHomepageVerificationSection(String headerText,String middleText,String rightText){
		Assert.assertTrue(enterprisePageUi.get_homepageVerificationHeaderText().getText().equals(headerText), "Header text does not matches");
		Assert.assertTrue(enterprisePageUi.get_homepageVerificationMiddleText().getText().equals(middleText), "Home Page Verification middle text does not matches");
		Assert.assertTrue(enterprisePageUi.get_homepageVerificationRightText().getText().equals(rightText), "Home Page verification right text does not matches");
		Assert.assertTrue(enterprisePageUi.get_homepageVerificationLeftImg().isDisplayed(), "Home Page verifucation left image is not displayed");
	}



}
