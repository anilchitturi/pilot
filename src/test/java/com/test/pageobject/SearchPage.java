package com.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.util.driver.Util;
import com.test.util.testData.TestData;

public class SearchPage extends Util{
    private WebDriver driver;

    @FindBy(id="gbqfq")
    private WebElement searchText;
    @FindBy(id="gbqfb")
    private WebElement searchBtn;

   
    
    public SearchPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }
    
    public void performSearch(String searchkey){
    	searchText.clear();
    	searchText.sendKeys(searchkey);
    	searchText.submit();

    	
    }

    
}