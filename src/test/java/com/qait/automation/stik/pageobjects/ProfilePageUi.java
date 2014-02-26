package com.qait.automation.stik.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.automation.stik.util.SizzleSelector;

public class ProfilePageUi extends BaseUi{

	public ProfilePageUi(WebDriver driver,SizzleSelector sizzle) {
		super(driver,sizzle);
	}

	/*****************WEB UI defined *****************************/
	//Profile Name on Profile Page
	@FindBy(css = "h1[itemprop='name']")
	private WebElement profileName;
	
	//Phone Number on Profile Page
	@FindBy(css = "h3[id= 'affiliation']")
	private WebElement affiliation;
	
	@FindBy(css = "p[id='address']")
	private WebElement streetAddress;
	
	@FindBy(css = "p[id= 'addressLocality']")
	private WebElement addressLocality;
	
	@FindBy(css = "h4[id= 'addressRegion']")
	private WebElement addressRegion;
	
	@FindBy(css ="h4[id= 'postalCode']")
	private WebElement postalCode;
	
	@FindBy(css = "h4[id= 'website']")
	private WebElement website;
	
	@FindBy(css = "article[id='about']>p")
	private WebElement about;
	
	@FindBy(css = "div[id= 'phoneNumber']>a:nth-child(2)")
	private WebElement phoneNumber;
	
	@FindBy(css= "li[data-magellan-arrival='reviewsAnchor']>a")
	private WebElement reviewTab;
	
	@FindBy(css= "span[itemprop='ratingCount']")
	private WebElement ratingCount;
	
	@FindBy(css="div[id='reviewsContainer']>div>div[class='review']")
	private List<WebElement> reviewRows;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']")
	private WebElement featuredReviewModelWindow;
	
	@FindBy(css="article[id='featuredReviews']>div>article")
	private List<WebElement> featuredReviews;
	
	/*Meta content on profile page*/
	//1.
	@FindBy(css= "meta[name='name'][property='name'][itemprop='name']")
	private WebElement metaName;
	//2
	@FindBy(css= "meta[name='description'][property='description'][itemprop='description']")
	private WebElement metaDescription;
	//3
	@FindBy(css= "meta[name='image'][property='image'][itemprop='image']")
	private WebElement metaImage;
	//4
	@FindBy(css= "meta[name='og:url'][property='og:url']")
	private WebElement metaOrgUrl;
	//5
	@FindBy(css= "meta[name='og:title'][property='og:title']")
	private WebElement metaOrgTitle;
	//6
	@FindBy(css= "meta[name='og:description'][property='og:description']")
	private WebElement metaOrgDescription;
	//7
	@FindBy(css= "meta[name='og:image'][property='og:image']")
	private WebElement metaOrgImage;
	//8
	@FindBy(css= "meta[name='og:site_name'][property='og:site_name']")
	private WebElement metaOrgSiteName;
	//9
	@FindBy(css= "meta[name='og:type'][property='og:type']")
	private WebElement metaOgType;
	//10
	@FindBy(css= "meta[name='og:postal-code'][property='og:postal-code']")
	private WebElement metaOgPostalCode;
//	//11 not mandatory
//	@FindBy(css= "meta[name='og:latitude'][property='og:latitude']")
//	private WebElement metaOgLatitude;
//	//12 not mandatory
//	@FindBy(css= "meta[name='og:longitude'][property='og:longitude']")
//	private WebElement metaOgLongitude;
	//13
	@FindBy(css= "meta[name='og:locality'][property='og:locality']")
	private WebElement metaOgLocality;
	//14
	@FindBy(css= "meta[name='og:region'][property='og:region']")
	private WebElement metaOgRegion;
//	//15 not mandatory
//	@FindBy(css= "meta[name='og:country-name'][property='og:country-name']")
//	private WebElement metaOgCountryName;
	//16
	@FindBy(css= "meta[name='fb:admins'][property='fb:admins']")
	private WebElement metaFbAdmins;
	//17
	@FindBy(css= "meta[name='fb:app_id'][property='fb:app_id']")
	private WebElement metaFbAppId;
	//18
	@FindBy(css= "meta[charset='utf-8']")
	private WebElement metaCharSet;
	
	@FindBy(css = "div[class= 'share share-large'] a[class = 'twitter js-show-as-popup']")
	private WebElement twitter;
	
	@FindBy(css = "article[id='share-profile']>footer>div>a:nth-child(1)")
	private WebElement facebook;
	
