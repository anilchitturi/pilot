package com.test.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.pageobject.SearchPage;
import com.test.util.app.Properties;
import com.test.util.driver.type.DriverFactory;
import com.test.util.testData.TestData;
import com.thoughtworks.selenium.SeleniumException;


public class SearchTest extends TestData {

    private static WebDriver driver;
    private static SearchPage searchPage;

    
    @BeforeClass
    public void startDriver() throws Exception{
    	try {
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Properties.ImplicitWait, TimeUnit.SECONDS);
            driver.get(TestData.URL);

        } catch (SeleniumException ex) {
            ex.printStackTrace();
        }
              System.out.println(driver.getTitle());
        if (null == driver) {
            //To-do : Implement exception handler
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
        {
            driver.quit();
        }
    }


    @Test(priority=1 ,groups = "Regression")
    public void searchTest() throws Exception {
    	 searchPage = PageFactory.initElements(driver,SearchPage.class);
    	 // And now use this to visit Google

        // Find the text input element by its name
        // Enter something to search for
    	 searchPage.performSearch(TestData.keyword);

        // Now submit the form. WebDriver will find the form for us from the element
       // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());  
    }
    
    @Test(priority=2 ,groups = {"Sanity","Regression"})
    public void searchTest2() throws Exception {
    	 searchPage = PageFactory.initElements(driver,SearchPage.class);
    	 // And now use this to visit Google

        // Find the text input element by its name
        // Enter something to search for
    	 searchPage.performSearch(TestData.books);

        // Now submit the form. WebDriver will find the form for us from the element
       // Check the title of the page
    }

}
