package com.qait.automation.stik.actionfixtures;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.qait.automation.stik.util.Utilities;

/**
 * <b>Class: HomePageFixture</b>
 * <p>
 * HomePageFixture Contains methods pertaining to Home Page.
 * 
 * @author      QAIT
 * @version     0.1
 * @since       0.0
 * @see         HomePageFixture#clickSignUpLink()
 * @see         HomePageFixture#clickLoginLink()
 * @see         HomePageFixture#signOut()
 */
public class HomePageFixture extends ProfessionalPageFixture{

	/**
	 * <b>Method: clickSignUpLink </b> 
	 * <p>
	 * click SignUp Link
	 * @return boolean
	 */

	public boolean clickSignUpLinkOnHomePage(){
		homePageUi.waitForElementToAppear(homePageUi.get_header());
		System.out.println("Trying to find Sign up...");
		try{
			//wait for login button to appear then try entering username and password
			homePageUi.get_signUpLink().click();
			logger.info("Sign Up Link clicked...");
			return true;

		}catch(Exception ex){
			System.out.println("Unable to find Sign Up Button");
			logger.info("Sign Up Link not clicked...");
			return false;
		}
	}

	public void handleEmailSignup(String name, String mailId, String importerEmail){
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(professionalPageUi.get_applyButton());
		professionalPageUi.get_nameTextBox().click();
		professionalPageUi.get_nameTextBox().sendKeys(name);
		professionalPageUi.get_emailTextBox().click();
		professionalPageUi.get_emailTextBox().sendKeys(mailId);
		professionalPageUi.get_applyButton().click();
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(professionalPageUi.get_continueButtonOnEmailImporter());
		professionalPageUi.get_emailImporterTextBox().clear();

		for(int i=1;i<=5;i++){

			professionalPageUi.get_emailImporterTextBox().click();
			professionalPageUi.get_emailImporterTextBox().sendKeys(importerEmail+i+"@test.com");
			professionalPageUi.get_emailImporterTextBox().sendKeys(Keys.RETURN);


			Utilities.hardWait(1);
		}
		Utilities.hardWait(1);
		professionalPageUi.get_continueButtonOnEmailImporter().click();
		Utilities.explicitWait(driver);
		Reporter.log("No Problems in handling Email Sign up...");
		System.out.println("Email Sign up Page handled correctly...");

	}

	public boolean signUpWithFacebook(String name, String mailId, String importerEmail){
		assert clickSignUpLinkOnHomePage(): "Unable to click Sign up button";
		System.out.println("Current URL on signup page is:- " +driver.getCurrentUrl());
		Utilities.explicitWait(driver);
		if(driver.getCurrentUrl().trim().contains("email-signup")){
			handleEmailSignup(name, mailId, importerEmail);
		}
		Utilities.hardWait(2);
		try{

			homePageUi.waitForElementToAppear(professionalPageUi.get_signUpButtonForFacebook());
			professionalPageUi.get_signUpButtonForFacebook().click();

		}catch(Exception e1){
			try{
				Utilities.explicitWait(driver);
				homePageUi.waitForElementToAppear(professionalPageUi.get_applyWithFacebookButton());
				professionalPageUi.get_applyWithFacebookButton().click();
			}catch(Exception e7){
				try{
					Utilities.explicitWait(driver);
					professionalPageUi.get_signUpWithFacebookButton().click();
					System.out.println("Sign Up with facebook Button clicked....");

				}catch(Exception e2){
					try{
						Utilities.explicitWait(driver);
						professionalPageUi.get_selectContactsWithFacebookButton().click();
						System.out.println("Select Contacts with facebook Button clicked...");

					}catch(Exception e3){
						try{
							Utilities.explicitWait(driver);
							homePageUi.waitForElementToAppear(professionalPageUi.get_signUpWithFacebookButton3());
							professionalPageUi.get_signUpWithFacebookButton3().click();

						}catch(Exception e4){
							try{
								Utilities.explicitWait(driver);
								professionalPageUi.get_signUpWithFacebookButton2().click();

							}catch(Exception e5){
								try{
									Utilities.explicitWait(driver);
									professionalPageUi.get_signUpWithFacebookButton4().click();
								}
								catch(Exception e8){
									System.out.println("None of the Sign Up buttons found!!");
									e5.printStackTrace();
								}


							}

						}
					}

				}

			}

		}	
		return true;
	}

