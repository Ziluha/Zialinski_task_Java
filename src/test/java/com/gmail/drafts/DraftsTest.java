package com.gmail.drafts;

import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.page.objects.Page;
import com.test.config.BaseTest;
import org.junit.*;

public class DraftsTest extends BaseTest{
    public DraftsTest(){
        super(Browsers.name.Chrome);
    }

    @Before
    public void setUpAuth(){
        Page.gmailLogin().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        Page.gmailLogin().submitLogin();
        Page.gmailPassword().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        Page.gmailPassword().submitPassword();
    }

    @Test
    public void addMessageToDrafts(){
        testCaseName = "Add Message To Drafts";
        test = extent.createTest(testCaseName);
        Page.gmailInbox().clickComposeButton();
        Page.gmailInbox().inputMessageSubject(PropertiesReading.getURLs().getProperty("gmailURL"));
        Assert.assertTrue("Saved Lable is not presented",
                Page.gmailInbox().isSavedLabelPresented());
        Page.gmailInbox().clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                Page.gmailDrafts().isDraftPageOpened());
        Assert.assertTrue("No message with this subject in drafts",
                Page.gmailDrafts().isDraftAdded(PropertiesReading.getURLs().getProperty("gmailURL")));
        test.pass("Message successfully added to drafts");
    }

    @Test
    public void deleteMessageFromDrafts(){
        testCaseName = "Delete Message From Drafts";
        test = extent.createTest(testCaseName);
        Page.gmailInbox().clickDraftsLink();
        Assert.assertTrue("Draft Page is not opened",
                Page.gmailDrafts().isDraftPageOpened());
        int countOfDraftsAtStart = Page.gmailDrafts().getCountOfDrafts();
        Page.gmailDrafts().chooseFirstDraft();
        Page.gmailDrafts().clickDiscardDraftButton();
        Assert.assertEquals("Count of drafts at start and afted discarding doesn't match",
                countOfDraftsAtStart-1, Page.gmailDrafts().getCountOfDrafts());
        test.pass("Message successfully deleted from drafts");
    }
}
