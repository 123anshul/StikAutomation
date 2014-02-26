package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class DemoPageFixture extends SearchPageFixture {

	public boolean verifySplashSection(String splashSectionText){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(demoUi.get_splashSection());
		Assert.assertTrue(isDisplayed(demoUi.get_ratingSectionUnderSplash()), "Rating in splash section not visible");
		Reporter.log("Rating under splash section is present...");
		System.out.println("Rating under splash section is present");
		Assert.assertTrue(demoUi.get_splashText().getText().contains(splashSectionText), "Splash text doesn't match");
		Reporter.log("Text in splash section is correct...");
		return true;
	}
	
	public boolean verifyJoinDemoFunctionality(){
		
		Assert.assertTrue(isDisplayed(demoUi.get_joinDemoButton()), "Join demo button not present!!");
		Reporter.log("Join Demo drop down is present...");
		demoUi.get_joinDemoButton().click();
		int sizeOfDemoPresenters=demoUi.get_joinDemoOptions().size();
		for(int i=1;i<=sizeOfDemoPresenters;i++){
			demoUi.get_joinDemoOptions().get(i-1).click();
			Utilities.hardWait(1);
			homePageUi.changeWindow(1);
			Utilities.explicitWait(driver);
			Assert.assertTrue(driver.getCurrentUrl().contains("join.me") || isDisplayed(demoUi.get_joinMeLinkOnJoinPage()), "Incorrect URL for join demo option");
		
			driver.close();
			homePageUi.changeWindow(0);
			Utilities.hardWait(1);
		}
		demoUi.get_joinDemoButton().click();
		Reporter.log("Join Demo options are redirecting to correct URL");
		return true;
	}
	
	public boolean verifyGetReviewsSectionWithAllTheTabs(){
		scrollDown(350);
		Assert.assertTrue(isDisplayed(demoUi.get_getReviewsSection()), "Stik Reviews section not visible!!");
		Reporter.log("Get Reviews section is visible..");
		Assert.assertTrue(demoUi.get_getReviewsTabName(1).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(1).getAttribute("class").contains("active"), "Showcase Reviews Tab under get Reviews section has some problem");
		Reporter.log("Showcase Reviews Tab is active by default along with the widget's content");
		Utilities.hardWait(2);
		//homePageUi.mouseMove(demoUi.get_getReviewsTabName(2), demoUi.get_getReviewsTabName(2));
		demoUi.get_getReviewsTabLinks(2).click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(demoUi.get_getReviewsTabName(2).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(2).getAttribute("class").contains("active"), "Google Widget is not active!!!");
		Reporter.log("Google tab works fine under Get Reviews section...");
		demoUi.get_googleWidgetLink().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(demoUi.get_googleWidgetContent()) && demoUi.get_googleWidgetContent().getAttribute("style").contains("display: block"), "Problem in Google Modal Window !!!");
		demoUi.get_closeButtonForGoogleWidget().click();
		Utilities.hardWait(2);
		Utilities.explicitWait(driver);
		Reporter.log("Google Modal window working fine...");
		demoUi.get_getReviewsTabLinks(3).click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(demoUi.get_getReviewsTabName(3).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(3).getAttribute("class").contains("active"),"Facebook Widget is not active!!");
		Reporter.log("Facebook Tab works fine under Get Reviews section...");
		demoUi.get_facebookWidgetLink().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(demoUi.get_facebookWidgetContent()) && demoUi.get_facebookWidgetContent().getAttribute("style").contains("display: block"), "Problem in Facebook Modal Window!!!");
		demoUi.get_closeButtonForFacebookWidget().click();
		Reporter.log("Facebook Modal window worked fine...");
		Utilities.hardWait(2);
		demoUi.get_getReviewsTabLinks(4).click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(demoUi.get_getReviewsTabName(4).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(4).getAttribute("class").contains("active"), "Your Website widget is not active!!");
		demoUi.get_yourWebsiteWidgetLink().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(demoUi.get_websiteWidgetContent()) && demoUi.get_websiteWidgetContent().getAttribute("style").contains("display: block"), "Problem in Website ModaL Window");
		demoUi.get_closeButtonForWebsiteWidget().click();
		Reporter.log("Your Website Modal worked fine...");
		Utilities.hardWait(2);
		demoUi.get_getReviewsTabLinks(5).click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(demoUi.get_getReviewsTabName(5).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(5).getAttribute("class").contains("active"), "Your Email tab is not active");
		demoUi.get_emailWidgetLink().click();
		Utilities.hardWait(1);
		Assert.assertTrue(isDisplayed(demoUi.get_emailWidgetContent()) && demoUi.get_emailWidgetContent().getAttribute("style").contains("display: block"), "Problem in Your Email Modal Window");
		demoUi.get_closeButtonForEmailWidget().click();
		Utilities.hardWait(2);
		demoUi.get_getReviewsTabLinks(6).click();
		Utilities.hardWait(1);
		Assert.assertTrue(demoUi.get_getReviewsTabName(6).getAttribute("class").contains("active") && demoUi.get_getReviewsTabContents(6).getAttribute("class").contains("active"), "Social tab is not active");
		Utilities.hardWait(2);
		return true;
		
	}
	
	
	public void checkWheelMovementAndVerifyReferralSection(String text1, String text2, String text3){
		homePageUi.waitForElementToAppear(demoUi.get_joinDemoButton());
		int rotationAngle=0;
		scrollDown(320);
		System.out.println("Scrolled to section 'get Referrals'");
		Assert.assertTrue(isDisplayed(demoUi.get_getReferralSectionHeading()) && demoUi.get_getReferralSectionHeading().getText().contains("Get Referrals"), "Wrong Heading of Referral Section!!");
		
		for(int i=1;i<=3;i++){
			Assert.assertTrue(demoUi.get_referralTextSteps(i).getAttribute("class").contains("active"), "Referral Step "+i+" has some problem!!");
			Assert.assertTrue(isDisplayed(demoUi.get_referralImages(i)), "Image for Referral Step "+i+" is not displayed");
			Assert.assertTrue(demoUi.get_wheelForReferralSteps().getAttribute("data-card-rotator").contains(String.valueOf(rotationAngle)), "Problem in wheel rotation!!!");
			rotationAngle+=120;
			if(i==1)Assert.assertTrue(demoUi.get_referralTextToBeMatched(i).getText().trim().equalsIgnoreCase(text1), "Matching text for step 1 in refrral section failed!!");
			if(i==2)Assert.assertTrue(demoUi.get_referralTextToBeMatched(i).getText().trim().equalsIgnoreCase(text2), "Matching text for step 2 in refrral section failed!!");
			if(i==3)Assert.assertTrue(demoUi.get_referralTextToBeMatched(i).getText().trim().equalsIgnoreCase(text3), "Matching text for step 3 in refrral section failed!!");
			demoUi.get_rightArrowForReferralWheel().click();
		}
	}
	
	public void verifyStaySafeSection(String pathOfImage){
		System.out.println("Scrolling to Stay safe section");
		scrollDown(1200);
		System.out.println("Scrolled to Stay safe section");
		
		Assert.assertTrue(isDisplayed(demoUi.get_staySafeSection()) && demoUi.get_staySafeSection().getText().contains("Stay safe"), "Problem in Stay bsafe section");
		Assert.assertTrue(isDisplayed(demoUi.get_staySafeImage()), "Problems in Stay Safe image");
		Assert.assertTrue(demoUi.get_staySafeImage().getAttribute("src").equals(pathOfImage), "Image in Stay safe section has changed!!");
		System.out.println("Exiting Stay Safe section");
	}
	
	public void verifyStikPremiumSection(String headText){
		scrollDown(450);
		System.out.println("scrolled to stik premium section");
		System.out.println("Text of Stik premium section on web page:- "+demoUi.get_stikPremiumSection().getText().trim());
		Assert.assertTrue(isDisplayed(demoUi.get_stikPremiumSection()) && demoUi.get_stikPremiumSection().getText().trim().equals(headText), "Problems in Stik Premium section");
		Assert.assertTrue(isDisplayed(demoUi.get_leftSectionOnStikPremiumSection()), "Issues in Animate-Group part under Stik Premium section!!");
		Assert.assertTrue(isDisplayed(demoUi.get_rightSectiononStikPremiumSection()), "Issues in Review part under Stik Premium section!!");
		System.out.println("Exiting stik premium section");
	}

	public void verifyCompanyPageSection(String pathofImage){
		scrollDown(1400);
		System.out.println("scrolled to company page section");
		Assert.assertTrue(isDisplayed(demoUi.get_companyPageSection()), "Company Page section is not present!!!");
		Assert.assertTrue(isDisplayed(demoUi.get_leftpartOnCompanyPageSection()), "Issues in text part of company page section");
		Assert.assertTrue(isDisplayed(demoUi.get_rightpartOnCompanyPageSection()) && demoUi.get_rightpartOnCompanyPageSection().getAttribute("src").equals(pathofImage), "Issues in image part of company page section");
		demoUi.get_rightpartOnCompanyPageSection().click();
		Utilities.hardWait(1);
		Assert.assertTrue(isDisplayed(demoUi.get_companyModalWidget()) && demoUi.get_companyModalWidget().getAttribute("style").contains("display: block"), "Issues in Compnay Page Modal widget");
		demoUi.get_closeButtonForCompanyModal().click();
	}
	
	public boolean checkPlanningButton(String menuUrl){
		scrollDown(1650);
		Assert.assertTrue(isDisplayed(demoUi.get_plansAndPricingButton()), "Pricing Button not present at the bottom");
		demoUi.get_plansAndPricingButton().click();
		Utilities.explicitWait(driver);
		if(driver.getCurrentUrl().equalsIgnoreCase(menuUrl)){
			Reporter.log("See Plans and pricing button is working fine");
			return true;
		}
		return true;
	}
}