	@FindBy(css = "article[id='share-profile']>footer>div>a:nth-child(2)")
	private WebElement linkedIn;
	
	@FindBy(css = "article[id='share-profile']>footer>div>a:nth-child(3)")
	private WebElement googlePlus;
	
	@FindBy(css="div[id='profileInfo']>div[id='extraInfo']>div>ul[class='slider-nav']>li:nth-child(2)>a")
	private WebElement contactTab;
	
	/********************* Google meta content ***********/
	//19
//	@FindBy(css= "meta[content='notranslate'][name='google']")
//	private WebElement metaGoogle;
	//20
	@FindBy(css= "meta[content='en-us'][http-equiv='content-language']")
	private WebElement metaContentLanguage;
	
	public String ratingsForAllReviews="(//div[@id='reviewsContainer']/div/div)[index]//div[@class='star-container']/i[@class='icon-star']";
	
	@FindBy(css= "div:nth-child(1)>div[class='review']>div>div:nth-child(1)>div>div>div[class='photo facebook']>img")
	private WebElement firstReviewerProfilePic;
	
	@FindBy(css="div:nth-child(1)>div[class='review']>div>div:nth-child(1)>div>div>span[class='name']")
	private WebElement firstReviewerProfileName;
	
	@FindBy(css="div:nth-child(1)>div[class='review']>div>div:nth-child(1)>div>p[class='review-content']")
	private WebElement firstReviewerProfileComment;
	
	@FindBy(css="div:nth-child(1)>div[class='review']>div>div:nth-child(1)>div>div[class='info']>div")
	private WebElement firstReviewerProfileDate;
	
	@FindBy(css="div:nth-child(1)>div[class='review']>div>div:nth-child(1)>div>div[class='rating']>div>i[class='icon-star']")
	private List<WebElement> firstReviewerRatingCount;
	
	@FindBy(css="div[id='directMessageModal']")
	private WebElement messageModal;
	
	@FindBy(css="a[id='closeDirectMessage']")
	private WebElement closeModalIcon;
	
	@FindBy(css="section[id='profile']>header>div[class='info']>div:nth-child(2)>article>section>div>div>a:nth-child(2)")
	private WebElement compnayLink;
	
	@FindBy(css="section[id='profile']>header>div[class='info']>div:nth-child(2)>article>section>div>div>a:nth-child(1)")
	private WebElement jobTitleLink;
	
	@FindBy(css="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='address']>div[class='address-container']>a")
	private WebElement addressLink;
	
	@FindBy(css="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='address']>div[class='location-container']>a")
	private WebElement location;
	
	@FindBy(css="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='button-container']>div>a[class='edit-setting']")
	private WebElement editPhoneNumberLink;
	
	@FindBy(css="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='website-container']>a")
	private WebElement webSiteLink;
	
	@FindBy(css="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='license-container']>a")
	private WebElement licenseLink;
	
//	@FindBy(css="")
//	private WebElement zipCode;
	
	
	//private String jobTitleLink="section[id='profile']>header>div[class='info']>div:nth-child(2)>article>section>div>div>a:nth-child(1)";
	//private String compnayLink="section[id='profile']>header>div[class='info']>div:nth-child(2)>article>section>div>div>a:nth-child(2)";
	//private String licenseLink="div[class='license inline-edit']>a:nth-child(1)";
	//private String addressLink="div[class='profile-content']>aside>article:nth-child(1)>footer>div>div[class='address-container']>a";
	//private String cityLink="div[id='extraInfo']>div>ul[class='container']>li[id='contact']>div>a[id='addressLocality']";
	//private String stateLink="div[id='extraInfo']>div>ul[class='container']>li[id='contact']>div>a[id='addressRegion']";
	//private String zipCodeLink="div[id='extraInfo']>div>ul[class='container']>li[id='contact']>div>a[id='postalCode']";
	//private String emailUserLink="div[id='extraInfo']>div>ul[class='container']>li[id='contact']>div[class='email-user']>h4[id='emailUser']>a";
	//private String webSiteLink="div[id='extraInfo']>div>ul[class='container']>li[id='contact']>div>a[id='website']";
	//private String editPhoneNumberLink="div[class='profile-content']>aside>article:nth-child(1)>footer>div[class='button-container']>div>a[class='edit-setting']";
	
		
	/*****************Review Submission UI Elements*********************/
	
	private String randomStarRating="div[id='rating-stars-container']>div[class='star-container']>i:nth-child(index)";
	
