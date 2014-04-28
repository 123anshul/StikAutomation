package com.qait.automation.stik.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ReviewPageUi extends BaseUi{

	public ReviewPageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}
	
	/******** Facebook UI elements ********/
	@FindBy(css = "div[class='seven columns'] h2")
	private WebElement profilePageHeading;
	
//	@FindBy(css = "div[class = 'review-box'] textarea")
//	private WebElement textAreaBox;
	
	@FindBy(xpath = "//div[@class='review-box']/textarea")
	private WebElement textAreaBox;
	
	@FindBy(xpath = "li>textarea")
	private WebElement textAreaForInlineReview;
	
	
	@FindBy(css = ".next.large.orange.button.to-verification")
	private WebElement leaveReviewButton;
	
	@FindBy(css = "a[class = 'large facebook-button button authenticate-with-facebook']")
	private WebElement faceBookButton;
	
	@FindBy(css="li[class='middle']>div")
	private WebElement facebookButtonForLineReview;
	
	//@FindBy(css = ".large.secondary.button")
	//private WebElement navigateBackToProfile;
	
	@FindBy(css = ".next.large.orange.button.to-verification")
	private WebElement leaveRatingButton;
	
	@FindBy(css = "span[class = 'avatar']")
	private WebElement avatarIcon;
	
	/***************************Recommend Section- Step 3****************/
	
	@FindBy(css="div[id='kahnReferrals']>div[id='question']>h1")
	private WebElement recommendText;
	
	@FindBy(css="div[id='kahnButtons']>div[class='buttons']>a")
	private List<WebElement> recommendYesAndNoButtons;
	
	@FindBy(css="a[class='button short xxlarge success btn-yes']")
	private WebElement recommendYesButton;

	@FindBy(css="div[id='kahnReferrals']>div[id='question']>div>div:nth-child(2)")
	private WebElement recommendNoButton;
	
	@FindBy(css="div[class='ui-email-importer']>div[class='ui-omnibar']>div[class='inline-field']>input")
	private WebElement recommendEmailTextArea;
	
	@FindBy(id="btn-omnibar-submit")
	private WebElement recommendAddEmailButton;
	
	@FindBy(id="skip")
	private WebElement recommendSkipButton;
	
	@FindBy(id="continue")
	private WebElement recommendContinueButton;
	
	@FindBy(css="div[id='kahnReferrals']>div[id='kahnEmailImporter']>div[class='continue-wrapper']>div[class='copy-me-wrapper']>input")
	private WebElement recommendCopyMeCheckbox;
	
	@FindBy(css="div[id='thanks']>div[class='panel']>div[class='secondary button']")
	private WebElement recommendGoBackButton;

	@FindBy(css="div[id='thanks']>div[class='panel']>h3")
	private WebElement recommendThanksPanel;
	
	@FindBy(css="div[id='savedEmailsPool']>div>div>div[class='email']")
	private List<WebElement> recommendSavedEmailContacts;
	
	@FindBy(css="div[class='ui-email-importer']>div:nth-child(4)")
	private WebElement progressMeter;
	
	@FindBy(css="div[id='thanks']>div[class='posted-wrapper']>div[class='kahn-review']>div>div>div>div[class='main']")
	private WebElement reviewOnThanksPage;
	
	@FindBy(css="ul[class='stars']>li")
	private List<WebElement> starsOnRecommendPage;
	
	@FindBy(xpath=".//*[@id='rating-stars-container']/div[1]/i[1]")
	private WebElement fifthStarOnInlineModal;
	
	
	String dateField = "(//div[@id = 'reviewsContainer']/div)[index]//div[@itemprop='datePublished']";
	String starXPath = "ul[class='stars']>li:nth-child(index)";
	String reviewText = "(//div[@id = 'reviewsContainer']/div)[index]//div[@class='main']/p[@itemprop='reviewBody']";
	String reviewCount = "div[class = 'js-reviews-container']>div>div";
	String starCount = "(//div[@id = 'reviewsContainer']/div)[index]//div[@class='main']//div[@class='rating']/div[@class='star-container']/i[@class='icon-star']";
	String selectorClassName = "selector";
	
	@FindBy(css="div[id='reviewerDetails']")
	private WebElement recommendReviewerSection;
	
	@FindBy(css="div[id='thanksAnyway']>div>h3")
	private WebElement thankPageText;
	
	@FindBy(css="div[id='reviewerDetails']>div>div[class='email']")
	private WebElement recommendEmailOfReviewer;
	
	@FindBy(css="div[id='reviewerDetails']>div>div[class='name']")
	private WebElement recommendNameOfReviewer;
	
	/******************************************Refer Page UI**********************************************/
	
	@FindBy(css="div[id='emailImporter']>h2")
	private WebElement reviewMessage;

	
	@FindBy(css="div[id='emailImporter']>div[class='text-center']>a")
	private WebElement spreadTheWordButton;
	
	@FindBy(css="div[class='profile-info']>div[class='name']")
	private WebElement profileName;
	
	@FindBy(css="div[class='why']>h2")
	private WebElement yesOrNoPageText;
	
	
	@FindBy(xpath=".//*[@id='thanks']/a")
	private WebElement signUpOnThanksPage;
	
	@FindBy(css="div[id='rating-stars-container']>div[class='star-container']>i")
	private List<WebElement> listofStarForInlineReview;
	
	@FindBy(css="li>textarea")
	private WebElement textAreaBoxForInlineReview;
	
	@FindBy(css="section[id='inlineReviewManagerReview']")
	private WebElement inlineReviewModal;
	
			
			
	@FindBy(css="section[id='inlineReviewManagerReview']>div>footer>div>button")
	private WebElement continueButtonForInlineReview;
	
	@FindBy(css="h1[class='title']")
	private WebElement successMessageForInlineReview;
	
	@FindBy(css="div[class='container']>div[class='review']")
	private WebElement reviewerDetailsSectionInlineReview;
	
	@FindBy(css="a[data-would-refer='yes']")
	private WebElement yesButtonForInlineReview;
	
	@FindBy(xpath=".//*[@id='inlineReviewManagerConfirmation']/div/footer/div/div[2]/a[1]")
	private WebElement noButtonForInlineReview;
	
	@FindBy(css=".ui-verification>div>div>.instructions>h1")
	private WebElement uiVerificationHeading;
	
	@FindBy(css = ".large.facebook-button.button.fb-login.login")
	private WebElement uiVerificationFacebookButton;
	
	@FindBy(css = ".large.button.continue")
	private WebElement uiVerificationContinueButton;
	
	@FindBy(css = ".explanation>a")
	private WebElement uiVerificationIdentityLink;
	
	@FindBy(css = ".explanation>p")
	private WebElement uiVerificationIdentityText;
	
	@FindBy(css = ".privacy-instructions>a")
	private WebElement uiVerificationTermsOfUseLink;
	
	@FindBy(css = ".row>p>a")
	private WebElement contactUsLinkOnTermsOfUsePage;
	
	@FindBy(css = ".row>h1")
	private WebElement termsOfUseWindowHeading;
	
	@FindBy(css=".large.facebook-button.button.authenticate-with-facebook")
	private WebElement recommendPageFacebookButton;
	
	@FindBy(css=".current.step-2")
	private WebElement recommendPageVerifyYourReviewText;
	
	@FindBy(css=".twelve.columns>h1")
	private WebElement recommendPageHeading;
	
	@FindBy(css=".large.button.btn-continue")
	private WebElement recommendPageContinueButton;
	
	private String firstNameOfSavedEmail="div[id='savedEmailsPool']>div:nth-child(index)>div[class='staged-email editable']>div[class='fields']>input[name='first_name']";
	private String secondNameofSavedEmail="div[id='savedEmailsPool']>div:nth-child(index)>div[class='staged-email editable']>div[class='fields']>input[name='last_name']";
	private String phoneNumberofSavedEmail="div[id='savedEmailsPool']>div:nth-child(index)>div[class='staged-email editable']>div[class='fields']>input[name='phone']";
	private String doneButton="div[id='savedEmailsPool']>div:nth-child(index)>div[class='staged-email editable']>div[class='fields']>a";
	private String starForInlineReview="div[id='rating-stars-container']>div[class='star-container']>i:nth-child(index)";
	
	public WebElement get_firstNameOfSavedEmail(int index){
		return driver.findElement(By.cssSelector(firstNameOfSavedEmail.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_secondNameofSavedEmail(int index){
		return driver.findElement(By.cssSelector(secondNameofSavedEmail.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_phoneNumberofSavedEmail(int index){
		return driver.findElement(By.cssSelector(phoneNumberofSavedEmail.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_doneButton(int index){
		return driver.findElement(By.cssSelector(doneButton.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_signUpOnThanksPage(){
		return signUpOnThanksPage;
	}
	
	public WebElement get_thankPageText(){
		return thankPageText;
	}
	
	
	/************ Getter Methods to get WEB Elements ************************/
	public WebElement get_profilePageHeading(){
		return profilePageHeading;
	}
	
	public int count_starsOnRecommendPage(){
		return starsOnRecommendPage.size();
	}
	
	public WebElement get_starXPath(int index){
		return driver.findElement(By.cssSelector(starXPath.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_textAreaBox(){
		return textAreaBox;
	}
	
	public WebElement get_continueButtonForRecommend(){
		return leaveReviewButton;
	}
	
	public WebElement get_faceBookButton(){
		return faceBookButton;
	}
	
	public WebElement get_facebookButtonForInlineReview(){
		return facebookButtonForLineReview;
	}
	

	public WebElement get_avatarIcon(){
		return avatarIcon;
	}
	
	public int get_reviewCount(){
		return driver.findElements(By.cssSelector(reviewCount)).size();
	}
	
	public int get_starCount(int index){
		return driver.findElements(By.xpath(starCount.replaceAll("index", String.valueOf(index)))).size();
	}
	
	public WebElement get_reviewText(int index){
		return driver.findElement(By.xpath(reviewText.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_leaveRatingButton(){
		return leaveRatingButton;
	}
	
	public WebElement get_dateField(int index){
		return driver.findElement(By.xpath(dateField.replaceAll("index", String.valueOf(index))));
	}
		
	public void click_NewestSelector(){
		executeJavaScript("document.getElementsByClassName('custom dropdown')[0].children[2].children[1].click()");
	}
	
	public void click_OldestSelector(){
		executeJavaScript("document.getElementsByClassName('custom dropdown')[0].children[2].children[2].click()");
	}
	
	public WebElement get_recommendYesButton(){
		return recommendYesButton;
	}
	
	public WebElement get_recommendNoButton(){
		return recommendNoButton;
	}
	
	public WebElement get_recommendEmailTextArea(){
		return recommendEmailTextArea;
	}
	
	public WebElement get_recommendSkipButton(){
		return recommendSkipButton;
	}
	public WebElement get_recommendContinueButton(){
		return recommendContinueButton;
	}
	
	public WebElement get_recommendCopyMeCheckbox(){
		return recommendCopyMeCheckbox;
	}
	
	public WebElement get_recommendGoBackButton(){
		return recommendGoBackButton;
	}

	
	public WebElement get_recommendText(){
		return recommendText;
	}
	
	public WebElement get_recommendAddEmailButton(){
		return recommendAddEmailButton;
	}
	
	public List<WebElement> get_recommendSavedEmailContacts(){
		return recommendSavedEmailContacts;
	}
	
	public WebElement get_progressMeter(){
		return progressMeter;
	}
	
	public WebElement get_recommendThanksPanel(){
		return recommendThanksPanel;
	}
	public WebElement get_reviewOnThanksPage(){
		return reviewOnThanksPage;
	}
	
	public WebElement get_spreadTheWordButton(){
		return spreadTheWordButton;
	}
	
	public WebElement get_reviewMessage(){
		return reviewMessage;
	}
	
	public WebElement get_profileName(){
		return profileName;
	}
	
	public WebElement get_yesOrNoPageText(){
		return yesOrNoPageText;
	}
	
	public List<WebElement> get_recommendYesAndNoButtons(){
		return recommendYesAndNoButtons;
	}
	
	public WebElement get_recommendReviewerSection(){
		return recommendReviewerSection;
	}
	
	public WebElement get_recommendEmailOfReviewer(){
		return recommendEmailOfReviewer;
	}
	
	public WebElement get_recommendNameOfReviewer(){
		return recommendNameOfReviewer;
	}
	
	public WebElement get_starForInlineReview(int index){
		return driver.findElement(By.cssSelector(starForInlineReview.replaceAll("index", String.valueOf(index))));
	}
	
	public int count_starsOnInlineReviewPage(){
		return listofStarForInlineReview.size();
	}
	
	public WebElement get_textAreaBoxForInlineReview(){
		return textAreaBoxForInlineReview;
	}
	
	public WebElement get_continueButtonForInlineReview(){
		return continueButtonForInlineReview;
	}
	
	public WebElement get_successMessageForInlineReview(){
		return successMessageForInlineReview;
	}
	
	public WebElement get_reviewerDetailsSectionInlineReview(){
		return reviewerDetailsSectionInlineReview;
	}
	
	public WebElement get_yesButtonForInlineReview(){
		return yesButtonForInlineReview;
	}
	
	public WebElement get_noButtonForInlineReview(){
		return noButtonForInlineReview;
	}
	
	public WebElement get_inlineReviewModal(){
		return inlineReviewModal;
	}
	
	public WebElement get_fifthStarOnInlineModal(){
		return fifthStarOnInlineModal;
	}
	
	public WebElement get_uiVerificationHeading(){
		return uiVerificationHeading;
	}
	
	public WebElement get_uiVerificationFacebookButton(){
		return uiVerificationFacebookButton;
	}
	
	public WebElement get_uiVerificationIdentityLink(){
		return uiVerificationIdentityLink;
	}
	
	public WebElement get_uiVerificationTermsOfUseLink(){
		return uiVerificationTermsOfUseLink;
	}
	
	public WebElement get_contactUsLinkOnTermsOfUsePage(){
		return contactUsLinkOnTermsOfUsePage;
	}
	
	public WebElement get_termsOfUseWindowHeading(){
		return termsOfUseWindowHeading;
	}
	
	public WebElement get_uiVerificationIdentityText(){
		return uiVerificationIdentityText;
	}
	
	public WebElement get_uiVerificationContinueButton(){
		return uiVerificationContinueButton;
	}
	
	public WebElement get_recommendPageFacebookButton(){
		return recommendPageFacebookButton;
	}
	
	public WebElement get_recommendPageVerifyYourReviewText(){
		return recommendPageVerifyYourReviewText;
	}
	
	public WebElement get_recommendPageHeading(){
		return recommendPageHeading;
	}
	
	public WebElement get_recommendPageContinueButton(){
		return recommendPageContinueButton;
	}
}
