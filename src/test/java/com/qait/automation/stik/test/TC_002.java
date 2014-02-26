package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;


// Combined Review Wizard using existing Stik session . 
// (Verify review appears on Profile Page along with rating)
public class TC_002 {
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
		assert test.launchUrl(test.getYamlVal("appUrl"));
    }

	//Log in using Facebook account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
    public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
		assert test.navigateToHomePage();
    }
	
	//Verify First Name on home page
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
    public void C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App()  {
		assert test.verifyFirstNameIsDisplayedOnHomePage();
    }
	
	//Send Review Using Combined Page
	@Test(dependsOnMethods={"C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App"})
	public void D_Send_Review_Thru_CombinedWizard_Using_Existing_Session()  {
		 test.sendReviewCombinedWizardAndVerifyGivenReviewAppearOnHomePage(test.getYamlVal("otherprofile.username"),test.getYamlVal("otherprofile.reviewComment"), test.getYamlVal("otherprofile.starRating"), true,test.getYamlVal("recommendFriendList.email1"), test.getYamlVal("recommendFriendList.email2"), test.getYamlVal("recommendFriendList.email3"),test.getYamlVal("otherprofile.username"));
	}
		
	//Verify Sort by feature in Profile Page
	@Test(dependsOnMethods={"D_Send_Review_Thru_CombinedWizard_Using_Existing_Session"})
	public void F_Verify_SortBy_NewestFirst_On_Profile_Page(){
		//Date: Newest First
		assert test.verifySortByNewestOnProfilePage();
	}
	
	@Test(dependsOnMethods={"F_Verify_SortBy_NewestFirst_On_Profile_Page"})
	public void G_Verify_SortBy_OldestFirst_On_Profile_Page(){
		//Date: Oldest First
		assert test.verifySortByOldestOnProfilePage();
	}
	
	@Test(dependsOnMethods={"G_Verify_SortBy_OldestFirst_On_Profile_Page"})
	public void H_SignOut(){
		test.signOut();
	}
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
