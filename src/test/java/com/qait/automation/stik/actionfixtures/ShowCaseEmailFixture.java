package com.qait.automation.stik.actionfixtures;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.qait.automation.stik.util.Utilities;



public class ShowCaseEmailFixture extends SearchPageFixture{
	
	public void verifySplashSectionOnEmailPage(){
		homePageUi.waitForElementToAppear(showcaseEmailUi.get_splashText());
		Assert.assertTrue(showcaseEmailUi.get_splashText().getText().contains("Stik Reviews in Your Email Signature"), "Incorrect text in the splash section");
		Reporter.log("Splash Text on Showcase Email page is OK");
	}
	
	public boolean clickGetStartedButtonOnEmailPreviewPage(){
		Utilities.hardWait(5);
		showcaseEmailUi.get_GetStarted();
		return true;
	}
	
	public void verifyEmailPreviewPresentAndClickSelectReviewButton(){
		driver.switchTo().frame(0);
		homePageUi.waitForElementToAppear(showcaseEmailUi.get_emailTextInPreview());
		try{
		Assert.assertTrue(isDisplayed(showcaseEmailUi.get_emailTextInPreview()));
		Reporter.log("Email Text is Displayed in Iframe");
		driver.switchTo().defaultContent();
		}catch(Exception e){
			Reporter.log("No Email content in frame!!!");
		}
		showcaseEmailUi.get_SelectReviewButton().click();
		Reporter.log("Preview Modal Opened up");
		
	}
	public void verifySignatureHeadingInEmailPreview(){
		Utilities.hardWait(2);
		driver.switchTo().frame(0);
		Assert.assertTrue(isDisplayed(showcaseEmailUi.get_headerInSignature()));
		Reporter.log("\"What people are saying about me\" is displayed");
		driver.switchTo().defaultContent();
		System.out.println("\"What people are saying about me\" is displayed");
	}
	
	public void verifyEmailPreviewIsOk(){
		String[] arrayFromModalDailog= performOperationsOnEmailPreviewModalDialog();
		scrollDown(200);
		String[] arrayFromEmailPreview= performOperationsOnEmailPreviewFrame();
		Assert.assertTrue(Integer.parseInt(arrayFromModalDailog[0])== Integer.parseInt(arrayFromEmailPreview[0]));
		Reporter.log("Number of Reviews in signature matches with number of reviews selected in Preview Modal");
		System.out.println("Number of Reviews In Signature matches with number of Reviews selected in Preview Modal");
		Assert.assertTrue(arrayFromModalDailog[2].equals(arrayFromEmailPreview[1]));
		Reporter.log("First Reviewer in Signature list is the same as selected in Preview Modal");
		System.out.println("First Reviewer in Signature list is the same as selected in Preview Modal");
		Utilities.hardWait(5);
		homePageUi.mouseMove(homePageUi.get_dropDown(), homePageUi.get_viewProfileLink());
		homePageUi.waitForElementToAppear(profilePageUi.get_profileName());
		Assert.assertTrue(Integer.parseInt(arrayFromModalDailog[1]) == Integer.valueOf(profilePageUi.get_RatingCount().getText().trim()));
		Reporter.log("Total Reviews on Profile Page matches with number of Reviews dispalyed in Email preview Modal Dialog");
		System.out.println("Total Reviews on Profile Matches number of Reviews dispalyed in Email preview Modal");	
		
	}

	public String[] performOperationsOnEmailPreviewModalDialog(){
		Utilities.hardWait(8);	
		showcaseEmailUi.get_DeselectAllButton();
		Reporter.log("Deselect button clicked..");
		int totalReviewCountOnPreviewModal=showcaseEmailUi.get_totalReviewCountOnPreview().size();
		System.out.println("Total Reviews on Modal:- " +totalReviewCountOnPreviewModal);
		Utilities.hardWait(2);
		String NameofFirstReviewerInPreview=showcaseEmailUi.get_firstReviewerInPreview().getText();
		System.out.println("Name of First reviewer On Modal:- " +NameofFirstReviewerInPreview);
		check_CheckboxesOnPreviewModalDialog(totalReviewCountOnPreviewModal);
		int checkedReviewCountOnPreviewModal= Integer.parseInt(showcaseEmailUi.get_CheckedReviewCountOnPreviewModal().getText());
		System.out.println("Checked Review Count:- " +checkedReviewCountOnPreviewModal);
		Utilities.hardWait(3);
		showcaseEmailUi.get_returnToPreviewButton();
		Reporter.log("Preview Modal Closed");
		String[] countArray= new String[3];
		countArray[0]=Integer.toString(checkedReviewCountOnPreviewModal);
		countArray[1]=Integer.toString(totalReviewCountOnPreviewModal);
		countArray[2]=NameofFirstReviewerInPreview;
		return countArray;
		
		
	}
	