	public boolean signUpWithLinkedIn(String name, String mailId, String importerEmail){
		assert clickSignUpLinkOnHomePage(): "Unable to click Sign up button";
		System.out.println("Current URL on signup page is:- " +driver.getCurrentUrl());
		if(driver.getCurrentUrl().trim().contains("email-signup")){
			handleEmailSignup(name, mailId, importerEmail);
		}

		try{
			Utilities.explicitWait(driver);
			professionalPageUi.get_signUpButtonForLinkedin().click();
			Utilities.hardWait(1);

		}catch(Exception ex){

			try{
				homePageUi.waitForElementToAppear(professionalPageUi.get_signUpWithLinkedInButton());
				professionalPageUi.get_signUpWithLinkedInButton().click();
				System.out.println("Sign Up with LinkedIn Button clicked....");

			}catch(Exception e1){
				try{
					homePageUi.waitForElementToAppear(professionalPageUi.get_applyWithLinkedInButton());
					professionalPageUi.get_applyWithLinkedInButton().click();
				}catch(Exception e7){
					try{
						homePageUi.waitForElementToAppear(professionalPageUi.get_selectContactsWithLinkedInButton());
						professionalPageUi.get_selectContactsWithLinkedInButton().click();
						System.out.println("Select Contacts with LinkedIn Button clicked...");

					}catch(Exception e2){
						try{
							homePageUi.waitForElementToAppear(professionalPageUi.get_signUpWithLinkedInButton3());
							professionalPageUi.get_signUpWithLinkedInButton3().click();

						}catch(Exception e3){

							try{
								homePageUi.waitForElementToAppear(professionalPageUi.get_signUpWithLinkedInButton2());
								professionalPageUi.get_signUpWithLinkedInButton2().click();

							}catch(Exception e4){
								System.out.println("None of the Sign Up buttons found!!");
								e4.printStackTrace();

							}
						}
					}

				}
			}
		}
		return true;

	}

	/**
	 * <b>Method: clickLoginLink </b> 
	 * <p>
	 * click Login Link on home page
	 * @return boolean
	 */
	public boolean clickLoginLink(){
		ifExistsDebugClickClose();
		homePageUi.waitForElementToAppear(homePageUi.get_header());
		Assert.assertTrue(homePageUi.get_loginLink().isDisplayed());
		Reporter.log("Verified that login Link is displayed");
		homePageUi.get_loginLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Clicking on Login doesn't open the login page");
		homePageUi.get_alreadySignUpLink().click();
		scrollDown(00);
		homePageUi.get_facebookLinkOnLoginPage().click();
		//homePageUi.get_facebookPicLink().click();
		Reporter.log("Login Link on Home Page clicked..");
		return true;
	}

	public boolean clickLinkedInLoginLink(){
		ifExistsDebugClickClose();
		homePageUi.waitForElementToAppear(homePageUi.get_header());
		Assert.assertTrue(homePageUi.get_loginLink().isDisplayed());
		Reporter.log("Verified that Login Link is displayed");
		homePageUi.get_loginLink().click();
		homePageUi.get_linkedInLoginButton().click();
		Reporter.log("Login Link on Home Page clicked...");
		return true;
	}

	public boolean checkNewUserFlag(){
		if(util.getYamlValue("runScriptWithNewUser")=="false") 
			return false;
		else 
			return true;
	}

	public boolean createUsersOnFacebook(String appName){
		String temp = null;
		if(appName.toLowerCase().contains("knewdeal"))
			temp = createUserOnFacebook("Knewdeal","automation");
		else if(appName.toLowerCase().contains("knewbies"))
			temp = createUserOnFacebook("Small Business", "automation");

		if(temp.length()<=1) return false;

		setTestUserName(temp.split(";")[0]);
		setTestPassword(temp.split(";")[1]);
		return true;
	}

