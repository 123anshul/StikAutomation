package com.qait.automation.stik.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ProfessionalPageUi extends BaseUi{

	public ProfessionalPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}


	@FindBy(css="div[class='large pulse facebook-button button fb-login login']")
	private WebElement selectContactsWithFacebookButton;
	
	@FindBy(css="a[class='fb-login login facebook-button large button']")
	private WebElement signUpWithFacebookButton;
	
	@FindBy(css="div[class='large pulse linkedin-button button li-login login']")
	private WebElement selectContactsWithLinkedInButton;
	
	@FindBy(css="a[class='li-login login linkedin-button large button']")
	private WebElement signUpWithLinkedInButton;
	
	@FindBy(css="a[class='large pulse facebook-button button fb-login login']")
	private WebElement signUpWithFacebookButton2;
	
	@FindBy(css="a[class='large pulse linkedin-button button li-login login']")
	private WebElement signUpWithLinkedInButton2;
	
	@FindBy(css="a[class='fb-login medium pulse facebook-button button']")
	private WebElement signUpWithFacebookButton3;
	
	@FindBy(css="a[class='li-login medium pulse linkedin-button button']")
	private WebElement signUpWithLinkedInButton3;
	
	@FindBy(css="div[class='medium pulse facebook-button button fb-login login']")
	private WebElement signUpWithFacebookButton4;
	
	
	
	// Currently used Sign up buttons- Working for all the different Sign up pages
	
	@FindBy(xpath=".//div[contains(text(),'Connect with Facebook')]")
	private WebElement signUpButtonForFacebook;
	
	@FindBy(xpath=".//div[contains(text(),'Connect with LinkedIn')]")
	private WebElement signUpButtonForLinkedin;
	
	
	@FindBy(xpath=".//div[contains(text(),'Apply with Facebook')]")
	private WebElement applyWithFacebookButton;
	
	@FindBy(xpath=".//div[contains(text(),'Apply with LinkedIn')]")
	private WebElement applyWithLinkedInButton;
	
	
	// Sign Up screen with Text Boxes and Apply button
	@FindBy(xpath="//div[@id='signUp']/form/input[1]")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//div[@id='signUp']/form/input[2]")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//div[@id='signUp']/form/button")
	private WebElement applyButton;
	
	@FindBy(xpath="//div[@class='ui-omnibar']/div/input")
	private WebElement emailImporterTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement continueButtonOnEmailImporter;
	
	
	
	
	//JobTitle dropdown
	@FindBy(css = "input[name = 'vch_title']")
	private WebElement jobTitle;
	
	@FindBy(css = "input[name = 'vch_company']")
	private WebElement companyName;
	
	//zip Code input box
	@FindBy(css = "input[name= 'vch_zip']")
	private WebElement zipCode;
	
	//phone number input box
	@FindBy(css = "input[name = 'vch_phone_full']")
	private WebElement phoneNumber;
	
	public String startCollectingReviews = ".js-start-picker.medium.button";
	@FindBy(css=".js-start-picker.medium.button")
	private WebElement startCollectingReviewButton;
	
	@FindBy(css = "a[class = 'selector']")
	private WebElement selectorElement;
	
	String sizzleCssIndustryTitle = "li:contains('indexText')";
	
	@FindBy(css = "div[class = 'custom dropdown']>ul>li:nth-child(4) ")
	private WebElement industry;
	
	@FindBy(css="div[class = 'custom dropdown open']>ul>li")
	private List<WebElement> industryList;
	
	@FindBy(css = "a[id = 'next']")
	private WebElement continueButton;
	
	@FindBy(css = "div[id = 'advanceAnywayButton']")
	private WebElement continueAnyWay;
	
	@FindBy(css = "a[source = 'gmail']")
	private WebElement gmailButton;
	
	
	@FindBy(css = "input[id = 'Email']")
	private WebElement gmailEmail;
	
	@FindBy(css = "input[id = 'Passwd']")
	private WebElement gmailPassword;
	
	@FindBy(css = "input[id = 'signIn']")
	private WebElement gmailLoginButton;
	
	@FindBy(css = "input[id = 'allow']")
	private WebElement gmailAllowButton;
	
	@FindBy(css="button[id='submit_approve_access']")
	private WebElement gmailAllowAccessButton;
	
	@FindBy(css="div[class='ui-tour tour-introduction']>div[class='hide-medium-down']>a[class='button orange dismiss-tour']")
	private WebElement gotItButtonOnPopup;
	
	
	@FindBy(css="div[id='facebookPanel']>div[class='contact-group-container']>div[class='contact-group']")
	private List<WebElement> visibleContactsOnFBPanel;
	
	
	@FindBy(css="div[id='editMessageModal']")
	private WebElement messageModalDialog;
	
	@FindBy(css="div[class='panel success ui-alert inline']>h5[class='title']")
	private WebElement successMessage;
	
	@FindBy(css="a[class='js-start-picker medium orange button create-my-profile']")
	private WebElement createMyProfileButton;
	
	@FindBy(css="div[id='importEmail']>div[class='individual-importer']>div[class='fields']>div>input[name='vch_email']")
	private WebElement emailFieldOnImportSection;
	
	@FindBy(css="div[id='importEmail']>div[class='individual-importer']>div[class='fields']>div>input[name='vch_first_name']")
	private WebElement firstNameOnImportSection;
	
	@FindBy(css="div[id='importEmail']>div[class='individual-importer']>div[class='fields']>div>input[name='vch_last_name']")
	private WebElement lastNameOnImportedSection;
	
	@FindBy(css="div[id='importEmail']>div[class='individual-importer']>div[class='import clearfix']>div")
	private WebElement importButton;
	
	@FindBy(css="div[id='mailPanel']>div[id='emailContacts']>div[class='contact-group-container']>div[class='contact-group']>ul[class='high-value suggested unsolicited contact-container']>li")
	private WebElement yourEmailContactListForNewUser;
	
	@FindBy(css="div[id='selectedCounter']>div[class='selected has-tip']>div>span")
	private WebElement counterForPeopleSelected;
	
	@FindBy(css="div[id='mailPanel']>div[id='emailContacts']>div[class='contact-group-container']>div[class='contact-group']>ul[class='high-value suggested unsolicited contact-container']>li>div[class='card back inactive']>div")
	private WebElement counterAtBackofContact;
	
	@FindBy(css="div[class='hide-medium-down']>div[class='ui-challenge-meter']>div[class='ui-meter']>div[class='progress']")
	private WebElement progressMeter;
	
	@FindBy(css="div[class='hide-medium-down']>div[class='ui-challenge-meter']")
	private WebElement uiMeterSection;
	
	
	String nameOfVisibleFBContacts="div[class='clearfix']>div[class='text']>h3[class='title']";
	String selectContactFromVisibleFBContacts="ul>li";
	String textAreaInMessageBox="form>textarea";
	String doneButtonOnMessageBox="a[class='close-modal button right js-send-message']";
	
	
	/*************************EMail Panel UI Elements***********************************/
	String yourEmailContactList = "div[id='emailContacts']>div[class='contact-group-container']>div[class='contact-group']>ul[class = 'high-value suggested unsolicited contact-container']>li";
	String requestedEmailContactList="div[id='mailPanel']>div[id='emailContacts']>div[class='contact-group-container']>div[class='contact-group']>ul[class = 'requested contact-container']>li";
	String yourName = "div>div[class='info']>div>div[class = 'name']";
	String requestedName="div[id='mailPanel']>div[id='emailContacts']>div[class='contact-group-container']>div[class='contact-group']>ul[class = 'requested contact-container']>li:nth-child(index)>div>div>div>div[class = 'name']";
	

	/****************Getter Methods for UI Elements***********************/
	public WebElement get_selectContactsWithFacebookButton(){
		return selectContactsWithFacebookButton;
	}
	
	public WebElement get_signUpWithFacebookButton(){
		return signUpWithFacebookButton;
	}
	
	public WebElement get_selectContactsWithLinkedInButton(){
		return selectContactsWithLinkedInButton;
	}
	
	public WebElement get_signUpWithLinkedInButton(){
		return signUpWithLinkedInButton;	
	}
	
	public WebElement get_signUpWithFacebookButton2(){
		return signUpWithFacebookButton2;
	}
	
	public WebElement get_signUpWithFacebookButton4(){
		return signUpWithFacebookButton4;
	}
	
	public WebElement get_signUpWithLinkedInButton2(){
		return signUpWithLinkedInButton2;
	}
	
	public WebElement get_signUpWithFacebookButton3(){
		return signUpWithFacebookButton3;
	}
	
	public WebElement get_signUpWithLinkedInButton3(){
		return signUpWithLinkedInButton3;
	}
	
	public WebElement get_gotItButtonOnPopup(){
		return gotItButtonOnPopup;
	}
	
	public WebElement get_IndustryTitle(){
		return industry;
	}
	
	public WebElement get_jobTitle() {
		return jobTitle;
	}
	
	public WebElement get_zipCode(){
		return zipCode;
	}
	
	public WebElement get_phoneNumber(){
		return phoneNumber;
	}
	
	public WebElement get_companyName(){
		return companyName;
	}
	
	public WebElement get_start_collecting_reviews(){
		return driver.findElement(By.cssSelector(startCollectingReviews));
	}
	
	public WebElement get_selectorElement(){
		return selectorElement;
	}
	
	public WebElement get_ContinueButton(){
		return continueButton;
	}
	
	public WebElement get_continueAnyWay(){
		return continueAnyWay;
	}
	
	public WebElement get_gmailButton(){
		return gmailButton;
	}
	
	public WebElement get_GmailLoginButton(){
		return gmailLoginButton;
	}
	
	public WebElement get_GmailUserName(){
		return gmailEmail;
	}
	
	public WebElement get_GmailPassword(){
		return gmailPassword;
	}
	
	public WebElement get_GmailAllowButton(){
		return gmailAllowButton;
	}
	
	public WebElement get_gmailAllowAccessButton(){
		return gmailAllowAccessButton;
	}
	
	
	public List<WebElement> get_yourEmailContactList(){
		return driver.findElements(By.cssSelector(yourEmailContactList));
	}
	
	public int get_requestedEmailContactList(){
		return driver.findElements(By.cssSelector(requestedEmailContactList)).size();
	}
	
	public String get_yourName(int index){
		return driver.findElement(By.cssSelector(yourName.replaceAll("index", String.valueOf(index)))).getText();
	}
	
	public String get_requestedName(int index){
		return driver.findElement(By.cssSelector(requestedName.replaceAll("index", String.valueOf(index)))).getText();
	}
	
	public WebElement get_startCollectingReviewButton(){
		return startCollectingReviewButton;
	}
	
	public List<WebElement> get_visibleContactsOnFBPanel(){
		return visibleContactsOnFBPanel;
	}
	
	public WebElement get_nameOfVisibleFBContacts(int index){
		return get_visibleContactsOnFBPanel().get(index).findElement(By.cssSelector(nameOfVisibleFBContacts));
	}
	
	public WebElement get_selectContactFromVisibleFBContacts(int index){
		return get_visibleContactsOnFBPanel().get(index).findElement(By.cssSelector(selectContactFromVisibleFBContacts));
	}
	
	public WebElement get_messageModalDialog(){
		return messageModalDialog;
	}
	
	public WebElement get_textAreaInMessageBox(){
		return get_messageModalDialog().findElement(By.cssSelector(textAreaInMessageBox));
	}
	
	public WebElement get_doneButtonOnMessageBox(){
		return get_messageModalDialog().findElement(By.cssSelector(doneButtonOnMessageBox));
	}
	
	public WebElement get_successMessage(){
		return successMessage;
	}
	
	public WebElement get_createMyProfileButton(){
		return createMyProfileButton;
	}
	
	public WebElement get_emailFieldOnImportSection(){
		return emailFieldOnImportSection;
	}
	public WebElement get_firstNameOnImportSection(){
		return firstNameOnImportSection;
	}
	
	public WebElement get_lastNameOnImportedSection(){
		return lastNameOnImportedSection;
	}
	
	public WebElement get_importButton(){
		return importButton;
	}
	public WebElement get_yourEmailContactListForNewUser(){
		return yourEmailContactListForNewUser;
	}
	
	public int get_counterForPeopleSelected(){
		try{
		return Integer.parseInt(counterForPeopleSelected.getText());
		}catch(NumberFormatException ne){
			System.out.println("Enmpty String returned from number of People Selected");
			return -1;
		}
	}
	
	public int get_counterAtBackofContact(){
		return Integer.parseInt(counterAtBackofContact.getText());
	}
	
	public WebElement get_uiProgressMeter(){
		return progressMeter;
	}
	public List<WebElement> get_industryList(){
		return industryList;
	}
	
	public WebElement get_uiMeterSection(){
		return uiMeterSection;
	}
	
	public WebElement get_signUpButtonForFacebook(){
		return signUpButtonForFacebook;
	}
	
	public WebElement get_signUpButtonForLinkedin(){
		return signUpButtonForLinkedin;
	}
	
	public WebElement get_nameTextBox(){
		return nameTextBox;
	}
	
	public WebElement get_emailTextBox(){
		return emailTextBox;
	}
	
	public WebElement get_applyButton(){
		return applyButton;
	}
	
	public WebElement get_emailImporterTextBox(){
		return emailImporterTextBox;
	}
	
	public WebElement get_continueButtonOnEmailImporter(){
		return continueButtonOnEmailImporter;
	}
	
	public WebElement get_applyWithFacebookButton(){
		return applyWithFacebookButton;
	}
	
	public WebElement get_applyWithLinkedInButton(){
		return applyWithLinkedInButton;
	}
}
