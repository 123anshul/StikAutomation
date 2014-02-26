package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DirectoryPageFixture_Temp;


public class TC_DirectoryTemp {
	private boolean newUserFlag= false;
	DirectoryPageFixture_Temp test = new DirectoryPageFixture_Temp();

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
	public void A_launch_URL_Navgiate_to_Directory() {
		assert test.launchUrl(test.getYamlVal("liveUrl"));
		test.navigateToDirectory();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Directory"})
	public void B_verify_DirectoryURL_BasicElements() {
		assert test.verifyDirectoryURL();
		assert test.verifySearchFormOnDirectory();
		assert test.verifyPopularIndustriesHeading();
	} 
	
	@Test(dependsOnMethods={"B_verify_DirectoryURL_BasicElements"})
	public void C_verify_InsuranceIndustriesList(){
		assert test.searchInsuranceIndustries();
	}
	
	@Test(dependsOnMethods={"C_verify_InsuranceIndustriesList"})
	public void D_verify_RealtorsIndustriesList(){
		assert test.searchRealtorsIndustries();
	}
	
	@Test(dependsOnMethods={"D_verify_RealtorsIndustriesList"})
	public void E_verify_AutoProfessionalIndustriesList(){
		assert test.searchAutoProfessionalIndustries();
	}
	
	@Test(dependsOnMethods={"E_verify_AutoProfessionalIndustriesList"})
	public void F_verify_HomeContractorsIndustriesList(){
		assert test.searchHomeContractorsIndustries();
	}
	
	@Test(dependsOnMethods={"F_verify_HomeContractorsIndustriesList"})
	public void G_verify_HealthCareIndustriesList(){
		assert test.searchHealthCareIndustries();
	}
	
	@Test(dependsOnMethods={"G_verify_HealthCareIndustriesList"})
	public void H_verify_ArtistsIndustriesList(){
		assert test.searchArtistsIndustries();
	}
	
	@Test(dependsOnMethods={"H_verify_ArtistsIndustriesList"})
	public void I_verify_OtherIndustriesList(){
		assert test.searchOtherIndustries();
	}
	
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
