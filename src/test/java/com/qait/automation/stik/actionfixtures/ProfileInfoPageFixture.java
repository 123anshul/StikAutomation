package com.qait.automation.stik.actionfixtures;


import org.testng.Reporter;
import org.testng.Assert;



import com.qait.automation.stik.util.Utilities;

public class ProfileInfoPageFixture extends HomePageFixture {
	/**
	 * <b>Method: verifyUserIsOnProfileInfoPage </b> 
	 * <p>
	 * verify application navigates to profile info page on clicking profile Info Link.
	 * @return boolean
	 */
	public void isMyProfileInfoPageOk(){
		profileInfoPageUi.waitForElementToAppear(profileInfoPageUi.get_profilePageHeading());
		Reporter.log("Profile Page Heading: "+profileInfoPageUi.get_profilePageHeading().getText());
		Assert.assertTrue(profileInfoPageUi.get_profilePageHeading().getText().trim().equalsIgnoreCase(profileInfoPageUi.get_profilePageHead()));
		Reporter.log("Verified heading matches");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_firstNameTextBox()));
		Reporter.log("Verified First name text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_lastNameTextBox()));
		Reporter.log("Verified Last name text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_userNameTextBox()));
		Reporter.log("Verified User name text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_emailTextBox()));
		Reporter.log("Verified email text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_phoneNumberTextBox()));
		Reporter.log("Verified phone number text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_companyTextBox()));
		Reporter.log("Verified Company text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_titleTextBox()));
		Reporter.log("Verified title text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_websiteTextBox()));
		Reporter.log("Verified website text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_addressTextBox()));
		Reporter.log("Verified address text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_cityNameTextBox()));
		Reporter.log("Verified city text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_zipCodeTextBox()));
		Reporter.log("Verified zip code text box is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_imageSrc()));
		Reporter.log("Verified image src tag is displayed");
		Assert.assertTrue(isDisplayed(profileInfoPageUi.get_changePictureLink()));
		Reporter.log("Verified change picture link is displayed");
	}
	
	/**
	 * <b>Method: updateFirstLastNameAndCompanyOnProfileInfoPage </b> 
	 * <p>
	 * Update First, Last Name and Company Name on Profile Info Page.
	 * @return boolean
	 */
	public boolean updateProfileInfoPage(boolean newUserFlag){
	    Assert.assertTrue(profileInfoPageUi.get_firstNameTextBox().isDisplayed());
		profileInfoPageUi.get_firstNameTextBox().clear();
		profileInfoPageUi.get_firstNameTextBox().sendKeys(util.getYamlValue("update.firstName"));
		
		Assert.assertTrue(profileInfoPageUi.get_lastNameTextBox().isDisplayed());
		profileInfoPageUi.get_lastNameTextBox().clear();
		profileInfoPageUi.get_lastNameTextBox().sendKeys(util.getYamlValue("update.lastName"));
		
		if(util.getYamlValue("appUrl").contains("knewbies")){
			
		Assert.assertTrue(profileInfoPageUi.get_emailTextBox().isDisplayed());
		profileInfoPageUi.get_emailTextBox().clear();
		if(newUserFlag)
			profileInfoPageUi.get_emailTextBox().sendKeys(getTestUserName());
		else
			profileInfoPageUi.get_emailTextBox().sendKeys(util.getYamlValue("userName"));
		}
		
		Assert.assertTrue(profileInfoPageUi.get_phoneNumberTextBox().isDisplayed());
		profileInfoPageUi.get_phoneNumberTextBox().clear();
		profileInfoPageUi.get_phoneNumberTextBox().sendKeys(util.getYamlValue("update.phoneNo"));
		
		Assert.assertTrue(profileInfoPageUi.get_companyTextBox().isDisplayed());
		profileInfoPageUi.get_companyTextBox().clear();
		profileInfoPageUi.get_companyTextBox().sendKeys(util.getYamlValue("update.company"));
		
		Assert.assertTrue(profileInfoPageUi.get_titleTextBox().isDisplayed());
		profileInfoPageUi.get_titleTextBox().clear();
		profileInfoPageUi.get_titleTextBox().sendKeys(util.getYamlValue("update.title"));
		
		Assert.assertTrue(profileInfoPageUi.get_licenseTextBox().isDisplayed());
		profileInfoPageUi.get_licenseTextBox().clear();
		profileInfoPageUi.get_licenseTextBox().sendKeys(util.getYamlValue("update.license"));
		
		Assert.assertTrue(profileInfoPageUi.get_websiteTextBox().isDisplayed());
		profileInfoPageUi.get_websiteTextBox().clear();
		profileInfoPageUi.get_websiteTextBox().sendKeys(util.getYamlValue("update.website"));
		
		Assert.assertTrue(profileInfoPageUi.get_addressTextBox().isDisplayed());
		profileInfoPageUi.get_addressTextBox().clear();
		profileInfoPageUi.get_addressTextBox().sendKeys(util.getYamlValue("update.Address"));
		
		Assert.assertTrue(profileInfoPageUi.get_cityNameTextBox().isDisplayed());
		profileInfoPageUi.get_cityNameTextBox().clear();
		profileInfoPageUi.get_cityNameTextBox().sendKeys(util.getYamlValue("update.City"));
		
	
		selectStateOnProfileInfoPage();
		
		Assert.assertTrue(profileInfoPageUi.get_zipCodeTextBox().isDisplayed());
		profileInfoPageUi.get_zipCodeTextBox().clear();
		profileInfoPageUi.get_zipCodeTextBox().sendKeys(util.getYamlValue("update.zipcode"));
		
		Reporter.log("Updated profile Information on Profile Info Page...");
		Assert.assertTrue(profileInfoPageUi.get_saveButton().isDisplayed());
		profileInfoPageUi.get_saveButton().click();
		Reporter.log("Clicked save button...");
		Utilities.hardWait(7);
		navigateToMyProfilePage();
		return true;
	}
	
	/**
	 * <b>Method: verifyFirstNameLastNameGetsUpdatedOnProfilePage </b> 
	 * <p>
	 * Click view profile link and verify the updated information.
	 * @return boolean
	 */
	public boolean verifyFirstNameLastNameGetsUpdatedOnProfilePage(){
		boolean flag = false;
		navigateToMyProfilePage();	
		String profileName = util.getYamlValue("update.firstName")+" "+util.getYamlValue("update.lastName");
		if(profilePageUi.get_profileName().getText().equalsIgnoreCase(profileName)){
			Reporter.log("Profile First and Last Name matches with the updated value");
			flag = true;
		}else{
			Reporter.log("Profile First and Last Name does not matches with the updated value");
		}
		if(profilePageUi.get_affiliation().getText().toLowerCase().contains(util.getYamlValue("update.company").toLowerCase())) {
			Reporter.log("Company Name Matches with updated value");
			return flag;
		}
		Reporter.log("Company Name does not match with the updated value");
		return false;
	}
	
	//Selecting "My Profile" from dropdown
	public boolean navigateToMyProfilePage(){
		ifExistsDebugClickClose();
		if(get_Browser().equalsIgnoreCase("iexplore")){
			Assert.assertTrue(homePageUi.get_dropDown().isDisplayed());
			homePageUi.get_dropDown().click();
			Assert.assertTrue(homePageUi.get_viewProfileLink().isDisplayed());
			//homePageUi.get_viewProfileLink().click();
			logger.info("href: " + homePageUi.get_viewProfileLink().getAttribute("href"));
			driver.navigate().to(homePageUi.get_viewProfileLink().getAttribute("href"));
			Reporter.log("Clicked drop down link and navigate to Users Profile...");
			homePageUi.waitForElementToAppear(profilePageUi.get_affiliation());
		}else{
			try{
				homePageUi.get_stiklogo1().click();
				homePageUi.waitForElementToAppear(homePageUi.get_GetStartedButton());
				Utilities.hardWait(2);
				homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_viewProfileLink());
			}catch(Exception enve){
					homePageUi.get_dropDown().click();
					logger.info("href: " + homePageUi.get_viewProfileLink().getAttribute("href"));
					driver.navigate().to(homePageUi.get_viewProfileLink().getAttribute("href"));
				}
		}
		Reporter.log("Navigated to my profile Page...");
		return true;
	}
	
	public boolean removeProfileDetails(){
		homePageUi.waitForElementToAppear(profileInfoPageUi.get_profilePageHeading());
		profileInfoPageUi.get_companyTextBox().clear();
		profileInfoPageUi.get_titleTextBox().clear();
		profileInfoPageUi.get_licenseTextBox().clear();
		profileInfoPageUi.get_websiteTextBox().clear();
		profileInfoPageUi.get_cityNameTextBox().clear();
		profileInfoPageUi.get_addressTextBox().clear();
		profileInfoPageUi.get_outSideUSLink().click();
		profileInfoPageUi.get_zipCodeTextBox().clear();
		Utilities.hardWait(1);
		profileInfoPageUi.get_saveButton().click();
		return true;
	}
	
	public void selectStateOnProfileInfoPage(){
		scrollDown(450);
		Assert.assertTrue(profileInfoPageUi.get_dropdownArrow().isDisplayed(),"State Drop Down not Present.." );
		profileInfoPageUi.get_dropdownArrow().click();
		profileInfoPageUi.get_stateToSelectFromList().click();		
		
	}
}
