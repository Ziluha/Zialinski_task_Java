package com.gmail.authorization;

import com.enums.Browsers;
import com.files.properties.*;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.*;

public class AuthorizationTest extends BaseTest {

    public AuthorizationTest(){
        super(Browsers.name.Chrome);
    }
    @Test
    public void authWithValidData(){
        testCaseName = "Authorization With Valid Data";
        test = extent.createTest(testCaseName);
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLogin().submitLogin();
        Page.gmailPassword().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        Page.gmailPassword().submitPassword();
        Assert.assertTrue("User was not logged in",
                Page.gmailInbox().isLoginSucceed());
        test.pass("User successfully authorized");
    }

    @Test
    public void authWithInvalidLogin(){
        testCaseName = "Authorization With Invalid Login";
        test = extent.createTest(testCaseName);
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        Page.gmailLogin().submitLogin();
        Assert.assertTrue("Login Error Lable is not presented",
                Page.gmailLogin().isLoginErrorLabelPresented());
        test.pass("User is not authorized with invalid login");
    }

    @Test
    public void authWithInvalidPassword(){
        testCaseName = "Authorization With Invalid Password";
        test = extent.createTest(testCaseName);
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLogin().submitLogin();
        Page.gmailPassword().inputPassword(PropertiesReading.getCredentials().getProperty("invalidPassword"));
        Page.gmailPassword().submitPassword();
        Assert.assertTrue("Password Error Lable is not presented",
                Page.gmailPassword().isPasswordErrorLabelPresented());
        test.pass("User is not authorized with invalid password");
    }
}
