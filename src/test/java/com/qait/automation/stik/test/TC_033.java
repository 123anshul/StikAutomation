package com.qait.automation.stik.test;

//import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ProfilePageFixture;

public class TC_033 {

	private boolean newUserFlag= false;
	ProfilePageFixture test=new ProfilePageFixture();

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
		test.launchUrl(test.getYamlVal("appUrl"));
	}

	//Log in using Facebook account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
		assert test.navigateToHomePage();
	}

	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Navigate_To_My_ProfilePage(){
		assert test.navigateToMyProfilePage();
	}


	@Test(dependsOnMethods={"C_Navigate_To_My_ProfilePage"})
	public void D_Verify_My_Profile_Cover_Photo(){
	    assert test.verifyCoverPhoto();
	}
	
	@Test(dependsOnMethods={"D_Verify_My_Profile_Cover_Photo"})
	public void E_Verify_Featured_Reviews_Section(){
		assert test.verifyFeaturedReviewsSection();
	}
	
	@Test(dependsOnMethods={"E_Verify_Featured_Reviews_Section"})
	public void F_Verify_Featured_Review_Model_Window(){
		 test.verifyFeaturedReviewModalWindow();
	}
	
	@Test(dependsOnMethods={"F_Verify_Featured_Review_Model_Window"})
	public void G_Verify_Share_Profile_Section(){
		 test.verifyShareProfileSection();
	}
	
	@Test(dependsOnMethods={"G_Verify_Share_Profile_Section"})
	public void H_Verify_Photo_Review_Modal(){
		test.verifyPhotoReviewModal();
	}
	
	@Test(dependsOnMethods={"H_Verify_Photo_Review_Modal"})
	public void I_Verify_Top_Professional_Section(){
		assert test.verifyTopProfessionalSection();
	}
	
	@Test(dependsOnMethods={"I_Verify_Top_Professional_Section"})
	public void J_SignOut(){
		test.signOut();
	}

	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}

}
