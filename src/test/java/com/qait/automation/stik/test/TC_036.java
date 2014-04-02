package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DemoPageFixture;

//Verify the UI and basic functionality on /demo page

public class TC_036 {
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
	
	//Verify UI and functionality of demo tab
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_verify_BasicUI_Functionality_For_DemoTab_On_Demo_Page(){
		test.verifyBasicUIandFunctionalityForDemoTab();
	}
	
	//Verify UI of Gallery tab
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void C_verify_Gallery_Tab_On_Demo_Page(){
		test.verifyGalleryTabonDemoPage();
	}
	
	//Verify UI and functionality of ROI tab
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void D_verify_ROI_Tab_On_Demo_Page(){
		test.verifyROITabOnDemoPage();
	}
	
	//Verify UI of Pricing tab
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void E_verify_Pricing_Tab_On_Demo_Page(){
		test.verifyPricingTabOnDemoPage();
	}
	
	//Close the browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}

}
