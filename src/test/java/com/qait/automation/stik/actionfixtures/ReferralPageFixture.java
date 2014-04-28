package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import org.testng.Reporter;
import com.qait.automation.stik.util.Utilities;

public class ReferralPageFixture extends SignUpFixture{

		private String newUserProfileName="";
		String userNameForNewUser="";
		String passwordForNewUser="";
		String dateOfReferral="";
		
		public boolean verifyPageLoads(){
			logger.info("Username and password of the new user are:- "+userNameForNewUser + " and "+passwordForNewUser);
			Utilities.explicitWait(driver);
			homePageUi.waitForElementToAppear(referralPageUi.get_yourReferralText());
			Assert.assertTrue(isDisplayed(referralPageUi.get_alertHeading()), "Problem in displaying Alert message!!");
			Assert.assertTrue(isDisplayed(referralPageUi.get_settingsButton()), "Problem in displaying Settings button");
			return true;
		}
		
		public boolean checkProspectsForNewUser(String freshUserReferralText, String noReferralImageURL, String startCollectingReviewsURL ){
			Assert.assertTrue(isDisplayed(referralPageUi.get_yourProspectsNumber()), "Problem in displaying your prospects!!");
			Assert.assertTrue(Integer.valueOf(referralPageUi.get_yourProspectsNumber().getText())==0, "Prospects count is not 0 for new user!!!");
			Assert.assertTrue(isDisplayed(referralPageUi.get_noReferralMessageHeading()) && referralPageUi.get_noReferralMessageHeading().getText().trim().equals(freshUserReferralText), "Problems in referral text under Your prospects section for new user");
			Assert.assertTrue(isDisplayed(referralPageUi.get_noreferralImage()) && referralPageUi.get_noreferralImage().getAttribute("src").equals(noReferralImageURL), "Problems in no referral image for new user");
			Assert.assertTrue(isDisplayed(referralPageUi.get_startCollectingReviewsButton()), "Start collecting reviews button not found");
			referralPageUi.get_startCollectingReviewsButton().click();
			logger.info("Start Collecting Reviews clicked...");
			Utilities.explicitWait(driver);
			String url=driver.getCurrentUrl().trim();
			Assert.assertTrue(url.equals(startCollectingReviewsURL), "Start Collecting Reviews button does not redirect to the correct URL");
			homePageUi.get_stiklogo1().click();
			homePageUi.handleAlert();
			navigateToReferralPage();
			Utilities.explicitWait(driver);
			return true;
		}
		
		public boolean checkUpgradeSection(String callMe, String callUs){
			Assert.assertTrue(isDisplayed(referralPageUi.get_callUsNumber()) && referralPageUi.get_callUsNumber().getText().trim().equals(callUs), "Problems in call us section");
			Assert.assertTrue(isDisplayed(referralPageUi.get_requestConsultationButton()), "Request consultation button is not displayed");
			referralPageUi.get_callMeTextBox().click();
			referralPageUi.get_callMeTextBox().sendKeys(callMe);
			referralPageUi.get_requestConsultationButton().click();
			Utilities.explicitWait(driver);
			homePageUi.waitForElementToAppear(referralPageUi.get_successMessageOnRequestingConsultation());
			referralPageUi.get_closeButtonForSuccessMessage().click();
			return true;
		}
		
		public void setUserProfileName(String newuser, String newPassword){
			homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_viewProfileLink());
			Utilities.explicitWait(driver);
			String profileLink=driver.getCurrentUrl().trim();
			String arr[]=profileLink.split("com/");
			System.out.println("UserName:- "+arr[1]);
			newUserProfileName=arr[1];
			userNameForNewUser=newuser;
			passwordForNewUser=newPassword;
		}
		
		public void navigateToRecommendWorkflowForNewUser(String url){
			String recommendURL=url.replaceAll("screeName", newUserProfileName);
			driver.navigate().to(recommendURL);
			Utilities.explicitWait(driver);
			
		}
		
