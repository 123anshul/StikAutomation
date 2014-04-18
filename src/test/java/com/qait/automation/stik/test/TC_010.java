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

	//Verify the presence "Meet the Team" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_verify_Link_Meet_The_Team_Appears_On_Home_Page(){
		test.verifyMeetTheTeamLink();
	}

	//Verify the presence "Contact Us" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void C_verify_Link_Contact_Us_Appears_On_Home_Page(){
		test.verifyContactUsLink();
	}
	
	//Verify the presence "FAQ" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void D_verify_Link_FAQ_Appears_On_Home_Page(){
		test.verifyFAQLink();
	}
	
	//Verify the presence "Find a Professional In Your Area" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void E_verify_Link_FindProfessionalInYourArea_Appears_On_Home_Page(){
		test.verifyFindProfessionalInYourAreaLink();
	}
	
	//Verify the presence "Real Estate" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void F_verify_Link_RealEstate_Appears_On_Home_Page(){
		test.verifyRealEstateLink();
	}
	
	//Verify the presence "Mortgage" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void G_verify_Link_Mortgage_Appears_On_Home_Page(){
		test.verifyMortgageLink();
	}
	
	//Verify the presence "Insurance" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void H_verify_Link_Insurance_Appears_On_Home_Page(){
		test.verifyInsuranceLink();
	}
	
	//Verify the presence "Health And Wellness" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void I_verify_Link_HealthAndWellness_Appears_On_Home_Page(){
		test.verifyHealthAndWellnessLink();
	}
	
	//Verify the presence "Lawyers" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void J_verify_Link_Lawyers_Appears_On_Home_Page(){
		test.verifyLawyersLink();
	}
	
	//Verify the presence "Financial Planning" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void K_verify_Link_Financial_Planning_Appears_On_Home_Page(){
		test.verifyFinancialPlanningLink();
	}
	
	//Verify the presence "Veterinarian" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void L_verify_Link_Veterinarian_Appears_On_Home_Page(){
		test.verifyVeterinarianLink();
	}
	
	//Verify the presence "Photographers" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void M_verify_Link_Photographers_Appears_On_Home_Page(){
		test.verifyPhotographersLink();
	}
	
	//Verify the presence "Home Services" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void N_verify_Link_Home_Services_Appears_On_Home_Page(){
		test.verifyHomeServicesLink();
	}
	
	//Verify the presence "Find Professional By Last Name" link and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void O_verify_Link_Find_Professional_By_Last_Name(){
		test.verifyFindProfessionalByLastNameLink();
	}
	
	//Verify the presence "Login" link in footer
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void P_verify_Link_Login_At_Footer_Appears_On_Home_Page(){
		test.verifyLoginLinkAtFooter();
	}
	
	//Verify the presence "Press" link in footer and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void Q_verify_Link_Press_At_Footer_Appears_On_Home_Page(){
		test.verifyPressLinkAtFooter();
	}
	
	//Verify the presence "Careers" link in footer and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void R_verify_Link_Carrers_At_Footer_Appears_On_Home_Page(){
		test.verifyCareersLinkAtFooter();
	}
	
	//Verify the presence "Careers" Partner in footer and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void S_verify_Link_Partner_At_Footer_Appears_On_Home_Page(){
		test.verifyPartnerLinkAtFooter();
	}
	
	//Verify the presence "Privacy" Partner in footer and click it
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void T_verify_Link_Privacy_At_Footer_Appears_On_Home_Page(){
		test.verifyPrivacyLinkAtFooter();
	}
	
	//Verify the presence "Terms" Partner in footer and click it
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
