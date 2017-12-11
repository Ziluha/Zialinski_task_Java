package com.page.objects;

import com.page.objects.gmail.authorization.GmailLoginPage;
import com.page.objects.gmail.authorization.GmailPasswordPage;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public static GmailLoginPage gmailLoginPage(){
        GmailLoginPage glp =  new GmailLoginPage();
        PageFactory.initElements(BrowserFactory.getDriver(), glp);
        return glp;
    }

    public static GmailPasswordPage gmailPasswordPage(){
        GmailPasswordPage gpp = new GmailPasswordPage();
        PageFactory.initElements(BrowserFactory.getDriver(), gpp);
        return gpp;
    }
}
