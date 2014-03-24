package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class EmailSignUpUi extends BaseUi{

	public EmailSignUpUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

//Webelements for Email signUp feature
	@FindBy(xpath=".//*[@id='csvUsersData']")
	private WebElement csvUserData;
	
	@FindBy(xpath = ".//*[@id='csvPicturesData']")
	private WebElement csvPictureData;
	
	@FindBy(xpath =".//*[@id='admin']/h3")
	private WebElement emailHeading;

	@FindBy(xpath = ".//*[@id='csvImport']")
	private WebElement importButton;
	
	@FindBy(xpath=".//*[@id='data']")
	private WebElement importData;
	
	public WebElement getImportData() {
		return importData;
	}

	public WebElement getImportButton() {
		return importButton;
	}

	public WebElement getEmailHeading() {
		return emailHeading;
	}

	public WebElement getCsvUserData() {
		return csvUserData;
	}

	public WebElement getCsvPictureData() {
		return csvPictureData;
	}
}
