package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DemoPageFixture;

// Verify the complete content and functionality on URL:- www.knewdeal.com/demo
public class TC_028 {

	private boolean newUserFlag= false;
	DemoPageFixture test=new DemoPageFixture();
		
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
	  		test.launchUrl(test.getYamlVal("appUrl")+ test.getYamlVal("demoPage.url"));
	      }
	  	
	  	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	  	public void B_Verify_Demo_SubSection_Under_Splash_Section(){
	  		assert test.verifySplashSection(test.getYamlVal("demoPage.splashSectionText"));
	  		assert test.verifyJoinDemoFunctionality();
	 
	  	}
	  	
	  	@Test(dependsOnMethods="B_Verify_Demo_SubSection_Under_Splash_Section")
	  	public void C_Verify_Get_Reviews_Section(){
	  		assert test.verifyGetReviewsSectionWithAllTheTabs();
	  	}
	  	
//	  	@Test(dependsOnMethods="C_Verify_Get_Reviews_Section")
//	  	public void D_Verify_Get_Refferal_Section(){
//	  		 test.checkWheelMovementAndVerifyReferralSection(test.getYamlVal("demoPage.referralText.step1"), test.getYamlVal("demoPage.referralText.step2"), test.getYamlVal("demoPage.referralText.step3"));
//	  	}
	  	
	  	@Test(dependsOnMethods="C_Verify_Get_Reviews_Section")
	  	public void E_Verify_Stay_Safe_Section(){
	  		 test.verifyStaySafeSection(test.getYamlVal("appUrl")+ test.getYamlVal("demoPage.staySafeImage"));
	  	}
	  	
	  	@Test(dependsOnMethods="E_Verify_Stay_Safe_Section")
	  	public void F_Verify_Stik_Premium_Section(){
	  		 test.verifyStikPremiumSection(test.getYamlVal("demoPage.stikPremiumText"));
	  	}
	  	
	  	@Test(dependsOnMethods="F_Verify_Stik_Premium_Section")
	  	public void G_Verify_Company_Page_Section(){
	  		 test.verifyCompanyPageSection(test.getYamlVal("appUrl")+ test.getYamlVal("demoPage.companyPageImage"));
	  	}
	  	
	  	@Test(dependsOnMethods="G_Verify_Company_Page_Section")
	  	public void H_Verify_SeePlansAndPricing_Button(){
	  		 test.checkPlanningButton(test.getYamlVal("appUrl")+ test.getYamlVal("menuPage.url"));
	  	}
	  	

		//Close Browser
		@AfterClass
		public void afterClass() {
			test.deleteUserOnFacebook();
			test.closeBrowser();
		}
}
