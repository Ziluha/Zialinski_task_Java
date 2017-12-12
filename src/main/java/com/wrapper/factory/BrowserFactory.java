package com.wrapper.factory;

import com.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class BrowserFactory {
    private HashMap<Browsers.name, WebDriver> drivers = new HashMap<Browsers.name, WebDriver>();
    private static BrowserFactory instance;
    private static WebDriver driver;

    private BrowserFactory(){}

    public static BrowserFactory getInstance(){
        if(instance == null)
            instance = new BrowserFactory();
        return instance;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public WebDriver initBrowser(Browsers.name browser){
        switch (browser){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                if(!drivers.containsKey(Browsers.name.Chrome))
                    drivers.put(Browsers.name.Chrome, driver);
                return driver;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "D:\\FirefoxDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                if(!drivers.containsKey(Browsers.name.Firefox))
                    drivers.put(Browsers.name.Firefox, driver);
                return driver;
        }
        return driver;
    }

    public void CloseAllDrivers(){
        for (Browsers.name key:drivers.keySet())
            drivers.get(key).quit();
        drivers.clear();
    }
}
