package com.qait.automation.stik.test;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.OnYourWebsiteFixture;

//Verify the content of IFrame on http://www.stik.com/zf/widget/builder
public class TC_017 {

	private boolean newUserFlag= false;
	OnYourWebsiteFixture test = new OnYourWebsiteFixture();
	
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
    }
  	
  	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
  	public void C_Select_On_Your_Website_From_DropDown_And_Check_WidgetStyles(){
  		assert test.clickYourOptionUnderShowcaseReviews("On my website");
  		//test.verifySplashSectionText();
  		assert test.areWidgetStyleOptionsPresent();
  	}

  	@Test(dependsOnMethods={"C_Select_On_Your_Website_From_DropDown_And_Check_WidgetStyles"})
  	public void D_Verify_iFrame_Content_On_Your_Website_Page(){
  		assert test.checkiFramePresentOrNot();
  		test.verifyContentWithinIframeHeader();
  		test.fillDetailsInCustomizeYourWidgetForm();
  		test.verifyWhetherIframeFooterPresentOrNot();
  		test.embedYourWidgetSection();
  		
  	}
  	@Test(dependsOnMethods={"D_Verify_iFrame_Content_On_Your_Website_Page"})
  	public void E_matchIFrameDetailsWithProfileDetails(){
  		test.matchIFrameDetailsWithProfileDetails();
  	}
  	
  	 	
	@Test(dependsOnMethods={"E_matchIFrameDetailsWithProfileDetails"})
	public void F_signOut(){
		test.signOut();
	}
	
//	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
