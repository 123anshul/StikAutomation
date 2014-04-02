package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ProfilePageFixture;


//Verify the UI and functionality of different sections present on Profile page.
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

	//Navigating to Professional profile page
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Navigate_To_My_ProfilePage(){
		assert test.navigateToMyProfilePage();
	}

	//Verify cover photo on profile page
	@Test(dependsOnMethods={"C_Navigate_To_My_ProfilePage"})
	public void D_Verify_My_Profile_Cover_Photo(){
	    assert test.verifyCoverPhoto();
	}
	
	//Verify basic UI and links related to Edit Featured Review wizard on profile page
	@Test(dependsOnMethods={"D_Verify_My_Profile_Cover_Photo"})
	public void E_Verify_Featured_Reviews_Section(){
		assert test.verifyFeaturedReviewsSection();
	}
	
	//Click Edit Featured Review link and verify basic UI on Edit Featured review wizard
	@Test(dependsOnMethods={"E_Verify_Featured_Reviews_Section"})
	public void F_Verify_Featured_Review_Model_Window(){
		 test.verifyFeaturedReviewModalWindow();
	}
	
	//Verify functionality of "Share Profile" section on profile page
	@Test(dependsOnMethods={"F_Verify_Featured_Review_Model_Window"})
	public void G_Verify_Share_Profile_Section(){
		 test.verifyShareProfileSection();
	}
	
	//Verify the Basic UI and functionality of "Add photo" modal
	@Test(dependsOnMethods={"G_Verify_Share_Profile_Section"})
	public void H_Verify_Photo_Review_Modal(){
		test.verifyPhotoReviewModal();
	}
	
	//Verify presence of Top Professional section on profile page
	@Test(dependsOnMethods={"H_Verify_Photo_Review_Modal"})
	public void I_Verify_Top_Professional_Section(){
		assert test.verifyTopProfessionalSection();
	}
	
	//Logout from the Application
	@Test(dependsOnMethods={"I_Verify_Top_Professional_Section"})
	public void J_SignOut(){
		test.signOut();
	}

	//close the browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}

}
