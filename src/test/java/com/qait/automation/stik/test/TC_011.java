package com.qait.automation.stik.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DirectoryPageFixture;

public class TC_011 {
	private boolean newUserFlag= false;
	DirectoryPageFixture test = new DirectoryPageFixture();

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
	
	//Verify the Basic elements-Directory page url, Search form and popular industry heading on /directory page
	@Test(dependsOnMethods={"A_launch_URL_Navgiate_to_Directory"})
	public void B_verify_DirectoryURL_BasicElements() {
		assert test.verifyDirectoryURL();
		assert test.verifySearchFormOnDirectory();
		assert test.verifyPopularIndustriesHeading();
	} 
	
	//Selecting the industry from dropdown on /directory page
	@Test(dependsOnMethods={"B_verify_DirectoryURL_BasicElements"})
	public void C_Verify_Professional_Search_Through_DropDown() {
		test.searchAndVerifyProfessionalFromDropDown(test.getYamlVal("directory.industry"), test.getYamlVal("directory.matchingHeading"), test.getYamlVal("directory.url"));
	} 
	
	//Inputting a zipcode and verifying the list of professionals for the provided zipcode
	@Test(dependsOnMethods={"C_Verify_Professional_Search_Through_DropDown"})
	public void D_Verify_Zipcode_Search() {
		test.verifyZipcode(test.getYamlVal("directory.zipCode"));
	} 
	
	//Selecting a state from dropdown appearing on already selected industry page and verifying the list of professionals
	@Test(dependsOnMethods={"D_Verify_Zipcode_Search"})
	public void E_Verify_State_Search() {
		test.selectAndVerifyState(test.getYamlVal("directory.state"));
	}
	
	//Selectig the city, verifying breadcrumbs updated correctly and then navigating back to directory
	@Test(dependsOnMethods={"E_Verify_State_Search"})
	public void F_Verify_City_Selection_And_Final_BreadCrumb_Trail() {
		test.selectAndverifyCity(test.getYamlVal("directory.city"));
		test.checkForBreadCrumbTrailOnCityPage(test.getYamlVal("directory.baiscText"), test.getYamlVal("directory.industry"), test.getYamlVal("directory.state"), test.getYamlVal("directory.city"));
		test.navigateToDirectory();
	}
	
	//Verifying the presence of "Insurance" link, clicking it and verifying UI elements on insurance page
	@Test(dependsOnMethods={"F_Verify_City_Selection_And_Final_BreadCrumb_Trail"})
	public void G_verify_InsuranceIndustriesList(){
		assert test.searchInsuranceIndustries();
	}
	
	//Verifying the presence of "Realtors" link, clicking it and verifying UI elements on realtors page
	@Test(dependsOnMethods={"G_verify_InsuranceIndustriesList"})
	public void H_verify_RealtorsIndustriesList(){
		assert test.searchRealtorsIndustries();
	}
	
	//Verifying the presence of "Auto Professionals" link, clicking it and verifying UI elements on auto professionals page
	@Test(dependsOnMethods={"H_verify_RealtorsIndustriesList"})
	public void I_verify_AutoProfessionalIndustriesList(){
		assert test.searchAutoProfessionalIndustries();
	}
	
	//Verifying the presence of "Home Contractors" link, clicking it and verifying UI elements on home contractors page
	@Test(dependsOnMethods={"I_verify_AutoProfessionalIndustriesList"})
	public void J_verify_HomeContractorsIndustriesList(){
		assert test.searchHomeContractorsIndustries();
	}
	
	//Verifying the presence of "Health Care" link, clicking it and verifying UI elements on health care page
	@Test(dependsOnMethods={"J_verify_HomeContractorsIndustriesList"})
	public void K_verify_HealthCareIndustriesList(){
		assert test.searchHealthCareIndustries();
	}
	
	//Verifying the presence of "Artists" link, clicking it and verifying UI elements on artists page
	@Test(dependsOnMethods={"K_verify_HealthCareIndustriesList"})
	public void L_verify_ArtistsIndustriesList(){
		assert test.searchArtistsIndustries();
	}
	
	//Verifying the presence of "Other" link, clicking it and verifying UI elements on financial planning page
	@Test(dependsOnMethods={"L_verify_ArtistsIndustriesList"})
	public void M_verify_OtherIndustriesList(){
		assert test.searchOtherIndustries();
	}
	
	//Close browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}






























/*package com.qait.automation.stik.test;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qait.automation.stik.actionfixtures.DirectoryPageFixture;
import com.qait.automation.stik.util.ReadFromTextFile;

//Verify directory Pages without existing session
public class TC_011 {
	DirectoryPageFixture test = new DirectoryPageFixture();

	String preFix;
	TestListenerAdapter tla = new TestListenerAdapter();
	TestNG testng = new TestNG();
	
	ReadFromTextFile readFromFile = new ReadFromTextFile("data/DirectoryData.txt");

	@BeforeClass
    @Parameters({ "filepath" })
    public void beforeClass(@Optional("")String filePath){
        test.setUpDataFile(filePath);
    }
    
	@DataProvider(name = "DP1")
	public Object[][] createData() {
		String[][] str = readFromFile.storeValuesInArray();
		Object[][] retObjArr = str;
		return (retObjArr);
	}
	
    @Test
    @Parameters({"BROWSER"})
    public void setup(@Optional("")String browser) {
        assert test.startBrowser(browser);
    }
	
	@Test(dependsOnMethods={"setup"}, dataProvider = "DP1")
	public void F_verify_Directory_Pages_Are_Working_As_Expected(String industry,String verifyText, String state, String city,String company) throws InterruptedException{
		test.launchUrl(test.getYamlVal("liveUrl")+"/directory");
		test.verifyDirectoryPagesAreWorkingAsExpected(industry, verifyText, company, state, city);
	}
	
	//Close Browser
	@AfterClass
	public void afterClass() {
		test.closeBrowser();
	}
}
*/