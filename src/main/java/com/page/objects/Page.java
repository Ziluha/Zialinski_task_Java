package com.page.objects;

import com.page.objects.gmail.authorization.GmailLoginPage;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public static GmailLoginPage gmailLogin(){
        GmailLoginPage glp =  new GmailLoginPage();
        PageFactory.initElements(BrowserFactory.getDriver(), glp);
        return glp;
    }
}
