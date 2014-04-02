package com.qait.automation.stik.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

/**
 * <b>Class: HomePageUi</b>
 * <p>
 * HomePageUi Contains Home Page UI elements and their getter methods.
 * 
 * @author      QAIT
 * @see			#BaseUi
 */
public class HomePageUi extends BaseUi {

	public HomePageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	/*****************WEB UI defined *****************************/
	
	//SignUp Link
	@FindBy(css = "ul[class='right js-header-right']>li>a[class='signup-button orange button']")
	private WebElement joinForFree;
	
	//loginLink Link on stik home page
	@FindBy(css = "ul[class = 'right js-header-right']>li a[class = 'login-button secondary button']")
	private WebElement loginLink;
	
	//Already signed up with Facebook and Linked In link
	@FindBy(xpath= ".//*[@id='emailLogin']/footer/p/a")
	private WebElement alreadySignUpLink;
	
	//Facebook link after clicking on already signup link
	@FindBy(css=".fb-login.button.small.secondary.login-link")
	private WebElement facebookLinkOnLoginPage;
	
	//LinkedIn link after clicking on already signup link
	@FindBy(css=".li-login.button.small.secondary.login-link")
	private WebElement linkedInLinkOnLoginPage;
	
	@FindBy(css = "div[id ='jsLoginDropdown'] a[class = 'facebook-button button fb-login']")
	private WebElement facebookPicLink;
	
	@FindBy(css="div[id ='jsLoginDropdown'] a[class = 'linkedin-button button li-login']")
	private WebElement linkedInLoginButton;
	
	
	//logout link on stik home page
	@FindBy(css = "a[id = 'logout']")
	private WebElement logoutLink;
	
	@FindBy(css = "div[class='splash-section']>div>div>div:nth-child(3)>div>a[class='button large orange']")
	private WebElement getStartedButton;
	
//	//logout link on stik home page
//	@FindBy(linkText = "Log Out ")
//	private WebElement logoutLink;
	
	@FindBy(css= "a[href$='/zf/profile/settings#accountInformation']")
	private WebElement profileInfoLink;
	
	//dropdown link on stik home page
	@FindBy(css= "li[class = 'has-dropdown account']>a[class='name']")
	private WebElement dropDown;
	
	//view profile link on nav page
	@FindBy(css= "ul[class = 'dropdown']>li>a[href$='/profile.html']")
	private WebElement viewProfileLink;
	
	@FindBy(css="ul[class='dropdown']>li>a[href='/referrals']")
	private WebElement referralLink;
	
	@FindBy(css="ul[class = 'dropdown']>li>a[href$='/emails']")
	private WebElement inYourEmail;
	
	@FindBy(css="ul[class = 'dropdown']>li>a[href$='/widgets']")
	private WebElement onYourWebsite;
	
	@FindBy(css="ul[class = 'dropdown']>li>a[href$='/facebook-page']")
	private WebElement onFacebookPage;
	
	@FindBy(css="ul[class = 'dropdown']>li>a[href$='/facebook-profile']")
	private WebElement onFacebookProfile;
		
	@FindBy(css = "span[id='firstName']")
	private WebElement firstName;
	
	@FindBy(css = "ul[class = 'left js-header-left']>li>a[href = '/professional']")
	private WebElement collectReviews;
	
	@FindBy(css = "li>a[href='/clients']")
	private WebElement collectReviewsLink;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(2)>a")
	private WebElement howItWorksLink;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(3)>a")
	private WebElement marketingLink;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(3)>a")
	private WebElement pricingLink;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(2)>a")
	private WebElement findAProfessional;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(2)>a")
	private WebElement enterPrise;
	
	@FindBy(xpath=".//*[@id='header']/div/nav/section/ul[4]/li[1]/a")
	private WebElement forLocalBusinessLink;
	
	@FindBy(xpath=".//*[@id='header']/div/nav/section/ul[4]/li[2]/a")
	private WebElement forEnterpriseLink;
	
	/**************** Showcase Review Drop down  ***************************/
	
