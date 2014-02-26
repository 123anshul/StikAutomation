package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

/**
 * <b>Class: TestCase009</b>
 * <p>
 * TestCase006 Basic login from home page and verify Review count on MyProfile and OthersProfile.
 * @author      QAIT
 */

//Basic login from home page and verify Review count on MyProfile and OthersProfile
public class TC_006 {
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
	
	// Naviagte to MyProfile and verify review Count
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void C_Navigate_To_MyProfile_And_Verify_Review_Count()  {
		assert test.navigateToMyProfilePage();
		assert test.verifyReviewCount();
    }
	
	// Naviagte to OtherProfile and verify review Count
	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	public void D_Navigate_To_OthersProfile_And_Verify_Review_Count()  {
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.username"));
		assert test.verifyReviewCount();
	}
	
	@Test(dependsOnMethods={"D_Navigate_To_OthersProfile_And_Verify_Review_Count"})
	public void E_SignOut(){
		test.signOut();
	}
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
