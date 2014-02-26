package com.qait.automation.stik.test;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.EnterprisePageFixture;

public class TC_034 {
	EnterprisePageFixture test=new EnterprisePageFixture();

	@BeforeClass
	@Parameters({ "filepath" })
	public void beforeClass(@Optional("data/qatestdata.yml")String filePath){
		test.setUpDataFile(filePath);
	}

	@Test
	@Parameters({"BROWSER"})
	public void setup(@Optional("")String browser) {
		assert test.startBrowser(browser);
	}

	//Launch Stick URL
	@Test(dependsOnMethods={"setup"})
	public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		test.launchUrl(test.getYamlVal("appUrl"));
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_navgiate_to_Enterprise_Page() {
		test.navigateToEnterprisePage();
	}
	
	@Test(dependsOnMethods={"B_navgiate_to_Enterprise_Page"})
	public void C_verify_Enterprise_Page(){
		test.verifyEnterprisePage(test.getYamlVal("appUrl")+test.getYamlVal("enterprisePage.enterpriseURL"), test.getYamlVal("enterprisePage.tab1"));
	}
	
	@Test(dependsOnMethods={"C_verify_Enterprise_Page"})
	public void D_verify_Overview_Tab(){
		test.verifyOverviewTab(test.getYamlVal("enterprisePage.getReviewText"),test.getYamlVal("enterprisePage.websiteModalText"),test.getYamlVal("enterprisePage.reviewMarketingText"),test.getYamlVal("enterprisePage.reviewMarketingText"),test.getYamlVal("enterprisePage.getReferralText"));
	}
	
	@Test(dependsOnMethods={"C_verify_Enterprise_Page"})
	public void E_verify_Roi_Tab(){
		test.navigateToRoiTab(test.getYamlVal("enterprisePage.roiTabUrl"),test.getYamlVal("enterprisePage.roiPageText"),test.getYamlVal("enterprisePage.tab2"));
		test.verifyRoiTab(test.getYamlVal("enterprisePage.roiMarketingLiftText"),test.getYamlVal("enterprisePage.roiSalesLiftText"),test.getYamlVal("enterprisePage.roiReferralsLiftText"),test.getYamlVal("enterprisePage.referralsCalculatorText"),test.getYamlVal("enterprisePage.noOfCustomers"));
	}
	
	@Test()
	public void F_verify_Features_Tab(){
		test.navigateToFeaturesTab(test.getYamlVal("enterprisePage.featureTabUrl"), test.getYamlVal("enterprisePage.featureTabText"), test.getYamlVal("enterprisePage.featurePageText"));
		test.verifyFeaturesTab(test.getYamlVal("enterprisePage.noSoftwareText"), test.getYamlVal("enterprisePage.reviewManageText"), test.getYamlVal("enterprisePage.headerText"), test.getYamlVal("enterprisePage"), test.getYamlVal("enterprisePage.rightText"));
		
	}
	
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
	
}
