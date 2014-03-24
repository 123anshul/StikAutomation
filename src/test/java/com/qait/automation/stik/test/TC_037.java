package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.EmailSignUpFixture;

//Verify email only signup feature by importing csv and then reviewing one of the imported professional

public class TC_037 {
	private boolean newUserFlag= false;
	EmailSignUpFixture test = new EmailSignUpFixture();

	@BeforeClass
	@Parameters({ "filepath" })
	public void beforeClass(@Optional("data/qatestdata.yml")String filePath){
		test.setUpDataFile(filePath);
	}

	@Test
	@Parameters({"BROWSER"})
	public void setup(@Optional("")String browser) {
		assert test.startBrowser(browser);
	}

	//Launch Stick URL
	@Test(dependsOnMethods={"setup"})
	public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		assert test.launchUrl(test.getYamlVal("appUrl"));
	}

	//Log in using Facebook account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("EmailUserName"), test.getYamlVal("EmailPassword"),newUserFlag);
	}

	//Launch email signup link
	@Test(dependsOnMethods = {"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Launch_Email_SignUp_Page(){
		test.launchUrl(test.getYamlVal("emailSignup"));
		assert test.importCSV();
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.emailSignup"));
	}

	@Test(dependsOnMethods = {"C_Launch_Email_SignUp_Page"})	
	public void D_Verify__Review_Button_Present_On_Profile(){
		assert test.verifyReviewButtonPresentOnProfilePage();
	}

	@Test(dependsOnMethods={"D_Verify__Review_Button_Present_On_Profile"})
	public void E_Give_Random_Rating_To_The_Professional_On_Profile(){
		assert test.giveRatingForReview();
	}

	@Test(dependsOnMethods={"E_Give_Random_Rating_To_The_Professional_On_Profile"})
	public void F_Submit_Review_Text_On_Profile(){
		assert test.submitReviewtextOnProfile(test.getYamlVal("otherprofile.reviewTextOnProfile"));
	}

	@Test(dependsOnMethods={"F_Submit_Review_Text_On_Profile"})
	public void G_Verify_UI_Verification_screen_after_giving_review_on_Profile(){
		assert test.verifyUIVerificationScreenInlineReview(true);
	}

	@Test(dependsOnMethods={"G_Verify_UI_Verification_screen_after_giving_review_on_Profile"})
	public void H_Verify_Review_Using_Facebook_Credentials_Of_Reviewer(){
		assert test.verifyReviewSubmissionForExistingSession();
	}

	@Test(dependsOnMethods={"H_Verify_Review_Using_Facebook_Credentials_Of_Reviewer"})
	public void I_signOut(){
		test.signOut();
	}

	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
