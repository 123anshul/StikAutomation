package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.BusinessInfoFixture;

// Login through Facebook and Fill Information on Business Page
public class TC_020 {

	private boolean newUserFlag= false;
	BusinessInfoFixture test = new BusinessInfoFixture();
	
	
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
	public void D_NavigateTo_Business_Info_Page(){
		assert test.navigateToProfileInfoPage();
		assert test.clickBusinessInfoTag();
		
	}
	
	@Test(dependsOnMethods={"D_NavigateTo_Business_Info_Page"})
	public void E_Check_PresenceOf_Business_Info_Fields(){
		test.isCompleteBusinessInfoFieldsPresent();
	}
	
	@Test(dependsOnMethods={"E_Check_PresenceOf_Business_Info_Fields"})
	public void F_Update_Information_On_Business_Info_Page(){
		assert test.selectIndustry();
		assert test.selectMultipleStates();
		assert test.clickAddAnotherAndVerifyStateIncrement();
		assert test.selectCity();
		assert test.enterSummary(test.getYamlVal("businessSummary"));
		assert test.clickSaveButton();
	}
	
	@Test(dependsOnMethods={"F_Update_Information_On_Business_Info_Page"})
	public void G_Verify_Updated_Info_On_Profile_Page(){
		assert test.veirfyAboutSectionContainsSummary();
	}
	
	@Test(dependsOnMethods={"G_Verify_Updated_Info_On_Profile_Page"})
	public void H_signOut(){
		test.signOut();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
	
}