	@FindBy(css="a[class='button medium js-navigate leave-inline-review']")
	private WebElement reviewButton;
	
	@FindBy(css="div[id='featuredReviewsWrapper']>article>header>div>a[class='small orange button']")
	private WebElement reviewButtonOnProfilePage;
	
	@FindBy(css="li[id='reviewsTab']>div[class='inline-review']")
	private WebElement inLineReviewSection;
	
	@FindBy(css="li>textarea")
	private WebElement textAreaForReview;
	
	@FindBy(css="a[class='button medium js-navigate verify-inline-review']")
	private WebElement submitReviewButton;
	
	@FindBy(css="section[id='inlineReviewManagerReview']>div>footer>div>button")
	private WebElement continueButton;
	
	@FindBy(css="section[id='inlineReviewManagerReview']>div>footer>div>button")
	private WebElement activeContinueButton;
	
	@FindBy(css="div[class='inline-review']>ul>li[id='verify']")
	private WebElement verifyReviewSection;
	
	@FindBy(css="div[id='simpleStepVerify']>div>div>div>div>a:nth-child(1)")
	private WebElement facebookButton;
	
	@FindBy(css="div[class='inline-review']>ul>li[id='save']>h5>i")
	private WebElement savingReviewtext;
	
	@FindBy(css="div[class='inline-review']>ul>li[id='thanks']>h4[class='thanks']")
	private WebElement thanksForReviewText;
	
	@FindBy(css="div[class='ui-email-importer']>section>div[id='defaultMessage']>p>a")
	private WebElement skipLink;
	
	@FindBy(css="article[id='leaderboard']>footer>div[class='leaderboard-user']")
	private List<WebElement> topProfessionals;
	
	@FindBy(css="article[id='featuredReviews']>header>h2")
	private WebElement featuredReviewsSectionText;
	
	@FindBy(xpath="//a[text()='Edit Featured Reviews']")
	private WebElement editFeaturedReviewLink;
	
	@FindBy(css="div[class='actions']>a[href='#reviews']")
	private WebElement viewAllReviewLink;
	
	@FindBy(css="ul[id='selectedFeaturedReviewsContainer']>li>article")
	private List<WebElement> featuredReviewsInPopUp;
	
	@FindBy(css="ul[id='selectedFeaturedReviewsContainer']>li>article>div>div>p")
	private List<WebElement> textForfeaturedReviewsInPopUp;
	
	@FindBy(css="div[id='eligibleFeaturedReviews']>article[class='featured-review review']")
	private List<WebElement> totalReviewsInPopUp;
	
	@FindBy(css="div[id='eligibleFeaturedReviews']>article[class='featured-review review']>div>div>p")
	private List<WebElement> textForTotalReviewsInPopup;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']>section>div>div[class='controls']>a[class='button up thin']")
	private WebElement reviewUpButtonInPopUp;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']>section>div>div[class='controls']>a[class='button down thin']")
	private WebElement reviewDownButtonInPopUp;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']>section>div>div>ul>li>article>div>div>div[class='remove']")
	private List<WebElement> featuredReviewCrossButton;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']>a")
	private WebElement popUpCross;
	
	@FindBy(css="article[id='share-profile']>footer>div[class='share-buttons']>a:nth-child(1)")
	private WebElement facebookProfileShareLink;
	
	@FindBy(css="article[id='share-profile']>footer>div[class='share-buttons']>a:nth-child(2)")
	private WebElement googleProfileShareLink;
	
	@FindBy(css="article[id='share-profile']>footer>div[class='share-buttons']>a:nth-child(3)")
	private WebElement linkedInProfileShareLink;
	
	@FindBy(css="article[id='share-profile']>footer>div[class='share-link']>input")
	private WebElement profileUrlInputBox;
	
	@FindBy(css="div[id='layout']>section>header")
	private WebElement coverImage;
	
	@FindBy(css="a[data-would-refer='no']")
	private WebElement noLink;
	
	@FindBy(xpath="(//a[@class='add-photo'])[1]")
	private WebElement addPhotoLink;
	
	@FindBy(css="div[id='reviewImagesManagerModal']>div:nth-child(2)")
	private WebElement addPhotoModalWindow;
	
	@FindBy(css="section[id='state-add']>h4")
	private WebElement addPhotoModelText;
	
	@FindBy(css="a[class='select-images button']")
	private WebElement addPhotoModelSelectButton;
	
