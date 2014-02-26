package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ShowcaseEMailUi extends BaseUi{

	public ShowcaseEMailUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}
	
	@FindBy(css="div[class='splash-section']>div>div[class='text five columns push-seven']>h1")
	private WebElement splashText;
	
	@FindBy(xpath= ".//*[@id='emailPreview']/div/a")
	private WebElement selectReviewsButton;
	
	@FindBy(css= ".button.small.deselect-all")
	private WebElement deselectAllButton;
	
	@FindBy(xpath=".//*[@id='selectorItemsContainer']/li[1]/div/div[1]/input")
	private WebElement clickOnCheckBox1;
	
	@FindBy(xpath=".//*[@id='selectorItemsContainer']/li[2]/div/div[1]/input")
	private WebElement clickOnCheckBox2;
	
	@FindBy(xpath=".//*[@id='selectorItemsContainer']/li[3]/div/div[1]/input")
	private WebElement clickOnCheckBox3;
	
	@FindBy(css= ".button.large.close-reveal-modal")
	private WebElement returnToPreviewButton;
	
	@FindBy(css= ".selected-tally")
	private WebElement checkedReviewCountOnPreviewModal;
	
	public String totalreviewCountonPreview= "//ul[@id='selectorItemsContainer']/li";
	
	
	@FindBy(xpath=".//body/p")
	private WebElement emailTextInPreview;
	
	@FindBy(xpath=".//*[@id='selectorItemsContainer']/li[1]/div/div[2]/span")
	private WebElement firstReviewerInPreview;
	
	@FindBy(css= "table[id=title]>tbody>tr>td")
	private WebElement headerInSignature;
	
	public String reviewCountInSignature= ".//*[@id='thinEmailWidget']/tr";
	
	
	@FindBy(xpath=".//*[@id='thinEmailWidget']/tr[1]/td[2]/a")
	private WebElement reviewerNameInSignaturePreview;
	
	
	@FindBy(xpath=".//*[@id='copyEmail']/div[1]/div[1]/a")
	private WebElement copySignatureButton;
	
	@FindBy(css="div[class='js-copy-instructions alert-box success']>p")
	private WebElement copySignatureSuccessMessage;
	
	@FindBy(xpath=".//div[@id='emailProvider']/div/ul[@class='email-buttons']/li[@class='gmail']/div[1]")
	private WebElement gmailProvider;
	
	@FindBy(xpath=".//div[@id='emailProvider']/div/ul[@class='email-buttons']/li[@class='yahoo']/div[1]")
	private WebElement yahooProvider;
	
	@FindBy(xpath=".//div[@id='emailProvider']/div/ul[@class='email-buttons']/li[@class='outlook']/div[1]")
	private WebElement outlookProvider;
	
	@FindBy(xpath=".//*[@id='embedInstructions']/ul/li")
	private List<WebElement> openyourXAccountLink;
	
	@FindBy(xpath=".//*[@id='gmailInstructions']/div[1]/div[1]/h3/a")
	private WebElement openGmailAccountLink;

	@FindBy(xpath=".//*[@id='yahooInstructions']/div[1]/div[1]/h3/a")
	private WebElement openYahooAccoutnLink;
	
	@FindBy(xpath=".//*[@id='outlookInstructions']/div[1]/div[1]/h3/a")
	private WebElement openOutlookAccountLink;
	
	
	public void get_GetStarted(){
		executeJavaScript("document.getElementsByClassName('large orange button hide-for-small')[0].click()");
	}
	
	public WebElement get_SelectReviewButton(){
		return selectReviewsButton;
	}
	public void get_DeselectAllButton(){
		executeJavaScript("document.getElementsByClassName('button small deselect-all')[0].click()");
	}
	public WebElement get_CheckboxesOnPreview_1(){
		return clickOnCheckBox1;
	}
	public WebElement get_CheckboxesOnPreview_2(){
		return clickOnCheckBox2;
	}
	public WebElement get_CheckboxesOnPreview_3(){
		return clickOnCheckBox3;
	}
	
	public void get_returnToPreviewButton(){
		executeJavaScript("document.getElementsByClassName('button large close-reveal-modal')[0].click()");
	}
	
	public WebElement get_CheckedReviewCountOnPreviewModal(){
		return checkedReviewCountOnPreviewModal;
	}
	public List<WebElement> get_ReviewCountInSignature(){
			return driver.findElements(By.xpath(reviewCountInSignature));
	}
	public List<WebElement> get_totalReviewCountOnPreview(){
		return driver.findElements(By.xpath(totalreviewCountonPreview));
		
	}
	
	public WebElement get_emailTextInPreview(){
		return emailTextInPreview;
	}
	public WebElement get_firstReviewerInPreview(){
		return firstReviewerInPreview;
	}
	public WebElement get_headerInSignature(){
		return headerInSignature;
	}
	
	public WebElement get_reviewerNameInSignaturePreview(){
		return reviewerNameInSignaturePreview;
	}
	
	public WebElement get_copySignatureButton(){
		return copySignatureButton;
	}
	public WebElement get_copySignatureSuccessMessage(){
		return copySignatureSuccessMessage;
	}
	
	public WebElement get_gmailProvider(){
		return gmailProvider;
	}
	
	public WebElement get_yahooProvider(){
		return yahooProvider;
	}
	public WebElement get_outlookProvider(){
		return outlookProvider;
	}
	
	public WebElement get_openGmailAccountLink(){
		return openGmailAccountLink;
	}
	
	public WebElement get_openYahooAccoutnLink(){
		return openYahooAccoutnLink;
	}
	public WebElement get_openOutlookAccountLink(){
		return openOutlookAccountLink;
	}
	
	public List<WebElement> get_openyourXAccountLink(){
		return openyourXAccountLink;
	}
	
	public WebElement get_splashText(){
		return splashText;
	}
}
