 package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ShowCaseEmailFixture;

//Verify that the "preview" contains emails on http://www.stik.com/zf/widget/builder
public class TC_016 {

	private boolean newUserFlag= false;
	ShowCaseEmailFixture test = new ShowCaseEmailFixture();
	
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
  	public void C_Select_In_Your_Email_From_DropDown_And_Get_Started(){
  		assert test.clickYourOptionUnderShowcaseReviews("In my email");
  		test.verifySplashSectionOnEmailPage();
  		assert test.clickGetStartedButtonOnEmailPreviewPage();
  		
  	}
  	@Test(dependsOnMethods={"C_Select_In_Your_Email_From_DropDown_And_Get_Started"})
  	public void D_Verify_Complete_Email_Preview_Content_After_Selecting_Reviews(){
  		test.verifyEmailPreviewPresentAndClickSelectReviewButton();
  		test.verifyEmailPreviewIsOk();
  	}
  	
  	 	
  	@Test(dependsOnMethods={"D_Verify_Complete_Email_Preview_Content_After_Selecting_Reviews"})
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