	@FindBy(css="div>div:nth-child(2)>article>a[class='close-reveal-modal']")
	private WebElement addPhotoModelCrossButton;
	
	@FindBy(xpath="(//div[@class='content-container'])[1]/div/div[4]")
	private WebElement reviewPhotoAction;
	
	@FindBy(css="div[id='addFeaturedReviewsModal']>div>a")
	private WebElement featuredModalDoneButton;
	
	@FindBy(xpath="//ul[@id='selectedFeaturedReviewsContainer']//div[@class='about']//span")
	private List<WebElement> profileNameForFeaturedReviewsInPopUp;
	/************ Getter Methods to get WEB Elements ************************/
	public WebElement get_addPhotoLink(){
		return addPhotoLink;
	}
	
	public WebElement get_featuredModalDoneButton(){
		return featuredModalDoneButton;
	}
	
	public WebElement get_reviewAction(){
		return reviewPhotoAction;
	}
	
	public WebElement get_addPhotoModelText(){
		return addPhotoModelText;
	}
	
	public WebElement get_addPhotoModalSelectButton(){
		return addPhotoModelSelectButton;
	}
	
	public WebElement get_addPhotoModelCrossButton(){
		return addPhotoModelCrossButton;
	}
	
	public WebElement get_addPhotoModalWindow(){
		return addPhotoModalWindow;
	}
	
	public WebElement get_profileName(){
		return profileName;
	}
	
	public WebElement get_affiliation(){
		return affiliation;
	}
	
	public WebElement get_address(){
		return streetAddress;
	}
	
	public WebElement get_addressLocality(){
		return addressLocality;
	}
	
	public WebElement get_addressRegion(){
		return addressRegion;
	}
	
	public WebElement get_postalCode(){
		return postalCode;
	}
	
	public WebElement get_website(){
		return website;
	}
	
	public WebElement get_about(){
		return about;
	}
	
	public WebElement get_phoneNumber(){
		return phoneNumber;
	}
	
	public WebElement get_reviewTab(){
		return reviewTab;
	}
	
	public WebElement get_reviewButtonOnProfilePage(){
		return reviewButtonOnProfilePage;
	}
	
	//meta data
	public WebElement get_metaName(){
		return metaName;
	}
	
	public WebElement get_metaDescription(){
		return metaDescription;
	}
	
	public WebElement get_metaImage(){
		return metaImage;
	}
	
	public WebElement get_metaOrgUrl(){
		return metaOrgUrl;
	}
	
	public WebElement get_metaOrgTitle(){
		return metaOrgTitle;
	}
	
	public WebElement get_metaOrgDescription(){
		return metaOrgDescription;
	}
	
	public WebElement get_metaOrgImage(){
		return metaOrgImage;
	}
	
	public WebElement get_metaOrgSiteName(){
		return metaOrgSiteName;
	}
	
	public WebElement get_metaOgType(){
		return metaOgType;
	}
	
	public WebElement get_metaOgPostalCode(){
		return metaOgPostalCode;
	}
	
	public WebElement get_metaOgLocality(){
		return metaOgLocality;
	}
	
	public WebElement get_metaOgRegion(){
		return metaOgRegion;
	}
	
	public WebElement get_metaFbAdmins(){
		return metaFbAdmins;
	}
	
	public WebElement get_metaFbAppId(){
		return metaFbAppId;
	}
	
	public WebElement get_metaCharSet(){
		return metaCharSet;
	}
	
//	public WebElement get_metaGoogle(){
//		return metaGoogle;
//	}
	
	public WebElement get_metaContentLanguage(){
		return metaContentLanguage;
	}
	
	public WebElement get_activeContinueButton(){
		return activeContinueButton;
	}
	
	public WebElement get_continueButton(){
		return continueButton;
	}
	
	public WebElement get_RatingCount(){
		return ratingCount;
	}
	
	public WebElement get_twitterLink(){
		return twitter;
	}
	
	public WebElement get_facebookLink(){
		return facebook;
	}
	
	public WebElement get_linkedInLink(){
		return linkedIn;
	}
	
	public WebElement get_googlePlusLink(){
		return googlePlus;
	}
	
	public WebElement get_firstReviewerProfilePic(){
		return firstReviewerProfilePic;
	}
	
	public WebElement get_firstReviewerProfileName(){
		return firstReviewerProfileName;
	}
	
	public WebElement get_firstReviewerProfileComment(){
		return firstReviewerProfileComment;
	}
	
