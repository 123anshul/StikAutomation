package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import org.testng.Reporter;
import com.qait.automation.stik.util.Utilities;


public class UserHomePageFixture extends HomePageFixture {

	public boolean verifyHomePageLoads(){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(userHomePageUi.get_clientDashboard());
		Assert.assertTrue(isDisplayed(userHomePageUi.get_clientDashboard()), "Client Dashboard not present!!!");
		Assert.assertTrue(isDisplayed(userHomePageUi.get_clientPanelSection()), "Problems in Client Panel section");
		Assert.assertTrue(isDisplayed(userHomePageUi.get_clientContentSection()), "Problems in Client Content section");
		Reporter.log("User home page loaded correctly...");
		System.out.println("No problems in loading home page for the user...");
		return true;
	}
	
	public boolean verifyClientPanelSection(String userProfileURL, String referralPage, String websiteURl, String emailURL, String fbPageURL, String fbProfileURL){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_clientProilfeName()) && userHomePageUi.get_clientProilfeName().getText().trim().contains(homePageUi.get_firstName().getText()), "Profile Name of client is not displayed or is incorrect!!");
		Assert.assertTrue(isDisplayed(userHomePageUi.get_clientProfileImage()), "Porifle Image of the client is not displayed");
		Assert.assertTrue(userHomePageUi.get_clientStarRating().size() > 0, "Improper Star rating for the client!!");
		userHomePageUi.get_clientProfileImage().click();
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(userProfileURL), "Profile Image link does not redirect to profile page!!");
		
		homePageUi.get_stiklogo1().click();
		Utilities.explicitWait(driver);
		for(int i=1;i<=2;i++){
			Assert.assertTrue(isDisplayed(userHomePageUi.get_clientReviewsAndReferralNumbers().get(i-1)),"Reviews/Referrals not visible!!");
			userHomePageUi.get_clientReviewsAndReferralNumbers().get(i-1).click();
			Utilities.explicitWait(driver);
			String url=driver.getCurrentUrl();
			if(i==1){
				Assert.assertTrue(url.equalsIgnoreCase(userProfileURL), "Review link not redirecting to correct page!!");
			}else{
				Assert.assertTrue(url.equalsIgnoreCase(referralPage), "Referral Link not redirecting to correct page!!");
			}
			homePageUi.get_stiklogo1().click();
			Utilities.explicitWait(driver);
		}
		
		System.out.println("Size of list in client panel:- "+userHomePageUi.get_clientQuickLinks().size());
		
		for(int i=1;i<=userHomePageUi.get_clientQuickLinks().size();i++){
			Assert.assertTrue(isDisplayed(userHomePageUi.get_clientQuickLinks().get(i-1)), "Link "+i+" is not visible under Showcase My Reviews");
			userHomePageUi.get_clientQuickLinks().get(i-1).click();
			Utilities.explicitWait(driver);
			String url=driver.getCurrentUrl();
			if(i==1){
				Assert.assertTrue(url.equalsIgnoreCase(websiteURl), "On My Website link not redirecting to correct page!!");
				System.out.println("Link 1 clicked");
			}else if(i==2){
				Assert.assertTrue(url.equalsIgnoreCase(emailURL), "In My Email link not redirecting to correct page!!");
				System.out.println("Link 2 clicked");
			}else if(i==3){
				Assert.assertTrue(url.equalsIgnoreCase(fbPageURL), "On Facebook Page link not redirecting to correct page!!");
				System.out.println("Link 3 clicked");
			}else{
				Assert.assertTrue(url.equalsIgnoreCase(fbProfileURL), "On Facebook profile link not redirecting to correct page!!");
				System.out.println("Link 4 clicked");
			}
			homePageUi.get_stiklogo1().click();
			Utilities.explicitWait(driver);
		}
		
		
		return true;
	}
	
	public void verifyLeaderBoardSection(String getMoreReviewsURL, String shareText, String userName){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(userHomePageUi.get_leaderBoradGetMoreReviewsButton());
		Assert.assertTrue(isDisplayed(userHomePageUi.get_leaderBoradOnYourWayText()), "Problems in leaderboard text!!");
		Assert.assertTrue(isDisplayed(userHomePageUi.get_leaderBoradProgressbar()) && userHomePageUi.get_leaderBoradProgressbar().getAttribute("class").contains("perc-"), "Problems in leaderboard progress bar");
		userHomePageUi.get_leaderBoradGetMoreReviewsButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(getMoreReviewsURL), "Get More Reviews button in Leaderboard section not redirecting to correct URL!!!");
		homePageUi.get_stiklogo1().click();
		homePageUi.handleAlert();
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(userHomePageUi.get_leaderBoardTrophyImage()), "Trophy image is not visible!!");
		Assert.assertTrue(userHomePageUi.get_leaderBoradRanksOfCompetitor().size()>0, "Ranks of all 3 competitors not visible!!");
		Assert.assertTrue(userHomePageUi.get_leaderBoradNameOfCompetitors().get(1).getText().contains(userName), "Name of client in competitor list not visible!!!");
	}
	
	public void verifyCompleteProfileAndUnlocklPotentialSections(String callMeNumber, String completprofileLink, String callusNumber){
		scrollDown(300);
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(userHomePageUi.get_completeYourProfileImageBadge()), "Image badge in complete your profile section is not displayed!!");
		userHomePageUi.get_completeYourProfileButton().click();	
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(completprofileLink), "Complete profile link does not redirect to setting page!!");
		homePageUi.get_stiklogo1().click();
		Utilities.explicitWait(driver);
		scrollDown(300);
		Assert.assertTrue(isDisplayed(userHomePageUi.get_callUsLabel()) && userHomePageUi.get_callUsLabel().getText().trim().equalsIgnoreCase(callusNumber) , "Problems in call us number!!");
		userHomePageUi.get_callMeInputBoxBeforeSucess().click();
		userHomePageUi.get_callMeInputBoxBeforeSucess().sendKeys(callMeNumber);
		userHomePageUi.get_requestConsulationButton().click();
		homePageUi.waitForElementToAppear(userHomePageUi.get_successMessageOnConsultation());
		homePageUi.waitForElementToAppear(userHomePageUi.get_disabledRequestConsultationButton());
		Assert.assertTrue(isDisplayed(userHomePageUi.get_callMeTextBoxAfterSuccess()), "Problems in requesting consultation");
		
	}
	
	public void verifyLatestReviewsSection(String profileURL, String getMoreReviewsURL){
		Utilities.explicitWait(driver);
		scrollDown(250);
		Assert.assertTrue(isDisplayed(userHomePageUi.get_latestReviewsLeftArrow()), "Left arrow in Latest Reviews section not displayed");
		Assert.assertTrue(isDisplayed(userHomePageUi.get_latestReviewsRightArrow()), "Right arrow in Latest Reviews section not displayed");
		Utilities.hardWait(5);
		for(int i=0;i<userHomePageUi.get_latestReviewList().size();i++){
			Assert.assertTrue(isDisplayed(userHomePageUi.get_latestReview(i+1)), "Review Is not Displayed");
			System.out.println(userHomePageUi.get_latestReview(i+1).getText());
			System.out.println(i);
			userHomePageUi.get_latestReviewsRightArrow().click();
		}
		scrollDown(250);
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(userHomePageUi.get_latestReviewsGetMoreReviewsButton()), "Get more Review is displayed");
		Utilities.explicitWait(driver);
		userHomePageUi.get_latestReviewsGetMoreReviewsButton().click();
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains(getMoreReviewsURL), "Get More Reviews button in latest reviews section is not redirecting to correct page!!");
		homePageUi.get_stiklogo1().click();
		homePageUi.handleAlert();
		Utilities.explicitWait(driver);
	}
	
	public void verifyFacebookGoogleLinkeinShareProfileSection(){
		Utilities.explicitWait(driver);
		verifyFacebookShareProfile();
		Utilities.explicitWait(driver);
		verifyGoogleShareProfile();
		Utilities.explicitWait(driver);
		verifyLinkedinShareProfile();
	}
	
	public void verifyFacebookGoogleLinkeinBoostProfileSection(){
		Utilities.explicitWait(driver);
		verifyFacebookBoostProfile();
		Utilities.explicitWait(driver);
		verifyGoogleBoostProfile();
		Utilities.explicitWait(driver);
		verifyLinkedinBoostProfile();
	}
	
	public void verifyFacebookShareProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_facebookShareProfileLink()),"Facebook share Profile link is not displayed");
		userHomePageUi.get_facebookShareProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.facebook.com"), "Facebook Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
		
	}
	
	public void verifyGoogleShareProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_googleShareProfileLink()),"Google share Profilelink is not displayed");
		userHomePageUi.get_googleShareProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("plus.google.com"), "Google Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
	}
	
	public void verifyLinkedinShareProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_linkedinShareProfileLink()),"LinkedIn share Profilelink is not displayed");
		userHomePageUi.get_linkedinShareProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.linkedin.com"), "Linkedin Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
	}
	
	public void verifyFacebookBoostProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_facebookBoostProfileLink()),"Facebook Boost Profile link is not displayed");
		userHomePageUi.get_facebookBoostProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.facebook.com"), "Facebook Boost Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
		
	}
	
	public void verifyGoogleBoostProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_googleShareProfileLink()),"Google Boost Profilelink is not displayed");
		userHomePageUi.get_googleBoostProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("plus.google.com"), "Google Boost Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
	}
	
	public void verifyLinkedinBoostProfile(){
		Assert.assertTrue(isDisplayed(userHomePageUi.get_linkedinShareProfileLink()),"LinkedIn Boost Profilelink is not displayed");
		userHomePageUi.get_linkedinBoostProfileLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.linkedin.com"), "Linkedin Boost Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
	}
	
	
}
