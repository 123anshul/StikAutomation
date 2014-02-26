package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

// Submission of Review on Profile Page with existing session
public class TC_024 {

	private boolean newUserFlag=false;
	SearchPageFixture test=new SearchPageFixture();

	@BeforeClass
	@Parameters({ "filepath" })
	public void beforeClass(@Optional("data/qatestdata.yml")String filePath){
		test.setUpDataFile(filePath);
	}

	@Test
	@Parameters({"BROWSER"})
	public void setup(@Optional("")String browser) {
		if(newUserFlag) {assert test.createUsersOnFacebook(test.getYamlVal("appUrl"));}
		assert test.startBrowser(browser);
	}

	//Launch Stick URL
	@Test(dependsOnMethods={"setup"})
	public void A_launch_URL_Navigate_to_Stick_HomePage() {
		assert test.launchUrl(test.getYamlVal("appUrl"));
	}

	@Test(dependsOnMethods={"A_launch_URL_Navigate_to_Stick_HomePage"})
	public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
		assert test.verifyFirstNameIsDisplayedOnHomePage();
	}

	@Test(dependsOnMethods={"A_launch_URL_Navigate_to_Stick_HomePage"})
	public void C_Navigate_To_Others_Profile_Page(){
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.username"));
	}

	@Test(dependsOnMethods={"C_Navigate_To_Others_Profile_Page"})
	public void D_Verify__Review_Button_Present_On_Profile_Page(){
		assert test.verifyReviewButtonPresentOnProfilePage();
	}

	@Test(dependsOnMethods={"D_Verify__Review_Button_Present_On_Profile_Page"})
	public void E_Give_Random_Rating_To_The_Professional_On_Profile_Page(){
		assert test.giveRatingForReview();
	}

	@Test(dependsOnMethods={"E_Give_Random_Rating_To_The_Professional_On_Profile_Page"})
	public void F_Submit_Review_Text_On_Profile_Page(){
		assert test.submitReviewtextOnProfile(test.getYamlVal("otherprofile.reviewTextOnProfile"));
	}

	@Test(dependsOnMethods={"F_Submit_Review_Text_On_Profile_Page"})
	public void G_Verify_UI_Verification_screen_after_giving_review(){
		assert test.verifyUIVerificationScreenInlineReview(true);
	}

	@Test(dependsOnMethods={"G_Verify_UI_Verification_screen_after_giving_review"})
	public void H_Verify_Review_Using_Facebook_Credentials_Of_Reviewer(){
		assert test.verifyReviewSubmissionForExistingSession();
	}

	@Test(dependsOnMethods={"H_Verify_Review_Using_Facebook_Credentials_Of_Reviewer"})
	public void I_signOut(){
		test.signOut();
	}

	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
