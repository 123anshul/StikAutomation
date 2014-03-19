package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.OnYourFacebookPageFixture;

//Verify that a Facebook tab can be successfully installed to a Page       
public class TC_018 {

	private boolean newUserFlag= false;
OnYourFacebookPageFixture test = new OnYourFacebookPageFixture();

	@BeforeClass
    @Parameters({ "filepath" })
    public void beforeClass(@Optional("data/qatestdata.yml")String filePath){
        test.setUpDataFile(filePath);
    }
    
    @Test
    @Parameters({"BROWSER"})
    public void setup(@Optional("")String browser) {
    	if(newUserFlag) {assert test.createUsersOnFacebook(test.getYamlVal("appUrl"));}
        test.startBrowser(browser);
    }
    
    //Launch Stick URL
  	@Test(dependsOnMethods={"setup"})
      public void A_launch_URL_Navgiate_to_Stick_HomePage() {
  		test.launchUrl(test.getYamlVal("appUrl"));
      }
  	
  	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
    public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
		assert test.clickLoginLink();
		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
		assert test.navigateToHomePage();
    }
  	
  	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
  	public void C_Select_On_Your_Facebook_Page_From_DropDown(){
  	//	assert test.clickYourOptionUnderShowcaseReviews("On my Facebook page");
  		assert test.clickOnYourFacebookPageShowcaseOptionUnderProfileDropdown();
  	}
  	
  	@Test(dependsOnMethods={"C_Select_On_Your_Facebook_Page_From_DropDown"})
  	public void D_Get_StartedOnFacebook_Page_And_Select_Facebook_Page(){
  		test.verifySplashTextOnFacebookPage();
  		assert test.isGetStartedButtonPresent();
  		assert test.clickFGetStartedButtonAndVerifyMessages();
  	}
  	

	@Test(dependsOnMethods={"D_Get_StartedOnFacebook_Page_And_Select_Facebook_Page"})
	public void E_signOut(){
		test.signOut();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
