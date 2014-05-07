package com.qait.automation.stik.actionfixtures;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotVisibleException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qait.automation.stik.util.Utilities;

//comment
public class ClientsPageFixture extends SearchPageFixture{

	public boolean navigateToClientsMailPage(){
		Utilities.explicitWait(driver);
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
		//method called tpo follow the /professional workflow but now it has been replaced with /demo so modified the test.		
//		homePageUi.get_stiklogoOnProfessionalPage().click();
//		homePageUi.handleAlert();
//		Utilities.explicitWait(driver);
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_collectReviewsLink());
		Utilities.explicitWait(driver);
		clientsPageUi.get_mailContactsButton().click();
		return true;
	}

}
