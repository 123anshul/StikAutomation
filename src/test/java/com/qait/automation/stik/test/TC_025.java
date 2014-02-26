package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SignUpFixture;

// Professional Sign Up process through LinkedIn using existing LinkedIn account on stik
public class TC_025 {

	private boolean newUserFlag=false;
	SignUpFixture test=new SignUpFixture();
	
	@BeforeClass
    @Parameters({ "filepath" })
    public void beforeClass(@Optional("")String filePath){
        test.setUpDataFile(filePath);
    }
    
    @Test
    @Parameters({"BROWSER"})
    public void setup(@Optional("")String browser) {
    	if(newUserFlag) {assert test.createUsersOnFacebook(test.getYamlVal("appUrl"));}
       assert test.startBrowserWithProxyForLinkedinTestCase(browser);
       //assert test.startBrowser(browser);
    }
	
	//Launch Stick URL
	@Test(dependsOnMethods={"setup"})
    public void A_launch_URL_Navgiate_to_Stick_HomePage() {
		assert test.launchUrl(test.getYamlVal("appUrl"));
    }
	
	//Log in using Facebook account
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	 public void B_Sign_Up_Using_With_LinkedIn_Using_Link_On_Professional_Sign_Up_Page()  {
		assert test.signUpWithLinkedIn(test.getYamlVal("signup.name"),test.getYamlVal("signup.email"),test.getYamlVal("signup.importerEmail"));
		assert test.loginusingLinkedInUserNamePassword(test.getYamlVal("userNameLinkedIn"), test.getYamlVal("passwordLinkedIn"));
	}
	
	@Test(dependsOnMethods={"B_Sign_Up_Using_With_LinkedIn_Using_Link_On_Professional_Sign_Up_Page"})
	public void C_Navigate_To_Mail_Panel(){
		assert test.clickContinueOnLinkedInPanel();
		assert test.clickContinueOnFBPanel();
			
	}
		
	@Test(dependsOnMethods={"C_Navigate_To_Mail_Panel"})
	public void D_Import_Email_Contact(){
		assert test.importIndividualEmailContactOnMailPanel(test.getYamlVal("importEmailId"), test.getYamlVal("importFirstName"), test.getYamlVal("importLastName"));
	}
	
	@Test(dependsOnMethods={"D_Import_Email_Contact"})
	public void E_Click_Continue_And_Handle_Modal_Dailog_to_Send_Message(){
		assert test.clickContinueOnMailPanel();
		test.handleModalDialogForMessage(test.getYamlVal("messageForCollectingReview"));
	}
		
	@Test(dependsOnMethods={"E_Click_Continue_And_Handle_Modal_Dailog_to_Send_Message"})
	public void F_Select_Industry_PhoneNumber_ZipCode_And_Click_Create_Profile(){
		assert test.handleProfileInfoSection(test.getYamlVal("signup.phoneNo"), test.getYamlVal("signup.zipcode"));
		assert test.verifyUserIsOnProfilePage();
	}
		
	@Test(dependsOnMethods={"F_Select_Industry_PhoneNumber_ZipCode_And_Click_Create_Profile"})
	public void G_signOut(){
		test.signOut();
	}
		
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}

}
