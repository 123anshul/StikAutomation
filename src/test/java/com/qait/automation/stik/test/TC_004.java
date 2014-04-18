package com.qait.automation.stik.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

//Check metadata on MyProfile Page and Other Profile Page.
public class TC_004 {

	private boolean newUserFlag= false;
	SearchPageFixture test = new SearchPageFixture();
	
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
	
	//Verifying metadata of Profile page
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Navigate_To_My_ProfilePage_Verify_MetaDataTags(){
		assert test.navigateToMyProfilePage();
		test.isMyProfileMetadataOK();
	}
	
	//Verifying metadata of other professional's Profile page
	@Test(dependsOnMethods={"C_Navigate_To_My_ProfilePage_Verify_MetaDataTags"})
	public void D_Navigate_To_Other_ProfilePage_VerifyMetaDataTags(){
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.username"));
		test.isOtherProfileMetadataOK();
	}
	
	//Logout from the app
	@Test(dependsOnMethods={"D_Navigate_To_Other_ProfilePage_VerifyMetaDataTags"})
	public void E_SignOut(){
		test.signOut();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