	/**
	 * <b>Method: loginUsingFaceBookUserNamePassword </b> 
	 * <p>
	 * Login to the application using the provided credentials
	 * @return boolean
	 */
	public boolean loginUsingFaceBookUserNamePassword(String username, String password, boolean newUserFlag){
		if(newUserFlag){
			username = getTestUserName();
			password = getTestPassword();
		}
		Utilities.hardWait(3);
		Reporter.log("Switching to FaceBook Window...");
		homePageUi.changeWindow(1);
		Reporter.log("Switched to FaceBook Window...");
		homePageUi.waitForElementToAppear(homePageUi.get_facebookLoginButton());
		//verify face book username text box appears in new window and type username.
		Assert.assertTrue(homePageUi.get_facebookUserName().isDisplayed());
		homePageUi.get_facebookUserName().clear();
		homePageUi.get_facebookUserName().sendKeys(username);
		Reporter.log("Typed keys username");
		//verify face book password text box appears in new window and type password.
		Assert.assertTrue(homePageUi.get_facebookPassword().isDisplayed());
		homePageUi.get_facebookPassword().sendKeys(password);
		Reporter.log("Typed keys password");

		//verify login button appears in new window and click login button.
		Assert.assertTrue(homePageUi.get_facebookLoginButton().isDisplayed());
		homePageUi.get_facebookLoginButton().click();
		Reporter.log("Clicked facebook login button...");
		Utilities.hardWait(5);

		try{
			homePageUi.get_okayButton().click();
			Reporter.log("Clicked facebook Okay button...");
			Utilities.hardWait(3);
			homePageUi.get_okayButton().click();
			homePageUi.changeWindow(0);
			Reporter.log("Switched back to main window");

			return true;
		}catch(Exception e){
			//switch back to default window
			homePageUi.changeWindow(0);
			Reporter.log("Switched back to main window");
			return true;
		}


	}


	public boolean loginusingLinkedInUserNamePassword(String username, String password){
		Utilities.hardWait(3);
		Reporter.log("Switching to LinkedIn Window...");
		homePageUi.changeWindow(1);
		Reporter.log("Switched to LinkedIn Window...");
		homePageUi.waitForElementToAppear(homePageUi.get_linkedInAllowButton());
		//verify LinkedIn username text box appears in new window and type username.
		Assert.assertTrue(homePageUi.get_linkedInEmailTextBox().isDisplayed());
		homePageUi.get_linkedInEmailTextBox().clear();
		homePageUi.get_linkedInEmailTextBox().sendKeys(username);
		Reporter.log("Typed keys username");
		//verify LinkedIn password text box appears in new window and type password.
		Assert.assertTrue(homePageUi.get_linkedInPasswordTextBox().isDisplayed());
		homePageUi.get_linkedInPasswordTextBox().sendKeys(password);
		Reporter.log("Typed keys password");

		//verify Allow Access button appears in new window and click it.
		Assert.assertTrue(homePageUi.get_linkedInAllowButton().isDisplayed());
		homePageUi.get_linkedInAllowButton().click();
		Reporter.log("Clicked LinkedIn Allow Access button...");
		Utilities.hardWait(5);
		homePageUi.changeWindow(0);
		Reporter.log("Switched back to main window");
		return true;
	}





