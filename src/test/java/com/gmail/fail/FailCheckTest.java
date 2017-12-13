package com.gmail.fail;

import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class FailCheckTest extends BaseTest {
    public FailCheckTest(){
        super(Browsers.name.Chrome);
    }

    @Test
    public void checkFail(){
        testCaseName = "Check Fail Test";
        test = extent.createTest(testCaseName);
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        Page.gmailLogin().submitLogin();
        Assert.assertTrue("Login was not applied",
                Page.gmailPassword().IsLoginApplied());
    }

}
