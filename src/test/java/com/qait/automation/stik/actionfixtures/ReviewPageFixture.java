package com.qait.automation.stik.actionfixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import bsh.util.Util;

import com.qait.automation.stik.util.Utilities;

public class ReviewPageFixture  extends ProfilePageFixture{

	private String reviewTextLocal = "";
	private int localStarRating=0;
	private int waitTime = 60;
	String recommendPageURL="";

	public void sendReviewCombinedWizardAndVerifyGivenReviewAppearOnHomePage(String userName, String reviewText, String rate, boolean loggedinFlag,String email1,String email2,String email3,String otherUserName){
		Reporter.log("Navigating to recommend URL.....");
		if(loggedinFlag)
			reviewPageUi.waitForElementToAppear(reviewPageUi.get_avatarIcon());
		navigateToCombinedReviewPage(userName);
		Utilities.explicitWait(driver);
		
		recommendPageURL=driver.getCurrentUrl();
		
		if(recommendPageURL.contains("/reviews/new")){
			giveInlineReview(reviewText,rate,loggedinFlag);
			boolean flag= verifyReviewerDetailForInlineReview(loggedinFlag);
			if(flag){
				verifyReferralCollectionProcess(email1,email2,email3);
			}
			navigatetoProfilePage(otherUserName);
			verifyReviewAppearOnProfilePageForInlineReview();
		}
		else{
			giveReviewThroughRecommend(reviewText,rate,loggedinFlag);
			isRecommendScreenPresent();
			recommendProfessionalsToFriends(email1,email2,email3);
			navigatetoProfilePage(otherUserName);
			verifyReviewAppearOnProfilePageForRecommendPage();
		}

	}
	 
	
	public boolean giveReviewThroughRecommend(String reviewText,String rate,boolean loggedinFlag){
		int rating = Integer.parseInt(rate);
		boolean flag = false;
		flag = verifyEmptyStarsOnRecommendPageAndGiveRatingsForRecommend(rating);
		flag = flag && addCommentsForRecommend(reviewText, loggedinFlag);
		Reporter.log("Given rating and Added Comments");
		verifyUIVerificationScreenRecommendReview(loggedinFlag);
		return flag;
	}
	
	public boolean giveInlineReview(String reviewText,String rate,boolean loggedinFlag){
		int rating = Integer.parseInt(rate);
		boolean flag = false;
		flag = verifyEmptyStarsOnRecommendPageAndGiveRatingsForInlineReview(rating);
		flag = flag && addCommentsForInlineReviews(reviewText);
		Reporter.log("Given rating and Added Comments");
		verifyUIVerificationScreenInlineReview(loggedinFlag);
		return flag;
	}
	
	public boolean verifyEmptyStarsOnRecommendPageAndGiveRatingsForInlineReview(int rating){
		localStarRating = rating;
		System.out.println("Count stars on recommend page...");
		reviewPageUi.waitForElementToAppear(reviewPageUi.get_starForInlineReview(1));
		int countStar = reviewPageUi.count_starsOnInlineReviewPage();
		System.out.println("Counted stars on recommend page...");
		Assert.assertTrue(countStar==5);
		Reporter.log("Verified that that there are 5 empty stars appearing on Web Page");
		reviewPageUi.get_fifthStarOnInlineModal().click();
		Reporter.log("Given rating "+rating+" Stars");
		return true;
	}
	
	public boolean addCommentsForInlineReviews(String reviewText){
		System.out.println("in addCommentsForInlineReviews");
		reviewTextLocal = reviewText + " " + System.currentTimeMillis();
		Assert.assertTrue(reviewPageUi.get_textAreaBoxForInlineReview().isDisplayed());
		reviewPageUi.get_textAreaBoxForInlineReview().click();
		reviewPageUi.get_textAreaBoxForInlineReview().sendKeys(reviewTextLocal);
		System.out.println("Type in Text Area Box////");
		Assert.assertTrue(reviewPageUi.get_continueButtonForInlineReview().isDisplayed());
		Utilities.hardWait(1);
		reviewPageUi.get_continueButtonForInlineReview().click();
		Reporter.log("Clicked Leave Review Button...");
		System.out.println("Clicked Leave Review Button...");
		homePageUi.waitForElementToAppear(profilePageUi.get_noLink());
		return true;
	}
	
