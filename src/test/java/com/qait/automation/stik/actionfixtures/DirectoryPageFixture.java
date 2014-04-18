package com.qait.automation.stik.actionfixtures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class DirectoryPageFixture extends ReviewPageFixture{


	//Verify the Directory page url
	public boolean verifyDirectoryURL(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("directory"), "The url doesn't contain the directory") ;
		return true;
	}

	//Verify basic UI elements of Search form on /directory page
	public boolean verifySearchFormOnDirectory(){
		Assert.assertTrue(isDisplayed(directoryPageUi.getDirectoryPageHeading()), "Page heading is not displayed");
		Assert.assertTrue(isDisplayed(directoryPageUi.getSelectIndustry()), "Select Industry list is not displayed");
		Assert.assertTrue(isDisplayed(directoryPageUi.getZipcodeInput()), "Zipcode text input is not displayed");
		Assert.assertTrue(isDisplayed(directoryPageUi.getContinueButton()), "Continue button is not present");
		return true;
	}

	//Verify popular industry heading on /directory page
	public boolean verifyPopularIndustriesHeading(){
		Assert.assertTrue(isDisplayed(directoryPageUi.getHeadingPopularIndustries()), "Heading Popular Industries is not displayed");
		return true;
	}

	//Verifying the presence of "Insurance" link, clicking it and verifying UI elements on insurance page
	public boolean searchInsuranceIndustries(){
		Assert.assertTrue(isDisplayed(directoryPageUi.getInsuranceHeading()), "Insurance Agents heading is not displayed");
		List<WebElement> list = directoryPageUi.getInsuranceIndustriesList();
		String insuranceHeadingText = directoryPageUi.getInsuranceHeadingText().getText();
		
		if(directoryPageUi.getInsuranceIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("insurance"), "Clicking on the Insurance industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();
			
			Assert.assertTrue(industryHead.contains(linkText), "Selected insurance industry doesn't open the correct page");
			Assert.assertTrue(recommendProfessionalText.contains(insuranceHeadingText), "List of professionals displayed is not in accordance with the selected Insurance industry");

			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}

	//Verifying the presence of "Realtors" link, clicking it and verifying UI elements on insurance page
	public boolean searchRealtorsIndustries(){
		Assert.assertTrue(isDisplayed(directoryPageUi.getRealtorsHeading()), "Realtors heading is not displayed");
		List<WebElement> list = directoryPageUi.getRealtorsIndustriesList();
		String realtorseHeadingText = directoryPageUi.getRealtorsHeadingText().getText();
		
		if(directoryPageUi.getRealtorsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("real-estate"), "Clicking on the Real Estate industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();			
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains(linkText), "Selected Real Estate industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains(realtorseHeadingText), "List of professionals displayed is not in accordance with the selected Real Estate industry");

			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}

	//Verifying the presence of "Auto Professional" link, clicking it and verifying UI elements on insurance page
	public boolean searchAutoProfessionalIndustries(){
		scrollDown(200);
		Assert.assertTrue(isDisplayed(directoryPageUi.getAutoProfessionHeading()), "Auto Professional heading is not displayed");
		List<WebElement> list = directoryPageUi.getAutoProfessionalIndustriesList();
		String autoProfessionHeadingText = directoryPageUi.getAutoProfessionHeadingText().getText();
		
		if(directoryPageUi.getAutoProfessionalIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("auto-sales"), "Clicking on the Auto Professional industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains(linkText), "Selected Auto Professional industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains(autoProfessionHeadingText), "List of professionals displayed is not in accordance with the selected Auto Professional industry");
		
			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
	
	//Verifying the presence of "Home Contractors" link, clicking it and verifying UI elements on insurance page
	public boolean searchHomeContractorsIndustries(){
		scrollDown(295);
		Assert.assertTrue(isDisplayed(directoryPageUi.getHomeContractorsHeading()), "Home Contractors heading is not displayed");
		List<WebElement> list = directoryPageUi.getHomeContractorsIndustriesList();
		String homeContractorsHeadingText = directoryPageUi.getHomeContractorsHeadingText().getText();
		
		if(directoryPageUi.getHomeContractorsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("home-services"), "Clicking on the Home Contractor industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains(linkText), "Selected Home Contractor industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains(homeContractorsHeadingText), "List of professionals displayed is not in accordance with the selected Home Contractor industry");
		
			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
	
	//Verifying the presence of "Health Care" link, clicking it and verifying UI elements on insurance page
	public boolean searchHealthCareIndustries(){
		scrollDown(300);
		Assert.assertTrue(isDisplayed(directoryPageUi.getHealthCareHeading()), "Health Care heading is not displayed");
		List<WebElement> list = directoryPageUi.getHealthCareIndustriesList();
		String healthCareHeadingText = directoryPageUi.getHealthCareHeadingText().getText();
		
		if(directoryPageUi.getHealthCareIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("health-wellness"), "Clicking on the Health Care industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains(linkText), "Selected Health Care industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains(healthCareHeadingText), "List of professionals displayed is not in accordance with the selected Health Care industry");
		
			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
	
	//Verifying the presence of "Artists" link, clicking it and verifying UI elements on insurance page
	public boolean searchArtistsIndustries(){
		scrollDown(280);
		Assert.assertTrue(isDisplayed(directoryPageUi.getArtistsHeading()), "Artists heading is not displayed");
		List<WebElement> list = directoryPageUi.getArtistsIndustriesList();
		String artistsHeadingText = directoryPageUi.getArtistsHeadingText().getText();
		
		if(directoryPageUi.getArtistsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("arts-entertainment"), "Clicking on the Artists industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains(linkText), "Selected Artists industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains(artistsHeadingText), "List of professionals displayed is not in accordance with the selected Artists industry");
		
			navigateToDirectory();
			Utilities.explicitWait(driver);
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
	
	//Verifying the presence of "Financial Planning" link, clicking it and verifying UI elements on insurance page
	public boolean searchOtherIndustries(){
		Assert.assertTrue(isDisplayed(directoryPageUi.getOthersHeading()), "Others heading is not displayed");
		List<WebElement> list = directoryPageUi.getOthersIndustriesList();
		if(directoryPageUi.getOthersIndustriesList().size()>0){
			list.get(0).click();
			homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("financial-planning"), "Clicking on Other industry doesn't navigate to correct url");

			String industryHead = directoryPageUi.getIndustryHeading().getText();
			String recommendProfessionalText = directoryPageUi.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains("Financial Planners"), "Selected Other industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains("Financial Planners"), "List of professionals displayed is not in accordance with the selected Artists industry");
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
	
	//Selecting the industry from dropdown on /directory page
	public void searchAndVerifyProfessionalFromDropDown(String industry, String matchText, String url){
	
		homePageUi.waitForElementToAppear(directoryPageUi.getSelectIndustry());
		directoryPageUi.getSelectIndustry().click();
		homePageUi.waitForElementToAppear(directoryPageUi.get_industryList().get(1));
		List<WebElement> industryList= directoryPageUi.get_industryList();
		for(int i=0;i<industryList.size();i++){
			if(industryList.get(i).getText().trim().contains(industry)){
				System.out.println("Clicked the "+industry+" industry");
				industryList.get(i).click();
				break;
			}else{
				continue;
			}
		}
		
		directoryPageUi.getContinueButton().click();
		System.out.println("Continue button clicked after selecting industry");
		Reporter.log("Industry clicked on Directory page");
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
		Assert.assertTrue(isDisplayed(directoryPageUi.get_mapOnSubPage()), "Map to the right of professional list is not displayed");
		Assert.assertTrue(driver.getCurrentUrl().trim().equalsIgnoreCase(url), "Incorrect URL opened for selected Industry");
		Assert.assertTrue(directoryPageUi.getIndustryHeading().getText().trim().contains(matchText), "Incorrect Industry opened on Directory page");
		Assert.assertTrue(verifyFrameTextAndEmployeeList(matchText), "Problems in frame text or professional list on directory subpage");
	}
	
	public boolean verifyFrameTextAndEmployeeList(String frameText){
		boolean flag1=false;
		boolean flag2=false;
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(directoryPageUi.get_framingText());
		if(directoryPageUi.get_framingText().getText().trim().contains(frameText)){
			flag1=true;
		}
		List<WebElement> professionals=directoryPageUi.get_employeeList();
		for(int i=0;i<professionals.size();i++){
			if(professionals.get(i).isDisplayed()){
				flag2=true;
			}else{
				flag2=false;
				break;
			}
		}
		return flag1 && flag2;
	}
	
	//Inputting a zipcode and verifying the list of professionals for the provided zipcode
	public boolean verifyZipcode(String zipcode){
		homePageUi.waitForElementToAppear(directoryPageUi.get_zipcodeInput());
		directoryPageUi.get_zipcodeInput().sendKeys(zipcode);
		directoryPageUi.getContinueButton().click();
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(directoryPageUi.get_finalHeaderContent());
		Assert.assertTrue(directoryPageUi.get_employeeList().size()>0, "Professional's list is not there for the provided zipcode");
		Assert.assertTrue(directoryPageUi.get_zipcodeOnEmployeePersonalInfo().getText().contains(zipcode), "Provided zipcode is not matched with zipcode with employee's information");
		return true;
		
	}
	
	//Selecting a state from dropdown and verifying the list of professionals
	public void selectAndVerifyState(String state){
		homePageUi.waitForElementToAppear(directoryPageUi.get_stateDropDownElement());
		scrollDown(200);
		directoryPageUi.get_stateDropDownElement().click();
		homePageUi.waitForElementToAppear(directoryPageUi.get_stateList().get(1));
		List<WebElement> stateList=directoryPageUi.get_stateList();
		for(int i=0;i<stateList.size();i++){
			if(stateList.get(i).getText().trim().contains(state)){
				System.out.println(stateList.get(i).getText().trim()+ " clicked from state drop down");
				stateList.get(i).click();
				break;
			}else{
				continue;
			}
		}
		
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(directoryPageUi.getIndustryHeading());
		Assert.assertTrue(directoryPageUi.get_framingText().getText().trim().contains(state), "Correct state is not reflected in framing text");
		Assert.assertTrue(directoryPageUi.get_employeeList().size()>0, "Professional's list is not there after selecting state");
		
	}
	
	//Selecting a city from dropdown and verifying the list of professionals
	public void selectAndverifyCity(String city){
		homePageUi.waitForElementToAppear(directoryPageUi.get_cityDropDownElement());
		directoryPageUi.get_cityDropDownElement().click();
		homePageUi.waitForElementToAppear(directoryPageUi.get_cityList().get(1));
		List<WebElement> cityList=directoryPageUi.get_cityList();
		for(int i=0;i<cityList.size();i++){
			if(cityList.get(i).getText().trim().contains(city)){
				System.out.println(cityList.get(i).getText().trim()+" clicked from City Drop down");
				cityList.get(i).click();
				
				break;
			}else{
				continue;
			}
		}
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(directoryPageUi.get_finalHeaderContent());
		Assert.assertTrue(directoryPageUi.get_finalHeaderContent().getText().trim().contains(city), "Wrong heading after city selection");
		Assert.assertTrue(directoryPageUi.get_framingText().getText().trim().contains(city), "Correct city is not reflected in framing text");
		Assert.assertTrue(directoryPageUi.get_employeeList().size()>0, "Professional's list is not there after selecting city");
	}
		
	//verify breadcrumbs updated correctly
	public boolean checkForBreadCrumbTrailOnCityPage(String industry, String state, String city, String all){
		boolean flag=false;
		String[] arr={all,industry,state,city};
		List<WebElement> list=directoryPageUi.get_breadCrumbText();
		Assert.assertTrue(list.size()==4, "Incorrct Breadcrumb in terms of number of links present");
		for(int i=0;i<list.size();i++){
			if(list.get(i).getText().trim().equalsIgnoreCase(arr[i])){
				flag=true;
			}else{
				flag=false;
				break;
			}
			
		}
		
		return flag;
	}
		
	
	
	//////////////   Older code   ///////////////////////
	public void verifyDirectoryPagesAreWorkingAsExpected(String industry, String verifyText, String company, String state, String city){
		if(industry!=null && !industry.isEmpty()){
			clickIndustry(industry);
			if(!verifyText.isEmpty())
				Assert.assertTrue(verifySearchData(verifyText,false),"Input text does not matches");
			else
				Assert.assertTrue(verifySearchData(industry,false),"Industry does not matches");
		}
		
		if(state!=null && !state.isEmpty()){
			clickState(state);
			Assert.assertTrue(verifySearchData(state,false),"State does not matches");
		}
		if(city!=null && !city.isEmpty()){
			clickCity(city);
			Assert.assertTrue(verifySearchData(city,false),"City does not Matches");
		}
		if( company!=null && !company.isEmpty()){
			clickCompany(company);
			Assert.assertTrue(verifySearchData(company,true),"Company does not matches");
		}
	}
	
	private void clickCompany(String company) {
		try{
			System.out.println("enter into click company");
			scrollDown(200);
			directoryPageUi.get_companyDropDown().click();
			List<WebElement> comp=directoryPageUi.get_companyFromDropDown();
			for(WebElement comp1 : comp){
				if(comp1.getText().trim().equalsIgnoreCase(company)){
					System.out.println("Found Company:- "+company);
					comp1.click();
					return;
				}
			}
			
		}catch(Exception ex){
			System.out.println("Company Drop Down Not Found");
		}
	}
	
	private void clickCity(String city) {
		List<WebElement> values = directoryPageUi.getCities();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
//			System.out.println(value.getText());
			if(value.getText().trim().equalsIgnoreCase(city)){
//				System.out.println("Found City: " + city);
				value.click();
				return;
			}
		}
	}

	private void clickState(String state) {
		List<WebElement> values = directoryPageUi.getStates();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
			WebElement anchortag = value.findElement(By.tagName("a"));
//			System.out.println(anchortag.getText());
			if(anchortag.getText().trim().equalsIgnoreCase(state)){
//				System.out.println("Found: " + state);
				anchortag.click();
				return;
			}
		}
	}
	
	public void clickIndustry(String industry){
		List<WebElement> values = directoryPageUi.getIndustries();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
			WebElement anchortag = value.findElement(By.tagName("a"));
//			System.out.println(anchortag.getText());
			if(anchortag.getText().trim().equalsIgnoreCase(industry)){
//				System.out.println("Found: " + industry);
				anchortag.click();
				return;
			}
			
			try{
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				List<WebElement> listTag = value.findElements(By.tagName("li"));
				driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
//				System.out.println("Inner size" + listTag.size());
				for (WebElement value1 : listTag){
					WebElement inneranchortag = value1.findElement(By.tagName("a"));
//					System.out.println("          "+inneranchortag.getText());
					if(inneranchortag.getText().trim().equalsIgnoreCase(industry))
					{
//						System.out.println("Found: " + industry);
						inneranchortag.click();
						return;
					}
				}
			}catch(StaleElementReferenceException sre){
				sre.printStackTrace();
			}catch(Exception ex){
				System.out.println("Sublist not found...");
			}finally{
				driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
			}
		}
	}
	
	public boolean verifySearchData(String searchTerm, boolean isCompany){
		if(isCompany){
			String searchData= directoryPageUi.getSearchTermOnCompanyPage();
			System.out.println(searchData);
			if(searchData.toLowerCase().contains(searchTerm.toLowerCase())){
				return true;
			}
			
		}
		
		List<WebElement> values = directoryPageUi.getSearchData();
		for (WebElement value : values){

			if(value.getText().toLowerCase().contains(searchTerm.toLowerCase())){

				return true;
			}
		}
		values = directoryPageUi.getSearchData();
		for (WebElement value : values){

			if(value.getText().toLowerCase().contains(searchTerm.toLowerCase().split(" ")[0])){

				return true;
			}
		}
		return false;
	}
	
}































/*package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class DirectoryPageFixture extends ReviewPageFixture{

	public void verifyDirectoryPagesAreWorkingAsExpected(String industry, String verifyText, String company, String state, String city){
		if(industry!=null && !industry.isEmpty()){
			clickIndustry(industry);
			if(!verifyText.isEmpty())
				Assert.assertTrue(verifySearchData(verifyText,false),"Input text does not matches");
			else
				Assert.assertTrue(verifySearchData(industry,false),"Industry does not matches");
		}
		
		if(state!=null && !state.isEmpty()){
			clickState(state);
			Assert.assertTrue(verifySearchData(state,false),"State does not matches");
		}
		if(city!=null && !city.isEmpty()){
			clickCity(city);
			Assert.assertTrue(verifySearchData(city,false),"City does not Matches");
		}
		if( company!=null && !company.isEmpty()){
			clickCompany(company);
			Assert.assertTrue(verifySearchData(company,true),"Company does not matches");
		}
	}
	
	private void clickCompany(String company) {
		try{
			System.out.println("enter into click company");
			scrollDown(200);
			directoryPageUi.get_companyDropDown().click();
			List<WebElement> comp=directoryPageUi.get_companyFromDropDown();
			for(WebElement comp1 : comp){
				if(comp1.getText().trim().equalsIgnoreCase(company)){
					System.out.println("Found Company:- "+company);
					comp1.click();
					return;
				}
			}
			
		}catch(Exception ex){
			System.out.println("Company Drop Down Not Found");
		}
		
		
	}

	private void clickCity(String city) {
		List<WebElement> values = directoryPageUi.getCities();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
//			System.out.println(value.getText());
			if(value.getText().trim().equalsIgnoreCase(city)){
//				System.out.println("Found City: " + city);
				value.click();
				return;
			}
		}
	}

	private void clickState(String state) {
		List<WebElement> values = directoryPageUi.getStates();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
			WebElement anchortag = value.findElement(By.tagName("a"));
//			System.out.println(anchortag.getText());
			if(anchortag.getText().trim().equalsIgnoreCase(state)){
//				System.out.println("Found: " + state);
				anchortag.click();
				return;
			}
		}
	}
	
	public void clickIndustry(String industry){
		List<WebElement> values = directoryPageUi.getIndustries();
//		System.out.println("Size: " + values.size());
		for (WebElement value : values)
		{
			WebElement anchortag = value.findElement(By.tagName("a"));
//			System.out.println(anchortag.getText());
			if(anchortag.getText().trim().equalsIgnoreCase(industry)){
//				System.out.println("Found: " + industry);
				anchortag.click();
				return;
			}
			
			try{
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				List<WebElement> listTag = value.findElements(By.tagName("li"));
				driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
//				System.out.println("Inner size" + listTag.size());
				for (WebElement value1 : listTag){
					WebElement inneranchortag = value1.findElement(By.tagName("a"));
//					System.out.println("          "+inneranchortag.getText());
					if(inneranchortag.getText().trim().equalsIgnoreCase(industry))
					{
//						System.out.println("Found: " + industry);
						inneranchortag.click();
						return;
					}
				}
			}catch(StaleElementReferenceException sre){
				sre.printStackTrace();
			}catch(Exception ex){
				System.out.println("Sublist not found...");
			}finally{
				driver.manage().timeouts().implicitlyWait(AJAX_WAIT, TimeUnit.SECONDS);
			}
		}
	}
	
	public boolean verifySearchData(String searchTerm, boolean isCompany){
		if(isCompany){
			String searchData= directoryPageUi.getSearchTermOnCompanyPage();
			System.out.println(searchData);
			if(searchData.toLowerCase().contains(searchTerm.toLowerCase())){
				return true;
			}
			
		}
		
		List<WebElement> values = directoryPageUi.getSearchData();
		for (WebElement value : values){

			if(value.getText().toLowerCase().contains(searchTerm.toLowerCase())){

				return true;
			}
		}
		values = directoryPageUi.getSearchData();
		for (WebElement value : values){

			if(value.getText().toLowerCase().contains(searchTerm.toLowerCase().split(" ")[0])){

				return true;
			}
		}
		return false;
	}
}*/
