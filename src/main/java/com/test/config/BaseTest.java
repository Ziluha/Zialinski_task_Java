package com.test.config;

import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.junit.*;

public class BaseTest {
    protected WebDriver driver;
    private Browsers.name browserName;
    private BrowserFactory browserFactory;

    public BaseTest(Browsers.name browserName){
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

    @Before
    public void initTest(){
        chooseDriverInstance(browserName);
        DriverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
    }

    @After
    public void endTest(){
        browserFactory.CloseAllDrivers();
    }
}