//		public void performRecommenAndReferralWorkflow(String rating, String reviewText,String email1, String email2, String email3, String appURL){
//			send_Review_Combined(newUserProfileName, reviewText, rating, false);
//			isRecommendScreenPresent();
//			recommendProfessionalsToFriends(email1, email2, email3);
//			dateOfReferral=Utilities.currentDateInStringFormat();
//			driver.navigate().to(appURL);
//		}
		
	//original function according to /professional workflow when new user is created
	/*	public boolean verifyReferralNames(String email1, String email2, String email3){
			boolean flag=false;
			Utilities.explicitWait(driver);
			int sizeOfReferralList=referralPageUi.get_listOfReferrals_Name().size();
			int numberOfProspects= Integer.valueOf(referralPageUi.get_yourProspectsNumber().getText());
			Assert.assertTrue(numberOfProspects==sizeOfReferralList, "Value for Prospects does not match number of referrals!!");
			Reporter.log("Count of Prospects is correct...");
			String[] ymlValues={email1,email2,email3};
			String[] namesOfReferrals=new String[sizeOfReferralList];
			for(int i=0;i<sizeOfReferralList;i++){
				namesOfReferrals[i]=referralPageUi.get_listOfReferrals_Name().get(i).getText();
			}
			
			flag=compareArrays(ymlValues, namesOfReferrals);
			if(flag==true)Reporter.log("Email Ids on referral page are correct as provided by the reviewer...");
			return flag;
			
		}*/
		
		public boolean verifyReferralNames(String email1, String email2, String email3){
			boolean flag=false;
			Utilities.explicitWait(driver);
			int sizeOfReferralList=referralPageUi.get_listOfReferrals_Name().size();
			int numberOfProspects= Integer.valueOf(referralPageUi.get_yourProspectsNumber().getText());
			Assert.assertTrue(numberOfProspects==sizeOfReferralList, "Value for Prospects does not match number of referrals!!");
			Reporter.log("Count of Prospects is correct...");
			String[] ymlValues={email1,email2,email3};
			String[] namesOfReferrals=new String[sizeOfReferralList];
			namesOfReferrals[0]=referralPageUi.get_listOfReferrals_Name().get(4).getText();
			namesOfReferrals[1]=referralPageUi.get_listOfReferrals_Name().get(5).getText();
			namesOfReferrals[2]=referralPageUi.get_listOfReferrals_Name().get(6).getText();
			for(int i=0;i<namesOfReferrals.length;i++){
				logger.info("namesOfReferrals " + i + namesOfReferrals[i]);
			}
			flag=compareArrays(ymlValues, namesOfReferrals);
			if(flag==true)Reporter.log("Email Ids on referral page are correct as provided by the reviewer...");
			return flag;
			
		}
		
		//original function according to /professional workflow when new user is created
	/*	public boolean verifyReferralSupporter(String nameOfReviewer){
			
			Utilities.explicitWait(driver);
			for(int i=0;i<referralPageUi.get_listOfReferrals_Supporter().size();i++){
				Assert.assertTrue(isDisplayed(referralPageUi.get_listOfReferrals_Supporter().get(i)), "Problem in displaying Supporter name!!");
				Assert.assertTrue(referralPageUi.get_listOfReferrals_Supporter().get(i).getText().contains(nameOfReviewer), "Incorrect Name of the supporter");
			}
			Reporter.log("Supporter Name is correctly displayed...");
			return true;
		}*/
		
		public boolean verifyReferralSupporter(String nameOfReviewer){
			
			Utilities.explicitWait(driver);
			for(int i=0;i<referralPageUi.get_listOfReferrals_Supporter().size();i++){
				Assert.assertTrue(isDisplayed(referralPageUi.get_listOfReferrals_Supporter().get(i)), "Problem in displaying Supporter name!!");
			}
			for(int i=4;i<referralPageUi.get_listOfReferrals_Supporter().size();i++){
				Assert.assertTrue(referralPageUi.get_listOfReferrals_Supporter().get(i).getText().contains(nameOfReviewer), "Incorrect Name of the supporter");
			}
			Reporter.log("Supporter Name is correctly displayed...");
			return true;
		}
		//original function according to /professional workflow when new user is created
	/*	public boolean verifyReferralDates(){
			for(int i=0;i<referralPageUi.get_referralDates().size();i++){
				Assert.assertTrue(isDisplayed(referralPageUi.get_referralDates().get(i)), "Date for referral is not displayed");
				Assert.assertTrue(referralPageUi.get_referralDates().get(i).getText().trim().equals(dateOfReferral), "Date of Referral is not correct");
			}
			Reporter.log("Dates of referral are correct...");
			return true;
	}*/
		public boolean verifyReferralDates(){
			for(int i=4;i<referralPageUi.get_referralDates().size();i++){
				Assert.assertTrue(isDisplayed(referralPageUi.get_referralDates().get(i)), "Date for referral is not displayed");
				Assert.assertTrue(referralPageUi.get_referralDates().get(i).getText().trim().equals(util.getYamlValue("dateOfReferral_temp")), "Date of Referral is not correct");
			}
			Reporter.log("Dates of referral are correct...");
			return true;
	}
		//commenting the method as /referral tab on setting page has been removed
		/*public boolean checkSettingsButton(String settingPageURL, String emailBody){
			referralPageUi.get_settingsButton().click();
			Utilities.explicitWait(driver);
			referralPageUi.get_noRadioButton().click();
			Utilities.hardWait(1);
			referralPageUi.get_yesRadioButton().click();
			Assert.assertTrue(driver.getCurrentUrl().equals(settingPageURL), "Settings button doesn't redirect to referral page in settings!!");
			referralPageUi.get_noRadioButton().click();
			Utilities.hardWait(2);
			Assert.assertTrue(referralPageUi.get_emailBodySection().getAttribute("style").contains("display: none;"), "Email body still visible after selecting 'No' Checkbox");
			referralPageUi.get_yesRadioButton().click();
			Utilities.hardWait(2);
			Assert.assertTrue(referralPageUi.get_emailBodySection().getAttribute("style").contains("display: block"), "Email body not visible after selecting 'Yes' Checkbox");
			referralPageUi.get_emailBodyTextArea().click();
			referralPageUi.get_emailBodyTextArea().clear();
			Utilities.hardWait(1);
			referralPageUi.get_emailBodyTextArea().sendKeys(emailBody);
			referralPageUi.get_saveButton().click();
			
			Reporter.log("Settings for Referral section is working fine");
			return true;
		}*/
		
		
}
