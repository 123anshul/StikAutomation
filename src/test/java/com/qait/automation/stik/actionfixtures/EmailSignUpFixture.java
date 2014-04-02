package com.qait.automation.stik.actionfixtures;

import org.testng.Assert;
import com.qait.automation.stik.util.Utilities;

public class EmailSignUpFixture extends SearchPageFixture{

	public boolean importCSV(){
		Utilities.explicitWait(driver);
		Assert.assertTrue(isDisplayed(emailSignupUi.getEmailHeading()), "Email heading is not displayed");
		
		emailSignupUi.getCsvUserData().sendKeys(System.getProperty("user.dir")+ "\\" + "ModifiedEmailReport.csv");
		emailSignupUi.getCsvPictureData().sendKeys(System.getProperty("user.dir")+ "\\"+ "email-import-pictures.zip");
		emailSignupUi.getImportButton().click();
		Utilities.hardWait(7);
		homePageUi.handleAlertinEmail();
		homePageUi.waitForElementToAppear(emailSignupUi.getImportData());
		Assert.assertTrue(isDisplayed(emailSignupUi.getImportData()), "Import data is not displayed..");
		return true;
	}
}
