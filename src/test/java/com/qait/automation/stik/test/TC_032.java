package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.CompanyPageFixture;

// Click Meet the team link on home page and verify the company page that follows

public class TC_032 {

	CompanyPageFixture test=new CompanyPageFixture();
	private boolean newUserFlag= false;

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
		test.launchUrl(test.getYamlVal("liveUrl"));
	}

	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_click_On_Meet_The_Team_Link(){
		test.verifyMeetTheTeamLink();
	}
	
	@Test(dependsOnMethods={"B_click_On_Meet_The_Team_Link"})
	public void C_verify_Stik_Employee_Page(){
		test.verifyStikCoverImage();
		test.verifyStikEmployeePage();
		test.verifyEmployeeProfile();
		
	}
	
	@Test(dependsOnMethods={"C_verify_Stik_Employee_Page"})
	public void D_verify_Contact(){
		test.verifyContactNumber(test.getYamlVal("companyPage.contactNumber"));
		test.verifyCompanyWebsitelink();
	}

	@Test(dependsOnMethods={"D_verify_Contact"})
	public void E_verify_Company_Select_Dropdown(){
		test.verifyCompanySelectDropDown();
	}
	
	@Test(dependsOnMethods={"E_verify_Company_Select_Dropdown"})
	public void F_verify_State_Select_Dropdown(){
		assert test.verifyStateSelectDropDown();
	}
	
	@Test(dependsOnMethods={"F_verify_State_Select_Dropdown"})
	public void G_verify_City_Select_Dropdown(){
		assert test.verifyCitySelectDropDown();
	}

//	@AfterClass
//	public void afterClass() {
//		test.closeBrowser();
//	}
	
}
