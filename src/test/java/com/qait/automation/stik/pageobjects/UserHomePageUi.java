package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class UserHomePageUi extends BaseUi{

	public UserHomePageUi(WebDriver driver, SizzleSelector sizzle) {
		super(driver, sizzle);
	}

	/***********************UI Elements***************************************************************/
	
	
	
	@FindBy(css=".ui-client")
	private WebElement clientDashboard;
	
	@FindBy(css=".client-panel")
	private WebElement clientPanelSection;
	
	@FindBy(css=".client-content")
	private WebElement clientContentSection;
	
	/******************Client Panel Section UI Elements**************************************/
	@FindBy(css="aside[class='client-panel is-home-page']>nav>div[class='avatar']>a>img")
	private WebElement clientProfileImage;
	
	@FindBy(css="aside[class='client-panel is-home-page']>nav>section[class='details']>div[class='reputation']>a>p")
	private WebElement clientProilfeName;
	
	@FindBy(css="aside[class='client-panel is-home-page']>nav>section[class='details']>div[class='reputation']>div>i[class='icon-star']")
	private List<WebElement> clientStarRating;
	
	@FindBy(css="aside[class='client-panel is-home-page']>nav>section[class='details']>ul[class='score']>li>a>span[class='number']")
	private List<WebElement> clientReviewsAndReferralNumbers;
	
	@FindBy(css="aside[class='client-panel is-home-page']>nav>section[class='quick-links']>ul>li>a")
	private List<WebElement> clientQuickLinks; 
	
	/*******************Client Content- Leaderboard Section UI Elements*************************************/
	
	@FindBy(css="article[class='client-content']>section>article>div>footer>div[class='details']>h2")
	private WebElement leaderBoradOnYourWayText;
	
	@FindBy(xpath="//div[@class='progress']/parent::div")
	private WebElement leaderBoradProgressbar;
	
	@FindBy(css="footer>div>div[class='control']>a")
	private WebElement leaderBoradGetMoreReviewsButton;
	
	@FindBy(css=".ui-leaderboard-trophy")
	private WebElement leaderBoardTrophyImage;
	
	@FindBy(css=".ui-leaderboard>li>div[class='ranking']")
	private List<WebElement> leaderBoradRanksOfCompetitor;
	
	@FindBy(css=".ui-leaderboard>li>div[class='competitor']>span:nth-child(1)")
	private List<WebElement> leaderBoradNameOfCompetitors;
	
	@FindBy(css="div[class='share-leaderboard']>a")
	private WebElement leaderBoardShareButton;
	
	@FindBy(css="div[class='innerWrap']>textarea")
	private WebElement leaderBoardTextAreaInShareWindow;
	
	@FindBy(css="button[name='share']")
	private WebElement leaderBoardShareLinkButtonInShareWindow;
	
	@FindBy(xpath=".//span[contains(text(),'On your own timeline')]")
	private WebElement onYourTimeLineDropDownInShareWindow;
	
	
	/*********************Client Content-Complete_Your_Profile_And_Unlock_Potential Sections UI Elements***************************/
	
	@FindBy(css="section>article[class='complete-profile']>div>div[class='content']>img")
	private WebElement completeYourProfileImageBadge;
	
	@FindBy(xpath="//article[@class='complete-profile']//footer/a")
	private WebElement completeYourProfileButton;
	
	@FindBy(css="section>article[class='contact-us js-lead-form']>form>div>div>div[class='lead-form']>label[class='call-me']>input")
	private WebElement callMeInputBoxBeforeSucess;
	
	@FindBy(css="section>article[class='contact-us js-lead-form']>form>div>div>div[class='lead-form']>label[class='call-us']>p")
	private WebElement callUsLabel;
	
	@FindBy(css="section>article[class='contact-us js-lead-form']>form>div>footer>button")
	private WebElement requestConsulationButton;
	
	@FindBy(xpath=".//button[contains(@disabled,'disabled')  and contains(@class,'button medium short')] ")
	private WebElement disabledRequestConsultationButton;
	
	@FindBy(css="section>article[class='contact-us js-lead-form success']>form>div>div>div[class='lead-form']>label[class='call-me']>input")
	private WebElement callMeTextBoxAfterSuccess;
	
	@FindBy(css="div[id='successMessage']>h1")
	private WebElement successMessageOnConsultation;
	
	
	/*******************Client Content-Latest_Reviews Section UI Elements****************************************************/
	
	@FindBy(css="div[class= 'card-stack-navigation']>div:nth-child(1)")
	private WebElement latestReviewsLeftArrow;
	
	@FindBy(css="div[class= 'card-stack-navigation']>div:nth-child(3)")
	private WebElement latestReviewsRightArrow;
	
	@FindBy(css="section>article[class='latest-reviews']>div>footer>div>div[class='card-stack-navigation']>ul>li")
	private List<WebElement> latestReviewsNavigationBullets;
	
	@FindBy(xpath="(//a[@ah-label='Facebook'])[1]")
	private WebElement facebookShareProfileLink;
	
	@FindBy(xpath="(//a[@ah-label='Google'])[1]")
	private WebElement googleShareProfileLink;
	
	@FindBy(xpath="(//a[@ah-label='LinkedIn'])[1]")
	private WebElement linkedinShareProfileLink;
	
	@FindBy(xpath="(//a[@ah-label='Facebook'])[2]")
	private WebElement facebookBoostProfileLink;
	
	@FindBy(xpath="(//a[@ah-label='Google'])[2]")
	private WebElement googleBoostProfileLink;
	
	@FindBy(xpath="(//a[@ah-label='LinkedIn'])[2]")
	private WebElement linkedinBoostProfileLink;
	
	
	
	
	private String latestReviewsList="section>article[class='latest-reviews']>div>footer>div>div:nth-child(index)";
	private String detailsOfReviewInLatestReviewSection="section>article[class='latest-reviews']>div>footer>div>div:nth-child(index)>div>div>div";
	private String viewReviewLink="//*[@class='latest-reviews']/div/footer/div/div[index]/div/div/p/a";
	
	@FindBy(xpath="(//div[@class='control']/a)[2]")
	private WebElement latestReviewsGetMoreReviewsButton;
	
	public String reviewId="parent::p/parent::div/parent::div/parent::div";
	
	
	
	/***********************Getter Methods*************************************************************/
	
	public WebElement get_clientDashboard(){
		return clientDashboard;
	}
	
	public WebElement get_clientPanelSection(){
		return clientPanelSection;
	}
	
	public WebElement get_clientContentSection(){
		return clientContentSection;
	}
	
	public WebElement get_clientProfileImage(){
		return clientProfileImage;
	}
	
	public WebElement get_clientProilfeName(){
		return clientProilfeName;
	}
	
	public List<WebElement> get_clientStarRating(){
		return clientStarRating;
	}
	
	public List<WebElement> get_clientReviewsAndReferralNumbers(){
		return clientReviewsAndReferralNumbers;
	}
	
	public List<WebElement> get_clientQuickLinks(){
		return clientQuickLinks;
	}
	
	public WebElement get_leaderBoradOnYourWayText(){
		return leaderBoradOnYourWayText;
	}
	
	public WebElement get_leaderBoradProgressbar(){
		return leaderBoradProgressbar;
	}
	
	public WebElement get_leaderBoradGetMoreReviewsButton(){
		return leaderBoradGetMoreReviewsButton;
	}
	
	public WebElement get_leaderBoardTrophyImage(){
		return leaderBoardTrophyImage;
	}
	
	public List<WebElement> get_leaderBoradRanksOfCompetitor(){
		return leaderBoradRanksOfCompetitor;
	}
	
	public List<WebElement> get_leaderBoradNameOfCompetitors(){
		return leaderBoradNameOfCompetitors;
	}
	
	public WebElement get_leaderBoardShareButton(){
		return leaderBoardShareButton;
	}
	
	public WebElement get_leaderBoardTextAreaInShareWindow(){
		return leaderBoardTextAreaInShareWindow;
	}
	
	public WebElement get_leaderBoardShareLinkButtonInShareWindow(){
		return leaderBoardShareLinkButtonInShareWindow;
	}
	
	public WebElement get_onYourTimeLineDropDownInShareWindow(){
		return onYourTimeLineDropDownInShareWindow;
	}
	
	public WebElement get_completeYourProfileImageBadge(){
		return completeYourProfileImageBadge;
	}
	
	public WebElement get_completeYourProfileButton(){
		return completeYourProfileButton;
	}
	
	public WebElement get_callMeInputBoxBeforeSucess(){
		return callMeInputBoxBeforeSucess;
	}
	
	public WebElement get_callUsLabel(){
		return callUsLabel;
	}
	
	public WebElement get_requestConsulationButton(){
		return requestConsulationButton;
	}
	
	public WebElement get_disabledRequestConsultationButton(){
		return disabledRequestConsultationButton;
	}
	
	
	public WebElement get_callMeTextBoxAfterSuccess(){
		return callMeTextBoxAfterSuccess;
	}
	
	public WebElement get_successMessageOnConsultation(){
		return successMessageOnConsultation;
	}
	
	
	public WebElement get_latestReviewsLeftArrow(){
		return latestReviewsLeftArrow;
	}
	
	public WebElement get_latestReviewsRightArrow(){
		return latestReviewsRightArrow;
	}
	
	public List<WebElement> get_latestReviewsNavigationBullets(){
		return latestReviewsNavigationBullets;
	}
	
	public WebElement get_latestReviewsList(int index){
		return driver.findElement(By.cssSelector(latestReviewsList.replaceAll("index", String.valueOf(index))));
	}
	
	public List<WebElement> get_detailsOfReviewInLatestReviewSection(int index){
		return driver.findElements(By.cssSelector(detailsOfReviewInLatestReviewSection.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_viewReviewLink(int index){
		return driver.findElement(By.xpath(viewReviewLink.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_latestReviewsGetMoreReviewsButton(){
		return latestReviewsGetMoreReviewsButton;
	}
	
	public WebElement get_facebookShareProfileLink(){
		return facebookShareProfileLink;
	}
	
	public WebElement get_googleShareProfileLink(){
		return googleShareProfileLink;
	}
	
	public WebElement get_linkedinShareProfileLink(){
		return linkedinShareProfileLink;
	}
	
	public WebElement get_facebookBoostProfileLink(){
		return facebookBoostProfileLink;
	}
	
	public WebElement get_googleBoostProfileLink(){
		return googleBoostProfileLink;
	}
	
	public WebElement get_linkedinBoostProfileLink(){
		return linkedinBoostProfileLink;
	}
	
	public List<WebElement> get_latestReviewList(){
		return driver.findElements(By.xpath("(//section[@class='reviewInfo']/h2)"));
	}
	
	public WebElement get_latestReview(int i){
		return driver.findElement(By.xpath("(//section[@class='reviewInfo']/h2)["+i+"]"));
	}
	
	
}
