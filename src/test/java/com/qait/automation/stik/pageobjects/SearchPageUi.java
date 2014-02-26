package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class SearchPageUi extends BaseUi{

	public SearchPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	String suggestedList = "div[class = 'suggestion']";
	
	/*****************WEB UI defined *****************************/
	//SignUp Link
	@FindBy(css = "form[id = 'searchboxContainer']>input")
	private WebElement searchBox;
	
	
	public WebElement get_SearchBox(){
		return (searchBox);
	}
	
	public List<WebElement> get_Suggested_Elements(){
		return driver.findElements(By.cssSelector(suggestedList));
	}
	
	public void close_ModalDialogBox(){
		executeJavaScript("document.getElementsByClassName('close-reveal-modal')[0].click()");
	}
	
	public List<WebElement> get_SearchResults(){
		return driver.findElements(By.cssSelector("div[id= 'results_container']>div h3"));
	}
	
}
