package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;


//Verify Meta-data on Combined Review Page
public class TC_005 {
	private boolean newUserFlag= false;
	SearchPageFixture test = new SearchPageFixture();
	
	@BeforeClass
	@Parameters({ "filepath" })
	public void beforeClass(@Optional("")String filePath){
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
	
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Navigate_To_Others_CombinedReviewPage_VerifyMetaDataTags(){
		assert test.navigateToCombinedReviewPage(test.getYamlVal("otherprofile.username"));
		test.isOtherProfileMetadataOK();
	}
	
	@Test(dependsOnMethods={"C_Navigate_To_Others_CombinedReviewPage_VerifyMetaDataTags"})
	public void D_SignOut(){
		test.signOut();
	}
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