	@FindBy(css = "ul[class='left js-header-left']>li:nth-child(1)>a")
	private WebElement showCaseReviews;
	
	@FindBy(css= "ul[class = 'dropdown']>li>a[href = '/emails']")
	private WebElement inYourEmailLink;
	
	@FindBy(css= "ul[class = 'dropdown']>li>a[href='/widgets']")
	private WebElement onYourWebSiteLink;
	
	@FindBy(css="ul[class= 'dropdown']>li>a[href='/facebook-page']")
	private WebElement onYourFacebookPage;	
	
	@FindBy(css="ul[class='dropdown']>li>a[href='/facebook-profile']")
	private WebElement onYourFacebookProfile;
	
	
	@FindBy(css = "form[id = 'searchboxContainer']")
	private WebElement formSearchBox;
	
	@FindBy(css = "li[class = 'current']")
	private WebElement whatIsStik;
	
	@FindBy(css = "a[href ='/how-stik-works']")
	private WebElement howItWorks;
	
	@FindBy(css="ul[class='left js-header-left']>li:nth-child(1)>a")
	private WebElement forBusinessLink;
	
	@FindBy(css = "a[href ='/stand-out-online']")
	private WebElement standOutOnline;
	
	@FindBy(css = "a[href = '/company/stik']")
	private WebElement meetTheTeam;
	
	@FindBy(css = "a[href = '/contact']")
	private WebElement contactUs;
	
	@FindBy(css = "a[href = '/faq']")
	private WebElement FAQ;
		
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(2)>a:nth-child(1)")
	private WebElement realEstate;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(2)>a:nth-child(2)")
	private WebElement mortgage;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(2)>a:nth-child(3)")
	private WebElement insurance;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(3)>a:nth-child(1)")
	private WebElement healthAndWellness;
	
	@FindBy(css = "h6>a[href = '/directory']")
	private WebElement findProfessionalInYourArea;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(3)>a:nth-child(2)")
	private WebElement lawyers;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(3)>a:nth-child(2)")
	private WebElement financialPlanning;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(4)>a:nth-child(1)")
	private WebElement veterinarians;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(4)>a:nth-child(2)")
	private WebElement photographers;
	
	@FindBy(css = "footer[id='footer']>section>div[class='hide-for-small footer-middle']>div>aside:nth-child(4)>a:nth-child(3)")
	private WebElement homeServices;
	
	@FindBy(css="a[class='alphabetical']")
	private WebElement findProfessionalByLastName;
	
	@FindBy(css = "a[href='/zf/landing-page/login']")
	private WebElement loginPageFooter;
	
	@FindBy(css = "div[class='footer-bottom']>a:nth-child(1)")
	private WebElement pressPage;
	
	@FindBy(css = "div[class='footer-bottom']>a:nth-child(2)")
	private WebElement careersPage;
	
	@FindBy(css = "div[class='footer-bottom']>a:nth-child(3)")
	private WebElement partnersPage;
	
	@FindBy(css = "div[class='footer-bottom']>a:nth-child(4)")
	private WebElement privacyPage;
	
	@FindBy(css = "div[class='footer-bottom']>a:nth-child(5)")
	private WebElement termsPage;
	
	
	private String debugClose = "img[alt = 'Close']";
	
	// Team page
	@FindBy(css = "div[class='professionals']")
	private WebElement teamPage;
	
	//Contact
	@FindBy(css = "div[id = 'contact']")
	private WebElement contactPage;
	
	//FAQ
	@FindBy(css = "div[id = 'faq']")
	private WebElement faqPage;
		
	//Real Estate
	@FindBy(xpath = "//section[@id='directory']/preceding-sibling::h1")
	private WebElement directoryPageHeading;
	
	@FindBy(css = "div[class='professional-search']")
	private WebElement professionalSearch;
	
	
	
	@FindBy(css = "div[id='mortgageComparison']")
	private WebElement mortgagepageHeading;
	
	//Okay button
	@FindBy(css = "button[name = '__CONFIRM__']")
	private WebElement okayButton;
	