	public WebElement get_firstReviewerProfileDate(){
		return firstReviewerProfileDate;
	}
	
	public WebElement get_jobTitleLink(){
		return jobTitleLink;
	}
	
	public WebElement get_compnayLink(){
		return compnayLink;
	}
	
	public WebElement get_licenseLink(){
		return licenseLink;
	}
	
	public WebElement get_addressLink(){
		return addressLink;
	}
	
	public WebElement get_locationLink(){
		return location;
	}
	
//	public WebElement get_cityLink(){
//		return driver.findElement(By.cssSelector(cityLink));
//	}
//	
//	public WebElement get_stateLink(){
//		return driver.findElement(By.cssSelector(stateLink));
//	}
//	
//	public WebElement get_zipCode(){
//		return zipCode;
//	}
//	
//	public WebElement get_emailUserLink(){
//		return driver.findElement(By.cssSelector(emailUserLink));
//	}

	public WebElement get_webSiteLink(){
		return webSiteLink;
	}
	
	public WebElement get_contactTab(){
		return contactTab;
	}
	
	public WebElement get_inLineReviewSection(){
		return inLineReviewSection;
	}
	
	public WebElement get_randomStarRating(int index){
		return driver.findElement(By.cssSelector(randomStarRating.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_reviewButton(){
		return reviewButton;
	}
	
	public WebElement get_textAreaForReview(){
		return textAreaForReview;
	}
	public WebElement get_submitReviewButton(){
		return submitReviewButton;
	}
	
	public WebElement get_verifyReviewSection(){
		return verifyReviewSection;
	}
	
	public WebElement get_facebookButton(){
		return facebookButton;
	}
	
	public WebElement get_savingReviewtext(){
		return savingReviewtext;
	}
	public WebElement get_thanksForReviewText(){
		return thanksForReviewText;
	}
	
	public int get_firstReviewerRatingCount(){
		return firstReviewerRatingCount.size();
	}
	
	public WebElement get_messageModal(){
		return messageModal;
	}
	public WebElement get_closeModalIcon(){
		return closeModalIcon;
	}
	public WebElement get_editPhoneNumberLink(){
		return editPhoneNumberLink;
	}
	
	public List<WebElement> get_reviewRows(){
		return reviewRows;
	}
	
	public WebElement get_featuredReviewModelWindow(){
		return featuredReviewModelWindow;
	}
	
	public List<WebElement> get_featuredReviews(){
		return featuredReviews;
	}
	
	public List<WebElement> get_ratingsForAllReviews(int index){
		return driver.findElements(By.xpath(ratingsForAllReviews.replaceAll("index", String.valueOf(index))));
	}
	
	public WebElement get_skipLink(){
		return skipLink;
	}
	
	public List<WebElement> get_topProfessionals(){
		return topProfessionals;
	}
	
	public WebElement get_featuredReviewsSectionText(){
		return featuredReviewsSectionText;
	}
	
	public WebElement get_editFeaturedReviewLink(){
		return editFeaturedReviewLink;
	}
	
	public WebElement get_viewAllReviewLink(){
		return viewAllReviewLink;
	}
	
	public List<WebElement> get_featuredReviewsInPopUp(){
		return featuredReviewsInPopUp;
	}
	
	public List<WebElement> get_textForfeaturedReviewsInPopUp(){
		return textForfeaturedReviewsInPopUp;
	}
	
	public List<WebElement> get_profileNameForFeaturedReviewsInPopUp(){
		return profileNameForFeaturedReviewsInPopUp;
	}
	
	public List<WebElement> get_totalReviewInPopUp(){
		return totalReviewsInPopUp;
	}
	
	public List<WebElement> get_textForTotalReviewInPopUp(){
		return textForTotalReviewsInPopup;
	}
	
	public WebElement get_reviewUpbuttonInPopUp(){
		return reviewUpButtonInPopUp;
	}
	
	public WebElement get_reviewDownButtonInPopUp(){
		return reviewDownButtonInPopUp;
	}
	
	public List<WebElement> get_featuredReviewCrossButton(){
		return featuredReviewCrossButton;
	}
	
	public WebElement get_popUpCross(){
		return popUpCross;
	}
	
	public WebElement get_profileUrlInputBox(){
		return profileUrlInputBox;
	}
	
	public WebElement get_coverImage(){
		return coverImage;
	}
	
	public WebElement get_noLink(){
		return noLink;
	}
	
//	public WebElement get_reviewCount(){
//		return reviewCount;
//	}
}