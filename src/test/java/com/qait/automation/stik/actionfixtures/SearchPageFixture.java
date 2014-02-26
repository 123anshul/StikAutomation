package com.qait.automation.stik.actionfixtures;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qait.automation.stik.util.Utilities;


public class SearchPageFixture extends DirectoryPageFixture{
	
		
		
	public void clickSearchBox(){
		
		Assert.assertTrue(searchPageUi.get_SearchBox().isDisplayed());
		searchPageUi.get_SearchBox().click();
		searchPageUi.executeJavaScript("document.getElementsByClassName('CSearchAutocomplete-results')[0].setAttribute('style','display: block; width: 564px;');");
	}
	
	public void select_from_Suggested_Searches(String searchTerm){
		List<WebElement> values = searchPageUi.get_Suggested_Elements();
		
		for (WebElement value : values){
			System.out.println("One: "+value.getText());
			if(value.getText().toLowerCase().contains(searchTerm.toLowerCase())){
				value.click();
				Utilities.hardWait(6);
				searchPageUi.waitFor(By.cssSelector("div[id='results_container'] div[class='highlightable']"));
				//searchPageUi.waitForTextToAppear("css", "div[id='localControl']>div[class = 'control-header']", "Local Results");
				break;
			}
		}
		searchPageUi.close_ModalDialogBox();
	}
	
	public boolean verifySearchResults(String searchTerm){
		Utilities.hardWait(6);
		List<WebElement> values = searchPageUi.get_SearchResults();
		for (WebElement value : values){
			System.out.println("Search Results: "+value.getText());
			if(value.getText().contains(searchTerm))
				return true;
		}
		return false;
	}
	
}
