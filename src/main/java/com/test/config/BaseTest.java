package com.test.config;

import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.wrapper.factory.BrowserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

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

    @BeforeEach
    public void initTest(){
        chooseDriverInstance(browserName);
        DriverConfig.loadApp(driver, "https://gmail.com");
    }

    @AfterEach
    public void endTest(){
        browserFactory.CloseAllDrivers();
    }
}
