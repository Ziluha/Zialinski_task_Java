package com.zialinski.webdriver;

import com.enums.Browsers;
import com.wrapper.factory.BrowserFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
