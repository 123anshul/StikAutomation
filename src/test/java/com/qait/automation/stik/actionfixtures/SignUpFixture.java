package com.qait.automation.stik.actionfixtures;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class SignUpFixture extends SearchPageFixture{


	public static boolean uiMeterFLAG=false;
	public void clickGotItButton(){
		homePageUi.waitForElementToAppear(professionalPageUi.get_gotItButtonOnPopup());
		try{
		professionalPageUi.get_gotItButtonOnPopup().click();
		System.out.println("Got It button present ancd clicked..");
		}catch(Exception ex){
			System.out.println("Got it button not found");
		}
	}
	
	
	public boolean clickContinueOnFBPanel(){
		try{
			clickGotItButton();
			Utilities.hardWait(1);
		}catch(Exception ex){
			System.out.println("Black Pop up screen does not appear");
		}
		homePageUi.waitForElementToAppear(professionalPageUi.get_ContinueButton());
		professionalPageUi.get_ContinueButton().click();
		try{
			Utilities.explicitWait(driver);
			professionalPageUi.get_continueAnyWay().click();
			return true;
		}catch(NoSuchElementException ex){
			System.out.println("Continue Anyway Button on Facebook Panel Not Found");
			return true;
		}catch(ElementNotVisibleException ex){
			System.out.println("Continue Anyway Button on Facebook Panel Not Found");
			return true;
		}
	
	}
	
	public boolean navigateToClientsMailPage_temp(){
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_collectReviewsLink());
		Utilities.explicitWait(driver);
		return true;
	}
	
	public boolean clickContinueOnLinkedInPanel(){
		Utilities.explicitWait(driver);
		try{
			clickGotItButton();
			Utilities.hardWait(1);
		}catch(Exception ex){
			System.out.println("Black Pop up screen does not appear");
		}
		homePageUi.waitForElementToAppear(professionalPageUi.get_ContinueButton());
		professionalPageUi.get_ContinueButton().click();
		Utilities.hardWait(1);
		try{
			
			professionalPageUi.get_continueAnyWay().click();
			
		}catch(ElementNotVisibleException ex){
			System.out.println("Continue Anyway Button on LinkedIn Panel Not Found");
			
		}catch (NoSuchElementException e) {
			System.out.println("Continue Anyway Button on LinkedIn Panel Not Found");
		}
		return true;
	}
	
	public boolean importIndividualEmailContactOnMailPanel(String email, String fname, String lname){
		Utilities.explicitWait(driver);
		int counterForPeopleSelectedBeforeImport= professionalPageUi.get_counterForPeopleSelected();
		System.out.println("Counter value for people Selected Before Import:- "+counterForPeopleSelectedBeforeImport);
		String randomNumber=generateRandomEmailIds(email);
		String localEmailId=email+randomNumber+"@test.net";
		System.out.println("The Random Email Id generated is:- "+localEmailId);
		scrollDown(250);
		try{
		professionalPageUi.get_emailFieldOnImportSection().clear();
		professionalPageUi.get_emailFieldOnImportSection().sendKeys(localEmailId);
		Utilities.hardWait(1);
		professionalPageUi.get_firstNameOnImportSection().clear();
		professionalPageUi.get_firstNameOnImportSection().sendKeys(fname+randomNumber);
		Utilities.hardWait(1);
		professionalPageUi.get_lastNameOnImportedSection().clear();
		professionalPageUi.get_lastNameOnImportedSection().sendKeys(lname);
		System.out.println("All Information for importing individual contact filled");
		Reporter.log("All Information for importing individual contact filled");
		professionalPageUi.get_importButton().click();
		System.out.println("Clicked import button");
		Utilities.hardWait(4);
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(professionalPageUi.get_yourEmailContactListForNewUser());
		System.out.println("Contact Imported");
		homePageUi.waitForElementToAppear(professionalPageUi.get_yourEmailContactListForNewUser());
		int counterForPeopleSelectedAfterImport=professionalPageUi.get_counterForPeopleSelected();
		System.out.println("Counter value for people Selected After Import:- "+counterForPeopleSelectedAfterImport);
		Assert.assertTrue(counterForPeopleSelectedAfterImport==(counterForPeopleSelectedBeforeImport+1), "Counter for people selected doesn't get updated");
		return true;
		}catch(Exception ex){
			System.out.println("Problem in importing individual contact");
			Reporter.log("Problems in importing individual contacts");
			return false;
		}
	}
	
	public void checkUncheckImportedContactOnEmailPanel_VerifyCounterValues_VeifyUIMeter(){
	
		if(professionalPageUi.get_yourEmailContactListForNewUser().getAttribute("class").contains("selected")){
			System.out.println("The newly imported Contact is selected by default");
			Reporter.log("The newly imported Contact is selected by default");
			
			professionalPageUi.get_yourEmailContactListForNewUser().click();
			Utilities.hardWait(1);
			if(verifyChallengeMeterPresent()){
				Assert.assertTrue(checkProgressMeter(), "Progress Bar not working!!!");
			}
			Assert.assertTrue(verifyCountersAreInSync(), "Counters Value mismatch on deselecting the contact");
			Reporter.log("Contact unchecked successfully...");
		
		}
		professionalPageUi.get_yourEmailContactListForNewUser().click();
		Assert.assertTrue(verifyCountersAreInSync(), "Counters Value mismatch on selecting the contact");
		Reporter.log("Contact successfully selected...");
		if(verifyChallengeMeterPresent()){
			Assert.assertTrue(checkProgressMeter(), "Progress Meter not working!!");
		}

	}

	
	public boolean verifyChallengeMeterPresent(){
		homePageUi.waitForElementToAppear(professionalPageUi.get_ContinueButton());
	
			if(professionalPageUi.get_uiMeterSection().isDisplayed()){
				uiMeterFLAG=true;
				System.out.println("UI Meter found...");
				Reporter.log("UI Challenge meter found...");
				return uiMeterFLAG;
			}else{
				System.out.println("UI Meter not found !!");
				Reporter.log("UI Challenge meter not present !!!");
				
			}
		return uiMeterFLAG;
	}
	
	
	public boolean clickContinueOnMailPanel(){
		professionalPageUi.get_ContinueButton().click();
		return true;
	}
	
	public void handleModalDialogForMessage(String textMessage){
		Utilities.explicitWait(driver);
		String localTextAreaMessage=textMessage+" "+String.valueOf(System.currentTimeMillis());
		Utilities.hardWait(2);
		Assert.assertTrue(isDisplayed(professionalPageUi.get_messageModalDialog()), "Modal Dialog did not open...");
		professionalPageUi.get_textAreaInMessageBox().clear();
		Utilities.hardWait(1);
		professionalPageUi.get_textAreaInMessageBox().sendKeys(localTextAreaMessage);
		Utilities.hardWait(2);
		try{
		professionalPageUi.get_doneButtonOnMessageBox().click();
		
		}catch(Exception ex){
			Utilities.hardWait(1);
			professionalPageUi.get_doneButtonOnMessageBox().click();
		}
		Utilities.hardWait(5);
	}
	
	
	public boolean handleProfileInfoSection(String phoneNumber, String zipCode){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(professionalPageUi.get_successMessage());
		Assert.assertTrue(isDisplayed(professionalPageUi.get_successMessage()), "Success Message 'Great Job' is not displayed");
		Utilities.hardWait(4);
		scrollDown(200);
		selectIndustryFromList();
		Utilities.hardWait(1);
		professionalPageUi.get_phoneNumber().clear();
		professionalPageUi.get_phoneNumber().sendKeys(phoneNumber);
		Utilities.hardWait(1);
		professionalPageUi.get_zipCode().clear();
		professionalPageUi.get_zipCode().sendKeys(zipCode);
		Utilities.hardWait(2);
		professionalPageUi.get_createMyProfileButton().click();
		return true;
	}
	
	public boolean verifyUserIsOnProfilePage(){
		homePageUi.waitForElementToAppear(profilePageUi.get_RatingCount());
		if(profilePageUi.get_profileName().isDisplayed()){
			System.out.println("On Profile Page");
			Reporter.log("User is On the Profile page...");
			return true;
		}else{
			Reporter.log("User DOES NOT reach profile page on creating profile after Sign up!!");
			return false;
		}
	}
	public void selectIndustryFromList(){
		Utilities.hardWait(1);
		professionalPageUi.get_selectorElement().click();
		List<WebElement> industry=professionalPageUi.get_industryList();
		int randomPickFromList= 1+ (int)(Math.random()*19);
	    System.out.println("At random index "+randomPickFromList+", the industry is:- " +industry.get(randomPickFromList).getText());
	    Reporter.log("At random index "+randomPickFromList+", the industry is:- " +industry.get(randomPickFromList).getText());
	    industry.get(randomPickFromList).click();
	}
	
	public boolean verifyCountersAreInSync(){
		Utilities.hardWait(1);
		int counterForPeopleSelected=professionalPageUi.get_counterForPeopleSelected();
		if(professionalPageUi.get_yourEmailContactListForNewUser().getAttribute("class").contains("selected")){
			int counterAtBack=professionalPageUi.get_counterAtBackofContact();
			System.out.println("Counter At back:- "+counterAtBack);
			
			System.out.println("Counter for People Selected:- "+ counterForPeopleSelected);
			if(counterAtBack== counterForPeopleSelected){
				Reporter.log("Counter for Number of People Selected is correct");
			
			}else{
				Reporter.log("Counters value Mismatched when Contact Selected");
				
			}
		}else{
			return counterForPeopleSelected==0;
		}		
		return true;
	}
	
	
	public String generateRandomEmailIds(String email){
		int randomNumber= generateRandomNumber(100, 30000);
		return String.valueOf(randomNumber);
	}
	
	public boolean checkProgressMeter(){
		if(professionalPageUi.get_yourEmailContactListForNewUser().getAttribute("class").contains("selected")){
			if(professionalPageUi.get_uiProgressMeter().getAttribute("style").contains("10%")){
				Reporter.log("Progress Bar has moved from 0 to 10% on selection");
				System.out.println("Progress Bar working fine on selection...");
				return true;
			}else{
				Reporter.log("Progress Bar did not work on Selection!!");
				return false;
			}
		}else{
			if(professionalPageUi.get_uiProgressMeter().getAttribute("style").contains("0%")){
				Reporter.log("Progress Bar has moved to 0% on deselecting the contact");
				System.out.println("Progress Bar workign fine on deselction...");
				return true;
			}else{
				Reporter.log("Progress Bar did not work on DeSelection!!");
				return false;
			}
		}
		
	}
	
	
}