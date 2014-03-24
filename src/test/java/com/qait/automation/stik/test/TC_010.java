package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ProfilePageFixture;

//Verify Home Page Footer without existing session on stik.com
public class TC_010 {
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
		assert test.launchUrl(test.getYamlVal("liveUrl"));
    }

	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_verify_Link_Meet_The_Team_Appears_On_Home_Page(){
		test.verifyMeetTheTeamLink();
	}

	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void C_verify_Link_Contact_Us_Appears_On_Home_Page(){
		test.verifyContactUsLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void D_verify_Link_FAQ_Appears_On_Home_Page(){
		test.verifyFAQLink();
	}
		
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void E_verify_Link_FindProfessionalInYourArea_Appears_On_Home_Page(){
		test.verifyFindProfessionalInYourAreaLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void F_verify_Link_RealEstate_Appears_On_Home_Page(){
		test.verifyRealEstateLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void G_verify_Link_Mortgage_Appears_On_Home_Page(){
		test.verifyMortgageLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void H_verify_Link_Insurance_Appears_On_Home_Page(){
		test.verifyInsuranceLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void I_verify_Link_HealthAndWellness_Appears_On_Home_Page(){
		test.verifyHealthAndWellnessLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void J_verify_Link_Lawyers_Appears_On_Home_Page(){
		test.verifyLawyersLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void K_verify_Link_Financial_Planning_Appears_On_Home_Page(){
		test.verifyFinancialPlanningLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void L_verify_Link_Veterinarian_Appears_On_Home_Page(){
		test.verifyVeterinarianLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void M_verify_Link_Photographers_Appears_On_Home_Page(){
		test.verifyPhotographersLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void N_verify_Link_Home_Services_Appears_On_Home_Page(){
		test.verifyHomeServicesLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void O_verify_Link_Find_Professional_By_Last_Name(){
		test.verifyFindProfessionalByLastNameLink();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void P_verify_Link_Login_At_Footer_Appears_On_Home_Page(){
		test.verifyLoginLinkAtFooter();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void Q_verify_Link_Press_At_Footer_Appears_On_Home_Page(){
		test.verifyPressLinkAtFooter();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void R_verify_Link_Carrers_At_Footer_Appears_On_Home_Page(){
		test.verifyCareersLinkAtFooter();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void S_verify_Link_Partner_At_Footer_Appears_On_Home_Page(){
		test.verifyPartnerLinkAtFooter();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void T_verify_Link_Privacy_At_Footer_Appears_On_Home_Page(){
		test.verifyPrivacyLinkAtFooter();
	}
	
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void U_verify_Link_Terms_At_Footer_Appears_On_Home_Page(){
		test.verifyTermsLinkAtFooter();
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
