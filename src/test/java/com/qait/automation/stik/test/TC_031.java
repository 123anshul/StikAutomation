package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.qait.automation.stik.actionfixtures.FeaturesPageFixture;

// Verify the content and functionality on /features pages- Why Stik, Reviews, Referrals and Stand Out Online 
public class TC_031 {
	
	private boolean newUserFlag= false;
	FeaturesPageFixture test=new FeaturesPageFixture();
		
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
	      public void B_Navgiate_to_Feature_Page() {
	  		assert test.navigateToFeaturesPage();
	  		assert test.verifyFeaturePageLoads(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.whyStikURL"), test.getYamlVal("featuresPage.tab1"));
	    }
	  	
	  	@Test(dependsOnMethods={"B_Navgiate_to_Feature_Page"})
	  	public void C_Verify_Why_Stik_Section(){
	  		assert test.verifyWhyStikSection(test.getYamlVal("featuresPage.tab2"), test.getYamlVal("featuresPage.tab3"), test.getYamlVal("featuresPage.tab4"), test.getYamlVal("featuresPage.tab5"),test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.reviewsURL"), test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.referralURL"), test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.standoutURL"), test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.getStartedURL"));
	  	}
	  	
	  	@Test(dependsOnMethods={"C_Verify_Why_Stik_Section"})
	  	public void D_Verify_Reviews_Section(){
	  		assert test.verifyReviewsSection(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.getStartedURL"));
	  	}
	  	
	  	@Test(dependsOnMethods={"D_Verify_Reviews_Section"})
	  	public void E_Verify_Referral_Section(){
	  		assert test.verifyReferralSection(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.getStartedURL"));
	  	}
	  	
	  	@Test(dependsOnMethods={"E_Verify_Referral_Section"})
	  	public void F_Verify_Stand_Out_Online_Section(){
	  		assert test.verifyStandOutOnlineSection(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.getStartedURL"));
	  	}
	  	
		@Test(dependsOnMethods={"F_Verify_Stand_Out_Online_Section"})
	  	public void G_Verify_ROI_Section(){
	  		assert test.checkROISection(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.roiURL"));
	  	}
	  	
	  	@Test(dependsOnMethods={"G_Verify_ROI_Section"})
	  	public void H_Verify_Ui_Footer_Section(){
	  		assert test.checkFooter(test.getYamlVal("appUrl")+test.getYamlVal("featuresPage.getStartedURL"));
	  	}
	  	
	  	
		//Close Browser
		@AfterClass
		public void afterClass() {
			test.deleteUserOnFacebook();
			test.closeBrowser();
		}

}