	public String[] performOperationsOnEmailPreviewFrame(){
		driver.switchTo().frame(0);
		String reviewCountInSignature=Integer.toString(showcaseEmailUi.get_ReviewCountInSignature().size());
		System.out.println("Reviews Displayed In signature:-"+reviewCountInSignature);
		
		String firstReviewerNameInSignature= showcaseEmailUi.get_reviewerNameInSignaturePreview().getText();
		System.out.println("Name of First Reviewer In Singature:- "+firstReviewerNameInSignature);
		driver.switchTo().defaultContent();
		String[] arrayCount=new String[2];
		arrayCount[0]=reviewCountInSignature;
		//arrayCount[1]=emailContent;
		arrayCount[1]=firstReviewerNameInSignature;
		return arrayCount;
	}
	
	
	
	public void check_CheckboxesOnPreviewModalDialog(int totalReviewCountOnPreviewModal){
		Utilities.hardWait(4);
		if(totalReviewCountOnPreviewModal>0){
		
		showcaseEmailUi.get_CheckboxesOnPreview_1().click();
		
		Utilities.hardWait(1);
		System.out.println("First selected");
		try{
		showcaseEmailUi.get_CheckboxesOnPreview_2().click();
		
		Utilities.hardWait(1);
		
		showcaseEmailUi.get_CheckboxesOnPreview_3().click();
		System.out.println("All 3 checkboxes are checked!!");
		
		}catch(Exception e){
			System.out.println("Number of checkboxes is less than 2");
			Reporter.log("Number of checkboxes on preview Dialog Modal is less than 2");
		
		}}else{
		
			System.out.println("No Checkboxes");
			Reporter.log("No Reviews on the modal dialog ");
		}
	}
	
	public boolean verifyEmailProviderLinksPresent(){
		homePageUi.waitForElementToAppear(showcaseEmailUi.get_copySignatureButton());
		showcaseEmailUi.get_GetStarted();
		scrollDown(450);
		Assert.assertTrue(isDisplayed(showcaseEmailUi.get_gmailProvider()), "Gmail Provider not present!!!");
		Assert.assertTrue(isDisplayed(showcaseEmailUi.get_yahooProvider()), "Yahoo Provider not present!!!");
		Assert.assertTrue(isDisplayed(showcaseEmailUi.get_outlookProvider()), "Outlook provider not present!!!");
		Assert.assertTrue(showcaseEmailUi.get_gmailProvider().getAttribute("class").contains("selected"), "Gmail Provider is not selected by default");
		Reporter.log("All Email Provider options available on Showcase Email page");
		Reporter.log("Gmail is selected as default Email Provider");
		return true;
	}
	
	public boolean checkOpenAccountSectionIsInSyncWithProviderSection(){
		Assert.assertTrue(getLinkForVisibleEmailProvider().contains("gmail"), "Active link in step 4 is not Gmail when email provider is Gmail");
		Assert.assertTrue(verifyAccountHyperlinksRedirectToCorrectURL("gmail"),"Incorrect URL for Google Account");
		Utilities.hardWait(2);
		showcaseEmailUi.get_yahooProvider().click();
		Utilities.hardWait(2);
		Assert.assertTrue(getLinkForVisibleEmailProvider().contains("yahoo"), "Active link in step 4 is not Yahoo when email provider is Yahoo");
		Assert.assertTrue(verifyAccountHyperlinksRedirectToCorrectURL("yahoo"), "Incorrect URL for Yahoo Account");
		Utilities.hardWait(2);
		showcaseEmailUi.get_outlookProvider().click();
		Utilities.hardWait(3);
		Assert.assertTrue(getLinkForVisibleEmailProvider().contains("outlook"), "Active link in step 4 is not Outlook when email provider is Outlook");
		Assert.assertTrue(verifyAccountHyperlinksRedirectToCorrectURL("outlook"), "Incorrect URL for Outlook Account");
		return true;
	}
	
	public boolean verifyAccountHyperlinksRedirectToCorrectURL(String provider){
		if(provider.contains("gmail")){
			showcaseEmailUi.get_openGmailAccountLink().click();
			homePageUi.changeWindow(1);
			Utilities.hardWait(2);
			if(driver.getCurrentUrl().contains("google")){
				driver.close();
				homePageUi.changeWindow(0);
				return true;
			}else return false;
		}
		if(provider.contains("yahoo")){
			showcaseEmailUi.get_openYahooAccoutnLink().click();
			homePageUi.changeWindow(1);
			if(driver.getCurrentUrl().contains("yahoo")){
				driver.close();
				homePageUi.changeWindow(0);
				return true;
			}else return false;
		}
		if(provider.contains("outlook")){
			showcaseEmailUi.get_openOutlookAccountLink().click();
			homePageUi.changeWindow(1);
			if(driver.getCurrentUrl().contains("live.com")){
				driver.close();
				homePageUi.changeWindow(0);
				return true;
			}else return false;
		}
		return false;
	}
	
	public String getLinkForVisibleEmailProvider(){
		List<WebElement> openXAccountList=showcaseEmailUi.get_openyourXAccountLink();
		for(int i=0;i<openXAccountList.size();i++){
			String cl=openXAccountList.get(i).getAttribute("class");
			if(cl.equals("card default active")){
				return "gmail";
			}else if(cl.equals("card active")){
				return openXAccountList.get(i).getAttribute("id");
			}else{
				continue;
			}
		}
		return null;
	}
}
	

