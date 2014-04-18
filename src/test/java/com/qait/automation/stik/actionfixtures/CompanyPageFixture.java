package com.qait.automation.stik.actionfixtures;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;

public class CompanyPageFixture extends DirectoryPageFixture{

	public void verifyStikEmployeePage(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(companyPageUi.get_stikEmployeePage()), "Stik Employee page not Found");
		Assert.assertTrue(companyPageUi.get_stikEmployeePage().getText().equalsIgnoreCase("Stik"));
		Assert.assertTrue(isDisplayed(companyPageUi.get_EmployeeList().get(0)), "Company employee list is not displayed");
	}

	public void verifyStikCoverImage(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(companyPageUi.get_stikCoverImage()),"Stik image is not displayed");
	}

	public void verifyContactNumber(String contactNumber){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(companyPageUi.get_companyContactHeading()), "contact heading is not displayed");
		Assert.assertTrue((companyPageUi.get_companyContactNumber().getText().contains(contactNumber)), "Contact number is incorrect");
	}

	public void verifyCompanyWebsitelink(){
		scrollDown(300);
		Assert.assertTrue(isDisplayed(companyPageUi.get_companyWebsiteLink()), "Company Website link is not visible");
		String websiteLink=companyPageUi.get_companyWebsiteLink().getAttribute("href");
		companyPageUi.get_companyWebsiteLink().click();
		Utilities.hardWait(1);
		logger.info("website link clicked");
		homePageUi.changeWindow(1);
		Utilities.explicitWait(driver);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.equalsIgnoreCase(websiteLink), "Correct comapny url is not open");
		driver.close();
		homePageUi.changeWindow(0);
		Utilities.explicitWait(driver);
	}

	public void verifyCompanySelectDropDown(){
		Assert.assertTrue(isDisplayed(companyPageUi.get_companySelectDropDownDefault()), "Stik is not default selected company in Company dropdown list");
		String companyName=get_clickedCompanyName();
		homePageUi.waitForElementToAppear(companyPageUi.get_companyName());
		Assert.assertTrue(isDisplayed(companyPageUi.get_companyName()),"Selected company name is not selected");
		Assert.assertTrue(companyPageUi.get_companyName().getText().contains(companyName), "Results displayed are not in accordance to the selected company");
		Assert.assertTrue(isDisplayed(companyPageUi.get_EmployeeList().get(0)), "Company employee list is not displayed");
	}
	
	
	public boolean verifyStateSelectDropDown(){
		scrollDown(300);
		homePageUi.waitForElementToAppear(companyPageUi.get_stateDropDownArrow());
		int stateEmployeeCount=companyPageUi.get_EmployeeList().size();
		if(stateEmployeeCount>1){
			String state=get_clickedState();
			Assert.assertTrue(isDisplayed(companyPageUi.get_stateName()),"State name is not selected");
			Assert.assertTrue(companyPageUi.get_stateName().getText().equalsIgnoreCase(state));
			Assert.assertTrue(isDisplayed(companyPageUi.get_EmployeeList().get(0)), "Company employee list is not displayed");
			return true;
		}
		else{
			Reporter.log("There is either only one or no employee in the employee list of a selected company");
			return true;
		}
	}

	public boolean verifyCitySelectDropDown(){
		scrollDown(330);
		int cityEmployeeCount=companyPageUi.get_EmployeeList().size();
		if(cityEmployeeCount>1){
			String city=get_clickedCity();
		//	Utilities.explicitWait(driver);
			Assert.assertTrue(isDisplayed(companyPageUi.get_cityName()),"City name is not selected");
			Assert.assertTrue(companyPageUi.get_cityName().getText().equalsIgnoreCase(city));
			Assert.assertTrue(isDisplayed(companyPageUi.get_EmployeeList().get(0)), "Company employee list is not displayed");
			return true;
		}
		else{
			Reporter.log("There is either only one or no employee in the employee list of a selected company and selected state");
			return true;
		}
		
	}

	public void verifyEmployeeProfile(){
		scrollDown(350);
		String employeeName=companyPageUi.get_EmployeeName().getText();
		System.out.println("employee name: "+ employeeName);
		Utilities.explicitWait(driver);
		companyPageUi.get_EmployeeName().click();
		Utilities.explicitWait(driver);
		String nameOnProfile=companyPageUi.get_NameOnProfile().getText();
		Assert.assertTrue(employeeName.equalsIgnoreCase(nameOnProfile), "Correct profile is not displayed");
		Utilities.explicitWait(driver);
		companyPageUi.get_stikLogo().click();
		Assert.assertTrue(isDisplayed(companyPageUi.get_stikEmployeePage()), "Stik Employee page not Found");
		homePageUi.get_meetTheTeam().click();
		Utilities.explicitWait(driver);
	}

	public String get_clickedCompanyName() {
		Utilities.explicitWait(driver);
		try{
			Assert.assertTrue(isDisplayed(companyPageUi.get_companySelectDropDown()), "Company drop down is missing!");
			companyPageUi.get_companyDropDownArrow().click();
			homePageUi.waitForElementToAppear(companyPageUi.get_companySearchTextBoxInDropDown());
			List<WebElement> comp = companyPageUi.get_companySelectDropDownList();
			int random=generateRandomNumber(1, comp.size()-1);
			String companyName= comp.get(random).getText();
			comp.get(random).click();
			return companyName;
		}
		catch(Exception ex){
			System.out.println("Company Drop Down Not Found");
			logger.error("Company Drop Down Not Found");
			return null;
		}
	}

	public String get_clickedState(){
		try{
			companyPageUi.get_stateDropDownArrow().click();
			homePageUi.waitForElementToAppear(companyPageUi.get_stateSearchTextBoxInDropDown());
			List<WebElement> stateList = companyPageUi.get_stateSelextDropDownList();
			int random=generateRandomNumber(1, stateList.size()-1);
			String stateName = stateList.get(random).getText();
			logger.info("statename :" + stateName);
			if(stateList.size()>1){
				stateList.get(random).click();
			}
			else{
				stateList.get(0).click();
			}
			return stateName;
		}catch(Exception ex){
			logger.error("State Drop Down Not Found");
			return "";
		}
	}

	public String get_clickedCity(){
		try{
			companyPageUi.get_cityDropDownArrow().click();
			homePageUi.waitForElementToAppear(companyPageUi.get_citySearchTextBoxInDropDown());
			List<WebElement> citylist=companyPageUi.get_citySelectDropDownList();
			String cityName=citylist.get(1).getText();
			logger.info("City found:-"+cityName);
			citylist.get(1).click();
			Utilities.explicitWait(driver);
			return cityName;
		}catch(Exception ex){
			logger.error("City Drop Down Not Found");
			return  "";
		}
	}
}
