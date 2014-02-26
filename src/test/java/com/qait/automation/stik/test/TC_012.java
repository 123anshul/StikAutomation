package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

//Search without existing session
public class TC_012 {
	SearchPageFixture test = new SearchPageFixture();
	
	@BeforeClass
    @Parameters({ "filepath" })
    public void beforeClass(@Optional("")String filePath){
        test.setUpDataFile(filePath);
    }
    
    @Test
    @Parameters({"BROWSER"})
    public void setup(@Optional("")String browser) {
        test.startBrowser(browser);
    }
    
    //Launch Stick URL
  	@Test(dependsOnMethods={"setup"})
      public void A_launch_URL_Navgiate_to_Stick_HomePage() {
  		test.launchUrl(test.getYamlVal("liveUrl"));
    }
	
  	//Verify click Search Button
  	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Perform_Search_Without_Existing_Session()  {
		test.clickSearchBox();
		test.select_from_Suggested_Searches(test.getYamlVal("searchTerm"));
	}
  	
  	@Test(dependsOnMethods={"B_Perform_Search_Without_Existing_Session"})
	public void C_Verify_Search_Results()  {
  		test.verifySearchResults(test.getYamlVal("searchTerm"));
	}
  	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
