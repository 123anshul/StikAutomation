package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;


// Verify that proper links appear on profile page if user Does not provide any information while signing up
// Delete information from an existing user's profile to check whether links appear on profile page
public class TC_021 {

	private boolean newUserFlag=false;
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
    public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		assert test.launchUrl(test.getYamlVal("appUrl"));
    }

	//Log in using LinkedIn account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
    public void B_Login_Using_LinkedIn_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"), newUserFlag);
		assert test.navigateToHomePage();
    }
	
	//Verify First Name on home page
	@Test(dependsOnMethods={"B_Login_Using_LinkedIn_Link_Given_On_Home_Page"})
    public void C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App()  {
		assert test.verifyFirstNameIsDisplayedOnHomePage();
    }
	
	@Test(dependsOnMethods={"C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App"})
	public void D_Go_To_Profile_Info_Page_And_Remove_Existing_Details(){
		assert test.navigateToProfileInfoPage();
		assert test.removeProfileDetails();
	}
	
	@Test(dependsOnMethods={"D_Go_To_Profile_Info_Page_And_Remove_Existing_Details"})
	public void E_Navigate_To_Profile_Page_And_Verify_Links(){
		assert test.navigateToMyProfilePage();
		assert test.verifyProfileInfoLinksPresent();
	}
	
	@Test(dependsOnMethods={"E_Navigate_To_Profile_Page_And_Verify_Links"})
	public void F_Verify_Add_Job_Title_Link(){
		test.verifyJobTitleLink();
	}
	
	@Test(dependsOnMethods={"F_Verify_Add_Job_Title_Link"})
	public void G_Verify_Company_Link(){
		test.verifyCompanyLink();
	}
	
	@Test(dependsOnMethods={"G_Verify_Company_Link"})
	public void H_Verify_License_Link(){
		test.verifyLicenseLink();
	}
	
	@Test(dependsOnMethods={"G_Verify_Company_Link"})
	public void H_Verify_Address_Link(){
		test.verifyAddressLink();
	}
	
	@Test(dependsOnMethods={"H_Verify_Address_Link"})
	public void I_Verify_Location_Link(){
		test.verifyLocationLink();
	}

	
//	@Test(dependsOnMethods={"I_Verify_Address_Link"})
//	public void J_Verify_City_Link(){
//		test.verifyCityLink();
//	}
	
	

//	@Test(dependsOnMethods={"J_Verify_City_Link"})
//	public void K_Verify_State_Link(){
//		test.verifyStateLink();
//	}

//	@Test(dependsOnMethods={"K_Verify_State_Link"})
//	public void L_Verify_Zip_Link(){
//		test.verifyZipCodeLink();
//	}

//	@Test(dependsOnMethods={"L_Verify_Zip_Link"})
//	public void M_Verify_Email_User_Link(){
//		test.verifyEmailUserLink();
//	}
	
	@Test(dependsOnMethods={"I_Verify_Location_Link"})
	public void J_Verify_WebSite_Link(){
		test.verifyWebsiteCodeLink();
	}
	
//	@Test(dependsOnMethods={"I_Verify_Location_Link"})
//	public void J_Verify_Edit_Button_For_PhoneNumber(){
//		test.verifyPhoneNumberEditButton();
//	}
	
	@Test(dependsOnMethods={"J_Verify_WebSite_Link"})
	public void K_Update_profile_again(){
		test.navigatetosettingpage();
		assert test.updateProfileInfoPage(newUserFlag);
	}
	
	@Test(dependsOnMethods={"K_Update_profile_again"})
	public void L_Verify_Edit_Button_For_PhoneNumber(){
		test.verifyPhoneNumberEditButton();
	}
	
	@Test(dependsOnMethods={"L_Verify_Edit_Button_For_PhoneNumber"})
	public void M_signOut(){
		test.signOut();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
