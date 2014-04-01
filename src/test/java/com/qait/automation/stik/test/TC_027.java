package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ShowCaseEmailFixture;

//Verify Referral Collection Workflow on URL:- http://www.knewdeal.com/refer/automationone.automationone?rev_id=16299938  
public class TC_027 {

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
	  	public void C_Navigate_To_Referral_Collection_URL(){
	  		assert test.navigateToReferralCollectionPage(test.getYamlVal("referURL"));
	  
	  	}
	  	
	  	@Test(dependsOnMethods="C_Navigate_To_Referral_Collection_URL")
	  	public void D_Verify_Referral_Collection_Workflow(){
	  		assert test.verifyReferralCollectionProcess(test.getYamlVal("recommendFriendList.email1"), test.getYamlVal("recommendFriendList.email2"), test.getYamlVal("recommendFriendList.email3"));
	  	}
  	
//		@Test(dependsOnMethods={"D_Verify_Referral_Collection_Workflow"})
//		public void E_signOut(){
//			test.signOut();
//		}
	  	
		//Close Browser
		@AfterClass
		public void afterClass() {
			test.deleteUserOnFacebook();
			test.closeBrowser();
		}
}
