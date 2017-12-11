package com.gmail.authorization;

import com.enums.Browsers;
import com.files.properties.*;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.Properties;

public class AuthorizationTests extends BaseTest {
    public AuthorizationTests(){
        super(Browsers.name.Chrome);
    }
    @Test
    public void authWithValidData(){
        Page.gmailLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLoginPage().submitLogin();
        Page.gmailPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        Page.gmailPasswordPage().submitPassword();
    }
}
