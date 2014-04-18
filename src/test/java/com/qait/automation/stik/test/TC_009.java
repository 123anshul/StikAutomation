package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ProfilePageFixture;

//Verify Home Page Header without existing session
public class TC_009 {

	ProfilePageFixture test = new ProfilePageFixture();

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
		assert test.launchUrl(test.getYamlVal("appUrl"));
	}

	//Verify the home page title
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_verify_Title_On_Home_Page(){
		test.verifyHomePageTitle("Reviews for Mortgage, Insurance, Real Estate, and Legal Professionals | Stik.com");
	}

	//Verify Stik logo appears on Home page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void C_verify_Stik_Logo_Appears_On_Home_Page(){
		test.verifyStikLogoOnHomePage();
	}

	//Verify the presence of "For bUsiness" link on Home page and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void D_verify_For_Business_On_Home_Page(){
		test.verifyLinkForBusinessOnHomePage();
	}

	//Verify the presence of "Find a Professional" link on Home page and click it
	@Test(dependsOnMethods="A_launch_URL_Navgiate_to_Stick_HomePage")
	public void E_verify_Find_Professional_Appears_On_Home_Page(){
		test.verifyLinkFindProfessionalOnHomePage();
	}

	//Verify Login button appears on Home page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void F_verify_Login_link_Appears_On_Home_Page(){
		test.verifyLoginLinkAppearsOnHomePage();
	}

	//Verify presence of different UI elements on Home page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void G_verify_BasicUI_Element_Appears_On_Home_Page(){
		test.verifyBasicUIElemetsOnHomePage();
	}

	//Verify the presence of "Request A Demo" button on Home page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void H_verify_Request_Demo_Button_Appears_On_Home_Page(){
		test.verifyRequestDemoLinkAppearsOnHomePage();
	}

	//Close Browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
