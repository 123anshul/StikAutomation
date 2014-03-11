package com.qait.automation.stik.actionfixtures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.stik.util.Utilities;

public class DirectoryPageFixture_Temp extends HomePageFixture{


	public boolean verifyDirectoryURL(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("directory"), "The url doesn't contain the directory") ;
		return true;
	}

	public boolean verifySearchFormOnDirectory(){
		Assert.assertTrue(isDisplayed(directTemp.getDirectoryPageHeading()), "Page heading is not displayed");
		Assert.assertTrue(isDisplayed(directTemp.getSelectIndustry()), "Select Industry list is not displayed");
		Assert.assertTrue(isDisplayed(directTemp.getZipcodeInput()), "Zipcode text input is not displayed");
		Assert.assertTrue(isDisplayed(directTemp.getContinueButton()), "Continue button is not present");
		return true;
	}

	public boolean verifyPopularIndustriesHeading(){
		Assert.assertTrue(isDisplayed(directTemp.getHeadingPopularIndustries()), "Heading Popular Industries is not displayed");
		return true;
	}

	public boolean searchInsuranceIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getInsuranceHeading()), "Insurance Agents heading is not displayed");
		List<WebElement> list = directTemp.getInsuranceIndustriesList();
		String insuranceHeadingText = directTemp.getInsuranceHeadingText().getText();
		
		if(directTemp.getInsuranceIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("insurance"), "Clicking on the Insurance industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();
			
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

	public boolean searchRealtorsIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getRealtorsHeading()), "Realtors heading is not displayed");
		List<WebElement> list = directTemp.getRealtorsIndustriesList();
		String realtorseHeadingText = directTemp.getRealtorsHeadingText().getText();
		
		if(directTemp.getRealtorsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("real-estate"), "Clicking on the Real Estate industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();			
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

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

	public boolean searchAutoProfessionalIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getAutoProfessionHeading()), "Auto Professional heading is not displayed");
		List<WebElement> list = directTemp.getAutoProfessionalIndustriesList();
		String autoProfessionHeadingText = directTemp.getAutoProfessionHeadingText().getText();
		
		if(directTemp.getAutoProfessionalIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("auto-sales"), "Clicking on the Real Estate industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

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
	
	public boolean searchHomeContractorsIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getHomeContractorsHeading()), "Home Contractors heading is not displayed");
		List<WebElement> list = directTemp.getHomeContractorsIndustriesList();
		String homeContractorsHeadingText = directTemp.getHomeContractorsHeadingText().getText();
		
		if(directTemp.getHomeContractorsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("home-services"), "Clicking on the Home Contractor industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

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
	
	public boolean searchHealthCareIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getHealthCareHeading()), "Health Care heading is not displayed");
		List<WebElement> list = directTemp.getHealthCareIndustriesList();
		String healthCareHeadingText = directTemp.getHealthCareHeadingText().getText();
		
		if(directTemp.getHealthCareIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("health-wellness"), "Clicking on the Health Care industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

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
	
	public boolean searchArtistsIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getArtistsHeading()), "Artists heading is not displayed");
		List<WebElement> list = directTemp.getArtistsIndustriesList();
		String artistsHeadingText = directTemp.getArtistsHeadingText().getText();
		
		if(directTemp.getArtistsIndustriesList().size()>0){
			String linkText = list.get(0).getText();
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("arts-entertainment"), "Clicking on the Artists industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

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
	
	public boolean searchOtherIndustries(){
		Assert.assertTrue(isDisplayed(directTemp.getOthersHeading()), "Others heading is not displayed");
		List<WebElement> list = directTemp.getOthersIndustriesList();
		if(directTemp.getOthersIndustriesList().size()>0){
			list.get(0).click();
			homePageUi.waitForElementToAppear(directTemp.getIndustryHeading());
			Assert.assertTrue(driver.getCurrentUrl().contains("financial-planning"), "Clicking on Other industry doesn't navigate to correct url");

			String industryHead = directTemp.getIndustryHeading().getText();
			String recommendProfessionalText = directTemp.getRecommendProfessionalsText().getText();

			Assert.assertTrue(industryHead.contains("Financial Planners"), "Selected Other industry redirects to the wrong page");
			Assert.assertTrue(recommendProfessionalText.contains("Financial Planners"), "List of professionals displayed is not in accordance with the selected Artists industry");
		}
		else{
			System.out.println("No list is available..");
			return false;
		}
		return true;
	}
}
