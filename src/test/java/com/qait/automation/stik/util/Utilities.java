/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.stik.util;

/**
 *
 * @author QAIT
 */

import java.io.FileReader;
import java.io.Reader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

public class Utilities {
	
	
	static int initialcheck = 0;
    public String yamlFilePath = "";
    
    public Utilities(String yamlFilePath) {
    	this.yamlFilePath = yamlFilePath;
    }

    public String setYamlFilePath(String filePath) {
        yamlFilePath = filePath;
        return filePath;
    }
    

//    @SuppressWarnings({"unchecked"})
    public String getYamlValue(String yamlToken) {
        Reader reader = null;
        int tokenCount = 0, i = 0;
        Map map = null;

        StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
        try {
            reader = new FileReader(yamlFilePath);
            String val = null;
            Yaml yaml = new Yaml();
            map = (Map) yaml.load(reader);
            tokenCount = st.countTokens();
            for (i = 1; i < tokenCount; i++) {
                String token = st.nextToken();
                map = (Map) map.get(token);
            }
            val = map.get(st.nextToken()).toString();
            return val;
        } catch (Exception e) {
            System.out.println("Yaml file not found!!!\n" + e);
            return "";
        }
    }
    
	public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }

    }
	
	public static void explicitWait(WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}
	
	
	public static void dynamicWaitForLinkedinTC(WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
		
	}
	
	
	public static String currentDateInStringFormat(){
		Date d=new Date();
		String formattedDate="";
        try {

      	  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
      	  formattedDate = formatter.format(d);
      	  System.out.println("Date:-"+formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return formattedDate;
	}
	
	
}
