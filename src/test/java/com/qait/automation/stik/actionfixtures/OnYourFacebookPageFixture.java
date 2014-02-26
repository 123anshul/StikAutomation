package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class OnYourFacebookPageFixture extends OnYourWebsiteFixture{

	public void verifySplashTextOnFacebookPage(){
		homePageUi.waitForElementToAppear(onYourFacebookPageUi.get_fGetStartedButton());
		Assert.assertTrue(onYourFacebookPageUi.get_splashText().getText().contains("Stik Reviews on Your Facebook Business Page"), "Incorrect text in the splash section");
		Reporter.log("Splash text on Facebook page is OK");
	}
	
	public boolean isGetStartedButtonPresent(){
		homePageUi.waitForElementToAppear(onYourFacebookPageUi.get_fGetStartedButton());
		Assert.assertTrue(isDisplayed(onYourFacebookPageUi.get_fGetStartedButton()));
		return true;
	}
	
//	public void selectFacebookPages(int totalPages){
//		int countOfSelectButtons= onYourFacebookPageUi.get_allSelectInstances().size();
//		System.out.println("Number of pages which can be selected:- "+countOfSelectButtons);
//		Reporter.log("Number of pages which can be selected:- "+countOfSelectButtons);
//		int countOfDoneText= onYourFacebookPageUi.get_allDoneInstacnes().size();
//		System.out.println("Number of pages that are already Done:- "+countOfDoneText);
//		Reporter.log("Number of pages that are already Done:- "+countOfDoneText);
//		Utilities.hardWait(2);
//		try{
//		if(countOfSelectButtons>0){
//			int counter=0;
//			while(counter < countOfSelectButtons){
//					onYourFacebookPageUi.get_allSelectInstances().get(counter).click();
//					counter++;
//					Reporter.log("Select button clicked..");
//					break;
//				
//		}
//		
//	}else{
//		System.out.println("No Page to be selected");
//		Reporter.log("No Facebook Page to be selected. All DONE!!");
//	}
//		}catch(Exception e){
//			System.out.println("No Select Button");
//			Reporter.log("No User Facebook Pages left to be selected");
//		}
//	}
	
	public boolean clickFGetStartedButtonAndVerifyMessages(){
		onYourFacebookPageUi.get_fGetStartedButton().click();
		homePageUi.waitForElementToAppear(onYourFacebookPageUi.get_fbLinkToCreatePage());
		Assert.assertTrue(isDisplayed(onYourFacebookPageUi.get_couldNotFindMessage()),"We couldn't find Fb page not Found!!!");
		Assert.assertTrue(isDisplayed(onYourFacebookPageUi.get_fbLinkToCreatePage()), "Hyperlink to create FB page not Found!!!");
		Reporter.log("Correct Messages are displayed on Clicking get Started button...");
		Reporter.log("Hyperlink for creating facebook pages is available...");
		onYourFacebookPageUi.get_fbLinkToCreatePage().click();
		homePageUi.changeWindow(1);
		Utilities.hardWait(3);
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"), "Hyperlink doesn't redirect to Facebook");
		Reporter.log("Clicking the hyperlink correctly redirects to Facebook ...");
		homePageUi.changeWindow(0);
		
		return true;
		
//		int numberOfPagesOnFacebookForThisUser=onYourFacebookPageUi.get_numberOfPagesOnFacebook().size();
//		System.out.println(onYourFacebookPageUi.get_numberOfPagesOnFacebook().get(0).getText());
//		System.out.println("No. of facebook pages:- " + numberOfPagesOnFacebookForThisUser);
//		Reporter.log("Number of facebook pages for this user:- " +numberOfPagesOnFacebookForThisUser);
//		if(numberOfPagesOnFacebookForThisUser == 0){
//			System.out.println("No Facebook Page for this user");
//			Reporter.log("No Facebook Page for this user..");
//			return true;
//		}else{
//			selectFacebookPages(numberOfPagesOnFacebookForThisUser);
//			return true;
//		}
	}
}
