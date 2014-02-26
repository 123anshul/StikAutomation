package com.qait.automation.stik.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class VisibilityOfElementLocated implements ExpectedCondition<Boolean> {
	    private By findCondition;
	    
	    public VisibilityOfElementLocated(By by) {
	            this.findCondition = by;
	    }

	    public Boolean apply(WebDriver driver) {
	            driver.findElement(this.findCondition);
	            return Boolean.valueOf(true);
	    }
}

