package com.qait.automation.stik.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class VisibilityOfText implements ExpectedCondition<Boolean> {
	private String locator;
	private WebDriver driver;
	private String locatorType;
	private String matchingString;

	public VisibilityOfText(WebDriver driver, String locator_Type,String locator, String matchingString){
			this.matchingString = matchingString;
			this.locatorType = locator_Type;
			this.locator = locator;
	        this.driver = driver;
	}

	public Boolean apply(WebDriver driver) {
		String text = findElement(driver,locatorType, locator);
		return Boolean.valueOf(text.toLowerCase().contains(matchingString.toLowerCase()));
	}

	public static String findElement(WebDriver driver, String locIdentifier, String locator) {
		if(locIdentifier.equalsIgnoreCase("xpath")){
			String temp = driver.findElement(By.xpath(locator)).getText();
			return temp;
		}
		if(locIdentifier.equalsIgnoreCase("css")){
			if(driver.findElement(By.cssSelector(locator)).isDisplayed()){
				String temp = driver.findElement(By.cssSelector(locator)).getText();
				return temp;
			}
		}
		return "";
	}
}
