package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.qait.automation.stik.actionfixtures.SignUpFixture;

// Professional "Sign up with Facebook" process for a fresh account
public class TC_022 {
	private boolean newUserFlag= true;
	SignUpFixture test=new SignUpFixture();
	
	
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
    public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		assert test.launchUrl(test.getYamlVal("appUrl"));
    }

	//Log in using Facebook account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
    public void B_Sign_Up_Using_With_FaceBook_Using_Link_On_Professional_Sign_Up_Page()  {
 		assert test.signUpWithFacebook(test.getYamlVal("signup.name"),test.getYamlVal("signup.email"),test.getYamlVal("signup.importerEmail"));
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
    }
	
	@Test(dependsOnMethods={"B_Sign_Up_Using_With_FaceBook_Using_Link_On_Professional_Sign_Up_Page"})
	public void C_Navigate_To_Mail_Panel(){
		assert test.navigateToHomePage();
		assert test.navigateToClientsMailPage_temp();
		assert test.clickContinueOnFBPanel();
		assert test.clickContinueOnLinkedInPanel();
		
	}
	
	@Test(dependsOnMethods={"C_Navigate_To_Mail_Panel"})
	public void D_Import_Email_Contact_And_Verify_It_Gets_Imported(){
		assert test.importIndividualEmailContactOnMailPanel(test.getYamlVal("importEmailId"), test.getYamlVal("importFirstName"), test.getYamlVal("importLastName"));
	}
	
//	@Test(dependsOnMethods={"D_Import_Email_Contact_And_Verify_It_Gets_Imported"})
//	public void E_Verify_UI_Challenge_Meter_Present_Or_Not(){
//		assert test.verifyChallengeMeterPresent(): " UI Challenge meter not present !!";
//		
//	}

	@Test(dependsOnMethods={"D_Import_Email_Contact_And_Verify_It_Gets_Imported"})
	public void F_Verify_CounterValues_And_ProgressBar_On_Selection_Deselction_Of_Contact(){
		test.checkUncheckImportedContactOnEmailPanel_VerifyCounterValues_VeifyUIMeter();
	}
	
	
	@Test(dependsOnMethods={"F_Verify_CounterValues_And_ProgressBar_On_Selection_Deselction_Of_Contact"})
	public void G_Click_Continue_And_Handle_Modal_Dailog_to_Send_Message(){
		assert test.clickContinueOnMailPanel();
		test.handleModalDialogForMessage(test.getYamlVal("messageForCollectingReview"));
	}
	
	@Test(dependsOnMethods={"G_Click_Continue_And_Handle_Modal_Dailog_to_Send_Message"})
	public void H_Select_Industry_PhoneNumber_ZipCode_And_Click_Create_Profile(){
		assert test.handleProfileInfoSection(test.getYamlVal("signup.phoneNo"), test.getYamlVal("signup.zipcode"));
		assert test.verifyUserIsOnProfilePage();
	}
	
	@Test(dependsOnMethods={"H_Select_Industry_PhoneNumber_ZipCode_And_Click_Create_Profile"})
	public void I_signOut(){
		test.signOut();
	}
	
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
	
}
