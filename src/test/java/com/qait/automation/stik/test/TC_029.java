package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.qait.automation.stik.actionfixtures.UserHomePageFixture;

//Verify complete UI and features on existing user's home page after log in
public class TC_029 {
	private boolean newUserFlag= false;
	UserHomePageFixture test = new UserHomePageFixture();
		
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
	  	public void C_Verify_Home_Page_Loads_With_All_Sections(){
	  		assert test.verifyHomePageLoads();
	  
	  	}
	  	
	  	@Test(dependsOnMethods="C_Verify_Home_Page_Loads_With_All_Sections")
	  	public void D_Verify_Client_Panel_Section(){
	  		assert test.verifyClientPanelSection(test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.profileURL"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.referralPage"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.onMyWebsiteURL"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.inMyEmailURL"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.onFacebookPage"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.onFacebookProfile"));
	  	}
	  	
		@Test(dependsOnMethods={"D_Verify_Client_Panel_Section"})
		public void E_Verify_LeaderBoard_Section(){
			test.verifyLeaderBoardSection(test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.getMoreReviewsURL"), test.getYamlVal("userHomePage.shareText"), test.getYamlVal("userHomePage.userName"));
		}
	
		@Test(dependsOnMethods={"E_Verify_LeaderBoard_Section"})
		public void F_Verify_Facebook_Google_Linkedin_Share_Profile_Section(){
			test.verifyFacebookGoogleLinkeinShareProfileSection();
		}
		
		@Test(dependsOnMethods={"F_Verify_Facebook_Google_Linkedin_Share_Profile_Section"})
		public void G_Verify_Facebook_Google_Linkedin_Boost_Profile_Section(){
			test.verifyFacebookGoogleLinkeinBoostProfileSection();
		}
	  	
		@Test(dependsOnMethods={"G_Verify_Facebook_Google_Linkedin_Boost_Profile_Section"})
		public void H_Verify_LatestReviews_Section(){
			test.verifyLatestReviewsSection(test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.profileURL"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.getMoreReviewsURL"));
		}
		
		@Test(dependsOnMethods={"H_Verify_LatestReviews_Section"})
		public void I_Verify_CompleteProfile_And_UnlockPotential_Sections(){
			test.verifyCompleteProfileAndUnlocklPotentialSections(test.getYamlVal("userHomePage.callMeNumber"), test.getYamlVal("appUrl")+test.getYamlVal("userHomePage.completeProfileURL"), test.getYamlVal("userHomePage.callUsNumber"));
		}
		
		@Test(dependsOnMethods={"I_Verify_CompleteProfile_And_UnlockPotential_Sections"})
		public void J_signOut(){
			test.signOut();
		}
		//Close Browser
		@AfterClass
		public void afterClass() {
			test.deleteUserOnFacebook();
			test.closeBrowser();
		}
}
