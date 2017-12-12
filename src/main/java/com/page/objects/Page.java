package com.page.objects;

import com.page.objects.gmail.authorization.GmailLoginPage;
import com.page.objects.gmail.authorization.GmailPasswordPage;
import com.page.objects.gmail.mail.GmailDraftsPage;
import com.page.objects.gmail.mail.GmailInboxPage;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Page {
    public static GmailLoginPage gmailLogin(){
        GmailLoginPage glp =  new GmailLoginPage();
        BrowserFactory.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(BrowserFactory.getDriver(), glp);
        return glp;
    }

    public static GmailPasswordPage gmailPassword(){
        GmailPasswordPage gpp = new GmailPasswordPage();
        BrowserFactory.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(BrowserFactory.getDriver(), gpp);
        return gpp;
    }

    public static GmailInboxPage gmailInbox(){
        GmailInboxPage gip = new GmailInboxPage();
        BrowserFactory.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(BrowserFactory.getDriver(), gip);
        return gip;
    }

    public static GmailDraftsPage gmailDrafts(){
        GmailDraftsPage gdp = new GmailDraftsPage();
        BrowserFactory.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(BrowserFactory.getDriver(), gdp);
        return gdp;
    }
}
