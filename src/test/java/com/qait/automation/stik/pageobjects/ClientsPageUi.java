package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ClientsPageUi extends BaseUi{

	public ClientsPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	//Email Contacts button
	@FindBy(css = ".email.js-network-nav.js-mail")
	private WebElement mailContactsButton;
	
	public WebElement get_mailContactsButton(){
		return mailContactsButton;
	}

}
