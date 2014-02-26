package com.qait.automation.stik.actionfixtures;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qait.automation.stik.util.Utilities;

public class ProfessionalPageFixture extends FacebookAppFixture{

	public ProfessionalPageFixture() {
	}

	public boolean fillDetailsOnProfessionalPage(){
		Reporter.log("Filling Details on Professional Page....");
		homePageUi.waitForElementToAppear(professionalPageUi.get_startCollectingReviewButton());
		//professionalPageUi.waitFor(By.cssSelector(professionalPageUi.startCollectingReviews));
		Utilities.hardWait(2);

		professionalPageUi.get_selectorElement().click();
		professionalPageUi.get_IndustryTitle().click();
		professionalPageUi.get_phoneNumber().click();
		professionalPageUi.get_phoneNumber().clear();
		professionalPageUi.get_phoneNumber().sendKeys(util.getYamlValue("signup.phoneNo"));
		professionalPageUi.get_zipCode().clear();
		professionalPageUi.get_zipCode().sendKeys(util.getYamlValue("signup.zipcode"));
		professionalPageUi.get_start_collecting_reviews().click();
		return true;
	}
	
	public boolean navigateToProfessionalMailPage(boolean newUserFlag){
		
		Utilities.explicitWait(driver);
		if(!newUserFlag){driver.navigate().to(util.getYamlValue("appUrl")+"/professional");}
		
		try{
		professionalPageUi.get_gotItButtonOnPopup().click();
		}catch(ElementNotFoundException ex){
			System.out.println(" Got It Button not found...");
		}catch(ElementNotVisibleException e1){
			System.out.println(" Got It Button not found...");
		}catch(NoSuchElementException e2){
			System.out.println(" Got It Button not found...");
		}catch(Exception e3){
			System.out.println(" Got It Button not found...");
		}
		Utilities.explicitWait(driver);
		professionalPageUi.get_ContinueButton().click();
		
		
		try{
			professionalPageUi.get_continueAnyWay().click();
			}catch(ElementNotFoundException ex){
				System.out.println(" Continue Anyway Button not found...");
			}catch(ElementNotVisibleException e1){
				System.out.println(" Continue Anyway Button not found...");
			}catch(NoSuchElementException e2){
				System.out.println(" Continue Anyway Button not found...");
			}catch(Exception e3){
			System.out.println(" Got It Button not found...");
		}
		
		Utilities.explicitWait(driver);
		professionalPageUi.get_ContinueButton().click();
		try{
			professionalPageUi.get_continueAnyWay().click();
		}catch(ElementNotFoundException ex){
			System.out.println(" Continue Anyway Button not found...");
		}catch(ElementNotVisibleException e1){
			System.out.println(" Continue Anyway Button not found...");
		}catch(NoSuchElementException e2){
			System.out.println(" Continue Anyway Button not found...");
		}catch(Exception e3){
			System.out.println(" Got It Button not found...");
		}
		
		return true;
	}
	
	
	public boolean clickGmailButton(){
		return clickMailButton();
	}
	
	public boolean clickMailButton(){
		Utilities.explicitWait(driver);
		professionalPageUi.get_gmailButton().click();
		Utilities.hardWait(1);
		homePageUi.changeWindow(1);
		homePageUi.waitForElementToAppear(professionalPageUi.get_GmailLoginButton());
		professionalPageUi.get_GmailUserName().sendKeys(util.getYamlValue("mailPage.gmailUsername"));
		professionalPageUi.get_GmailPassword().sendKeys(util.getYamlValue("mailPage.gmailPassword"));
		professionalPageUi.get_GmailLoginButton().click();

		homePageUi.changeWindow(0);
		return true;
	}
	
	public boolean verifyGmailImport(){
		boolean flag=false;
		scrollDown(200);
		System.out.println("Verifying the Gmail Import");
		Reporter.log("Verifying If the records are imported properly...");
		Utilities.explicitWait(driver);
		String[] ymlnames = {util.getYamlValue("mailPage.verifyEmail1"), util.getYamlValue("mailPage.verifyEmail2"), util.getYamlValue("mailPage.verifyEmail3")};
		String[] yourNames = new String[professionalPageUi.get_yourEmailContactList().size()];
		
		if(professionalPageUi.get_yourEmailContactList().size()==0){
				Reporter.log("Number of contacts in Your Contact Section:- 0");
				Reporter.log("Not able to fetch any contact from Gmail");
				System.out.println("No Contacts fetched");
				return false;
		}else {
			System.out.println("Number of contacts fetched:- " +professionalPageUi.get_yourEmailContactList().size());
			yourNames=fillContactArray();
		}
		flag = compareArrays(ymlnames, yourNames);
		Reporter.log("Verified Names in YML and on webpage. Results: " + String.valueOf(flag));
		return flag;
		}
	    
	public String[] fillContactArray(){
		String yourName = "div>div[class='info']>div>div[class = 'name']";
		String[] contactNames=new String[professionalPageUi.get_yourEmailContactList().size()];
		for(int i=1;i<=professionalPageUi.get_yourEmailContactList().size();i++){
			contactNames[i-1]=professionalPageUi.get_yourEmailContactList().get(i-1).findElement(By.cssSelector(yourName)).getText();
			System.out.println("Contacts:- "+contactNames[i-1]);
		}
		return contactNames;
	}
		
	public boolean compareArrays(String[] ymlNames, String[] names){
		boolean flag = true;
		boolean sflag = true;
		for(int i=0;i<ymlNames.length;i++){
			
			for(int j=0;j<names.length;j++){
		
				if(ymlNames[i].toLowerCase().equals(names[j].toLowerCase())){
					
					flag = true; 
					break;
				}
				flag = false;
			}
			sflag = sflag && flag;
		}
		return sflag;
	}
	
}
