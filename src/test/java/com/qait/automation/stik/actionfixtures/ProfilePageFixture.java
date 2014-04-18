package com.qait.automation.stik.actionfixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.qait.automation.stik.util.Utilities;

public class ProfilePageFixture extends ProfileInfoPageFixture{

	String reviewTextLocal="";
	int randomRating=0;
	int reviewCountBeforeReview;
	String recommendPageURL="";
	
	public void isMyProfileOk(String profileName){
		Utilities.explicitWait(driver);
		Assert.assertTrue(profilePageUi.get_profileName().getText().equalsIgnoreCase(profileName));
		Assert.assertTrue(isDisplayed(profilePageUi.get_affiliation()));
		Reporter.log("Job Title is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_phoneNumber()));
		Reporter.log("Phone number is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_about()));
		Reporter.log("About section is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_address()));
		Reporter.log("Address is displayed under contact section");
		Assert.assertTrue(isDisplayed(profilePageUi.get_addressLocality()));
		Reporter.log("City is displayed under contact section");
		Assert.assertTrue(isDisplayed(profilePageUi.get_reviewTab()));
		Reporter.log("Review tab link is displayed on other profile");
	}

	public void isMyProfileOk(){
		isMyProfileOk(util.getYamlValue("update.firstName")+" "+ util.getYamlValue("update.lastName"));
	}

	public void isOthersProfileOk(String profileName){
		Utilities.hardWait(5);
		Assert.assertTrue(profilePageUi.get_profileName().getText().equalsIgnoreCase(profileName));
		Assert.assertTrue(isDisplayed(profilePageUi.get_affiliation()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_phoneNumber()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_about()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_address()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_addressLocality()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_addressRegion()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_postalCode()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_website()));
		//Other Profile Page should have a review tab...
		Assert.assertTrue(isDisplayed(profilePageUi.get_reviewTab()));
	}

	public void isMyProfileMetadataOK(){
		isProfilePageMetadataOK();
	}

	//Verifying metadata of Profile page
	public void isProfilePageMetadataOK(){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaName()),"Meta tag name missing");
		Reporter.log("meta[name='name'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaCharSet()),"Meta tag description missing");
		Reporter.log("meta[name='description'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaContentLanguage()),"Meta tag content missing");
		Reporter.log("meta[content='en-us'][http-equiv='content-language'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaDescription()),"Meta tag og:description missing");
		Reporter.log("meta[name='og:description'] is displayed.");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaFbAdmins()),"Meta tag fb:admins missing");
		Reporter.log("meta[name='fb:admins'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaFbAppId()),"Meta tag fb:app_id missing");
		Reporter.log("meta[name='fb:app_id'] is displayed");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_metaGoogle()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaImage()),"Meta tag image missing");
		Reporter.log("meta[name='image'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOgLocality()),"Meta tag og:locality missing");
		Reporter.log("meta[name='og:locality'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOgPostalCode()),"Meta tag og:postal-code missing");
		Reporter.log("meta[name='og:postal-code'] is displayed");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOgRegion()),"Meta tag og:region missing");
		//		Reporter.log("meta[name='og:region'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOgType()),"Meta tag og:type missing");
		Reporter.log("meta[name='og:type'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOrgDescription()),"Meta tag og:description missing");
		Reporter.log("meta[name='og:description'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOrgImage()),"Meta tag og:image missing");
		Reporter.log("meta[name='og:image'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOrgSiteName()),"Meta og:site_name name missing");
		Reporter.log("meta[name='og:site_name'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOrgTitle()),"Meta tag og:title missing");
		Reporter.log("meta[name='og:title'] is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_metaOrgUrl()),"Meta tag og:url missing");
		Reporter.log("meta[name='og:url'] is displayed");
	}

	public boolean navigatetoProfilePage(String userName){
		String url = util.getYamlValue("appUrl")+"/"+userName;
		driver.navigate().to(url);
		homePageUi.handleAlert();
		return true;
	}

	public void isOtherProfileMetadataOK(){
		isProfilePageMetadataOK();
	}

	public boolean verifyReviewCount(){
		int ratings =  Integer.valueOf(profilePageUi.get_RatingCount().getText().trim());
		Utilities.hardWait(10);
		int ratingsRowCount = profilePageUi.get_reviewRows().size();	
		Reporter.log("Review Count On Page: "+ ratings);
		Reporter.log("Review Row on Page "+ ratingsRowCount);
		if(ratings == ratingsRowCount){
			Reporter.log("Review Count Matches");
			return true;
		}
		Reporter.log("Review Count does not Matches");
		return false;
	}

	public boolean verifyFeaturedReviewCount(){
		Utilities.hardWait(10);
		int ratingsRowCount = profilePageUi.get_reviewRows().size();	
		if(ratingsRowCount>3 ){
			Reporter.log("Review Count Matches");
			return true;
		}
		Reporter.log("Review Count does not Matches");
		return false;
	}

	public boolean verifyFacebookLinkedinGooglePlusLinkAppearOnProfilePage(){
		Assert.assertTrue(isDisplayed(profilePageUi.get_facebookLink()), "Facebook link missing");
		Assert.assertTrue(isDisplayed(profilePageUi.get_linkedInLink()),"LinkedIn Link Missing");
		Assert.assertTrue(isDisplayed(profilePageUi.get_googlePlusLink()),"Google Plus Link Missing");
		//Assert.assertTrue(isDisplayed(profilePageUi.get_twitterLink()),"Twitter Link Missing");
		return true;
	}

	public boolean verifyProfileInfoLinksPresent(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(isDisplayed(profilePageUi.get_jobTitleLink()), "Add your Job Title Link not present");
		logger.info("Job Title Link Says:- "+profilePageUi.get_jobTitleLink().getText());
		Reporter.log("Add Your Job Title Hyperlink available...");
		Assert.assertTrue(isDisplayed(profilePageUi.get_compnayLink()), "Add your compnay Link not present");
		logger.info("Company link Says:- "+ profilePageUi.get_compnayLink().getText());
		Reporter.log("Add Your Company Hyperlink available...");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_licenseLink()), "Add your license Link not present");
		//		System.out.println("License Link present");
		//		Reporter.log("Add Your License Hyperlink available...");
		//		profilePageUi.get_contactTab().click();
		Assert.assertTrue(isDisplayed(profilePageUi.get_addressLink()), "Add Address Link not present");
		logger.info("Add Address Link present");
		Reporter.log("Add Address Hyperlink available...");
		Assert.assertTrue(isDisplayed(profilePageUi.get_locationLink()), "Add location Link not present");
		logger.info("Add location Link present");
		Reporter.log("Add Location Hyperlink available...");
		Assert.assertTrue(isDisplayed(profilePageUi.get_editPhoneNumberLink()), "Add Phone Number Link not present");
		logger.info("Add Phone Number Link present");
		Reporter.log("Add Phone Number Hyperlink available...");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_cityLink()), "Add City Link not present");
		//		System.out.println("Add City Link present");
		//		Reporter.log("Add City Hyperlink available...");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_stateLink()), "Add State link not present");
		//		System.out.println("Add State link present");
		//		Reporter.log("Add State Hyperlink available...");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_zipCodeLink()), "Add zip code link not present");
		//		System.out.println("Add Zip Code link present");
		//		Reporter.log("Add Zip Code Hyperlink available...");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_emailUserLink()), "Email User link not present");
		//		Reporter.log("Email User Hyperlink available...");
		//		System.out.println("Email User link present");
		//		Assert.assertTrue(isDisplayed(profilePageUi.get_webSiteLink()), "Add Website link not present");
		//		System.out.println("Add Website link present");
		//		Reporter.log("Add Website hyperlink available");
		return true;

	}

	public void verifyJobTitleLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_jobTitleLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_titleTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_titleTextBox()), "Profile Title text box missing");

		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("Job Title hyperlink lands on correct page...");
		}else{
			Reporter.log("Job Title hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void verifyCompanyLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_compnayLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_companyTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_companyTextBox()), "Profile Company Text box missing");

		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("Company hyperlink lands on correct page...");
		}else{
			Reporter.log("Company hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void verifyLicenseLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_licenseLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_licenseTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_licenseTextBox()), "License Text box missing");
		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("License hyperlink lands on correct page...");
		}else{
			Reporter.log("License hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void verifyPhoneNumberEditButton(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_editPhoneNumberLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_phoneNumberTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_phoneNumberTextBox()), "Phone Number Text box missing");
		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("License hyperlink lands on correct page...");
		}else{
			Reporter.log("License hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void verifyAddressLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		//profilePageUi.get_contactTab().click();
		//Utilities.hardWait(2);
		profilePageUi.get_addressLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_addressTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_addressTextBox()), "Profile Address Text box missing");

		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("Address hyperlink lands on correct page...");
		}else{
			Reporter.log("Address hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

//		public void verifyCityLink(){
//			homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
//			profilePageUi.get_contactTab().click();
//			Utilities.hardWait(2);
//			profilePageUi.get_cityLink().click();
//			homePageUi.waitForElementToAppear(profileInfoPageUi.get_cityNameTextBox());
//			Assert.assertTrue(isDisplayed(profileInfoPageUi.get_cityNameTextBox()), "Profile City Text box missing");
//			
//			if(driver.getCurrentUrl().toString().contains("settings")){
//				Reporter.log("City hyperlink lands on correct page...");
//			}else{
//				Reporter.log("City hyperlink not redirecting to Proifle Info Page !!");
//			}
//			navigateToMyProfilePage();
//		}

//		public void verifyStateLink(){
//			homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
//			profilePageUi.get_contactTab().click();	
//			Utilities.hardWait(2);
//			profilePageUi.get_stateLink().click();
//			homePageUi.waitForElementToAppear(profileInfoPageUi.get_saveButton());
//			Assert.assertTrue(isDisplayed(profileInfoPageUi.get_stateDropDownSingle()), "Profile State drop down missing");
//	
//			if(driver.getCurrentUrl().toString().contains("settings")){
//				Reporter.log("State hyperlink lands on correct page...");
//			}else{
//				Reporter.log("State hyperlink not redirecting to Proifle Info Page !!");
//			}
//			navigateToMyProfilePage();
//		}

//
//	public void verifyZipCodeLink(){
//		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
//		profilePageUi.get_contactTab().click();	
//		Utilities.hardWait(2);
//		homePageUi.waitForElementToAppear(profileInfoPageUi.get_saveButton());
//		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_zipCodeTextBox()), "Profile Zip Code text box missing");
//	
//		if(driver.getCurrentUrl().toString().contains("settings")){
//		Reporter.log("Zip hyperlink lands on correct page...");
//		}else{
//			Reporter.log("Zip hyperlink not redirecting to Proifle Info Page !!");
//		}
//		navigateToMyProfilePage();
//	}

//		public void verifyEmailUserLink(){
//			homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
//			profilePageUi.get_contactTab().click();	
//			Utilities.hardWait(2);
//			profilePageUi.get_emailUserLink().click();
//			Utilities.hardWait(2);
//			if(isDisplayed(profilePageUi.get_messageModal()) && profilePageUi.get_messageModal().getAttribute("style").contains("display: block")){
//				Reporter.log("Contact User Modal on Profile page opened...");
//			}else{
//				Reporter.log("Problem in Email user link");
//			}
//			profilePageUi.get_closeModalIcon().click();
//			Utilities.hardWait(1);
//			Assert.assertTrue(profilePageUi.get_messageModal().getAttribute("style").contains("display: none"), "Email User Modal dialog did not close");
//			System.out.println("Closed Email User Modal dialog");
//			Reporter.log("Closed Email User Modal dialog");
//			scrollDown(50);
//		}

	public void verifyWebsiteCodeLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Utilities.hardWait(2);
		profilePageUi.get_webSiteLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_websiteTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_websiteTextBox()), "Profile WebSite text box missing");

		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("WebSite hyperlink lands on correct page...");
		}else{
			Reporter.log("WebSite hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void verifyLocationLink(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_locationLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_cityNameTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_cityNameTextBox()), "Profile Address Text box missing");

		if(driver.getCurrentUrl().toString().contains("settings")){
			Reporter.log("Location hyperlink lands on correct page...");
		}else{
			Reporter.log("Location hyperlink not redirecting to Proifle Info Page !!");
		}
		navigateToMyProfilePage();
	}

	public void navigatetosettingpage(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		profilePageUi.get_jobTitleLink().click();
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_titleTextBox());
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_titleTextBox()), "Profile Title text box missing");		
	}


	public boolean isInlineReviewSectionPresentOnProfilePage(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(isDisplayed(profilePageUi.get_inLineReviewSection()), "The in-line review section is not displayed");
		Reporter.log("Inline Review section is displayed correctly...");
		System.out.println("In Line Review section is present...");
		return true;
	}

	//Clicking and verifying "Review" button on professional's profile page
	public boolean verifyReviewButtonPresentOnProfilePage(){
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(isDisplayed(profilePageUi.get_reviewButtonOnProfilePage()), "The Review button is not displayed");
		Reporter.log("Review button is displayed correctly...");
		System.out.println("Review button is present...");
		reviewCountBeforeReview=calculateReviewCountOnProfilePage();
		profilePageUi.get_reviewButtonOnProfilePage().click();
		return true;
	}

	public int calculateReviewCountOnProfilePage(){
		String reviewCountText=profilePageUi.get_RatingCount().getText();
		int reviewCount=Integer.parseInt(reviewCountText);
		return reviewCount;
	}

	//Give the random star rating to the professional
	public boolean giveRatingForReview(){
		randomRating=generateRandomNumber(1, 5);
		recommendPageURL=driver.getCurrentUrl();
		if(recommendPageURL.contains("#/reviews/new/")){
			Assert.assertTrue(isDisplayed(profilePageUi.get_randomStarRating(randomRating)), "random rating stars are not pesent");
			profilePageUi.get_randomStarRating(randomRating).click();
		}
		else{
			Assert.assertTrue(isDisplayed(reviewPageUi.get_starXPath(randomRating)), "Rating stars for recommend is not present");
			reviewPageUi.get_starXPath(randomRating).click();
		}
		Utilities.hardWait(1);
		return true;
	}

	//Give review to professional and click "Continue"
	public boolean submitReviewtextOnProfile(String reviewContent){
		reviewTextLocal=reviewContent+" "+System.currentTimeMillis();
		recommendPageURL=driver.getCurrentUrl();
		if(recommendPageURL.contains("#/reviews/new/")){
			profilePageUi.get_textAreaForReview().click();
			Utilities.hardWait(1);
			profilePageUi.get_textAreaForReview().sendKeys(reviewTextLocal);
			Utilities.hardWait(3);
			profilePageUi.get_continueButton().click();
			
		}else{
			Assert.assertTrue(reviewPageUi.get_textAreaBox().isDisplayed());
			reviewPageUi.get_textAreaBox().click();
			reviewPageUi.get_textAreaBox().sendKeys(reviewTextLocal);
			System.out.println("Type in Text Area Box////");
			Assert.assertTrue(reviewPageUi.get_continueButtonForRecommend().isDisplayed());
			Utilities.hardWait(1);
			reviewPageUi.get_continueButtonForRecommend().click();
			Reporter.log("Clicked Leave Review Button...");
			System.out.println("Clicked Leave Review Button...");
			Utilities.hardWait(3);
		}
		return true;
	}

	//Verify whether user is logged in or not and then perform required action accordingly
	public boolean verifyReviewSubmission(){
		recommendPageURL=driver.getCurrentUrl();
		if(recommendPageURL.contains("#/reviews/new/")){
			reviewPageUi.waitForElementToAppear(reviewPageUi.get_facebookButtonForInlineReview());
//			Utilities.hardWait(1);
//			reviewPageUi.get_facebookButtonForInlineReview().click();
//			System.out.println("Clicked Facebook Button");
//			loginUsingFaceBookUserNamePassword(getYamlVal("userName"), getYamlVal("password"), false);
			homePageUi.waitForElementToAppear(reviewPageUi.get_yesButtonForInlineReview());
			profilePageUi.get_noLink().click();
		}
		else{
			reviewPageUi.waitForElementToAppear(reviewPageUi.get_faceBookButton());
			Utilities.hardWait(1);
			reviewPageUi.get_faceBookButton().click();
			System.out.println("Clicked Facebook Button");
			loginUsingFaceBookUserNamePassword(getYamlVal("userName"), getYamlVal("password"), false);
			isRecommendScreenPresent();
		}
		return true;
	}
	
	public void isRecommendScreenPresent(){
		boolean ifYesNoButttonPresent;
		List<WebElement> yesAndNoButton=reviewPageUi.get_recommendYesAndNoButtons();
		int size=yesAndNoButton.size();
		ifYesNoButttonPresent= size>0;
		if(ifYesNoButttonPresent){
			Reporter.log("Yes and No Buttons Present on Recommend Page- Step 3");
			System.out.println("Yes and No Buttons Present on Recommend Page- Step 3");
			reviewPageUi.get_recommendNoButton().click();
			homePageUi.waitForElementToAppear(reviewPageUi.get_thankPageText());
		}else{
			System.out.println("Recommend Page did not appear");
			Reporter.log("Would you recommend Screen did not appear");
		}
	}

	public boolean verifyReviewSubmissionForExistingSession(){
		recommendPageURL=driver.getCurrentUrl();
		if(recommendPageURL.contains("#/reviews/new/")){
			homePageUi.waitForElementToAppear(profilePageUi.get_noLink());
			Assert.assertTrue(isDisplayed(profilePageUi.get_noLink()), "No link for verifying review does not appear!!");
			profilePageUi.get_noLink().click();
			Utilities.explicitWait(driver);
			
		}else{
			homePageUi.waitForElementToAppear(reviewPageUi.get_recommendNoButton());
			isRecommendScreenPresent();
			
		}
		return true;
	}

	public boolean doesThankYouTabAppear(){
		homePageUi.waitForElementToAppear(profilePageUi.get_savingReviewtext());
		Utilities.hardWait(3);
		Assert.assertTrue(profilePageUi.get_thanksForReviewText().getText().contains("Thanks for your review"), "Thanks for review text not displayed!!!");
		return true;
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


	public boolean sortByNewestOnProfilePage(){
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

	public boolean verifyRatingAndReviewFromFirstReviewer(String userName){
		navigatetoProfilePage(userName);
		homePageUi.handleAlert();
		scrollDown(500);
		Utilities.explicitWait(driver);
		sortByNewestOnProfilePage();
		int reviewRatingOnProfile= profilePageUi.get_firstReviewerRatingCount();
		System.out.println("review Rating on profile:-"+reviewRatingOnProfile);
		System.out.println("randomRating give on profile Page:-"+randomRating);
		if(randomRating==reviewRatingOnProfile){
			String reviewCommentOnProfile= profilePageUi.get_firstReviewerProfileComment().getText().replaceAll("\"", "").replaceAll(" ", "");
			if(reviewCommentOnProfile.equalsIgnoreCase(reviewTextLocal.replaceAll("\"", "").replaceAll(" ", ""))){
				Reporter.log("Review Text and Rating count matches... ");
				System.out.println("Review text and Rating Count Matches...");
				return true;
			}else{
				Reporter.log("Review text on profile doesn't match with the review submitted");
				System.out.println("Error in Review text");
				return false;
			}

		}else{
			Reporter.log("Rating count on profile doesn't match with the rating submitted");
			System.out.println("Error in Rating count!!");
			return false;
		}
	}
	
	public boolean verifyRatingAndReviewFromFirstReviewer(){
		homePageUi.waitForElementToAppear(profilePageUi.get_coverImage());
		scrollDown(500);
		Utilities.explicitWait(driver);
		sortByNewestOnProfilePage();
		int reviewRatingOnProfile= profilePageUi.get_firstReviewerRatingCount();
		if(randomRating==reviewRatingOnProfile){
			String reviewCommentOnProfile= profilePageUi.get_firstReviewerProfileComment().getText().replaceAll("\"", "").replaceAll(" ", "");
			if(reviewCommentOnProfile.equalsIgnoreCase(reviewTextLocal.replaceAll("\"", "").replaceAll(" ", ""))){
				Reporter.log("Review Text and Rating count matches... ");
				System.out.println("Review text and Rating Count Matches...");
				return true;
			}else{
				Reporter.log("Review text on profile doesn't match with the review submitted");
				System.out.println("Error in Review text");
				return false;
			}

		}else{
			Reporter.log("Rating count on profile doesn't match with the rating submitted");
			System.out.println("Error in Rating count!!");
			return false;
		}
		
	}
	
	//Navigate to other professional's profile and verify Review count on his profile
	public boolean verifyRatingAndReviewOnProfilePage(String userName){
		navigatetoProfilePage(userName);
		homePageUi.handleAlert();
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		String countText=profilePageUi.get_RatingCount().getText();
		int reviewCountAfterReview=Integer.parseInt(countText);
		System.out.println("Review Count After Review"+reviewCountAfterReview);
		if(reviewCountAfterReview==reviewCountBeforeReview+1){
			return true;
		}
		else{
			return false;
		}
	}

	public void verifySelectedFeaturedReviews(){
		homePageUi.waitForElementToAppear(profilePageUi.get_popUpCross());
		Utilities.explicitWait(driver);
		int reviewCount=profilePageUi.get_totalReviewInPopUp().size();
		System.out.println("Size of review list on Featured modal window:- "+reviewCount);
		scrollDown(100);
		for(int i=0;i<3;i++){
			profilePageUi.get_totalReviewInPopUp().get(i).click();
			Utilities.hardWait(2);
		}
		Assert.assertTrue(profilePageUi.get_textForTotalReviewInPopUp().get(0).getText().equals(profilePageUi.get_textForfeaturedReviewsInPopUp().get(0).getText()), "First Review does not Matches");
		Assert.assertTrue(profilePageUi.get_textForTotalReviewInPopUp().get(1).getText().equals(profilePageUi.get_textForfeaturedReviewsInPopUp().get(1).getText()), "Second Review does not Matches");
		Assert.assertTrue(profilePageUi.get_textForTotalReviewInPopUp().get(2).getText().equals(profilePageUi.get_textForfeaturedReviewsInPopUp().get(2).getText()), "First Review does not Matches");
		profilePageUi.get_popUpCross().click();
	}

	//Verifying the functionality of "Edit Featured Review" modal on profile page
	public void verifyFeaturedReviewModalWindow(){
		homePageUi.waitForElementToAppear(profilePageUi.get_editFeaturedReviewLink());
		scrollDown(100);
		boolean editFeaturedReviewLink=isDisplayed(profilePageUi.get_editFeaturedReviewLink());
		if(editFeaturedReviewLink){
			Utilities.hardWait(2);
			profilePageUi.get_editFeaturedReviewLink().click();
			logger.info("Link clicked!");
			homePageUi.waitForElementToAppear(profilePageUi.get_popUpCross());
			Assert.assertTrue(profilePageUi.get_featuredReviewModelWindow().getAttribute("style").contains("visibility: visible"));
			Utilities.explicitWait(driver);
			verifyRearrangeFunctionality();
			Utilities.explicitWait(driver);
			profilePageUi.get_popUpCross().click();
		}

	}

	public void verifyRearrangeFunctionality(){
		boolean featuredReviewPresent=(profilePageUi.get_featuredReviewsInPopUp().size()>2);
		if(featuredReviewPresent){
			Utilities.explicitWait(driver);
			Utilities.hardWait(2);
			String textForSecondReview=profilePageUi.get_textForfeaturedReviewsInPopUp().get(1).getText();
			String nameOnSecondReview=profilePageUi.get_profileNameForFeaturedReviewsInPopUp().get(1).getText();
			logger.info("Text for second top review:-"+textForSecondReview);
			profilePageUi.get_featuredReviewsInPopUp().get(1).click();
			Utilities.explicitWait(driver);
			Assert.assertTrue(profilePageUi.get_featuredReviewsInPopUp().get(1).getAttribute("class").contains("selected"),"Review is not selected");
			Utilities.explicitWait(driver);
			profilePageUi.get_reviewUpbuttonInPopUp().click();
			Assert.assertTrue(profilePageUi.get_textForfeaturedReviewsInPopUp().get(0).getText().equals(textForSecondReview), "Review text doesnt not matches");
			Assert.assertTrue(profilePageUi.get_profileNameForFeaturedReviewsInPopUp().get(0).getText().equals(nameOnSecondReview), "Profile name doesnot matches");
			Utilities.explicitWait(driver);
			profilePageUi.get_reviewDownButtonInPopUp().click();
			Assert.assertTrue(profilePageUi.get_textForfeaturedReviewsInPopUp().get(1).getText().equals(textForSecondReview),"Review text doent match");
			Assert.assertTrue(profilePageUi.get_profileNameForFeaturedReviewsInPopUp().get(1).getText().equals(nameOnSecondReview), "Profile Name does not matches");
		}
	}
	
	//Verify "Featured Review" section on Profile page
	public boolean verifyFeaturedReviewsSection(){
		Assert.assertTrue(profilePageUi.get_featuredReviewsSectionText().getText().contains("FEATURED REVIEWS"), "Edit featured reviews section is not Displayed");
		Reporter.log("Fetured reviews are displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_editFeaturedReviewLink()), "Edit fetaured review Link is not Displayed");
		Reporter.log("Edit fetured review link is displayed");
		Assert.assertTrue(isDisplayed(profilePageUi.get_viewAllReviewLink()), "view all review Link is not Displayed");
		Reporter.log("View all review Link is Displayed");
		return true;
	}

	//Verify "Top Professional" section appears on profile page
	public boolean verifyTopProfessionalSection(){
		scrollDown(250);
		Assert.assertTrue((profilePageUi.get_topProfessionals().size()==5),"Top professionals section is not dispalyed");
		Reporter.log("Top professionals section is displayed");
		return true;
	}

	//Verify the "Share Profile" on Facebook/Linked In/Google+ 
	public void verifyShareProfileSection(){
		scrollDown(50);
		Utilities.explicitWait(driver);
		verifyFacebookShareProfile();
		Utilities.explicitWait(driver);
		verifyLinkedinShareProfile();
		Utilities.explicitWait(driver);
		verifyGooglePlusShareProfile();
		Utilities.explicitWait(driver);
		verifyProfileUrlTextbox();
	}
	
	//Verify "Add Photo" link appear on Profile page and then click it
	public void verifyPhotoReviewModal(){
		Utilities.explicitWait(driver);
		scrollDown(150);
		homePageUi.mouseMove(profilePageUi.get_reviewAction(), profilePageUi.get_addPhotoLink());
		homePageUi.waitForElementToAppear(profilePageUi.get_addPhotoModelText());
		Assert.assertTrue(profilePageUi.get_addPhotoModalWindow().getAttribute("style").contains("visibility: visible"), "Add Photo model window doesnt open");
		Assert.assertTrue(isDisplayed(profilePageUi.get_addPhotoModalSelectButton()));
		Assert.assertTrue(isDisplayed(profilePageUi.get_addPhotoModelCrossButton()));
		profilePageUi.get_addPhotoModelCrossButton().click();
	}
	
	public void verifyProfileUrlTextbox(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(profilePageUi.get_profileUrlInputBox()), "Profile URL input box is not displayed");
		Assert.assertTrue(profilePageUi.get_profileUrlInputBox().getAttribute("value").contains("www.stik.com"), "Profile URL is not correct");
	}
	
	//Share profile on Facebook through the link appearing on Profile page
	public void verifyFacebookShareProfile(){
		homePageUi.waitForElementToAppear(profilePageUi.get_facebookLink());
		Assert.assertTrue(isDisplayed(profilePageUi.get_facebookLink()), "facebook share button is not present");
		profilePageUi.get_facebookLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.facebook.com"), "Facebook Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
	}
	
	//Share profile on Linked In through the link appearing on Profile page
	public void verifyLinkedinShareProfile(){
		homePageUi.waitForElementToAppear(profilePageUi.get_linkedInLink());
		Assert.assertTrue(isDisplayed(profilePageUi.get_linkedInLink()), "linkedin share button is not present");
		profilePageUi.get_linkedInLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("www.linkedin.com"), "linkedin Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
	}
	
	//Share profile on Google+ through the link appearing on Profile page
	public void verifyGooglePlusShareProfile(){
		homePageUi.waitForElementToAppear(profilePageUi.get_googlePlusLink());
		Assert.assertTrue(isDisplayed(profilePageUi.get_googlePlusLink()), "Google share button is not present");
		profilePageUi.get_googlePlusLink().click();
		Utilities.explicitWait(driver);
		homePageUi.changeWindow(1);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("plus.google.com"), "Google Share Profile Link is not opened");
		driver.close();
		homePageUi.changeWindow(0);
	}

	//Verifying whether cover image is displayed on profile page or not
	public boolean verifyCoverPhoto(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(profilePageUi.get_coverImage()), "Cover image is not displayed");
		Assert.assertTrue(profilePageUi.get_coverImage().getAttribute("style").contains("background-image"), "Cover image is not displayed");
		return true;
	}
}
