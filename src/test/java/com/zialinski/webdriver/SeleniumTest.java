package com.zialinski.webdriver;

import com.enums.Browsers;
import com.page.objects.Page;
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
        Page.gmailLogin().inputLogin("test.ta2sk.zel");
        Page.gmailLogin().submitLogin();
        Assert.assertTrue(Page.gmailLogin().isErrorLabelPresented());
        bf.CloseAllDrivers();
    }

}
