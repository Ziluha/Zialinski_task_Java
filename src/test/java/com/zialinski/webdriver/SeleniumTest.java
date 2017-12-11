package com.zialinski.webdriver;

import com.enums.Browsers;
import com.wrapperfactory.BrowserFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    @Test
    public void test(){
        BrowserFactory bf = BrowserFactory.getInstance();
        bf.initBrowser(Browsers.name.Chrome);
        BrowserFactory.getDriver().navigate().to("https://gmail.com");
        Assert.assertTrue(BrowserFactory.getDriver().findElement(By.id("identifierNext")).isDisplayed());
        bf.CloseAllDrivers();
    }

}
