package com.qait.automation.stik.actionfixtures;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class BusinessInfoFixture extends SearchPageFixture{

	public int stateSelector=2;
	public String city="h";
	public String summryLocal="";
	public boolean clickBusinessInfoTag(){
		homePageUi.waitForElementToAppear(businessInfoUi.get_businessInfoTab());
		if(businessInfoUi.get_businessInfoTab().isDisplayed()){
			businessInfoUi.get_businessInfoTab().click();
			Reporter.log("Clicked on Business Info tab from left vertical menu bar");
			return true;
		}else{
			Reporter.log("Business Info Tag from left manu bar is missing");
			return false;
		}
	}
	
	public void isCompleteBusinessInfoFieldsPresent(){
		Assert.assertTrue(isDisplayed(businessInfoUi.get_SelectIndustryDropDown()));
		Reporter.log("Industry Drop Down present...");
		Assert.assertTrue(isDisplayed(businessInfoUi.get_addAnotherButton()));
		Reporter.log("Add Another button present...");
		Assert.assertTrue(isDisplayed(businessInfoUi.get_cityTextBox()));
		Reporter.log("City Text Box present...");
		Assert.assertTrue(isDisplayed(businessInfoUi.get_summaryTextArea()));
		Reporter.log("Summary Text Area present...");
	}
	
	public boolean selectIndustry(){
		Utilities.hardWait(2);
		int countOfIndustry=2;
		String currentIndustry= businessInfoUi.get_currentIndustry();
		businessInfoUi.get_industryDropDownArrow().click();
	
		logger.info("Current Industry:- "+currentIndustry);
		logger.info("Industry to be selected:- "+businessInfoUi.getIndustrySelected(countOfIndustry).getText());
		if(currentIndustry.equalsIgnoreCase(businessInfoUi.getIndustrySelected(countOfIndustry).getText())){
			countOfIndustry++;
		}
		System.out.println("CountOfIndustry Variable value:- " +countOfIndustry);
		Reporter.log("Industry Selected as:- " + businessInfoUi.getIndustrySelected(countOfIndustry).getText());
		logger.info("Industry Selected:- "+businessInfoUi.getIndustrySelected(countOfIndustry).getText());
		businessInfoUi.getIndustrySelected(countOfIndustry).click();
		
		return true;
	}
	
	
	public boolean selectMultipleStates(){
		Utilities.hardWait(2);
		WebElement dropDownElement;
		System.out.println("Number of already seleted States:- "+businessInfoUi.get_stateDropDown().size());
		int originalSizeOfStateList= businessInfoUi.get_stateDropDown().size();
		for(int i=0;i<originalSizeOfStateList;i++){
			dropDownElement= businessInfoUi.get_stateDropDown().get(i);
			clickStates(dropDownElement);
			System.out.println(dropDownElement.getText());
		}
			return true;	
	}
	
	public void clickStates(WebElement dropDownElement){
		Utilities.hardWait(2);
		if(stateSelector>25){
			stateSelector=2;
		}
		stateSelector++; 
		String cssSelector="ul>li:nth-child(index)";
		String cssSelectorState= cssSelector.replaceAll("index", String.valueOf(stateSelector));
		dropDownElement.findElement(By.cssSelector("a[class='selector']")).click();
		dropDownElement.findElement(By.cssSelector(cssSelectorState)).click();
	}
	
	public boolean clickAddAnotherAndVerifyStateIncrement(){
		int sizebeforeAdd= businessInfoUi.get_stateDropDown().size();
		logger.info("Number of States Before Adding Any:- "+ sizebeforeAdd);
		businessInfoUi.get_addAnotherButton().click();
		Utilities.hardWait(2);
		int sizeAfterAdd= businessInfoUi.get_stateDropDown().size();
		if(sizeAfterAdd == (sizebeforeAdd+1)){
			System.out.println("Number of States After Adding Another:- "+sizeAfterAdd);
			Reporter.log("Add Another Button working Fine...");
			logger.info("Add Another Button working fine");
			return true;
		}
		else{
			Reporter.log("Unable to Add another state drop down with Add Another button...");
			logger.info("Problem with Add Another Button...");
			System.out.println("Problem with Add Another Button...");
			return false;
		}
	}
	
	public boolean selectCity(){
		scrollDown(400);
		removeExistingCities();
		Utilities.hardWait(2);
		try{
		Assert.assertTrue(isDisplayed(businessInfoUi.get_cityTextBoxSuggestionPlaceholder()));
		Reporter.log("Placeholder in Suggestion list for city text box appears...");
		logger.info("Text in Suggestion Placeholder:- "+ businessInfoUi.get_cityTextBoxSuggestionPlaceholder().getText());
		
		for(int i=0;i<3;i++){
			clickOnCityFromSuggestionList(i);
			city=incrementCityCharacter(city);
		}
		}catch(Exception e){
			logger.error("Unable to select city");
		}
		return true;
	}
	
	public void clickOnCityFromSuggestionList(int counter){
		businessInfoUi.get_cityTextBox().click();
		businessInfoUi.get_cityTextBox().sendKeys(city);
		logger.info("Name of Selected City:- "+ businessInfoUi.get_citySuggestionList().getText());
		Reporter.log("Selected City No."+counter+1+" is:- "+businessInfoUi.get_citySuggestionList().getText());
		businessInfoUi.get_citySuggestionList().click();
		Utilities.hardWait(1);
		
	}
	
	private String incrementCityCharacter(String city) {
        
        char c1= city.charAt(0);
        int c2=(int)++c1;
        char c3=(char)c2;
        city=city.replace(city.charAt(0),c3);
		return city;
		
	}

	public boolean enterSummary(String summary){
		summryLocal=summary+ System.currentTimeMillis();
		businessInfoUi.get_summaryTextArea().clear();
		Utilities.hardWait(2);
		businessInfoUi.get_summaryTextArea().click();
		businessInfoUi.get_summaryTextArea().sendKeys(summryLocal);
		Utilities.hardWait(2);
		return true;
	}
	public boolean clickSaveButton(){
		businessInfoUi.get_saveButtonOnBusinessInfoPage().click();
		Utilities.hardWait(5);
		return true;
	}
	
	public void removeExistingCities(){
		int sizeOfExistingCity=businessInfoUi.get_existingCitiesList().size();
		for(int i=1;i<sizeOfExistingCity;i++){
		businessInfoUi.get_crossButtonForExistingCity().click();
			Utilities.hardWait(1);
		}
		Reporter.log("Removed Existing Cities Using Cross Button...");
	}
	
	public boolean veirfyAboutSectionContainsSummary(){
	String summary=businessInfoUi.get_summaryTextArea().getAttribute("value");
		businessInfoUi.get_addAnotherButton().getAttribute("ttile");
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_viewProfileLink());
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		logger.info("About Section Text:- "+profilePageUi.get_about().getText());
		if(profilePageUi.get_about().getText().trim().equalsIgnoreCase(summary.trim())){
			
			Reporter.log("Summary content matches with the About Section on Profile Page");
			return true;
		}
		return false;
	
	}
}
