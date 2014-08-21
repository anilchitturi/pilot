package com.test.util.driver.type;

import com.test.util.app.Properties;
import com.test.util.testData.TestData;
import com.thoughtworks.selenium.SeleniumException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Description: Factory class which will call driver constructors
 */
public class DriverFactory {
    static WebDriver driver = null;

    private DriverFactory(){}
    //To get the driver instance by browser passed from testng.xml
    public static WebDriver getWebDriverInstanceForBrowser(String browser) {
        if (browser.equals("firefox"))
            return firefox();

        if (browser.equals("chrome"))
            return chrome();

        if (browser.equals("ie"))
            return ie();

        return null;
    }
 
    private static WebDriver firefox() {

        try {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.safebrowsing.malware.enabled", false);
            driver = new org.openqa.selenium.firefox.FirefoxDriver(profile);
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Properties.ImplicitWait, TimeUnit.SECONDS);
            driver.get(TestData.URL);
        } catch (SeleniumException ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    //download chrome driver from http://chromedriver.storage.googleapis.com/index.html
    private static WebDriver chrome() {
        try {
            System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
            //We can set capabilities for chrome driver as
            //ChromeOptions options = new ChromeOptions();
            //Options.addArguments("window-size=800,600");
            //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            //WebDriver driver = new ChromeDriver(capabilities);
            driver = new ChromeDriver();
            driver.get(TestData.URL);
        } catch (SeleniumException ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    private static WebDriver ie() {
        try {
            //download ie driver from http://docs.seleniumhq.org/download/
            System.setProperty("webdriver.ie.driver","D://IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.get(TestData.URL);
        } catch (SeleniumException ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}