	//Stik home page
	@FindBy(css = "header[id='header']>nav>ul>li:nth-child(1)>a")
	private WebElement stiklogo;
	
	@FindBy(css = "header[id='header']>nav>ul>li[class='name logo']>a")
	private WebElement stiklogo1;
	
	@FindBy(css="div[id='header']>div>ul>li>a[class='logo name']")
	private WebElement stiklogoOnProfessionalPage;
	
	/******** Facebook UI elements ********/
	//facebook username input field
	@FindBy(css = "input[class='inputtext']")
	private WebElement facebookUserName;
	
	//facebook password input field
	@FindBy(css= "input[class='inputpassword']")
	private WebElement facebookPassword;
	
	//facebook login button
	@FindBy(css= "label[class='uiButton uiButtonConfirm uiButtonLarge'] input")
	private WebElement facebookLoginButton;
		
	//SignUpWithFacebook Button
	@FindBy(xpath = "//div[@id = 'header']")
	private WebElement header;
	
	@FindBy(xpath = "label[class='uiButton uiButtonConfirm uiButtonLarge'] input")
	private WebElement signUpWithFacebookLink;
	
	
	/***************LinkedIn UI Elements***************************************/
	//Email Field
	@FindBy(css="div[class='fieldgroup']>input[id='session_key-oauth2SAuthorizeForm']")
	private WebElement linkedInEmailTextBox;
	
	@FindBy(css="div[class='fieldgroup']>input[id='session_password-oauth2SAuthorizeForm']")
	private WebElement linkedInPasswordTextBox;
	
	@FindBy(css="div[class='actions']>ul>li>input[class='allow']")
	private WebElement linkedInAllowButton;
	
	

	
	/************ Getter Methods to get WEB Elements ************************/
	public WebElement get_signUpLink() {
		return joinForFree;
	}
	
	public WebElement get_loginLink(){
		return loginLink;
	}
	
	public WebElement get_facebookLinkOnLoginPage(){
		return facebookLinkOnLoginPage;
	}
	
	public WebElement get_linkedInLinkOnLoginPage(){
		return linkedInLinkOnLoginPage;
	}
	
	public WebElement get_logoutLink(){
		return logoutLink;
	}
	
	public WebElement get_howItWorksLink(){
		return howItWorksLink;
	}
	
	public WebElement get_marketingLink(){
		return marketingLink;
	}
	
	public WebElement get_findAProfessional(){
		return findAProfessional;
	}
	
	public WebElement get_enterPrise(){
		return enterPrise;
	}
	
	
	public WebElement get_facebookUserName(){
		return facebookUserName;
	}
	
	public WebElement get_facebookPassword(){
		return facebookPassword;
	}
	
	public WebElement get_signUpWithFacebookLink(){
		return signUpWithFacebookLink;
	}
	
	public WebElement get_facebookLoginButton(){
		return facebookLoginButton;
	}
	
	public WebElement get_alreadySignUpLink(){
		return alreadySignUpLink;
	}
	
	public WebElement get_linkedInLoginButton(){
		return linkedInLoginButton;
	}
	
	public WebElement get_inYourEmail(){
		return inYourEmail;
	}
	
	public WebElement get_onYourWebsite(){
		return onYourWebsite;
	}
	
	public WebElement get_onFacebookPage(){
		return onFacebookPage;
	}
	
	public WebElement get_onFacebookProfile(){
		return onFacebookProfile;
	}
		
	public WebElement get_dropDown(){
		return dropDown;
	}
	
	public WebElement get_profileInfoLink(){
		return profileInfoLink;
	}
	
	public WebElement get_viewProfileLink(){
		return viewProfileLink;
	}
	
	public WebElement get_firstName(){
		return firstName;
	}
	
	public WebElement get_facebookPicLink(){
		return facebookPicLink;
	}
	
	public WebElement get_collectReviews(){
		return collectReviews;
	}
	
	public WebElement get_collectReviewsLink(){
		return collectReviewsLink;
	}
	
	public WebElement get_showCaseReviews(){
		return showCaseReviews;
	}
	
