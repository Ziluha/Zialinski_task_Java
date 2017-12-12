package com.test.config;

import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.reports.extent.settings.BaseReport;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.junit.*;

public class BaseTest extends BaseReport {
    protected WebDriver driver;
    private Browsers.name browserName;
    private BrowserFactory browserFactory;
    protected static String testSuiteName;

    public BaseTest(Browsers.name browserName, String testSuiteName){
        this.browserName = browserName;
        browserFactory = BrowserFactory.getInstance();
    }

    public void chooseDriverInstance(Browsers.name browserName){
        switch (browserName){
            case Firefox:
                driver = browserFactory.initBrowser(Browsers.name.Firefox);
                break;
            case Chrome:
                driver = browserFactory.initBrowser(Browsers.name.Chrome);
                break;
        }
    }

    @BeforeClass
    public static void initReport(){
        startReport(testSuiteName);
    }

    @Before
    public void initTest(){
        test = null;
        chooseDriverInstance(browserName);
        DriverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
    }

    @After
    public void endTest(){
        getResult();
        browserFactory.CloseAllDrivers();
    }

    @AfterClass
    public static void endReport(){
        stopReport();
    }

}