	/**
	 * <b>Method: navigateToProfileInfoPage </b> 
	 * <p>
	 * Navigate to profile info page.
	 * @return boolean
	 */
	public boolean navigateToProfileInfoPage(){
		Utilities.hardWait(5);
		//if browser is iexplore click drop down and click 'Profile Info' link
		//else if move mouse over drop down button and click profile info link
		if(util.getYamlValue("browser").equalsIgnoreCase("iexplore")){
			homePageUi.waitForElementToAppear(homePageUi.get_dropDown());
			homePageUi.get_dropDown().click();
			Reporter.log("Drop Down clicked on main page");
			Assert.assertTrue(homePageUi.get_profileInfoLink().isDisplayed());
			homePageUi.get_profileInfoLink().click();
			driver.navigate().to(homePageUi.get_profileInfoLink().getAttribute("href"));
		}else{
			try{
				homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_profileInfoLink());
			}catch(Exception enve){
				driver.navigate().to(homePageUi.get_profileInfoLink().getAttribute("href"));
			}
		}
		Reporter.log("Navigate to profileInfo Page");
		return true;
	}


	public boolean navigateToReferralPage(){
		Utilities.explicitWait(driver);
		//if browser is iexplore click drop down and click 'Profile Info' link
		//else if move mouse over drop down button and click profile info link
		if(util.getYamlValue("browser").equalsIgnoreCase("iexplore")){
			homePageUi.waitForElementToAppear(homePageUi.get_dropDown());
			homePageUi.get_dropDown().click();
			Reporter.log("Drop Down clicked on main page");
			Assert.assertTrue(homePageUi.get_referralLink().isDisplayed());
			homePageUi.get_profileInfoLink().click();
			driver.navigate().to(homePageUi.get_referralLink().getAttribute("href"));
		}else{
			try{
				homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_referralLink());
			}catch(Exception enve){
				driver.navigate().to(homePageUi.get_referralLink().getAttribute("href"));
			}
		}
		Reporter.log("Navigate to Referral Page");
		return true;
	}

	/**
	 * <b>Method: verifyFirstNameIsDisplayedOnHomePage </b> 
	 * <p>
	 * Verify if first name appears on profile page after logging into the account.
	 * @return boolean
	 */
	public boolean verifyFirstNameIsDisplayedOnHomePage(){
		//homePageUi.get_stiklogo1().click();ot
		Utilities.hardWait(4);
		if(homePageUi.get_firstName().isDisplayed()){
			Reporter.log("First name displayed: " + homePageUi.get_firstName().isDisplayed());
			return true;
		}
		Reporter.log("First name is not displayed: " + homePageUi.get_firstName().isDisplayed());
		return false;
	}



	/**
	 * Method: Sign out from the current session
	 * @return boolean
	 */
	public boolean signOut(){
		ifExistsDebugClickClose();
		Utilities.hardWait(2);
		if(!isDisplayed(homePageUi.get_firstName())){
			Reporter.log("Not signed in...");
			return true;
		}
		if(util.getYamlValue("browser").equalsIgnoreCase("iexplore")){
			homePageUi.waitForElementToAppear(homePageUi.get_dropDown());
			Assert.assertTrue(homePageUi.get_dropDown().isDisplayed());
			homePageUi.get_dropDown().click();
			Assert.assertTrue(homePageUi.get_logoutLink().isDisplayed());
			homePageUi.get_logoutLink().click();
			Reporter.log("Sign Out button clicked...");
		}else{
			try{
				homePageUi.get_dropDown().click();
				homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_logoutLink());
			}catch(ElementNotVisibleException enve){
				homePageUi.get_dropDown().click();
				homePageUi.get_logoutLink().click();
			}
			Reporter.log("Sign Out button clicked....");
		}
		return true;
	}

	public void verifyStikLogoOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_stiklogo()), "Stik Logo in not visible");
		System.out.println("Stik Logo Appears on Home Page");
		Reporter.log("Stik Logo Present in the header on Home page ");
	}

	public void verifyCollectReviewsAppearsOnHomePage(){
		Assert.assertTrue(homePageUi.get_collectReviews().getText().trim().equalsIgnoreCase("Collect Reviews"),"Collect Reviews is not visible");
		System.out.println("Collect Reviews Appears On Home Page");
		Reporter.log("Collect Reviews Present in the header on Home page ");
	}

	public void verifyLinkShowCaseReviewsAppearsOnHomePage(){
		Assert.assertTrue(homePageUi.get_showCaseReviews().getText().trim().equalsIgnoreCase("Showcase Reviews"),"Show Case Reviews Link is not visible");
		System.out.println("Show Case Reviews Appears On Home Page");
	}

	//	public void verifyLinkForLocalBusinessAppearsOnHomePage(){
	//		Assert.assertTrue(homePageUi.get_forLocalBusinessLink().getText().trim().equalsIgnoreCase("For Local Business"), "For Local Business Link is not visible");
	//		Reporter.log("For Local Business Link Present in the header on Home page ");
	//	}

	//	public void verifyLinkForEnterpriseAppearsOnHomePage(){
	//		Assert.assertTrue(homePageUi.get_forEnterpriseLink().getText().trim().equalsIgnoreCase("For Enterprise"), "For Enterprise link not visible");
	//		Reporter.log("For Enterprise Present in the header on Home page ");
	//	}
	//	
	public void verifyLinkHowItWorksOnHomePage(){
		Assert.assertTrue(homePageUi.get_howItWorksLink().getText().trim().equalsIgnoreCase("Why stik"), "How it works Link is not visible");
		System.out.println("How it works Appears on Home Page");
		Reporter.log("How It Works Link Present in the header on Home page ");
	}


	public void verifyLinkForBusinessOnHomePage(){
		Assert.assertTrue(homePageUi.get_forBusinessLink().getText().trim().equalsIgnoreCase("For Business"), "For Business Link is not visible");
		System.out.println("For Business Appears on Home Page");
		Reporter.log("For Business Link Present in the header on Home page ");
	}

	public void verifyLinkFindProfessionalOnHomePage(){
		Assert.assertTrue(homePageUi.get_findAProfessional().getText().trim().equalsIgnoreCase("Find a Professional"), "Find a Professional Link is not visible");
		System.out.println("Find a Professional Appears on Home Page");
		Reporter.log("Find a Professional Link Present in the header on Home page ");
	}

	public void verifyLinkMarketingWorksOnHomePage(){
		Assert.assertTrue(homePageUi.get_marketingLink().getText().trim().equalsIgnoreCase("Marketing"), "Marketing Link is not visible");
		System.out.println("Marketing Appears on Home Page");
		Reporter.log("Marketing Link Present in the header on Home page ");
	}

	public void verifyPricingLinkWorksOnHomePage(){
		Assert.assertTrue(homePageUi.get_pricingLink().getText().trim().equalsIgnoreCase("Pricing"), "Pricing Link not visible");
		System.out.println("Pricing Link Appears on Home page");
		Reporter.log("Pricing Link Present in the header on Home page ");
	}

	//	public void verifyLinkEnterpriseOnHomePage(){
	//		Assert.assertTrue(homePageUi.get_enterpriseLink().getText().trim().equalsIgnoreCase("Enterprise"), "Enterprise Link not visible");
	//		System.out.println("Enterprise Appears on Home page");
	//	}


	public void verifyLinkProfessionalSearchAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_formSearchBox()),"Professional Search is not visible");
		System.out.println("Professional Search Appears On Home Page");
		Reporter.log("Professional Search Present in the header on Home page ");
	}

	public void verifyLoginLinkAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_loginLink()),"Login Link is not visible");
		System.out.println("Login Link Appears On Home Page");
		Reporter.log("Login Link Present in the header on Home page ");
	}

	public void verifySignUpLinkAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_signUpLink()),"Sign Up Link is not visible");
		System.out.println("Sign Up Link Appears On Home Page");
		Reporter.log("Sign Up Link Present in the header on Home page ");
	}

	public void verifyHomePageTitle(String title){
		homePageUi.waitForElementToAppear(homePageUi.get_GetStartedButton());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title), "Title does not match..");
		System.out.println("Home Page title matches");
	}

	public void verifyTabWhatIsStikAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_whatIsStik()),"What is Stik is not visibile");
		System.out.println("What is Stik Appears On Home Page");
	}

	public void verifyTabHowItWorksAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_howItWorks()), "Link 'How it works' is not visible");
		System.out.println("How it Works Appears On Home Page");
	}

	public void verifyTabStandOutOnlineAppearsOnHomePage(){
		Assert.assertTrue(isDisplayed(homePageUi.get_standOutOnline()), "Link 'Stand Out Online' is not visible");
		System.out.println("Stand Out Online Appears On Home Page");
	}

	public void verifyMeetTheTeamLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_meetTheTeam()), "Link 'Meet The Team Link' is not visible");
		homePageUi.get_meetTheTeam().click();
		Utilities.explicitWait(driver);
		homePageUi.waitForElementToAppear(homePageUi.get_teamPage());
		Assert.assertTrue(homePageUi.get_teamPage().isDisplayed(), "Correct Element not found on clicking Meet the team link");
		System.out.println("Meet the Team works fine");
	}

	public void verifyContactUsLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_contactUs()), "Link 'Contact Us' is not visible");
		homePageUi.get_contactUs().click();
		homePageUi.get_contactPage().isDisplayed();
		System.out.println("Contact Us Link works fine");
	}

	public void verifyFAQLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_FAQ()), "Link 'FAQ' is not visible");
		homePageUi.get_FAQ().click();
		homePageUi.get_faqPage().isDisplayed();
		System.out.println("FAQ Link works fine");
	}

	public void verifyAnswersLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_answers()), "Link 'Answers' is not visible");
		homePageUi.get_answers().click();
		homePageUi.get_answersPage().isDisplayed();
		System.out.println("Answers link works fine");
	}

	public void verifyFindProfessionalInYourAreaLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_findProfessionalInYourArea()), "Link 'Find Professional In Your Area' is not visible");
		homePageUi.get_findProfessionalInYourArea().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		Assert.assertTrue(isDisplayed(homePageUi.get_professionalSearch()), "Profeesional Search option not present on directory");
		System.out.println("Find Professional In your area works fine");
	}

	public void verifyRealEstateLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_realEstate()), "Link 'Real Estate' is not visible");
		homePageUi.get_realEstate().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Realtors");
		System.out.println("Real Estate Link works fine..");
	}



	public void verifyMortgageLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_mortgage()), "Link 'Mortgage' is not visible");
		homePageUi.get_mortgage().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Mortgage Brokers");
		System.out.println("Mortgage Link works fine");
	}

	public void verifyInsuranceLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_insurance()), "Link 'Insurance' is not visible");
		homePageUi.get_insurance().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Insurance Agents");
		System.out.println("Insurance link works fine");
	}

	public void verifyHealthAndWellnessLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_healthAndWellness()), "Link 'Health And Wellness' is not visible");
		homePageUi.get_healthAndWellness().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Health Care Providers");
		System.out.println("Health professional Link works fine..");
	}

	public void verifyLawyersLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_lawyers()), "Link 'Lawyers' is not visible");
		homePageUi.get_lawyers().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Lawyers");
		System.out.println("Lawyers links works fine..");
	}

	public void verifyFinancialPlanningLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_financialPlanning()), "Link 'Financial Planning' is not visible");
		homePageUi.get_financialPlanning().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Financial Planners");
		System.out.println("Financial Professional Link works fine....");
	}

	public void verifyVeterinarianLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_veterinarians()), "Link 'Veterinarians' is not visible");
		homePageUi.get_veterinarians().click();
		homePageUi.get_directoryPageHeading().getText().contains("Veterinarians");
		System.out.println("Veterinarians link works fine...");
	}

	public void verifyPhotographersLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_photographers()), "Link 'Photographers' is not visible");
		homePageUi.get_photographers().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Photographers");
		System.out.println("Photographers link works fine...");
	}

	public void verifyHomeServicesLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_homeServices()), "Link 'Home Services' is not visible");
		homePageUi.get_homeServices().click();
		homePageUi.waitForElementToAppear(homePageUi.get_directoryPageHeading());
		homePageUi.get_directoryPageHeading().getText().contains("Home Contractors");
		System.out.println("Home Services link works fine...");
	}

	public void verifyFindProfessionalByLastNameLink(){
		driver.get(util.getYamlValue("liveUrl"));
		Assert.assertTrue(isDisplayed(homePageUi.get_findProfessionalByLastName()), "Link for 'Find Professional by Last Name' is not visible");
		homePageUi.get_findProfessionalByLastName().click();
		homePageUi.get_findProfessionalByLastName().getAttribute("href").contains("directory/alphabetical");
		System.out.println("Find Professional By Last Name link works fine...");
	}

	public void verifyLoginLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_loginPageFooter()) && homePageUi.get_loginPageFooter().getText().trim().contains("Login"), "Link 'Login at Footer' is not visible");
		System.out.println("Login Link in footer appears on Home Page");
	}

	public void verifyPressLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_pressLink()) && homePageUi.get_pressLink().getText().trim().contains("Press"), "Link 'Press at Footer' is not visible");
		homePageUi.get_pressLink().click();
		homePageUi.get_pressLink().getAttribute("href").contains("/press");
		System.out.println("Press Link in footer appears on Home Page");
	}

	public void verifyCareersLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_careersLink()) && homePageUi.get_careersLink().getText().trim().contains("Careers"), "Link 'Carrers at Footer' is not visible");		
		homePageUi.get_careersLink().click();
		homePageUi.get_careersLink().getAttribute("href").contains("/careers");
		System.out.println("Career Link in footer appears on Home Page");
	}

	public void verifyPartnerLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_partnersLink()) && homePageUi.get_partnersLink().getText().trim().contains("Partners"), "Link 'Partner at Footer' is not visible");		
		homePageUi.get_partnersLink().click();
		homePageUi.get_partnersLink().getAttribute("href").contains("/partners");
		System.out.println("Partners Link in footer appears on Home Page");
	}

	public void verifyPrivacyLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_privacyLink()) && homePageUi.get_privacyLink().getText().trim().contains("Privacy"), "Link 'Privacy at Footer' is not visible");		
		homePageUi.get_privacyLink().click();
		homePageUi.get_privacyLink().getAttribute("href").contains("/privacy");
		System.out.println("Privacy Link in footer appears on Home Page");
	}

	public void verifyTermsLinkAtFooter(){
		driver.get(util.getYamlValue("liveUrl"));		
		Assert.assertTrue(isDisplayed(homePageUi.get_termsLink()) && homePageUi.get_termsLink().getText().trim().contains("Terms"), "Link 'Terms at Footer' is not visible");		
		homePageUi.get_termsLink().click();
		homePageUi.get_termsLink().getAttribute("href").contains("/terms");
		System.out.println("Terms Link in footer appears on Home Page");
	}


	public boolean navigateToHomePage(){

		Utilities.explicitWait(driver);
		try{
			driver.get(homePageUi.get_stiklogo1().getAttribute("href"));
			homePageUi.handleAlert();
			Utilities.hardWait(2);
			return true;
		}catch(Exception ex){
			try{
				driver.get(homePageUi.get_stiklogo().getAttribute("href"));
				homePageUi.handleAlert();
				Utilities.hardWait(2);
				return true;
			}
			catch(Exception e){
				driver.get(homePageUi.get_stiklogoOnProfessionalPage().getAttribute("href"));
				homePageUi.handleAlert();
				Utilities.hardWait(2);
				return true;
			}
		}
	}


	public boolean ifNewUserFillInDetailsOnProfessionalPage(boolean newUserFlag){
		if(!newUserFlag) return true;
		fillDetailsOnProfessionalPage();
		return true;
	}



