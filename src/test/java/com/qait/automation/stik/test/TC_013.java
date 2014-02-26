package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

//Search with existing session on Stik.com
public class TC_013 {
	private boolean newUserFlag= false;
	SearchPageFixture test = new SearchPageFixture();
	
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
	
  	//Log in using Facebook account
  	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
      public void B_Login_Using_FaceBook_Link_Given_On_Home_Page()  {
  		assert test.clickLoginLink();
  		assert test.loginUsingFaceBookUserNamePassword(test.getYamlVal("userName_for_Search_With_Existing_Seesion"), test.getYamlVal("password_for_Search_With_Existing_Seesion"),newUserFlag);
  		assert test.navigateToHomePage();
      }
  	
  	//Verify First Name on home page
  	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	  public void C_Verify_First_Name_Is_Displayed_On_Home_Page_After_Signing_Into_App()  {
		assert test.verifyFirstNameIsDisplayedOnHomePage();
	  }
  	
  	//Verify click Search Button
  	@Test(dependsOnMethods={"B_Login_Using_FaceBook_Link_Given_On_Home_Page"})
	  public void D_Perform_Search_With_Existing_Session()  {
		test.clickSearchBox();
		test.select_from_Suggested_Searches(test.getYamlVal("searchTerm"));
	  }
  	
  	@Test(dependsOnMethods={"D_Perform_Search_With_Existing_Session"})
	  public void E_Verify_Search_Results()  {
  		assert test.verifySearchResults(test.getYamlVal("searchTerm"));
	  }
  	
  	@Test(dependsOnMethods={"E_Verify_Search_Results"})
	public void F_signOut(){
		test.signOut();
	}
  	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.deleteUserOnFacebook();
		test.closeBrowser();
	}
}
