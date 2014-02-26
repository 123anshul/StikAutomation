package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ReferralPageFixture;

// Verify Referral Page for a new Stik user
// Verify whether referrals provided by reviewer appear correctly in user profile i.e., on referral page
public class TC_030 {

	private boolean newUserFlag= false;
	public String newUserName="";
	public String newPassword="";
	ReferralPageFixture test = new ReferralPageFixture();

	@BeforeClass
	@Parameters({ "filepath" })
	public void beforeClass(@Optional("data/qatestdata.yml")String filePath){
		test.setUpDataFile(filePath);
	}

	@Test
	@Parameters({"BROWSER"})
	public void setup(@Optional("")String browser) {
		if(newUserFlag) {assert test.createUsersOnFacebook(test.getYamlVal("liveUrl"));}
		newUserName=test.getTestUserName();
		newPassword=test.getTestPassword();
		test.startBrowser(browser);
	}

	//Launch Stick URL
	@Test(dependsOnMethods={"setup"})
	public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		test.launchUrl(test.getYamlVal("liveUrl"));
	}

	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Sign_Up_Using_With_FaceBook()  {
		assert test.signUpWithFacebook(test.getYamlVal("signup.name"),test.getYamlVal("signup.email"),test.getYamlVal("signup.importerEmail"));
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
		test.clickGotItButton();

	}

	@Test(dependsOnMethods={"B_Sign_Up_Using_With_FaceBook"})
	public void C_Navigate_To_Referral_Page()  {
		assert test.navigateToHomePage();
		assert test.navigateToReferralPage();
	}

	@Test(dependsOnMethods={"C_Navigate_To_Referral_Page"})
	public void C_Verify_Referral_Page_For_fresh_User()  {
		assert test.verifyPageLoads();
		assert test.checkProspectsForNewUser(test.getYamlVal("referralPage.freshUserReferralText"),test.getYamlVal("appUrl")+ test.getYamlVal("referralPage.noReferralImageURL"), test.getYamlVal("appUrl")+ test.getYamlVal("referralPage.startCollectingReviewsURL"));
		assert test.checkUpgradeSection(test.getYamlVal("referralPage.callMeNumber"), test.getYamlVal("referralPage.callUsNumber"));
		test.setUserProfileName(newUserName, newPassword);
	}


	@Test(dependsOnMethods={"C_Verify_Referral_Page_For_fresh_User"})
	public void D_signOut_New_User(){
		test.signOut();
	}


	@Test(dependsOnMethods={"D_signOut_New_User"})
	public void F_closeBrowser() {
		test.closeBrowser();
	}

	@Test(dependsOnMethods={"F_closeBrowser"})
	@Parameters({"BROWSER"})
	public void G_setup_Again(@Optional("")String browser) {
		test.startBrowser(browser);
	}

	//Launch Stick URL
	@Test(dependsOnMethods={"G_setup_Again"})
	public void H_launch_URL_Navgiate_to_Stick_HomePage() {
		test.launchUrl(test.getYamlVal("appUrl"));
	}


	@Test(dependsOnMethods={"H_launch_URL_Navgiate_to_Stick_HomePage"})
	public void I_Provide_Review_And_Referral(){
		//test.performRecommenAndReferralWorkflow(test.getYamlVal("otherprofile.starRating"), test.getYamlVal("otherprofile.reviewComment"), test.getYamlVal("recommendFriendList.email1"), test.getYamlVal("recommendFriendList.email2"), test.getYamlVal("recommendFriendList.email3"), test.getYamlVal("appUrl"));
		test.signOut();
	}


	@Test(dependsOnMethods={"I_Provide_Review_And_Referral"})
	public void J_Sign_In_With_New_User_Again()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(newUserName, newPassword, false);

	}

	@Test(dependsOnMethods={"J_Sign_In_With_New_User_Again"})
	public void K_Navigate_To_ReferralPage_Again()  {
		assert test.navigateToReferralPage();
	}

	@Test(dependsOnMethods={"K_Navigate_To_ReferralPage_Again"})
	public void L_Verify_Referral_Page_Again()  {
		assert test.navigateToReferralPage();
		assert test.verifyReferralNames(test.getYamlVal("recommendFriendList.email1"), test.getYamlVal("recommendFriendList.email2"), test.getYamlVal("recommendFriendList.email3"));
		assert test.verifyReferralSupporter(test.getYamlVal("referralPage.userNameOfSupporter"));
		assert test.verifyReferralDates();
	}

	@Test(dependsOnMethods={"L_Verify_Referral_Page_Again"})
	public void M_Referral_Settings()  {
		assert test.checkSettingsButton(test.getYamlVal("appUrl")+ test.getYamlVal("referralPage.settingsPageURL"), test.getYamlVal("referralPage.emailBoyTextOnSettingsPage"));
	}


	@Test(dependsOnMethods={"M_Referral_Settings"})
	public void N_signOut(){
		test.signOut();
	}

	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}

}
