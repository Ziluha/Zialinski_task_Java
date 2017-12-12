package com.gmail.authorization;

import com.enums.Browsers;
import com.files.properties.*;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.*;

public class

AuthorizationTests extends BaseTest {
    public AuthorizationTests(){
        super(Browsers.name.Chrome);
    }
    @Test
    public void authWithValidData(){
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLogin().submitLogin();
        Page.gmailPassword().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        Page.gmailPassword().submitPassword();
        Assert.assertTrue("User was not logged in",
                Page.gmailInbox().isLoginSucceed());
    }

    @Test
    public void authWithInvalidLogin(){
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        Page.gmailLogin().submitLogin();
        Assert.assertTrue("Login Error Lable is not presented",
                Page.gmailLogin().isLoginErrorLabelPresented());
    }

    @Test
    public void authWithInvalidPassword(){
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLogin().submitLogin();
        Page.gmailPassword().inputPassword(PropertiesReading.getCredentials().getProperty("invalidPassword"));
        Page.gmailPassword().submitPassword();
        Assert.assertTrue("Password Error Lable is not presented",
                Page.gmailPassword().isPasswordErrorLabelPresented());
    }
}
