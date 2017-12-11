package com.gmail.authorization;

import com.enums.Browsers;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.jupiter.api.*;

public class AuthorizationTests extends BaseTest {
    public AuthorizationTests(){
        super(Browsers.name.Chrome);
    }
    @Test
    public void authWithValidData(){
        Page.gmailLoginPage().inputLogin("test.task.zel");
        Page.gmailLoginPage().submitLogin();
        Page.gmailPasswordPage().inputPassword("Test1234Test");
        Page.gmailPasswordPage().submitPassword();
    }
}
