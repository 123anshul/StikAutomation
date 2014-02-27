package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.SearchPageFixture;

//Verify Review count on OthersProfile without existing session
public class TC_007 {

	SearchPageFixture test = new SearchPageFixture();
	
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

	// Naviagte to OthersProfile and verify review Count
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Stick_HomePage"})
	public void B_Navigate_To_OtherProfile_And_Verify_Review_Count()  {
		assert test.navigatetoProfilePage(test.getYamlVal("otherprofile.username"));
		assert test.verifyReviewCount();
    }
	
	
	//Logout of the Application and Close Browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