//	public boolean clickYourOptionUnderShowcaseReviews(String option){
//		Utilities.explicitWait(driver);
//		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_inYourEmail());
//		Utilities.explicitWait(driver);
//		List<WebElement> list=homePageUi.get_dropDownOnProfilePage();
//		//		for(WebElement el : list){
//		//			if(el.getText().equalsIgnoreCase(option)){
//		//				el.click();
//		//				System.out.println(option+" link is clicked...");
//		//				break;
//		//			}
//		//		}
//		return true;
//	}

	public boolean clickInYourEmailShowcaseOptionUnderProfileDropdown(){
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_inYourEmail());
		Utilities.explicitWait(driver);
		return true;
	}
	
	public boolean clickOnYourWebsiteShowcaseOptionUnderProfileDropdown(){
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_onYourWebsite());
		Utilities.explicitWait(driver);
		return true;
	}
	
	public boolean clickOnYourFacebookPageShowcaseOptionUnderProfileDropdown(){
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_onYourFacebookPage());
		Utilities.explicitWait(driver);
		return true;
	}
	
	public boolean clickOnYourFacebookProfileShowcaseOptionUnderProfileDropdown(){
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_onYourFacebookProfile());
		Utilities.explicitWait(driver);
		return true;
	}
	
	public void navigateToEnterprisePage(){
		homePageUi.waitForElementToAppear(homePageUi.get_stiklogo());
		homePageUi.get_enterPrise().click();
	}

	public void navigateToDirectory(){
		homePageUi.waitForElementToAppear(homePageUi.get_findAProfessional());
		homePageUi.get_findAProfessional().click();
		homePageUi.waitForElementToAppear(directTemp.getContinueButton());
	}

	public void clearCache(){
		driver.manage().deleteAllCookies();
	}

}
