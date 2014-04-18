package com.qait.automation.stik.pageobjects;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.automation.stik.actionfixtures.BaseFixture;
import com.qait.automation.stik.util.SizzleSelector;
import com.qait.automation.stik.util.StringMatcher;
import com.qait.automation.stik.util.Utilities;
import com.qait.automation.stik.util.VisibilityOfElementLocated;
import com.qait.automation.stik.util.VisibilityOfText;

/**
 * <b>Class: BaseUi</b>
 * <p>
 * BaseUi Contains common methods which are used in UI classes.
 * 
 * @author      QAIT
 * @see			#CreateTopicPageUi
 * @see			#LoginPageUi
 * @see			#TopicsOverviewPageUi
 */
public class BaseUi {

	WebDriver driver;
	SizzleSelector sizzle;
	private int waitTime = 200;
	JavascriptExecutor executor;
	Wait wait;
	//int AJAX_WAIT = 100;
	

	protected static HashMap<String, String> setting;

	public BaseUi(WebDriver driver, SizzleSelector sizzle) {
		PageFactory.initElements(driver, this);
		ElementLocatorFactory finder =  new AjaxElementLocatorFactory(driver, BaseFixture.AJAX_WAIT);
		this.driver = driver;
		this.sizzle = sizzle;
		executor = (JavascriptExecutor) driver;
	}

	public void changeWindow(int i) {
		Set<String> windows = driver.getWindowHandles();
		if(i>0){
			for(int j=0; j<5; j++){
				System.out.println("Windows: " + windows.size());
				if(windows.size()>=2) {
					Utilities.hardWait(5);
					break;
				}
				Utilities.hardWait(5);
				windows = driver.getWindowHandles();
			}
		}
		String wins[] = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(wins[i]);
		System.out.println("Title: "+driver.switchTo().window(wins[i]).getTitle());
	}

	public boolean verifyPageTitle(String pageTitle) {
		System.out.println("Page Title : " + driver.getTitle());
		Utilities.hardWait(5);
		return StringMatcher.match(driver.getTitle(), pageTitle, false);
	}

	public void handleAlert() {
		try {
			switchToAlert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("Alert Not Present...");
		}
	}

	private Alert switchToAlert() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void handleAlertafterClickingImport(){
		try{
			switchToAlertEmail().accept();
			driver.switchTo().defaultContent();
		}
		catch(Exception e){
			System.out.println("Email import summary alert not present..");
		}
	}
	
	public Alert switchToAlertEmail(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void printOutputOnConsole(String str) {
		System.out.println("\n");
		System.out.println(str);
		System.out.println("\n");
	}

	public void performClickFromAction(WebElement element) {
		Actions builder = new Actions(driver);
		Action click = builder.doubleClick(element).build();
		click.perform();
	}


	public boolean mouseMove(WebElement ele1, WebElement ele2) {
		Actions builder = new Actions(driver);
		Actions hoverOverRegistrar = builder.moveToElement(ele1);
		hoverOverRegistrar.build().perform();
		hoverOverRegistrar.click();
		ele2.click();
		return true;
	}

	public void executeJavaScript(String javaScript) {
		Utilities.hardWait(3);
		executor.executeScript(javaScript);
	}
	
	@SuppressWarnings("unused")
	public boolean waitForElementToAppear(WebElement element) {
	//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis() + waitTime;
		int elementDisplayed = 0;
		while (System.currentTimeMillis() < endTime) {
			elementDisplayed++;
			try {
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(BaseFixture.AJAX_WAIT, TimeUnit.SECONDS);
					return true;
				}
			} catch (Exception e) {
				Utilities.hardWait(1);
			}
		}// end while
		driver.manage().timeouts().implicitlyWait(BaseFixture.AJAX_WAIT, TimeUnit.SECONDS);
		return false;
	}
	
	public void waitForTextToAppear(String locator_Type,String locator, String text){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(new VisibilityOfText(driver, locator_Type, locator, text));
	}
	
	public void waitFor(By locator){
		wait = new WebDriverWait(driver, BaseFixture.AJAX_WAIT);
        wait.until(new VisibilityOfElementLocated(locator));
    }
}

