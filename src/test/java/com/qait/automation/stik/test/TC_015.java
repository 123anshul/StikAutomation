package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.ClientsPageFixture;


//Clients page : Import using Gmail account
public class TC_015 {

	private boolean newUserFlag= true;
	ClientsPageFixture test = new ClientsPageFixture();
	
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
  		test.launchUrl(test.getYamlVal("appUrl"));
      }
	
  	//Log in using Facebook account
  	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
      public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
 		assert test.signUpWithFacebook(test.getYamlVal("signup.name"),test.getYamlVal("signup.email"),test.getYamlVal("signup.importerEmail"));
  		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName"), test.getYamlVal("password"),newUserFlag);
  		
      }
  	
   // Navigate to the Professional Mail page
  	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
    public void C_Navigate_To_Client_Mail_Page(){
  		assert test.navigateToClientsMailPage();
  	}
  	
  	@Test(dependsOnMethods={"C_Navigate_To_Client_Mail_Page"})
  	public void D_Verify_Gmail_Import(){
  		assert test.clickGmailButton();
  		assert test.verifyGmailImport();
  	}
  	
  	@Test(dependsOnMethods={"D_Verify_Gmail_Import"})
	public void D_signOut(){
  		test.navigateToHomePage();
		test.signOut();
	}
  	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
