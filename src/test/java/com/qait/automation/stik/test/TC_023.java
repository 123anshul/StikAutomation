package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

// Submission of Review on Profile Page without existing session
public class TC_023 {

	private boolean newUserFlag= false;
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
	public void B_Navigate_To_Profile_Page(){
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.username"));
	}

	@Test(dependsOnMethods={"B_Navigate_To_Profile_Page"})
	public void C_Verify__Review_Button_Present_On_Profile_Page(){
		assert test.verifyReviewButtonPresentOnProfilePage();
	}

	@Test(dependsOnMethods={"C_Verify__Review_Button_Present_On_Profile_Page"})
	public void D_Give_Random_Rating_To_The_Professional_On_Profile_Page(){
		assert test.giveRatingForReview();
	}

	@Test(dependsOnMethods={"D_Give_Random_Rating_To_The_Professional_On_Profile_Page"})
	public void E_Submit_Review_Text_On_Profile_Page(){
		assert test.submitReviewtextOnProfile(test.getYamlVal("otherprofile.reviewTextOnProfile"));
	}

	@Test(dependsOnMethods={"E_Submit_Review_Text_On_Profile_Page"})
	public void F_Verify_UI_Verification_screen_after_giving_review(){
		assert test.verifyUIVerificationScreenInlineReview(false);
	}

	@Test(dependsOnMethods={"F_Verify_UI_Verification_screen_after_giving_review"})
	public void G_Verify_Review_Using_Facebook_Credentials_Of_Reviewer(){
		assert test.verifyReviewSubmission();
	}

	@Test(dependsOnMethods={"G_Verify_Review_Using_Facebook_Credentials_Of_Reviewer"})
	public void H_Verify_Review_gets_Posted_By_Checking_Rating_and_ReviewText_From_Top_Most_Reviewer_On_Profile(){
		assert test.verifyRatingAndReviewOnProfilePage(test.getYamlVal("otherprofile.username"));
	}

	@Test(dependsOnMethods={"H_Verify_Review_gets_Posted_By_Checking_Rating_and_ReviewText_From_Top_Most_Reviewer_On_Profile"})
	public void I_signOut(){
		test.signOut();
	}

	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
