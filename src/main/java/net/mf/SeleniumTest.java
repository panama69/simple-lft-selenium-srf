package net.mf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.*;
import com.hpe.leanft.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import com.hpe.leanft.selenium.ByEach;
import java.util.HashMap;
import java.util.regex.Pattern;

public class SeleniumTest  {
    /**

     * Micro Focus StormRunner Functional Selenium Java upload example
     *
     * Example based on example found at https://admhelp.microfocus.com/srf/en/1.50/Content/upload-sel.htm

     */
    private static RemoteWebDriver driver;

    public SeleniumTest() {
    //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void configToSRF()throws MalformedURLException{

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        capabilities.setCapability("SRF_CLIENT_SECRET", System.getenv("SRF_CLIENT_SECRET"));

        capabilities.setCapability("name","My Uploaded Selenium Example");

        URL FTAAS_URL = new URL( System.getenv("SELENIUM_ADDRESS"));
        driver = new RemoteWebDriver(FTAAS_URL, capabilities);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws Exception {
        driver.get("http://www.google.com");// Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));// Enter something to search for
        element.sendKeys("StormRunner Functional");// Now submit the form. WebDriver will find the form for us from the element
        element.submit();

    }
}