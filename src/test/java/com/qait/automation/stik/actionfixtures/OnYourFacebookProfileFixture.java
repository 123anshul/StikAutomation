package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class OnYourFacebookProfileFixture extends OnYourFacebookPageFixture{

	public void verifySplashTextonFacebookProfilePage(){
		homePageUi.waitForElementToAppear(onYourFacebookProfileUi.get_getStartedButton());
		Assert.assertTrue(onYourFacebookProfileUi.get_splashText().getText().contains("Stik Reviews on Your Facebook Profile"), "Incorrect splash text!!");
		Reporter.log("Splash Text on Facebook Profile page is OK");
	}
	
	public boolean isGetStartedButtonPresentOnProfilePage(){
		homePageUi.waitForElementToAppear(onYourFacebookProfileUi.get_getStartedButton());
		Assert.assertTrue(isDisplayed(onYourFacebookProfileUi.get_getStartedButton()));
		return true;
	}

	
	public boolean isDoneMessageDisplayedOnClickingGetStarted(){
		
	onYourFacebookProfileUi.get_getStartedButton().click();
	if(onYourFacebookProfileUi.get_connectToFacebookMessage().getText().contains(util.getYamlValue("fbPostMessageOnClick"))){
		System.out.println("Posting in 30 seconds...");
		Reporter.log("Posting reviews on Facebook Profile Message appeared...");
	}else{
		System.out.println("Message related to posting the message in 30 seconds does not appear");
		Reporter.log("Message related to posting the message in 30 seconds does not appear");
	}
	homePageUi.waitForElementToAppear(onYourFacebookProfileUi.get_addToProfileTab());
	Assert.assertTrue(isDisplayed(onYourFacebookProfileUi.get_connectToFacebookMessage()));
	if(onYourFacebookProfileUi.get_connectToFacebookMessage().getText().equals(util.getYamlValue("fbPostAfterClick"))){
		System.out.println("Done Message has appeared");
		Reporter.log("Done Mesaage appeared..");
		return true;
	}else{
		Reporter.log("Done is not displayed after clicking on Get Started");
		System.out.println("Done is not displayed after clicking on Get Started");
		return false;
		
	}
	
}
	
	public void isAddToProfileTabAndContentVisible(){
		Utilities.hardWait(2);
		Assert.assertTrue(isDisplayed(onYourFacebookProfileUi.get_addToProfileTab()));
		Reporter.log("Add To Profile text appearing...");
		Assert.assertTrue(isDisplayed(onYourFacebookProfileUi.get_addToProfileMessage()));
		Assert.assertTrue(isDisplayed(onYourFacebookProfileUi.get_facebookPageLink()));
		if(onYourFacebookProfileUi.get_addToProfileMessage().getText().equals(util.getYamlValue("addToProfielPageMessageOnFacebookProfilePage"))){
			System.out.println("Correct Messgage in Add to profile section");
			Reporter.log("Correct Message in Add to Profile Section");
			
		}else{
			System.out.println("Not Present");
			Reporter.log("Correct Message on Add to Profile tab is not present..");
			
		}
	}
	
	public boolean checkForAddToProfileLinkOnFacebookProfilePage(){
		onYourFacebookProfileUi.get_facebookPageLink().click();
		Utilities.hardWait(3);
		try{
		Reporter.log("Switching to Facebook Window...");
		homePageUi.changeWindow(1);
		Reporter.log("On Facebook Profile Page...");
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
		}catch(Exception e){
			Reporter.log("Facebook Window didn't open");
			
		}
		homePageUi.changeWindow(0);
		return true;
	}
}	

		