	public boolean verifyReviewerDetailForInlineReview(boolean loggedinFlag){
		boolean flag = false;
		homePageUi.waitForElementToAppear(reviewPageUi.get_yesButtonForInlineReview());
		Assert.assertTrue(isDisplayed(reviewPageUi.get_successMessageForInlineReview()), "Inline review success message doesn't appears");
		Assert.assertTrue(reviewPageUi.get_successMessageForInlineReview().getText().contains("successfully"), "Inline review is not posted successfully");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_reviewerDetailsSectionInlineReview()));
		Assert.assertTrue(isDisplayed(reviewPageUi.get_yesButtonForInlineReview()), "Yes button for inline review is not present");
		if(loggedinFlag){
			reviewPageUi.get_yesButtonForInlineReview().click();
			flag = true;
		}
		else{
			reviewPageUi.get_noButtonForInlineReview().click();
			flag = false;
		}
		return flag;
	}
	
	public boolean verifyEmptyStarsOnRecommendPageAndGiveRatingsForRecommend(int rating){
		localStarRating = rating;		
		System.out.println("Count stars on recommend page...");
		reviewPageUi.waitForElementToAppear(reviewPageUi.get_starXPath(1));
		int countStar = reviewPageUi.count_starsOnRecommendPage();
		System.out.println("Counted stars on recommend page...");
		Assert.assertTrue(countStar==5);
		Reporter.log("Verified that that there are 5 empty stars appearing on Web Page");
		for(int i=0; i< rating; i++){
			Assert.assertTrue(reviewPageUi.get_starXPath(i+1).isDisplayed());
			reviewPageUi.get_starXPath(i+1).click();
		}
		Reporter.log("Given rating "+rating+" Stars");
		return true;
	}

	public boolean addCommentsForRecommend(String reviewText, boolean flag){
		reviewTextLocal = reviewText + " " + System.currentTimeMillis();
		Assert.assertTrue(reviewPageUi.get_textAreaBox().isDisplayed());
		reviewPageUi.get_textAreaBox().click();
		reviewPageUi.get_textAreaBox().sendKeys(reviewTextLocal);
		System.out.println("Type in Text Area Box////");
		Assert.assertTrue(reviewPageUi.get_continueButtonForRecommend().isDisplayed());
		Utilities.hardWait(1);
		reviewPageUi.get_continueButtonForRecommend().click();
		Reporter.log("Clicked Leave Review Button...");
		System.out.println("Clicked Leave Review Button...");
		waitForUrlToAppear(flag);
		return true;
	}
	
	public void isRecommendScreenPresent(){
		boolean ifYesNoButttonPresent;
		try{
		List<WebElement> yesAndNoButton=reviewPageUi.get_recommendYesAndNoButtons();
		int size=yesAndNoButton.size();
		ifYesNoButttonPresent= size>0;
		if(ifYesNoButttonPresent){
			Reporter.log("Yes and No Buttons Present on Recommend Page- Step 3");
			System.out.println("Yes and No Buttons Present on Recommend Page- Step 3");
			reviewPageUi.get_recommendYesButton().click();
			homePageUi.waitForElementToAppear(reviewPageUi.get_recommendReviewerSection());
		}else{
			System.out.println("Recommend Page did not appear");
			Reporter.log("Would you recommend Screen did not appear");
		}
		}catch(Exception ex){
			System.out.println("Recommend Yes/No screen did not appear");
		}
	}
	
	public boolean recommendProfessionalsToFriends(String email1, String email2, String email3){
		Utilities.hardWait(2);
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendEmailTextArea()), "Recommendation Email TextArea not present");
		Reporter.log("Recommend Professional to Friends Email Text area is present...");
		System.out.println("Recommend Professional to Friends Email Text area is present...");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendAddEmailButton()), "Add Button on Recommend to friends Page not available!!");
		Reporter.log("Add Button on Recommend to friends Page is available...");
		
		//enter first email
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().clear();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email1);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(2);
		
		//enter second email
		homePageUi.waitForElementToAppear(reviewPageUi.get_progressMeter());
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendContinueButton()), "Continue button not present after adding any Email on Recommend Page!!");
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().clear();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email2);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(2);
		
		//enter third email
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().clear();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email3);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(4);
		
		Assert.assertTrue(reviewPageUi.get_recommendSavedEmailContacts().size()==3, "Problem in adding contacts!!");
		Assert.assertTrue(verifyEmailIdsGetSavedOnRecommendPage(), "Email Ids could not be verified on Recommend Page");
		reviewPageUi.get_recommendContinueButton().click();
		homePageUi.waitForElementToAppear(reviewPageUi.get_recommendThanksPanel());
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendThanksPanel()), "Thanks Page did not appear!!");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_reviewOnThanksPage()), "Review Submitted does not appear on Thanks Page!!");
		Reporter.log("Review submitted by the user is reflected on Thanks page after Recommend Workflow");
		return true;
	}


	
	public boolean navigateToCombinedReviewPage(String userName){
		String url = util.getYamlValue("combinedReviewWizardUrl").replaceAll("screenName", userName);
		driver.navigate().to(url);
		return true;
	}

	public boolean clickFacebookAuthenticateButtonForRecommend(){
		reviewPageUi.waitForElementToAppear(reviewPageUi.get_faceBookButton());
		Utilities.hardWait(1);
		reviewPageUi.get_faceBookButton().click();
		System.out.println("Clicked Facebook Button");
		return true;
	}
	
	public boolean clickFacebookAuthenticateButtonForInlineReview(){
		reviewPageUi.waitForElementToAppear(reviewPageUi.get_facebookButtonForInlineReview());
		reviewPageUi.get_facebookButtonForInlineReview().click();
		System.out.println("Clicked Facebook Button");
		return true;
	}

	public boolean navigateBackToUserProfile(){
		try{
			homePageUi.handleAlert();
		}catch(Exception e){
			System.out.println("No Alert Present");
		}
		String url= getYamlVal("appUrl")+"/"+getYamlVal("otherprofile.username");
		driver.navigate().to(url);
		try{
			homePageUi.handleAlert();
		}catch(Exception e){
			System.out.println("No Alert Present");
		}
		Reporter.log("Navigate to User Profile");
		return true;
	}

	public boolean verifyReviewAppearOnProfilePageForRecommendPage(){
		Utilities.hardWait(2);
		homePageUi.waitForElementToAppear(profilePageUi.get_coverImage());
		boolean flag = true;
		int countReview=0;
		int count = reviewPageUi.get_reviewCount();
		System.out.println("Review count on profile page:-"+count);
		Reporter.log("There are "+ count + " reviews on profile page");
		for(int i=1; i<=count;i++){
			String reviewText = reviewPageUi.get_reviewText(i).getText().replaceAll("\"", "").replaceAll(" ", "");
			System.out.println("Review Text is: "+reviewText);
			reviewTextLocal = reviewTextLocal.replaceAll("\"","").replaceAll(" ", "");
			System.out.println("Review given "+reviewTextLocal);
			int starCount = reviewPageUi.get_starCount(i);
			if(reviewText.contains(reviewTextLocal)){
				Reporter.log("The review text matches....");
				System.out.println("review text matches");
				if(starCount==localStarRating){
					Reporter.log("Star rating matches....");
					return flag;
				}else
					Reporter.log("Star ratings does not match");
			}else
				countReview=countReview+1;
				Reporter.log("Review text does not match");
		}
		System.out.println("No of times if statement exectuted "+countReview);
		return false;
		
	}
	
	public boolean verifyReviewAppearOnProfilePageForInlineReview(){
		Utilities.hardWait(2);
		homePageUi.waitForElementToAppear(profilePageUi.get_coverImage());
		boolean flag = true;
		int countReview=0;
		localStarRating=1;
		int count = reviewPageUi.get_reviewCount();
		System.out.println("Review count on profile page:-"+count);
		Reporter.log("There are "+ count + " reviews on profile page");
		for(int i=1; i<=count;i++){
			String reviewText = reviewPageUi.get_reviewText(i).getText().replaceAll("\"", "").replaceAll(" ", "");
			System.out.println("Review Text is: "+reviewText);
			reviewTextLocal = reviewTextLocal.replaceAll("\"","").replaceAll(" ", "");
			System.out.println("Review given "+reviewTextLocal);
			int starCount = reviewPageUi.get_starCount(i);
			if(reviewText.contains(reviewTextLocal)){
				Reporter.log("The review text matches....");
				System.out.println("review text matches");
				if(starCount==localStarRating){
					Reporter.log("Star rating matches....");
					return flag;
				}else
					Reporter.log("Star ratings does not match");
			}else
				countReview=countReview+1;
				Reporter.log("Review text does not match");
		}
		System.out.println("No of times if statement exectuted "+countReview);
		return false;
	}


	public boolean verifySortByNewestOnProfilePage(){
		if(get_Browser().equalsIgnoreCase("iexplore")) throw new SkipException("Sort By Newest feature not supported in IE");
		String appUrl= getYamlVal("appUrl");
		driver.get(appUrl+"/"+util.getYamlValue("otherprofile.username"));
		Reporter.log("Verifying sort by Feature on Profile Page");
		int count = reviewPageUi.get_reviewCount();
		Reporter.log("There are "+ count + " reviews on profile page");
		boolean flag = true;
		Date previousDate = null;
		reviewPageUi.click_NewestSelector();


		for(int i=1; i<=count;i++){
			String date = reviewPageUi.get_dateField(i).getText().trim();
			Date currentDate = stringToDate(date);

			if(i==1) previousDate = currentDate;
			//System.out.println("Current date: "+ currentDate);
			//System.out.println("Previous date: "+ previousDate);

			if(currentDate.compareTo(previousDate)==0){
				//System.out.println("isEqual");
				flag = flag && true;;
			}else if(currentDate.compareTo(previousDate)<0){
				//System.out.println("c > p");
				flag = flag && true;
			}else{
				return false;
			}
			previousDate = currentDate;
		}
		return flag;
	}

	public boolean verifySortByOldestOnProfilePage(){
		if(get_Browser().equalsIgnoreCase("iexplore")) throw new SkipException("Sort By Oldest feature not supported in IE");
		String appUrl= getYamlVal("appUrl");
		driver.get(appUrl+"/"+util.getYamlValue("otherprofile.username"));
		Reporter.log("Verifying sort by Feature on Profile Page");
		int count = reviewPageUi.get_reviewCount();
		Reporter.log("There are "+ count + " reviews on profile page");
		boolean flag = true;
		Date previousDate = null;
		reviewPageUi.click_OldestSelector();

		for(int i=1; i<=count;i++){
			String date = reviewPageUi.get_dateField(i).getText().trim();
			Date currentDate = stringToDate(date);

			if(i==1) previousDate = currentDate;
			//System.out.println("Current date: "+ currentDate);
			//	System.out.println("Previous date: "+ previousDate);

			if(currentDate.compareTo(previousDate)==0){
				//	System.out.println("isEqual");
				flag = flag && true;;
			}else if(previousDate.compareTo(currentDate)<0){
				//System.out.println("c < p");
				flag = flag && true;
			}else{
				return false;
			}
			previousDate = currentDate;
		}
		return flag;
	}

	private Date stringToDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean verifyReviewersDetailsAreVisible(String emailOfReviewer, String nameOfReviewer){
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendReviewerSection()), "Reviewer Details not visible");
		Assert.assertTrue(reviewPageUi.get_recommendEmailOfReviewer().getText().trim().equalsIgnoreCase(emailOfReviewer), "Incorrect email address of reviwer");
		Assert.assertTrue(reviewPageUi.get_recommendNameOfReviewer().getText().trim().equalsIgnoreCase(nameOfReviewer), "Incorrect name of reviewer");
		return true;
	}

	public boolean verifyEmailIdsGetSavedOnRecommendPage(){
		boolean FLAG=false;
		Utilities.hardWait(1);
		String[] arrayOfEmailSavedOnRecommedPage=getEmailIdsSavedOnRecommendPage();
		String[] ymlEmailList={util.getYamlValue("recommendFriendList.email1"),util.getYamlValue("recommendFriendList.email2"),util.getYamlValue("recommendFriendList.email3")};
		FLAG=compareArrays(ymlEmailList, arrayOfEmailSavedOnRecommedPage);
		if(FLAG){System.out.println("Contacts Matched...");}
		return FLAG;
	}

	public String[] getEmailIdsSavedOnRecommendPage(){
		int size=reviewPageUi.get_recommendSavedEmailContacts().size();
		String array[]=new String[size];
		for(int i=1;i<=size;i++){
			array[i-1]=reviewPageUi.get_recommendSavedEmailContacts().get(i-1).getText().trim();
			System.out.println("Email Contact Added:- "+array[i-1]);
		}
		return array;
	}


	public boolean navigateToReferralCollectionPage(String url){
		driver.navigate().to(url);
		return true;
	}

	public boolean verifyReferralCollectionProcess(String email1, String email2, String email3){
		homePageUi.waitForElementToAppear(reviewPageUi.get_reviewMessage());
		reviewPageUi.get_spreadTheWordButton().click();
		homePageUi.waitForElementToAppear(reviewPageUi.get_recommendAddEmailButton());
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email1);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(3);
		Assert.assertTrue(reviewPageUi.get_progressMeter().getAttribute("class").contains("perc-6"), "Progress Meter does not move on Adding an email contact");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendContinueButton()), "Continue button not present after adding any Email on Recommend Page!!");
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email2);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(3);
		Assert.assertTrue(reviewPageUi.get_progressMeter().getAttribute("class").contains("perc-13"), "Progress Meter does not move on Adding second email contact");
		reviewPageUi.get_recommendEmailTextArea().click();
		reviewPageUi.get_recommendEmailTextArea().sendKeys(email3);
		reviewPageUi.get_recommendAddEmailButton().click();
		Utilities.hardWait(3);
		Assert.assertTrue(reviewPageUi.get_progressMeter().getAttribute("class").contains("perc-20"), "Progress Meter does not move on Adding third email contact");
		Reporter.log("Progress bar working fine for the feature of importing contacts");

		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendContinueButton()), "Continue button not present after adding any Email on Recommend Page!!");

		for(int i=1;i<=3;i++){
			reviewPageUi.get_firstNameOfSavedEmail(i).sendKeys("TesterFirst");
			reviewPageUi.get_secondNameofSavedEmail(i).sendKeys("SecondTest");
			reviewPageUi.get_phoneNumberofSavedEmail(i).click();
			reviewPageUi.get_phoneNumberofSavedEmail(i).sendKeys("9001234567");
			reviewPageUi.get_doneButton(i).click();
			Utilities.hardWait(1);
		}
		reviewPageUi.get_recommendContinueButton().click();
		homePageUi.waitForElementToAppear(reviewPageUi.get_signUpOnThanksPage());
		Reporter.log("Referral Collection Workflow is working fine...");
		Utilities.hardWait(2);
		return true;
	}


	public boolean waitForYesOrNoButtonToAppear(WebElement element) {
		//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis() + waitTime;
		int elementDisplayed = 0;
		while (System.currentTimeMillis() < endTime) {
			elementDisplayed++;
			try {
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(BaseFixture.AJAX_WAIT, TimeUnit.SECONDS);
					return true;
				}
			} catch (Exception e) {
				Utilities.hardWait(1);
			}
		}// end while
		driver.manage().timeouts().implicitlyWait(BaseFixture.AJAX_WAIT, TimeUnit.SECONDS);
		return false;
	}

	public boolean waitForUrlToAppear(boolean loggedInFlag){
		String u1;
		int count=0;
		
		if(loggedInFlag){
			for(int i=1;i<100;i++){
			u1=driver.getCurrentUrl().trim();
			if(u1.contains("step=3")){
				break;
			}else{
				Utilities.hardWait(1);
			}
			count=count+1;
			}
			System.out.println("Waited for Step 3 for " +count+ " seconds");
			return true;
		}
		else{
			for(int i=1;i<100;i++){
				u1=driver.getCurrentUrl().trim();
				if(u1.contains("step=2")){
					break;
				}else{
					Utilities.hardWait(1);
				}
				count=count+1;
			}
			System.out.println("Waited for Step 2 for " +count+ " seconds");
			return true;
		}
	}	
	
	public boolean verifyUIVerificationScreenInlineReview(boolean loggedinFlag){
		homePageUi.waitForElementToAppear(reviewPageUi.get_uiVerificationHeading());
		Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationHeading()), "Heading is not displayed on UI verification sceen");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationTermsOfUseLink()), "Terms of use link is not displayed on UI Verification screen");
		reviewPageUi.get_uiVerificationTermsOfUseLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		Assert.assertTrue(driver.getCurrentUrl().contains("terms"), "Clicking on Terms of use doesn't navigate to correct url");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_termsOfUseWindowHeading()), "Heading is not displayed on Terms of Use page");
		driver.close();
		homePageUi.changeWindow(0);
		
		if(loggedinFlag){
			Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationContinueButton()), "Continue button is not displayed on inline UI verification screen");
			reviewPageUi.get_uiVerificationContinueButton().click();
		}
		else{
			Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationFacebookButton()), "Facebook button is not displayed on UI Verification screen");
			Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationIdentityLink()), "Identity link is not displayed on UI Verification screen");
			reviewPageUi.get_uiVerificationIdentityLink().click();
			homePageUi.waitForElementToAppear(reviewPageUi.get_uiVerificationIdentityText());
			Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationIdentityText()), "On clicking Identity link, text is not displayed");

			clickFacebookAuthenticateButtonForInlineReview();
			Reporter.log("Clicked Facebook Authenticate button");
			loginUsingFaceBookUserNamePassword(getYamlVal("userName"), getYamlVal("password"), false);
		}
		return true;
	}
	
	public boolean verifyUIVerificationScreenRecommendReview(boolean loggedinFlag){
		homePageUi.waitForElementToAppear(reviewPageUi.get_recommendPageHeading());
		Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendPageVerifyYourReviewText()), "Step 2 Verify your review text is not present");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_uiVerificationTermsOfUseLink()), "Terms of use link is not displayed");
		reviewPageUi.get_uiVerificationTermsOfUseLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		Assert.assertTrue(driver.getCurrentUrl().contains("terms"), "Clicking on Terms of use doesn't navigate to correct url");
		Assert.assertTrue(isDisplayed(reviewPageUi.get_termsOfUseWindowHeading()), "Heading is not displayed on Terms of Use page");
		driver.close();
		homePageUi.changeWindow(0);
		if(loggedinFlag){
			Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendPageContinueButton()), "Continue button is not displayed on recommend UI verification screen");
			reviewPageUi.get_recommendPageContinueButton().click();
		}
		else{
			Assert.assertTrue(isDisplayed(reviewPageUi.get_recommendPageFacebookButton()), "Facebook button is not displayed on recommend UI verification screen");
			clickFacebookAuthenticateButtonForRecommend();
			Reporter.log("Clicked Facebook Authenticate button");
			loginUsingFaceBookUserNamePassword(getYamlVal("userName"), getYamlVal("password"), false);
		}
		return true;
	}
	
}
