package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DemoPageFixture;

//Verify functionality on /demo/connect page
public class TC_035 {

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
		test.launchUrl(test.getYamlVal("appUrl")+ test.getYamlVal("demoPageConnect.url"));
	}
	
	//Verify UI on /demo/connect page and filling details for requesting a demo
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_verify_BasicUI_Functionality_Of_DemoConnect_Page(){
		test.verifyBasicUIandFunctionalityForDemoTab();
	}

	//Close the browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
