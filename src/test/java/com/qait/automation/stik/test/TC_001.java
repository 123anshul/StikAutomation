
package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qait.automation.stik.actionfixtures.SearchPageFixture;

/**
 * <b>Class: TestCase001</b>
 * <p>
 * TestCase001 Basic login from home page and account update verification.
 * @author      QAIT
 */

//Basic login from homepage www.knewdeal.com and account update verification
public class TC_001 {
	private static boolean newUserFlag= false;
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
	
	//Navigate to Profile Info Page. 
	@Test(dependsOnMethods={"C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App"})
	public void D_Navigate_To_Profile_Info_Page_Verify_Profile_Info_Page()  {
		assert test.navigateToProfileInfoPage();
    }
	
	//Verify is My Profile Info Pag
	@Test(dependsOnMethods={"D_Navigate_To_Profile_Info_Page_Verify_Profile_Info_Page"})
	public void E_Is_My_Profile_Info_Page_Ok()  {
		test.isMyProfileInfoPageOk();
    }
	
	
	//Update First Name and Last Name On Profile Info page
	@Test(dependsOnMethods={"E_Is_My_Profile_Info_Page_Ok"})
	public void F_Update_Account_Info_Verify_Info_Gets_Updated_On_Profile_Page()  {
		assert test.updateProfileInfoPage(newUserFlag);
		assert test.verifyFirstNameLastNameGetsUpdatedOnProfilePage();
    }
	
	//Verify that profile contains various text fields
	@Test(dependsOnMethods={"F_Update_Account_Info_Verify_Info_Gets_Updated_On_Profile_Page"})
	public void G_Is_My_Profile_Ok()  {
		test.isMyProfileOk();
    }
	
	@Test(dependsOnMethods={"G_Is_My_Profile_Ok"})
	public void H_signOut(){
		test.signOut();
	}
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
