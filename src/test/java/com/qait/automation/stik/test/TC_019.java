package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.OnYourFacebookProfileFixture;

//Verify that reviews can be posted to facebook on http://www.stik.com/zf/facebook/add-collection
public class TC_019 {
	private boolean newUserFlag= false;
OnYourFacebookProfileFixture test=new OnYourFacebookProfileFixture();
	
	
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
  	public void C_Select_On_Your_Facebook_Profile_From_DropDown(){
  		assert test.clickYourOptionUnderShowcaseReviews("On my Facebook profile");
  		
  	}
  	
  	@Test(dependsOnMethods={"C_Select_On_Your_Facebook_Profile_From_DropDown"})
  	public void D_Get_Started_ConnectToFacebook(){
  		test.verifySplashTextonFacebookProfilePage();
  		assert test.isGetStartedButtonPresentOnProfilePage();
  		assert test.isDoneMessageDisplayedOnClickingGetStarted();
  		test.isAddToProfileTabAndContentVisible();
  	}
  	
  	@Test(dependsOnMethods={"D_Get_Started_ConnectToFacebook"})
  	public void E_Check_Add_To_Profile_Link_On_Facebook_Page(){
  		assert test.checkForAddToProfileLinkOnFacebookProfilePage();
  	}
  	
  	@Test(dependsOnMethods={"E_Check_Add_To_Profile_Link_On_Facebook_Page"})
	public void F_signOut(){
		test.signOut();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
  	
}