	public WebElement get_formSearchBox(){
		return formSearchBox;
	}
	
	public String get_debugCloseCSS(){
		return debugClose;
	}
	
	public WebElement get_howItWorks(){
		return howItWorks;
	}
	
	public WebElement get_standOutOnline(){
		return standOutOnline;
	}
	
	public WebElement get_findProfessionalInYourArea(){
		return findProfessionalInYourArea;
	}
	
	public WebElement get_whatIsStik(){
		return whatIsStik;
	}
	
	//footer links
	public WebElement get_meetTheTeam(){
		return meetTheTeam;
	}
	
	public WebElement get_contactUs(){
		return contactUs;
	}
	
	public WebElement get_FAQ(){
		return FAQ;
	}
		
	public WebElement get_realEstate(){
		return realEstate;
	}
	
	public WebElement get_mortgage(){
		return mortgage;
	}
	
	public WebElement get_insurance(){
		return insurance;
	}
	
	public WebElement get_healthAndWellness(){
		return healthAndWellness;
	}
	
	public WebElement get_lawyers(){
		return lawyers;
	}
	
	public WebElement get_financialPlanning(){
		return financialPlanning;
	}
	
	public WebElement get_veterinarians(){
		return veterinarians;
	}
	
	public WebElement get_photographers(){
		return photographers;
	}
	
	public WebElement get_homeServices(){
		return homeServices;
	}
	
	public WebElement get_findProfessionalByLastName(){
		return findProfessionalByLastName;
	}
	
	public WebElement get_loginPageFooter(){
		return loginPageFooter;
	}
	
	public WebElement get_pressLink(){
		return pressPage;
	}
	
	public WebElement get_careersLink(){
		return careersPage;
	}
	
	public WebElement get_partnersLink(){
		return partnersPage;
	}
	
	public WebElement get_privacyLink(){
		return privacyPage;
	}
	
	public WebElement get_termsLink(){
		return termsPage;
	}
	
	public WebElement get_teamPage(){
		return teamPage;
	}
	
	public WebElement get_contactPage(){
		return contactPage;
	}
	
	public WebElement get_faqPage(){
		return faqPage;
	}
	
	public WebElement get_directoryPageHeading(){
		return directoryPageHeading;
	}
	
	public WebElement get_okayButton(){
		return okayButton;
	}
	
	public WebElement get_stiklogo(){
		return stiklogo;
	}
	
	public WebElement get_stiklogo1(){
		return stiklogo1;
	}
	
	public WebElement get_GetStartedButton(){
		return getStartedButton;
	}
	
	public WebElement get_inYourEmailLink(){
		return inYourEmailLink;
	}
	
	/********* Wait Elements *************/
	public WebElement get_header(){
		return header;
	}
	public WebElement get_onYourWebSiteLink(){
		return onYourWebSiteLink;
	}
	
	public WebElement get_onYourFacebookPage(){
		return onYourFacebookPage;
	}
	
	public WebElement get_onYourFacebookProfile(){
		return onYourFacebookProfile;
	}

	public WebElement get_linkedInEmailTextBox(){
		return linkedInEmailTextBox;
	}
	public WebElement get_linkedInPasswordTextBox(){
		return linkedInPasswordTextBox;
	}
	public WebElement get_linkedInAllowButton(){
		return linkedInAllowButton;
	}
	
	public WebElement get_forLocalBusinessLink(){
		return forLocalBusinessLink;
	}
	
	public WebElement get_forEnterpriseLink(){
		return forEnterpriseLink;
	}
	
	public WebElement get_forBusinessLink(){
		return forBusinessLink;
	}
	
	public WebElement get_pricingLink(){
		return pricingLink;
	}
	
	public WebElement get_stiklogoOnProfessionalPage(){
		return stiklogoOnProfessionalPage;
	}
	
	public WebElement get_referralLink(){
		return referralLink;
	}
	
	public WebElement get_mortgagepageHeading(){
		  return mortgagepageHeading;
	}
	
	public WebElement get_professionalSearch(){
		return professionalSearch;
	}
	
}
