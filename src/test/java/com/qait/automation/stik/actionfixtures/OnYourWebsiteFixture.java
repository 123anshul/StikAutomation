package com.qait.automation.stik.actionfixtures;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class OnYourWebsiteFixture extends SearchPageFixture {


	public void verifySplashSectionText(){
		homePageUi.waitForElementToAppear(onYourWebsiteUi.get_GetStartedNow());
		Assert.assertTrue(onYourWebsiteUi.get_splashText().getText().contains("Stik Reviews on Your Website"), "Incorrect text in splash section!!!");
		Reporter.log("Text in splash section is OK");
		System.out.println("Text in Splash Section is Ok");
	}
	
	public boolean areWidgetStyleOptionsPresent(){
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		homePageUi.waitForElementToAppear(onYourWebsiteUi.get_iFrameheader());
		driver.switchTo().defaultContent();
		onYourWebsiteUi.get_GetStartedNow().click();
		
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_reviewsStyleButton()), "Reviews button in Widget Style not present!!");
		
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_recommendStyleButton()), "Recommendation button in Widget Style not present!!");
		
		Reporter.log("Both Widget Styles present on the page...");
		
		return true;
	}
	
	
	
	public boolean checkiFramePresentOrNot(){
		homePageUi.waitForElementToAppear(onYourWebsiteUi.get_iFrameObject());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameObject()));
		System.out.println("Iframe Present");		
		Reporter.log("IFrame is present...");
		return true;
		
	}
	
	public void verifyContentWithinIframeHeader(){
		System.out.println("Inside IFrame Header");
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		homePageUi.waitForElementToAppear(onYourWebsiteUi.get_iFrameheader());
		
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameheader()));
		System.out.println("IFrame header is present");
		Reporter.log("Header in the iFrame is present..");
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameProfilePic()));
		Reporter.log("Profile Pic in iFrame is present..");
		System.out.println("Profile pic is present");
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameProfileName()));
		Reporter.log("Profile Name in iFrame is present..");
		System.out.println("Profile Name in IFrame is present.. "+ onYourWebsiteUi.get_iFrameProfileName().getText());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameProfileDetails()));
		Reporter.log("Profile Details in iFrame are present.. ");
		System.out.println("Profile Details on IFrame is present.. "+onYourWebsiteUi.get_iFrameProfileDetails().getText());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameReviewMeButton()));
		System.out.println("Review Me button on IFrame is present..");
		Reporter.log("Review Me button on iFrame is present..");
		Utilities.hardWait(2);
		driver.switchTo().defaultContent();
		System.out.println("Out of Iframe header");
		
	
	}
	public void fillDetailsInCustomizeYourWidgetForm(){
		onYourWebsiteUi.get_selectThemeDropDown().click();
		String themeColour=onYourWebsiteUi.get_selectedTheme().getText();
		onYourWebsiteUi.get_selectedTheme().click();
		System.out.println(themeColour);
		onYourWebsiteUi.get_heightOfFrame().clear();
		onYourWebsiteUi.get_widthOfFrame().clear();
		onYourWebsiteUi.get_heightOfFrame().sendKeys(util.getYamlValue("customizeWidgetEnteries.height"));
		onYourWebsiteUi.get_widthOfFrame().sendKeys(util.getYamlValue("customizeWidgetEnteries.width"));
		System.out.println("height:- " + util.getYamlValue("customizeWidgetEnteries.height") + "\n Width:- " +util.getYamlValue("customizeWidgetEnteries.width"));
		onYourWebsiteUi.get_widthOfFrame().sendKeys(Keys.ENTER);
		Utilities.hardWait(2);
		verifyIFrameChangsWithCustomizeWidgetForm(themeColour);
	}
	
	public void verifyWhetherIframeFooterPresentOrNot(){
		scrollDown(250);
		onYourWebsiteUi.get_hideFooterRadio();
		Utilities.hardWait(1);
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		Assert.assertFalse(onYourWebsiteUi.get_iFrameFooter().isDisplayed());
		Reporter.log("Footer not present on selecting \"Hide\" in Display Footer");
		System.out.println("Footer not present on selecting \"Hide\"  in Display Footer");	
		driver.switchTo().defaultContent();
		Utilities.hardWait(2);
		onYourWebsiteUi.get_showFooterRadio();
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_iFrameFooter()));
		Reporter.log("Footer Present on selecting \"Show\" in Display Footer");
		System.out.println("Footer Present on selecting \"Show\" in Display Footer");
		driver.switchTo().defaultContent();
	}
	
	public void embedYourWidgetSection(){
		scrollDown(200);
		onYourWebsiteUi.get_sendToMyWebMasterButton();
		Utilities.hardWait(2);
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_webMasterEmailTextBox()));
		Reporter.log("Send To My Webmaster dialog has opened up and email address field is displayed");
		onYourWebsiteUi.get_webMasterEmailTextBox().sendKeys(util.getYamlValue("sendToMyWebMasterEmailAddress"));
		onYourWebsiteUi.get_emailMyWebMasterButton().click();
		Utilities.hardWait(2);
		homePageUi.waitForElementToAppear(onYourWebsiteUi.get_successMessageOnSendingEmailToWebMaster());
		System.out.println("Success Message:- " +onYourWebsiteUi.get_successMessageOnSendingEmailToWebMaster().getText());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_successMessageOnSendingEmailToWebMaster()));
		Reporter.log("Success Message after sending embed code to Webmaster has appeared. DONE!!!");
		
	}
	
	public void matchIFrameDetailsWithProfileDetails(){
		String [] detailsOnIframeForFirstReviewer= checkForCompleteDetailsOfFirstReviewerInIframe();
		int reviewListCountOnIFrame= verifyReviewListInIframeAndReturnItsSize();
		System.out.println("Review List Count on Iframe:- "+reviewListCountOnIFrame);
		Utilities.hardWait(5);
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_viewProfileLink());
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(reviewListCountOnIFrame == numberOfReviewWith4OrMoreRatingOnProfile(),"Mismatch in Review count with 4+ ratings");
		Reporter.log("Total Number of Reviews In IFrame matches with total reviews on Profile");
		System.out.println("values:- "+detailsOnIframeForFirstReviewer[2]+" and"+profilePageUi.get_firstReviewerProfileComment().getText());
		scrollDown(300);
		//Assert.assertTrue(detailsOnIframeForFirstReviewer[0].contains(profilePageUi.get_firstReviewerProfilePic().getAttribute("src").toString()));
		Assert.assertTrue(detailsOnIframeForFirstReviewer[1].equals(profilePageUi.get_firstReviewerProfileName().getText()),"Profile name is not matchings");
		Assert.assertTrue(detailsOnIframeForFirstReviewer[2].contains(profilePageUi.get_firstReviewerProfileComment().getText()));
		Assert.assertTrue(detailsOnIframeForFirstReviewer[3].equals(profilePageUi.get_firstReviewerProfileDate().getText()));
	}
	
	
	public void verifyIFrameChangsWithCustomizeWidgetForm(String themecolour){
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		String classInfoOfHeader= onYourWebsiteUi.get_iFrameReviewWidgetWrapper().getAttribute("class");
		System.out.println("Class Info:- " +classInfoOfHeader);
		Assert.assertTrue(classInfoOfHeader.contains("width-"+util.getYamlValue("customizeWidgetEnteries.width")));
		Reporter.log("Width of Frame has changed according to the customization ");
		Assert.assertTrue(classInfoOfHeader.contains("height-"+util.getYamlValue("customizeWidgetEnteries.height")));
		Reporter.log("Height of Frame has changed according to the customization");
		Assert.assertTrue(classInfoOfHeader.contains("theme-"+themecolour.toLowerCase()));
		Reporter.log("Theme of Frame has changes according to the customization");
		driver.switchTo().defaultContent();
	}
	
	
	
	
	public int verifyReviewListInIframeAndReturnItsSize(){
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		Assert.assertTrue(isDisplayed(onYourWebsiteUi.get_isIFrameReviewsListPresent()));
		Reporter.log("Reviews Present in Iframe..");
		int reviewListCount=onYourWebsiteUi.get_iFrameReviewsList().size();
		System.out.println("Total Reviews In list:-  " +reviewListCount);
		for(int i=1; i<=reviewListCount;i++){
			System.out.println("Taking rating count...");
			try{
			int ratingCount=onYourWebsiteUi.get_iFrameReviewRatings(i).size();
			System.out.println("Rating count:- "+ratingCount);
			if(ratingCount >= 4){
				Assert.assertTrue(true);
				
			}else{
				Assert.assertTrue(false, "Rating counts are less than 4 in iFrame");
			}
			}catch(Exception ex){
				System.out.println("Improper number in IFrame");
			}
			
		}
		Reporter.log("All the reviews in iFrame are having a rating of 4 or more...");
		driver.switchTo().defaultContent();
		return reviewListCount;
	}
	
	public String[] checkForCompleteDetailsOfFirstReviewerInIframe(){
		System.out.println("In Review List Panel");
		driver.switchTo().frame(onYourWebsiteUi.get_iFrameObject());
		String linkOfProfilePic= onYourWebsiteUi.get_firstReviewerInIframe_ProfilePic().getAttribute("src").toString();
		System.out.println(linkOfProfilePic);
		String profileName=onYourWebsiteUi.get_firstReviewerInIframe_ProfileName().getText();
		String profileDetails= onYourWebsiteUi.get_firstReviewerInIframe_ProfileDetails().getText();
		String profileDate=  onYourWebsiteUi.get_firstReviewerInIframe_ProfileDate().getText();
		System.out.println("Out of Review List Panel");
		driver.switchTo().defaultContent();
		String[] detailsOfFirstReviewerInIFrame=new String[4];
		detailsOfFirstReviewerInIFrame[0]=linkOfProfilePic;
		detailsOfFirstReviewerInIFrame[1]=profileName;
		detailsOfFirstReviewerInIFrame[2]=profileDetails;
		detailsOfFirstReviewerInIFrame[3]=profileDate;
		return detailsOfFirstReviewerInIFrame;
	}
	
	
	public int numberOfReviewWith4OrMoreRatingOnProfile(){
		int FLAG=0;
		int  ratingCountOnTop=Integer.parseInt(profilePageUi.get_RatingCount().getText());
		System.out.println("Rating ");
		for(int i=1;i<=ratingCountOnTop;i++){
			try{
				int temp= profilePageUi.get_ratingsForAllReviews(i).size();
				if(temp >= 4){
					FLAG++;
				}else{
					continue;
				}
			}catch(Exception ex){
				System.out.println("Improper number on Profile");
			}
			
		}
		System.out.println("Value of FLAG:- " +FLAG);
		return FLAG;
	}
	
}
