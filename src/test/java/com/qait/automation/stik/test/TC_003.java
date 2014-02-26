package com.qait.automation.stik.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

//Navigate to Combined Review page: Rate and Add review
//Verify that rating and review text appears on Profile Page.

//Automation of ‘Combined Review Wizard’ without existing Stik session.
public class TC_003 {
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
    
	//Send Review using Combined page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Send_Review_Thru_CombinedWizard_Without_Existing_Session()  {
		 test.sendReviewCombinedWizardAndVerifyGivenReviewAppearOnHomePage(test.getYamlVal("otherprofile.username"),test.getYamlVal("otherprofile.reviewComment"), test.getYamlVal("otherprofile.starRating"), false,test.getYamlVal("recommendFriendList.email1"), test.getYamlVal("recommendFriendList.email2"), test.getYamlVal("recommendFriendList.email3"),test.getYamlVal("otherprofile.username"));
	}
		
	@Test(dependsOnMethods={"B_Send_Review_Thru_CombinedWizard_Without_Existing_Session"})
	public void tearDown(){
		test.signOut();
	}
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
