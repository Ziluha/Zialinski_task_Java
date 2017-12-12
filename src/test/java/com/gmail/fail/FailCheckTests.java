package com.gmail.fail;

import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class FailCheckTests extends BaseTest {
    public FailCheckTests(){
        super(Browsers.name.Chrome, "Fail Check Tests");
    }

    @Test
    public void checkFail(){
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        Page.gmailLogin().submitLogin();
        Assert.assertTrue("Login was not applied",
                Page.gmailPassword().IsLoginApplied());
    }

}
